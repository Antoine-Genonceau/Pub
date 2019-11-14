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
        
        tableau = new Tableau(equipes, barman);
        
    }
    
        
    public int compteServeur(){
        
        int compteur = 0;
        
        for (int i = 0; i < equipes.size(); i++){
            
            if (equipes.get(i).getJoueur1().getIdentite().getClass() == Serveur.class){                
                
                compteur++;
                
            }
            
            if (equipes.get(i).getJoueur1().getIdentite().getClass() == Serveur.class){
                
                compteur++;
            }
        }
        
        return compteur;
        
    }
    
    public boolean autorisation(Equipe equipe){
        
        boolean bool = true;
        
        if (compteServeur() + equipe.compteServeur() > barman.getPatronne().getBar().getServeurs().size() - 1){
            
            bool = false;
            
        }        
        
        return bool;
        
    }
    
        
    public void ajoutEquipe(Equipe equipe){
        
                
        if(inscriptionsOuvertes){
            
            if (!(equipes.contains(equipe))){
                
                if(autorisation(equipe)){
                
                    barman.parler("Ok c'est " + prix + " euros l'inscription");
                
                    if(payment(equipe)){
                    
                        equipe.getJoueur1().getIdentite().parler("Ok voila l'argent");
                    
                        equipes.add(equipe);
                    
                        barman.parler("Merci, vous êtes inscrits");
                    
                    }
                
                    else{equipe.getJoueur1().getIdentite().parler("Ok je reviens quand j'ai l'argent");
                    
                    }
                   
                }
                
                else{
                    
                    barman.parler("Désolé on a déjà trop de serveurs inscrits au tournoi");
                }

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
        
        System.out.println("\n" + "Debut du match entre " + A.getNom()+ " et " + B.getNom() + "\n");
        
        int scoreA = 0;
        int scoreB = 0;
        double rand = 0;
        
        while(scoreA != 2 && scoreB != 2){
            
            rand = Math.random();
            
            
            if (rand > 0.5){
                
                scoreA = scoreA + 1;                
                System.out.println("\n" + A + " : " + scoreA + "   " + B + " : " + scoreB + "\n");
                B.tourneeAdversaire(A, barman);
            
                
            }
            
            else{
                
                scoreB = scoreB + 1;
                System.out.println("\n" + A + " : " + scoreA + "   " + B + " : " + scoreB + "\n");
                A.tourneeAdversaire(B, barman);
            
                
            }
            
                     
        }
        
        
               
        if (scoreA > scoreB){
            
            barman.parler("L'équipe " + A + " L'emporte face à l'équipe " + B);
            
        }
        
        else{
            
            barman.parler("L'équipe " + B + " L'emporte face à l'équipe " + A);
        }
        
        tableau.resultatMatch(A, B, scoreA, scoreB);
              
    }
    
    
    public void deroulementTournoi(){
        
        barman.parler("LE TOURNOI EST LANCE !");
        
        Calendrier calendrier = new Calendrier(equipes);
        
        for (int i = 0; i < calendrier.getClendrier().size(); i++){                      
            
            barman.parler("Prochain match : " + calendrier.getClendrier().get(i)[0].getNom()+ " VS " + calendrier.getClendrier().get(i)[1].getNom() );
            match(calendrier.getClendrier().get(i)[0], calendrier.getClendrier().get(i)[1]);
            tableau.calculTotal();
            tableau.calculClassement();
            barman.parler("VOICI LE NOUVEAU TABLEAU :");
            tableau.afficheTabClassement();
            
        }
        
        barman.parler("LE TOURNOI EST TERMINE");
        
        remisePrix();
    }
    
    public void remisePrix(){
        
        Equipe gagnant = tableau.getGagnant();
        
        barman.parler("Bravo à l'équipe " + gagnant.getNom() + " qui remporte le tournoi " + nom);
        
        int recompense = cagnotte / 2;
        
        int retourPatronne = cagnotte - recompense;
        
        barman.getPatronne().setPorteMonnaie(barman.getPatronne().getPorteMonnaie() + retourPatronne);
        
        int sommeJ1 = recompense / 2;
        int sommeJ2 = recompense - sommeJ1;
        
        gagnant.getJoueur1().getIdentite().setPorteMonnaie(gagnant.getJoueur1().getIdentite().getPorteMonnaie() + sommeJ1);
        gagnant.getJoueur2().getIdentite().setPorteMonnaie(gagnant.getJoueur2().getIdentite().getPorteMonnaie() + sommeJ2);
        
        
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
