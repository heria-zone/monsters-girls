package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;

import java.util.Random;

public class InternalParticles {

    // -- Variables --
    private static final Random random = new Random();

    // -- Methods --
    public static void Ash(Entity entity) {
        for (int i = 0; i < 7; ++i) {
            double d0 = random.nextGaussian() * 0.02D;
            double d1 = random.nextGaussian() * 0.02D;
            double d2 = random.nextGaussian() * 0.02D;
            entity.getWorld().addParticle(ParticleTypes.ASH, entity.getParticleX(1.0D), entity.getRandomBodyY() + 0.5D, entity.getParticleZ(1.0D), d0, d1, d2);
        }
    } // Ash ()

    public static void Heart(Entity entity) {
        for (int i = 0; i < 7; ++i) {
            double d0 = random.nextGaussian() * 0.02D;
            double d1 = random.nextGaussian() * 0.02D;
            double d2 = random.nextGaussian() * 0.02D;
            entity.getWorld().addParticle(ParticleTypes.HEART, entity.getParticleX(1.0D), entity.getRandomBodyY() + 0.5D, entity.getParticleZ(1.0D), d0, d1, d2);
        }
    } // Heart ()

} // Class InternalParticles