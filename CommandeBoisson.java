/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.ArrayList;

/**
 *
 * @author Toine
 */
public class CommandeBoisson {
    
    private StockBoisson stockBoisson;
    private ArrayList<Humain> listeConsomateur;
    
    public CommandeBoisson(){
        
        stockBoisson = new StockBoisson();
        listeConsomateur = new ArrayList<>();
        
    }
    
    public CommandeBoisson(StockBoisson pStockBoisson, ArrayList<Humain> pListeConsomateur){
        
        stockBoisson = pStockBoisson;
        
        listeConsomateur = pListeConsomateur;
        
    }
    
    
    public void setStockBoisson(StockBoisson pStockBoisson){
        
        stockBoisson = pStockBoisson;
        
    }
    
    public void setListeConsomateur(ArrayList<Humain> pListeConsomateur){
        
        listeConsomateur = pListeConsomateur;
        
    }
    
    public StockBoisson getStockBoisson(){
        
        return stockBoisson;
        
    }
    
    public ArrayList<Humain> getListeConsomateur(){
        
        return listeConsomateur;
        
    }
    
    @Override
    public CommandeBoisson clone(){
        
        return new CommandeBoisson(stockBoisson.clone(), (ArrayList<Humain>) listeConsomateur.clone());
        
    }
    
    public boolean equals(CommandeBoisson pCommandeBoisson){
        
        return (stockBoisson.equals(pCommandeBoisson.getStockBoisson()) && listeConsomateur.equals(pCommandeBoisson.listeConsomateur));        
                
    }
    
    @Override
    public String toString(){
        
        return "Commande de : " + stockBoisson.toString() + " Pour " + listeConsomateur.toString();
        
    }
}
