package net.msymbios.monsters_girls.entity.internal;

import net.msymbios.monsters_girls.entity.enums.EntityAttribute;

public class InternalAttribute {

    // -- Variables --
    public EntityAttribute attribute;
    public float value;

    // -- Construct --
    public InternalAttribute(EntityAttribute attribute, float value) {
        this.attribute = attribute;
        this.value = value;
    } // Construct InternalAttribute ()

} // Class InternalAttribute