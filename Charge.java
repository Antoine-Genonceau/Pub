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
public class Charge {
    
    Bar bar;
    Fournisseur fournisseur;
    boolean chargement;
    
    public Charge(){
        
        bar = new Bar();
        fournisseur = new Fournisseur();
        chargement = false;
        
    }
    
    public Charge(Bar pBar, Fournisseur pFournisseur){
        
        bar = pBar;
        fournisseur = pFournisseur;
        chargement = true;
        
    }
    
}
