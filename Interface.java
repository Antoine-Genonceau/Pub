/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.Scanner;

/**
 *
 * @author Toine
 */
public class Interface {
    
    private Charge charge = new Charge();
    private Scanner keyboard = new Scanner(System.in);
    private String entree = "vide";
    
    public void processus(){
        
        while(!entree.equals("quit")){
            
            menuGeneral();
            
            
            
        }
        
        
        System.out.print("\nAu revoir, à bientot !\n");
        
    }
    
    public void chargerBarLeSixRoses(){
        
        LeSixRoses lesixroses = new LeSixRoses();
        
        charge = lesixroses.CreationLeSixRoses();
        
        System.out.println("bar bien chargé !");
        
        
    }
    
    
    
    
    public void menuGeneral(){      
                
        while(!charge.chargement){
        
            System.out.println("Bonjour, pour commencer veulliez choisir au bar à charger !");
            System.out.println("| Le six roses - 1 |");
        
            entree = keyboard.nextLine();
        
            switch(entree) {
                
            case "1":
                chargerBarLeSixRoses();
                break;   
            
            }
        
        }
        
        System.out.println("Que voullez vous faire ?");
        System.out.println("| Afficher données - 1 | Créer données - 2 | Effectuer une action - 3 ");
        
        entree = keyboard.nextLine();

        switch(entree) {
                
            case "1":
                afficherDonnée();
                break;
            case "2":
                creerDonnée();
                break;
            case "3":
                action();
                break;
            
            }
        
    }   
    
    public void afficherDonnée(){
        
        System.out.println("Quelle type de donnée voulez vous afficher ?");
        System.out.println("| Bar - 1 | Fournisseur - 2 | Serveurs - 3 | Clients - 4 | Barman - 5 | Patronne - 6");
        
        entree = keyboard.nextLine();
        
        switch(entree) {
                
            case "1":
                charge.bar.toString();
                break;
            case "2":
                charge.fournisseur.toString();
                break;
            case "3":
                charge.bar.getServeurs();
                break;
            case "4":
                charge.bar.getClients();
                break;
            case "5":
                charge.bar.getBarman();
                break;
            case "6":
                charge.bar.getPatronne();
                break;
            
            }
        
    }
    
    public void creerDonnée(){
        
        System.out.println("Quelle type de donnée voulez vous créer ?");
        System.out.println("| Serveur - 1 | Client - 2 |");
        
        entree = keyboard.nextLine();
        
        switch(entree) { 
                
            case "1":
                creationServeur();
                break;
            case "2":
                creationClient();
                break;
                        
            }
  
    }
    
    creationServeur(){
        
        System.out.println("Cretion Serveur :");
        
                
        System.out.println("Surnom :");
        entree = keyboard.nextLine();
        String surnom = entree;
        
        System.out.println("Prenom :");
        entree = keyboard.nextLine();
        String prenom = entree;
        
        System.out.println("Porte monnaie :");
        entree = keyboard.nextLine();
        
        int porteMonnaie = conversionListeStrVersInt(entree);
        
        System.out.println("Cri :");
        entree = keyboard.nextLine();
        String cri = entree;
        
        System.out.println("Sexe : | Homme - 1 | Femme - 2 |");
        entree = keyboard.nextLine();
        
        int sexe = conversionListeStrVersInt(entree);
        int signe = 0;
        
        switch(entree) { 
                
                    case "1":
                        System.out.println("Taille des biceps : | Gros biceps - 1 | Moyens biceps - 2 | Petits biceps - 3 |");
                        entree = keyboard.nextLine();
                        signe = conversionListeStrVersInt(entree);
                        break;
                    case "2":
                        System.out.println("Coefficient de seduction : | Haute seduction - 1 | Moyenne seduction - 2 | Basse seduction - 3 |");
                        entree = keyboard.nextLine();
                        signe = conversionListeStrVersInt(entree);
                        break;
        }
        
        SigneServeur signeServeur = conversionListeStrVersSigneServeur(sexe, signe);
        
        Serveur serveur = new Serveur(surnom, prenom, porteMonnaie, cri, signeServeur);
        
        System.out.println("Vous avez créé le serveur " + serveur.toString());
        
    }
    
