package net.msymbios.monsters_girls.entity.internal;

public class Utility {

    // -- Variables --
    private static final java.util.Random rand = new java.util.Random();
    public static final double PI = 3.14159265358979323846;

    // -- Methods --
    public static int getRandomNumber(int number) {
        return rand.nextInt(number);
    } // getRandomNumber ()

    public static boolean invertBoolean(boolean value) {
        return !value;
    } // invertBoolean ()

} // Class Utility