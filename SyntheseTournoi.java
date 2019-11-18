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
 */
public class SyntheseTournoi implements Serializable{
    
    private int nombreConsomations;
    private int nombreJoueurs;
    
    public SyntheseTournoi(){
        
        nombreConsomations = 0;
        nombreJoueurs = 0;
        
    }
    
    public int getNombreConsomations(){
        
        return nombreConsomations;
        
    }
    
    public int getNombreJoueurs(){
        
        return nombreJoueurs;
        
    }
    
    public void setNombreConsomations(int nombre){
        
        nombreConsomations = nombre;
        
    }
    
    public void setNombreJoueurs(int nombre){
        
        nombreJoueurs = nombre;
        
    }
}
