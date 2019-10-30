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
public class Commande {
    
    private ArrayList<CommandeBoisson> commande;
    
    public Commande(){
        
        commande = new ArrayList<>();
        
    }
    
    public Commande(ArrayList<CommandeBoisson> pCommande){
        
        commande = pCommande;
        
    }
    
    public void setCommande(ArrayList<CommandeBoisson> pCommande){
        
        commande = (ArrayList<CommandeBoisson>) pCommande.clone();
        
    }
    
    public ArrayList<CommandeBoisson> getCommande(){
        
        return commande;
    }
    
    @Override
    public Commande clone(){
        
        return new Commande((ArrayList<CommandeBoisson>) commande.clone());
        
    }
    
    public boolean equals(Commande pCommande){
        
        return this.commande.equals(pCommande.getCommande());
        
    }
    
    @Override
    public String toString(){
        
        return commande.toString();
        
    }
    
    
}
