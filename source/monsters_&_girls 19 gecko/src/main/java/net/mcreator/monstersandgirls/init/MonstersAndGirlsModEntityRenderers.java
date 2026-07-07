
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.monstersandgirls.client.renderer.YellowWispRenderer;
import net.mcreator.monstersandgirls.client.renderer.WarpedMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.WarpedMushroomGalBigSpotsRenderer;
import net.mcreator.monstersandgirls.client.renderer.WarpedJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.StationCarpetRenderer;
import net.mcreator.monstersandgirls.client.renderer.SpookRenderer;
import net.mcreator.monstersandgirls.client.renderer.SoulWandererJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.SoulWandererGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.RedMushromGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.RedJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.RareWarpedJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.RareCrimsonJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.PuffballJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.PoofedEndershroomRenderer;
import net.mcreator.monstersandgirls.client.renderer.PeachRenderer;
import net.mcreator.monstersandgirls.client.renderer.MoltenMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.MoltenJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.InkCapRenderer;
import net.mcreator.monstersandgirls.client.renderer.InkCapBedRenderer;
import net.mcreator.monstersandgirls.client.renderer.InfernalMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.InfernalJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.GreenWispRenderer;
import net.mcreator.monstersandgirls.client.renderer.GreenMandrakeRenderer;
import net.mcreator.monstersandgirls.client.renderer.FruityMandrakeRenderer;
import net.mcreator.monstersandgirls.client.renderer.FlyAlexgaricRenderer;
import net.mcreator.monstersandgirls.client.renderer.EnderMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.CrimsonMushroomGirlBigspotsRenderer;
import net.mcreator.monstersandgirls.client.renderer.CrimsonMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.CrimsonJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.BrownMushroomGalRenderer;
import net.mcreator.monstersandgirls.client.renderer.BrownMandragoraRenderer;
import net.mcreator.monstersandgirls.client.renderer.BrownJarRenderer;
import net.mcreator.monstersandgirls.client.renderer.BlueWispRenderer;
import net.mcreator.monstersandgirls.client.renderer.BlueSlimeGirlRenderer;
import net.mcreator.monstersandgirls.client.renderer.BeeGirlWorkerRenderer;
import net.mcreator.monstersandgirls.client.renderer.AlexJarRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MonstersAndGirlsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MonstersAndGirlsModEntities.FRUITY_MANDRAKE.get(), FruityMandrakeRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.STATION_CARPET.get(), StationCarpetRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BEE_GIRL_WORKER.get(), BeeGirlWorkerRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BROWN_MUSHROOM_GAL.get(), BrownMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.MOLTEN_MUSHROOM_GAL.get(), MoltenMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.ENDER_MUSHROOM_GAL.get(), EnderMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.INFERNAL_MUSHROOM_GAL.get(), InfernalMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.SPOOK.get(), SpookRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.POOFED_ENDERSHROOM.get(), PoofedEndershroomRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.INK_CAP.get(), InkCapRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.RED_MUSHROM_GAL.get(), RedMushromGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.WARPED_MUSHROOM_GAL.get(), WarpedMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.WARPED_MUSHROOM_GAL_BIG_SPOTS.get(), WarpedMushroomGalBigSpotsRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.CRIMSON_MUSHROOM_GIRL_BIGSPOTS.get(), CrimsonMushroomGirlBigspotsRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.CRIMSON_MUSHROOM_GAL.get(), CrimsonMushroomGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.SOUL_WANDERER_GAL.get(), SoulWandererGalRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.FLY_ALEXGARIC.get(), FlyAlexgaricRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.PEACH.get(), PeachRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BLUE_WISP.get(), BlueWispRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.GREEN_WISP.get(), GreenWispRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.YELLOW_WISP.get(), YellowWispRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BLUE_SLIME_GIRL.get(), BlueSlimeGirlRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.GREEN_MANDRAKE.get(), GreenMandrakeRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BROWN_MANDRAGORA.get(), BrownMandragoraRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.RED_JAR.get(), RedJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.WARPED_JAR.get(), WarpedJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.CRIMSON_JAR.get(), CrimsonJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.SOUL_WANDERER_JAR.get(), SoulWandererJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.RARE_WARPED_JAR.get(), RareWarpedJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.ALEX_JAR.get(), AlexJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.RARE_CRIMSON_JAR.get(), RareCrimsonJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.INK_CAP_BED.get(), InkCapBedRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.BROWN_JAR.get(), BrownJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.PUFFBALL_JAR.get(), PuffballJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.INFERNAL_JAR.get(), InfernalJarRenderer::new);
		event.registerEntityRenderer(MonstersAndGirlsModEntities.MOLTEN_JAR.get(), MoltenJarRenderer::new);
	}
}
