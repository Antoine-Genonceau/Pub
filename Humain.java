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
 * @author procy
 * 
 * L'objet Humain est la classe mère de tous les personnages
 * 
 * Un humain peut se présenter, parler, boire, payer, offrir un verre à d'autres humains
 * 
 * Il a aussi un droit d'access au bar, il en a bessoin pour pouvoir effectuer des actions dans un bar
 * 
 */
public class Humain implements Serializable{
    private String surnom;
    private String prenom;
    private int porteMonnaie;
    private int popularite;
    private String cri;   
    private boolean access;
    private Table table;
    
    
    public Humain(){
        surnom = new String();
        prenom = new String();
        porteMonnaie=0;
        cri = new String();
        access = false;
        Table debout = new Table();
        table = debout;
        initPopularite();
        
        
    }
    
    public Humain(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri){
            
        surnom = pSurnom;
        prenom = pPrenom;
        porteMonnaie = pPorteMonnaie;
        cri = pCri;
        access = false;
        Table debout = new Table();
        table = debout; 
        initPopularite();

    }
    
    /**
     * Lorsqu'un humain parle on commence par "Fonction prenom" ou "prenom" si c'est un client
     * 
     * @param phrase le pharse que dit le client
     *  
     **/
    
    public void parler(String phrase){
        
        Class<?> classe = this.getClass();
        
        if (classe == Client.class){
            
            System.out.println("<"+this.prenom+"> " + phrase);
            
        }
        
        else{
            
            System.out.println("<" + this.getClass().getSimpleName() + " " + this.prenom + "> " + phrase);
            
        }
        
    }
    
    public void parler(String phrase, Serveur serveur){
        
        Class<?> classe = this.getClass();
        
        if (classe == Client.class){
            
            System.out.println("<"+this.prenom+"> " + phrase);
            
        }
        
        else{
            
            System.out.println("<" + this.getClass().getSimpleName() + " " + this.prenom + "> " + phrase);
            
        }
        
    }
    
    /**
     * 
     * Presentation de base d'un humain
     * 
     */
    
    public void presentation(){
        
        String presentation = "Salut moi c'est " + this.prenom + ", mais tout le monde m'appelle " + this.surnom + ", je suis " + this.getClass().getSimpleName() + ".";
        
        this.parler(presentation);
        
    }
    
    /**
     * 
     * initialisation de la popularite
     * 
     */
    
    public void initPopularite(){
        
        int popRole = 0;
        
         Class<?> classe = this.getClass();            
            
            
            if (classe == Client.class){
                
                popRole = 1;
                
            }
            
            if (classe == Serveur.class){
                
                popRole = 10;
            }
            
            if (classe == Barman.class){
                
                popRole = 100;
                
            }
            
            if (classe == Patronne.class){
                
                popRole = 1000;
                
            }  
            
            if (classe == Fournisseur.class){
                
                popRole = 10;
                
            }
                     
        
        
        popularite = (porteMonnaie / 10)*popRole;        
    
        
    }
    
    /**
     * Plus un humain boit de boisson alcoolise plus il est populaire
     * 
     * @param boisson boisson bu
     */
    
    public void updatePopularite(Boisson boisson){
        
        popularite = popularite + 10 * boisson.getUniteAlcool();        
               
    }
    
    /**
     * Plus un humain paye plus il est populaire
     * 
     * @param ardoise montant payé
     */
    
    public void updatePopularite(int ardoise){
        
        popularite = popularite + 10 * ardoise;        
               
    }
    
    /**
     * 
     * quand quelqu'un paye une tournee généralle sa popularite triple
     * 
     */
    
    public void updatePopulariteTournee(){
        
        popularite = popularite*3;        
               
    }
    
    /**
     * Un humain peut choisir une table, si une plce est libre il s'assoit
     * 
     * @param pTable table choisit
     */
    
    private void runChoisirTable(Table pTable){
        
        if (pTable.getNombrePlacesLibres() > 0){
            
            table = pTable;
            
            pTable.getPersonnes().add(this);
            
            pTable.setNombrePlacesLibres(pTable.getNombrePlacesLibres() - 1);
            
            System.out.println(this.prenom + " s'assois table " + pTable.getNumero());
            
        }
        
        else{
            
            System.out.println("Cette table n'est pas disponible !");
            
        }
        
    }
    
    /**
     * Un humain paut boire une boisson
     * 
     * @param pBoisson boisson bu
     */
    
