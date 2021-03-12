package com.test.selvakumar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
//TEST

public class main extends JavaPlugin {


	@Override
	public void onEnable() {  
		getServer().getPluginManager().registerEvents(new MatchCommands(this), this);
		getCommand("startmatch").setExecutor(new MatchCommands(this));
		if(!Bukkit.getOnlinePlayers().isEmpty()) {
			for(Player player : Bukkit.getOnlinePlayers()) {
				player.getInventory().clear();
				//	player.setGameMode(GameMode.ADVENTURE);
				
				BoardPlayer boardplayer = new BoardPlayer(player, 0);
				MatchCommands.LeaderBoardPlayers.add(boardplayer);
				MatchCommands.createBoard(player);
			}
		}
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "enabled"); 
	}


 
    @Override
    public void onDisable() {
    	Bukkit.getPluginManager().disablePlugin(this);
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "disabled");
    }

}
