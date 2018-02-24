package me.WitherPunishment.punish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ScrollerInventory{
	public ArrayList<Inventory> pages = new ArrayList<Inventory>();
    public UUID id;
    public int currpage = 0;
    public static HashMap<UUID, ScrollerInventory> users = new HashMap<UUID, ScrollerInventory>();
   //Running this will open a paged inventory for the specified player, with the items in the arraylist specified.
    public ScrollerInventory(ArrayList<ItemStack> items, String name, Player p){
        this.id = UUID.randomUUID();
//create new blank page
        Inventory page = getBlankPage(name);
       //According to the items in the arraylist, add items to the ScrollerInventory
        for(int i = 0;i < items.size(); i++){
       //If the current page is full, add the page to the inventory's pages arraylist, and create a new page to add the items.
            if(page.firstEmpty() == 46){
                pages.add(page);
                page = getBlankPage(name);
                page.addItem(items.get(i));
            }else{
//Add the item to the current page as per normal
                page.addItem(items.get(i));
            }
        }
        pages.add(page);
//open page 0 for the specified player
        p.openInventory(pages.get(currpage));
        users.put(p.getUniqueId(), this);
    }



   public static final String nextPageName = ChatColor.AQUA + "Próxima página";
   public static final String previousPageName = ChatColor.AQUA + "Página anterior";
   //This creates a blank page with the next and prev buttons
    private Inventory getBlankPage(String name){
        Inventory page = Bukkit.createInventory(null, 54, name);

        ItemStack nextpage =  new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5);
        ItemMeta meta = nextpage.getItemMeta();
        meta.setDisplayName(nextPageName);
        nextpage.setItemMeta(meta);

        ItemStack prevpage = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 2);
        meta = prevpage.getItemMeta();
        meta.setDisplayName(previousPageName);
        prevpage.setItemMeta(meta);


        page.setItem(53, nextpage);
        page.setItem(45, prevpage);
        return page;
    }
}
