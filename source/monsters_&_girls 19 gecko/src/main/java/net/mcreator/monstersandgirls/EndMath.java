
package net.mcreator.monstersandgirls;

import net.minecraft.util.Mth;

import java.util.Random;

public class EndMath extends Mth {

    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean inRange(float value, float min, float max) {
        return value >= min && value <= max;
    }

    public static boolean inRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    public static boolean inAverage(int value, int average, int range) {
        return value >= average - range && value <= average + range;
    }
}