package net.msymbios.monsters_girls.common.util.internal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class Utility {

    // -- Variables --
    public static final double PI = 3.14159265358979323846;

    // -- Methods --

    /**
     * Gets the custom name of a LivingEntity.
     *
     * @param entity the LivingEntity to get the custom name from
     * @return the custom name of the LivingEntity, or an empty string if not present
     */
    public static String getEntityCustomName(LivingEntity entity) {
        String customName = "";
        try {customName = entity.getCustomName().getString();}
        catch (Exception ignored) {} // Custom name not found, return empty string
        return customName;
    } // getEntityCustomName ()

    /**
     * Inverts a boolean value.
     *
     * @param  value  the boolean value to be inverted
     * @return       the inverted boolean value
     */
    public static boolean invertBoolean(boolean value) {
        return !value;
    } // invertBoolean ()

    // DISPLAY

    /**
     * Displays the given message to the owner of the entity, if the owner exists.
     *
     * @param entity The entity to display the message owner.
     * @param message The message to display.
     * @param overlay Indicates whether the message should be displayed as an overlay.
     */
    public static void displayInfo(TameableEntity entity, MutableText message, boolean overlay) {
        // Check if the entity has an owner
        if(entity.getOwner() != null) {
            // Get the owner as a PlayerEntity
            PlayerEntity player = (PlayerEntity)entity.getOwner();
            // Send the message to the player
            player.sendMessage(message, overlay);
        }
    } // displayInfo ()

    /**
     * Displays the given message to the owner of the entity, if the owner exists.
     *
     * @param entity The entity to display the message owner.
     * @param message The message to display.
     * @param overlay Indicates whether the message should be displayed as an overlay.
     */
    public static void displayInfo(TameableEntity entity, String message, boolean overlay) { displayInfo(entity, Text.literal(message), overlay); } // displayInfo ()

} // Class Utility