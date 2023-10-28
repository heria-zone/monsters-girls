package net.msymbios.monsters_girls.entity.custom;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.enums.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import net.msymbios.monsters_girls.entity.internal.InternalEntity;
import net.msymbios.monsters_girls.entity.internal.InternalMetric;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class BeeGirlEntity extends InternalEntity implements GeoEntity  {

    // -- Variables --
    protected static final TrackedData<Integer> BELLY_LEVEL = DataTracker.registerData(BeeGirlEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private final AnimatableInstanceCache  cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_ARMOR, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.ARMOR))
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.ARMOR_TOUGHNESS))
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.FOLLOW_RANGE))
                .add(EntityAttributes.GENERIC_FLYING_SPEED, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.FLYING_SPEED));
    } // setAttributes ()

    // BELLY LEVEL
    public int getBellyLevel() {
        int value = EntityTexture.DEFAULT.getId();
        try {value = this.dataTracker.get(BELLY_LEVEL);}
        catch (Exception ignored) {}
        return value;
    } // getBelly ()

    public void setBellyLevel(int value) { this.dataTracker.set(BELLY_LEVEL, value); } // setBelly ()

    // TEXTURE
    @Override
    public Identifier getTexture() { return InternalMetric.BEE_TEXTURES.get(getTextureID()).get(EntityTexture.byId(getBellyLevel())); } // getTexture ()

    @Override
    public Identifier getCurrentTexture() {
        Identifier defaultTexture = getTexture();
        if(defaultTexture == null) defaultTexture = InternalMetric.BEE_TEXTURES.get(getTextureID()).get(EntityTexture.DEFAULT);
        return defaultTexture;
    } // getCurrentTexture ()

    @Override
    public int getTextureID() {
        int value = 0;
        try {value = this.dataTracker.get(TEXTURE_ID);}
        catch (Exception ignored) {}
        return value;
    } // getTextureID ()

    @Override
    public void setTexture(int value) { this.dataTracker.set(TEXTURE_ID, value); } // setTexture ()

    // -- Constructor --
    public BeeGirlEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.category = EntityCategory.Bee;
        this.variant = EntityVariant.Bee;
        this.canPlant = false;
    } // Constructor BeeEntity ()

    // -- Inherited Methods --
    @Override
    public void handleTexture(ItemStack items, PlayerEntity player) {
        var oldTexture = getTextureID();
        if(items.isOf(Items.FEATHER)) {
            int bellyLevel = this.getBellyLevel();
            if(bellyLevel > 0 && bellyLevel <= 4){
                bellyLevel = bellyLevel - 1;
                setBellyLevel(bellyLevel);
            }
            commandDebug("Belly Level: " + bellyLevel, false);
        }

        if(items.isOf(Items.HONEYCOMB)) {
            int bellyLevel = this.getBellyLevel();
            if(bellyLevel >= 0 && bellyLevel < 4){
                bellyLevel = bellyLevel + 1;
                setBellyLevel(bellyLevel);
            }
            commandDebug("Belly Level: " + bellyLevel, false);
        }

        if(oldTexture != getTextureID()) {
            if (!player.getAbilities().creativeMode)
                items.decrement(1);
        }
    } // handleTexture ()

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    } // method_48926 ()

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegister) {
        controllerRegister.add(InternalAnimation.locomotionAnimation(this));
        controllerRegister.add(InternalAnimation.attackAnimation(this));
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache  getAnimatableInstanceCache() {
        return cache;
    } // getFactory ()

    // -- Built-In Methods --
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new FollowOwnerGoal(this, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.MOVEMENT_SPEED), InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.FOLLOW_RANGE), InternalMetric.FollowCloseDistance, false));
        this.goalSelector.add(3, new FlyGoal(this, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.FLYING_SPEED)));
        this.goalSelector.add(4, new TemptGoal(this, InternalMetric.getAttribute(EntityVariant.Bee, EntityAttribute.MOVEMENT_SPEED), Ingredient.ofItems(new ItemConvertible[]{Items.HONEYCOMB, Items.HONEY_BOTTLE}), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, InternalMetric.WanderAroundMovement));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LookAtRange));
        this.goalSelector.add(6, new LookAtEntityGoal(this, InternalEntity.class, InternalMetric.LookAtRange));
        this.goalSelector.add(7, new LookAroundGoal(this));
    } // initGoals ()

    @Override
    public @Nullable EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setTexture(InternalMetric.getRandomBeeTextureID());
        this.setBellyLevel(getTextureID());
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    } // initialize ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(BELLY_LEVEL, EntityTexture.DEFAULT.getId());
        this.dataTracker.startTracking(VARIANT, EntityVariant.Bee.getName());
        this.dataTracker.startTracking(MODEL_ID, EntityModel.Bee.getId());
        this.dataTracker.startTracking(BELLY, true);
    } // initDataTracker ()

    public void writeCustomDataToNbt(NbtCompound dataNBT) {
        dataNBT.putInt("BellyLevel", this.getBellyLevel());
        super.writeCustomDataToNbt(dataNBT);
    } // writeCustomDataToNbt ()

    public void readCustomDataFromNbt(NbtCompound dataNBT) {
        this.setBellyLevel(dataNBT.getInt("BellyLevel"));
        super.readCustomDataFromNbt(dataNBT);
    } // readCustomDataFromNbt ()

} // Class BeeEntity