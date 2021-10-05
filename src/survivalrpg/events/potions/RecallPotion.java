package survivalrpg.events.potions;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"ConstantConditions", "NullableProblems", "UnnecessaryReturnStatement", "UnusedAssignment"})
public class RecallPotion extends JavaPlugin implements Listener {

    public NamespacedKey potionKey = new NamespacedKey(this,"recallpotion");

    public void onEnable(){
        getCommand("recallpotion").setExecutor(this);
        getServer().getPluginManager().registerEvents(this,this);
        loadConfig();
        if(getConfig().getBoolean("General.allow-crafting")){
            buildRecipe();
        }
    }



    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }




    public ItemStack buildItem(){
        ItemStack i = new ItemStack(Material.POTION);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&',getConfig().getString("ItemConfig.name")));
        im.setCustomModelData(getConfig().getInt("ItemConfig.custommodeldata"));
        im.getPersistentDataContainer().set(potionKey, PersistentDataType.STRING,"recallpotion");
        im.addEnchant(Enchantment.DURABILITY,1,true);
        List<String> lore = new ArrayList<>();
        for(String s : getConfig().getStringList("ItemConfig.lore")){
            lore.add(ChatColor.translateAlternateColorCodes('&',s));
        }
        im.setLore(lore);
        i.setItemMeta(im);
        return i;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("recallpotion.give")){
            if(args.length==3&&args[0].equalsIgnoreCase("give")){
                Player target = Bukkit.getPlayer(args[1]);
                if(target==null){
                    sender.sendMessage(ChatColor.RED+"Player is offline!");
                    return true;
                }
                int amount = 1;
                try{
                    amount = Integer.parseInt(args[2]);
                    ItemStack i = buildItem();
                    i.setAmount(amount);
                    if(target.getInventory().firstEmpty()==-1){
                        target.getLocation().getWorld().dropItemNaturally(target.getLocation(),i);
                        return true;
                    }
                    target.getInventory().addItem(i);
                    return true;
                }catch (IllegalArgumentException ex){
                    sender.sendMessage(ChatColor.RED+"Wrong amount!");
                    return true;
                }
            }


            sender.sendMessage(ChatColor.GRAY+"Usage: /rpg potion recallpotion give <amount> <player>");
            return true;
        }
        return true;
    }


    @EventHandler
    public void onDrink(PlayerItemConsumeEvent event){
        if(event.getItem().getType()==Material.POTION){
            if(event.getItem().hasItemMeta()&&event.getItem().getItemMeta().getPersistentDataContainer().has(potionKey,PersistentDataType.STRING)){
                Player consumer = event.getPlayer();
                if(consumer.getBedSpawnLocation()!=null){
                    consumer.getBedSpawnLocation().getChunk().load();
                    teleportDelay(consumer,consumer.getBedSpawnLocation());
                    return;
                }
                consumer.getWorld().getSpawnLocation().getChunk().load();
                teleportDelay(consumer,consumer.getWorld().getSpawnLocation());
                return;
            }
        }
    }


    private void teleportDelay(Player target,Location location){
        Bukkit.getScheduler().runTaskLater(this,()->{
            target.teleport(location);target.getWorld().playSound(location,Sound.ENTITY_ENDERMAN_TELEPORT,1f,1f);
        },10);
    }

    private void buildRecipe(){
        ShapelessRecipe sr = new ShapelessRecipe(potionKey,buildItem());
        sr.addIngredient(1,Material.POTION);
        sr.addIngredient(1,Material.ENDER_PEARL);
        sr.addIngredient(1,Material.SUGAR);
        sr.addIngredient(1,Material.PAPER);
        getServer().addRecipe(sr);
    }




}
