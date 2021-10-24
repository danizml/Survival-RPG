package survivalrpg.manager;

import survivalrpg.SurvivalRPG;

/**
 *    +UnregisterManager+
 * File created by TonimatasMC
 * Links:
 *  - Discord: https://discord.com/invite/VYqEtT36U9
 *  - GitHub: https://github.com/TonimatasMCDEV
 *  - SpigotMC: https://www.spigotmc.org/members/tonimatas.803111/
 *  - CurseForge: https://www.curseforge.com/members/x_tonimatasmc_x/projects
 *
 */

public class UnregisterManager {
    public static void unregister() {
        unregisterYML();
        MessageManager.unregister();
    }

    public static void unregisterYML() {
        SurvivalRPG.getInstance().saveConfig();
        SurvivalRPG.getInstance().saveWarps();
        SurvivalRPG.getInstance().saveItems();
        SurvivalRPG.getInstance().saveMessages();
        EconomyManager.saveEconomy();
    }
}
