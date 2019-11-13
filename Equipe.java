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
public class Equipe {
    
    private Joueur joueur1;
    private Joueur joueur2;
    private String nom;
    private int pointsTournoi;
    private int points;
    
    
    public Equipe(){
        
        joueur1 = new Joueur();
        joueur2 = new Joueur();
        nom = new String();
        
    }
    
    public Equipe(Joueur pJoueur1, Joueur pJoueur2, String pNom){
        
        joueur1 = pJoueur1;
        joueur2 = pJoueur2;
        nom = pNom;
        
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
    
    public int getPointsTournoi(){
        
        return pointsTournoi;
        
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
    
    public void setPointsTournoi(int pPointsTournoi){
        
        pointsTournoi = pPointsTournoi;
        
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
