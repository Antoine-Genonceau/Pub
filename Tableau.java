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
 * L'objet tableau contient des cases, une liste d'equipes, un barman responsable du tableau
 * 
 * 
 */
public class Tableau {
    
    private ArrayList<ArrayList<TableauCase>> tableau;
    private ArrayList<Equipe> listeEquipe;
    private Barman barman;
    
    public Tableau(){
        
        
    }
    
    public Tableau(ArrayList<Equipe> equipes, Barman pBarman){
        
        barman = pBarman;
        
        tableau = new ArrayList();
        listeEquipe = new ArrayList();
        
        for (int i = 0; i < equipes.size(); i++){
            
            ArrayList<TableauCase> ligneTableau = new ArrayList<>();
            TableauCase caseTempListe = new TableauCase(equipes.get(i), i);
            listeEquipe.add(equipes.get(i));
            ligneTableau.add(caseTempListe); 
           
            for (int j = 0; j < equipes.size(); j++){
            
                TableauCase caseTemp = new TableauCase(equipes.get(j), j);
            
                ligneTableau.add(caseTemp);    
                
            }   
            
            tableau.add(ligneTableau);
            
        }
        
    }
    
    /**
     * Mise a jour après reception des résultats d'un match
     * 
     * @param equipe1
     * @param equipe2
     * @param score1 score equipe1
     * @param score2 score equipe2
     */
        
    public void resultatMatch(Equipe equipe1, Equipe equipe2, int score1, int score2){
        
        int indexEquipe1 = listeEquipe.indexOf(equipe1);
        int indexEquipe2 = listeEquipe.indexOf(equipe2);
        
        if (score1 == 2){
            
            tableau.get(indexEquipe2).get(indexEquipe1 + 1).setPoints(score2);
            tableau.get(indexEquipe1).get(indexEquipe2 + 1).setPoints(3);
            
            equipe1.getJoueur1().getIdentite().setPopularite((equipe1.getJoueur1().getIdentite().getPopularite())*2);
            equipe1.getJoueur2().getIdentite().setPopularite((equipe1.getJoueur2().getIdentite().getPopularite())*2);
            
            
        }
        
        else{
            
            tableau.get(indexEquipe2).get(indexEquipe1 + 1).setPoints(3);
            tableau.get(indexEquipe1).get(indexEquipe2 + 1).setPoints(score1); 
            
            equipe2.getJoueur1().getIdentite().setPopularite((equipe2.getJoueur1().getIdentite().getPopularite())*2);
            equipe2.getJoueur2().getIdentite().setPopularite((equipe2.getJoueur2().getIdentite().getPopularite())*2);
            
        }
        
    }
    
    /**
     * Cherche le gagnat du tournoi
     * 
     * @return retourne le gagnant
     */
    
    public Equipe getGagnant(){
        
        Equipe gagnant = tableau.get(0).get(0).getEquipe();
        
        for (int i = 1; i < tableau.size(); i++){
            
            if (tableau.get(i).get(0).getEquipe().getPoints() > gagnant.getPoints()){
                
                gagnant = tableau.get(i).get(0).getEquipe();
                
            }
            
        }
        
        return gagnant;
    }
        
    /**
     * Calcul du total de points des différentes équipes
     * 
     */   
    
    public void calculTotal(){
        
        int somme = 0;
        
        for (int i = 0; i < tableau.size(); i++){
            
            somme = 0;
            
            for (int j = 0; j < tableau.size(); j++){
                
                if (i != j && tableau.get(i).get(j + 1).getPoints() != -1){
                
                    somme = somme + tableau.get(i).get(j + 1).getPoints();
                
                }
                
            }
            
            tableau.get(i).get(0).setPoints(somme);
            
        }
        
        
    }
    
    /**
     * Calcul le classement des différents équipes
     * 
     */
    
    public void calculClassement(){
                
        int somme = 0;
        int k;
        boolean bool;
        int indiceBest = 0;
        
        for (int i = 0; i < tableau.size(); i++){
            
            tableau.get(i).get(0).setClassement(0);
            
        }
        
        for (int i = 0; i < tableau.size(); i++){
            
            bool = false;
            k = 0;
            
            while(!bool && k < tableau.size()){
                
                if (tableau.get(k).get(0).getClassement() == 0){
                    
                    indiceBest = k;
                    bool = true;
                    
                }
                
                k++;
            }           
                                    
            for (int j = 0; j < tableau.size(); j++){                
            
                if (tableau.get(indiceBest).get(0).getPoints() < tableau.get(j).get(0).getPoints() && tableau.get(j).get(0).getClassement() == 0){
                    
                    indiceBest = j;
                    
                }
                
            
            }
            
            tableau.get(indiceBest).get(0).setClassement(i + 1);
            
        }
        
        
    }
    
    /**
     * Affiche le tableau
     * 
     */
    
    public void afficheTabClassement(){
        
        System.out.println("\n");
        
        String premiereLigne = "Equipe            ";
        
        for (int i = 0; i < tableau.size(); i++){
            
            String espace = " ";
            
            for (int k = 0; k < 10 - tableau.get(i).get(0).getEquipe().getNom().length(); k++){
                
                espace = espace + " ";
            }
            
            premiereLigne = premiereLigne + tableau.get(i).get(0).getEquipe().getNom() + espace;
            
        }
        
        System.out.println(premiereLigne + "Total     " + "Classement");
        
        
        for (int i = 0; i < tableau.size(); i++){
            
            String espace2 = " ";
            
            for (int k = 0; k < 10 - tableau.get(i).get(0).getEquipe().getNom().length(); k++){
                
                espace2 = espace2 + " ";
            }
            
            String ligne = tableau.get(i).get(0).getEquipe().getNom() + espace2;
            
            for (int j = 0; j < tableau.size(); j++){
                
                if (j != i){
                    
                    if (tableau.get(i).get(j + 1).getPoints() == -1){
                        
                        ligne = ligne + "          " + "*";
                        
                    }
                    
                    else{
                
                    ligne = ligne + "          " + tableau.get(i).get(j + 1).getPoints();
                            
                    }
                
                }
                
                else{
                    
                    
                    ligne = ligne + "          " + "\\";
                    
                }
                
            }
            
            System.out.println("\n" + ligne + "         " + tableau.get(i).get(0).getPoints() + "         " + tableau.get(i).get(0).getClassement());
            
        }
        
        System.out.println("\n");
    }
    
  
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Equipe> getListeEquipe(){
        
        return listeEquipe;
        
    }
    
    public ArrayList<ArrayList<TableauCase>> getTableau(){
        
        return tableau;
        
    }
    
}
