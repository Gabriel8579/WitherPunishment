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
		if(cmd.getName().equalsIgnoreCase("pset")) {
			if(!(sender instanceof Player)) {
				if(args.length < 2) {
					if(Main.english) {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					}
					return true;
				}
				if(args[0].equalsIgnoreCase("language")) {
					if(args[1].equalsIgnoreCase("brazilian")) {
						Main.pl.getConfig().set("config.language", "brazilian");
						Main.english = false;
						Main.pl.saveConfig();
						sender.sendMessage(ChatColor.BLUE + "Punishment Set> " + ChatColor.GOLD + "Linguagem alterada para portugues brazileiro.");
					} else if(args[1].equalsIgnoreCase("english")) {
						Main.pl.getConfig().set("config.language", "english");
						Main.english = true;
						Main.pl.saveConfig();
						sender.sendMessage(ChatColor.BLUE + "Punishment Set> " + ChatColor.GOLD + "Language changed to english.");
					} else {
						if(Main.english) {
							sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
						}
						return true;
					}
				} else {
					if(Main.english) {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					}
					return true;
				}
			}
			if(sender.hasPermission("punish.command.pset")) {
				if(args.length < 2) {
					if(Main.english) {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					}
					return true;
				}
				if(args[0].equalsIgnoreCase("language")) {
					if(args[1].equalsIgnoreCase("brazilian")) {
						Main.pl.getConfig().set("config.language", "brazilian");
						Main.english = false;
						Main.pl.saveConfig();
						sender.sendMessage(ChatColor.BLUE + "Punishment Set> " + ChatColor.GOLD + "Linguagem alterada para portugues brazileiro.");
					} else if(args[1].equalsIgnoreCase("english")) {
						Main.pl.getConfig().set("config.language", "english");
						Main.english = true;
						Main.pl.saveConfig();
						sender.sendMessage(ChatColor.BLUE + "Punishment Set> " + ChatColor.GOLD + "Language changed to english.");
					} else {
						if(Main.english) {
							sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
						}
						return true;
					}
				} else {
					if(Main.english) {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Correct usage: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "Punishment Set> " + ChatColor.RED + "Uso correto: " + ChatColor.GOLD + " /pset language [brazilian/english]");
					}
					return true;
				}
			} else {
				if(Main.english) {
					sender.sendMessage(ChatColor.DARK_RED + "Permissions> " + ChatColor.RED + "You can't run this command.");
					return false;
				}
				sender.sendMessage(ChatColor.DARK_RED + "Permissões> " + ChatColor.RED + "Você não pode utilizar este comando.");
				return false;
			}
		}
		if(cmd.getName().equalsIgnoreCase("p") || cmd.getName().equalsIgnoreCase("punir")) {
			if(!(sender instanceof Player)) {
				if(Main.english) {
					sender.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "You need be in game!");
					return false;
				}
				sender.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você precisa estar no jogo!");
				return false;
			}
			Player p = (Player)sender;
			if(!p.hasPermission("punish.command.p")) {
				if(args.length == 2 && args[1].equalsIgnoreCase("pdev")) {
					String pun = args[0];
					try {
						MainPunish.openPrimaryPunish(p, pun);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return false;
				}
				if(Main.english) {
					p.sendMessage(ChatColor.DARK_RED + "Permissions> " + ChatColor.RED + "You can't run this command.");
					return false;
				}
				p.sendMessage(ChatColor.DARK_RED + "Permissões> " + ChatColor.RED + "Você não pode utilizar este comando.");
				return false;
			}
			if(args.length != 1) {
				if(args.length == 2 && args[1].equalsIgnoreCase("chat")) { 
					if(Bukkit.getPlayer(args[0]) instanceof Player) {
						Player s = Bukkit.getPlayer(args[0]);
						if(s.hasPermission("punish.staff") && (!s.getName().equalsIgnoreCase("Gabriel8579"))) {
							if(Main.english) {
								p.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "You can't punish a staff member!");
								return true;
							}
							p.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você não pode punir um membro da equipe!");
							return true;
						}
					}
					MainPunish.openTPunish(p, args[0], true);
					MainPunish.punish.put(p.getName(), args[0]);
					return true;
				}
				if(Main.english) {
					p.sendMessage(ChatColor.BLUE + "Punish> " + ChatColor.GRAY + "Correct use (/p)unish [nickname]");
					return false;
				}
				p.sendMessage(ChatColor.BLUE + "Punir> " + ChatColor.GRAY + "Use (/p)unir [nick]");
				return false;
			}
			
			String punido = args[0];
			try {
				Statement st = Main.c.createStatement();
				ResultSet res = st.executeQuery("SELECT * FROM users WHERE Nome = '" + args[0] + "';");
				if(!res.next()) {
					if(Main.english) {
						p.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "No players were found with the following name: " + args[0]);
						return true;
					}
					p.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Nenhum jogador foi encontrado com este nome: " + args[0]);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				MainPunish.openPrimaryPunish(p, punido);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        }	
		if(cmd.getName().equalsIgnoreCase("punicoes")) {
			if(!(sender instanceof Player)) {
				if(Main.english) {
					sender.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "You need be in game!");
					return false;
				}
				sender.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Você precisa estar no jogo!");
				return false;
			}
			Player p = (Player)sender;
			try {
				Statement s = Main.c.createStatement();
				Statement s2 = Main.c.createStatement();
				ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p.getName() + "';");
				ResultSet res2 = s2.executeQuery("SELECT COUNT(*) AS total FROM punish WHERE Nome='" + p.getName() + "';");
				if(Main.english) {
					p.sendMessage(ChatColor.BLUE + "Punishments> " + ChatColor.GRAY + "Showing your punishments:");
				} else {
					p.sendMessage(ChatColor.BLUE + "Punições> " + ChatColor.GRAY + "Mostrando sua lista de punições:");
				}
				if(res2.next() && res2.getInt("total") >= 0) {
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Punishments> " + ChatColor.RED + "You received a total of " + ChatColor.DARK_RED + res2.getInt("total") + ChatColor.RED + " punishments!");
					} else {
						p.sendMessage(ChatColor.BLUE + "Punições> " + ChatColor.RED + "Você recebeu um total de " + ChatColor.DARK_RED + res2.getInt("total") + ChatColor.RED + " punições!");
					}
				}
				while(res.next()) {
					Date d = new Date(res.getLong("Inicio"));
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					TextComponent hover = new TextComponent(ChatColor.WHITE + sd.format(d) + ": " + ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")));
					HoverEvent h = null;
					String flag = "";
					if(res.getBoolean("Tipo")) {
						if(Main.english) {
							flag = ChatColor.AQUA + "in act";
						} else {
							flag = ChatColor.AQUA + "em flagrante";
						}	
					} else {
						if(Main.english) {
							flag = ChatColor.GOLD + "by report";
						} else {
							flag = ChatColor.GOLD + "por denúncia";
						}	
					}
					String jogo = "";
					if(Main.english) {
						jogo = "muted";
					} else {
						jogo = "calado";
					}
					if(res.getInt("Modo") == 2) {
						if(Main.english) {
							jogo = "banned";
						} else {
							jogo = "banido";
						}
					}
					if(res.getInt("Sev") < 10 && res.getInt("Sev") > 2) { 
						if(Main.english) {
							h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been " + jogo + " for " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " \n" + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.GOLD + "until " + ChatColor.RED + sd.format(new Date(res.getLong("Fim"))) + " " + ChatColor.YELLOW + "(" + MainPunish.getRemaing(res.getLong("Fim")) + ") " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						} else {
						 h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi " + jogo + " por " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " \n" + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.GOLD + "até " + ChatColor.RED + sd.format(new Date(res.getLong("Fim"))) + " " + ChatColor.YELLOW + "(" + MainPunish.getRemaing(res.getLong("Fim")) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						}
					}
					if(res.getInt("Sev") < 3) {
						if(Main.english) {
							h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been warned for " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + flag + " " + ChatColor.GOLD + "with this proof:\n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						} else {
							h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + flag + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						}
					}
					if(res.getInt("Sev") == 10) {
						if(Main.english) {
							h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been muted for " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.RED + "forever " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						} else {
							h = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc")).create());
						}
					}
					hover.setHoverEvent(h);
					p.spigot().sendMessage(hover);
				}
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

}
