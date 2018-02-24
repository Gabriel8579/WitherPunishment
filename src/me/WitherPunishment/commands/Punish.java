package me.WitherPunishment.commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.WitherPunishment.Main;
import me.WitherPunishment.inventories.MainPunish;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Punish implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("p") || cmd.getName().equalsIgnoreCase("punir")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você precisa estar no jogo!");
				return false;
			}
			Player p = (Player)sender;
			if(!p.hasPermission("punish.command.p")) {
				p.sendMessage("" + ChatColor.BLUE + "Permissões> " + ChatColor.GRAY + "Você precisa ser um [" + ChatColor.YELLOW + "MODERADOR" + ChatColor.GRAY + "] para utilizar este comando.");
				return false;
			}
			if(args.length != 1) {
				if(args.length == 2 && args[1].equalsIgnoreCase("chat")) { 
					if(Bukkit.getPlayer(args[0]) instanceof Player) {
						Player s = Bukkit.getPlayer(args[0]);
						if(s.hasPermission("punish.staff") && (!s.getName().equalsIgnoreCase("Gabriel8579"))) {
							p.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você não pode punir um membro da equipe!");
							return true;
						}
					}
					MainPunish.openTPunish(p, args[0], true);
					MainPunish.punish.put(p.getName(), args[0]);
					return true;
				}
				p.sendMessage("" + ChatColor.BLUE + "Punir> " + ChatColor.GRAY + "use (/p)unir [nome]");
				return false;
			}
			
			String punido = args[0];
			try {
				Statement st = Main.c.createStatement();
				ResultSet res = st.executeQuery("SELECT * FROM users WHERE Nome = '" + args[0] + "';");
				if(!res.next()) {
					p.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Nenhum jogador foi encontrado com este nome: " + args[0]);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(Bukkit.getPlayer(punido) instanceof Player) {
				Player s = Bukkit.getPlayer(punido);
				if(s.hasPermission("punish.staff") && (!s.getName().equalsIgnoreCase("Gabriel8579"))) {
					p.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você não pode punir um membro da equipe!");
					return true;
				}
			}
			try {
				MainPunish.openPrimaryPunish(p, punido);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }	
		if(cmd.getName().equalsIgnoreCase("punicoes")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você precisa estar no jogo!");
				return false;
			}
			Player p = (Player)sender;
			try {
				Statement s = Main.c.createStatement();
				ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p.getName() + "';");
				p.sendMessage("" + ChatColor.BLUE + "Punições> " + ChatColor.GRAY + "Mostrando sua lista de punições:");
				while(res.next()) {
					Date d = new Date(res.getLong("Inicio"));
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					TextComponent hover = new TextComponent("" + ChatColor.WHITE + "" + sd.format(d) + ": " + ChatColor.DARK_RED + "" + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")));
					HoverEvent h = null;
					String flag = "";
					if(res.getBoolean("Tipo")) {
						flag = "§bem flagrante";
					} else {
						flag = "" + ChatColor.GOLD + "por denúncia";
					}
					String jogo = "calado";
					if(res.getInt("Modo") == 2) {
						jogo = "banido";
					}
					if(res.getInt("Sev") < 10 && res.getInt("Sev") > 2) { 
						 h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi " + jogo + " por " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")) + " \n" + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.GOLD + "até " + ChatColor.RED + "" + sd.format(new Date(res.getLong("Fim"))) + " BRT " + ChatColor.YELLOW + "(" + MainPunish.getRemaing(res.getLong("Fim")) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + res.getString("Prova") + " \n" + ChatColor.YELLOW + "" + res.getString("Desc")).create());
					}
					if(res.getInt("Sev") < 3) {
						 h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + flag + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + "" + res.getString("Prova") + " \n" + ChatColor.YELLOW + "" + res.getString("Desc")).create());
					}
					if(res.getInt("Sev") == 10) {
						 h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + res.getString("Prova") + " \n" + ChatColor.YELLOW + "" + res.getString("Desc")).create());
					}
					hover.setHoverEvent(h);
					p.spigot().sendMessage(hover);
				}
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

}
