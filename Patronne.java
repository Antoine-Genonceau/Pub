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
public class Patronne extends Client{
    
    private Bar bar;
    
    public Patronne(){
    
        super();  
    
}
    
    
    public Patronne(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri, pBoissonFav, pBoissonFavBis, pNiveauAlcool, pSigne);    
                
    }
    
    public void receptionFournisseur(Stock stockNonDispo, Caisse caisse, int prix){
        
        System.out.println("stockNonDispo" + stockNonDispo);
        
        this.setPorteMonnaie(this.getPorteMonnaie() - prix);
        
        caisse.setLiquidite(caisse.getLiquidite() + prix);
        
    }
    
    public void acheterBoisson(Commande commande, Barman barman){      
                            
            barman.chercherBoisson(commande);
            
    }
    
    public void exclureClient(Client client){
        
        boolean done = false;
        
        int i = 0;
        
        while(!done && i < bar.getServeurs().size()){
            
            if (bar.getServeurs().get(i).getSigne().getValeur() == "gros"){
                
                bar.virerClient(client, bar.getServeurs().get(i));
                
            }           
 
            i = i + 1;            
        }           
        
    }
    
    public ArrayList<Humain> reclamationTG(){
        
        ArrayList<Humain> liste = new ArrayList<>();
        
                
        for (int i = 0; i < bar.getClients().size(); i++){
            
            liste.add(bar.getClients().get(i));
            
        }
        
        return liste;
        
    }
    
    public void setBar(Bar pBar){
        
        bar = pBar;
        
    }
    
    @Override
    public Patronne clone(){        
        
        return new Patronne(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri(), super.getBoissonFav(), super.getBoissonFavBis(), super.getNiveauAlcool(), super.getSigne());        
        
    }
    
    public boolean equals(Patronne pPatronne){
        
        return (super.equals(pPatronne));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
