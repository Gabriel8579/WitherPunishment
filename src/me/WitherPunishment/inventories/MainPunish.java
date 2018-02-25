package me.WitherPunishment.inventories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.WitherPunishment.Main;
import me.WitherPunishment.punish.ScrollerInventory;


public class MainPunish implements Listener{
	
	public static Map<String, String> punish = new HashMap<String, String>();
	public static Map<String, Integer> editando = new HashMap<String,Integer>();
	public static List<String> emprova = new ArrayList<String>();
	public static List<String> eprova = new ArrayList<String>();
	public static List<String> emwarn = new ArrayList<String>();
	public static boolean flagra = false;
	public static boolean flpun = false;
	
	public static ItemStack cabeca;
	public static SkullMeta cabecam;
	public static ItemStack papel;
	public static ItemMeta papelm;
	public static ItemStack ejec;
	public static ItemMeta ejecm;
	public static ItemStack livro;
	public static ItemMeta livrom;
	public static ItemStack esp;
	public static ItemMeta espm;
	public static ItemStack flagr;
	public static ItemMeta flagrm;
	public static ItemStack denun;
	public static ItemMeta denunm;
	public static ItemStack prova;
	public static ItemMeta provam;
	public static ItemStack conf;
	public static ItemMeta confm;
	public static ItemStack canc;
	public static ItemMeta cancm;
	public static ItemStack punicoes;
	public static ItemMeta punicoesm;
	public static ItemStack pjogo;
	public static ItemMeta pjogom;
	public static ItemStack pchat;
	public static ItemMeta pchatm;
	public static ItemStack tpun;
	public static ItemMeta tpunm;
	public static ItemStack spun;
	public static ItemMeta spunm;
	public static ItemStack sepun;
	public static ItemMeta sepunm;
	public static ItemStack cpun;
	public static ItemMeta cpunm;
	public static ItemStack ppun;
	public static ItemMeta ppunm;
	public static ItemStack fpun;
	public static ItemMeta fpunm;
	public static ItemStack sair;
	public static ItemMeta sairm;
	public static ItemStack sev1;
	public static ItemMeta sev1m;
	public static ItemStack sev2;
	public static ItemMeta sev2m;
	public static ItemStack sev3;
	public static ItemMeta sev3m;
	public static ItemStack sev4;
	public static ItemMeta sev4m;
	public static ItemStack sev5;
	public static ItemMeta sev5m;
	public static ItemStack sev6;
	public static ItemMeta sev6m;
	public static ItemStack sev7;
	public static ItemMeta sev7m;
	public static ItemStack sev8;
	public static ItemMeta sev8m;
	public static ItemStack sev9;
	public static ItemMeta sev9m;
	public static ItemStack sev10;
	public static ItemMeta sev10m;
	public static ItemStack excluir;
	public static ItemMeta excluirm;
	
	public static int seve;
	public static String provaa;
	public static String sigla;
	public static String descr;
	public static String tip;
	public static String fla = "";
	
	@SuppressWarnings("deprecation")
	public static void openPrimaryPunish(Player punisher, String punished) throws SQLException {
			if(punish.containsKey(punisher.getName())) {
				punish.remove(punisher.getName());
			}
			punish.put(punisher.getName(), punished);
			seve = 0;
			sigla = "";
			descr = "";
			tip = "";
			provaa = "";
			String ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished;
			if(Main.english) {
				ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + punished;
			}
			Inventory inv = Bukkit.createInventory(null, 9*3, ninv);
			
			cabeca = new ItemStack(397, 1, (short) 3);
		    cabecam = (SkullMeta) cabeca.getItemMeta();
		    List<String> desccab = new ArrayList<String>();
		    if(Main.english) {
		    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + ChatColor.RED + "Choose the punishment mode");
		    	cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punish: "+punished);
		    } else {
		    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Escolha o modo de punição");
		    	cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
		    }
		    cabecam.setOwner(punished);
		    cabecam.setLore(desccab);
		    cabeca.setItemMeta(cabecam);
		    
		    papel = new ItemStack(Material.PAPER);
		    papelm = papel.getItemMeta();
		    List<String> descpapel = new ArrayList<String>();
		    if(Main.english) {
		    	descpapel.add("" + ChatColor.AQUA + "Punishment mode: " + ChatColor.YELLOW + "Report");
			    descpapel.add("");
			    descpapel.add("" + ChatColor.GRAY + "Choose this mode to punish");
			    descpapel.add("" + ChatColor.GRAY + "the player " + ChatColor.RED + "" + punished);
			    descpapel.add("" + ChatColor.GRAY + "based on a report.");
			    descpapel.add("");
			    descpapel.add("" + ChatColor.DARK_RED + "A proof need be attached!");
			    papelm.setDisplayName(ChatColor.DARK_GRAY + "Punish based on a " + ChatColor.YELLOW + "REPORT");
		    } else {
		    	descpapel.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Denúncia");
			    descpapel.add("");
			    descpapel.add("" + ChatColor.GRAY + "Escolha este modo para punir");
			    descpapel.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
			    descpapel.add("" + ChatColor.GRAY + "com base em uma denúncia.");
			    descpapel.add("");
			    descpapel.add("" + ChatColor.DARK_RED + "Uma prova deverá ser anexada!");
			    papelm.setDisplayName(ChatColor.DARK_GRAY + "Punir com base em " + ChatColor.YELLOW + "DENUNCIA");
		    }
		    papelm.setLore(descpapel);
		    papel.setItemMeta(papelm);
		    
		    ejec = new ItemStack(Material.DISPENSER);
		    ejecm = ejec.getItemMeta();
		    List<String> descejec = new ArrayList<String>();
		    if(Main.english) {
		    	descejec.add("" + ChatColor.AQUA + "Punishment mode: " + ChatColor.YELLOW + "In act");
			    descejec.add("");
			    descejec.add("" + ChatColor.GRAY + "Choose this mode to punish");
			    descejec.add("" + ChatColor.GRAY + "the player " + ChatColor.RED + "" + punished);
			    descejec.add("" + ChatColor.GRAY + "in act");
			    descejec.add("");
			    descejec.add("" + ChatColor.DARK_RED + "A proof can be attached later!");
			    ejecm.setDisplayName(ChatColor.DARK_GRAY + "Punish " + ChatColor.YELLOW + "IN ACT");
		    } else {
		    	descejec.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Flagrante");
			    descejec.add("");
			    descejec.add("" + ChatColor.GRAY + "Escolha este modo para punir");
			    descejec.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
			    descejec.add("" + ChatColor.GRAY + "em flagrante");
			    descejec.add("");
			    descejec.add("" + ChatColor.DARK_RED + "A prova pode ser anexada posteriormente!");
			    ejecm.setDisplayName(ChatColor.DARK_GRAY + "Punir em " + ChatColor.YELLOW + "FLAGRANTE");
		    }
		    ejecm.setLore(descejec);
		    ejec.setItemMeta(ejecm);
		    
		    punicoes = new ItemStack(Material.HOPPER);
		    punicoesm = punicoes.getItemMeta();
		    List<String> descpunicoes = new ArrayList<String>();
		    if(Main.english) {
		    	descpunicoes.add("" + ChatColor.DARK_RED + punished + ChatColor.RED + "'s punishments");
				descpunicoes.add(" ");
				descpunicoes.add("" + ChatColor.WHITE + "Chat Violations: " + ChatColor.YELLOW + getTotal(punished, 1));
				descpunicoes.add("" + ChatColor.WHITE + "Game Violations: " + ChatColor.YELLOW + getTotal(punished, 2));
				descpunicoes.add(" ");
				descpunicoes.add("" + ChatColor.YELLOW + "Click here to edit " + punished + "'s punishments");
				punicoesm.setDisplayName(ChatColor.DARK_RED + punished + ChatColor.RED + "'s past punishments");
		    } else {
		    	descpunicoes.add("" + ChatColor.DARK_RED + "Punições de " + ChatColor.RED + "" + punished);
			    descpunicoes.add(" ");
				descpunicoes.add("" + ChatColor.WHITE + "Violações de Chat: " + ChatColor.YELLOW + "" + getTotal(punished, 1));
				descpunicoes.add("" + ChatColor.WHITE + "Violações de Jogo: " + ChatColor.YELLOW + "" + getTotal(punished, 2));
				descpunicoes.add(" ");
				descpunicoes.add("" + ChatColor.YELLOW + "Clique para editar as punições");
				punicoesm.setDisplayName(ChatColor.DARK_GRAY + "Punições passadas de " + ChatColor.RED + "" + punished);
		    } 
		    punicoesm.setLore(descpunicoes);
		    punicoes.setItemMeta(punicoesm);
		    
