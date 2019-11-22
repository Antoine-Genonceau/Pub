/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 * Manche d'une partie de flechette 301
 */
public class MancheFlechette301 {
    
    /**
     * Cette methode execute nue manche et retourne l'équipe gagnante
     * 
     */
    
    public Equipe manche(Equipe A, Equipe B, Cible cible) throws BorneException{
        
        int scoreA = 301;
        int scoreB = 301;
        int etat = 1;
        int round = 0;
        
        Equipe gagnant = new Equipe();
        
        System.out.println("\nNouvelle manche:\n             " + A.getNom() + " : " + scoreA + "   |   " + B.getNom() + " : " + scoreB + "\n");
        
        while((scoreA != 0) && (scoreB != 0) && round < 20){
            
            round++;
            
            switch(etat){
                case 1:
                    System.out.println("\nProchain Lanceur : " + A.getJoueur1().getIdentite().getPrenom());
                    scoreA = lancer(A, 1, scoreA, cible);
                    break;
                case 2:
                    System.out.println("\nProchain Lanceur : " + B.getJoueur1().getIdentite().getPrenom());
                    scoreB = lancer(B, 1, scoreB, cible);
                    break;
                case 3:
                    System.out.println("\nProchain Lanceur : " + A.getJoueur2().getIdentite().getPrenom());
                    scoreA = lancer(A, 2, scoreA, cible);
                    break;
                case 4:
                    System.out.println("\nProchain Lanceur : " + B.getJoueur2().getIdentite().getPrenom());
                    scoreB = lancer(B, 2, scoreB, cible);
                    break;    
                
                
            }
            
            
            System.out.println("\n             " + A.getNom() + " : " + scoreA + "   |   " + B.getNom() + " : " + scoreB + "          round " + round + "\n");
                    
            
            etat++;
            
            if(etat > 4){
                
                etat = 1;
                
            }
            
        }
        
        if (scoreA <= scoreB){
            
            gagnant = A;
            
            
            System.out.println(A.getNom() + " Gagne la manche !");
                    
            
        }
        else{
            
            gagnant = B;
            
            System.out.println(B.getNom() + " Gagne la manche !");
            
        }
        
        return gagnant;
        
    }
    
    /**
     * Cette methode execute les potentiels 3 lancés d'un joueur et retourne le nouveau score de son equipe
     * 
     * @param equipe equipe qui doit lancer
     * @param joueur joueur1 ou joueur2 de l'equipe
     * @param points score actuel de l'équipe
     * @param cible
     * @return nouveau score de l'équipe
     * @throws BorneException 
     */
    
    public int lancer(Equipe equipe, int joueur, int points, Cible cible) throws BorneException{
        
        int newPoints = points;
        
        boolean depassement = false;
        
        if (joueur == 1){
            
            int flechettesRestantes = 3;
            
            while (flechettesRestantes > 0 && !depassement){
                
                int polaire[] = equipe.getJoueur1().lance(newPoints, cible);
                
                int pointsFleche = cible.calculPoints(polaire[0], polaire[1]);
                
                System.out.println("Lancer de "+ equipe.getJoueur1().getIdentite().getPrenom() + " : " + cible.calculCases(polaire[0], polaire[1]));
                
                if (pointsFleche > newPoints){
                    
                    System.out.println("Depassement !");
                    
                    flechettesRestantes = 0;
                    
                    depassement = true;
                    
                }
                
                else{
                    
                    
                    
                    if(pointsFleche == newPoints){
                        
                        newPoints = 0;
                    
                        flechettesRestantes = 0;
                        
                    }
                    
                    else{
                    
                        flechettesRestantes = flechettesRestantes - 1;
                    
                        newPoints = newPoints - pointsFleche;
                    
                    }
                    
                }
                
            }
            
            
        }
        
        else{
            
             int flechettesRestantes = 3;
            
            while (flechettesRestantes > 0 && !depassement){                
                
                int polaire[] = equipe.getJoueur2().lance(newPoints, cible);
                
                int pointsFleche = cible.calculPoints(polaire[0], polaire[1]);
                
                System.out.println("Lancer de "+ equipe.getJoueur1().getIdentite().getPrenom() + " : " + cible.calculCases(polaire[0], polaire[1]));
                
                if (pointsFleche > newPoints){
                    
                    System.out.println("Depassement !");
                    
                    flechettesRestantes = 0;
                    
                    depassement = true;
                    
                }
                
                else{
                    
                    if(pointsFleche == newPoints){
                        
                        newPoints = 0;
                    
                        flechettesRestantes = 0;
                        
                    }
                    
                    else{
                    
                        flechettesRestantes = flechettesRestantes - 1;
                    
                        newPoints = newPoints - pointsFleche;
                    
                    }
                    
                }
                
            }
            
            
            
            
        }
        
        return newPoints;
        
    }
    
}
