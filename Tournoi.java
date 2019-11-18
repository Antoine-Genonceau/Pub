/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Toine
 * 
 * L'objet tournoi est créé par la patronne, il a une cagnotte, un prix d'inscription, un barman responsable de son déroulé et du tableau de celui ci
 * les equipes doivent s'insrcire auprès du barman avant le début du tournoi
 * 
 */
public class Tournoi implements Serializable{
    
    private ArrayList<Equipe> equipes;
    private Tableau tableau;
    private int cagnotte;
    private boolean inscriptionsOuvertes;
    private String nom;
    private int prix;
    private Barman barman;
    private boolean termine;
    private SyntheseTournoi synthese;
    
    public Tournoi(String pNom, int pPrix, Barman pBarman){
        
        equipes = new ArrayList();
        cagnotte = 0;
        inscriptionsOuvertes = true;
        termine = false;
        nom = pNom;
        prix = pPrix;
        barman = pBarman;
        synthese = new SyntheseTournoi();
        
    }
    
    /**
     * Cette methode cloture les inscription au tournoi, et crée alors le tableau du tournoi 
     * 
     */
        
    public void fermetureInscription(){
        
        barman.parler("LES INSCRIPTIONS POUR LE TOURNOI " + nom + " SONT CLOSES");
        
        inscriptionsOuvertes = false;
        
        tableau = new Tableau(equipes, barman);
        
        synthese.setNombreJoueurs(equipes.size() * 2);
        
    }
    
    /**
     * 
     * cette methode compte le nombre de serveurs inscrits au tournoi
     * 
     * @return retourne le nombre de serveurs
     */
        
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
    
    /**
     * Cette methode verifie si un joueur c'est déja inscrit
     * 
     * @param equipe
     * @return 
     */
    
    public boolean chercheJoueur(Equipe equipe){
        
        boolean bool = true;
        
        for (int i = 0; i < equipes.size(); i++){
            
            if (equipe.getJoueur1().equals(equipes.get(i).getJoueur1()) || equipe.getJoueur1().equals(equipes.get(i).getJoueur2())|| equipe.getJoueur2().equals(equipes.get(i).getJoueur1())|| equipe.getJoueur2().equals(equipes.get(i).getJoueur2())){
                
                bool = false;
                
            }
            
        }
        
        return bool;
    }
    
    /**
     * 
     * Cette methode indique si une équipe à le droits de s'inscrire au tournoi
     * 
     * @param equipe equipe souhaitant s'inscrire
     * @return autorisation ou non de s'inscrire 
     */
    
    public boolean autorisation(Equipe equipe){
        
        boolean bool = true;
        
        if (compteServeur() + equipe.compteServeur() > barman.getPatronne().getBar().getServeurs().size() - 1){
            
            barman.parler("Désolé on a déjà trop de serveurs inscrits au tournoi");
            
            bool = false;
            
        } 
        
        if (!(chercheJoueur(equipe))){
            
            barman.parler("Désolé mais vous n'avez pas le droit de vous inscrire deux fois");
            
            bool = false;
            
        }
        
        return bool;
        
    }
    
    /**
     * 
     * Cette methode inscrit sous certaines condition une equipe au tournoi
     * 
     * @param equipe equipe souhaitant s'inscrire
     */
        
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
                
            }
            
            else{barman.parler("Désolé mais vous êtes déjà incrits");}
            
        }
        
        else{barman.parler("Désolé mais les inscriptions sont closes");}
        
    }
    
    /**
     * Payment d'une équipe pour son inscription au tournoi
     * 
     * @param equipe equipe s'inscrivant au tournoi
     * @return indique si le payment à bien eu lieu
     */
    
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
    
    /**
     * Déroulment d'un match entre une equipe A et une equipe B
     * 
     * @param A equipe A
     * @param B equipe B
     */
    
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
                synthese.setNombreConsomations(synthese.getNombreConsomations() + 4);
            
                
            }
            
            else{
                
                scoreB = scoreB + 1;
                System.out.println("\n" + A + " : " + scoreA + "   " + B + " : " + scoreB + "\n");
                A.tourneeAdversaire(B, barman);
                synthese.setNombreConsomations(synthese.getNombreConsomations() + 4);
            
                
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
    
    /**
     * Deroulement d'un tournoi
     * 
     */
    
    public void deroulementTournoi(){
        
        if (!termine){
        
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
        
            termine = true;
        
        }
        
        else{
            
            System.out.println("Ce tournoi à déjà eu lieux !");
            
        }
    }
    
    /**
     * Remise des prix a la suite du tournoi     * 
     */
    
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
    
    
    public void afficheSynthese(){
        
        if (termine){
        
            System.out.println("\nSynthese du tournoi '" + nom + "' : \n");
        
            System.out.println("Nombre de joueurs ayant participés : " + synthese.getNombreJoueurs());
            System.out.println("Nombre de consomations engendrées par le tournoi : " + synthese.getNombreConsomations());
            System.out.println("\n");
        }
        
        else{
            
            System.out.println("La synthese sera disponible à la fin du tournoi");
            
        }
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
