package dev.Fjc.elytraQuest;

import com.ordwen.odailyquests.api.ODailyQuestsAPI;
import dev.Fjc.elytraQuest.cmd.Reload;
import dev.Fjc.elytraQuest.listener.ElytraQuestListener;
import dev.Fjc.elytraQuest.quests.ElytraQuestClass;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraQuest extends JavaPlugin {

    @Override
    public void onLoad() {
        ODailyQuestsAPI.registerQuestType("ELYTRA", ElytraQuestClass.class);
        getLogger().info("Quest registration successful.");
    }

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("ODailyQuests")) {
            getLogger().warning("ODailyQuests was not detected! That is an issue but loading will attempt to continue.");
        } else {
            getLogger().info("Found ODailyQuests.");
        }
        Bukkit.getPluginManager().registerEvents(new ElytraQuestListener(), this);
        getLogger().info("Listener loaded.");

        this.getConfig().addDefault("chance", 0.07);
        getServer().getPluginCommand("elytraquestapi-reload").setExecutor(new Reload());
        saveDefaultConfig();
        getLogger().info("Configuration file loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