		    inv.setItem(4, cabeca);
		    inv.setItem(11, papel);
		    inv.setItem(15, ejec);
		    if((getTotal(punished, 1) > 0) || (getTotal(punished, 2) > 0)) {
		    	inv.setItem(22, punicoes);
		    }	    
		    punisher.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void openSecundaryPunish(Player punisher, String punished, boolean inact) {
		String ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished;
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + punished;
		}
		Inventory inv = Bukkit.createInventory(null, 9*3, ninv);
		String flag = "";
		String prova = "";
		if(inact) {
			if(Main.english) {
				flag = "In act";
				prova = "can be attached later!";
			} else {
				flag = "Flagrante";
				prova = "poderá ser anexada posteriormente!";
			}
		} else {
			if(Main.english) {
				flag = "Report";
				prova = "need be attached!";
			} else {
				flag = "Denúncia";
				prova = "deve ser anexada!";
			}
		}
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    if(Main.english) {
	    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + ChatColor.RED + "Choose the punishment type");
		    desccab.add("");
		    desccab.add("" + ChatColor.WHITE + "Punishment mode: " + ChatColor.YELLOW + flag);
		    cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punish: "+punished);
	    } else {
	    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Escolha o tipo de punição");
		    desccab.add("");
		    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + flag);
		    cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
	    }   
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    livro = new ItemStack(Material.BOOK_AND_QUILL);
	    livrom = livro.getItemMeta();
	    List<String> descpapel = new ArrayList<String>();
	    if(Main.english) {
	    	descpapel.add("" + ChatColor.AQUA + "Punishment Type: " + ChatColor.YELLOW + "Chat Violations");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.GRAY + "Choose this type to punish");
		    descpapel.add("" + ChatColor.GRAY + "the player " + ChatColor.RED + punished);
		    descpapel.add("" + ChatColor.GRAY + "based on a chat violation");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.DARK_RED + "A proof " + prova);
		    livrom.setDisplayName(ChatColor.DARK_GRAY + "Chat Violation");
	    } else {
	    	descpapel.add("" + ChatColor.AQUA + "Tipo de Punição: " + ChatColor.YELLOW + "Violações de Chat");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.GRAY + "Escolha este tipo para punir");
		    descpapel.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
		    descpapel.add("" + ChatColor.GRAY + "com base em uma violação de chat");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
		    livrom.setDisplayName(ChatColor.DARK_GRAY + "Violação de Chat");
	    }
	    livrom.setLore(descpapel);
	    livro.setItemMeta(livrom);
	    
	    esp = new ItemStack(Material.DIAMOND_SWORD);
	    espm = esp.getItemMeta();
	    List<String> descejec = new ArrayList<String>();
	    if(Main.english) {
	    	descejec.add("" + ChatColor.AQUA + "Punishment Type: " + ChatColor.YELLOW + "Game Violations");
	 	    descejec.add("");
	 	    descejec.add("" + ChatColor.GRAY + "Choose this type to punish");
	 	    descejec.add("" + ChatColor.GRAY + "the player " + ChatColor.RED + punished);
	 	    descejec.add("" + ChatColor.GRAY + "based on a game violation");
	 	    descejec.add("");
	 	    descejec.add("" + ChatColor.DARK_RED + "A proof " + prova);
	 	    espm.setDisplayName(ChatColor.DARK_GRAY + "Game Violation");
	    } else {
	    	descejec.add("" + ChatColor.AQUA + "Tipo de Punição: " + ChatColor.YELLOW + "Violações de Jogo");
	 	    descejec.add("");
	 	    descejec.add("" + ChatColor.GRAY + "Escolha este tipo para punir");
	 	    descejec.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
	 	    descejec.add("" + ChatColor.GRAY + "com base em uma violação de jogo");
	 	    descejec.add("");
	 	    descejec.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	 	    espm.setDisplayName(ChatColor.DARK_GRAY + "Violação de Jogo");
	    }
	    espm.setLore(descejec);
	    esp.setItemMeta(espm);
	    
	    inv.setItem(4, cabeca);
	    inv.setItem(11, livro);
	    inv.setItem(15, esp);
	    
	    punisher.openInventory(inv);
	}
	
	public static void openTPunish(Player punisher, String punished, boolean inact) {
		flagra = inact;
		String prova = "";
		if(inact) {
			if(Main.english) {
				prova = "can be attached later!";
			} else {
				prova = "poderá ser anexada posteriormente!";
			}
		} else {
			if(Main.english) {
				prova = "need be attached!";
			} else {
				prova = "deve ser anexada!";
			}
		}
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.chatViolations");
		if(Main.pl.getConfig().get("punishments.chatViolations") == null) {
			punisher.closeInventory();
			if(Main.english) {
				punisher.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "No chat violations configured");
				return;
			}
			punisher.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Não foram encontradas violações de chat configuradas");
			return;
		}
		for(String s : c.getKeys(false)) {
			ItemStack chat = new ItemStack(Material.NETHER_STAR);
			ItemMeta chatm = chat.getItemMeta();
			List<String> descchat = new ArrayList<String>();
			if(Main.english) {
				descchat.add(ChatColor.AQUA + "Description");
				descchat.add("");
				descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
				descchat.add("");
				descchat.add(ChatColor.WHITE + "Severity: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
				descchat.add("");
				descchat.add(ChatColor.DARK_RED + "A proof " + prova);
			} else {
				descchat.add(ChatColor.AQUA + "Descrição");
				descchat.add("");
				descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
				descchat.add("");
				descchat.add(ChatColor.WHITE + "Severidade: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
				descchat.add("");
				descchat.add(ChatColor.DARK_RED + "Uma prova " + prova);
			}
			chatm.setLore(descchat);
			chatm.setDisplayName(ChatColor.DARK_GRAY + c.getString(s + ".stname") + " - " + c.getString(s + ".name"));
			chat.setItemMeta(chatm);
			items.add(chat);
		}
		String ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished;
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + punished;
		}
		new ScrollerInventory(items, ninv, punisher);
	}
	
	
	public static void openTPunishJ(Player punisher, String punished, boolean inact) {
		String prova = "";
		if(inact) {
			if(Main.english) {
				prova = "can be attached later!";
			} else {
				prova = "poderá ser anexada posteriormente!";
			}
		} else {
			if(Main.english) {
				prova = "need be attached!";
			} else {
				prova = "deve ser anexada!";
			}
		}
		
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.gameViolations");
		if(Main.pl.getConfig().get("punishments.gameViolations") == null) {
			punisher.closeInventory();
			if(Main.english) {
				punisher.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "No game violations configured");
				return;
			}
			punisher.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Não foram encontradas violações de jogo configuradas");
			return;
		}
		for(String s : c.getKeys(false)) {
			ItemStack chat = new ItemStack(Material.NETHER_STAR);
			ItemMeta chatm = chat.getItemMeta();
			List<String> descchat = new ArrayList<String>();
			if(Main.english) {
				descchat.add(ChatColor.AQUA + "Description");
				descchat.add("");
				descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
				descchat.add("");
				descchat.add(ChatColor.WHITE + "Severity: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
				descchat.add("");
				descchat.add(ChatColor.DARK_RED + "A proof " + prova);
			} else {
				descchat.add(ChatColor.AQUA + "Descrição");
				descchat.add("");
				descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
				descchat.add("");
				descchat.add(ChatColor.WHITE + "Severidade: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
				descchat.add("");
				descchat.add(ChatColor.DARK_RED + "Uma prova " + prova);
			}
			chatm.setLore(descchat);
			chatm.setDisplayName(ChatColor.DARK_GRAY + c.getString(s + ".stname") + " - " + c.getString(s + ".name"));
			chat.setItemMeta(chatm);
			items.add(chat);
		}
		String ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished;
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + punished;
		}
		new ScrollerInventory(items, ninv, punisher);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void openFPunish(Player punisher, String punished, boolean inact, String tipo,int sev, String sig, String desc) {
		tip = tipo;
		seve = sev;
		sigla = sig;
		descr = desc; 
		String ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished;
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + punished;
		}
		Inventory inv = Bukkit.createInventory(null, 9*5, ninv);
		String flag = "";
		String prova2 = "";
		String sla = "";
		String tipopun = "";
		if((tipo.equalsIgnoreCase("chat") || tipo.equalsIgnoreCase("jogo")) && sev <3) {
			if(Main.english) {
				tipopun = "Warn";
			} else {
				tipopun = "Aviso";
			}
		}
		if(tipo.equalsIgnoreCase("chat") && sev > 2) {
			tipopun = "Mute";
		}
		if(tipo.equalsIgnoreCase("jogo") && sev > 2) {
			tipopun = "Ban";
		}
		if(inact) {
			if(Main.english) {
				flag = "In act";
				sla = "in " + ChatColor.GREEN + "act";
				prova2 = "can be attached later!";
			} else {
				flag = "Flagrante";
				sla = "em " + ChatColor.GREEN + "flagrante";
				prova2 = "poderá ser anexada posteriormente!";
			}
		} else {
			if(Main.english) {
				flag = "Report";
				sla = "based on a " + ChatColor.GREEN + "report";
				prova2 = "need be attached!";
			} else {
				flag = "Denúncia";
				sla = "com base em uma " + ChatColor.GREEN + "denúncia";
				prova2 = "deverá ser anexada!";
			}
		}
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    if(Main.english) {
	    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punish: " + ChatColor.RED + "Review and conclusion");
		    desccab.add("");
		    desccab.add("" + ChatColor.WHITE + "Punishment mode: " + ChatColor.YELLOW + flag);
		    desccab.add("" + ChatColor.WHITE + "Punishment type: " + ChatColor.YELLOW + tipopun);
		    desccab.add("" + ChatColor.WHITE + "Severity: " + ChatColor.YELLOW + "" + sev);
		    if(sev >0 && sev < 3) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "Warn");
		    }
		    if(sev >2 && sev < 5 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "2 hours mute");
		    }
		    if(sev >2 && sev < 5 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "2 hours ban");
		    }
		    if(sev >4 && sev < 8 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "A day mute");
		    }
		    if(sev >4 && sev < 8 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "A day ban");
		    }
		    if(sev >7 && sev < 10 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "A week mute");
		    }
		    if(sev >7 && sev < 10 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "A week ban");
		    }
		    if(sev == 10 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "Forever mute");
		    }
		    if(sev == 10 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.YELLOW + "Forever ban");
		    }
		    cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punish: "+punished);
	    } else {
	    	desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Revisão e conclusão");
		    desccab.add("");
		    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + flag);
		    desccab.add("" + ChatColor.WHITE + "Tipo de punição: " + ChatColor.YELLOW + tipopun);
		    desccab.add("" + ChatColor.WHITE + "Severidade: " + ChatColor.YELLOW + "" + sev);
		    if(sev >0 && sev < 3) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Aviso");
		    }
		    if(sev >2 && sev < 5 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Mute de 2 horas");
		    }
		    if(sev >2 && sev < 5 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Ban de 2 horas");
		    }
		    if(sev >4 && sev < 8 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Mute de 24 horas");
		    }
		    if(sev >4 && sev < 8 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Ban de 24 horas");
		    }
		    if(sev >7 && sev < 10 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Mute de 7 dias");
		    }
		    if(sev >7 && sev < 10 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Ban de 7 dias");
		    }
		    if(sev == 10 && tipo.equalsIgnoreCase("chat")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Mute permanente");
		    }
		    if(sev == 10 && tipo.equalsIgnoreCase("jogo")) {
		    	desccab.add("" + ChatColor.WHITE + "Punição dada: " + ChatColor.YELLOW + "Ban permanente");
		    }
		    cabecam.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
	    }
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    flagr = new ItemStack(Material.DISPENSER);
	    flagrm = flagr.getItemMeta();
	    List<String> descflagr = new ArrayList<String>();
	    if(Main.english) {
	    	descflagr.add("" + ChatColor.AQUA + "Punishment mode: " + ChatColor.YELLOW + "In act");
		    descflagr.add("");
		    descflagr.add("" + ChatColor.GRAY + "You're punishing the player " + ChatColor.RED + punished);
		    descflagr.add("" + ChatColor.GRAY + "in act");
		    descflagr.add("");
		    descflagr.add("" + ChatColor.DARK_RED + "A proof " + prova2);
		    descflagr.add("");
		    descflagr.add("" + ChatColor.YELLOW + "Click to change the mode to " + ChatColor.AQUA + "report");
		    flagrm.setDisplayName(ChatColor.DARK_GRAY + "In act");
	    } else {
	    	descflagr.add("" + ChatColor.AQUA + "Modo de punição: " + ChatColor.YELLOW + "Flagrante");
		    descflagr.add("");
		    descflagr.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + punished);
		    descflagr.add("" + ChatColor.GRAY + "em flagrante");
		    descflagr.add("");
		    descflagr.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
		    descflagr.add("");
		    descflagr.add("" + ChatColor.YELLOW + "Clique para alterar para o modo " + ChatColor.AQUA + "denúncia");
		    flagrm.setDisplayName(ChatColor.DARK_GRAY + "Flagrante");
	    }
	    flagrm.setLore(descflagr);
	    flagr.setItemMeta(flagrm);
	    
	    denun = new ItemStack(Material.PAPER);
	    denunm = denun.getItemMeta();
	    List<String> descdenun = new ArrayList<String>();
	    if(Main.english) {
	    	descdenun.add("" + ChatColor.AQUA + "Punishment mode: " + ChatColor.YELLOW + "Report");
		    descdenun.add("");
		    descdenun.add("" + ChatColor.GRAY + "You're punishing the player " + ChatColor.RED + punished);
		    descdenun.add("" + ChatColor.GRAY + "based on a report");
		    descdenun.add("");
		    descdenun.add("" + ChatColor.DARK_RED + "A proof " + prova2);
		    descdenun.add("");
		    descdenun.add("" + ChatColor.YELLOW + "Click to change the mode to " + ChatColor.AQUA + "in act");
		    denunm.setDisplayName(ChatColor.DARK_GRAY + "Report");
	    } else {
	    	descdenun.add("" + ChatColor.AQUA + "Modo de punição: " + ChatColor.YELLOW + "Denúncia");
		    descdenun.add("");
		    descdenun.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + punished);
		    descdenun.add("" + ChatColor.GRAY + "com base em uma denúncia");
		    descdenun.add("");
		    descdenun.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
		    descdenun.add("");
		    descdenun.add("" + ChatColor.YELLOW + "Clique para alterar para o modo " + ChatColor.AQUA + "flagrante");
		    denunm.setDisplayName(ChatColor.DARK_GRAY + "Denúncia");
	    }
	    
	    denunm.setLore(descdenun);
	    denun.setItemMeta(denunm);
	    
	    prova = new ItemStack(Material.ITEM_FRAME);
	    provam = prova.getItemMeta();
	    List<String> descprova = new ArrayList<String>();
	    if(Main.english) {
	    	descprova.add("" + ChatColor.AQUA + "Proof attachment");
		    descprova.add("");
		    descprova.add("" + ChatColor.GRAY + "You're punishing the player " + ChatColor.RED +  punished);
		    descprova.add("" + ChatColor.GRAY + sla);
		    descprova.add("");
		    descprova.add("" + ChatColor.DARK_RED + "A proof " + prova2);
		    descprova.add("");
		    descprova.add("" + ChatColor.YELLOW + "Click to attach a proof");
		    provam.setDisplayName(ChatColor.DARK_GRAY + "Attach a proof");
	    } else {
	    	descprova.add("" + ChatColor.AQUA + "Anexo de prova");
		    descprova.add("");
		    descprova.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + punished);
		    descprova.add("" + ChatColor.GRAY + sla);
		    descprova.add("");
		    descprova.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
		    descprova.add("");
		    descprova.add("" + ChatColor.YELLOW + "Clique para anexar uma prova");
		    provam.setDisplayName(ChatColor.DARK_GRAY + "Anexar uma Prova");
	    } 
	    provam.setLore(descprova);
	    prova.setItemMeta(provam);
	    
	    conf = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
	    confm = conf.getItemMeta();
	    desccab.add("");
	    if(Main.english) {
	    	desccab.add("" + ChatColor.GREEN + "Click to punish");
	    	confm.setDisplayName(ChatColor.DARK_GRAY + "Clique to punish " + ChatColor.AQUA + punished + " " + ChatColor.DARK_GRAY + sla);
	    } else {
	    	desccab.add("" + ChatColor.GREEN + "Clique para punir");
	    	confm.setDisplayName(ChatColor.DARK_GRAY + "Clique para punir " + ChatColor.AQUA + punished + " " + ChatColor.DARK_GRAY + sla);
	    }
	    confm.setLore(desccab);
	    conf.setItemMeta(confm);
	    
	    canc = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
	    cancm = canc.getItemMeta();
	    List<String> desccanc = new ArrayList<String>();
	    if(Main.english) {
	    	desccanc.add("" + ChatColor.RED + "Click to cancel the punishment and close the inventory");
		    cancm.setDisplayName(ChatColor.DARK_GRAY + "Click to cancel the punishment");
	    } else {
	    	desccanc.add("" + ChatColor.RED + "Clique para cancelar a punição e sair do inventário");
		    cancm.setDisplayName(ChatColor.DARK_GRAY + "Clique para cancelar a punição");
	    }
	    cancm.setLore(desccanc);
	    canc.setItemMeta(cancm);
	    
	    inv.setItem(4, cabeca);
	    inv.setItem(13, prova);
	    if(inact) {
	    	inv.setItem(31, flagr);
	    } else {
	    	inv.setItem(31, denun);
	    }
	    inv.setItem(18, canc);
	    inv.setItem(19, canc);
	    inv.setItem(20, canc);
	    inv.setItem(27, canc);
	    inv.setItem(28, canc);
	    inv.setItem(29, canc);
	    inv.setItem(36, canc);
	    inv.setItem(37, canc);
	    inv.setItem(38, canc);
	    inv.setItem(24, conf);
	    inv.setItem(25, conf);
	    inv.setItem(26, conf);
	    inv.setItem(33, conf);
	    inv.setItem(34, conf);
	    inv.setItem(35, conf);
	    inv.setItem(42, conf);
	    inv.setItem(43, conf);
	    inv.setItem(44, conf);
	    
	    punisher.openInventory(inv);
	}

	@SuppressWarnings("deprecation")
	public static void openEditPunish(Player punisher, String punished) throws SQLException {
		String ninv = "" + ChatColor.DARK_RED + "Punições de: " + ChatColor.RED + punished;
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + punished + ChatColor.RED + "'s punishments";
		}
		Inventory inv = Bukkit.createInventory(null, 9*3, ninv);
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    if(Main.english) {
	    	desccab.add("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punish: " + ChatColor.RED + "Choose some violation to");
		    desccab.add("" + ChatColor.RED + "edit the punishment.");
		    desccab.add("");
		    cabecam.setDisplayName(ChatColor.DARK_RED + punished + ChatColor.RED + "'s punishments");
	    } else {
	    	desccab.add("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Escolha a violação para");
		    desccab.add("" + ChatColor.RED + "editar a punição.");
		    desccab.add("");
		    cabecam.setDisplayName(ChatColor.DARK_RED + "Punições de: " + ChatColor.RED + punished);
	    }
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    pjogo = new ItemStack(Material.DIAMOND_SWORD);
	    pjogom = pjogo.getItemMeta();
	    List<String> descpjogo = new ArrayList<String>();
	    if(Main.english) {
	    	descpjogo.add("" + ChatColor.DARK_RED + "Punish> " + ChatColor.RED + punished + " received a total of " + ChatColor.YELLOW + getTotal(punished, 2));
		    descpjogo.add("" + ChatColor.RED + "game punishments. Click here to edit it");
		    pjogom.setDisplayName(ChatColor.DARK_GRAY + "Game Violations");
	    } else {
	    	descpjogo.add("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "" + punished + " recebeu um total de " + ChatColor.YELLOW + "" + getTotal(punished, 2));
		    descpjogo.add("" + ChatColor.RED + "punições de jogo. Clique aqui para edita-la(s)");
		    pjogom.setDisplayName(ChatColor.DARK_GRAY + "Violações de Jogo");
	    }    
	    pjogom.setLore(descpjogo);
	    pjogo.setAmount(getTotal(punished, 2));
	    pjogo.setItemMeta(pjogom);
	    
	    pchat = new ItemStack(Material.BOOK_AND_QUILL);
	    pchatm = pchat.getItemMeta();
	    List<String> descpchat = new ArrayList<String>();
	    if(Main.english) {
	    	descpchat.add("" + ChatColor.DARK_RED + "Punish> " + ChatColor.RED + punished + " received a total of " + ChatColor.YELLOW + getTotal(punished, 1));
		    descpchat.add("" + ChatColor.RED + "chat punishments. Click to edit it");
		    pchatm.setDisplayName(ChatColor.DARK_GRAY + "Chat Violations");
	    } else {
	    	descpchat.add("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + punished + " recebeu um total de " + ChatColor.YELLOW + getTotal(punished, 1));
		    descpchat.add("" + ChatColor.RED + "punições de chat. Clique aqui para edita-la(s)");
		    pchatm.setDisplayName(ChatColor.DARK_GRAY + "Violações de Chat");
	    }
	    pchatm.setLore(descpchat);
	    pchat.setAmount(getTotal(punished, 1));
	    pchat.setItemMeta(pchatm);
	    
	    inv.setItem(4, cabeca);
	    inv.setItem(11, pchat);
	    inv.setItem(15, pjogo);
	    
	    punisher.openInventory(inv);
		
	}
	
	public void editarPunicao(Player punisher, String punished, int modo) throws SQLException {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();	
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome = '" + punished + "' AND Modo=" + modo+ ";");
		while(res.next()) {
			String modos = "";
			if(res.getInt("Modo") == 1) {
				if(Main.english) {
					modos = "Chat Violation";
				} else {
					modos = "Violação de Chat";
				}
			}
			if(res.getInt("Modo") == 2) {
				if(Main.english) {
					modos = "Game Violation";
				} else {
					modos = "Violação de Jogo";
				}
			}
			String flag = "";
			if(Main.english) {
				if(res.getBoolean("Tipo")) {
					flag = "Yes";
				} else {
					flag = "No";
				}
			} else {
				if(res.getBoolean("Tipo")) {
					flag = "Sim";
				} else {
					flag = "Não";
				}
			}
			String expira = "";
			if(Main.english) {
				expira = "No";
			} else {
				expira = "Não";
			}
			Date data1 = new Date(res.getLong("Inicio"));
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
			if(res.getInt("Sev") != 10 && res.getInt("Sev") > 2) {
				Date data2 = new Date(res.getLong("Fim"));
				expira = sf.format(data2);
			}
			String cancel = "";
			if(Main.english) {
				if(res.getBoolean("Cancelado")) {
					cancel = "Yes";
				} else {
					cancel = "No";
				}
			} else {
				if(res.getBoolean("Cancelado")) {
					cancel = "Sim";
				} else {
					cancel = "Não";
				}
			}
				
			ItemStack punicao = new ItemStack(Material.DIAMOND_SPADE);
			ItemMeta punicaom = punicao.getItemMeta();
			List<String> dp = new ArrayList<String>();
			if(Main.english) {
				dp.add("" + ChatColor.WHITE + "Punishment: " + ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + getName(res.getString("Sigla")));
				dp.add("" + ChatColor.WHITE + "Player: " + punished);
				dp.add("" + ChatColor.WHITE + "UUID: " + res.getString("UUID"));
				dp.add("" + ChatColor.WHITE + "IP: " + res.getString("IP"));
				dp.add("" + ChatColor.WHITE + "Severity: " + res.getInt("Sev"));
				dp.add("" + ChatColor.WHITE + "Type: " + modos);
				dp.add("" + ChatColor.WHITE + "In act: " + flag);
				dp.add("" + ChatColor.WHITE + "Activated: " + sf.format(data1));
				dp.add("" + ChatColor.WHITE + "Expires: " + expira);
				dp.add("" + ChatColor.WHITE + "Cancelled: " + cancel);
				if(cancel.equalsIgnoreCase("Yes")) {dp.add("" + ChatColor.WHITE + "Cancelled by: " + res.getString("CancelBy")); }
				dp.add("" + ChatColor.WHITE + "Proof: " + res.getString("Prova"));
				dp.add("" + ChatColor.WHITE + "Staff: " + res.getString("Staff"));
				dp.add("");
				dp.add("" + ChatColor.YELLOW + "Click to edit or cancel the punishment");
			} else {
				dp.add("" + ChatColor.WHITE + "Punição: " + ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + getName(res.getString("Sigla")));
				dp.add("" + ChatColor.WHITE + "Jogador: " + punished);
				dp.add("" + ChatColor.WHITE + "UUID: " + res.getString("UUID"));
				dp.add("" + ChatColor.WHITE + "IP: " + res.getString("IP"));
				dp.add("" + ChatColor.WHITE + "Severidade: " + res.getInt("Sev"));
				dp.add("" + ChatColor.WHITE + "Tipo: " + modos);
				dp.add("" + ChatColor.WHITE + "Flagrante: " + flag);
				dp.add("" + ChatColor.WHITE + "Ativada: " + sf.format(data1));
				dp.add("" + ChatColor.WHITE + "Expira: " + expira);
				dp.add("" + ChatColor.WHITE + "Cancelado: " + cancel);
				if(cancel.equalsIgnoreCase("Sim")) {dp.add("" + ChatColor.WHITE + "Cancelado por: " + res.getString("CancelBy")); }
				dp.add("" + ChatColor.WHITE + "Prova: " + res.getString("Prova"));
				dp.add("" + ChatColor.WHITE + "Staff: " + res.getString("Staff"));
				dp.add("");
				dp.add("" + ChatColor.YELLOW + "Clique para editar ou cancelar a punição");
			}	
			punicaom.setLore(dp);
			punicaom.setDisplayName(ChatColor.DARK_GRAY + "" +  res.getInt("id"));
			punicao.setItemMeta(punicaom);
			
			items.add(punicao);
		}
		String ninv = ChatColor.DARK_RED + "Violações";
		if(Main.english) {
			ninv = "Violations";
		}
		new ScrollerInventory(items, ninv , punisher);
		
	}
	
	public static void editPunish(Player p, int id)throws SQLException {
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM punish WHERE id=" + id + ";");
		Inventory inv = Bukkit.createInventory(null, 9*6, ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id"));
		
		res.next();
		flpun = res.getBoolean("Tipo");
		String vi = "";
		if(res.getInt("Modo") == 1) {
			tpun = new ItemStack(Material.BOOK_AND_QUILL);
			if(Main.english) {
				vi = "Chat"; 
			} else {
				vi = "chat";
			}
		} else {
			tpun = new ItemStack(Material.DIAMOND_SWORD);
			if(Main.english) {
				vi = "Game"; 
			} else {
				vi = "jogo";
			}
		}
		tpunm = tpun.getItemMeta();
		List<String> dt = new ArrayList<String>();
		if(Main.english) {
			dt.add("" + ChatColor.DARK_RED + "Punishment> " + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + getName(res.getString("Sigla")));
			dt.add("" + ChatColor.YELLOW + "" + res.getString("Desc"));
			tpunm.setDisplayName(ChatColor.DARK_GRAY + vi + " violation");
		} else {
			dt.add("" + ChatColor.DARK_RED + "Punição> " + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + getName(res.getString("Sigla")));
			dt.add("" + ChatColor.YELLOW + "" + res.getString("Desc"));
			tpunm.setDisplayName(ChatColor.DARK_GRAY + "Violação de " + vi);
		}
		tpunm.setLore(dt);
		tpun.setItemMeta(tpunm);
		
		cpun = new ItemStack(Material.REDSTONE_BLOCK);
		cpunm = cpun.getItemMeta();
		if(Main.english) {
			cpunm.setDisplayName(ChatColor.DARK_GRAY + "Click to cancel the punishment");
		} else {
			cpunm.setDisplayName(ChatColor.DARK_GRAY + "Clique para cancelar a punição");
		}
		cpun.setItemMeta(cpunm);
		
		spun = new ItemStack(Material.STAINED_CLAY, 1, (short)5);
		spunm = spun.getItemMeta();
		if(Main.english) {
			spunm.setDisplayName(ChatColor.DARK_GRAY + "Click to save the punishment's changes");
		} else {
			spunm.setDisplayName(ChatColor.DARK_GRAY + "Clique para salvar as alterações na punição");
		}
		spun.setItemMeta(spunm);
		
		sepun = new ItemStack(Material.REDSTONE_TORCH_ON);
		sepunm = sepun.getItemMeta();
		List<String> saa = new ArrayList<String>();
		if(Main.english) {
			saa.add("" + ChatColor.WHITE + "Current severity: " + res.getInt("Sev"));
			saa.add("" + ChatColor.WHITE + "New severity: " + seve);
			sepunm.setDisplayName(ChatColor.DARK_GRAY + "Click to change the severity");
		} else {
			saa.add("" + ChatColor.WHITE + "Severidade atual: " + res.getInt("Sev"));
			saa.add("" + ChatColor.WHITE + "Nova severidade: " + seve);
			sepunm.setDisplayName(ChatColor.DARK_GRAY + "Clique para alterar a severidade");
		}
		sepunm.setLore(saa);
		sepun.setItemMeta(sepunm);
		
		ppun = new ItemStack(Material.ITEM_FRAME);
		ppunm = ppun.getItemMeta();
		List<String> sa = new ArrayList<String>();
		if(Main.english) {
			sa.add("" + ChatColor.WHITE + "Current proof: " + res.getString("Prova"));
			sa.add("" + ChatColor.WHITE + "New proof: " + provaa);
			ppunm.setDisplayName(ChatColor.DARK_GRAY + "Click to attach/edit the proof");
		} else {
			sa.add("" + ChatColor.WHITE + "Prova atual: " + res.getString("Prova"));
			sa.add("" + ChatColor.WHITE + "Nova prova: " + provaa);
			ppunm.setDisplayName(ChatColor.DARK_GRAY + "Clique para anexar/editar a prova");
		}
		ppunm.setLore(sa);	
		ppun.setItemMeta(ppunm);
		
		if(fla != "") {
			if(fla.equalsIgnoreCase("Sim")) {
				fpun = new ItemStack(Material.DISPENSER);
			} else {
				fpun = new ItemStack(Material.PAPER);
			}
		} else {	
			if(flpun) {
				fpun = new ItemStack(Material.DISPENSER);
			} else {
				fpun = new ItemStack(Material.PAPER);
			}
		}
		fpunm = fpun.getItemMeta();
		if(Main.english) {
			fpunm.setDisplayName(ChatColor.DARK_GRAY + "Click to toggle between in act/report");
		} else {
			fpunm.setDisplayName(ChatColor.DARK_GRAY + "Clique para alternar entre o modo flagrante/denúncia");
		}
		fpun.setItemMeta(fpunm);
		
		sair = new ItemStack(Material.IRON_DOOR);
		sairm = sair.getItemMeta();
		if(Main.english) {
			sairm.setDisplayName(ChatColor.DARK_GRAY + "Click to leave to the inventory");
		} else {
			sairm.setDisplayName(ChatColor.DARK_GRAY + "Clique para sair da edição");
		}
		sair.setItemMeta(sairm);
		
		excluir = new ItemStack(Material.BARRIER);
		excluirm = excluir.getItemMeta();
		if(Main.english) {
			excluirm.setDisplayName(ChatColor.DARK_GRAY + "Delete the punishment of the database");
		} else {
			excluirm.setDisplayName(ChatColor.DARK_GRAY + "Excluir punição do Banco de Dados");
		}
		excluir.setItemMeta(excluirm);
		
		inv.setItem(4, tpun);
		if(!res.getBoolean("Cancelado") && p.hasPermission("punish.edit.cancel")) {
			inv.setItem(19, cpun);
		}
		if(p.hasPermission("punish.edit.delete")) {
			inv.setItem(28, excluir);
		}
		inv.setItem(37, sair);
		inv.setItem(22, sepun);
		inv.setItem(31, ppun);
		inv.setItem(40, fpun);
		inv.setItem(24, spun);
		inv.setItem(25, spun);
		inv.setItem(26, spun);
		inv.setItem(33, spun);
		inv.setItem(34, spun);
		inv.setItem(35, spun);
		inv.setItem(42, spun);
		inv.setItem(43, spun);
		inv.setItem(44, spun);
		
		p.openInventory(inv);		
	}
	
	public static void eSev(Player p) {
		String ninv = "" + ChatColor.DARK_RED + "Editar Severidade";
		if(Main.english) {
			ninv = "" + ChatColor.DARK_RED + "Edit Severity";
		}
		Inventory inv = Bukkit.createInventory(null, 9*5, ninv);
		
		sev1 = new ItemStack(Material.STAINED_CLAY, 1, (short)2);
		sev1m = sev1.getItemMeta();
		if(Main.english) {
			sev1m.setDisplayName(ChatColor.DARK_GRAY + "Severity 1");
		} else {
			sev1m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 1");
		}
		sev1.setItemMeta(sev1m);
		
		sev2 = new ItemStack(Material.STAINED_CLAY, 2, (short)10);
		sev2m = sev2.getItemMeta();
		if(Main.english) {
			sev2m.setDisplayName(ChatColor.DARK_GRAY + "Severity 2");
		} else {
			sev2m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 2");
		}
		sev2.setItemMeta(sev2m);
		
		sev3 = new ItemStack(Material.STAINED_CLAY, 3, (short)3);
		sev3m = sev3.getItemMeta();
		if(Main.english) {
			sev3m.setDisplayName(ChatColor.DARK_GRAY + "Severity 3");
		} else {
			sev3m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 3");
		}
		sev3.setItemMeta(sev3m);
		
		sev4 = new ItemStack(Material.STAINED_CLAY, 4, (short)11);
		sev4m = sev4.getItemMeta();
		if(Main.english) {
			sev4m.setDisplayName(ChatColor.DARK_GRAY + "Severit 4");
		} else {
			sev4m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 4");
		}
		sev4.setItemMeta(sev4m);
		
		sev5 = new ItemStack(Material.STAINED_CLAY, 5, (short)5);
		sev5m = sev5.getItemMeta();
		if(Main.english) {
			sev5m.setDisplayName(ChatColor.DARK_GRAY + "Severity 5");
		} else {
			sev5m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 5");
		}
		sev5.setItemMeta(sev5m);
		
		sev6 = new ItemStack(Material.STAINED_CLAY, 6, (short)13);
		sev6m = sev6.getItemMeta();
		if(Main.english) {
			sev6m.setDisplayName(ChatColor.DARK_GRAY + "Severity 6");
		} else {
			sev6m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 6");
		}
		sev6.setItemMeta(sev6m);
		
		sev7 = new ItemStack(Material.STAINED_CLAY, 7, (short)4);
		sev7m = sev7.getItemMeta();
		if(Main.english) {
			sev7m.setDisplayName(ChatColor.DARK_GRAY + "Severity 7");
		} else {
			sev7m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 7");
		}
		sev7.setItemMeta(sev7m);
		
		sev8 = new ItemStack(Material.STAINED_CLAY, 8, (short)1);
		sev8m = sev8.getItemMeta();
		if(Main.english) {
			sev8m.setDisplayName(ChatColor.DARK_GRAY + "Severity 8");
		} else {
			sev8m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 8");
		}
		sev8.setItemMeta(sev8m);
		
		sev9 = new ItemStack(Material.STAINED_CLAY, 9, (short)14);
		sev9m = sev9.getItemMeta();
		if(Main.english) {
			sev9m.setDisplayName(ChatColor.DARK_GRAY + "Severity 9");
		} else {
			sev9m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 9");
		}
		sev9.setItemMeta(sev9m);
		
		sev10 = new ItemStack(Material.REDSTONE_BLOCK, 10);
		sev10m = sev10.getItemMeta();
		if(Main.english) {
			sev10m.setDisplayName(ChatColor.DARK_GRAY + "Severity 10");
		} else {
			sev10m.setDisplayName(ChatColor.DARK_GRAY + "Severidade 10");
		}
		sev10.setItemMeta(sev10m);
		
		inv.setItem(2, sev1);
		inv.setItem(11, sev2);
		inv.setItem(20, sev3);
		inv.setItem(29, sev4);
		inv.setItem(38, sev5);
		inv.setItem(6, sev6);
		inv.setItem(15, sev7);
		inv.setItem(24, sev8);
		inv.setItem(33, sev9);
		inv.setItem(42, sev10);
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void click(InventoryClickEvent e) throws SQLException {
		Player p = (Player) e.getWhoClicked();
		if(p instanceof Player) {
				if(ScrollerInventory.users.containsKey(p.getUniqueId())) {
					 ScrollerInventory inv = ScrollerInventory.users.get(p.getUniqueId());
				        if(e.getCurrentItem() == null) return;
				        if(e.getCurrentItem().getItemMeta() == null) return;
				        if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
				        if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ScrollerInventory.nextPageName)){
				            e.setCancelled(true);
				            if(inv.currpage >= inv.pages.size()-1){
				                return;
				            }else{
				                inv.currpage += 1;
				                p.openInventory(inv.pages.get(inv.currpage));
				            }
				        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ScrollerInventory.previousPageName)){
				             e.setCancelled(true);
				             if(inv.currpage > 0){
				                 inv.currpage -= 1;
				                 p.openInventory(inv.pages.get(inv.currpage));
				             }
				}
				}
		       
				if(e.getCurrentItem().isSimilar(cabeca)) {
					e.setCancelled(true);
					return;
				}
				if(e.getCurrentItem().isSimilar(punicoes)) {
					e.setCancelled(true);
					p.closeInventory();
					openEditPunish(p, punish.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().getType().equals(Material.DIAMOND_SPADE) && punish.containsKey(p.getName())) {
					e.setCancelled(true);
					p.closeInventory();
					editPunish(p, Integer.parseInt(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())));
					editando.put(p.getName(), Integer.parseInt(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())));
					return;
				}
				if(e.getCurrentItem().isSimilar(ppun)) {
					e.setCancelled(true);
					eprova.add(p.getName());
					p.closeInventory();
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Edit Punishment> " + ChatColor.GRAY + "Type the proof link in the chat. The inventory will then open.");
						return;
					}
					p.sendMessage(ChatColor.BLUE + "Editar Punição> " + ChatColor.GRAY + "Digite o link da prova no chat. O inventário será aberto em seguida.");
					return;
				}
				if(e.getCurrentItem().isSimilar(sair)) {
					e.setCancelled(true);
					eprova.remove(p.getName());
					editando.remove(p.getName());
					flpun = false;
					fla = "";
					p.closeInventory();
					return;
				}
				if(e.getCurrentItem().isSimilar(fpun)) {
					e.setCancelled(true);
					p.closeInventory();
					if(fla != "") {
						if(fla.equalsIgnoreCase("Sim")) {
							fla = "Não";
						} else {
							fla = "Sim";
						}
					} else {	
						if(flpun) {
							fla = "Não";
						} else {
							fla = "Sim";
						}
					}
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sepun)) {
					e.setCancelled(true);
					p.closeInventory();
					eSev(p);
					return;
				}
				if(e.getCurrentItem().isSimilar(spun)) {
					e.setCancelled(true);
					p.closeInventory();
					String prova = " ";
					if(provaa != "") {
						prova = " Prova='" + provaa + "',";
					}
					String sev = " ";
					if(seve != 0) {
						sev = " Sev=" + seve + ",";
					}
					String fim = " ";
					if(seve != 0) {
						if(seve == 10) {
							fim = " Fim=-1,";
						} else {
							fim = " Fim=" + getFMillis(seve) + ",";
						}
						
					}
					String sla = "";
					if(fla == "") {
						sla = " ";
					}
					if(fla.equalsIgnoreCase("Sim")) {
						sla = " Tipo = 1";
					}
					if(fla.equalsIgnoreCase("Não")) {
						sla = " Tipo = 0";
					}
					Statement s = Main.c.createStatement();
					s.execute("UPDATE punish SET" + prova + sev + fim + sla + " WHERE id=" + editando.get(p.getName()) + ";");
					fla = "";
					s.close();
					editando.remove(p.getName());
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Edit Punishment> The punishment was edited successful.");
						return;
					}
					p.sendMessage(ChatColor.BLUE + "Editar Punição> A punição foi editada com sucesso.");
					return;
				}
				if(e.getCurrentItem().isSimilar(cpun)) {
					e.setCancelled(true);
					p.closeInventory();
					Statement s = Main.c.createStatement();
					s.execute("UPDATE punish SET Cancelado=1, CancelBy='" + p.getName() + "' WHERE id=" + editando.get(p.getName()) + ";");
					ResultSet res = s.executeQuery("SELECT * FROM punish WHERE id=" + editando.get(p.getName()) + ";");
					res.next();
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Cancel Punishment> " + ChatColor.GRAY + "The punishment " + ChatColor.RED + editando.get(p.getName()) + " " + ChatColor.GRAY + "was cancelled successful.");
						if(Bukkit.getPlayer(res.getString("Nome")) instanceof Player) {
							Player a = Bukkit.getPlayer(res.getString("Nome"));
							a.sendMessage(ChatColor.BLUE + "Punishment> " + ChatColor.GOLD + "Your punishment " + ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + getName(res.getString("Sigla")) + " " + ChatColor.GOLD + "was cancelled by an administrator.");
						}
					} else {
						p.sendMessage(ChatColor.BLUE + "Cancelar Punição> " + ChatColor.GRAY + "A punição " + ChatColor.RED + "" + editando.get(p.getName()) + " " + ChatColor.GRAY + "foi cancelada com sucesso");
						if(Bukkit.getPlayer(res.getString("Nome")) instanceof Player) {
							Player a = Bukkit.getPlayer(res.getString("Nome"));
							a.sendMessage(ChatColor.BLUE + "Punição> " + ChatColor.GOLD + "Sua punição " + ChatColor.DARK_RED + "" + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + "" + getName(res.getString("Sigla")) + " " + ChatColor.GOLD + "foi cancelada por um administrador.");
						}
					}
					fla = "";
					return;
				}
				if(e.getCurrentItem().isSimilar(excluir)) {
					e.setCancelled(true);
					p.closeInventory();
					Statement s = Main.c.createStatement();
					s.execute("DELETE FROM punish WHERE id=" + editando.get(p.getName()));
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Delete Punishment> " + ChatColor.GRAY + "The punishment " + ChatColor.RED + editando.get(p.getName()) + " " + ChatColor.GRAY + "was deleted successful!");
						return;
					}
					p.sendMessage(ChatColor.BLUE + "Excluir Punição> " + ChatColor.GRAY + "A punição " + ChatColor.RED + "" + editando.get(p.getName()) + " " + ChatColor.GRAY + "foi excluida com sucesso!");
					return;
				}
				if(e.getCurrentItem().isSimilar(sev1)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 1;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev2)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 2;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev3)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 3;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev4)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 4;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev5)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 5;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev6)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 6;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev7)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 7;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev8)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 8;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev9)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 9;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(sev10)) {
					e.setCancelled(true);
					p.closeInventory();
					seve = 10;
					editPunish(p, editando.get(p.getName()));
					return;
				}
				if(e.getCurrentItem().isSimilar(pjogo)) {
					e.setCancelled(true);
					try {
						editarPunicao(p, punish.get(p.getName()), 2);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return;
				}
				if(e.getCurrentItem().isSimilar(pchat)) {
					e.setCancelled(true);
					try {
						editarPunicao(p, punish.get(p.getName()), 1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return;
				}
				if(e.getCurrentItem().isSimilar(papel)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					flagra = false;
					openSecundaryPunish(p, punished, false);
					return;
				}
				if(e.getCurrentItem().isSimilar(ejec)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openSecundaryPunish(p, punished, true);
					flagra = true;
					return;
				}
				if(e.getCurrentItem().isSimilar(livro)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openTPunish(p, punished, flagra);
					return;
				}
				if(e.getCurrentItem().isSimilar(esp)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openTPunishJ(p, punished, flagra);
					return;
				}
				if(e.getCurrentItem().getType().equals(Material.NETHER_STAR) && punish.containsKey(p.getName())) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.gameViolations");
					for(String s : c.getKeys(false)) {
						if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).toUpperCase().startsWith((c.getString(s + ".stname").toUpperCase()))) {
							openFPunish(p, punished, flagra, "jogo", getSev(c.getString(s + ".stname"), punished), c.getString(s + ".stname"), c.getString(s + ".description"));
						}
					}
					ConfigurationSection c2 = Main.pl.getConfig().getConfigurationSection("punishments.chatViolations");
					for(String s : c2.getKeys(false)) {
						if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).toUpperCase().startsWith((c2.getString(s + ".stname").toUpperCase()))) {
							openFPunish(p, punished, flagra, "chat", getSev(c2.getString(s + ".stname"), punished), c2.getString(s + ".stname"), c2.getString(s + ".description"));
						}
					}
					return;
				}
				if(e.getCurrentItem().isSimilar(flagr)) {
					p.closeInventory();
					flagra = false;
					reabrirInv(p);
					e.setCancelled(true);
					return;
				}
				if(e.getCurrentItem().isSimilar(denun)) {
					p.closeInventory();
					flagra = true;
					reabrirInv(p);
					e.setCancelled(true);
					return;
				}
				if(e.getCurrentItem().isSimilar(prova)) {
					e.setCancelled(true);
					emprova.add(p.getName());
					p.closeInventory();
					if(Main.english) {
						p.sendMessage(ChatColor.BLUE + "Punish> " + ChatColor.GRAY + "Type the proof link in the chat. The inventory will then open.");
						return;
					}
					p.sendMessage(ChatColor.BLUE + "Punir> " + ChatColor.GRAY + "Digite o link da prova no chat. O inventário será aberto em seguida.");
					return;
				}
				if(e.getCurrentItem().isSimilar(canc)) {
					e.setCancelled(true);
					punish.remove(p.getName());
					provaa = "";
					seve = 0;
					sigla = "";
					descr = "";
					tip = "";
					emprova.remove(p.getName());
					p.closeInventory();
					return;
				}
				if(e.getCurrentItem().isSimilar(conf)) {
					e.setCancelled(true);
					if(provaa.equalsIgnoreCase("")) {
						if(!flagra) {
							if(Main.english) {
								p.sendMessage(ChatColor.DARK_RED + "Punish> " + ChatColor.RED + "A proof need be attached in report mode.");
							} else {
								p.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Uma prova precisa ser anexada no modo denúncia.");
							}
						} else {
							p.closeInventory();
							punish(p, punish.get(p.getName()), flagra, sigla, descr, tip);
						}
					} else {		
							p.closeInventory();
							punish(p, punish.get(p.getName()), flagra, sigla, descr, tip, provaa);

					}
					punish.remove(p.getName());
					provaa = "";
					seve = 0;
					sigla = "";
					descr = "";
					tip = "";
					emprova.remove(p.getName());
					e.setCancelled(true);
				}
				return;
			}
		}
		
	
	public static void reabrirInv(Player punisher) {
		openFPunish(punisher, punish.get(punisher.getName()), flagra, tip, seve, sigla, descr);
		emprova.remove(punisher.getName());
	}
	
	public static void punish(Player punisher, String punished, boolean inact, String sigl, String desc, String tipo, String prova) {
		int modo = 0;
		if(tipo.equalsIgnoreCase("chat")) {
			modo = 1;
		} else if(tipo.equalsIgnoreCase("jogo")) {
			modo = 2;
		}
		int flagranteo = 0;
		if(inact) {
			flagranteo = 1;
		} else {
			flagranteo = 0;
		}
		try {
			Statement st = Main.c.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM users WHERE Nome = '" + punished + "';");
			res.next();
			String uuid = res.getString("UUID");
			String ip = res.getString("IP");
			int sev = getSev(sigl, punished);
			long sla = getFMillis(sev);
			PreparedStatement s = Main.c.prepareStatement("INSERT INTO punish (id, Nome, UUID, IP, Sigla, Sev, Modo, Tipo, Inicio, Fim, Cancelado, CancelBy, Prova, Desc, Staff) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			s.setString(1, punished);
			s.setString(2, uuid);
			s.setString(3, ip);
			s.setString(4, sigl.toUpperCase());
			s.setLong(5, sev);
			s.setInt(6, modo);
			s.setInt(7, flagranteo);
			s.setLong(8, System.currentTimeMillis());
			s.setLong(9, sla);
			s.setInt(10, 0);
			s.setString(11, null);
			s.setString(12, prova);
			s.setString(13, desc);
			s.setString(14, punisher.getName());
			s.execute();	
			s.close();
			st.close();
			res.close();
			if(sev < 3) {
				sendWarn(punished, prova, sigl, flagra, desc, getId(punished, sigl));			
			} else {
				BanMute(punished, desc, sigl, prova, inact, tipo, sev, sla);
			}
			for(Player ss : Bukkit.getOnlinePlayers()) {
				if(Main.english) {
					ss.sendMessage(ChatColor.BLUE + "Punishment> " + ChatColor.RED + punished + " " + ChatColor.GRAY + "have been punished for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
					return;
				}
				ss.sendMessage(ChatColor.BLUE + "Punição> " + ChatColor.RED + punished + " " + ChatColor.GRAY + "foi punido(a) por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
				return;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static void BanMute(String punished, String desc, String sigl, String prova, boolean inact, String tipo, int sev, long exp) {
		Player p = Bukkit.getPlayer(punished);
		String flag = "";
		if(inact) {
			if(Main.english) {
				flag = "" + ChatColor.AQUA + "in act";
			} else {
				flag = "" + ChatColor.AQUA + "em flagrante";
			}
		} else {
			if(Main.english) {
				flag = "" + ChatColor.GOLD + "by report";
			} else {
				flag = "" + ChatColor.GOLD + "por denúncia";
			}
		}
		if(!(p instanceof Player)) 	{
			return;
		}
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = new Date(exp);
		if(tipo.equalsIgnoreCase("chat")) {
			if(Main.english) {
				if(exp != -1) {
					p.sendMessage(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've benn muted for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "until " + ChatColor.RED + sf.format(data) + " " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + prova + " \n" + ChatColor.YELLOW + desc);
				} else {
					p.sendMessage(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've benn muted for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "forever " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + prova + " \n" + ChatColor.YELLOW +  desc);
				}
			} else {
				if(exp != -1) {
					p.sendMessage(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "até " + ChatColor.RED + "" + sf.format(data) + " " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED +  prova + " \n" + ChatColor.YELLOW +  desc);
				} else {
					p.sendMessage(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + prova + " \n" + ChatColor.YELLOW + "" + desc);
				}
			}
		} else {
			if(Main.english) {
				if(exp != -1) {
					p.kickPlayer(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been banned for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "until " + ChatColor.RED + sf.format(data) + " " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED + prova + " \n" + ChatColor.YELLOW + desc);
				} else {
					p.kickPlayer(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been banned for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "forever " + flag + " " + ChatColor.GOLD + "with this proof: \n" + ChatColor.RED +  prova + " \n" + ChatColor.YELLOW + desc);
				}
			} else {
				if(exp != -1) {
					p.kickPlayer(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "até " + ChatColor.RED + "" + sf.format(data) + " " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + prova + " \n" + ChatColor.YELLOW + desc);
				} else {
					p.kickPlayer(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED +  prova + " \n" + ChatColor.YELLOW + desc);
				}
			}
		}
	}
	
	public static String getRemaing(long exp) {
		String sla = "";
		if(exp == -1) {
			if(Main.english) {
				return "Doesn't expire";
			}
			return "Não expira";
		}
		long agora = System.currentTimeMillis();
		long pronto = exp - agora;
		if(pronto < 0) {
			if(Main.english) {
				return "Expired";
			}
			return "Expirado";
		}
	
		long sec = pronto / 1000;
		long min = sec / 60;
		long hora = min / 60;
		long dia = hora / 24;
		if(Main.english) {
			if(dia >= 1) {
				return dia + " day(s) remaining(s)";
			}
			if(hora >= 1) {
				return hora + " hour(s) remaining(s)";
			}
			if(min >= 1) {
				return min + " minute(s) remaining(s)";
			}
			if(sec >=1) {
				return sec + " second(s) remaining(s)";
			}
		} else {
			if(dia >= 1) {
				return dia + " dia(s) restante(s)";
			}
			if(hora >= 1) {
				return hora + " hora(s) restante(s)";
			}
			if(min >= 1) {
				return min + " minuto(s) restante(s)";
			}
			if(sec >=1) {
				return sec + " segundo(s) restante(s)";
			}
		}
		return sla;
	}
	
	public static int getId(String punished, String sigl) {
		try {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome = '" + punished + "' AND Sigla = '" + sigl.toUpperCase() + "' ORDER BY id");
			if(res.next()) {
				return res.getInt("id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static String getName(String sigl) {
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.gameViolations");
		for(String s : c.getKeys(false)) {
			if(sigl.equalsIgnoreCase(c.getString(s + ".stname"))) {
				return c.getString(s + ".name");
			}
		}
		ConfigurationSection c2 = Main.pl.getConfig().getConfigurationSection("punishments.chatViolations");
		for(String s : c2.getKeys(false)) {
			if(sigl.equalsIgnoreCase(c2.getString(s + ".stname"))) {
				return c2.getString(s + ".name");
			}
		}
		return "";
	}
	
	public static void sendWarn(String punished, String proof, String sigl, boolean inact, String desc, int id) {
		if(Bukkit.getPlayer(punished) instanceof Player) {
			Player p = Bukkit.getPlayer(punished);
			String flaga = "";
			if(inact) {
				if(Main.english) {
					flaga = ChatColor.AQUA + "in act";
				} else {
					flaga = ChatColor.AQUA + "em flagrante";
				}
			} else {
				if(Main.english) {
					flaga = ChatColor.GOLD + "by report";
				} else {
					flaga = ChatColor.GOLD + "por denúncia";
				}
			}
			emwarn.add(punished);
			if(Main.english) {
				p.sendMessage(ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been warned for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + id + "] " + flaga + " " + ChatColor.GOLD + "with this proof:\n" + ChatColor.RED + proof + " \n" + ChatColor.YELLOW + desc + "\n" + ChatColor.GOLD + "Type '" + ChatColor.RED + "understood" + ChatColor.GOLD + "' to can play and communicate again.");
				return;
			}
			p.sendMessage(ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + id + "] " + flaga + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + proof + " \n" + ChatColor.YELLOW + desc + "\n" + ChatColor.GOLD + "Digite '" + ChatColor.RED + "entendi" + ChatColor.GOLD + "' para poder jogar e falar novamente.");
			return;
		}
	}
	
	public static String getLastWarn(String punished) {
		String flaga = "";
		
		try {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + punished + "' AND Sev < 3 ORDER BY id;");
			if(!res.next()) {
				return null;
			}
			if(res.getBoolean("Tipo")) {
				if(Main.english) {
					flaga = ChatColor.AQUA + "in act";
				} else {
					flaga = ChatColor.AQUA + "em flagrante";
				}
			} else {
				if(Main.english) {
					flaga = ChatColor.GOLD + "by report";
				} else {
					flaga = ChatColor.GOLD + "por denúncia";
				}
			}
			String sigla = res.getString("Sigla");
			if(Main.english) {
				return ChatColor.DARK_RED + "Punishment> " + ChatColor.GOLD + "You've been warned for " + ChatColor.RED + getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + sigla.toUpperCase() + "#" + getId(punished, sigla) + "] " + flaga + " " + ChatColor.GOLD + "with this proof:\n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc") + "\n" + ChatColor.GOLD + "Type '" + ChatColor.RED + "understood" + ChatColor.GOLD + "' to can play and communicate again.";
			}
			return ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + sigla.toUpperCase() + "#" + getId(punished, sigla) + "] " + flaga + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + res.getString("Prova") + " \n" + ChatColor.YELLOW + res.getString("Desc") + "\n" + ChatColor.GOLD + "Digite '" + ChatColor.RED + "entendi" + ChatColor.GOLD + "' para poder jogar e falar novamente.";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void punish(Player punisher, String punished, boolean inact, String sigl, String desc, String tipo) {
		int modo = 0;
		if(tipo.equalsIgnoreCase("chat")) {
			modo = 1;
		} else if(tipo.equalsIgnoreCase("jogo")) {
			modo = 2;
		}
		int flagranteo = 0;
		if(inact) {
			flagranteo = 1;
		} else {
			flagranteo = 0;
		}
		try {
			Statement st = Main.c.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM users WHERE Nome = '" + punished + "';");
			res.next();
			int sev = getSev(sigl, punished);
			long sla = getFMillis(getSev(sigl, punished));
			PreparedStatement s = Main.c.prepareStatement("INSERT INTO punish (id, Nome, UUID, IP, Sigla, Sev, Modo, Tipo, Inicio, Fim, Cancelado, CancelBy, Prova, Desc, Staff) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			s.setString(1, punished);
			s.setString(2, res.getString("UUID"));
			s.setString(3, res.getString("IP"));
			s.setString(4, sigl.toUpperCase());
			s.setLong(5, getSev(sigl, punished));
			s.setInt(6, modo);
			s.setInt(7, flagranteo);
			s.setLong(8, System.currentTimeMillis());
			s.setLong(9, sla);
			s.setInt(10, 0);
			s.setString(11, null);
			if(Main.english) {
				s.setString(12, "A proof will be attached later.");
			} else {
				s.setString(12, "Uma prova será anexada posteriormente.");
			}
			s.setString(13, desc);
			s.setString(14, punisher.getName());
			s.execute();	
			s.close();
			st.close();
			res.close();
			if(sev < 3) {
				if(Main.english) {
					sendWarn(punished, "A proof will be attached later.", sigl, flagra, desc, getId(punished, sigl));
				} else {
					sendWarn(punished, "Uma prova será anexada posteriormente.", sigl, flagra, desc, getId(punished, sigl));
				}				
			} else {
				if(Main.english) {
					BanMute(punished, desc, sigl, "A proof will be attached later.", inact, tipo, sev, sla);
				} else {
					BanMute(punished, desc, sigl, "Uma prova será anexada posteriormente.", inact, tipo, sev, sla);
				}
			}
			for(Player ss : Bukkit.getOnlinePlayers()) {
				if(Main.english) {
					ss.sendMessage(ChatColor.BLUE + "Punishment> " + ChatColor.RED + punished + " " + ChatColor.GRAY + "have been punished for " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
				} else {
					ss.sendMessage(ChatColor.BLUE + "Punição> " + ChatColor.RED + punished + " " + ChatColor.GRAY + "foi punido(a) por " + ChatColor.RED + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getMsg(String tipo, int sev) {
		String msg = "";
		if(sev < 3) {
			return "Warn";
		}
		if(tipo.equalsIgnoreCase("chat")) {
			msg = "Mute";
		}
		if(tipo.equalsIgnoreCase("jogo")) {
			msg = "Ban";
		}
		if(Main.english) {
			if(sev > 2 && sev < 5) {
				msg = "2 hours " + msg;
			}
			if(sev > 4 && sev < 8) {
				msg = "A day " + msg;
			}
			if(sev > 7 && sev < 10) {
				msg = "A week " + msg;
			}
			if(sev == 10) {
				msg = "Forever";
			}
		} else {
			if(sev > 2 && sev < 5) {
				msg += " de 2 horas";
			}
			if(sev > 4 && sev < 8) {
				msg += " de 1 dia";
			}
			if(sev > 7 && sev < 10) {
				msg += " de 1 semana";
			}
			if(sev == 10) {
				msg += " permanente";
			}
		}
		return msg;
	}
	
	public static long getFMillis(int sev) {
		long mfinal = 0;
		if((sev > 1 && sev < 3) || sev == 10) {
			return -1;
		}
		if(sev == 3 || sev == 4) {
			int duashoras = 2*60*60*1000;
			mfinal = System.currentTimeMillis() + duashoras;
		}
		if(sev == 5 || sev == 6 || sev == 7) {
			int umdia = 24*60*60*1000;
			mfinal = System.currentTimeMillis() + umdia;
		}
		if(sev == 8 || sev == 9) {
			int umdia = 7*24*60*60*1000;
			mfinal = System.currentTimeMillis() + umdia;
		}
		return mfinal;
	}
	
	public static int getSev(String sigl, String punished) {
		int severidade = 0;
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.gameViolations");
		for(String s : c.getKeys(false)) {
			if(sigl.equalsIgnoreCase(c.getString(s + ".stname"))) {
				severidade = c.getInt(s + ".severity");
			}
		}
		ConfigurationSection c2 = Main.pl.getConfig().getConfigurationSection("punishments.chatViolations");
		for(String s : c2.getKeys(false)) {
			if(sigl.equalsIgnoreCase(c2.getString(s + ".stname"))) {
				severidade = c2.getInt(s + ".severity");
			}
		}
		try {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT COUNT(*) AS total FROM punish WHERE Nome='" + punished + "' AND Sigla = '" + sigl.toUpperCase() + "' AND CancelBy != 'Sistema';");
			if(res.next()) {
				int sev2 = res.getInt("total");
				severidade = severidade + sev2;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(severidade > 10) {
			return 10;
		}
		return severidade;
	}	
	
	public static int getTotal(String punished, int modo) throws SQLException {
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT COUNT(*) AS total FROM punish WHERE Nome='" + punished + "' AND Modo = " + modo + ";");
		if(res.next()) {
			return res.getInt("total");
		} 
		return 0;
	}
}
