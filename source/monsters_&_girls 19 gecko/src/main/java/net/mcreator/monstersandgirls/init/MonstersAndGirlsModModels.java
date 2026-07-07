
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.monstersandgirls.client.model.Modeljargal;
import net.mcreator.monstersandgirls.client.model.ModelfruityMandrake;
import net.mcreator.monstersandgirls.client.model.Modelfat_mushroombed;
import net.mcreator.monstersandgirls.client.model.Modelendercaris;
import net.mcreator.monstersandgirls.client.model.Modelborowik;
import net.mcreator.monstersandgirls.client.model.ModelStation;
import net.mcreator.monstersandgirls.client.model.ModelSoulJar;
import net.mcreator.monstersandgirls.client.model.ModelMuchomor;
import net.mcreator.monstersandgirls.client.model.ModelKurwaPlease;
import net.mcreator.monstersandgirls.client.model.ModelCrimsonFung;
import net.mcreator.monstersandgirls.client.model.ModelChubbyjargal;
import net.mcreator.monstersandgirls.client.model.ModelBeegirl;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MonstersAndGirlsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeljargal.LAYER_LOCATION, Modeljargal::createBodyLayer);
		event.registerLayerDefinition(ModelSoulJar.LAYER_LOCATION, ModelSoulJar::createBodyLayer);
		event.registerLayerDefinition(Modelborowik.LAYER_LOCATION, Modelborowik::createBodyLayer);
		event.registerLayerDefinition(ModelKurwaPlease.LAYER_LOCATION, ModelKurwaPlease::createBodyLayer);
		event.registerLayerDefinition(ModelCrimsonFung.LAYER_LOCATION, ModelCrimsonFung::createBodyLayer);
		event.registerLayerDefinition(ModelChubbyjargal.LAYER_LOCATION, ModelChubbyjargal::createBodyLayer);
		event.registerLayerDefinition(ModelMuchomor.LAYER_LOCATION, ModelMuchomor::createBodyLayer);
		event.registerLayerDefinition(ModelBeegirl.LAYER_LOCATION, ModelBeegirl::createBodyLayer);
		event.registerLayerDefinition(ModelfruityMandrake.LAYER_LOCATION, ModelfruityMandrake::createBodyLayer);
		event.registerLayerDefinition(Modelendercaris.LAYER_LOCATION, Modelendercaris::createBodyLayer);
		event.registerLayerDefinition(ModelStation.LAYER_LOCATION, ModelStation::createBodyLayer);
		event.registerLayerDefinition(Modelfat_mushroombed.LAYER_LOCATION, Modelfat_mushroombed::createBodyLayer);
	}
}
