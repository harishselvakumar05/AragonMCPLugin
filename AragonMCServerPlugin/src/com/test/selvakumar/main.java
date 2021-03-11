package com.test.selvakumar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin {

	
    @Override
    public void onEnable() {  
    	getServer().getPluginManager().registerEvents(new MatchCommands(this), this);
    	getCommand("startmatch").setExecutor(new MatchCommands(this));    	
    	for(Player player : Bukkit.getOnlinePlayers()) {
    		player.getInventory().clear();
    	//	player.setGameMode(GameMode.ADVENTURE);  		
    	}
      	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "enabled"); 
    }
    

 
    @Override
    public void onDisable() {
    	Bukkit.getPluginManager().disablePlugin(this);
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "disabled");
    }

}