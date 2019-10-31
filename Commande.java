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
    
    public Commande(ArrayList<CommandeBoisson> listeCommande){
        
        /**Formater liste**/
        
        commande = new ArrayList<>();
        
        boolean done = false;
        
        for (int i = 0; i < listeCommande.size(); i++){            
                        
            done = false;
            
            for (int j = 0; j < commande.size(); j++){
            
                if (listeCommande.get(i).getStockBoisson().getBoisson().equals(commande.get(j).getStockBoisson().getBoisson())){
                    
                    commande.get(j).getStockBoisson().setNombre(commande.get(j).getStockBoisson().getNombre() + 1);
                    
                    
                    for (int k = 0; k < listeCommande.get(i).getListeConsomateur().size(); k++){
                        
                        commande.get(j).getListeConsomateur().add(listeCommande.get(i).getListeConsomateur().get(k));
                        
                    }
                    
                    done = true;
                    
                }                
                
                
            }
            
            
            
            if (!done){
                
                CommandeBoisson commandeTemp = new CommandeBoisson();
                
                commandeTemp.setStockBoisson(listeCommande.get(i).getStockBoisson().clone());
                
                commandeTemp.setListeConsomateur((ArrayList<Humain>) listeCommande.get(i).getListeConsomateur().clone());
            
                commande.add(commandeTemp);
                
            }                 
            
        }        
        
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
