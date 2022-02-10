package survivalrpg.manager;

//----------------bukkit-------------//

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import survivalrpg.SurvivalRPG;

//----------------Java---------------//

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

//----------------code---------------//

public class EconomyManager implements CommandExecutor, Listener {
    private static FileConfiguration economy = null;
    private static File economyFile = null;

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if (label.equalsIgnoreCase("rpgs")) {
            if (args[0].equalsIgnoreCase("economy")) {
                Player player = (Player) sender;

                if (args[1].equalsIgnoreCase("give")) {
                    Player target = Bukkit.getPlayer(args[3]);
                    assert target != null;

                    player.sendMessage("");

                    int amount = EconomyManager.getEconomy().getInt(target.getName());
                    int amountAdd = Integer.parseInt(args[2]);

                    if (EconomyManager.getEconomy().getConfigurationSection(target.getName()) == null) {
                        EconomyManager.getEconomy().set(target.getName(), 0);
                    }

                    EconomyManager.getEconomy().set(target.getName(), amount + amountAdd);
                    EconomyManager.saveEconomy();
                    EconomyManager.reloadEconomy();
                }

                if (args[1].equalsIgnoreCase("take")) {
                    Player target = Bukkit.getPlayer(args[3]);
                    assert target != null;

                    player.sendMessage("");

                    int amount = EconomyManager.getEconomy().getInt(target.getName());
                    int deletedAmount = Integer.parseInt(args[2]);

                    if (EconomyManager.getEconomy().getConfigurationSection(target.getName()) == null) {
                        EconomyManager.getEconomy().set(target.getName(), 0);
                        EconomyManager.saveEconomy();
                        EconomyManager.reloadEconomy();
                    }

                    EconomyManager.getEconomy().set(target.getName(), amount - deletedAmount);
                    EconomyManager.saveEconomy();
                    EconomyManager.reloadEconomy();
                }

                if (args[1].equalsIgnoreCase("pay")) {
                    Player target = Bukkit.getPlayer(args[3]);
                    assert target != null;


                    int amountSender = EconomyManager.getEconomy().getInt(player.getName());
                    int amountTarget = EconomyManager.getEconomy().getInt(target.getName());
                    int moneyAmount = Integer.parseInt(args[2]);

                    if (EconomyManager.getEconomy().getConfigurationSection(player.getName()) == null) {
                        EconomyManager.getEconomy().set(player.getName(), 0);
                        EconomyManager.saveEconomy();
                        EconomyManager.reloadEconomy();
                    }

                    EconomyManager.getEconomy().set(player.getName(), amountSender - moneyAmount);
                    EconomyManager.saveEconomy();
                    EconomyManager.reloadEconomy();

                    if (EconomyManager.getEconomy().getConfigurationSection(target.getName()) == null) {
                        EconomyManager.getEconomy().set(target.getName(), 0);
                        EconomyManager.saveEconomy();
                        EconomyManager.reloadEconomy();
                    }

                    EconomyManager.getEconomy().set(target.getName(), amountTarget + moneyAmount);
                    EconomyManager.saveEconomy();
                    EconomyManager.reloadEconomy();
                }

                if (args[1].equalsIgnoreCase("balance")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    assert target != null;

                    int amount = EconomyManager.getEconomy().getInt(player.getName());

                    if (EconomyManager.getEconomy().getConfigurationSection(target.getName()) == null) {
                        EconomyManager.getEconomy().set(target.getName(), 0);
                        EconomyManager.saveEconomy();
                        EconomyManager.reloadEconomy();
                    }

                    player.sendMessage("Your money: " + amount);
                }
            }
        }return true;
    }

    public static FileConfiguration getEconomy() {
        if (economy == null) {
            reloadEconomy();
        }return economy;
    }

    public static void reloadEconomy() {
        if (economy == null) {
            economyFile = new File(SurvivalRPG.getInstance().getDataFolder(), "economy.yml");
        }

        economy = YamlConfiguration.loadConfiguration(economyFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(SurvivalRPG.getInstance().getResource("economy.yml")), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        economy.setDefaults(defConfig);
    }

    public static void saveEconomy() {
        try {
            economy.save(economyFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static void registerEconomy() {
        economyFile = new File(SurvivalRPG.getInstance().getDataFolder(), "economy.yml");

        if (!economyFile.exists()) {
            getEconomy().options().copyDefaults(true);
            saveEconomy();
        }
    }
}