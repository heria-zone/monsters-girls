package net.msymbios.monsters_girls.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MonstersGirlsMixin {

	// -- Method --
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
	} // init ()

} // Class MonstersGirlsMixin