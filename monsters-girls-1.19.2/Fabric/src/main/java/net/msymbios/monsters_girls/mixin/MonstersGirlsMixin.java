package net.msymbios.monsters_girls.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MonstersGirlsMixin {

	// -- Method --
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		MonstersGirlsMod.LOGGER.info("This line is printed by an reboot lovely robot mixin!");
	} // init ()

} // Class MonstersGirlsMixin
