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
 * 
 * L'objet interface represente l'interaction avec l'utilisateur
 */
public class Interface {
    
    private Charge charge = new Charge();
    private Scanner keyboard = new Scanner(System.in);
    private String entree = "vide";
    
    /**
     * Cette methode est le coeur de l'interface
     * 
     */
    
    public void processus(){
        
        while(!entree.equals("quit")){
            
            menuGeneral();
              
        }        
        
        System.out.print("\nAu revoir, à bientot !\n");
        
    }
    
    
    /**
     * Chargement des informations
     * 
     */
    
    public void chargerBarLeSixRoses(){
        
        LeSixRoses lesixroses = new LeSixRoses();
        
        charge = lesixroses.CreationLeSixRoses();
        
        System.out.println("bar bien chargé !");
        
        
    }
    
    /**
     * Menu général on demande à l'utilisateur ce qu'il souhaite faire
     * 
     */
    
    
    public void menuGeneral(){      
                
        while(!charge.chargement){
        
            System.out.println("Bonjour, pour commencer veulliez choisir au bar à charger !");
            System.out.println("| Le six roses - 1 |");
        
            try{
            
            switch(scanEntierBorne(1,1)) {
                
            case 1:
                chargerBarLeSixRoses();
                break;   
            
            }
        
        }           
                
        catch(BorneException e){
                
                menuGeneral();
                
                }
        
        System.out.println("Que voullez vous faire ?");
        System.out.println("| Afficher données - 1 | Créer données - 2 | Effectuer une action - 3 |");
        
        entree = keyboard.nextLine();
        
        try{

        switch(scanEntierBorne(1,3)) {
                
            case 1:
                afficherDonnee();
                break;
            case 2:
                creerDonnee();
                break;
            case 3:
                action();
                break;
            
            }
        
        }
        
        catch(BorneException e){
            
            menuGeneral();
        }
        
    
        }   
    }
    
    /**
     * Menu pour afficher des données
     * 
     */
    
    public void afficherDonnee(){
        
        System.out.println("Quelle type de donnée voulez vous afficher ?");
        System.out.println("| Bar - 1 | Fournisseur - 2 | Serveurs - 3 | Clients - 4 | Barman - 5 | Patronne - 6 |");
        
        try{
            
        
        
        switch(scanEntierBorne(1, 6)) {
                
            case 1:
                System.out.println(charge.bar.toString());
                break;
            case 2:
                System.out.println(charge.fournisseur.toString());
                break;
            case 3:
                System.out.println(charge.bar.getServeurs());
                break;
            case 4:
                System.out.println(charge.bar.getClients());
                break;
            case 5:
                System.out.println(charge.bar.getBarman());
                break;
            case 6:
                System.out.println(charge.bar.getPatronne());
                break;
            
            }
        }
        
        catch(BorneException e){
            
            afficherDonnee();
            
        }
    }
    
    /**
     * Menu pour créer des données
     * 
     */
    
    public void creerDonnee(){
        
        System.out.println("Quelle type de donnée voulez vous créer ?");
        System.out.println("| Serveur - 1 | Client - 2 |");
        
        try{
            
        switch(scanEntierBorne(1,2)) { 
                
            case 1:
                creationServeur();
                break;
            case 2:
                creationClient();
                break;
                        
            }
        
        }
        catch(BorneException e){
            
            creerDonnee();
        }
  
    }
    
    /**
     * Cette methode crée un serveur
     * 
     */
    
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
        
        int porteMonnaie = conversionStrVersInt(entree);
        
        System.out.println("Cri :");
        entree = keyboard.nextLine();
        String cri = entree;
        
        System.out.println("Sexe : | Homme - 1 | Femme - 2 |");
        entree = keyboard.nextLine();
        
        int sexe = conversionStrVersInt(entree);
        int signe = 0;
        
        switch(entree) { 
                
                    case "1":
                        System.out.println("Taille des biceps : | Gros biceps - 1 | Moyens biceps - 2 | Petits biceps - 3 |");
                        entree = keyboard.nextLine();
                        signe = conversionStrVersInt(entree);
                        break;
                    case "2":
                        System.out.println("Coefficient de seduction : | Haute seduction - 1 | Moyenne seduction - 2 | Basse seduction - 3 |");
                        entree = keyboard.nextLine();
                        signe = conversionStrVersInt(entree);
                        break;
        }
        
