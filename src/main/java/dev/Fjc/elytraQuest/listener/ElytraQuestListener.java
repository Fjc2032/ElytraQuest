package dev.Fjc.elytraQuest.listener;

import com.ordwen.odailyquests.api.events.QuestCompletedEvent;
import com.ordwen.odailyquests.quests.player.progression.PlayerProgressor;
import dev.Fjc.elytraQuest.ElytraQuest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ElytraQuestListener extends PlayerProgressor implements Listener {

    public Double chance = (Double) JavaPlugin.getPlugin(ElytraQuest.class).getConfig().get("chance");

    private final Map<Player, Double> playerDistance = new HashMap<>();

    @EventHandler
    public void onPlayerElytraFly(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            return;
        }

        if (player.isSwimming() || player.isClimbing() || player.isRiptiding() || player.isInsideVehicle() || player.isInWater() || player.isDead() || player.isSneaking()) return;
        if (player.isOnGround()) return;
        if (!player.isGliding()) return;

        Location from = event.getFrom();
        Location to = event.getTo();

        double distance = Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY()) + Math.abs(from.getZ() - to.getZ());


        double fullDistance = playerDistance.getOrDefault(player, 0.0);
        fullDistance += distance;

        playerDistance.put(player, fullDistance);

        setPlayerQuestProgression(event, player, 1, "ELYTRA");

    }

    @EventHandler
    public void onQuestComplete(QuestCompletedEvent event) {
        Random random = new Random();
        Player player = event.getPlayer();

        double percentRange = random.nextDouble();

        if (percentRange <= chance) {
            Bukkit.dispatchCommand(player, "mm mobs egg get Terrorwing");
        }

    }
}
