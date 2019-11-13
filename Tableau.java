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
public class Tableau {
    
    private ArrayList<ArrayList<TableauCase>> tableau;
    ArrayList<Equipe> listeEquipe;
    
    public Tableau(){
        
        
    }
    
    public Tableau(ArrayList<Equipe> equipes){
        
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
    
    public ArrayList<ArrayList<TableauCase>> getTableau(){
        
        return tableau;
        
    }
    
    public void resultatMatch(Equipe equipe1, Equipe equipe2, int score1, int score2){
        
        int indexEquipe1 = listeEquipe.indexOf(equipe1);
        int indexEquipe2 = listeEquipe.indexOf(equipe2);
        
        if (score1 == 2){
            
            tableau.get(indexEquipe2).get(indexEquipe1 + 1).setPoints(score2);
            tableau.get(indexEquipe1).get(indexEquipe2 + 1).setPoints(3);
            
        }
        
        else{
            
            tableau.get(indexEquipe2).get(indexEquipe1 + 1).setPoints(3);
            tableau.get(indexEquipe1).get(indexEquipe2 + 1).setPoints(score1);            
            
        }
        
    }
    
    public void resultatFinal(){
        
        int somme = 0;
        
        for (int i = 0; i < tableau.size(); i++){
            
            somme = 0;
            
            for (int j = 0; j < tableau.size(); j++){
                
                if (i != j){
                
                    somme = somme + tableau.get(i).get(j + 1).getPoints();
                
                }
                
            }
            
            tableau.get(i).get(0).setPoints(somme);
            
        }
        
        
    }
    
    public void afficheTabFinal(){
        
        afficheTab();
        
        for (int i = 0; i < tableau.size(); i++){
            
            System.out.println(tableau.get(i).get(0).getEquipe().getNom() + " : " + tableau.get(i).get(0).getPoints());
            
        }
    }
    
  
    public void afficheTab(){
        
        System.out.println("\n");
        
        String premiereLigne = "Equipe            ";
        
        for (int i = 0; i < tableau.size(); i++){
            
            String espace = " ";
            
            for (int k = 0; k < 10 - tableau.get(i).get(0).getEquipe().getNom().length(); k++){
                
                espace = espace + " ";
            }
            
            premiereLigne = premiereLigne + tableau.get(i).get(0).getEquipe().getNom() + espace;
            
        }
        
        System.out.println(premiereLigne);
        
        
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
            
            System.out.println("\n" + ligne);
            
        }
        
        System.out.println("\n");
    }
    
    
}