    public void creationClient(){
        
        System.out.println("Cretion Client :");
        
                
        System.out.println("Surnom :");
        entree = keyboard.nextLine();
        String surnom = entree;
        
        System.out.println("Prenom :");
        entree = keyboard.nextLine();
        String prenom = entree;
        
        System.out.println("Porte monnaie :");
        entree = keyboard.nextLine();
        
        int porteMonnaie = conversionListeStrVersInt(entree);
        
        System.out.println("Cri :");
        entree = keyboard.nextLine();
        String cri = entree;
        
        System.out.println("Boisson Favorie :");
        entree = keyboard.nextLine();
        Boisson boissonFav = conversionListeStrVersBoisson(entree);
        
        System.out.println("Boisson de secours :");
        entree = keyboard.nextLine();
        Boisson boissonFavBis = conversionListeStrVersBoisson(entree);
        
        System.out.println("Niveau alcool :");
        entree = keyboard.nextLine();
        int niveauAlcool = conversionListeStrVersInt(entree);
        
        System.out.println("Sexe : | Homme - 1 | Femme - 2 |");
        entree = keyboard.nextLine();
        
        int sexe = conversionListeStrVersInt(entree);
        int signe = 0;
        
        switch(entree) { 
                
                    case "1":
                        System.out.println("Couleur du t-shirt : | Blanc - 1 | Bleu - 2 | Noir - 3 | Rouge - 4 | Vert - 5 |");
                        entree = keyboard.nextLine();
                        signe = conversionListeStrVersInt(entree);
                        break;
                    case "2":
                        System.out.println("Bijoux : | Bague - 1 | Boucle d'oreille - 2 | Bracellet - 3 | Collier - 4 | Montre - 5 |");
                        entree = keyboard.nextLine();
                        signe = conversionListeStrVersInt(entree);
                        break;
        }
        
        SigneClient signeClient = conversionListeStrVersSigneClient(sexe, signe);
        
        Client client = new Serveur(surnom, prenom, porteMonnaie, cri, signeClient);
        
        System.out.println("Vous avez créé le client " + client.toString());
        
    }
    
    
    public void action(){
        
        
        
    }
    
    public SigneServeur conversionListeStrVersSigneServeur(int a, int b){
        
        SigneServeur signe = SigneServeur.grosBiceps;;
        
        switch(entree) { 
                
            case "1":
                switch(entree) { 
                
                    case "1":
                        signe = SigneServeur.grosBiceps;
                        break;
                    case "2":
                        signe = SigneServeur.normalBiceps;
                        break;
                    case "3":
                        signe = SigneServeur.petitBiceps;
                        break;
                        
            }
                break;
            case "2":
                switch(entree) { 
                
                    case "1":
                        signe = SigneServeur.hauteSeduction;
                        break;
                    case "2":
                        signe = SigneServeur.moyenneSeduction;
                        break;
                    case "3":
                        signe = SigneServeur.basseSeduction;
                        break;
                        
            }
                break;
                        
            }
        
        return signe;
        
    }
    
    public SigneClient conversionListeStrVersSigneClient(int a, int b){
        
        SigneClient signe = SigneClient.bague;
        
        switch(entree) { 
                
            case "1":
                switch(entree) { 
                
                    case "1":
                        signe = SigneClient.tShirtBlanc;
                        break;
                    case "2":
                        signe = SigneClient.tShirtBleu;
                        break;
                    case "3":
                        signe = SigneClient.tShirtNoir;
                        break;
                    case "4":
                        signe = SigneClient.tShirtRouge;
                        break;
                    case "5":
                        signe = SigneClient.tShirtVert;
                        break;
                        
            }
                break;
            case "2":
                switch(entree) { 
                
                    case "1":
                        signe = SigneClient.bague;
                        break;
                    case "2":
                        signe = SigneClient.boucleOreille;
                        break;
                    case "3":
                        signe = SigneClient.bracellet;
                        break;
                    case "4":
                        signe = SigneClient.collier;
                        break;
                    case "5":
                        signe = SigneClient.montre;
                        break;
                        
            }
                break;
                        
            }
        
        return signe;
        
    }
    
    public Boisson conversionListeStrVersBoisson(String entree){
        
        Boisson boisson = new Boisson();
        
        
        return boisson;
    }
    
    public int conversionListeStrVersInt(String entree){
        
        
        int i = 0;
        int nombre = -1;

         
            switch(entree) {
                case "0":
                    nombre = 0;
                    break;
                case "1":
                    nombre = 1;
                    break;
                case "2":
                    nombre = 2;
                    break;
                case "3":
                    nombre = 3;
                    break;
                case "4":
                    nombre = 4;
                    break;
                case "5":
                    nombre = 5;
                    break;
                case "6":
                    nombre = 6;
                    break;
                case "7":
                    nombre = 7;
                    break;
                case "8":
                    nombre = 8;
                    break;
                case "9":
                    nombre = 9;
                    break;

        }
        
    return nombre;

}
    
}
