package net.msymbios.monsters_girls.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
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
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.common.particle.InternalParticle;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.entity.internal.enums.*;
import net.msymbios.monsters_girls.common.util.internal.Utility;
import org.jetbrains.annotations.Nullable;

import static net.msymbios.monsters_girls.common.util.internal.Utility.invertBoolean;

public abstract class InternalEntity extends TameableEntity {

    // -- Variables --
    protected static final TrackedData<Integer> TEXTURE_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> MODEL_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> ANIMATOR_ID = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected static final TrackedData<Integer> STATE = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Boolean> HAS_BELLY = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected static final TrackedData<Boolean> IS_PLANTING_ENABLED = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> IS_SOUND_ENABLED = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> IS_NOTIFICATION_ON = DataTracker.registerData(InternalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected int waryTimer = 0, autoHealTimer = 0;
    protected boolean combatMode = false, autoHeal = false, canPlant = true, hasEffects = false;
    public InternalEntityType<?> nativeEntity;

    // -- Properties --

    // TEXTURE

    public Identifier getCurrentTexture() { return nativeEntity.getTexture(EntityTexture.byId(getCurrentTextureID())); } // getTexture ()

    public int getCurrentTextureID() {
        int value = EntityTexture.DEFAULT.getId();
        try {value = this.dataTracker.get(TEXTURE_ID);}
        catch (Exception ignored) {}
        return value;
    } // getTextureID ()

    public void setCurrentTexture(int value) { if(nativeEntity.checkTexture(EntityTexture.byId(value))) this.dataTracker.set(TEXTURE_ID, value); } // setTexture ()

    public void setCurrentTexture(EntityTexture value) { setCurrentTexture(value.getId()); } // setTexture ()

    // MODEL

    public Identifier getCurrentModel() { return nativeEntity.getModel(EntityModel.byId(getCurrentModelID())); } // getCurrentModel ()

    public int getCurrentModelID() {
        int value = EntityModel.DEFAULT.getId();
        try {value = this.dataTracker.get(MODEL_ID);}
        catch (Exception ignored) {}
        return value;
    } // getModelID ()

    public void setCurrentModel(int value) { if(nativeEntity.checkModel(EntityModel.byId(value))) this.dataTracker.set(MODEL_ID, value); } // setModel ()

    public void setCurrentModel(EntityModel value) { setCurrentModel(value.getId()); } // setModel ()

    // ANIMATOR

    public Identifier getCurrentAnimator() { return nativeEntity.getAnimator(EntityAnimator.byId(getCurrentAnimatorID())); } // getCurrentAnimator ()

    public int getCurrentAnimatorID() {
        int value = EntityAnimator.DEFAULT.getId();
        try {value = this.dataTracker.get(ANIMATOR_ID);}
        catch (Exception ignored) {}
        return value;
    } // getAnimatorID ()

    public void setCurrentAnimator(int value) { if(nativeEntity.checkAnimator(EntityAnimator.byId(value))) this.dataTracker.set(ANIMATOR_ID, value); } // setAnimator ()

    public void setCurrentAnimator(EntityAnimator value) { setCurrentAnimator(value.getId()); } // setAnimator ()

    // STATE

    public int getCurrentStateID() {
        int value = EntityState.REST.getId();
        try {value = this.dataTracker.get(STATE);}
        catch (Exception ignored) {}
        return value;
    } // getCurrentStateID ()

    public EntityState getCurrentState() {
        EntityState value = EntityState.REST;
        try {value = EntityState.byId(this.dataTracker.get(STATE));}
        catch (Exception ignored) {}
        return value;
    } // getCurrentState ()

    public void setCurrentState(EntityState value){
        this.dataTracker.set(STATE, value.getId());
    } // setCurrentState ()

    public void setCurrentState(int value){
        this.dataTracker.set(STATE, value);
    } // setCurrentState ()

    // BELLY

    public boolean getBelly() {
        boolean value = true;
        try {value = this.dataTracker.get(HAS_BELLY);}
        catch (Exception ignored) {}
        return value;
    } // getBelly ()

    public void setBelly(boolean value) { this.dataTracker.set(HAS_BELLY, value); } // setBelly ()

    // PLANT

    public boolean getPlant() {
        boolean value = true;
        try {value = this.dataTracker.get(IS_PLANTING_ENABLED);}
        catch (Exception ignored) {}
        return value;
    } // getPlant ()

    public void setPlant(boolean value) { this.dataTracker.set(IS_PLANTING_ENABLED, value); } // setPlant ()

    // SOUND

    public boolean getSoundStatus() {
        boolean value = true;
        try {value = this.dataTracker.get(IS_SOUND_ENABLED);}
        catch (Exception ignored) {}
        return value;
    } // getSoundStatus ()

    public void setSoundStatus(boolean value) { this.dataTracker.set(IS_SOUND_ENABLED, value); } // setSoundStatus ()

    // NOTIFICATION

    public boolean getNotification() {
        boolean value = true;
        try {value = this.dataTracker.get(IS_NOTIFICATION_ON);}
        catch (Exception ignored) {}
        return value;
    } // getNotification ()

    public void setNotification(boolean value) { this.dataTracker.set(IS_NOTIFICATION_ON, value); } // setNotification ()

    // -- Constructor --

    protected InternalEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    } // Constructor InternalEntity ()

