/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Toine
 * 
 * Un joueur à une identite
 * 
 */
public class Joueur implements Serializable{
    
    private Humain identite;
    private NiveauFlechette niveau;
    
    public Joueur(){
        
        identite = new Humain();
        niveau = NiveauFlechette.expert;
        
    }
    
    public Joueur(Humain pIdentite){
        
        identite = pIdentite;
        niveau = NiveauFlechette.expert;
        
    }
    
    public Joueur(Humain pIdentite, NiveauFlechette pNiveau){
        
        identite = pIdentite;
        niveau = pNiveau;
        
    }
    
    public int[] lanceDebutant(){
        
         int r = ThreadLocalRandom.current().nextInt(-12, 13);

        int alpha = ThreadLocalRandom.current().nextInt(0, 20); 
        
        
        int tab[] = {r, alpha};
        
        return tab;
        
    }
    
    public int[] lanceConfirme(int points, Cible cible){
        
        int polaire[] = caseCible301(points, cible);
        
        int r = polaire[0];
        
        int alpha = polaire[1];
        
        int erreurR = ThreadLocalRandom.current().nextInt(-3, 4);

        int erreurAlpha = ThreadLocalRandom.current().nextInt(-3, 4);        
        
        int tab[] = {r + erreurR, alpha + erreurAlpha};
        
        return tab;
        
    }
    
    public int[] lanceExpert(int points, Cible cible){
        
        int polaire[] = caseCible301(points, cible);
        
        int r = polaire[0];
        
        int alpha = polaire[1];
        
        int erreurR = ThreadLocalRandom.current().nextInt(-1, 2);

        /*int erreurAlpha = ThreadLocalRandom.current().nextInt(-1, 2);  */        
        
        int erreurAlpha = 0;
        
        int tab[] = {r + erreurR, alpha + erreurAlpha};
        
        return tab;
        
    }
    
    
    public int[] lance(int points, Cible cible){
        
        int polaire[] = {0, 0};
        
        if(niveau == NiveauFlechette.debutant){
            
            polaire = lanceDebutant();
            
        }
        
        if(niveau == NiveauFlechette.confirme){
            
            polaire = lanceConfirme(points, cible);            
            
        }
        
        if(niveau == NiveauFlechette.expert){
            
            polaire = lanceExpert(points, cible);            
            
        }
        
        if(niveau == NiveauFlechette.manuel){
            
            
        }
        
        return polaire;
        
    }
    
    
    public int[] caseCible301(int Points, Cible cible){
        
        int r = 20;
        
        int alpha = 0;
        
        double score = (double) Points;
        
        if (score >= 60){
            
            r = 5;
            
            alpha = cible.cases.indexOf(20);
            
        }
        
        if ((score / 3) == ((int) (score / 3)) && (score / 3) < 20){
            
            int caseCible = (int) score / 3;
            
            r = 5;
            
            alpha = cible.cases.indexOf(caseCible);
            
        }
        
        if ((score / 2) == ((int) (score / 2)) && (score / 2) < 20){
            
            int caseCible = (int) score / 2;
            
            r = 10;
            
            alpha = cible.cases.indexOf(caseCible);
            
        }
        
        if (score < 20){
            
            int caseCible = (int) score;
            
            r = 7;
            
            alpha = cible.cases.indexOf(caseCible);
            
        }
        
        if (score == 25){
            
            r = 1;
            
            alpha = 0;
            
        }
        
        if (score == 50){            
            
            r = 0;
            
            alpha = 0;
            
        }
        
        int polaire[] = {r,alpha};
        
        return polaire;
        
    }
    
    
    public Humain getIdentite(){
        
        return identite;
        
    }
    
    public NiveauFlechette getNiveau(){
        
        return niveau;
        
    }
    
    public boolean equals(Joueur pJoueur){
        
        return identite.equals(pJoueur.getIdentite());
        
    }
    
}
