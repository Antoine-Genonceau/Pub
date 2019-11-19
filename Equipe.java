/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Toine
 * 
 * L'objet Equipe est composé de deux joueurs, d'un nom et d'un nombre de points durant une manche
 * 
 */
public class Equipe implements Serializable{
    
    private Joueur joueur1;
    private Joueur joueur2;
    private String nom;
    private int points;
    
    public Equipe(){
        
        joueur1 = new Joueur();
        joueur2 = new Joueur();
        nom = new String();
        
    }
        
    public Equipe(String pNom, Joueur pJoueur1, Joueur pJoueur2){
        
        joueur1 = pJoueur1;
        joueur2 = pJoueur2;
        nom = pNom;
        
    }
    
    public Equipe(Joueur pJoueur1, Joueur pJoueur2, String pNom){
        
        joueur1 = pJoueur1;
        joueur2 = pJoueur2;
        nom = pNom;
        
    }
    
    /**
     * Offrir un coup a boire à une autre equipe
     * 
     * @param equipeAd  equipe à laquelle on offre a boiree
     * @param barman barman auquel on fait la demande
     */
    
    public void tourneeAdversaire(Equipe equipeAd, Barman barman) throws StopCommandeException{
        
        ArrayList<Humain> joueurs = new ArrayList<>();
        
        joueurs.add(equipeAd.getJoueur1().getIdentite());
        joueurs.add(equipeAd.getJoueur2().getIdentite());
        joueurs.add(joueur1.getIdentite());
        joueurs.add(joueur2.getIdentite());
        
        if (joueur1.getIdentite().getPorteMonnaie() > joueur2.getIdentite().getPorteMonnaie()){
            
            joueur1.getIdentite().consommer(joueurs, barman);
            
        }
        
        else{
            
            joueur2.getIdentite().consommer(joueurs, barman);
            
        }
        
    }
    
    /**
     * Compte le nombre de serveurs present dans l'équipe
     * 
     * @return retourne le nombre de serveur
     */
    
    public int compteServeur(){
        
        int compteur = 0;
        
        if (joueur1.getIdentite().getClass() == Serveur.class){                
                
                compteur++;
                
            }
            
        if (joueur2.getIdentite().getClass() == Serveur.class){
                
                compteur++;
            }
        
        
        return compteur;
        
    }
    
    /**
     * Demande d'inscription à un tournoi
     * 
     * @param nomTournoi nom du tournoi auquel l'équipe souhaite s'inscrire
     * @param barman barman auprès duquel l'équipe effectue sa demande d'inscription
     */
    
    public void inscription(Tournoi tournoi, Barman barman){
        
        boolean done = false;
        
        joueur1.getIdentite().parler("Bonjour on voudrais s'inscrire au tournoi " + tournoi.getNom() + ", on est l'équipe " + nom);
        
        for (int i = 0; i < barman.getTournois().size(); i++){
            
            if (barman.getTournois().get(i).equals(tournoi)){
                
                barman.getTournois().get(i).ajoutEquipe(this);
                
                done = true;
            }
            
        }
        
        if(!done){
            
            barman.parler("Désolé mais ce tournoi n'éxiste pas");
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Joueur getJoueur1(){
        
        return joueur1;
        
    }
    
    public Joueur getJoueur2(){
        
        return joueur2;
        
    }
    
    public String getNom(){
        
        return nom;
        
    }
    
    public int getPoints(){
        
        return points;
        
    }
        
    public void setJoueur1(Joueur pJoueur1){
        
        joueur1 = pJoueur1;
        
    }
    
    public void setjoueur2(Joueur pJoueur2){
        
        joueur2 = pJoueur2;
        
    }
    
    public void setNom(String pNom){
        
        nom = pNom;
        
    }
    
    public void setPoints(int pPoints){
        
        points = pPoints;
        
    }
    
    
    
    @Override
    public String toString(){
        
        return nom;
        
    }
    
    public Equipe clone(){
        
        return new Equipe(joueur1, joueur2, nom);
        
    }
    
    public boolean equals(Equipe pEquipe){
        
        return nom.equals(pEquipe.getNom());
        
    }
}
