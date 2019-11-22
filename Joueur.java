/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
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
    
    /**
     * Un debutant lance ses fleche au hasard
     * 
     * @return coordonnées polaire de la case atteinte
     */
    
    public int[] lanceDebutant(){
        
         int r = ThreadLocalRandom.current().nextInt(-12, 13);

        int alpha = ThreadLocalRandom.current().nextInt(0, 20); 
        
        
        int tab[] = {r, alpha};
        
        return tab;
        
    }
    
    /**
     * Un joueur confirme atteint la case qu'il vide avec une certaine erreur
     * 
     * @param points point restants
     * @param cible 
     * @return coordonnée polaires de la case atteinte
     */
    
    public int[] lanceConfirme(int points, Cible cible){
        
        int polaire[] = caseCible301(points, cible);
        
        int r = polaire[0];
        
        int alpha = polaire[1];
        
        int erreurR = ThreadLocalRandom.current().nextInt(-1, 2);

        int erreurAlpha = ThreadLocalRandom.current().nextInt(-1, 2);        
        
        int tab[] = {r + erreurR, alpha + erreurAlpha};
        
        return tab;
        
    }
    
    /**
     * Un joueur expert atteint la case qu'il vise avec une erreur souvent nulle
     * 
     * @param points points restants
     * @param cible
     * @return coordonnée polaires de la case atteinte
     */
    
    public int[] lanceExpert(int points, Cible cible){
        
        int polaire[] = caseCible301(points, cible);
        
        int r = polaire[0];
        
        int alpha = polaire[1];
        
        int erreurR = 0;
        
        if (ThreadLocalRandom.current().nextInt(-1, 2) == 0){
            
            erreurR = ThreadLocalRandom.current().nextInt(-1, 2);
            
        }
        
        int erreurAlpha = 0;
        
        if (ThreadLocalRandom.current().nextInt(-3, 2) == 0){
            
            erreurAlpha = ThreadLocalRandom.current().nextInt(-1, 2);
            
        }
        
        int tab[] = {r + erreurR, alpha + erreurAlpha};
        
        return tab;
        
    }
    
    /**
     * L'utilisateur joue à la place du joueur de niveau manuel
     * 
     * @param cible
     * @return coordonnées polaires de la case atteinte
     * @throws BorneException 
     */
    
    public int[] lanceManuel(Cible cible) throws BorneException{
        
        int r = 0;
        int alpha = 0;
        boolean conforme = false;
        boolean conformeSimple = false;
        boolean conformeDouble = false;
        boolean conformeTriple = false;
        
        while(!conforme){
            
            conforme = true;
            
            try{
                
            System.out.print("Quelle case visez vous ?");
            System.out.println("| Simple - 1 | Double - 2 | Triple - 3 | Bull - 4 | Eye-Bull - 5 | Hors-cible - 6 |");
        
            int choix = scanEntierBorne(1,6);
        
            switch(choix){
            
                case 1:
                    
                    r = 7;
                    
                    while(!conformeSimple){
                        
                        conformeSimple = true;
                        
                        try{
                            
                        System.out.println("Entrez la valeur du simple que vous visez");
                        alpha = cible.cases.indexOf(scanEntierBorne(1,20));
                        
                        }
                        catch(BorneException s){  
                            
                            conformeSimple = false;
                        }
                    
                    }
                    break;
                case 2:
                    
                    r = 10;
                    
                    while(!conformeDouble){
                        
                        conformeDouble = true;
                        
                        try{
                            
                        System.out.println("Entrez la valeur du double que vous visez");
                        alpha = cible.cases.indexOf(scanEntierBorne(1,20));
                        
                        }
                        catch(BorneException d){ 
                            
                            conformeDouble = false;
                        }
                    
                    }
                    break;
                case 3:
                    
                    r = 5;
                    
                    while(!conformeTriple){
                        
                        conformeTriple = true;
                        
                        try{
                            
                        System.out.println("Entrez la valeur du triple que vous visez");
                        alpha = cible.cases.indexOf(scanEntierBorne(1,20));
                        
                        }
                        catch(BorneException t){ 
                            
                            conformeTriple = false;
                        }
                    
                    }
                    break;   
                    
                case 4:
                    r = 1;                
                    break;
                case 5:
                    r = 0;
                    break;
                case 6:
                    r = 11;
                    break;
            
        }
            }
            
            catch(BorneException e){
                
                conforme = false;
                
            }
        }
        
        int polaire[] = {r, alpha};
        
        return polaire;
        
    }
    
    /**
     * Lancement d'une flechette
     * 
     * @param points points restants
     * @param cible
     * @return coordonnées polaires de la case atteinte
     * @throws BorneException 
     */
    
    
    public int[] lance(int points, Cible cible) throws BorneException{
        
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
            
            polaire = lanceManuel(cible);
            
        }
        
        return polaire;
        
    }
    
    /**
     * cette methode sert à determiner la case qu'il faut viser suivant notre score actuel durant une partie de 301
     * 
     * @param Points points restants
     * @param cible
     * @return coordonnées polaires de la case qu'il faut viser
     */
    
    public int[] caseCible301(int Points, Cible cible){
        
        int r = 20;
        
        int alpha = 0;
        
        boolean done = false;
        
        double score = (double) Points;
        
        if (score >= 60){
            
            r = 5;
            
            alpha = cible.cases.indexOf(20);
            
            done = true;
            
        }
        
        if ((score / 3) == ((int) (score / 3)) && (score / 3) < 20){
            
            int caseCible = (int) score / 3;
            
            r = 5;
            
            alpha = cible.cases.indexOf(caseCible);
            
            done = true;
            
        }
        
        if ((score / 2) == ((int) (score / 2)) && (score / 2) < 20){
            
            int caseCible = (int) score / 2;
            
            r = 10;
            
            alpha = cible.cases.indexOf(caseCible);
            
            done = true;
            
        }
        
        if (score < 20){
            
            int caseCible = (int) score;
            
            r = 7;
            
            alpha = cible.cases.indexOf(caseCible);
            
            done = true;
            
        }
        
        if (score == 25){
            
            r = 1;
            
            alpha = 0;
            
            done = true;
            
        }
        
        if (score == 50){            
            
            r = 0;
            
            alpha = 0;
            
            done = true;
            
        }
        
        if (!done){
            
                       
            int polaireBis[] = caseCible301(Points - 1, cible);
            
            r = polaireBis[0];
            alpha = polaireBis[1];
                        
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
    
    public int scanEntierBorne(int min, int max) throws BorneException{
        
        int entier = 0;
        
        Scanner keyboard = new Scanner(System.in);
        String chaine = keyboard.nextLine();
                
        entier = conversionStrVersInt(chaine);
        
        if (entier < min || entier > max){
            
            throw new BorneException();
            
        }
        
        return entier;
    }
    
    public int conversionStrVersInt(String entree){
        
        int puissance = entree.length();
        int nombre = 0;
        double result = 0;

        for(int i = 0; i < puissance; i++){
            
            char chiffre = entree.charAt(i);

            switch(chiffre) {
                case '0':
                    nombre = 0;
                    break;
                case '1':
                    nombre = 1;
                    break;
                case '2':
                    nombre = 2;
                    break;
                case '3':
                    nombre = 3;
                    break;
                case '4':
                    nombre = 4;
                    break;
                case '5':
                    nombre = 5;
                    break;
                case '6':
                    nombre = 6;
                    break;
                case '7':
                    nombre = 7;
                    break;
                case '8':
                    nombre = 8;
                    break;
                case '9':
                    nombre = 9;
                    break;
                    
                    

        }
            
            result = result + nombre*Math.pow((double) 10, (double) (puissance - i - 1));
            
        }
      
    if ((result == 0) && !(entree.equals("0"))){
        
        result = -1;
        
    }
        
    return (int) result;

}
    
}
