package me.WitherPunishment;


import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.WitherPunishment.commands.Punish;
import me.WitherPunishment.events.Chat;
import me.WitherPunishment.events.JoinQuit;
import me.WitherPunishment.inventories.MainPunish;
import me.WitherPunishment.punish.DataManager;

public class Main extends JavaPlugin{
	
	public static Main pl = null;	
	
	public static Connection c = null;
	public static boolean english = false;
	@Override
	public void onEnable() {	
		pl = this;
		File f = new File(getDataFolder() + "/config.yml");
		if(!f.exists()) {
			getConfig().addDefault("punishments.chatViolations.EXC.name", "");
			getConfig().addDefault("punishments.chatViolations.EXC.stname", "");
			getConfig().addDefault("punishments.chatViolations.EXC.severity", "");
			getConfig().addDefault("punishments.chatViolations.EXC.description", "");
			getConfig().addDefault("punishments.gameViolations.EXG.name", "");
			getConfig().addDefault("punishments.gameViolations.EXG.stname", "");
			getConfig().addDefault("punishments.gameViolations.EXG.severity", "");
			getConfig().addDefault("punishments.gameViolations.EXG.description", "");
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment System> " + ChatColor.GREEN + "successfully enabled");
		getCommand("p").setExecutor(new Punish());
		getCommand("punicoes").setExecutor(new Punish());
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Commands> " + ChatColor.GREEN + "successfully registred");
		Bukkit.getPluginManager().registerEvents(new MainPunish(), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Events> " + ChatColor.GREEN + "successfully registred");
		DataManager.createDb();
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Datas> " + ChatColor.GREEN + "successfully loaded");
		c = DataManager.connect();
	}
	
	
	@Override
	public void onDisable() {
		pl = null;
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		c = null;
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment All> " + ChatColor.GREEN + "successfully disabled");
	}

}
