/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;

/**
 *
 * @author Toine
 * 
 * Un joueur à une identite
 * 
 */
public class Joueur implements Serializable{
    
    private Humain identite;
    
    public Joueur(){
        
        identite = new Humain();
        
    }
    
    public Joueur(Humain pIdentite){
        
        identite = pIdentite;
        
    }
    
    public Humain getIdentite(){
        
        return identite;
        
    }
    
    public boolean equals(Joueur pJoueur){
        
        return identite.equals(pJoueur.getIdentite());
        
    }
    
}
