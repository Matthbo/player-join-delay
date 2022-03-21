package me.matthbo.mod.joindelay.common;

import com.mojang.logging.LogUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = "joindelay")
public class EventHandlerCommon {

    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event){
        LOGGER.info("/-- {} Logged in --/", event.getPlayer().getName().getString());
        MinecraftServer server = event.getPlayer().getServer();
        ServerPlayer player = server.getPlayerList().getPlayer(event.getPlayer().getUUID());

        // TODO check if player can just be invincible with a ghost form instead (also kind of like spectator in playerlist)
        player.setGameMode(GameType.SPECTATOR);
    }
}
