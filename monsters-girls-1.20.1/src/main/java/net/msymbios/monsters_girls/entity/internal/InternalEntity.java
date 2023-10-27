package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.msymbios.monsters_girls.entity.enums.*;
import org.jetbrains.annotations.Nullable;

import static net.msymbios.monsters_girls.entity.internal.Utility.invertBoolean;

public abstract class InternalEntity extends TameableEntity {

    // -- Variables --
    protected static final TrackedData<String> VARIANT = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.STRING);
    protected static final TrackedData<Integer> TEXTURE_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> MODEL_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> STATE = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Boolean> LOG = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> BELLY = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> PLANT = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> SOUND = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected int waryTimer = 0, autoHealTimer = 0;
    protected boolean combatMode = false, autoHeal = false, canPlant = true, hasEffects = false;
    protected EntityCategory category;
    protected EntityVariant variant;

    // -- Properties --

    // VARIANT
    public String getVariant() {
        String value = variant.getName();
        try {value = this.dataTracker.get(VARIANT);}
        catch (Exception ignored) {}
        return value;
    } // getVariant ()

    public void setVariant(String value) {
        this.dataTracker.set(VARIANT, value);
    } // setVariant ()

    // ANIMATOR
    public Identifier getAnimatorByID(int value) { return InternalMetric.getAnimator(category, variant, EntityAnimator.byId(value)); } // getAnimatorByID ()

    public Identifier getAnimator() { return InternalMetric.getAnimator(category, variant); } // getAnimator ()

    // MODEL
    public Identifier getCurrentModelByID(int value) { return InternalMetric.getModel(category, variant, EntityModel.byId(value)); } // getCurrentModelByID ()

    public Identifier getCurrentModel() { return InternalMetric.getModel(category, variant); } // getCurrentModel ()

    public int getModelID() {
        int value = 0;
        try {value = this.dataTracker.get(MODEL_ID);}
        catch (Exception ignored) {}
        return value;
    } // getModelID ()

    public EntityModel getModel() {
        int value = 0;
        try {value = this.dataTracker.get(MODEL_ID);}
        catch (Exception ignored) {}
        return EntityModel.byId(value);
    } // getModel ()

    public void setModel(EntityModel value) { setModel(value.getId()); } // setModel ()

    public void setModel(int value) { this.dataTracker.set(MODEL_ID, value); } // setModel ()

    // TEXTURE
    public Identifier getTextureByID(int value) { return InternalMetric.getTexture(variant, EntityTexture.byId(value)); } // getTextureByID ()

    public Identifier getTexture() { return InternalMetric.getTexture(variant, EntityTexture.byId(getTextureID())); } // getTexture ()

    public Identifier getCurrentTexture() {
        Identifier defaultTexture = InternalMetric.TEXTURE.get(this.variant).get(EntityTexture.DEFAULT);
        if(InternalMetric.checkTextureID(this.variant, EntityTexture.byId(getTextureID())))
            defaultTexture = InternalMetric.TEXTURE.get(this.variant).get(EntityTexture.byId(getTextureID()));
        return defaultTexture;
    } // getCurrentTexture ()

    public int getTextureID() {
        int value = EntityTexture.DEFAULT.getId();
        try {value = this.dataTracker.get(TEXTURE_ID);}
        catch (Exception ignored) {}
        return value;
    } // getTextureID ()

    public void setTexture(int value) { if(InternalMetric.checkTextureID(this.variant, EntityTexture.byId(value))) this.dataTracker.set(TEXTURE_ID, value); } // setTexture ()

    public void setTexture(EntityTexture value) {
        setTexture(value.getId());
    } // setTexture ()

    // STATE
    public int getCurrentStateID() {
        int value = EntityState.Sit.getId();
        try {value = this.dataTracker.get(STATE);}
        catch (Exception ignored) {}
        return value;
    } // getCurrentStateID ()

    public EntityState getCurrentState() {
        EntityState value = EntityState.Sit;
        try {value = EntityState.byId(this.dataTracker.get(STATE));}
        catch (Exception ignored) {}
        return value;
    } // getCurrentState ()

    public void setCurrentState(EntityState value){ this.dataTracker.set(STATE, value.getId()); } // setCurrentMode ()

    public void setCurrentState(int value){ this.dataTracker.set(STATE, value); } // setCurrentState ()

    // STATS
    public float getAttributeRaw(EntityAttribute attribute) { return InternalMetric.getAttribute(variant, attribute); } // getAttributeRaw ()

    public int getAttribute(EntityAttribute attribute) { return (int) getAttributeRaw(attribute); } // getAttribute ()

    public int getHpValue() { return getAttribute(EntityAttribute.MAX_HEALTH); } // getHpValue ()

    public int getAttackValue() { return getAttribute(EntityAttribute.ATTACK_DAMAGE); } // getAttackValue ()

    public int getDefenseValue() { return getAttribute(EntityAttribute.DEFENSE); } // getDefenseValue ()

    public double getArmorValue () {
        int armor = this.getDefenseValue();
        if (armor > 30) armor = 30;
        return armor;
    } // getArmorValue ()

    public double getArmorToughnessValue () {
        double armor = getArmorValue();
        double armor_tou = 0;
        if (armor > 30) armor_tou = armor - 30;
        return armor_tou;
    } // getArmorToughnessValue ()

    // LOG
    public boolean getLog() {
        boolean value = true;
        try {value = this.dataTracker.get(LOG);}
        catch (Exception ignored) {}
        return value;
    } // getLog ()

    public void setLog(boolean value) { this.dataTracker.set(LOG, value); } // setLog ()

    // BELLY
    public boolean getBelly() {
        boolean value = true;
        try {value = this.dataTracker.get(BELLY);}
        catch (Exception ignored) {}
        return value;
    } // getBelly ()

    public void setBelly(boolean value) { this.dataTracker.set(BELLY, value); } // setBelly ()

    // PLANT
    public boolean getPlant() {
        boolean value = true;
        try {value = this.dataTracker.get(PLANT);}
        catch (Exception ignored) {}
        return value;
    } // getPlant ()

    public void setPlant(boolean value) { this.dataTracker.set(PLANT, value); } // setPlant ()

    // SOUND
    public boolean getSound() {
        boolean value = true;
        try {value = this.dataTracker.get(SOUND);}
        catch (Exception ignored) {}
        return value;
    } // getSound ()

    public void setSound(boolean value) { this.dataTracker.set(SOUND, value); } // setSound ()

    // -- Constructor --
    protected InternalEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    } // Constructor InternalEntity ()

    // -- Inherited Method --
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    } // createChild ()

    // -- Built-In Method --
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setTexture(InternalMetric.getRandomTextureID(this.variant));
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    } // initialize

    @Override
    public void tick() {
        super.tick();
        if(canPlant && getPlant() && this.isTamed()) handlePlanting(getWorld(), this.getX(), this.getY(), this.getZ(), this);
        handleCombatMode();
        handleAutoHeal();
    } // tick ()

    @Override
    public void onAttacking(Entity target) {
        handleActivateCombatMode();
        this.getWorld().sendEntityStatus(this, (byte)4);
        super.onAttacking(target);
    } // onAttacking ()

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        if (hasEffects) handleNegativeEffect(this, source.getSource());
        handleActivateCombatMode();
        return super.damage(source, amount);
    } // damage ()

    // -- Interact Methods --
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        var itemStack = player.getStackInHand(hand);
        if(hand == Hand.MAIN_HAND) {
            if(getOwner() != null) handleSit(itemStack);
            if(this.getWorld().isClient) {
                boolean bl = this.isOwner(player) || this.isTamed() || itemStack.isOf(Items.COOKIE) && !this.isTamed();
                return bl ? ActionResult.CONSUME : ActionResult.PASS;
            } else {
                if(getOwner() == null) handleTame(itemStack, player);

                if(getOwner() != null) {
                    if (hasEffects) handleEffect(this, player, itemStack);
                    handleState(itemStack, player);
                    handleTexture(itemStack, player);

                    if(itemStack.isOf(Items.OAK_BUTTON)) {
                        this.setLog(invertBoolean(getLog()));
                        if(getLog()) commandDebug("Log: ON", true);
                        else commandDebug("Log: OFF", true);
                    }

                    if(itemStack.isOf(Items.NOTE_BLOCK)) {
                        this.setSound(invertBoolean(getSound()));
                        if(getSound()) commandDebug("Sound: ON", true);
                        else commandDebug("Sound: OFF", true);
                    }

                    if(this.canPlant && itemStack.isOf(Items.WOODEN_HOE)) {
                        this.setPlant(invertBoolean(getPlant()));
                        if(getPlant()) commandDebug("Plant: ON", true);
                        else commandDebug("Plant: OFF", true);
                    }

                    return ActionResult.SUCCESS;
                }
            }
        }

        return super.interactMob(player, hand);
    } // interactMob ()

    // -- Sound
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return InternalMetric.getSound(this.variant, EntitySound.HURT);
    } // getHurtSound ()

    @Override
    protected SoundEvent getDeathSound() {
        return InternalMetric.getSound(this.variant, EntitySound.DEATH);
    } // getDeathSound ()

    @Override
    protected SoundEvent getAmbientSound() {
        if(getSound()) return InternalMetric.getSound(this.variant, EntitySound.DEFAULT);
        else return null;
    } // getAmbientSound ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TEXTURE_ID, EntityTexture.DEFAULT.getId());
        this.dataTracker.startTracking(STATE, EntityState.Move.getId());
        this.dataTracker.startTracking(LOG, false);
        this.dataTracker.startTracking(PLANT, true);
        this.dataTracker.startTracking(SOUND, true);
    } // initDataTracker ()

    public void writeCustomDataToNbt(NbtCompound dataNBT) {
        super.writeCustomDataToNbt(dataNBT);
        dataNBT.putString("Variant", this.getVariant());
        dataNBT.putInt("TextureID", this.getTextureID());
        dataNBT.putInt("ModelID", this.getModelID());
        dataNBT.putInt("State", this.getCurrentStateID());
        dataNBT.putBoolean("Log", getLog());
        dataNBT.putBoolean("Belly", getBelly());
        dataNBT.putBoolean("Plant", getPlant());
        dataNBT.putBoolean("Sound", getSound());
    } // writeCustomDataToNbt ()

    public void readCustomDataFromNbt(NbtCompound dataNBT) {
        super.readCustomDataFromNbt(dataNBT);
        this.setVariant(dataNBT.getString("Variant"));
        this.setTexture(dataNBT.getInt("TextureID"));
        this.setModel(dataNBT.getInt("ModelID"));
        this.setCurrentState(dataNBT.getInt("State"));
        this.setLog(dataNBT.getBoolean("Log"));
        this.setBelly(dataNBT.getBoolean("Belly"));
        this.setPlant(dataNBT.getBoolean("Plant"));
        this.setSound(dataNBT.getBoolean("Sound"));
    } // readCustomDataFromNbt ()

    // -- Custom Method --
    public boolean canInteract(ItemStack itemStack){
        if(itemStack.isOf(Items.FEATHER) || itemStack.isOf(Items.APPLE) || itemStack.isOf(Items.COOKIE) || itemStack.isOf(Items.NOTE_BLOCK) || itemStack.isOf(Items.WOODEN_HOE)) return false;
        if(itemStack.isOf(Items.BOOK) || itemStack.isOf(Items.WRITABLE_BOOK) || itemStack.isOf(Items.OAK_BUTTON)) return false;
        return true;
    } // canInteract ()

    protected void handlePlanting (WorldAccess world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        if (entity.isOnGround()) {
            BlockPos blockPos = new BlockPos((int)x, (int)y, (int)z);
            if (world.isSpaceEmpty(new Box(blockPos))) {
                var standingBlock = (world.getBlockState(new BlockPos((int)x, (int)y - 1, (int)z))).getBlock();
                var blockToPlant = InternalMetric.PLANTING.get(variant);
                var canPlantBlock = false;

                if(!blockToPlant.canPlantOn.isEmpty()) {
                    for (var item : blockToPlant.canPlantOn) {
                        if (standingBlock == item) {
                            canPlantBlock = true;
                            break;
                        }
                    }
                } else canPlantBlock = true;

                if (canPlantBlock) {
                    for (var item : blockToPlant.toBePlant) {
                        if (Math.random() < item.condition)
                            world.setBlockState(blockPos, item.block.getDefaultState(), 3);
                    }
                }
            }
        }
    } // handlePlanting ()

    protected void handleNegativeEffect(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null) return;
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient()) {
            var listOfEffects = InternalMetric.HARMFUL_EFFECTS.get(variant);
            for (var effect : listOfEffects) _entity.addStatusEffect(new StatusEffectInstance((StatusEffect) effect.get(0).getValue(), (int)effect.get(1).getValue(), (int)effect.get(2).getValue()));
        }
    } // handleNegativeEffect ()

    protected void handleEffect(Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null) return;
        if (entity instanceof TameableEntity _tamEnt && _tamEnt.isTamed()) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient()) {
                var listOfEffects = InternalMetric.HELPFUL_EFFECTS.get(variant);
                for (var effect : listOfEffects) {
                    if (itemstack.isOf((Item)effect.get(0).getValue()))
                        _entity.addStatusEffect(new StatusEffectInstance((StatusEffect) effect.get(1).getValue(), (int) effect.get(2).getValue(), (int) effect.get(3).getValue()));
                }
                if (!(sourceentity instanceof PlayerEntity player && player.getAbilities().creativeMode)) itemstack.decrement(1);
            }
        }
    } // handleEffect ()

    protected void handleAutoHeal () {
        if(this.getHealth() < this.getHpValue()) autoHeal = true;
        if(this.getWorld().isClient && !autoHeal && !InternalMetric.GlobalAutoHeal) return;

        if(autoHealTimer != 0) {
            autoHealTimer--;
        } else {
            final float healValue = this.getHpValue() / 16.0F;
            this.heal(healValue);
            autoHeal = false;
            autoHealTimer = InternalMetric.AutoHealInterval;
        }
    } // handleAutoHeal ()

    protected void handleActivateCombatMode () {
        if(!combatMode) combatMode = true;
        waryTimer = InternalMetric.WaryTime;
    } // handleActivateCombatMode ()

    protected void handleCombatMode() {
        if(this.isAttacking()) handleActivateCombatMode();
        if(this.getWorld().isClient && !combatMode) return;

        if(waryTimer != 0) {
            // Do something!! She's Cautious...
            // if(getModel() != EntityModel.Armed) setModel(EntityModel.Armed);
            waryTimer--;
        } else {
            // She´s no longer cautious, want to do something...
            if(getModel() != EntityModel.Mushroom) setModel(EntityModel.Mushroom);
            combatMode = false;
        }
    } // handleCombatMode ()

    public void handleTame(ItemStack stack, PlayerEntity player) {
        boolean canAttemptTame = false;
        var listOfItems = InternalMetric.ENTITY_TAMABLE_ITEM.get(variant);
        for (Item item : listOfItems) canAttemptTame = stack.isOf(item);

        if(canAttemptTame) {
            if (this.random.nextInt(5) == 0) {
                this.setOwner(player);
                this.navigation.stop();
                this.setTarget(null);

                InternalParticles.Heart(this);
                this.getWorld().sendEntityStatus(this, (byte) 7);
            } else {
                InternalParticles.Ash(this);
                this.getWorld().sendEntityStatus(this, (byte) 6);
            }
            if (!player.getAbilities().creativeMode) stack.decrement(1);
        }
    } // handleTame ()

    public void handleSit(ItemStack itemStack) {
        if(!canInteract(itemStack)) return;
        setSitting(invertBoolean(isSitting()));
    } // handleSit ()

    public void handleTexture(ItemStack items, PlayerEntity player) {
        var oldTexture = getTextureID();
        if(items.isOf(Items.FEATHER)) {
            int bellyLevel = this.getTextureID();
            if(bellyLevel > 0 && bellyLevel <= 3){
                bellyLevel = bellyLevel - 1;
                setTexture(EntityTexture.byId(bellyLevel));
            }
        }

        if(items.isOf(Items.APPLE)) {
            int bellyLevel = this.getTextureID();
            if(bellyLevel >= 0 && bellyLevel < 3){
                bellyLevel = bellyLevel + 1;
                setTexture(EntityTexture.byId(bellyLevel));
            }
        }

        if(oldTexture != getTextureID()) {
            if (!player.getAbilities().creativeMode)
                items.decrement(1);
        }
    } // handleTexture ()

    public void handleState(ItemStack itemStack, PlayerEntity player) {
        RestState(itemStack);
        FollowState(itemStack);
    } // handleState

    public void RestState(ItemStack itemStack){
        if(!canInteract(itemStack)) return;
        if(isSitting()) setCurrentState(EntityState.Sit);
    } // RestState ()

    public void FollowState(ItemStack itemStack){
        if(!canInteract(itemStack)) return;
        if(!isSitting()) setCurrentState(EntityState.Move);
    } // FollowState ()

    // -- Debug
    public void commandDebug(String message, boolean overlay) {
        if(this.getOwner() != null) {
            PlayerEntity player = (PlayerEntity)this.getOwner();
            player.sendMessage(Text.literal(message), overlay);
        }
    } // commandDebug ()

} // Class InternalEntity