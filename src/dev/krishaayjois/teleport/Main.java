package dev.krishaayjois.teleport;

// Bukkit Plugins
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){

    }

    @Override
    public void onDisable(){

    }
    public boolean onCommand(CommandSender sender , Command cmd , String label , String[] args){
        if(label.equalsIgnoreCase("move") || label.equalsIgnoreCase("mv")){
            if(!(sender instanceof Player)){
                sender.sendMessage("Console can fly?");
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please mention a player to teleport to");
                return true;
            }
            String targetPlayerUsername = args[0];
            Player targetPlayer = Bukkit.getServer().getPlayer(targetPlayerUsername);
            player.teleport(targetPlayer);
            player.sendMessage(ChatColor.GREEN + "Teleported to " + targetPlayerUsername);
            targetPlayer.sendMessage(ChatColor.YELLOW + player.getName() + " teleported to you");
            return true;
        }
        return false;
    }

}