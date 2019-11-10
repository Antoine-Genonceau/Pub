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
 * 
 * Une CommandeBoisson contient un StockBoisson et une liste de consomateurs correspondants
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
    
    public CommandeBoisson(Object humain){   
        
        
        listeConsomateur = new ArrayList<>();
                
        stockBoisson = new StockBoisson(); 
        
        if (humain.getClass() == Client.class){
            
            
            
        }
        
    }
    
    /**
     * Un client commande sa boisson favorite
     * 
     * @param client 
     */
    
    public void setCommandeBoisson(Client client){   
        
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(client);
        
        stockBoisson = new StockBoisson(client.getBoissonFav(), 1); 
        
    }
    
    /**
     * Un serveur commande de l'eau
     * 
     * @param serveur 
     */
    
    public void setCommandeBoisson(Serveur serveur){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(serveur);
        
        Boisson eau = new Boisson("eau", 0, 0, 0);
        
        stockBoisson = new StockBoisson(eau, 1);
        
    }
    
    /**
     * La patronne commande sa boisson favorite
     * 
     * @param patronne 
     */
    
    public void setCommandeBoisson(Patronne patronne){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(patronne);
        
        stockBoisson = new StockBoisson(patronne.getBoissonFav(), 1);
        
    }
    
    /**
     * Le barman commande la boisson sans alcool la plus presente en stock
     * 
     * @param barman 
     */
    
    public void setCommandeBoisson(Barman barman){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(barman);
        
        Boisson eau = new Boisson("eau", 0, 0, 0);
        
        int max = 0;
        
        Boisson boissonMax = eau;
        
        for (int i = 0; i < barman.getStock().getStock().size(); i++){
            
            if (barman.getStock().getStock().get(i).getBoisson().getUniteAlcool() == 0){
                
                if (barman.getStock().getStock().get(i).getNombre() > max){
                    
                    max = barman.getStock().getStock().get(i).getNombre();
                    
                    boissonMax = barman.getStock().getStock().get(i).getBoisson();
                    
                }
                
            }
            
        }
        
        if (boissonMax == eau){
            
            stockBoisson = new StockBoisson(boissonMax, 0);
            
        }
        
        
        else{
        
            stockBoisson = new StockBoisson(boissonMax, 1);
        
        }
        
    }
    
    /**
     * En second choix un client choisit sa boisson de secours
     * 
     * @param client 
     */
    
    public void setCommandeBoissonBis(Client client){   
        
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(client);
        
        stockBoisson = new StockBoisson(client.getBoissonFavBis(), 1); 
        
    }
    
    /**
     * En second choix le serveur choisit de l'eau
     * 
     * @param serveur 
     */
    
    public void setCommandeBoissonBis(Serveur serveur){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(serveur);
        
        Boisson eau = new Boisson("eau", 0, 0, 0);
        
        stockBoisson = new StockBoisson(eau, 1);
        
    }
    
    /**
     * En second choix la patronne choisit sa boisson de secours
     * 
     * @param patronne 
     */
    
    public void setCommandeBoissonBis(Patronne patronne){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(patronne);
        
        stockBoisson = new StockBoisson(patronne.getBoissonFavBis(), 1);
        
    }
    
    /**
     * En second choix le barman choisit de l'eau
     * 
     * @param barman 
     */
    
    public void setCommandeBoissonBis(Barman barman){
        
        listeConsomateur = new ArrayList<>();
        
        listeConsomateur.add(barman);
        
        Boisson eau = new Boisson("eau", 0, 0, 0);
        
        
        stockBoisson = new StockBoisson(eau, 1);      
                
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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
        
        return "Commande de : "+ stockBoisson.getNombre() + " " + stockBoisson.getBoisson().getNom() + " Pour " + toStringConsomateur(listeConsomateur);
        
    }
    
    public String toStringConsomateur(ArrayList<Humain> humain){
        
        String string = new String();
        
        for (int i = 0; i<humain.size(); i++){
            
            string = string + ", " + humain.get(i).getSurnom();
            
        }
        
        return string;
        
    }
}
