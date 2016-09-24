package net.blay09.mods.clienttweaks.tweak;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HideOwnEffectParticles extends ClientTweak {

	public HideOwnEffectParticles() {
		super("Hide Own Particle Effects");

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if(isEnabled()) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			if (player != null) {
				player.getDataManager().set(EntityLivingBase.HIDE_PARTICLES, true);
			}
		}
	}

	@Override
	public String getDescription() {
		return "This option will hide most of your own potion particle effects for your client (other players will still see them).";
	}

}