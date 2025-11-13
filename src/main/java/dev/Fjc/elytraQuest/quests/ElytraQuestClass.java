package dev.Fjc.elytraQuest.quests;

import com.ordwen.odailyquests.quests.player.progression.Progression;
import com.ordwen.odailyquests.quests.types.AbstractQuest;
import com.ordwen.odailyquests.quests.types.shared.BasicQuest;
import com.ordwen.odailyquests.tools.PluginLogger;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginLoader;

public class ElytraQuestClass extends AbstractQuest {

    public Double bossChance;

    public ElytraQuestClass(BasicQuest basicQuest) {
        super(basicQuest);
    }

    @Override
    public String getType() {
        return "ELYTRA";
    }

    @Override
    public boolean canProgress(Event provided, Progression progression) {
        return provided instanceof PlayerMoveEvent && progression != null;
    }

    @Override
    public boolean loadParameters(ConfigurationSection configurationSection, String file, String index) {

        return true;
    }
}
