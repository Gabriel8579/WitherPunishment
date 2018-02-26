package me.WitherPunishment.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;

import me.WitherPunishment.Main;
import me.WitherPunishment.inventories.MainPunish;

@SuppressWarnings("deprecation")
public class JoinQuit implements Listener{
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		try {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM users WHERE UUID = '" + p.getUniqueId() + "';");	
			if(!res.next()) {
				s.execute("INSERT INTO users (id, Nome, UUID, IP) VALUES (NULL, '" + p.getName() + "', '" + p.getUniqueId() + "', '" + p.getAddress().getHostString() + "');");
				Main.pl.getServer().getConsoleSender().sendMessage("" + ChatColor.BLUE + "WitherPunishment Info> " + ChatColor.GREEN + "successfully registred user " + ChatColor.AQUA + "" + p.getName());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPreLogin(PlayerPreLoginEvent e)throws SQLException {
		String p = e.getName();
		if(isBanned(p) != 0) {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM punish WHERE id=" + isBanned(p) + ";");
			if(!res.next()) {
				e.allow();
			} else {
				String flag = "";
				if(res.getBoolean("Tipo")) {
					if(Main.english) {
						flag = ChatColor.AQUA + "in act";
					} else {
						flag = ChatColor.AQUA + "em flagrante";
					}	
				} else {
					if(Main.english) {
						flag = ChatColor.AQUA + "by report";
					} else {
						flag = ChatColor.AQUA + "por denúncia";
					}	
				}
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				if(res.getInt("Sev") > 2 && res.getInt("Sev") != 10) {
					if(Main.english) {
						e.disallow(Result.KICK_OTHER, ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been banned for " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " \n" + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.GOLD + "until " + ChatColor.RED + sd.format(new Date(res.getLong("Fim"))) + " " + ChatColor.YELLOW + "(" + MainPunish.getRemaing(res.getLong("Fim")) + ") " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc"));
					}
					e.disallow(Result.KICK_OTHER, ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " \n" + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.GOLD + "até " + ChatColor.RED + sd.format(new Date(res.getLong("Fim"))) + " " + ChatColor.YELLOW + "(" + MainPunish.getRemaing(res.getLong("Fim")) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc"));
					return;
				}
				if(res.getInt("Sev") < 3) {
					e.allow();
					return;
				}
				if(res.getInt("Sev") == 10) {
					if(Main.english) {
						e.disallow(Result.KICK_OTHER, ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been banned for " + ChatColor.RED + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.RED + "forever " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc"));
						return;
					}
					e.disallow(Result.KICK_OTHER, ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + "" + MainPunish.getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + res.getString("Sigla").toUpperCase() + "#" + res.getInt("id") + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + res.getString("Prova") + " \n" + ChatColor.YELLOW + "" + res.getString("Desc"));
					return;
				}
			}
			return;
		}
	}
	
	public static int isBanned(String p) {
		try {
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p + "' AND Modo=2 AND Fim > " + System.currentTimeMillis() + ";");
		while(res.next()) {
			if(!res.getBoolean("Cancelado")) {
				return res.getInt("id");
			}
			s.execute("UPDATE punish SET Cancelado=1, CancelBy=1 WHERE id=" + res.getInt("id") + ";");
			return 0;
		}	
		res.close();
		ResultSet res2 = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p + "' AND Modo=2 AND Fim = -1 AND Sev = 10;");
		while(res2.next()) {
			if(!res2.getBoolean("Cancelado")) {
				return res.getInt("id");
			}
			s.execute("UPDATE punish SET Cancelado=1, CancelBy=1 WHERE id=" + res.getInt("id") + ";");
			return 0;
		}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
