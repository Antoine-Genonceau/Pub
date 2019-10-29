/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 */
public class Barman extends Humain{
    
    Caisse caisse;
    Stock stock;
    
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
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setCaisse(Caisse pCaisse){
        
        
        caisse = pCaisse;
        
    }
    
    public void setStock(Stock pStock){
        
        stock = pStock;
        
    }
    
    @Override
    public Barman clone(){        
        
        return new Barman(surnom, prenom, porteMonnaie, popularite, cri);        
        
    }
    
    public boolean equals(Barman pBarman){
        
        
        return (super.equals(pBarman));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