    public void boire(Boisson pBoisson){        
            
        System.out.println(this.surnom + " a bu la boisson : " + pBoisson.getNom());
        
        this.updatePopularite(pBoisson);        
        
    }
    
    /**
     * Plusieurs humains peuvent boirent ensemble une commande
     * 
     * @param commande commande bu
     */
    
    public void boire(Commande commande){
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            for (int j = 0; j < commande.getCommande().get(i).getListeConsomateur().size(); j++){
                
                commande.getCommande().get(i).getListeConsomateur().get(j).boire(commande.getCommande().get(i).getStockBoisson().getBoisson());
                
            }           
            
        }       
        
    }
    
    /**
     * Un humain peut payer une commande
     * 
     * @param commande commande reglée par l'humain
     * @param serveur serveur auquel l'humain regle la commande
     */
    
    public void payerBoisson(Commande commande, Serveur serveur){
        
        int somme = 0;
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            
            somme = somme +  commande.getCommande().get(i).getStockBoisson().getBoisson().getPrixVente() * commande.getCommande().get(i).getStockBoisson().getNombre();
            
        
        }
         
        this.porteMonnaie = this.porteMonnaie - somme;  
        
        this.updatePopularite(somme);
        
        serveur.parler("Ok ça fait " + somme + " €");
        
        this.parler("Voila !");
        
        serveur.parler("Merci");
        
        serveur.encaissement(somme, commande); 
        
    }
    
    /**
     * Un humain peut payer une commande
     * 
     * @param commande commande reglée par l'humain
     * @param barman barman auquel l'humain regle la commande
     */
    
    public void payerBoisson(Commande commande, Barman barman){
        
        int somme = 0;
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            
            somme = somme +  commande.getCommande().get(i).getStockBoisson().getBoisson().getPrixVente() * commande.getCommande().get(i).getStockBoisson().getNombre();
            
        
        }
         
        barman.parler(somme + " € s’il te plaît");
            
        this.porteMonnaie = this.porteMonnaie - somme;  
        
        this.parler("Voila !");
            
        barman.encaissement(somme); 
        
        barman.parler("Merci");
          
    }
    
    /**
     * Un humain vérifie si il est en mesure de payer une commande
     * 
     * @param commande commande dont on vérifie la possibilite de payer
     * @return cette methode retourne un boolean qui indique si oui ou non l'humain est en mesure de payer la commande
     */
    
    public boolean verifPrix(Commande commande){
        
        boolean verifPrix = false;
        
        int somme = 0;
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            
            somme = somme +  commande.getCommande().get(i).getStockBoisson().getBoisson().getPrixVente() * commande.getCommande().get(i).getStockBoisson().getNombre();
            
        
        }
               
            
        if (this.porteMonnaie - somme > 0){
            
            verifPrix = true;
            
        }
        
        return verifPrix;
        
    }
    
    /**
     * Un humain peut acheter une commande 
     * 
     * @param commande commande achetée
     * @param barman barman au quel l'humain achete la commande
     */
    
    public void acheterBoisson(Commande commande, Barman barman){      
                            
            barman.chercherBoisson(commande);
                
            payerBoisson(commande, barman);               
                           
    }
    
    public void acheterBoisson(Commande commande, Serveur serveur){     
        
            serveur.getBarman().chercherBoisson(commande);
                
            payerBoisson(commande, serveur);               
                           
    }
    
    /**
     * Un humain peut consommer c'est à dire commande à boire pour lui et d'autres humains
     * 
     * @param listeConsomateur humains pour lesquels la commande est passée
     * @param serveur serveur auquel l'humain passe la commande
     */
    
    private void runConsommer(ArrayList<Humain> listeConsomateur, Serveur serveur) throws StopCommandeException{
        
       
        
        Commande commande = new Commande();
        
        Commande commandeDispo = new Commande();
        
        Commande commandeNonDispo = new Commande();
        
        commande = creationCommande(listeConsomateur);
                
        Commande tabCommande[] = new Commande[2];
        
        this.parler("Je voudrais " + commande, serveur);
        
        serveur.parler(serveur.getBarman().getPrenom() + ", il nous reste " + commande + " ?");
        
        tabCommande = serveur.getBarman().verifBoisson(serveur.getBarman().verifBlackList(commande));
        
        commandeDispo = tabCommande[0];
        
        commandeNonDispo = tabCommande[1];
        
        if (commandeNonDispo.getCommande().size() == 0){
            
            serveur.getBarman().parler("Yes on a tout " + serveur.getPrenom() + "!");
            
            serveur.parler("Ok j'ai Tout !");
            
            if (verifPrix(commandeDispo)){
                
                acheterBoisson(commandeDispo, serveur);
                
                boire(commandeDispo);
                
            }
            
            else{
                
                this.parler("Mince, j'ai pas assez d'argent !!", serveur);
                
            } 
            
        }
        
        else{
            
            serveur.getBarman().parler("Ah non,"+ serveur.getPrenom() +", il manque :" + commandeNonDispo);
            
            serveur.parler("Désolé il nous manque : " + commandeNonDispo);
            
            Commande commandeBis = new Commande();
            
            commandeBis = creationCommandeBis(commandeNonDispo);
            
            Commande commandeNew = new Commande();
            
            commandeNew.getCommande().addAll(commandeBis.getCommande());
            commandeNew.getCommande().addAll(commandeDispo.getCommande());
            
            this.parler("Bon alors mets moi :" + commandeNew, serveur);
        
            Commande commandeDispoBis = new Commande();
        
            Commande commandeNonDispoBis = new Commande();        
                            
            Commande tabCommandeBis[] = new Commande[2];
            
            serveur.parler(serveur.getBarman().getPrenom() + ", il nous reste " + commandeNew + " ?");
        
            tabCommandeBis = serveur.getBarman().verifBoisson(commandeNew);
        
            commandeDispoBis = tabCommandeBis[0];
        
            commandeNonDispoBis = tabCommandeBis[1];
            
                        
            if (commandeNonDispoBis.getCommande().size() == 0){
                
                serveur.getBarman().parler("Yes on a tout " + serveur.getPrenom() + "!");
            
                serveur.parler("Ok j'ai Tout !");
            
                if (verifPrix(commandeDispoBis)){
                
                    acheterBoisson(commandeDispoBis, serveur);
                
                    boire(commandeDispoBis);
                
                }
            
                else{
                
                    this.parler("Mince, j'ai pas assez d'argent !!", serveur);
                
                } 
                
            }
                
                
            else{
                                        
                    if(commandeDispoBis.getCommande().size() == 0){
                        
                        serveur.getBarman().parler("Désolé j'ai rien de tout ça");
            
                        serveur.parler("Désolé on a rien de tout ça");
            
                        this.parler("Ok tant pis", serveur);
            
                        }
                    
                    else{
                        
                        serveur.getBarman().parler("Ah non,"+ serveur.getPrenom() +", il manque :" + commandeNonDispoBis);
            
                        serveur.parler("Désolé il nous manque : " + commandeNonDispoBis);
                        
                        this.parler("Ok mets moi juste : " + commandeDispoBis, serveur);
                    
                        if (verifPrix(commandeDispoBis)){
                
                            acheterBoisson(commandeDispoBis, serveur);
                
                            boire(commandeDispoBis);
                
                        }
            
                        else{
                
                            this.parler("Pas assez d'argent !!", serveur);
                
                        } 
                        
                    }
                        
                        }
            
        }
        
    }
    
    /**
     * Un humain peut consommer c'est à dire commande à boire pour lui et d'autres humains
     * 
     * @param listeConsomateur humains pour lesquels la commande est passée
     * @param barman barman auquel l'humain s'adresse 
     */
    
    private void runConsommer(ArrayList<Humain> listeConsomateur, Barman barman) throws StopCommandeException{
        
        Commande commande = new Commande();
        
        Commande commandeDispo = new Commande();
        
        Commande commandeNonDispo = new Commande();
        
        commande = creationCommande(listeConsomateur);
                
        Commande tabCommande[] = new Commande[2];
        
        this.parler("Je voudrais " + commande);
        
        tabCommande = barman.verifBoisson(barman.verifBlackList(commande));
        
        commandeDispo = tabCommande[0];
        
        commandeNonDispo = tabCommande[1];
        
        
                
        if (commandeNonDispo.getCommande().size() == 0){
            
            barman.parler("Ok j'ai Tout !");
            
            if (verifPrix(commandeDispo)){
                
                acheterBoisson(commandeDispo, barman);
                
                boire(commandeDispo);
                
            }
            
            else{
                
                this.parler("Pas assez d'argent !!");
                
            } 
            
        }
        
        else{
            
            barman.parler("Désolé il nous manque : " + commandeNonDispo);
            
            Commande commandeBis = new Commande();
            
            commandeBis = creationCommandeBis(commandeNonDispo);
            
            Commande commandeNew = new Commande();
            
            commandeNew.getCommande().addAll(commandeBis.getCommande());
            commandeNew.getCommande().addAll(commandeDispo.getCommande());
            
            this.parler("Bon alors mets moi :" + commandeNew);
            
        
            Commande commandeDispoBis = new Commande();
        
            Commande commandeNonDispoBis = new Commande();        
                            
            Commande tabCommandeBis[] = new Commande[2];
        
            tabCommandeBis = barman.verifBoisson(commandeNew);
        
            commandeDispoBis = tabCommandeBis[0];
        
            commandeNonDispoBis = tabCommandeBis[1];
            
                      
            if (commandeNonDispoBis.getCommande().size() == 0){
            
                barman.parler("Ok j'ai Tout !");
            
                if (verifPrix(commandeDispoBis)){
                
                    acheterBoisson(commandeDispoBis, barman);
                
                    boire(commandeDispoBis);
                
                }
            
                else{
                
                    this.parler("Pas assez d'argent !!");
                
                } 
                
            }
                
                
            else{
                                        
                    if(commandeDispoBis.getCommande().size() == 0){
            
                        barman.parler("Désolé j'ai rien de tout ça");
            
                        this.parler("Ok tant pis");
            
                        }
                    
                    else
                        
                        barman.parler("Désolé il nous manque : " + commandeNonDispoBis);
                    
                        this.parler("Ok mets moi juste : " + commandeDispoBis);
                    
                        if (verifPrix(commandeDispoBis)){
                
                            acheterBoisson(commandeDispoBis, barman);
                
                            boire(commandeDispoBis);
                
                        }
            
                        else{
                
                            this.parler("Pas assez d'argent !!");
                
                        } 
                        
                        
                        }
                }
            
        
            
            
            
            
            
            
            
        }
    
    /**
     * Un humain peut commander une tournee generale
     * 
     * @param barman la demande de tournee générale se fait aupres du barman
     */
    
    private void runTourneeGenerale(Barman barman) throws StopCommandeException{
        
        this.updatePopulariteTournee();
        
        ArrayList<Humain> listeConsomateur = new ArrayList<>();
        
        listeConsomateur = barman.reclamationTG();  
        
        barman.annonceTG();

        for (int i = 0; i < listeConsomateur.size(); i++){
            
            Class<?> classe = listeConsomateur.get(i).getClass();
        
            if (classe == Client.class){
            
                listeConsomateur.get(i).parler(listeConsomateur.get(i).getCri());
            
            }
        
        }
        
        barman.getPatronne().parler("tout va bien, les affaires reprennent");
        
        consommer(listeConsomateur, barman);
        
        
        
    }
    
    /**
     * Une commande est crée en fonction des consomateurs
     * 
     * @param listeConsomateur
     * @return on retourne la commande créée
     */

    public Commande creationCommande(ArrayList listeConsomateur){
        
        ArrayList<CommandeBoisson> listeCommande = new ArrayList<>();
        
        CommandeBoisson commandeBoissonTemp = new CommandeBoisson();
        
        for (int i = 0; i < listeConsomateur.size(); i++){           
            
            
            Class<?> classe = listeConsomateur.get(i).getClass();            
            
            
            if (classe == Client.class){
                
                CommandeBoisson commandeBoissonClientTemp = new CommandeBoisson();
                
                commandeBoissonClientTemp.setCommandeBoisson((Client) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonClientTemp.clone();
                
            }
            
            if (classe == Serveur.class){
                
                CommandeBoisson commandeBoissonServeurTemp = new CommandeBoisson();
                
                commandeBoissonServeurTemp.setCommandeBoisson((Serveur) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonServeurTemp.clone();
                
            }
            
            if (classe == Barman.class){
                
                CommandeBoisson commandeBoissonBarmanTemp = new CommandeBoisson();
                
                commandeBoissonBarmanTemp.setCommandeBoisson((Barman) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonBarmanTemp.clone();
                
            }
            
            if (classe == Patronne.class){
                
                CommandeBoisson commandeBoissonPatronneTemp = new CommandeBoisson();
                
                commandeBoissonPatronneTemp.setCommandeBoisson((Patronne) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonPatronneTemp.clone();
                
            }            
            
            
            listeCommande.add(commandeBoissonTemp);
            
        }
        
        return new Commande(listeCommande);
         
    }
    
    /**
     * Commande de second choix
     * 
     * @param commande correspond à une commande de premier choix qui n'a pu oboutir
     * @return commande de second choix créée
     */
       
    public Commande creationCommandeBis(Commande commande){
        
        ArrayList<CommandeBoisson> listeCommande = new ArrayList<>();
        
        ArrayList<Humain> listeConsomateur = new ArrayList<>();
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            for (int j = 0; j < commande.getCommande().get(i).getListeConsomateur().size(); j++){
            
            listeConsomateur.add(commande.getCommande().get(i).getListeConsomateur().get(j));
            
            }
        }
                        
        CommandeBoisson commandeBoissonTemp = new CommandeBoisson();
        
        for (int i = 0; i < listeConsomateur.size(); i++){           
            
            
            Class<?> classe = listeConsomateur.get(i).getClass();            
            
            
            if (classe == Client.class){
                
                CommandeBoisson commandeBoissonClientTemp = new CommandeBoisson();
                
                commandeBoissonClientTemp.setCommandeBoissonBis((Client) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonClientTemp.clone();
                
            }
            
            if (classe == Serveur.class){
                
                CommandeBoisson commandeBoissonServeurTemp = new CommandeBoisson();
                
                commandeBoissonServeurTemp.setCommandeBoissonBis((Serveur) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonServeurTemp.clone();
                
            }
            
            if (classe == Barman.class){
                
                CommandeBoisson commandeBoissonBarmanTemp = new CommandeBoisson();
                
                commandeBoissonBarmanTemp.setCommandeBoissonBis((Barman) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonBarmanTemp.clone();
                
            }
            
            if (classe == Patronne.class){
                
                CommandeBoisson commandeBoissonPatronneTemp = new CommandeBoisson();
                
                commandeBoissonPatronneTemp.setCommandeBoissonBis((Patronne) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonPatronneTemp.clone();
                
            }            
            
            
            listeCommande.add(commandeBoissonTemp);
            
        }
        
        return new Commande(listeCommande);
         
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setCri(String pCri){
        
        cri = pCri;
        
    }
    
    public void setPopularite(int pPopularite){
        
        popularite = pPopularite;
        
    }
    
    public void setPorteMonnaie(int pPorteMonnaie){
        
        porteMonnaie = pPorteMonnaie;
        
    }
    
    public void setPrenom(String pPrenom){
        
        prenom = pPrenom;
        
    }
    
    public void setSurom(String pSurnom){
        
        surnom = pSurnom;
        
    }    
    
    public void setAccess(boolean bool){
        
        access = bool;
        
    }
    
    public String getCri(){
        
        return cri;
        
    }
    
    public int getPopularite(){
        
        return popularite;
        
    }
    
    public int getPorteMonnaie(){
        
        return porteMonnaie;
        
    }
    
    public String getSurnom(){
        
        return surnom;
        
    }
    
    public String getPrenom(){
        
        return prenom;
        
    }
    
    public void consommer(ArrayList<Humain> listeConsomateur, Barman barman) throws StopCommandeException{
        
        try{
        
        if (access){
            
            runConsommer(listeConsomateur, barman);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
        }
        catch(StopCommandeException e){
            
            
        }
        
    }
    
    public void consommer(ArrayList<Humain> listeConsomateur, Serveur serveur) throws StopCommandeException{
        
        try{
        
        if (access){
            
            runConsommer(listeConsomateur, serveur);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
        }
        catch(StopCommandeException e){
            
            
        }
        
    }
    
    public void tourneeGenerale(Barman barman) throws StopCommandeException{
        
        if (access){
            
            runTourneeGenerale(barman);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
        
    }
    
    public void choisirTable(Table table){
        
        if (access){
            
            runChoisirTable(table);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
    }
    
    
    public boolean equals(Humain pHumain){        
        
        return ( this.surnom.equals(pHumain.getSurnom()) && this.prenom.equals(pHumain.getPrenom()) && this.porteMonnaie == pHumain.getPorteMonnaie() && this.popularite == pHumain.getPopularite() && this.cri.equals(pHumain.getCri()));
        
    }
    
    @Override
    public String toString(){
        
        return "Surnom : " + surnom + " | Prenom : " + prenom + " | Porte Monnaie : " + porteMonnaie + " | Popularite : " + popularite + " | Cri : " + cri;
        
    }
    
    
    
    
}
