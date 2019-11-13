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
    
    public Tournoi(){
        
        equipes = new ArrayList();
        cagnotte = 0;
        inscriptionsOuvertes = true;
        
    }
    
    public Tournoi(ArrayList<Equipe> pEquipes){
        
        equipes = pEquipes;
        cagnotte = 0;
        inscriptionsOuvertes = true;
        
    }
    
    public void fermetureInscription(){
        
        inscriptionsOuvertes = false;
        
        tableau = new Tableau(equipes);
        
    }
    
    public void ajoutEquipe(Equipe equipe){
        
        if(inscriptionsOuvertes){
            
            if (!(equipes.contains(equipe))){
                
                if(payment(equipe)){
                    
                    equipes.add(equipe);
                    
                }

            }
            
        }
        
        else{System.out.println("Inscriptions Closes");}
        
    }
    
    public boolean payment(Equipe equipe){
        
        boolean valide = false;
        
        return valide;
        
    }
    
    public void match(Equipe A, Equipe B){
        
        tableau.resultatMatch(A, B, 2, 1);
              
    }
    
    public void deroulementMatchs(){
        
        Calendrier calendrier = new Calendrier(equipes);
        
        for (int i = 0; i < calendrier.calendrier.size(); i++){
            
            match(calendrier.calendrier.get(i)[0], calendrier.calendrier.get(i)[1]);
            tableau.afficheTab();
            
        }
        
        tableau.resultatFinal();
        tableau.afficheTabFinal();
    }
    
}
