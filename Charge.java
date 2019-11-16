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
 * 
 * L'objet charge contient les informations chargées
 */
public class Charge {
    
    Bar bar;
    Fournisseur fournisseur;
    ArrayList<Boisson> boissons;
    boolean chargement;
    
    public Charge(){
        
        bar = new Bar();
        fournisseur = new Fournisseur();
        boissons = new ArrayList<>();
        chargement = false;
        
    }
    
    public Charge(Bar pBar, Fournisseur pFournisseur, ArrayList<Boisson> pBoissons){
        
        bar = pBar;
        fournisseur = pFournisseur;
        boissons = pBoissons;
        chargement = true;
        
    }
    
}
