/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;
import java.util.*;
/**
 *
 * @author Toine
 */
public class Belote {
    JeuDeCarte jdc = new JeuDeCarte();
    
    
}

class JeuDeCarte
{
    int nbJoueur;
    int nbCarte;
    int[] paquet;
     
    public void creationPaquetDeCarte()        
    {
        Scanner scannbCarte = new Scanner(System.in);                                           
        Scanner scannbJoueur = new Scanner(System.in);
         
        System.out.println("Veuillez saisir le nombre de joueur ; il doit etre de 4 pour la belote");
        int nbJoueur = scannbJoueur.nextInt();                                            
        
        while (nbJoueur !=4 )                           
        {
            System.out.println("Le nombre de joueur doit etre de 4 ");
            nbJoueur = scannbJoueur.nextInt();                   
        }
         
        System.out.println("Combien y a t-il de cartes dans votre paquet?");
        nbCarte = scannbCarte.nextInt();                                              
         
        while (0 < nbCarte && nbCarte > 101)                                                
        {
            System.out.println("Entree incorrecte ... Merci de renseigner un nombre de cartes compris entre 1 et 100:");
            nbCarte = scannbCarte.nextInt();                                                    //Associe la nouvelle valeur rentree par l'utilisateur dans l'entier nbCarte
        }
         
        while (nbCarte % nbJoueur != 0)                                                         //Boucle qui indique que le reste de la division de nbCarte par nbJoueur doit etre nul pour que les deux valeurs soient des multiples entre eux
        {
            System.out.println("Le nombre de carte n'est pas un multiple du nombre de joueur, merci de saisir un nouveau nombre de carte :");
            nbCarte = scannbCarte.nextInt();
        }
                     
        System.out.println("La partie commence avec " + nbCarte + " cartes, et " + nbJoueur + " joueurs. C'est parti !");
         
        scannbCarte.close();
        scannbJoueur.close();
    }
    
}
     