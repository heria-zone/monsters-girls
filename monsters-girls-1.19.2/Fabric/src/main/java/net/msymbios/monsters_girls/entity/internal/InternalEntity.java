package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.enums.*;

import static net.msymbios.monsters_girls.entity.internal.Utility.invertBoolean;

public abstract class InternalEntity extends TameableEntity {

    // -- Variables --
    protected static final TrackedData<String> VARIANT = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.STRING);
    protected static final TrackedData<Integer> TEXTURE_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> MODEL_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> STATE = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected static final TrackedData<Boolean> LOG = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> BELLY = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected int waryTimer = 0, autoHealTimer = 0;
    protected boolean combatMode = false, autoHeal = false;

    // -- Properties --

    // VARIANT
    public abstract String getVariant();

    public String getVariant(String value) {
        try {value = this.dataTracker.get(VARIANT);}
        catch (Exception ignored) {}
        return value;
    } // getVariant ()

    public void setVariant(String value) {
        this.dataTracker.set(VARIANT, value);
    } // setVariant ()

    // TEXTURE
    public abstract Identifier getTextureByID(int value);

    public Identifier getTexture() { return getTextureByID(getTextureID()); } // getTexture ()

    public int getTextureID() {
        int value = 0;
        try {value = this.dataTracker.get(TEXTURE_ID);}
        catch (Exception ignored) {}
        return value;
    } // getTextureID ()

    public void setTexture(EntityTexture value) {
        setTexture(value.getId());
    } // setTexture ()

    public void setTexture(int value) { this.dataTracker.set(TEXTURE_ID, value); } // setTexture ()

    // MODEL
    public abstract Identifier getCurrentModelByID(int value);

    public Identifier getCurrentModel() { return getCurrentModelByID(getModelID()); } // getCurrentModel ()

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

    // ANIMATOR
    public abstract Identifier getAnimatorByID(int value);

    public Identifier getAnimator() { return getAnimatorByID(getAnimatorID()); } // getAnimator ()

    public int getAnimatorID() {
        int value = 0;
        try {value = this.dataTracker.get(MODEL_ID);}
        catch (Exception ignored) {}
        return value;
    } // getAnimatorID ()

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
    public abstract float getAttributeRaw(EntityAttribute attribute);

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
    @Override
    public void tick() {
        super.tick();
        handleCombatMode();
        handleAutoHeal();
        commandDebugExtra();
    } // tick ()

    @Override
    public void onAttacking(Entity target) {
        handleActivateCombatMode();
        this.world.sendEntityStatus(this, (byte)4);
        super.onAttacking(target);
    } // onAttacking ()

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        handleActivateCombatMode();
        return super.damage(source, amount);
    } // damage ()

    // -- Interact Methods --
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        var itemStack = player.getStackInHand(hand);
        if(hand == Hand.MAIN_HAND) {
            if(getOwner() != null) handleSit(itemStack);
            if(this.world.isClient) {
                boolean bl = this.isOwner(player) || this.isTamed() || itemStack.isOf(Items.COOKIE) && !this.isTamed();
                return bl ? ActionResult.CONSUME : ActionResult.PASS;
            } else {
                if(getOwner() == null) handleTame(itemStack, player);

                if(getOwner() != null) {
                    handleState(itemStack, player);
                    handleTexture(itemStack, player);

                    if(itemStack.isOf(Items.OAK_BUTTON)) {
                        this.setLog(invertBoolean(getLog()));
                        if(getLog()) commandDebug("Log ON", true);
                        else commandDebug("Log OFF", true);
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
        return SoundEvents.ENTITY_GENERIC_HURT;
    } // getHurtSound ()

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GENERIC_DEATH;
    } // getDeathSound ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TEXTURE_ID, EntityTexture.DEFAULT.getId());
        this.dataTracker.startTracking(STATE, EntityState.Move.getId());
        this.dataTracker.startTracking(LOG, true);
    } // initDataTracker ()

    public void writeCustomDataToNbt(NbtCompound dataNBT) {
        super.writeCustomDataToNbt(dataNBT);
        dataNBT.putString("Variant", this.getVariant());
        dataNBT.putInt("TextureID", this.getTextureID());
        dataNBT.putInt("ModelID", this.getModelID());
        dataNBT.putInt("State", this.getCurrentStateID());
        dataNBT.putBoolean("Log", getLog());
        dataNBT.putBoolean("Belly", getBelly());
    } // writeCustomDataToNbt ()

    public void readCustomDataFromNbt(NbtCompound dataNBT) {
        super.readCustomDataFromNbt(dataNBT);
        this.setVariant(dataNBT.getString("Variant"));
        this.setTexture(dataNBT.getInt("TextureID"));
        this.setModel(dataNBT.getInt("ModelID"));
        this.setCurrentState(dataNBT.getInt("State"));
        this.setLog(dataNBT.getBoolean("Log"));
        this.setBelly(dataNBT.getBoolean("Belly"));
    } // readCustomDataFromNbt ()

    // -- Custom Method --
    public boolean canInteract(ItemStack itemStack){
        if(itemStack.isOf(Items.FEATHER) || itemStack.isOf(Items.APPLE) || itemStack.isOf(Items.COOKIE)) return false;
        if(itemStack.isOf(Items.BOOK) || itemStack.isOf(Items.WRITABLE_BOOK) || itemStack.isOf(Items.OAK_BUTTON)) return false;
        return true;
    } // canInteract ()

    protected void handleAutoHeal () {
        if(this.getHealth() < this.getHpValue()) autoHeal = true;
        if(this.world.isClient && !autoHeal && !InternalMetric.GlobalAutoHeal) return;

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
        if(this.world.isClient && !combatMode) return;

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

    public void handleTame(ItemStack item, PlayerEntity player) {
        if(item.isOf(Items.COOKIE)) {
            if (this.random.nextInt(10) == 0) {
                this.setOwner(player);
                this.navigation.stop();
                this.setTarget(null);

                // Spawn hearts particles
                for (int i = 0; i < 7; ++i) {
                    double d0 = this.random.nextGaussian() * 0.02D;
                    double d1 = this.random.nextGaussian() * 0.02D;
                    double d2 = this.random.nextGaussian() * 0.02D;
                    this.world.addParticle(ParticleTypes.HEART, this.getParticleX(1.0D), this.getRandomBodyY() + 0.5D, this.getParticleZ(1.0D), d0, d1, d2);
                }

                player.sendMessage(Text.literal("Current Owner: " + getOwner().getEntityName()), true);
                this.world.sendEntityStatus(this, (byte) 7);
            } else {
                // Spawn ash particles
                for (int i = 0; i < 7; ++i) {
                    double d0 = this.random.nextGaussian() * 0.02D;
                    double d1 = this.random.nextGaussian() * 0.02D;
                    double d2 = this.random.nextGaussian() * 0.02D;
                    this.world.addParticle(ParticleTypes.ASH, this.getParticleX(1.0D), this.getRandomBodyY() + 0.5D, this.getParticleZ(1.0D), d0, d1, d2);
                }

                this.world.sendEntityStatus(this, (byte) 6);
            }

            if (!player.getAbilities().creativeMode) item.decrement(1);
        }

    } // handleTame ()

    public void handleSit(ItemStack itemStack) {
        if(!canInteract(itemStack)) return;
        setSitting(invertBoolean(isSitting()));
    } // handleSit ()

    public void handleTexture(ItemStack items, PlayerEntity player) {
        var oldTexture = getTextureID();
        if(items.isOf(Items.FEATHER)) setTexture(EntityTexture.DEFAULT);
        if(items.isOf(Items.APPLE)) {
            if(getBelly()) setTexture(EntityTexture.BELLY);
        }

        if(oldTexture != getTextureID()) {
            if (!player.getAbilities().creativeMode)
                items.decrement(1);
        }
    } // handleTexture ()

    public void handleState(ItemStack itemStack, PlayerEntity player) {
        var previousState = getCurrentState();
        RestState(itemStack);
        FollowState(itemStack);
        if(previousState != getCurrentState()) player.sendMessage(Text.literal("State: " + getCurrentState().name()), true);
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

    public void commandDebugExtra() {
        String debug = "";
        if(combatMode && getLog()) {
            if(waryTimer < 10) debug += "Wary: 0" + waryTimer + " ";
            else debug += "Wary: " + waryTimer + " ";
        }

        if(autoHeal && getLog() && InternalMetric.GlobalAutoHeal) {
            if(autoHealTimer < 10) debug += "Heal: 0" + autoHealTimer + " ";
            else debug += "Heal: " + autoHealTimer + " ";
            if(this.getHealth() < 10) debug += "| 0" + this.getHealth();
            else debug += "| " + (int)Math.floor(this.getHealth());
        }
        if(!debug.equals("")) commandDebug(debug, true);
    } // commandDebugExtra ()

} // Class InternalEntity