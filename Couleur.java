/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Edouard
 */
public class Couleur {
    
	String nom;
	public Couleur (String nomCouleur){
	this.nom = nomCouleur ;
	}
        
	public static Couleur Coeur = new Couleur ("Coeur");
	public static Couleur Pique = new Couleur ("Pique");
	public static Couleur Carreau = new Couleur ("Carreau");
	public static Couleur Trefle = new Couleur ("Trefle");
}

