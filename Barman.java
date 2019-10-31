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
        
        System.out.println("Barman payée" + somme);
        
    }
    
    public void decaissement(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() - somme);
        
    }
    
    public boolean verifBoisson(StockBoisson boisson){
                      
        boolean boissonDispo = false;
        
        for (int i = 0; i < stock.getStock().size(); i++){
            
            if (stock.getStock().get(i).getBoisson() == boisson.getBoisson() && stock.getStock().get(i).getNombre() > boisson.getNombre()){
                
                boissonDispo = true;
                
            }
            
        }
        
        return boissonDispo;
        
    }
    
    public boolean verifBoisson(Commande commande){
        
        boolean verifBoisson = true;
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            if (!this.verifBoisson(commande.getCommande().get(i).getStockBoisson())){
                
                verifBoisson = false;                
                
            }            
            
        }     
       
        return verifBoisson;
        
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
