package survivalrpg.warps;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import survivalrpg.SurvivalRPG;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class WarpConfig {
    private static FileConfiguration warps = null;
    private static File warpsFile = null;

    public static FileConfiguration getWarps() {
        if (warps == null) {
            reloadWarps();
        }

        return warps;
    }

    public static void reloadWarps() {
        if (warps == null) {
            warpsFile = new File(SurvivalRPG.plugin.getDataFolder(), "messages.yml");
        }

        warps = YamlConfiguration.loadConfiguration(warpsFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(SurvivalRPG.plugin.getResource("messages.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        warps.setDefaults(defConfig);
    }

    public static void saveWarps() {
        try {
            warps.save(warpsFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static void registerWarps() {
        warpsFile = new File(SurvivalRPG.plugin.getDataFolder(), "messages.yml");
        if (!warpsFile.exists()) {
            getWarps().options().copyDefaults(true);
            saveWarps();
        }
    }
}
