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
    
    
    public Patronne(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri, pBoissonFav, pBoissonFavBis, pNiveauAlcool, pSigne);    
                
    }
    
    public void receptionFournisseur(Stock stockNonDispo, Caisse caisse, int prix){
        
        this.parler("Merci, voici le reglement !");
        
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
                
                this.parler(bar.getServeurs().get(i).getPrenom() + " vire moi " + client.getPrenom());
                               
            }           
 
            i = i + 1;            
        }           
        
    }
    
    public void rappelOrdre(Client client){
        
        BlackListed blacklisted = new BlackListed(client);
        
        this.parler("Arretez de servir " + client.getPrenom());
        
        bar.getBlackList().getListeNoire().add(blacklisted);
        
    }
    
    public void checkEtatClient(){
        
        for(int i = 0; i < bar.getClients().size(); i++){
            
            if (bar.getClients().get(i).getNiveauAlcool() > 50){
                
                rappelOrdre(bar.getClients().get(i));
                
            }
            
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
        
        return new Patronne(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri(), super.getBoissonFav(), super.getBoissonFavBis(), super.getNiveauAlcool(), super.getSigne());        
        
    }
    
    public boolean equals(Patronne pPatronne){
        
        return (super.equals(pPatronne));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