        SigneServeur signeServeur = conversionListeStrVersSigneServeur(sexe, signe);
        
        Serveur serveur = new Serveur(surnom, prenom, porteMonnaie, cri, signeServeur);
        
        charge.bar.embauche(serveur);
        
        System.out.println("Vous avez créé le serveur " + serveur.toString());
        
    }
    
    /**
     * Cette methode crée un client
     * 
     */
    
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
        
        int porteMonnaie = conversionStrVersInt(entree);
        
        System.out.println("Cri :");
        entree = keyboard.nextLine();
        String cri = entree;
        
        System.out.println("Boisson Favorie :");
        for (int i = 0; i < charge.boissons.size(); i++){
            
            System.out.print(charge.boissons.get(i).getNom() + " - " +  i +" | ");
            
        }
        System.out.println("");
        entree = keyboard.nextLine();
        Boisson boissonFav = charge.boissons.get(conversionStrVersInt(entree));
        
        System.out.println("Boisson de secours :");
        for (int i = 0; i < charge.boissons.size(); i++){
            
            System.out.print(charge.boissons.get(i).getNom() + " - " +  i +" | ");
            
        }
        System.out.println("");
        entree = keyboard.nextLine();
        Boisson boissonFavBis = charge.boissons.get(conversionStrVersInt(entree));
        
        System.out.println("Niveau alcool :");
        entree = keyboard.nextLine();
        int niveauAlcool = conversionStrVersInt(entree);
        
        System.out.println("Sexe : | Homme - 1 | Femme - 2 |");
        entree = keyboard.nextLine();
        
        int sexe = conversionStrVersInt(entree);
        int signe = 0;
        
        switch(entree) { 
                
                    case "1":
                        System.out.println("Couleur du t-shirt : | Blanc - 1 | Bleu - 2 | Noir - 3 | Rouge - 4 | Vert - 5 |");
                        entree = keyboard.nextLine();
                        signe = conversionStrVersInt(entree);
                        break;
                    case "2":
                        System.out.println("Bijoux : | Bague - 1 | Boucle d'oreille - 2 | Bracellet - 3 | Collier - 4 | Montre - 5 |");
                        entree = keyboard.nextLine();
                        signe = conversionStrVersInt(entree);
                        break;
        }
        
        SigneClient signeClient = conversionListeStrVersSigneClient(sexe, signe);
        
        Client client = new Client(surnom, prenom, porteMonnaie, cri, boissonFav, boissonFavBis, niveauAlcool, signeClient);
        
        charge.bar.entreeClient(client);
        
        System.out.println("Vous avez créé le client " + client.toString());
        
    }
    
    /**
     * Menu pour effectuer une action
     * 
     */
    
    
    public void action(){
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Gestion Bar - 1 | Action Bar - 2 | Action Tournoi -3 |");
        
        try{
            
        
        switch(scanEntierBorne(1,3)) { 
                
            case 1:
                actionBar();
                break;
            case 2:
                actionHumain();
                break;
            case 3:
                actionTournoi();
                break;
                        
            }
        
        }
        catch(BorneException e){
            
            action();
            
        }
        
    }
    
    /**
     * Menu pour effectuer une action de gestion du bar
     * 
     */
    
    public void actionBar(){
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Commander des boissons au fournisseur - 1 | Rappeller à l'ordre un client trop alcoolisé - 2 |");
        
        try{
            
        
        switch(scanEntierBorne(1,2)) { 
                
            case 1:
                commandeFournisseur();
                break;
            case 2:
                rappelOrdre();
                break;
                                    
            }
        }
        catch(BorneException e){
            
            actionBar();
            
        }
               
        
    }
    
    /**
     * Cette methode permet de passer une commande au fournisseur
     * 
     */
    
    public void commandeFournisseur(){
        
        System.out.println("Commande :");
        
        Stock commande = new Stock();
        
        for (int i = 0; i < charge.boissons.size(); i++){
            
                       
            System.out.println("nombre de " + charge.boissons.get(i).getNom() + ":");
            entree = keyboard.nextLine();
            
            StockBoisson stockBoisson = new StockBoisson(charge.boissons.get(i), conversionStrVersInt(entree));
            
            commande.getStock().add(stockBoisson);
            
        }
        
        charge.bar.getBarman().envoieCommandeFournisseur(commande, charge.fournisseur);
        
    }
    
    /**
     * Cette methode permet de rappeller a l'ordre un client
     * 
     */
    
    public void rappelOrdre(){
        
        System.out.println("Quelle type de rappel à l'ordre voulez vous effectuer ?");
        System.out.println("| Automatique - 1 | Manuel - 2 |");
        
        try{
            
        switch(scanEntierBorne(1,2)) { 
                
            case 1:
                automatique();
                break;
            case 2:
                manuel();
                break;
                                    
            }
        
        }
        catch(BorneException e){
            
            rappelOrdre();
            
        }
        
    }
    
    /**
     * Rappel à l'ordre automatique 
     * 
     */
    
    public void automatique(){
        
        if (!charge.bar.getPatronne().checkEtatClient()){
            
            System.out.println("Aucun client n'as bessoin d'être rappellé à l'ordre.");
            
        }
        
    }
    
    /**
     * Rappel à l'ordre manuel
     * 
     */
    
    public void manuel(){
        
        System.out.println("Quel client voulez vous rappeller à l'ordre ?");
        
        for (int i = 0; i < charge.bar.getClients().size(); i++){
            
            System.out.print(charge.bar.getClients().get(i) + " - " + i + " | ");
            
        }
        
        entree = keyboard.nextLine();
        
        charge.bar.getPatronne().rappelOrdre(charge.bar.getClients().get(conversionStrVersInt(entree)));
        
    }
    
    /**
     * Menu pour effectuer une action avec un individu present dans le bar
     * 
     */
    
    public void actionHumain(){
        
        Humain humain = choixHumain();
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Se présenter - 1 | Commander auprès du barman - 2 | Commander aupres d'un serveur - 3 |");
        entree = keyboard.nextLine();
        
        try{
        switch(scanEntierBorne(1,3)) { 
                
            case 1:
                humain.presentation();
                break;
            case 2:
                commanderBarman(humain);
                break;
            case 3:
                commanderServeur(humain);
                break;
            
                                    
            }
        
        }
        catch(BorneException e){
            
            actionHumain();
        }
    }
    
    /**
     * Methode permetant dans passer une commande au barman
     * @param humain individu passant la commande
     */
    
    public void commanderBarman(Humain humain){
        
        System.out.println("Quelle genre de commande voulez vous passer ?");
        System.out.println("| Commander un verre pour soi - 1 | Commander pour soi et d'autres personnes - 2 | Commander pour d'autres personnes - 3 |");
        
        entree = keyboard.nextLine();
        
        try{
        switch(scanEntierBorne(1,3)) { 
            
            case 1:
                commanderSeul(humain, charge.bar.getBarman());
                break;
            case 2:
                commanderAvec(humain, charge.bar.getBarman());
                break;
            case 3:
                commanderAutres(humain, charge.bar.getBarman());
                break;
                                    
            }
        }
        catch(BorneException e){
            
            commanderBarman(humain);
            
        }
    }
    
    /**
     * Methode permetant dans passer une commande à un serveur
     * 
     * @param humain individu passant la commande
     */
    
    public void commanderServeur(Humain humain){
        
        Serveur serveur = new Serveur();
        
        serveur = choixServeur();
        
        System.out.println("Quelle genre de commande voulez vous passer ?");
        System.out.println("| Commander un verre pour soi - 1 | Commander pour soi et d'autres personnes - 2 | Commander pour d'autres personnes - 3 |");
        
        try{
        switch(scanEntierBorne(1,3)) { 
            
            case 1:
                commanderSeul(humain, serveur);
                break;
            case 2:
                commanderAvec(humain, serveur);
                break;
            case 3:
                commanderAutres(humain, serveur);
                break;
                                    
            }
        }
        
        catch(BorneException e){
            
            commanderServeur(humain);
        }
    }
    
    /**
     * methode permetant à un individu de passer une commande pour lui seul
     * 
     * @param humain individu passant la commande
     * @param barman barman auquel il s'adresse
     */
    
    public void commanderSeul(Humain humain, Barman barman){
        
        ArrayList<Humain> seul = new ArrayList<>();
        
        seul.add(humain);
        
        humain.consommer(seul, barman);
        
    }
    
    /**
     * methode permetant à un individu de passer une commande pour lui seul
     * 
     * @param humain individu passant la commande
     * @param serveur serveur auquel il s'adresse
     */
    
    public void commanderSeul(Humain humain, Serveur serveur){
        
        ArrayList<Humain> seul = new ArrayList<>();
        
        seul.add(humain);
        
        humain.consommer(seul, serveur);
        
    }
    
    /**
     * Methode permetant à un individu de passer une commande pour lui et d'autres personnes
     * 
     * @param humain individu passant la commande
     * @param barman barman auquel il s'adresse
     */
    
    public void commanderAvec(Humain humain, Barman barman){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        avec.add(humain);
        
        ajoutAutres(avec);
        
        humain.consommer(avec, barman);
        
    }
    
    /**
     * Methode permetant à un individu de passer une commande pour lui et d'autres personnes 
     * 
     * @param humain individu passant la commande
     * @param serveur serveur auquel il s'adresse
     */
    
    public void commanderAvec(Humain humain, Serveur serveur){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        avec.add(humain);
        
        ajoutAutres(avec);
        
        humain.consommer(avec, serveur);
        
    }
    
    /**
     * Methode permetant à un individu de passer une commande pour d'autres personnes 
     * 
     * @param humain individu passant la commande
     * @param barman barman auquel il s'adresse
     */
    
    public void commanderAutres(Humain humain, Barman barman){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        ajoutAutres(avec);
        
        humain.consommer(avec, barman);
        
    }
    
    /**
     * Methode permetant à un individu de passer une commande pour d'autres personnes 
     * 
     * @param humain individu passant la commande
     * @param serveur serveur auquel il s'adresse
     */
    
    public void commanderAutres(Humain humain, Serveur serveur){
        
        ArrayList<Humain> avec = new ArrayList<>();
        
        ajoutAutres(avec);
        
        humain.consommer(avec, serveur);
        
    }
    
    /**
     * Methode permettant d'ajouter des individu dans une commande
     * 
     * @param liste liste d'individus
     */
    
    public void ajoutAutres(ArrayList<Humain> liste){
        
        entree = "O";
        
        while(!(entree.equals("N"))){
            
            liste.add(choixHumainConsomateur());
            
            System.out.println("Voulez vous offrir un verre à quelqu'un d'autres ? (O = oui / N = non)");
            
            entree = keyboard.nextLine();
            
        }
        
    }
    
    /**
     * Methode permettant de choisir le serveur auquel on souhaite passer la commande
     * 
     * @return retourne le serveur choisi
     */
    
    public Serveur choixServeur(){
        
        System.out.println("Aupres de quel serveur souhaitez vous commander ?");
        
        Serveur serveur = new Serveur();
        
        for (int i = 0; i < charge.bar.getServeurs().size(); i++){
            
            System.out.print(charge.bar.getServeurs().get(i).getPrenom() + " - " + i + " | ");
            
        }
        
        entree = keyboard.nextLine();
        
        serveur = charge.bar.getServeurs().get(conversionStrVersInt(entree));
        
        return serveur;
        
    }
    
    /**
     * Methode permetant de choisir l'individu avec lequel on veut effectuer une action
     * 
     * @return individu choisi
     */
    
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
        
        int choix = conversionStrVersInt(entree);
        
        if (choix <= lastClient){
            
            humain = charge.bar.getClients().get(choix);
            
        }
        
        if (choix <= lastServeur && choix > lastClient){
            
            humain = charge.bar.getServeurs().get(choix - lastClient - 1);
            
        }
        
        if (choix == num){
            
            humain = charge.bar.getBarman();
            
        }
        
        if (choix == num + 1){
            
            humain = charge.bar.getPatronne();
            
        }
                
        return humain;        
        
    }
    
    /**
     * Methode permetant de choisir un individu auquel on souhaite offrir un verre
     * 
     * @return  individu choisi
     */
    
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
        
        int choix = conversionStrVersInt(entree);
        
        if (choix <= lastClient){
            
            humain = charge.bar.getClients().get(choix);
            
        }
        
        if (choix <= lastServeur && choix > lastClient){
            
            humain = charge.bar.getServeurs().get(choix - lastClient - 1);
            
        }
        
        if (choix == num){
            
            humain = charge.bar.getBarman();
            
        }
        
        if (choix == num + 1){
            
            humain = charge.bar.getPatronne();
            
        }
                
        return humain;        
        
    }
     
     /**
      * Methode permetant de choisir un individu pour jouer
      * 
      * @return retourne l'individu choisit
      */
     
     public Humain choixJoueur(){
        
        Humain humain = new Humain();
        
        int num = 0;
        
        int lastClient = 0;
        
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
        
        entree = keyboard.nextLine();
        
        int choix = conversionStrVersInt(entree);
        
        if (choix <= lastClient){
            
            humain = charge.bar.getClients().get(choix);
            
        }
        
        else{
            
            humain = charge.bar.getServeurs().get(choix - lastClient - 1);
            
        }
        
        
                
        return humain;        
        
    }
     
    /**
     * Menu des actions de tournoi
     * 
     */
    
    public void actionTournoi(){
        
        System.out.println("Quelle type d'action voulez vous effectuer ?");
        System.out.println("| Gerer un tournoi - 1 | Creer un tournoi - 2 |");
        
        
        try{
        switch(scanEntierBorne(1,2)) { 
                
                    case 1:
                        choixTournoi();
                        break;
                    case 2:
                        creerTournoi();
                        break;
                                         
            }
        
        }
        
        catch(BorneException e){
            
            actionTournoi();
            
        }
        
    }
    
    /**
     * Methode permettant de choisir un tournoi avec lequel on veut effectuer une action
     * 
     */
    
    public void choixTournoi(){
        
        if (charge.bar.getBarman().getTournois().size() == 0){
            
            System.out.println("Il n'existe pour l'instant aucun tournoi !");
            
        }
        
        else{
            
            System.out.println("Quel tournoi souhaitez vous gerer ?");
            
            for (int i = 0; i < charge.bar.getBarman().getTournois().size(); i++){
                
                System.out.println( charge.bar.getBarman().getTournois().get(i).getNom() + " - " + i + " | ");    
                
            }
            
            entree = keyboard.nextLine();
            
            gererTournoi(charge.bar.getBarman().getTournois().get(conversionStrVersInt(entree)));           
            
        }
        
        
    }
    
    /**
     * Menu des actions possibles pour un tournoi existant
     * 
     * @param tournoi 
     */
    
    public void gererTournoi(Tournoi tournoi){
        
        
        System.out.println("Quelle type d'action voulez vous effectuer pour le tournoi " + tournoi.getNom() + " ?");
        System.out.println("| Inscrire une Equipe - 1 | Cloturer les inscriptions - 2 |Lancer le tournoi - 3 |");
        
        try{
        switch(scanEntierBorne(1,3)) { 
                
                    case 1:
                        inscrireEquipe(tournoi);
                        break;
                    case 2:
                        cloreInscriptionsTournoi(tournoi);
                        break;
                    case 3:
                        lancerTournoi(tournoi);
                        break;
                                         
            }
        
        }
        catch(BorneException e){
            
            gererTournoi(tournoi);
            
        }
        
    }
    
    /**
     * Methode permettant d'inscrire une equipe a un tournoi
     * 
     * @param tournoi 
     */
    public void inscrireEquipe(Tournoi tournoi){
        
        Equipe equipe = new Equipe();
        
        equipe = creationEquipe();
        
        equipe.toString();
        
        equipe.inscription(tournoi, charge.bar.getBarman());
        
    }
    
    
    /**
     * Methode permetant de créer une equipe
     * 
     * @return 
     */
    
    public Equipe creationEquipe(){
        
        Joueur joueur1 = new Joueur();
        
        joueur1 = creationJoueur1();
        
        Joueur joueur2 = new Joueur();
        
        joueur2 = creationJoueur2();
        
        String nom = creationNomEquipe();
        
        return new Equipe(joueur1, joueur2, nom);
        
        
    }
    
    /**
     * Methode permetant de creer un joueur
     * 
     * @return retoure le joueur créé
     */
    
    public Joueur creationJoueur1(){
        
        Humain humain = new Humain();
        
        System.out.println("Qui choisissez vous comme joueur numero 1 pour cette equipe ?");
        
        humain = choixJoueur();
        
        return new Joueur(humain);        
                
    }
    
    /**
     * Methode permetant de creer un joueur
     * 
     * @return retoure le joueur créé
     */
    
    public Joueur creationJoueur2(){
       
        Humain humain = new Humain();
        
        System.out.println("Qui choisissez vous comme joueur numero 2 pour cette equipe ?");
        
        humain = choixJoueur();
        
        return new Joueur(humain);        
               
        
    }
    
    /**
     * Methode permettant de choisir un nom d'équipe
     * 
     * @return retourne le nom choisi
     */
    
    public String creationNomEquipe(){
        
        System.out.println("Quel est le nom de cette equipe ? (maximum 9 caracteres)");
        
        entree = keyboard.nextLine();
        
        return entree;
        
    }
    
    /**
     * Methode permetant de cloturer les inscription d'un tournoi
     * 
     * @param tournoi 
     */
    
    public void cloreInscriptionsTournoi(Tournoi tournoi){
        
        
        charge.bar.getBarman().fermetureInscription(tournoi);
        
    }
    
    /**
     * Methode permettant de lancer les matchs d'un tournoi
     * 
     * @param tournoi 
     */
    
    public void lancerTournoi(Tournoi tournoi){
        
        charge.bar.getBarman().deroulementTournoi(tournoi);
        
    }
    
    /**
     * Methode permetant de créer un tournoi
     * 
     */
    
    public void creerTournoi(){
        
        System.out.println("Quel nom voulez vous choisir ?");
        
        entree = keyboard.nextLine();
        
        String nom = entree;
        
        System.out.println("Quel prix voulez vous choisir pour l'inscription ?");
        
        entree = keyboard.nextLine();
        
        int prix = conversionStrVersInt(entree);                
                
        charge.bar.getPatronne().creationTournoi(nom, prix);
        
    }
    
    /**
     * Methode permetant de choisir le signe distinctif d'un server
     * 
     * @param a variable correspondant au sexe
     * @param b variable correspondant au signe
     * @return retourne le signe distinctif
     */
    
    public SigneServeur conversionListeStrVersSigneServeur(int a, int b){
        
        SigneServeur signe = SigneServeur.grosBiceps;;
        
        switch(a) { 
                
            case 1:
                switch(b) { 
                
                    case 1:
                        signe = SigneServeur.grosBiceps;
                        break;
                    case 2:
                        signe = SigneServeur.normalBiceps;
                        break;
                    case 3:
                        signe = SigneServeur.petitBiceps;
                        break;
                        
            }
                break;
            case 2:
                switch(b) { 
                
                    case 1:
                        signe = SigneServeur.hauteSeduction;
                        break;
                    case 2:
                        signe = SigneServeur.moyenneSeduction;
                        break;
                    case 3:
                        signe = SigneServeur.basseSeduction;
                        break;
                        
            }
                break;
                        
            }
        
        return signe;
        
    }
    
    /**
     * Methode permetant de choisir le signe distinctif d'un client
     * 
     * @param a variable correspondant au sexe
     * @param b variable correspondant au signe
     * @return retourne le signe distinctif
     */
    
    public SigneClient conversionListeStrVersSigneClient(int a, int b){
        
        SigneClient signe = SigneClient.bague;
        
        switch(a) { 
                
            case 1:
                switch(b) { 
                
                    case 1:
                        signe = SigneClient.tShirtBlanc;
                        break;
                    case 2:
                        signe = SigneClient.tShirtBleu;
                        break;
                    case 3:
                        signe = SigneClient.tShirtNoir;
                        break;
                    case 4:
                        signe = SigneClient.tShirtRouge;
                        break;
                    case 5:
                        signe = SigneClient.tShirtVert;
                        break;
                        
            }
                break;
            case 2:
                switch(b) { 
                
                    case 1:
                        signe = SigneClient.bague;
                        break;
                    case 2:
                        signe = SigneClient.boucleOreille;
                        break;
                    case 3:
                        signe = SigneClient.bracellet;
                        break;
                    case 4:
                        signe = SigneClient.collier;
                        break;
                    case 5:
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
   
    
    /**
     * Methode permettant de traiter les entiers entrés par l'utilisateur
     * 
     * @param entree entier entré par l'utilisateur
     * @return entier traité
     */
    
    
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
      
    if ((result == 0) && (entree != "0")){
        
        result = -1;
        
    }
        
    return (int) result;

}
    
    
    public int scanEntierBorne(int min, int max) throws BorneException{
        
        int entier = 0;
        
        String chaine = keyboard.nextLine();
        
        entier = conversionStrVersInt(chaine);
        
        if (entier < min || entier > max){
            
            throw new BorneException();
            
        }
        
        return entier;
    }
    
}
