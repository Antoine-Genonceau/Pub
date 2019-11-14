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
public class Equipe {
    
    private Joueur joueur1;
    private Joueur joueur2;
    private String nom;
    private int points;
    
    
        
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
    
    public void tourneeAdversaire(Equipe equipeAd, Barman barman){
        
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
    
    public void inscription(String nomTournoi, Barman barman){
        
        boolean done = false;
        
        joueur1.getIdentite().parler("Bonjour on voudrais s'inscrire au tournoi " + nomTournoi + ", on est l'équipe " + nom);
        
        for (int i = 0; i < barman.getTournois().size(); i++){
            
            if (barman.getTournois().get(i).getNom().equals(nomTournoi)){
                
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
