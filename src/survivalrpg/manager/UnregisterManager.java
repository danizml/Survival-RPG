package survivalrpg.manager;

import survivalrpg.SurvivalRPG;

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
