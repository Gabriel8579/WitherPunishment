package me.WitherPunishment.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.WitherPunishment.Main;
import me.WitherPunishment.inventories.MainPunish;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Chat implements Listener{
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) throws SQLException {
		Player p = e.getPlayer();
			if(isMuted(p)) {
				e.setCancelled(true);
				p.sendMessage("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você não pode falar pois recebeu uma " + ChatColor.RED + "punição " + ChatColor.GOLD + "que proíbe o uso do chat. " + ChatColor.GRAY + "Use " + ChatColor.YELLOW + "/punicoes " + ChatColor.GRAY + "para mais informações.");
				return;
			}
		if(MainPunish.emwarn.contains(p.getName())) {
			if(!e.getMessage().equalsIgnoreCase("entendi")) {
				e.setCancelled(true);
				p.sendMessage(MainPunish.getLastWarn(p.getName()));
				return;
			}
			p.sendMessage("" + ChatColor.BLUE + "Punição> " + ChatColor.GRAY + "Ok, cuidado para não quebrar as regras novamente. Você já pode se comunicar.");
			MainPunish.emwarn.remove(p.getName());
			e.setCancelled(true);
			return;
		}		
		if(MainPunish.emprova.contains(p.getName())) {
			e.setCancelled(true);
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				MainPunish.reabrirInv(p);
				MainPunish.emprova.remove(p.getName());
			} else if(e.getMessage().toLowerCase().startsWith("http://") || (e.getMessage().toLowerCase().startsWith("https://"))) {
				MainPunish.provaa = e.getMessage();
				MainPunish.reabrirInv(p);
				MainPunish.emprova.remove(p.getName());
			} else {
				p.sendMessage("" + ChatColor.BLUE + "Punir> " + ChatColor.GRAY + "A prova precisa ser um link, você pode cancelar digitando 'cancelar'");
			}
			return;
		}	
		if(MainPunish.eprova.contains(p.getName())) {
			e.setCancelled(true);
			if(e.getMessage().equalsIgnoreCase("cancelar")) {
				MainPunish.reabrirInv(p);
				MainPunish.eprova.remove(p.getName());
			} else if(e.getMessage().toLowerCase().startsWith("http://") || (e.getMessage().toLowerCase().startsWith("https://"))) {
				MainPunish.provaa = e.getMessage();
				MainPunish.editPunish(p, MainPunish.editando.get(p.getName()));
				MainPunish.eprova.remove(p.getName());
			} else {
				p.sendMessage("" + ChatColor.BLUE + "Editar Punição> " + ChatColor.GRAY + "A prova precisa ser um link, você pode cancelar digitando 'cancelar'");
			}
			return;
		}	
		e.setFormat("" + ChatColor.YELLOW + "" + p.getName() + "" + ChatColor.BLUE + " >> " + ChatColor.WHITE + "" + e.getMessage());
		if(!p.hasPermission("punish.chat.punish")) {
			TextComponent punir = new TextComponent("" + ChatColor.DARK_RED + "[Punir]");
			TextComponent traco = new TextComponent(" " + ChatColor.GOLD + "- ");
			TextComponent format = new TextComponent(e.getFormat());
			ClickEvent cv = new ClickEvent(Action.RUN_COMMAND, "/punir " + e.getPlayer().getName() + " chat");
			HoverEvent hv = new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Clique aqui para punir " + ChatColor.AQUA + p.getName() + ChatColor.WHITE + " em flagrante \npor uma violação de chat").create());
			punir.setClickEvent(cv);
			punir.setHoverEvent(hv);
			e.setCancelled(true);
			for(Player s : Bukkit.getOnlinePlayers()) {
				if(s.hasPermission("punish.chat.punish")) {
					s.spigot().sendMessage(format, traco, punir);
				} else {
					s.sendMessage(e.getFormat());
				}
			}
		}

	}
	public static boolean isMuted(Player p) {
		try {
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p.getName() + "' AND Modo=1 AND Fim > " + System.currentTimeMillis() + ";");
		while(res.next()) {
			if(!res.getBoolean("Cancelado")) {
				return true;
			}
			s.execute("UPDATE punish SET Cancelado=1, CancelBy='Sistema' WHERE id=" + res.getInt("id") + ";");
		}	
		res.close();
		ResultSet res2 = s.executeQuery("SELECT * FROM punish WHERE Nome='" + p.getName() + "' AND Modo=1 AND Fim = -1 AND Sev = 10;");
		while(res2.next()) {
			if(!res2.getBoolean("Cancelado")) {
				return true;
			}
			s.execute("UPDATE punish SET Cancelado=1, CancelBy='Sistema' WHERE id=" + res.getInt("id") + ";");
		}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
