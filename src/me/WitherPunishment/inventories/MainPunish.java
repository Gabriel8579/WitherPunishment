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

	//Violação de chat
	public static ItemStack abc;
	public static ItemMeta abcm;
	public static ItemStack ae;
	public static ItemMeta aem;
	public static ItemStack as;
	public static ItemMeta asm;
	public static ItemStack bfc;
	public static ItemMeta bfcm;
	public static ItemStack ct;
	public static ItemMeta ctm;
	public static ItemStack dna;
	public static ItemMeta dnam;
	public static ItemStack fec;
	public static ItemMeta fecm;
	public static ItemStack fh;
	public static ItemMeta fhm;
	public static ItemStack fpc;
	public static ItemMeta fpcm;
	public static ItemStack mi;
	public static ItemMeta mim;
	public static ItemStack oe;
	public static ItemMeta oem;
	public static ItemStack oj;
	public static ItemMeta ojm;
	public static ItemStack os;
	public static ItemMeta osm;
	public static ItemStack risme;
	public static ItemMeta rismem;
	//violação de jogo
	public static ItemStack abj;
	public static ItemMeta abjm;
	public static ItemStack aemj;
	public static ItemMeta  aemjm;
	public static ItemStack co;
	public static ItemMeta com;
	public static ItemStack fc;
	public static ItemMeta fcm;
	public static ItemStack gr;
	public static ItemMeta grm;
	public static ItemStack vreb;
	public static ItemMeta vrebm;
	public static ItemStack hc;
	public static ItemMeta hcm;
	public static ItemStack hd;
	public static ItemMeta hdm;
	public static ItemStack hm;
	public static ItemMeta hmm;
	public static ItemStack hmv;
	public static ItemMeta hmvm;
	public static ItemStack mna;
	public static ItemMeta mnam;
	public static ItemStack sh;
	public static ItemMeta shm;
	public static ItemStack ao;
	public static ItemMeta aom;
	public static ItemStack asg;
	public static ItemMeta asgm;
	public static ItemStack coi;
	public static ItemMeta coim;
	public static ItemStack fen;
	public static ItemMeta fenm;
	public static ItemStack pc;
	public static ItemMeta pcm;
	public static ItemStack pf;
	public static ItemMeta pfm;
	public static ItemStack soi;
	public static ItemMeta soim;
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
		    desccab.add("" + ChatColor.DARK_RED + "§lPunir: " + ChatColor.RED + "Escolha o modo de punição");
		    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunir: "+punished);
		    cabecam.setOwner(punished);
		    cabecam.setLore(desccab);
		    cabeca.setItemMeta(cabecam);
		    
		    papel = new ItemStack(Material.PAPER);
		    papelm = papel.getItemMeta();
		    List<String> descpapel = new ArrayList<String>();
		    descpapel.add("§bModo de Punição: " + ChatColor.YELLOW + "Denúncia");
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
		    descejec.add("§bModo de Punição: " + ChatColor.YELLOW + "Flagrante");
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
	    desccab.add("" + ChatColor.DARK_RED + "§lPUNIR: " + ChatColor.RED + "Escolha o tipo de punição");
	    desccab.add("");
	    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + "" + flag);
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    livro = new ItemStack(Material.BOOK_AND_QUILL);
	    livrom = livro.getItemMeta();
	    List<String> descpapel = new ArrayList<String>();
	    descpapel.add("§bTipo de Punição: " + ChatColor.YELLOW + "Violações de Chat");
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
	    descejec.add("§bTipo de Punição: " + ChatColor.YELLOW + "Violações de Jogo");
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
	
	@SuppressWarnings("deprecation")
	public static void openTPunish(Player punisher, String punished, boolean inact) {
		Inventory inv = Bukkit.createInventory(null, 9*4, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished);
		flagra = inact;
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
	    desccab.add("" + ChatColor.DARK_RED + "§lPUNIR: " + ChatColor.RED + "Escolha a violação");
	    desccab.add("");
	    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + "" + flag);
	    desccab.add("" + ChatColor.WHITE + "Tipo de punição: " + ChatColor.YELLOW + "Violação de chat");
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    abc = new ItemStack(Material.BOOK_AND_QUILL);
	    abcm = abc.getItemMeta();
	    List<String> descabc = new ArrayList<String>();
	    descabc.add("§bDescrição");
	    descabc.add("");
	    descabc.add("" + ChatColor.GRAY + "Usar intencionalmente um erro");
	    descabc.add("" + ChatColor.GRAY + "existente no sistema de chat.");
	    descabc.add("");
	    descabc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    abcm.setLore(descabc);
	    abcm.setDisplayName("" + ChatColor.DARK_GRAY + "UBC - Uso de Bug de Chat");
	    abc.setItemMeta(abcm);
	    
	    ae = new ItemStack(Material.BOOK_AND_QUILL);
	    aem = ae.getItemMeta();
	    List<String> descae = new ArrayList<String>();
	    descae.add("§bDescrição");
	    descae.add("");
	    descae.add("" + ChatColor.GRAY + "Discutir persistentemente");
	    descae.add("" + ChatColor.GRAY + "sobre ações de um membro da equipe.");
	    descae.add("");
	    descae.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    aem.setLore(descae);
	    aem.setDisplayName("" + ChatColor.DARK_GRAY + "PAE - Persistir Discussão com Membro da Equipe");
	    ae.setItemMeta(aem);
	    
	    as = new ItemStack(Material.BOOK_AND_QUILL);
	    asm = as.getItemMeta();
	    List<String> descas = new ArrayList<String>();
	    descas.add("§bDescrição");
	    descas.add("");
	    descas.add("" + ChatColor.GRAY + "Enviar mensagem sexual direcionada a um jogador.");
	    descas.add("");
	    descas.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    asm.setLore(descas);
	    asm.setDisplayName("" + ChatColor.DARK_GRAY + "MSJ - Mensagem Sexual a um Jogador");
	    as.setItemMeta(asm);
	    
	    bfc = new ItemStack(Material.BOOK_AND_QUILL);
	    bfcm = bfc.getItemMeta();
	    List<String> descbfc = new ArrayList<String>();
	    descbfc.add("§bDescrição");
	    descbfc.add("");
	    descbfc.add("" + ChatColor.GRAY + "Desfigurar uma palavra protegida com o objetivo de");
	    descbfc.add("" + ChatColor.GRAY + "ignorar a proteção do chat.");
	    descbfc.add("");
	    descbfc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    bfcm.setLore(descbfc);
	    bfcm.setDisplayName("" + ChatColor.DARK_GRAY + "IPC - Ignorar Proteção do Chat");
	    bfc.setItemMeta(bfcm);
	    
	    ct = new ItemStack(Material.BOOK_AND_QUILL);
	    ctm = ct.getItemMeta();
	    List<String> descct = new ArrayList<String>();
	    descct.add("§bDescrição");
	    descct.add("");
	    descct.add("" + ChatColor.GRAY + "Enviar mensagens fazendo jogadores executarem");
	    descct.add("" + ChatColor.GRAY + "comandos indesejaveis intencionamente.");
	    descct.add("");
	    descct.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    ctm.setLore(descct);
	    ctm.setDisplayName("" + ChatColor.DARK_GRAY + "TC- Trolar no Chat");
	    ct.setItemMeta(ctm);
	    
	    dna = new ItemStack(Material.BOOK_AND_QUILL);
	    dnam = dna.getItemMeta();
	    List<String> descdna = new ArrayList<String>();
	    descdna.add("§bDescrição");
	    descdna.add("");
	    descdna.add("" + ChatColor.GRAY + "Fazer divulgações ou anúncios");
	    descdna.add("" + ChatColor.GRAY + "sem autorização de um administrador.");
	    descdna.add("");
	    descdna.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    dnam.setLore(descdna);
	    dnam.setDisplayName("" + ChatColor.DARK_GRAY + "DVC - Divulgação");
	    dna.setItemMeta(dnam);
	    
	    fec = new ItemStack(Material.BOOK_AND_QUILL);
	    fecm = fec.getItemMeta();
	    List<String> descfec = new ArrayList<String>();
	    descfec.add("§bDescrição");
	    descfec.add("");
	    descfec.add("" + ChatColor.GRAY + "Falar no chat dizendo que faz parte da equipe");
	    descfec.add("" + ChatColor.GRAY + "quando não faz.");
	    descfec.add("");
	    descfec.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    fecm.setLore(descfec);
	    fecm.setDisplayName("" + ChatColor.DARK_GRAY + "FSE - Fingir ser da Equipe");
	    fec.setItemMeta(fecm);
	    
	    fh = new ItemStack(Material.BOOK_AND_QUILL);
	    fhm = fh.getItemMeta();
	    List<String> descfh = new ArrayList<String>();
	    descfh.add("§bDescrição");
	    descfh.add("");
	    descfh.add("" + ChatColor.GRAY + "Enviar a mesma mensagem varias vezes.");
	    descfh.add("");
	    descfh.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    fhm.setLore(descfh);
	    fhm.setDisplayName("" + ChatColor.DARK_GRAY + "FLD - Flood");
	    fh.setItemMeta(fhm);
	    
	    fpc = new ItemStack(Material.BOOK_AND_QUILL);
	    fpcm = fpc.getItemMeta();
	    List<String> descfpc = new ArrayList<String>();
	    descfpc.add("§bDescrição");
	    descfpc.add("");
	    descfpc.add("" + ChatColor.GRAY + "Fazer outros jogadores violarem");
	    descfpc.add("" + ChatColor.GRAY + "regras para serem punidos.");
	    descfpc.add("");
	    descfpc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    fpcm.setLore(descfpc);
	    fpcm.setDisplayName("" + ChatColor.DARK_GRAY + "IQR - Incentivar Quebra de Regra");
	    fpc.setItemMeta(fpcm);
	    
	    mi = new ItemStack(Material.BOOK_AND_QUILL);
	    mim = mi.getItemMeta();
	    List<String> descmi = new ArrayList<String>();
	    descmi.add("§bDescrição");
	    descmi.add("");
	    descmi.add("" + ChatColor.GRAY + "Mensagem com conotação sexual ou nojentas.");
	    descmi.add("" + ChatColor.GRAY + "Também é aplicado quando se usa palavrões em excesso.");
	    descmi.add("");
	    descmi.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    mim.setLore(descmi);
	    mim.setDisplayName("" + ChatColor.DARK_GRAY + "MA - Mensagem Abusiva");
	    mi.setItemMeta(mim);
	    
	    oe = new ItemStack(Material.BOOK_AND_QUILL);
	    oem = oe.getItemMeta();
	    List<String> descoe = new ArrayList<String>();
	    descoe.add("§bDescrição");
	    descoe.add("");
	    descoe.add("" + ChatColor.GRAY + "Ofender ou enviar mensagens abusivas a um jogador");
	    descoe.add("" + ChatColor.GRAY + "que seja um membro da equipe.");
	    descoe.add("");
	    descoe.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    oem.setLore(descoe);
	    oem.setDisplayName("" + ChatColor.DARK_GRAY + "OST - Ofensa a Staff");
	    oe.setItemMeta(oem);
	    
	    oj = new ItemStack(Material.BOOK_AND_QUILL);
	    ojm = oj.getItemMeta();
	    List<String> descoj = new ArrayList<String>();
	    descoj.add("§bDescrição");
	    descoj.add("");
	    descoj.add("" + ChatColor.GRAY + "Ofender ou enviar mensagens abusivas a um jogador comum.");
	    descoj.add("");
	    descoj.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    ojm.setLore(descoj);
	    ojm.setDisplayName("" + ChatColor.DARK_GRAY + "OP - Ofensa a Player");
	    oj.setItemMeta(ojm);
	    
	    os = new ItemStack(Material.BOOK_AND_QUILL);
	    osm = os.getItemMeta();
	    List<String> descos = new ArrayList<String>();
	    descos.add("§bDescrição");
	    descos.add("");
	    descos.add("" + ChatColor.GRAY + "Ofender ou enviar mensagens abusivas ao servidor.");
	    descos.add("");
	    descos.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    osm.setLore(descos);
	    osm.setDisplayName("" + ChatColor.DARK_GRAY + "OSV - Ofensa ao Servidor");
	    os.setItemMeta(osm);
	    
	    risme = new ItemStack(Material.BOOK_AND_QUILL);
	    rismem = risme.getItemMeta();
	    List<String> descrisme = new ArrayList<String>();
	    descrisme.add("§bDescrição");
	    descrisme.add("");
	    descrisme.add("" + ChatColor.GRAY + "Dizer a outro jogador que existe um staff");
	    descrisme.add("" + ChatColor.GRAY + "disfarçado no servidor quando realmente existe um.");
	    descrisme.add("");
	    descrisme.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    rismem.setLore(descrisme);
	    rismem.setDisplayName("" + ChatColor.DARK_GRAY + "RME - Revelar um Membro da Equipe");
	    risme.setItemMeta(rismem);
	    
	    
	    inv.setItem(4, cabeca);
	    inv.setItem(11, livro);
	    inv.setItem(15, esp);
	    inv.setItem(10, abc);
	    inv.setItem(11, ae);
	    inv.setItem(12, as);
	    inv.setItem(13, bfc);
	    inv.setItem(14, ct);
	    inv.setItem(15, dna);
	    inv.setItem(16, fec);
	    inv.setItem(19, fh);
	    inv.setItem(20, fpc);
	    inv.setItem(21, mi);
	    inv.setItem(22, oe);
	    inv.setItem(23, oj);
	    inv.setItem(24, os);
	    inv.setItem(25, risme);
	    
	    punisher.openInventory(inv);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void openTPunishJ(Player punisher, String punished, boolean inact) {
		Inventory inv = Bukkit.createInventory(null, 9*5, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Punir: " + punished);
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
	    desccab.add("" + ChatColor.DARK_RED + "§lPUNIR: " + ChatColor.RED + "Escolha a violação");
	    desccab.add("");
	    desccab.add("" + ChatColor.WHITE + "Modo de punição: " + ChatColor.YELLOW + "" + flag);
	    desccab.add("" + ChatColor.WHITE + "Tipo de punição: " + ChatColor.YELLOW + "Violação de jogo");
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    abj = new ItemStack(Material.BOOK_AND_QUILL);
	    abjm = abj.getItemMeta();
	    List<String> descabj = new ArrayList<String>();
	    descabj.add("§bDescrição");
	    descabj.add("");
	    descabj.add("" + ChatColor.GRAY + "Abusar constantemente de erro existente no jogo.");
	    descabj.add("");
	    descabj.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    abjm.setLore(descabj);
	    abjm.setDisplayName("" + ChatColor.DARK_GRAY + "UBJ - Uso de Bug do Jogo");
	    abj.setItemMeta(abjm);
	    
	    aemj = new ItemStack(Material.BOOK_AND_QUILL);
	    aemjm = aemj.getItemMeta();
	    List<String> descaemj = new ArrayList<String>();
	    descaemj.add("§bDescrição");
	    descaemj.add("");
	    descaemj.add("" + ChatColor.GRAY + "Usar intencionalmente um erro existente no mapa.");
	    descaemj.add("");
	    descaemj.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    aemjm.setLore(descaemj);
	    aemjm.setDisplayName("" + ChatColor.DARK_GRAY + "UBM - Uso de Bug do Mapa");
	    aemj.setItemMeta(aemjm);
	    
	    co = new ItemStack(Material.BOOK_AND_QUILL);
	    com = co.getItemMeta();
	    List<String> descco = new ArrayList<String>();
	    descco.add("§bDescrição");
	    descco.add("");
	    descco.add("" + ChatColor.GRAY + "Fazer construções ou desenhos inapropriados.");
	    descco.add("");
	    descco.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    com.setLore(descco);
	    com.setDisplayName("" + ChatColor.DARK_GRAY + "CI - Construção Inapropriada");
	    co.setItemMeta(com);
	    
	    fc = new ItemStack(Material.BOOK_AND_QUILL);
	    fcm = fc.getItemMeta();
	    List<String> descfc = new ArrayList<String>();
	    descfc.add("§bDescrição");
	    descfc.add("");
	    descfc.add("" + ChatColor.GRAY + "Enviar comandos constantemente para");
	    descfc.add("" + ChatColor.GRAY + "floodar o chat de outros jogadores ou");
	    descfc.add("" + ChatColor.GRAY + "para causar lag no servidor.");
	    descfc.add("");
	    descfc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    fcm.setLore(descfc);
	    fcm.setDisplayName("" + ChatColor.DARK_GRAY + "SC - Spam de Comandos");
	    fc.setItemMeta(fcm);
	    
	    gr = new ItemStack(Material.BOOK_AND_QUILL);
	    grm = gr.getItemMeta();
	    List<String> descgr = new ArrayList<String>();
	    descgr.add("§bDescrição");
	    descgr.add("");
	    descgr.add("" + ChatColor.GRAY + "Prejudicar ou Destruir qualquer coisa");
	    descgr.add("" + ChatColor.GRAY + "que não seja sua propositalmente.");
	    descgr.add("");
	    descgr.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    grm.setLore(descgr);
	    grm.setDisplayName("" + ChatColor.DARK_GRAY + "GRF - Griefing");
	    gr.setItemMeta(grm);
	    
	    vreb = new ItemStack(Material.BOOK_AND_QUILL);
	    vrebm = vreb.getItemMeta();
	    List<String> descvreb = new ArrayList<String>();
	    descvreb.add("§bDescrição");
	    descvreb.add("");
	    descvreb.add("" + ChatColor.GRAY + "Fazer construções ou desenhos de mensagens");
	    descvreb.add("" + ChatColor.GRAY + "que violam alguma regra existente.");
	    descvreb.add("");
	    descvreb.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    vrebm.setLore(descvreb);
	    vrebm.setDisplayName("" + ChatColor.DARK_GRAY + "VRCC - Violar Regra de Chat em uma Construção");
	    vreb.setItemMeta(vrebm);
	    
	    hc = new ItemStack(Material.BOOK_AND_QUILL);
	    hcm = hc.getItemMeta();
	    List<String> deschc = new ArrayList<String>();
	    deschc.add("§bDescrição");
	    deschc.add("");
	    deschc.add("" + ChatColor.GRAY + "Utilizar qualquer tipo de hack ou mod que alteram o jogador em");
	    deschc.add("" + ChatColor.GRAY + "sua forma de lutar mas que não altere a sua movimentação.");
	    deschc.add("");
	    deschc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    hcm.setLore(deschc);
	    hcm.setDisplayName("" + ChatColor.DARK_GRAY + "HL - Hack de Luta");
	    hc.setItemMeta(hcm);
	    
	    hd = new ItemStack(Material.BOOK_AND_QUILL);
	    hdm = hd.getItemMeta();
	    List<String> deschd = new ArrayList<String>();
	    deschd.add("§bDescrição");
	    deschd.add("");
	    deschd.add("" + ChatColor.GRAY + "Utilizar derp hack.");
	    deschc.add("");
	    deschc.add("");
	    deschd.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    hdm.setLore(deschd);
	    hdm.setDisplayName("" + ChatColor.DARK_GRAY + "DH - Derp Hack");
	    hd.setItemMeta(hdm);
	    
	    hm = new ItemStack(Material.BOOK_AND_QUILL);
	    hmm = hm.getItemMeta();
	    List<String> deschm = new ArrayList<String>();
	    deschm.add("§bDescrição");
	    deschm.add("");
	    deschm.add("" + ChatColor.GRAY + "Utilizar hack de luta e de movimento ao mesmo tempo.");
	    deschm.add("");
	    deschm.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    hmm.setLore(deschm);
	    hmm.setDisplayName("" + ChatColor.DARK_GRAY + "MH - Múltiplos Hacks");
	    hm.setItemMeta(hmm);
	    
	    hmv = new ItemStack(Material.BOOK_AND_QUILL);
	    hmvm = hmv.getItemMeta();
	    List<String> deschmv = new ArrayList<String>();
	    deschmv.add("§bDescrição");
	    deschmv.add("");
	    deschmv.add("" + ChatColor.GRAY + "Utilizar hack que modifique a movimentação.");
	    deschmv.add("");
	    deschmv.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    hmvm.setLore(deschmv);
	    hmvm.setDisplayName("" + ChatColor.DARK_GRAY + "HMV - Hack de Movimento");
	    hmv.setItemMeta(hmvm);
	    
	    mna = new ItemStack(Material.BOOK_AND_QUILL);
	    mnam = mna.getItemMeta();
	    List<String> descmna = new ArrayList<String>();
	    descmna.add("§bDescrição");
	    descmna.add("");
	    descmna.add("" + ChatColor.GRAY + "Utilizar um mod não autorizado.");
	    descmna.add("");
	    descmna.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    mnam.setLore(descmna);
	    mnam.setDisplayName("" + ChatColor.DARK_GRAY + "MNP - Mod Não Permitido");
	    mna.setItemMeta(mnam);
	    
	    sh = new ItemStack(Material.BOOK_AND_QUILL);
	    shm = sh.getItemMeta();
	    List<String> descsh = new ArrayList<String>();
	    descsh.add("§bDescrição");
	    descsh.add("");
	    descsh.add("" + ChatColor.GRAY + "Executa movimentos suspeitos ou aciona");
	    descsh.add("" + ChatColor.GRAY + "constantemente o sistema anti-cheat.");
	    descsh.add("");
	    descsh.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    shm.setLore(descsh);
	    shm.setDisplayName("" + ChatColor.DARK_GRAY + "SH - Suspeita de Hack");
	    sh.setItemMeta(shm);
	    
	    ao = new ItemStack(Material.BOOK_AND_QUILL);
	    aom = ao.getItemMeta();
	    List<String> descao = new ArrayList<String>();
	    descao.add("§bDescrição");
	    descao.add("");
	    descao.add("" + ChatColor.GRAY + "Utilizar um nick com conotação sexual, ofensivo ou palavrões.");
	    descao.add("");
	    descao.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    aom.setLore(descao);
	    aom.setDisplayName("" + ChatColor.DARK_GRAY + "NOI - Nick Ofensivo ou Inapropriado");
	    ao.setItemMeta(aom);
	    
	    asg = new ItemStack(Material.BOOK_AND_QUILL);
	    asgm = asg.getItemMeta();
	    List<String> descasg = new ArrayList<String>();
	    descasg.add("§bDescrição");
	    descasg.add("");
	    descasg.add("" + ChatColor.GRAY + "Agachar e levantar (shift) rapidamente atrás de um");
	    descasg.add("" + ChatColor.GRAY + "player fingindo estar praticando ato sexual.");
	    descasg.add("");
	    descasg.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    asgm.setLore(descasg);
	    asgm.setDisplayName("" + ChatColor.DARK_GRAY + "FAS - Fingir Ato Sexual");
	    asg.setItemMeta(asgm);
	    
	    coi = new ItemStack(Material.BOOK_AND_QUILL);
	    coim = coi.getItemMeta();
	    List<String> desccoi = new ArrayList<String>();
	    desccoi.add("§bDescrição");
	    desccoi.add("");
	    desccoi.add("" + ChatColor.GRAY + "Utilizar capa com conotação sexual, ofensiva ou com palavrões.");
	    desccoi.add("");
	    desccoi.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    coim.setLore(desccoi);
	    coim.setDisplayName("" + ChatColor.DARK_GRAY + "CI - Capa Inapropriada");
	    coi.setItemMeta(coim);
	    
	    fen = new ItemStack(Material.BOOK_AND_QUILL);
	    fenm = fen.getItemMeta();
	    List<String> descfen = new ArrayList<String>();
	    descfen.add("§bDescrição");
	    descfen.add("");
	    descfen.add("" + ChatColor.GRAY + "Utilizar um nick parecido de algum membro da staff.");
	    descfen.add("");
	    descfen.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    fenm.setLore(descfen);
	    fenm.setDisplayName("" + ChatColor.DARK_GRAY + "FSN - Fingir ser da Staff por Nick");
	    fen.setItemMeta(fenm);
	    
	    pc = new ItemStack(Material.BOOK_AND_QUILL);
	    pcm = pc.getItemMeta();
	    List<String> descpc = new ArrayList<String>();
	    descpc.add("§bDescrição");
	    descpc.add("");
	    descpc.add("" + ChatColor.GRAY + "Conta mal-intencionada (comprometida, duplicada ou hackeada).");
	    descpc.add("");
	    descpc.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    pcm.setLore(descpc);
	    pcm.setDisplayName("" + ChatColor.DARK_GRAY + "CMI - Conta Mal Intencionada");
	    pc.setItemMeta(pcm);
	    
	    pf = new ItemStack(Material.BOOK_AND_QUILL);
	    pfm = pf.getItemMeta();
	    List<String> descpf = new ArrayList<String>();
	    descpf.add("§bDescrição");
	    descpf.add("");
	    descpf.add("" + ChatColor.GRAY + "Forjar uma prova para fazer com que");
	    descpf.add("" + ChatColor.GRAY + "um jogador seja punido injustamente.");
	    descpf.add("");
	    descpf.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    pfm.setLore(descpf);
	    pfm.setDisplayName("" + ChatColor.DARK_GRAY + "FPD - Forjar Prova de Denúncia");
	    pf.setItemMeta(pfm);
	    
	    soi = new ItemStack(Material.BOOK_AND_QUILL);
	    soim = soi.getItemMeta();
	    List<String> descsoi = new ArrayList<String>();
	    descsoi.add("§bDescrição");
	    descsoi.add("");
	    descsoi.add("" + ChatColor.GRAY + "Utilizar skin com conotação sexual, com propaganda ou ofensiva.");
	    descsoi.add("");
	    descsoi.add("" + ChatColor.DARK_RED + "Uma prova " + prova);
	    soim.setLore(descsoi);
	    soim.setDisplayName("" + ChatColor.DARK_GRAY + "SI - Skin Inapropriada");
	    soi.setItemMeta(soim);
	    
	    inv.setItem(4, cabeca);
	    inv.setItem(10, abj);
	    inv.setItem(11, aemj);
	    inv.setItem(12, co);
	    inv.setItem(13, fc);
	    inv.setItem(14, gr);
	    inv.setItem(15, vreb);
	    inv.setItem(16, hc);
	    inv.setItem(19, hd);
	    inv.setItem(20, hm);
	    inv.setItem(21, hmv);
	    inv.setItem(22, mna);
	    inv.setItem(23, sh);
	    inv.setItem(24, ao);
	    inv.setItem(25, asg);
	    inv.setItem(28, coi);
	    inv.setItem(29, fen);
	    inv.setItem(30, pc);
	    inv.setItem(31, pf);
	    inv.setItem(32, soi);
	    
	    punisher.openInventory(inv);
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
			sla = "em §aflagrante";
			prova2 = "poderá ser anexada posteriormente!";
		} else {
			flag = "Denúncia";
			prova2 = "deverá ser anexada!";
			sla = "com base em uma §adenúncia";
		}
		
		cabeca = new ItemStack(397, 1, (short) 3);
	    cabecam = (SkullMeta) cabeca.getItemMeta();
	    List<String> desccab = new ArrayList<String>();
	    desccab.add("" + ChatColor.DARK_RED + "§lPUNIR: " + ChatColor.RED + "Revisão e punimento");
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
	    
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunir: "+punished);
	    cabecam.setOwner(punished);
	    cabecam.setLore(desccab);
	    cabeca.setItemMeta(cabecam);
	    
	    flagr = new ItemStack(Material.DISPENSER);
	    flagrm = flagr.getItemMeta();
	    List<String> descflagr = new ArrayList<String>();
	    descflagr.add("§bModo de Punição: " + ChatColor.YELLOW + "Flagrante");
	    descflagr.add("");
	    descflagr.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + "" + punished);
	    descflagr.add("" + ChatColor.GRAY + "em flagrante");
	    descflagr.add("");
	    descflagr.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
	    descflagr.add("");
	    descflagr.add("" + ChatColor.YELLOW + "Clique para alterar para o modo §bdenúncia");
	    flagrm.setLore(descflagr);
	    flagrm.setDisplayName("" + ChatColor.DARK_GRAY + "Flagrante");
	    flagr.setItemMeta(flagrm);
	    
	    denun = new ItemStack(Material.PAPER);
	    denunm = denun.getItemMeta();
	    List<String> descdenun = new ArrayList<String>();
	    descdenun.add("§bModo de Punição: " + ChatColor.YELLOW + "Denúncia");
	    descdenun.add("");
	    descdenun.add("" + ChatColor.GRAY + "Você está punindo o player " + ChatColor.RED + "" + punished);
	    descdenun.add("" + ChatColor.GRAY + "com base em uma denúncia");
	    descdenun.add("");
	    descdenun.add("" + ChatColor.DARK_RED + "Uma prova " + prova2);
	    descdenun.add("");
	    descdenun.add("" + ChatColor.YELLOW + "Clique para alterar para o modo §bflagrante");
	    denunm.setLore(descdenun);
	    denunm.setDisplayName("" + ChatColor.DARK_GRAY + "Denúncia");
	    denun.setItemMeta(denunm);
	    
	    prova = new ItemStack(Material.ITEM_FRAME);
	    provam = prova.getItemMeta();
	    List<String> descprova = new ArrayList<String>();
	    descprova.add("§bAnexo de prova");
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
	    desccab.add("§aClique para punir");
	    confm.setLore(desccab);
	    confm.setDisplayName("" + ChatColor.DARK_GRAY + "Clique para punir §b" + punished + " " + ChatColor.DARK_GRAY + "" + sla);
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
	    desccab.add("" + ChatColor.DARK_RED + "§lPunir: " + ChatColor.RED + "Escolha a violação para");
	    desccab.add("" + ChatColor.RED + "editar a punição.");
	    desccab.add("");
	    cabecam.setDisplayName("" + ChatColor.DARK_RED + "§lPunições de: "+punished);
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
		
		if(flpun) {
			fpun = new ItemStack(Material.DISPENSER);
		} else {
			fpun = new ItemStack(Material.PAPER);
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
				        //If the pressed item was a nextpage button
				        if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ScrollerInventory.nextPageName)){
				            e.setCancelled(true);
				            //If there is no next page, don't do anything
				            if(inv.currpage >= inv.pages.size()-1){
				                return;
				            }else{
				                //Next page exists, flip the page
				                inv.currpage += 1;
				                p.openInventory(inv.pages.get(inv.currpage));
				            }
				                        //if the pressed item was a previous page button
				        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ScrollerInventory.previousPageName)){
				             e.setCancelled(true);
				             //If the page number is more than 0 (So a previous page exists)
				             if(inv.currpage > 0){
				             //Flip to previous page
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
					p.closeInventory();
					return;
				}
				if(e.getCurrentItem().isSimilar(fpun)) {
					e.setCancelled(true);
					p.closeInventory();
					flpun = !flpun;
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
					int sla = 0;
					if(flpun) {
						sla = 1;
					}
					Statement s = Main.c.createStatement();
					s.execute("UPDATE punish SET" + prova + sev + fim + " Tipo=" + sla + " WHERE id=" + editando.get(p.getName()) + ";");
					p.sendMessage("" + ChatColor.BLUE + "Editar Punição> A punição foi editada com sucesso.");
					
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return;
				}
				if(e.getCurrentItem().isSimilar(pchat)) {
					e.setCancelled(true);
					try {
						editarPunicao(p, punish.get(p.getName()), 1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
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
				//violações de chat
				if(e.getCurrentItem().isSimilar(abc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("ubc", punished), "ubc", "Usar intencionalmente um erro existente no sistema de chat.");
				}
				if(e.getCurrentItem().isSimilar(ae)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("pae", punished), "pae", "Discutir persistentemente sobre ações de um membro da equipe.");
				}
				if(e.getCurrentItem().isSimilar(as)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("msj", punished), "msj", "Enviar mensagem sexual direcionada a um jogador.");
				}
				if(e.getCurrentItem().isSimilar(bfc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("ipc", punished), "ipc", "Desfigurar uma palavra protegida com o objetivo de ignorar a proteção do chat.");
				}
				if(e.getCurrentItem().isSimilar(ct)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("tc", punished), "tc", 	"Enviar mensagens fazendo jogadores executarem comandos indesejaveis intencionamente.");
				}
				if(e.getCurrentItem().isSimilar(dna)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("dvc", punished), "dvc", "Fazer divulgações ou anúncios sem autorização de um administrador.");
				}
				if(e.getCurrentItem().isSimilar(fec)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("fse", punished), "fse", "Falar no chat dizendo que faz parte da equipe quando não faz.");
				}
				if(e.getCurrentItem().isSimilar(fh)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("fld", punished), "fld", "Enviar a mesma mensagem varias vezes.");
				}
				if(e.getCurrentItem().isSimilar(fpc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("iqr", punished), "iqr", "Fazer outros jogadores violarem regras para serem punidos.");
				}
				if(e.getCurrentItem().isSimilar(mi)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("ma", punished), "ma", "Mensagem com conotação sexual ou nojentas.");
				}
				if(e.getCurrentItem().isSimilar(oe)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("ost", punished), "ost", " Ofender ou enviar mensagens abusivas a um jogador que seja um membro da equipe.");
				}
				if(e.getCurrentItem().isSimilar(oj)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("op", punished), "op", "Ofender ou enviar mensagens abusivas a um jogador comum.");
				}
				if(e.getCurrentItem().isSimilar(os)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("osv", punished), "osv", "Ofender ou enviar mensagens abusivas ao servidor.");
				}
				if(e.getCurrentItem().isSimilar(risme)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "chat", getSev("rme", punished), "rme", "Dizer a outro jogador que existe um staff disfarçado no servidor quando realmente existe um.");
				}

				//Violações de jogo
				if(e.getCurrentItem().isSimilar(abj)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("ubj", punished), "ubj", "Abusar constantemente de erro existente no jogo.");
				}
				if(e.getCurrentItem().isSimilar(aemj)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("ubm", punished), "ubm", "Usar intencionalmente um erro existente no mapa.");
				}
				if(e.getCurrentItem().isSimilar(co)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("ci", punished), "ci", "Fazer construções ou desenhos inapropriados.");
				}
				if(e.getCurrentItem().isSimilar(fc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("sc", punished), "sc", "Enviar comandos constantemente para floodar o chat de outros jogadores ou para causar lag no servidor.");
				}
				if(e.getCurrentItem().isSimilar(gr)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("grf", punished), "grf", "Prejudicar ou Destruir qualquer coisa que não seja sua propositalmente.");
				}
				if(e.getCurrentItem().isSimilar(vreb)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("vrcc", punished), "vrcc", "Fazer construções ou desenhos de mensagens que violam alguma regra existente.");
				}
				if(e.getCurrentItem().isSimilar(hc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("hl", punished), "hl", "Utilizar qualquer tipo de hack ou mod que alteram o jogador em sua forma de lutar mas que não altere a sua movimentação.");
				}
				if(e.getCurrentItem().isSimilar(hd)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("dh", punished), "dh", "Utilizar derp hack.");
				}
				if(e.getCurrentItem().isSimilar(hm)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("mh", punished), "mh", "Utilizar hack de luta e de movimento ao mesmo tempo.");
				}
				if(e.getCurrentItem().isSimilar(hmv)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("hmv", punished), "hmv", "Utilizar hack que modifique a movimentação.");
				}
				if(e.getCurrentItem().isSimilar(mna)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("mnp", punished), "mnp", "Utilizar um mod não autorizado.");
				}
				if(e.getCurrentItem().isSimilar(sh)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("sh", punished), "sh", "Executa movimentos suspeitos ou aciona constantemente o sistema anti-cheat.");
				}
				if(e.getCurrentItem().isSimilar(ao)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("noi", punished), "noi", "Utilizar um nick com conotação sexual, ofensivo ou palavrões.");
				}
				if(e.getCurrentItem().isSimilar(asg)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("fas", punished), "fas", "Agachar e levantar (shift) rapidamente atrás de um player fingindo estar praticando ato sexual.");
				}
				if(e.getCurrentItem().isSimilar(coi)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("ci", punished), "ci", "Utilizar capa com conotação sexual, ofensiva ou com palavrões.");
				}
				if(e.getCurrentItem().isSimilar(fen)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("fsn", punished), "fsn", "Utilizar um nick parecido de algum membro da staff.");
				}
				if(e.getCurrentItem().isSimilar(pc)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("cmi", punished), "cmi", "Conta mal-intencionada (comprometida, duplicada ou hackeada).");
				}
				if(e.getCurrentItem().isSimilar(pf)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("fpd", punished), "fpd", "Forjar uma prova para fazer com que um jogador seja punido injustamente.");
				}
				if(e.getCurrentItem().isSimilar(soi)) {
					e.setCancelled(true);
					String punished = punish.get(p.getName());
					p.closeInventory();
					openFPunish(p, punished, flagra, "jogo", getSev("si", punished), "si", "Utilizar skin com conotação sexual, com propaganda ou ofensiva.");
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
			flag = "§bem flagrante";
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
		String namePun = "";
		if(sigl.equalsIgnoreCase("ubc")) {
			namePun = "Uso de Bug do Chat";
		}
		if(sigl.equalsIgnoreCase("PAE")) {
			namePun = "Persistir Discussão com Membro da Equipe";
		}
		if(sigl.equalsIgnoreCase("msj")) {
			namePun = "Mensagem Sexual a um Jogador";
		}
		if(sigl.equalsIgnoreCase("ipc")) {
			namePun = "Ignorar Proteção do Chat";
		}
		if(sigl.equalsIgnoreCase("tc")) {
			namePun = "Trolar no Chat";
		}
		if(sigl.equalsIgnoreCase("dvc")) {
			namePun = "Divulgação";
		}
		if(sigl.equalsIgnoreCase("fse")) {
			namePun = "Fingir ser da Equipe";
		}
		if(sigl.equalsIgnoreCase("fld")) {
			namePun = "Flood";
		}
		if(sigl.equalsIgnoreCase("iqr")) {
			namePun = "Incentivar Quebra de Regra";
		}
		if(sigl.equalsIgnoreCase("ma")) {
			namePun = "Mensagem Abusiva";
		}
		if(sigl.equalsIgnoreCase("ost")) {
			namePun = "Ofensa a Staff";
		}
		if(sigl.equalsIgnoreCase("op")) {
			namePun = "Ofensa a Player";
		}
		if(sigl.equalsIgnoreCase("osv")) {
			namePun = "Ofensa ao Servidor";
		}
		if(sigl.equalsIgnoreCase("rme")) {
			namePun = "Revelar um Membro da Equipe";
		}
		if(sigl.equalsIgnoreCase("ubj")) {
			namePun = "Uso de Bug do Jogo";
		}
		if(sigl.equalsIgnoreCase("ubm")) {
			namePun = "Uso de Bug do Mapa";
		}
		if(sigl.equalsIgnoreCase("ci")) {
			namePun = "Construção Inapropriada";
		}
		if(sigl.equalsIgnoreCase("sc")) {
			namePun = "Spam de Comandos";
		}
		if(sigl.equalsIgnoreCase("grf")) {
			namePun = "Griefing";
		}
		if(sigl.equalsIgnoreCase("vrcc")) {
			namePun = "Violar Regra de Chat em uma Construção";
		}
		if(sigl.equalsIgnoreCase("hl")) {
			namePun = "Hack de Luta";
		}
		if(sigl.equalsIgnoreCase("dh")) {
			namePun = "Derp Hack";
		}
		if(sigl.equalsIgnoreCase("mh")) {
			namePun = "Múltiplos Hacks";
		}
		if(sigl.equalsIgnoreCase("hmv")) {
			namePun = "Hack de Movimento";
		}
		if(sigl.equalsIgnoreCase("mnp")) {
			namePun = "Mod Não Permitido";
		}
		if(sigl.equalsIgnoreCase("sh")) {
			namePun = "Suspeita de Hack";
		}
		if(sigl.equalsIgnoreCase("noi")) {
			namePun = "Nick Ofensivo ou Inapropriado";
		}
		if(sigl.equalsIgnoreCase("fas")) {
			namePun = "Fingir Ato Sexual";
		}
		if(sigl.equalsIgnoreCase("ci")) {
			namePun = "Capa Inapropriada";
		}
		if(sigl.equalsIgnoreCase("fsn")) {
			namePun = "Fingir ser da Staff por Nick";
		}
		if(sigl.equalsIgnoreCase("cmi")) {
			namePun = "Conta Mal Intencionada";
		}
		if(sigl.equalsIgnoreCase("fpd")) {
			namePun = "Forjar Prova de Denúncia";
		}
		if(sigl.equalsIgnoreCase("si")) {
			namePun = "Skin Inapropriada";
		}
		return namePun;
	}
	
	public static void sendWarn(String punished, String proof, String sigl, boolean inact, String desc, int id) {
		if(Bukkit.getPlayer(punished) instanceof Player) {
			Player p = Bukkit.getPlayer(punished);
			String flag = "";
			if(inact) {
				flag = "§bem flagrante";
			} else {
				flag = "" + ChatColor.GOLD + "por denúncia";
			}
			p.sendMessage("" + ChatColor.DARK_RED + "Punição> " + ChatColor.GOLD + "Você foi alertado por " + ChatColor.RED + "" + getName(sigl) + " " + ChatColor.DARK_RED + "[" + sigl.toUpperCase() + "#" + id + "] " + flag + " " + ChatColor.GOLD + "com esta prova:\n" + ChatColor.RED + "" + proof + " \n" + ChatColor.YELLOW + "" + desc + "\n" + ChatColor.GOLD + "Digite '" + ChatColor.RED + "entendi" + ChatColor.GOLD + "' para poder jogar e falar novamente.");
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
		if(sev >4 && sev < 8) {
			msg += " de 1 dia";
		}
		if(sev >7 && sev < 10) {
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
		if(sigl.equalsIgnoreCase("ubc")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("pae")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("msj")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("ipc")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("tc")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("dvc")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("fse")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("fld")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("iqr")) {
			severidade = 3;
		}
		if(sigl.equalsIgnoreCase("ma")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("ost")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("op")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("osv")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("rme")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("ubj")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("ubm")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("ci")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("sc")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("grf")) {
			severidade = 3;
		}
		if(sigl.equalsIgnoreCase("vrc")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("hl")) {
			severidade = 8;
		}
		if(sigl.equalsIgnoreCase("dh")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("mh")) {
			severidade = 10;
		}
		if(sigl.equalsIgnoreCase("hmv")) {
			severidade = 10;
		}
		if(sigl.equalsIgnoreCase("mnp")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("sh")) {
			severidade = 1;
		}
		if(sigl.equalsIgnoreCase("noi")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("fas")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("ci")) {
			severidade = 3;
		}
		if(sigl.equalsIgnoreCase("fsn")) {
			severidade = 2;
		}
		if(sigl.equalsIgnoreCase("cmi")) {
			severidade = 10;
		}
		if(sigl.equalsIgnoreCase("fpd")) {
			severidade = 3;
		}
		if(sigl.equalsIgnoreCase("si")) {
			severidade = 1;
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
