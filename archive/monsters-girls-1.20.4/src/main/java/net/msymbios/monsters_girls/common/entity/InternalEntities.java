package net.msymbios.monsters_girls.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.config.MonstersGirlsID;

public class InternalEntities {

    // -- Methods --

    protected static <T extends Entity> EntityType<T> register (Identifier name, SpawnGroup group, float width, float height, EntityType.EntityFactory<T> factory) {
        return Registry.register(Registries.ENTITY_TYPE, name, EntityType.Builder.create(factory,group).setDimensions(width, height).build());
    } // register ()

} // Class InternalEntities