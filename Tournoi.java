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
public class Tournoi {
    
    private ArrayList<Equipe> equipes;
    private Tableau tableau;
    private int cagnotte;
    private boolean inscriptionsOuvertes;
    private String nom;
    private int prix;
    private Barman barman;
    
    public Tournoi(String pNom, int pPrix, Barman pBarman){
        
        equipes = new ArrayList();
        cagnotte = 0;
        inscriptionsOuvertes = true;
        nom = pNom;
        prix = pPrix;
        barman = pBarman;
        
    }
    
        
    public void fermetureInscription(){
        
        barman.parler("LES INSCRIPTIONS POUR LE TOURNOI " + nom + " SONT CLOSES");
        
        inscriptionsOuvertes = false;
        
        tableau = new Tableau(equipes);
        
    }
    
    public void annonceTableau(){
        
        barman.parler("VOICI LE NOUVEAU TABLEAU :");
        tableau.afficheTab();
          
        
    }
    
    public void annonceTableauFinal(){
        
        barman.parler("VOICI LE TABLEAU FINAL :");
        tableau.afficheTabFinal();
          
        
    }
    
    public void ajoutEquipe(Equipe equipe){
        
                
        if(inscriptionsOuvertes){
            
            if (!(equipes.contains(equipe))){
                
                barman.parler("Ok c'est " + prix + " euros l'inscription");
                
                if(payment(equipe)){
                    
                    equipe.getJoueur1().getIdentite().parler("Ok voila l'argent");
                    
                    equipes.add(equipe);
                    
                    barman.parler("Merci, vous êtes inscrits");
                    
                }
                
                else{equipe.getJoueur1().getIdentite().parler("Ok je reviens quand j'ai l'argent");}

            }
            
            else{barman.parler("Désolé mais vous êtes déjà incrits");}
            
        }
        
        else{barman.parler("Désolé mais les inscriptions sont closes");}
        
    }
    
    public boolean payment(Equipe equipe){
        
        boolean valide = false;
        int sommeJ1 = prix / 2 ;            
        int sommeJ2 = prix - sommeJ1;
        
        if (equipe.getJoueur1().getIdentite().getPorteMonnaie() > sommeJ1 && equipe.getJoueur2().getIdentite().getPorteMonnaie() > sommeJ2){
            
            equipe.getJoueur1().getIdentite().setPorteMonnaie(equipe.getJoueur1().getIdentite().getPorteMonnaie() - sommeJ1);
            equipe.getJoueur2().getIdentite().setPorteMonnaie(equipe.getJoueur2().getIdentite().getPorteMonnaie() - sommeJ2);     
            
            cagnotte = cagnotte + sommeJ1 + sommeJ2;
            
            valide = true;
            
        }
        
        return valide;
        
    }
    
    public void match(Equipe A, Equipe B){
        
        tableau.resultatMatch(A, B, 2, 1);
              
    }
    
    public void deroulementMatchs(){
        
        barman.parler("LE TOURNOI EST LANCE !");
        
        Calendrier calendrier = new Calendrier(equipes);
        
        for (int i = 0; i < calendrier.getClendrier().size(); i++){                      
            
            match(calendrier.getClendrier().get(i)[0], calendrier.getClendrier().get(i)[1]);
            annonceTableau();
            
        }
        
        tableau.resultatFinal();
        annonceTableauFinal();
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public ArrayList<Equipe> getEquipes(){
        
        return equipes;
        
    }
    
    public int getCagnotte(){
        
        return cagnotte;
        
    }
    
    public Tableau getTableau(){
        
        return tableau;
        
    }
    
    public boolean getInscriptionsOuvertes(){
        
        return inscriptionsOuvertes;
        
    }
    
    public String getNom(){
        
        return nom;
        
    }
    
    public int getPrix(){
        
        return prix;
        
    }
    
    public void setEquipes(ArrayList<Equipe> pEquipes){
        
        equipes = pEquipes;
        
    }
    
    public void setCagnotte(int pCagnotte){
        
        cagnotte = pCagnotte;
        
    }
    
    public void setTableau(Tableau pTableau){
        
        tableau = pTableau;
        
    }
    
    public void setInscriptionsOuvertes(boolean bool){
        
        inscriptionsOuvertes = bool;
        
    }
}
