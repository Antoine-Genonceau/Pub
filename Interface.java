/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.ArrayList;
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
        System.out.println("| Afficher données - 1 | Créer données - 2 | Effectuer une action - 3 |");
        
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
        System.out.println("| Bar - 1 | Fournisseur - 2 | Serveurs - 3 | Clients - 4 | Barman - 5 | Patronne - 6 |");
        
        entree = keyboard.nextLine();
        
        switch(entree) {
                
            case "1":
                System.out.println(charge.bar.toString());
                break;
            case "2":
                System.out.println(charge.fournisseur.toString());
                break;
            case "3":
                System.out.println(charge.bar.getServeurs());
                break;
            case "4":
                System.out.println(charge.bar.getClients());
                break;
            case "5":
                System.out.println(charge.bar.getBarman());
                break;
            case "6":
                System.out.println(charge.bar.getPatronne());
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
    
    public void creationServeur(){
        
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
        
        charge.bar.embauche(serveur);
        
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
        for (int i = 0; i < charge.boissons.size(); i++){
            
            System.out.print(charge.boissons.get(i).getNom() + " - " +  i +" | ");
            
        }
        System.out.println("");
        entree = keyboard.nextLine();
        Boisson boissonFav = charge.boissons.get(conversionListeStrVersInt(entree));
        
        System.out.println("Boisson de secours :");
        for (int i = 0; i < charge.boissons.size(); i++){
            
            System.out.print(charge.boissons.get(i).getNom() + " - " +  i +" | ");
            
        }
        System.out.println("");
        entree = keyboard.nextLine();
        Boisson boissonFavBis = charge.boissons.get(conversionListeStrVersInt(entree));
        
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
        
        Client client = new Client(surnom, prenom, porteMonnaie, cri, boissonFav, boissonFavBis, niveauAlcool, signeClient);
        
        charge.bar.entreeClient(client);
        
        System.out.println("Vous avez créé le client " + client.toString());
        
    }
    
    
    public void action(){
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Gestion Bar - 1 | Action Bar - 2 | Action Tournoi -3 |");
        
        entree = keyboard.nextLine();
        
        switch(entree) { 
                
            case "1":
                actionBar();
                break;
            case "2":
                actionHumain();
                break;
            case "3":
                actionTournoi();
                break;
                        
            }
        
        
        
    }
    
    public void actionBar(){
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Commander des boissons au fournisseur - 1 | Rappeller à l'ordre un client trop alcoolisé - 2 |");
        
        entree = keyboard.nextLine();
        
        switch(entree) { 
                
            case "1":
                commandeFournisseur();
                break;
            case "2":
                rappelOrdre();
                break;
                                    
            }
               
        
    }
    
    public void commandeFournisseur(){
        
        System.out.println("Commande :");
        
        Stock commande = new Stock();
        
        for (int i = 0; i < charge.boissons.size(); i++){
            
                       
            System.out.println("nombre de " + charge.boissons.get(i).getNom() + ":");
            entree = keyboard.nextLine();
            
            StockBoisson stockBoisson = new StockBoisson(charge.boissons.get(i), conversionListeStrVersInt(entree));
            
            commande.getStock().add(stockBoisson);
            
        }
        
        charge.bar.getBarman().envoieCommandeFournisseur(commande, charge.fournisseur);
        
    }
    
    public void rappelOrdre(){
        
        System.out.println("Quelle type de rappel à l'ordre voulez vous effectuer ?");
        System.out.println("| Automatique - 1 | Manuel - 2 |");
        
        entree = keyboard.nextLine();
        
        
        switch(entree) { 
                
            case "1":
                automatique();
                break;
            case "2":
                manuel();
                break;
                                    
            }
        
    }
    
    public void automatique(){
        
        if (!charge.bar.getPatronne().checkEtatClient()){
            
            System.out.println("Aucun client n'as bessoin d'être rappellé à l'ordre.");
            
        }
        
    }
    
    public void manuel(){
        
        System.out.println("Quel client voulez vous rappeller à l'ordre ?");
        
        for (int i = 0; i < charge.bar.getClients().size(); i++){
            
            System.out.print(charge.bar.getClients().get(i) + " - " + i + " | ");
            
        }
        
        entree = keyboard.nextLine();
        
        charge.bar.getPatronne().rappelOrdre(charge.bar.getClients().get(conversionListeStrVersInt(entree)));
        
    }
    
    public void actionHumain(){
        
        Humain humain = choixHumain();
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Se présenter - 1 | Commander auprès du barman - 2 | Commander aupres d'un serveur - 3 |");
        entree = keyboard.nextLine();
        
        
        switch(entree) { 
                
            case "1":
                humain.presentation();
                break;
            case "2":
                commanderBarman(humain);
                break;
            case "3":
                commanderServeur(humain);
                break;
            
                                    
            }
        
        
    }
    
    public void commanderBarman(Humain humain){
        
        System.out.println("Quelle genre de commande voulez vous passer ?");
        System.out.println("| Commander un verre pour soi - 1 | Commander pour soi et d'autres personnes - 2 | Commander pour d'autres personnes - 3 |");
        
        entree = keyboard.nextLine();
        
        
        switch(entree) { 
            
            case "1":
                commanderSeul(humain, charge.bar.getBarman());
                break;
            case "2":
                commanderAvec(humain, charge.bar.getBarman());
                break;
            case "3":
                commanderAutres(humain, charge.bar.getBarman());
                break;
                                    
            }
        
    }
    
    public void commanderServeur(Humain humain){
        
        Serveur serveur = new Serveur();
        
        serveur = choixServeur();
        
        System.out.println("Quelle genre de commande voulez vous passer ?");
        System.out.println("| Commander un verre pour soi - 1 | Commander pour soi et d'autres personnes - 2 | Commander pour d'autres personnes - 3 |");
        
        entree = keyboard.nextLine();
        
        
        switch(entree) { 
            
            case "1":
                commanderSeul(humain, serveur);
                break;
            case "2":
                commanderAvec(humain, serveur);
                break;
            case "3":
                commanderAutres(humain, serveur);
                break;
                                    
            }
        
    }
    
    public void commanderSeul(Humain humain, Barman barman){
        
        ArrayList<Humain> seul = new ArrayList<>();
        
        seul.add(humain);
        
        humain.consommer(seul, barman);
        
    }
    
    public void commanderSeul(Humain humain, Serveur serveur){
        
        ArrayList<Humain> seul = new ArrayList<>();
        
        seul.add(humain);
        
        humain.consommer(seul, serveur);
        
    }
    
    public void commanderAvec(Humain humain, Barman barman){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        avec.add(humain);
        
        ajoutAutres(avec);
        
        humain.consommer(avec, barman);
        
    }
    
    public void commanderAvec(Humain humain, Serveur serveur){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        avec.add(humain);
        
        ajoutAutres(avec);
        
        humain.consommer(avec, serveur);
        
    }
    
    public void commanderAutres(Humain humain, Barman barman){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        ajoutAutres(avec);
        
        humain.consommer(avec, barman);
        
    }
    
    public void commanderAutres(Humain humain, Serveur serveur){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        ajoutAutres(avec);
        
        humain.consommer(avec, serveur);
        
    }
    
    public void ajoutAutres(ArrayList<Humain> liste){
        
        entree = "O";
        
        while(!(entree.equals("N"))){
            
            liste.add(choixHumainConsomateur());
            
            System.out.println("Voulez vous offrir un verre à quelqu'un d'autres ? (O = oui / N = non)");
            
            entree = keyboard.nextLine();
            
        }
        
    }
    
    public Serveur choixServeur(){
        
        System.out.println("Aupres de quel serveur souhaitez vous commander ?");
        
        Serveur serveur = new Serveur();
        
        for (int i = 0; i < charge.bar.getServeurs().size(); i++){
            
            System.out.print(charge.bar.getServeurs().get(i).getPrenom() + " - " + i + " | ");
            
        }
        
        entree = keyboard.nextLine();
        
        serveur = charge.bar.getServeurs().get(conversionListeStrVersInt(entree));
        
        return serveur;
        
    }
    
    public Humain choixHumain(){
        
        Humain humain = new Humain();
        
        System .out.println("Avec qui voulez vous effectuer une action ?");
        
        int num = 0;
        
        int lastClient = 0;
        
        int lastServeur = 0;
        
        System.out.println("Clients :");
                
        for (int i = 0; i < charge.bar.getClients().size(); i++){
            
            System.out.print(charge.bar.getClients().get(i).getPrenom() + " - " + num + " | ");
            
            num++;
            
        }
        
        lastClient = num - 1;
        
        System.out.println("Serveurs :");
        
        for (int i = 0; i < charge.bar.getServeurs().size(); i++){
            
            System.out.print(charge.bar.getServeurs().get(i).getPrenom() + " - " + num + " | ");
            
            num++;
            
        }
        
        lastServeur = num - 1;
        
        System.out.println("Barman :");
        
        System.out.print(charge.bar.getBarman().getPrenom() + " - " + num + " | ");
        
        System.out.println("Patronne :");
        
        System.out.print(charge.bar.getPatronne().getPrenom() + " - " + num + 1 + " | ");
        
        entree = keyboard.nextLine();
        
        int choix = conversionListeStrVersInt(entree);
        
        if (choix <= lastClient){
            
            humain = charge.bar.getClients().get(choix);
            
        }
        
        if (choix <= lastServeur && choix > lastClient){
            
            humain = charge.bar.getServeurs().get(choix);
            
        }
        
        if (choix == num){
            
            humain = charge.bar.getBarman();
            
        }
        
        if (choix == num + 1){
            
            humain = charge.bar.getPatronne();
            
        }
                
        return humain;        
        
    }
    
     public Humain choixHumainConsomateur(){
        
        Humain humain = new Humain();
        
        System .out.println("A qui voulez vous offir un verre ?");
        
        int num = 0;
        
        int lastClient = 0;
        
        int lastServeur = 0;
        
        System.out.println("Clients :");
                
        for (int i = 0; i < charge.bar.getClients().size(); i++){
            
            System.out.print(charge.bar.getClients().get(i).getPrenom() + " - " + num + " | ");
            
            num++;
            
        }
        
        lastClient = num - 1;
        
        System.out.println("Serveurs :");
        
        for (int i = 0; i < charge.bar.getServeurs().size(); i++){
            
            System.out.print(charge.bar.getServeurs().get(i).getPrenom() + " - " + num + " | ");
            
            num++;
            
        }
        
        lastServeur = num - 1;
        
        System.out.println("Barman :");
        
        System.out.print(charge.bar.getBarman().getPrenom() + " - " + num + " | ");
        
        System.out.println("Patronne :");
        
        System.out.print(charge.bar.getPatronne().getPrenom() + " - " + num + 1 + " | ");
        
        entree = keyboard.nextLine();
        
        int choix = conversionListeStrVersInt(entree);
        
        if (choix <= lastClient){
            
            humain = charge.bar.getClients().get(choix);
            
        }
        
        if (choix <= lastServeur && choix > lastClient){
            
            humain = charge.bar.getServeurs().get(choix);
            
        }
        
        if (choix == num){
            
            humain = charge.bar.getBarman();
            
        }
        
        if (choix == num + 1){
            
            humain = charge.bar.getPatronne();
            
        }
                
        return humain;        
        
    }
    
    public void actionTournoi(){
        
       
        
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
        
        for(int i = 0; i < charge.boissons.size(); i++){
            
            if (charge.boissons.get(i).getNom().equals(entree)){
                
                boisson = charge.boissons.get(i);
                
            }
            
        }        
        
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
