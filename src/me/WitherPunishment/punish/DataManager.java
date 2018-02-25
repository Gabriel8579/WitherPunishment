package me.WitherPunishment.punish;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;

import me.WitherPunishment.Main;

public class DataManager {
	
	static String url = "jdbc:sqlite:" + Main.pl.getDataFolder().getAbsolutePath().replace("\\", "/") + "/playerdata/sql.db";
	
	public static void createDb() {
		File dir = new File(Main.pl.getDataFolder() + "/playerdata");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File db = new File(Main.pl.getDataFolder() + "/playerdata", "sql.db");
		if(!db.exists()) {
			try {
				db.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				Connection conn = DriverManager.getConnection(url);
	            if (conn != null) {
	                Main.pl.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "WitherPunishment Datas> " + ChatColor.YELLOW + "a new database has been created.");
	            }
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			
		}
		createTable();
		
	}
	
	public static void createTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	Nome VARCHAR(16) NOT NULL,\n"
                + " UUID VARCHAR(36), \n"
                + " IP VARCHAR(15), \n"
                + "	capacity real\n"
                + ");";
		String sql2 = "CREATE TABLE IF NOT EXISTS punish (\r\n" + 
				"	id	INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + 
				"	Nome	VARCHAR ( 16 ) NOT NULL,\r\n" + 
				"	UUID	VARCHAR ( 36 ),\r\n" + 
				"	IP	VARCHAR ( 15 ),\r\n" + 
				"	Sigla	VARCHAR ( 6 ) NOT NULL,\r\n" + 
				"	Sev	INT ( 2 ),\r\n" + 
				"	Modo	INT ( 1 ),\r\n" + 
				"	Tipo	INT ( 1 ),\r\n" + 
				"	capacity	real,\r\n" + 
				"	Inicio	INT ( 50 ),\r\n" + 
				"	Fim	INT ( 50 ),\r\n" + 
				"	Cancelado	INT ( 1 ),\r\n" + 
				"	CancelBy	VARCHAR ( 16 ),\r\n" + 
				"	Prova	VARCHAR ( 128 ),\r\n" + 
				"	Desc	VARCHAR ( 256 ),\r\n" + 
				"	Staff	VARCHAR ( 16 )\r\n" + 
				");";

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(url);
			Statement s = conn.createStatement();
			s.execute(sql);
			s.execute(sql2);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection connect() {
		Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
        
    }
	
	
	
	
	
}