    // -- Inherited Methods --

    // SOUNDS

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if(nativeEntity.checkSound(EntitySound.HURT)) return nativeEntity.getSound(EntitySound.HURT);
        else return super.getHurtSound(source);
    } // getHurtSound ()

    @Override
    protected SoundEvent getDeathSound() {
        if(nativeEntity.checkSound(EntitySound.DEATH)) return nativeEntity.getSound(EntitySound.DEATH);
        else return super.getDeathSound();
    } // getDeathSound ()

    @Override
    protected SoundEvent getAmbientSound() {
        if(getSoundStatus() && nativeEntity.checkSound(EntitySound.DEFAULT)) return nativeEntity.getSound(EntitySound.DEFAULT);
        else return super.getAmbientSound();
    } // getAmbientSound ()

    // INITIALIZATION

    @Override @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setCurrentTexture(nativeEntity.getRandomTextureID());
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    } // initialize

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    } // createChild ()

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    } // method_48926 ()

    // UPDATE

    @Override
    public void tick() {
        super.tick();
        //if(canPlant && getPlant() && this.isTamed()) handlePlanting(getWorld(), this.getX(), this.getY(), this.getZ(), this);
        //handleCombatMode();
        //handleAutoHeal();
    } // tick ()

    // INTERACTION

    @Override
    public void onAttacking(Entity target) {
        //handleActivateCombatMode();
        this.getWorld().sendEntityStatus(this, (byte)4);
        super.onAttacking(target);
    } // onAttacking ()

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;
        //if (hasEffects) handleNegativeEffect(this, source.getSource());
        //handleActivateCombatMode();
        return super.damage(source, amount);
    } // damage ()

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        var stack = player.getStackInHand(hand);
        Item item = stack.getItem();

        if (this.getWorld().isClient) {
            boolean bl = this.isOwner(player) || this.isTamed() || nativeEntity.isFood(item) && !this.isTamed();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            label90: {
                if (this.isTamed()) {
                    if (!this.isOwner(player)) break label90;
                    handleTexture(stack, player);
                    handleSit(stack);
                    handleStates(stack);
                    handlePreferences(stack);
                    handleInteract(player);
                    return ActionResult.SUCCESS;
                } else {
                    if (handleTame(stack, player)) return ActionResult.SUCCESS;
                }
                return super.interactMob(player, hand);
            }
            return super.interactMob(player, hand);
        }
    } // interactMob ()

    // SAVE

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TEXTURE_ID, EntityTexture.DEFAULT.getId());
        this.dataTracker.startTracking(MODEL_ID, EntityModel.DEFAULT.getId());
        this.dataTracker.startTracking(ANIMATOR_ID, EntityAnimator.DEFAULT.getId());

        this.dataTracker.startTracking(STATE, EntityState.MOVE.getId());
        this.dataTracker.startTracking(HAS_BELLY, false);

        this.dataTracker.startTracking(IS_PLANTING_ENABLED, true);
        this.dataTracker.startTracking(IS_SOUND_ENABLED, true);
        this.dataTracker.startTracking(IS_NOTIFICATION_ON, false);
    } // initDataTracker ()

    @Override
    public void writeCustomDataToNbt(NbtCompound dataNBT) {
        super.writeCustomDataToNbt(dataNBT);
        dataNBT.putInt("TextureID", this.getCurrentTextureID());
        dataNBT.putInt("ModelID", this.getCurrentModelID());
        dataNBT.putInt("AnimatorID", this.getCurrentAnimatorID());

        dataNBT.putInt("State", this.getCurrentStateID());
        dataNBT.putBoolean("Belly", getBelly());

        dataNBT.putBoolean("Plant", getPlant());
        dataNBT.putBoolean("Sound", getSoundStatus());
        dataNBT.putBoolean("Notification", getNotification());
    } // writeCustomDataToNbt ()

    @Override
    public void readCustomDataFromNbt(NbtCompound dataNBT) {
        super.readCustomDataFromNbt(dataNBT);
        this.setCurrentTexture(dataNBT.getInt("TextureID"));
        this.setCurrentModel(dataNBT.getInt("ModelID"));
        this.setCurrentAnimator(dataNBT.getInt("AnimatorID"));

        this.setCurrentState(dataNBT.getInt("State"));
        this.setBelly(dataNBT.getBoolean("Belly"));

        this.setPlant(dataNBT.getBoolean("Plant"));
        this.setSoundStatus(dataNBT.getBoolean("Sound"));
        this.setNotification(dataNBT.getBoolean("Notification"));
    } // readCustomDataFromNbt ()

    // -- Custom Methods --

    // INTERACTION

    public void handleInteract (PlayerEntity player) {}

    public boolean handleTame(ItemStack stack, PlayerEntity player) {
        boolean result = false;
        if(nativeEntity.isFood(stack)) {
            if (this.random.nextInt(5) == 0) {
                this.setOwner(player);
                this.navigation.stop();
                this.setTarget(null);

                InternalParticle.Heart(this);
                result = true;
            } else {
                InternalParticle.Ash(this);
            }
            if (!player.getAbilities().creativeMode) stack.decrement(1);
        }
        return result;
    } // handleTame ()

    public boolean handleTexture(ItemStack stack, PlayerEntity player) {
        boolean result = false;
        var oldTexture = getCurrentTextureID();
        int bellyLevel = this.getCurrentTextureID();

        if (stack.isOf(Items.FEATHER)) {
            if (bellyLevel > EntityTexture.SLIM.getId() && bellyLevel <= nativeEntity.textures.size()) {
                for (int i = bellyLevel - 1; i >= EntityTexture.SLIM.getId(); i--) {
                    if (!nativeEntity.checkTexture(EntityTexture.byId(i))) continue;
                    bellyLevel = i;
                    break;
                }
            }
        }

        if (stack.isOf(Items.APPLE)) {
            if (bellyLevel >= EntityTexture.SLIM.getId() && bellyLevel <= nativeEntity.textures.size()) {
                for (int i = bellyLevel + 1; i <= nativeEntity.textures.size(); i++) {
                    if (!nativeEntity.checkTexture(EntityTexture.byId(i))) continue;
                    bellyLevel = i;
                    break;
                }
            }
        }

        if (this.getCurrentTextureID() != bellyLevel) setCurrentTexture(EntityTexture.byId(bellyLevel));

        if(oldTexture != getCurrentTextureID()) {
            if (!player.getAbilities().creativeMode)
                stack.decrement(1);
            result = true;
        }
        return result;
    } // handleTexture ()

    protected void handlePreferences(ItemStack stack) {
        if(stack.isOf(Items.OAK_BUTTON)) {
            this.setNotification(invertBoolean(getNotification()));
            if(getNotification()) displayNotification(MonstersGirlsID.TRANS_MSG_NOTIFICATION, MonstersGirlsID.TRANS_MSG_ON, true);
            else displayNotification(MonstersGirlsID.TRANS_MSG_NOTIFICATION, MonstersGirlsID.TRANS_MSG_OFF, true);
        }

        if(stack.isOf(Items.NOTE_BLOCK)) {
            this.setSoundStatus(invertBoolean(getSoundStatus()));
            if(getSoundStatus()) displayNotification(MonstersGirlsID.TRANS_MSG_SOUND, MonstersGirlsID.TRANS_MSG_ON, true);
            else displayNotification(MonstersGirlsID.TRANS_MSG_SOUND, MonstersGirlsID.TRANS_MSG_OFF, true);
        }

        if(this.canPlant && stack.isOf(Items.WOODEN_HOE)) {
            this.setPlant(invertBoolean(getPlant()));
            if(getPlant()) displayNotification(MonstersGirlsID.TRANS_MSG_PLANT, MonstersGirlsID.TRANS_MSG_ON, true);
            else displayNotification(MonstersGirlsID.TRANS_MSG_PLANT, MonstersGirlsID.TRANS_MSG_OFF, true);
        }
    } // handlePreferences ()

    // TODO: Further Refine (canInteract, handleSit, handleState)
    public boolean canInteract(ItemStack stack){
        if(stack.isOf(Items.FEATHER) || stack.isOf(Items.APPLE) || stack.isOf(Items.COOKIE) || stack.isOf(Items.NOTE_BLOCK) || stack.isOf(Items.WOODEN_HOE)
                || stack.isOf(Items.HONEYCOMB) || stack.isOf(Items.HONEY_BOTTLE)) return false;
        if(stack.isOf(Items.BOOK) || stack.isOf(Items.WRITABLE_BOOK) || stack.isOf(Items.OAK_BUTTON)) return false;
        return true;
    } // canInteract ()

    public void handleSit(ItemStack stack) {
        if(!canInteract(stack)) return;
        setSitting(invertBoolean(isSitting()));
        setInSittingPose(isSitting());
        this.setTarget(null);
        this.navigation.stop();
    } // handleSit ()

    public void handleStates(ItemStack stack) {
        handleRestState(stack);
        handleFollowState(stack);
    } // handleStates

    public void handleRestState(ItemStack stack){
        if(!canInteract(stack)) return;
        if(isSitting()) setCurrentState(EntityState.REST);
    } // handleRestState ()

    public void handleFollowState(ItemStack stack){
        if(!canInteract(stack)) return;
        if(!isSitting()) setCurrentState(EntityState.MOVE);
    } // handleFollowState ()

    // DISPLAY

    private void displayNotification(String notification, String message, boolean display) {
        if(!display) return;
        String customName = Utility.getEntityCustomName(this);
        if(!customName.isEmpty()) Utility.displayInfo(this, Text.literal(customName + " | ").append(MonstersGirlsID.getTranslation(notification).append(Text.literal(": ").append(MonstersGirlsID.getTranslation(message)))), true);
        else Utility.displayInfo(this, MonstersGirlsID.getTranslation(notification).append(Text.literal(": ").append(MonstersGirlsID.getTranslation(message))), true);
    } // displayNotification ()

    private void displayNotification(String message, boolean display) {
        if(!display) return;
        String customName = Utility.getEntityCustomName(this);
        if(!customName.isEmpty()) Utility.displayInfo(this, Text.literal(customName + " | ").append(MonstersGirlsID.getTranslation(message)), true);
        else Utility.displayInfo(this, MonstersGirlsID.getTranslation(message), true);
    } // displayNotification ()

} // Class InternalEntity