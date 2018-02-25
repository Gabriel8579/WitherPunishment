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

	//Inventario editar punição
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
			Inventory inv = Bukkit.createInventory(null, 9*3, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished);
			
			cabeca = new ItemStack(397, 1, (short) 3);
		    cabecam = (SkullMeta) cabeca.getItemMeta();
		    List<String> desccab = new ArrayList<String>();
		    desccab.add("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Escolha o modo de punição");
		    cabecam.setDisplayName("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
		    cabecam.setOwner(punished);
		    cabecam.setLore(desccab);
		    cabeca.setItemMeta(cabecam);
		    
		    papel = new ItemStack(Material.PAPER);
		    papelm = papel.getItemMeta();
		    List<String> descpapel = new ArrayList<String>();
		    descpapel.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Denúncia");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.GRAY + "Escolha este modo para punir");
		    descpapel.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
		    descpapel.add("" + ChatColor.GRAY + "com base em uma denúncia");
		    descpapel.add("");
		    descpapel.add("" + ChatColor.DARK_RED + "Uma prova deverá ser anexada!");
		    papelm.setLore(descpapel);
		    papelm.setDisplayName("" + ChatColor.DARK_GRAY + "Punir com base em " + ChatColor.YELLOW + "DENUNCIA");
		    papel.setItemMeta(papelm);
		    
		    ejec = new ItemStack(Material.DISPENSER);
		    ejecm = ejec.getItemMeta();
		    List<String> descejec = new ArrayList<String>();
		    descejec.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Flagrante");
		    descejec.add("");
		    descejec.add("" + ChatColor.GRAY + "Escolha este modo para punir");
		    descejec.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
		    descejec.add("" + ChatColor.GRAY + "em flagrante");
		    descejec.add("");
		    descejec.add("" + ChatColor.DARK_RED + "A prova pode ser anexada posteriormente!");
		    ejecm.setLore(descejec);
		    ejecm.setDisplayName("" + ChatColor.DARK_GRAY + "Punir em " + ChatColor.YELLOW + "FLAGRANTE");
		    ejec.setItemMeta(ejecm);
		    
		    punicoes = new ItemStack(Material.HOPPER);
		    punicoesm = punicoes.getItemMeta();
		    List<String> descpunicoes = new ArrayList<String>();
		    descpunicoes.add("" + ChatColor.DARK_RED + "Punições de " + ChatColor.RED + "" + punished);
		    descpunicoes.add(" ");
		    descpunicoes.add("" + ChatColor.WHITE + "Violações de Chat: " + ChatColor.YELLOW + "" + getTotal(punished, 1));
		    descpunicoes.add("" + ChatColor.WHITE + "Violações de Jogo: " + ChatColor.YELLOW + "" + getTotal(punished, 2));
		    descpunicoes.add(" ");
		    descpunicoes.add("" + ChatColor.YELLOW + "Clique para editar as punições");
		    punicoesm.setLore(descpunicoes);
		    punicoesm.setDisplayName("" + ChatColor.DARK_GRAY + "Punições passadas de " + ChatColor.RED + "" + punished);
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
		Inventory inv = Bukkit.createInventory(null, 9*3, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished);
		String flag = "";
		String prova = "";
		if(inact) {
			flag = "Flagrante";
			prova = "poderá ser anexada posteriormente!";
		} else {
			flag = "Denúncia";
			prova = "deverá ser anexada!";
		}
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    desccab.add("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "PUNIR: " + ChatColor.RED + "Escolha o tipo de punição");
	    desccab.add("");
	    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + "" + flag);
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    livro = new ItemStack(Material.BOOK_AND_QUILL);
	    livrom = livro.getItemMeta();
	    List<String> descpapel = new ArrayList<String>();
	    descpapel.add("" + ChatColor.AQUA + "Tipo de Punição: " + ChatColor.YELLOW + "Violações de Chat");
	    descpapel.add("");
	    descpapel.add("" + ChatColor.GRAY + "Escolha este tipo para punir");
	    descpapel.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
	    descpapel.add("" + ChatColor.GRAY + "com base em uma violação de chat");
	    descpapel.add("");
	    descpapel.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    livrom.setLore(descpapel);
	    livrom.setDisplayName("" + ChatColor.DARK_GRAY + "Violação de Chat");
	    livro.setItemMeta(livrom);
	    
	    esp = new ItemStack(Material.DIAMOND_SWORD);
	    espm = esp.getItemMeta();
	    List<String> descejec = new ArrayList<String>();
	    descejec.add("" + ChatColor.AQUA + "Tipo de Punição: " + ChatColor.YELLOW + "Violações de Jogo");
	    descejec.add("");
	    descejec.add("" + ChatColor.GRAY + "Escolha este modo para punir");
	    descejec.add("" + ChatColor.GRAY + "o player " + ChatColor.RED + "" + punished);
	    descejec.add("" + ChatColor.GRAY + "com base em uma violação de jogo");
	    descejec.add("");
	    descejec.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    espm.setLore(descejec);
	    espm.setDisplayName("" + ChatColor.DARK_GRAY + "Violação de Jogo");
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
			prova = "poderá ser anexada posteriormente!";
		} else {
			prova = "deverá ser anexada!";
		}
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.chatViolations");
		if(Main.pl.getConfig().get("punishments.chatViolations") == null) {
			punisher.closeInventory();
			punisher.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Não foram encontradas violações de chat configuradas");
			return;
		}
		for(String s : c.getKeys(false)) {
			ItemStack chat = new ItemStack(Material.NETHER_STAR);
			ItemMeta chatm = chat.getItemMeta();
			List<String> descchat = new ArrayList<String>();
			descchat.add(ChatColor.AQUA + "Descrição");
			descchat.add("");
			descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
			descchat.add("");
			descchat.add(ChatColor.WHITE + "Severidade: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
			descchat.add("");
			descchat.add(ChatColor.DARK_RED + "Uma prova " + prova);
			chatm.setLore(descchat);
			chatm.setDisplayName(ChatColor.DARK_GRAY + c.getString(s + ".stname") + " - " + c.getString(s + ".name"));
			chat.setItemMeta(chatm);
			items.add(chat);
		}
		new ScrollerInventory(items, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished, punisher);
	}
	
	
	public static void openTPunishJ(Player punisher, String punished, boolean inact) {
		String prova = "";
		if(inact) {
			prova = "poderá ser anexada posteriormente!";
		} else {
			prova = "deverá ser anexada!";
		}
		
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		ConfigurationSection c = Main.pl.getConfig().getConfigurationSection("punishments.gameViolations");
		if(Main.pl.getConfig().get("punishments.gameViolations") == null) {
			punisher.closeInventory();
			punisher.sendMessage(ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Não foram encontradas violações de jogo configuradas");
			return;
		}
		for(String s : c.getKeys(false)) {
			ItemStack chat = new ItemStack(Material.NETHER_STAR);
			ItemMeta chatm = chat.getItemMeta();
			List<String> descchat = new ArrayList<String>();
			descchat.add(ChatColor.AQUA + "Descrição");
			descchat.add("");
			descchat.add(ChatColor.GRAY + c.getString(s + ".description"));
			descchat.add("");
			descchat.add(ChatColor.WHITE + "Severidade: " + ChatColor.YELLOW + getSev(c.getString(s + ".stname"), punished));
			descchat.add("");
			descchat.add(ChatColor.DARK_RED + "Uma prova " + prova);
			chatm.setLore(descchat);
			chatm.setDisplayName(ChatColor.DARK_GRAY + c.getString(s + ".stname") + " - " + c.getString(s + ".name"));
			chat.setItemMeta(chatm);
			items.add(chat);
		}
		
		new ScrollerInventory(items, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished, punisher);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void openFPunish(Player punisher, String punished, boolean inact, String tipo,int sev, String sig, String desc) {
		tip = tipo;
		seve = sev;
		sigla = sig;
		descr = desc; 
		
		Inventory inv = Bukkit.createInventory(null, 9*5, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished);
		String flag = "";
		String prova2 = "";
		String sla = "";
		String tipopun = "";
		if((tipo.equalsIgnoreCase("chat") || tipo.equalsIgnoreCase("jogo")) && sev <3) {
			tipopun = "Aviso";
		}
		if(tipo.equalsIgnoreCase("chat") && sev > 2) {
			tipopun = "Mute";
		}
		if(tipo.equalsIgnoreCase("jogo") && sev > 2) {
			tipopun = "Ban";
		}
		if(inact) {
			flag = "Flagrante";
			sla = "em " + ChatColor.GREEN + "flagrante";
			prova2 = "poderá ser anexada posteriormente!";
		} else {
			flag = "Denúncia";
			prova2 = "deverá ser anexada!";
			sla = "com base em uma " + ChatColor.GREEN + "denúncia";
		}
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    desccab.add("" + ChatColor.DARK_RED + ChatColor.BOLD + "PUNIR: " + ChatColor.RED + "Revisão e punimento");
	    desccab.add("");
	    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + "" + flag);
	    desccab.add("" + ChatColor.WHITE + "Tipo de punição: " + ChatColor.YELLOW + "" + tipopun);
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
	    
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    flagr = new ItemStack(Material.DISPENSER);
	    flagrm = flagr.getItemMeta();
	    List<String> descflagr = new ArrayList<String>();
	    descflagr.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Flagrante");
	    descflagr.add("");
	    descflagr.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + "" + punished);
	    descflagr.add("" + ChatColor.GRAY + "em flagrante");
	    descflagr.add("");
	    descflagr.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
	    descflagr.add("");
	    descflagr.add("" + ChatColor.YELLOW + "Clique para alterar para o modo " + ChatColor.AQUA + "denúncia");
	    flagrm.setLore(descflagr);
	    flagrm.setDisplayName("" + ChatColor.DARK_GRAY + "Flagrante");
	    flagr.setItemMeta(flagrm);
	    
	    denun = new ItemStack(Material.PAPER);
	    denunm = denun.getItemMeta();
	    List<String> descdenun = new ArrayList<String>();
	    descdenun.add("" + ChatColor.AQUA + "Modo de Punição: " + ChatColor.YELLOW + "Denúncia");
	    descdenun.add("");
	    descdenun.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + "" + punished);
	    descdenun.add("" + ChatColor.GRAY + "com base em uma denúncia");
	    descdenun.add("");
	    descdenun.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
	    descdenun.add("");
	    descdenun.add("" + ChatColor.YELLOW + "Clique para alterar para o modo " + ChatColor.AQUA + "flagrante");
	    denunm.setLore(descdenun);
	    denunm.setDisplayName("" + ChatColor.DARK_GRAY + "Denúncia");
	    denun.setItemMeta(denunm);
	    
	    prova = new ItemStack(Material.ITEM_FRAME);
	    provam = prova.getItemMeta();
	    List<String> descprova = new ArrayList<String>();
	    descprova.add("" + ChatColor.AQUA + "Anexo de prova");
	    descprova.add("");
	    descprova.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + "" + punished);
	    descprova.add("" + ChatColor.GRAY + "" + sla);
	    descprova.add("");
	    descprova.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
	    descprova.add("");
	    descprova.add("" + ChatColor.YELLOW + "Clique para anexar uma prova");
	    provam.setLore(descprova);
	    provam.setDisplayName("" + ChatColor.DARK_GRAY + "Anexar uma Prova");
	    prova.setItemMeta(provam);
	    
	    conf = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
	    confm = conf.getItemMeta();
	    desccab.add("");
	    desccab.add("" + ChatColor.GREEN + "Clique para punir");
	    confm.setLore(desccab);
	    confm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para punir " + ChatColor.AQUA + "" + punished + " " + ChatColor.DARK_GRAY + "" + sla);
	    conf.setItemMeta(confm);
	    
	    canc = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
	    cancm = canc.getItemMeta();
	    List<String> desccanc = new ArrayList<String>();
	    desccanc.add("" + ChatColor.RED + "Clique para cancelar a punição e sair do inventário");
	    cancm.setLore(desccanc);
	    cancm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para cancelar a punição");
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
		Inventory inv = Bukkit.createInventory(null, 9*3, "" + ChatColor.DARK_RED + "Punições: " + ChatColor.RED + punished);
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    desccab.add("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punir: " + ChatColor.RED + "Escolha a violação para");
	    desccab.add("" + ChatColor.RED + "editar a punição.");
	    desccab.add("");
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Punições de: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    pjogo = new ItemStack(Material.DIAMOND_SWORD);
	    pjogom = pjogo.getItemMeta();
	    List<String> descpjogo = new ArrayList<String>();
	    descpjogo.add("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "" + punished + " recebeu um total de " + ChatColor.YELLOW + "" + getTotal(punished, 2));
	    descpjogo.add("" + ChatColor.RED + "punições de jogo. Clique aqui para edita-la(s)");
	    pjogom.setLore(descpjogo);
	    pjogom.setDisplayName("" + ChatColor.DARK_GRAY + "Violações de Jogo");
	    pjogo.setAmount(getTotal(punished, 2));
	    pjogo.setItemMeta(pjogom);
	    
	    pchat = new ItemStack(Material.BOOK_AND_QUILL);
	    pchatm = pchat.getItemMeta();
	    List<String> descpchat = new ArrayList<String>();
	    descpchat.add("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "" + punished + " recebeu um total de " + ChatColor.YELLOW + "" + getTotal(punished, 1));
	    descpchat.add("" + ChatColor.RED + "punições de chat. Clique aqui para edita-la(s)");
	    pchatm.setLore(descpchat);
	    pchatm.setDisplayName("" + ChatColor.DARK_GRAY + "Violações de Chat");
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
				modos = "Violação de Chat";
			}
			if(res.getInt("Modo") == 2) {
				modos = "Violação de Jogo";
			}
			String flag = "Não";
			if(res.getBoolean("Tipo")) {
				flag = "Sim";
			}
			String expira = "Não";
			Date data1 = new Date(res.getLong("Inicio"));
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
			if(res.getInt("Sev") != 10 && res.getInt("Sev") > 2) {
				Date data2 = new Date(res.getLong("Fim"));
				expira = sf.format(data2);
			}
			String cancel = "Não";
			if(res.getBoolean("Cancelado")) {
				cancel = "Sim";
			}
			
			ItemStack punicao = new ItemStack(Material.DIAMOND_SPADE);
			ItemMeta punicaom = punicao.getItemMeta();
			List<String> dp = new ArrayList<String>();
			dp.add("" + ChatColor.WHITE + "Punição: " + ChatColor.DARK_RED + "" + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + "" + getName(res.getString("Sigla")));
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
			punicaom.setLore(dp);
			punicaom.setDisplayName("" + ChatColor.DARK_GRAY + "" + res.getInt("id"));
			punicao.setItemMeta(punicaom);
			
			items.add(punicao);
		}
		new ScrollerInventory(items, "" + ChatColor.DARK_RED + "Violações", punisher);
		
	}
	
	public static void editPunish(Player p, int id)throws SQLException {
		Statement s = Main.c.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM punish WHERE id=" + id + ";");
		Inventory inv = Bukkit.createInventory(null, 9*6, ChatColor.DARK_RED + res.getString("Sigla") + "#" + res.getInt("id"));
		
		res.next();
		flpun = res.getBoolean("Tipo");
		String vi = "chat";
		if(res.getInt("Modo") == 1) {
			tpun = new ItemStack(Material.BOOK_AND_QUILL);
		} else {
			tpun = new ItemStack(Material.DIAMOND_SWORD);
			vi = "jogo";
		}
		tpunm = tpun.getItemMeta();
		List<String> dt = new ArrayList<String>();
		dt.add("" + ChatColor.DARK_RED + "Punição> " + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + "" + getName(res.getString("Sigla")));
		dt.add("" + ChatColor.YELLOW + "" + res.getString("Desc"));
		tpunm.setDisplayName("" + ChatColor.DARK_GRAY + "Violação de " + vi);
		tpunm.setLore(dt);
		tpun.setItemMeta(tpunm);
		
		cpun = new ItemStack(Material.REDSTONE_BLOCK);
		cpunm = cpun.getItemMeta();
		cpunm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para cancelar a punição");
		cpun.setItemMeta(cpunm);
		
		spun = new ItemStack(Material.STAINED_CLAY, 1, (short)5);
		spunm = spun.getItemMeta();
		spunm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para salvar as alterações na punição");
		spun.setItemMeta(spunm);
		
		sepun = new ItemStack(Material.REDSTONE_TORCH_ON);
		sepunm = sepun.getItemMeta();
		List<String> saa = new ArrayList<String>();
		saa.add("" + ChatColor.WHITE + "Severidade atual: " + res.getInt("Sev"));
		saa.add("" + ChatColor.WHITE + "Nova severidade: " + seve);
		sepunm.setLore(saa);
		sepunm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para alterar a severidade");
		sepun.setItemMeta(sepunm);
		
		ppun = new ItemStack(Material.ITEM_FRAME);
		ppunm = ppun.getItemMeta();
		List<String> sa = new ArrayList<String>();
		sa.add("" + ChatColor.WHITE + "Prova atual: " + res.getString("Prova"));
		sa.add("" + ChatColor.WHITE + "Nova prova: " + provaa);
		ppunm.setLore(sa);
		ppunm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para anexar/editar a prova");
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
		fpunm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para alternar entre o modo flagrante/denúncia");
		fpun.setItemMeta(fpunm);
		
		sair = new ItemStack(Material.IRON_DOOR);
		sairm = sair.getItemMeta();
		sairm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para sair da edição");
		sair.setItemMeta(sairm);
		
		excluir = new ItemStack(Material.BARRIER);
		excluirm = excluir.getItemMeta();
		excluirm.setDisplayName("" + ChatColor.DARK_GRAY + "Excluir punição do Banco de Dados");
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
		Inventory inv = Bukkit.createInventory(null, 9*5, "" + ChatColor.DARK_RED + "Editar Severidade");
		
		sev1 = new ItemStack(Material.STAINED_CLAY, 1, (short)2);
		sev1m = sev1.getItemMeta();
		sev1m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 1");
		sev1.setItemMeta(sev1m);
		
		sev2 = new ItemStack(Material.STAINED_CLAY, 2, (short)10);
		sev2m = sev2.getItemMeta();
		sev2m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 2");
		sev2.setItemMeta(sev2m);
		
		sev3 = new ItemStack(Material.STAINED_CLAY, 3, (short)3);
		sev3m = sev3.getItemMeta();
		sev3m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 3");
		sev3.setItemMeta(sev3m);
		
		sev4 = new ItemStack(Material.STAINED_CLAY, 4, (short)11);
		sev4m = sev4.getItemMeta();
		sev4m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 4");
		sev4.setItemMeta(sev4m);
		
		sev5 = new ItemStack(Material.STAINED_CLAY, 5, (short)5);
		sev5m = sev5.getItemMeta();
		sev5m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 5");
		sev5.setItemMeta(sev5m);
		
		sev6 = new ItemStack(Material.STAINED_CLAY, 6, (short)13);
		sev6m = sev6.getItemMeta();
		sev6m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 6");
		sev6.setItemMeta(sev6m);
		
		sev7 = new ItemStack(Material.STAINED_CLAY, 7, (short)4);
		sev7m = sev7.getItemMeta();
		sev7m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 7");
		sev7.setItemMeta(sev7m);
		
		sev8 = new ItemStack(Material.STAINED_CLAY, 8, (short)1);
		sev8m = sev8.getItemMeta();
		sev8m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 8");
		sev8.setItemMeta(sev8m);
		
		sev9 = new ItemStack(Material.STAINED_CLAY, 9, (short)14);
		sev9m = sev9.getItemMeta();
		sev9m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 9");
		sev9.setItemMeta(sev9m);
		
		sev10 = new ItemStack(Material.REDSTONE_BLOCK, 10);
		sev10m = sev10.getItemMeta();
		sev10m.setDisplayName("" + ChatColor.DARK_GRAY + "Severidade 10");
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
					p.sendMessage("" + ChatColor.BLUE + "Editar Punição> " + ChatColor.GRAY + "Digite o link da prova no chat. O inventário será aberto em seguida.");
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
					p.sendMessage("" + ChatColor.BLUE + "Editar Punição> A punição foi editada com sucesso.");
					fla = "";
					s.close();
					editando.remove(p.getName());
					return;
				}
				if(e.getCurrentItem().isSimilar(cpun)) {
					e.setCancelled(true);
					p.closeInventory();
					Statement s = Main.c.createStatement();
					s.execute("UPDATE punish SET Cancelado=1, CancelBy='" + p.getName() + "' WHERE id=" + editando.get(p.getName()) + ";");
					p.sendMessage("" + ChatColor.BLUE + "Cancelar Punição> " + ChatColor.GRAY + "A punição " + ChatColor.RED + "" + editando.get(p.getName()) + " " + ChatColor.GRAY + "foi cancelada com sucesso");
					ResultSet res = s.executeQuery("SELECT * FROM punish WHERE id=" + editando.get(p.getName()) + ";");
					res.next();
					if(Bukkit.getPlayer(res.getString("Nome")) instanceof Player) {
						Player a = Bukkit.getPlayer(res.getString("Nome"));
						a.sendMessage("" + ChatColor.BLUE + "Punição> " + ChatColor.GOLD + "Sua punição " + ChatColor.DARK_RED + "" + res.getString("Sigla") + "#" + res.getInt("id") + ": " + ChatColor.RED + "" + getName(res.getString("Sigla")) + " " + ChatColor.GOLD + "foi cancelada por um administrador.");
					}
					fla = "";
					return;
				}
				if(e.getCurrentItem().isSimilar(excluir)) {
					e.setCancelled(true);
					p.closeInventory();
					Statement s = Main.c.createStatement();
					s.execute("DELETE FROM punish WHERE id=" + editando.get(p.getName()));
					p.sendMessage("" + ChatColor.BLUE + "Excluir Punição> " + ChatColor.GRAY + "A punição " + ChatColor.RED + "" + editando.get(p.getName()) + " " + ChatColor.GRAY + "foi excluida com sucesso!");
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
				}
				if(e.getCurrentItem().isSimilar(flagr)) {
					p.closeInventory();
					flagra = false;
					reabrirInv(p);
					e.setCancelled(true);
				}
				if(e.getCurrentItem().isSimilar(denun)) {
					p.closeInventory();
					flagra = true;
					reabrirInv(p);
					e.setCancelled(true);
				}
				if(e.getCurrentItem().isSimilar(prova)) {
					e.setCancelled(true);
					emprova.add(p.getName());
					p.closeInventory();
					p.sendMessage("" + ChatColor.BLUE + "Punir> " + ChatColor.GRAY + "Digite o link da prova no chat. O inventário será aberto em seguida.");
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
				}
				if(e.getCurrentItem().isSimilar(conf)) {
					e.setCancelled(true);
					if(provaa.equalsIgnoreCase("")) {
						if(!flagra) {
							p.sendMessage("" + ChatColor.DARK_RED + "Punir> " + ChatColor.RED + "Uma prova precisa ser anexada no modo denúncia.");
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
				ss.sendMessage("" + ChatColor.BLUE + "Punição> " + ChatColor.RED + "" + punished + " " + ChatColor.GRAY + "foi punido(a) por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void BanMute(String punished, String desc, String sigl, String prova, boolean inact, String tipo, int sev, long exp) {
		Player p = Bukkit.getPlayer(punished);
		String flag = "";
		if(inact) {
			flag = "" + ChatColor.AQUA + "em flagrante";
		} else {
			flag = "" + ChatColor.GOLD + "por denúncia";
		}
		if(!(p instanceof Player)) 	{
			return;
		}
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date data = new Date(exp);
		if(tipo.equalsIgnoreCase("chat") && sev !=10) {
			if(exp != -1) {
				p.sendMessage("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "até " + ChatColor.RED + "" + sf.format(data) + " BRT " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + prova + " \n" + ChatColor.YELLOW + "" + desc);
			} else {
				p.sendMessage("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi calado por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + prova + " \n" + ChatColor.YELLOW + "" + desc);
			}
			
		} else {
			if(exp != -1) {
				p.kickPlayer("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.GOLD + "até " + ChatColor.RED + "" + sf.format(data) + " BRT " + ChatColor.YELLOW + "(" + getRemaing(exp) + ") " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + prova + " \n" + ChatColor.YELLOW + "" + desc);
			} else {
				p.kickPlayer("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi banido por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + getId(punished, sigl) + "] " + ChatColor.RED + "permanentemente " + flag + " " + ChatColor.GOLD + "com esta prova: \n" + ChatColor.RED + "" + prova + " \n" + ChatColor.YELLOW + "" + desc);
			}
		}
	}
	
	public static String getRemaing(long exp) {
		String sla = "";
		if(exp == -1) {
			return "Não expira";
		}
		long agora = System.currentTimeMillis();
		long pronto = exp - agora;
		if(pronto < 0) {
			return "Expirado";
		}
	
		long sec = pronto / 1000;
		long min = sec / 60;
		long hora = min / 60;
		long dia = hora / 24;
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
				flaga = ChatColor.AQUA + "em flagrante";
			} else {
				flaga = ChatColor.GOLD + "por denúncia";
			}
			p.sendMessage("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + id + "] " + flaga + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + "" + proof + " \n" + ChatColor.YELLOW + "" + desc + "\n" + ChatColor.GOLD + "Digite '" + ChatColor.RED + "entendi" + ChatColor.GOLD + "' para poder jogar e falar novamente.");
			emwarn.add(punished);
		}
	}
	
	public static String getLastWarn(String punished) {
		String msg = "";
		try {
			Statement s = Main.c.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM punish WHERE Nome='" + punished + "' AND Sev < 3 ORDER BY id;");
			if(!res.next()) {
				return null;
			}
			String sigla = res.getString("Sigla");
			msg = "" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + getName(res.getString("Sigla")) + " " + ChatColor.DARK_RED + "[" + sigla.toUpperCase() + "#" + getId(punished, sigla) + "] " + res.getBoolean("Tipo") + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + "" + res.getString("Prova") + " \n" + ChatColor.YELLOW + "" + res.getString("Desc") + "\n" + ChatColor.GOLD + "Digite '" + ChatColor.RED + "entendi" + ChatColor.GOLD + "' para poder jogar e falar novamente.";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
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
			s.setString(12, "Uma prova será anexada posteriormente.");
			s.setString(13, desc);
			s.setString(14, punisher.getName());
			s.execute();	
			s.close();
			st.close();
			res.close();
			if(sev < 3) {
				sendWarn(punished, "Uma prova será anexada posteriormente.", sigl, flagra, desc, getId(punished, sigl));			
			} else {
				BanMute(punished, desc, sigl, "Uma prova será anexada posteriormente.", inact, tipo, sev, sla);
			}
			for(Player ss : Bukkit.getOnlinePlayers()) {
				ss.sendMessage("" + ChatColor.BLUE + "Punição> " + ChatColor.RED + "" + punished + " " + ChatColor.GRAY + "foi punido(a) por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "(" + getMsg(tipo, sev) + ")" + ChatColor.GRAY + ".");
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
