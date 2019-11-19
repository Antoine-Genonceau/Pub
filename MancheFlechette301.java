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
public class MancheFlechette301 {
    
    public Equipe manche(Equipe A, Equipe B, Cible cible){
        
        int scoreA = 301;
        int scoreB = 301;
        int etat = 1;
        int round = 0;
        
        Equipe gagnant = new Equipe();
        
        while((scoreA != 0) && (scoreB != 0) && round < 20){
            
            round++;
            
            switch(etat){
                case 1:
                    scoreA = lancer(A, 1, scoreA, cible);
                    break;
                case 2:
                    scoreB = lancer(B, 1, scoreB, cible);
                    break;
                case 3:
                    scoreA = lancer(A, 2, scoreA, cible);
                    break;
                case 4:
                    scoreB = lancer(B, 2, scoreB, cible);
                    break;    
                
                
            }
            
            etat++;
            
            if(etat > 4){
                
                etat = 1;
                
            }
            
        }
        
        if (scoreA <= scoreB){
            
            gagnant = A;
            
        }
        else{
            
            gagnant = B;
            
        }
        
        return gagnant;
        
    }
    
    public int lancer(Equipe equipe, int joueur, int points, Cible cible){
        
        int newPoints = points;
        
        boolean depassement = false;
        
        if (joueur == 1){
            
            int flechettesRestantes = 3;
            
            while (flechettesRestantes > 0 && !depassement){
                
                int pointsFleche = cible.calculPoints(equipe.getJoueur1().lance(newPoints, cible)[0], equipe.getJoueur1().lance(newPoints, cible)[1]);
                
                System.out.println("Lancer de "+ equipe.getJoueur1().getIdentite().getPrenom() + " : " + cible.calculCases(equipe.getJoueur1().lance(newPoints, cible)[0], equipe.getJoueur1().lance(newPoints, cible)[1]));
                
                if (pointsFleche > newPoints){
                    
                    System.out.println("Depassement !");
                    
                    System.out.println("Score equipe " + equipe.getNom() + " : " + newPoints);
                    
                    flechettesRestantes = 0;
                    
                }
                
                else{
                    
                    flechettesRestantes = flechettesRestantes - 1;
                    
                    newPoints = newPoints - pointsFleche;
                    
                    System.out.println("Score equipe " + equipe.getNom() + " : " + newPoints);
                    
                }
                
            }
            
            
        }
        
        else{
            
             int flechettesRestantes = 3;
            
            while (flechettesRestantes > 0 && !depassement){
                
                int pointsFleche = cible.calculPoints(equipe.getJoueur2().lance(newPoints, cible)[0], equipe.getJoueur2().lance(newPoints, cible)[1]);
                
                System.out.println("Lancer de "+ equipe.getJoueur2().getIdentite().getPrenom() + " : " + cible.calculCases(equipe.getJoueur2().lance(newPoints, cible)[0], equipe.getJoueur2().lance(newPoints, cible)[1]));
                
                if (pointsFleche > newPoints){
                    
                    System.out.println("Depassement !");
                    
                    System.out.println("Score equipe " + equipe.getNom() + " : " + newPoints);
                    
                    flechettesRestantes = 0;
                    
                }
                
                else{
                    
                    if(pointsFleche == newPoints){
                        
                        System.out.println("Score equipe " + equipe.getNom() + " : " + newPoints);
                    
                        flechettesRestantes = 0;
                        
                    }
                    
                    else{
                    
                        flechettesRestantes = flechettesRestantes - 1;
                    
                        newPoints = newPoints - pointsFleche;
                    
                        System.out.println("Score equipe " + equipe.getNom() + " : " + newPoints);
                    
                    }
                    
                }
                
            }
            
            
            
            
        }
        
        return newPoints;
        
    }
    
}
