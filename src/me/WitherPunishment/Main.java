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
			getConfig().addDefault("config.language", "brazilian");
			getConfig().addDefault("punishments.chatViolations.EXC.name", "Example Chat #Name for punishment");
			getConfig().addDefault("punishments.chatViolations.EXC.stname", "EXC #A short name for punishment (lower than 7 chars and unique)");
			getConfig().addDefault("punishments.chatViolations.EXC.severity", "2 #A severity for punishment 1 - 10");
			getConfig().addDefault("punishments.chatViolations.EXC.description", "This is an example #A description for punishment");
			getConfig().addDefault("punishments.gameViolations.EXG.name", "Example Game #Name for punishment");
			getConfig().addDefault("punishments.gameViolations.EXG.stname", "EXC #A short name for punishment (lower than 7 chars and unique)");
			getConfig().addDefault("punishments.gameViolations.EXG.severity", "2 #A severity for punishment 1 - 10");
			getConfig().addDefault("punishments.gameViolations.EXG.description", "This is an example #A description for punishment");
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		if(getConfig().getString("config.language").equalsIgnoreCase("english")) {
			english = true;
		}
		getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment System> " + ChatColor.GREEN + "successfully enabled");
		try {
			getCommand("p").setExecutor(new Punish());
			getCommand("punicoes").setExecutor(new Punish());
			getCommand("pset").setExecutor(new Punish());
			getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Commands> " + ChatColor.GREEN + "successfully registred");
		} catch (Exception e) {
			getServer().getConsoleSender().sendMessage("" + ChatColor.DARK_RED + "WitherPunishment Commands> " + ChatColor.RED + "error registering commands");
		}
		try {
			Bukkit.getPluginManager().registerEvents(new MainPunish(), this);
			Bukkit.getPluginManager().registerEvents(new Chat(), this);
			Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
			getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Events> " + ChatColor.GREEN + "successfully registred");
		} catch (Exception e) {
			getServer().getConsoleSender().sendMessage("" + ChatColor.DARK_RED + "WitherPunishment Events> " + ChatColor.RED + "error registering events");
		}
		try {
			DataManager.createDb();
			c = DataManager.connect();
			getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Datas> " + ChatColor.GREEN + "successfully loaded");
		} catch (Exception e) {
			getServer().getConsoleSender().sendMessage("" + ChatColor.DARK_RED + "WitherPunishment Datas> " + ChatColor.RED + "error loading database");
		}
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
