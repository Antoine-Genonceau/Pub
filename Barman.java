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
public class Barman extends Humain{
    
    private Caisse caisse;
    private Stock stock;
    
    public Barman(){
    
        super(); 
        stock = new Stock();
        caisse = new Caisse();
    
}
    
    
    public Barman(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri); 
        stock = new Stock();
        caisse = new Caisse();
                
    }
    
    
    public void encaissement(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() + somme);
        
    }
    
    public void decaissement(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() - somme);
        
    }
    
    public int verifBoisson(StockBoisson boisson){
                      
        int boissonNonDispo = 0;
        
        for (int i = 0; i < stock.getStock().size(); i++){
                                    
            if (stock.getStock().get(i).getBoisson().equals(boisson.getBoisson()) && stock.getStock().get(i).getNombre() < boisson.getNombre()){
                
                boissonNonDispo++;
                
            }
            
        }
        
        return boissonNonDispo;
        
    }
    
    public Commande[] verifBoisson(Commande commande){
        
        Commande tabVerif[] = new Commande[2];
        
        Commande commandeDispo = new Commande();
        
        commandeDispo = commande;
        
        Commande commandeNonDispo = new Commande();
        
        for (int i = 0; i < commande.getCommande().size(); i++){         
                        
            CommandeBoisson commandeBoissonNonDispo = new CommandeBoisson();           
                    
            int boissonNonDispo = verifBoisson(commande.getCommande().get(i).getStockBoisson());
               
            if (boissonNonDispo > 0){
            
                commandeBoissonNonDispo.getStockBoisson().setBoisson(commande.getCommande().get(i).getStockBoisson().getBoisson().clone());
            
            }
             
            for(int j = 0; j < boissonNonDispo; j++){                
                
                commandeBoissonNonDispo.getStockBoisson().setNombre(commandeBoissonNonDispo.getStockBoisson().getNombre() + 1);
                
                commandeBoissonNonDispo.getListeConsomateur().add(commandeDispo.getCommande().get(i).getListeConsomateur().get(0));
                
                commandeDispo.getCommande().get(i).getStockBoisson().setNombre(commandeDispo.getCommande().get(i).getStockBoisson().getNombre() - 1);
                
                commandeDispo.getCommande().get(i).getListeConsomateur().remove(0);    
               
                
            }        
            
            if (commandeDispo.getCommande().get(i).getStockBoisson().getNombre() == 0){
                
                commandeDispo.getCommande().remove(i);
                
            }
            
            if (commandeBoissonNonDispo.getStockBoisson().getNombre() > 0){
            
                commandeNonDispo.getCommande().add(commandeBoissonNonDispo);
            
            }
            
        }     
        
        tabVerif[0] = commandeDispo;
        
        tabVerif[1] = commandeNonDispo;
        
        
        
        return tabVerif;
        
    } 
    
    
    public void chercherBoisson(StockBoisson boisson){
                
        for (int i = 0; i < stock.getStock().size(); i++){
            
            if (stock.getStock().get(i).getBoisson() == boisson.getBoisson()){
                
                stock.getStock().get(i).setNombre(stock.getStock().get(i).getNombre() - boisson.getNombre());
                
            }
            
        }
                
    }
    
    
    
    
    public void chercherBoisson(Commande commande){
                
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            chercherBoisson(commande.getCommande().get(i).getStockBoisson());           
            
        }     
       
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setCaisse(Caisse pCaisse){
        
        
        caisse = pCaisse;
        
    }
    
    public void setStock(Stock pStock){
        
        stock = pStock;
        
    }
    
    public Caisse getCaisse(){
        
        return caisse;
        
    }
    
    public Stock getStock(){
        
        return stock;
        
    }
    @Override
    public Barman clone(){        
        
        return new Barman(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri());        
        
    }
    
    public boolean equals(Barman pBarman){
        
        
        return (super.equals(pBarman));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
