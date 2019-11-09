/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.ArrayList;


/**
 *
 * @author procy
 */
public class Humain {
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
    
    public void presentation(){
        
        String presentation = "Salut moi c'est " + this.prenom + ", mais tout le monde m'appelle " + this.surnom + ", je suis " + this.getClass().getSimpleName() + ".";
        
        this.parler(presentation);
        
    }
    
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
    
    public void updatePopularite(Boisson boisson){
        
        popularite = popularite + 10 * boisson.getUniteAlcool();        
               
    }
    
    public void updatePopularite(int ardoise){
        
        popularite = popularite + 10 * ardoise;        
               
    }
    
    public void updatePopulariteTournee(){
        
        popularite = popularite*3;        
               
    }
    
    private void runChoisirTable(Table pTable){
        
        if (pTable.getNombrePlacesLibres() > 0){
            
            table = pTable;
            
            pTable.getPersonnes().add(this);
            
            pTable.setNombrePlacesLibres(pTable.getNombrePlacesLibres() - 1);
            
        }
        
        else{
            
            System.out.println("Cette table n'est pas disponible !");
            
        }
        
    }
    
    
    public void boire(Boisson pBoisson){        
            
        System.out.println(this.surnom + " a bu la boisson : " + pBoisson.getNom());
        
        this.updatePopularite(pBoisson);        
        
    }
    
    public void boire(Commande commande){
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            for (int j = 0; j < commande.getCommande().get(i).getListeConsomateur().size(); j++){
                
                commande.getCommande().get(i).getListeConsomateur().get(j).boire(commande.getCommande().get(i).getStockBoisson().getBoisson());
                
            }           
            
        }       
        
    }
    
    public void payerBoisson(Commande commande, Serveur serveur){
        
        int somme = 0;
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            
            somme = somme +  commande.getCommande().get(i).getStockBoisson().getBoisson().getPrixVente() * commande.getCommande().get(i).getStockBoisson().getNombre();
            
        
        }
         
        this.porteMonnaie = this.porteMonnaie - somme;  
        
        this.updatePopularite(somme);
            
        serveur.encaissement(somme);        
          
    }
    
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
    
    public void acheterBoisson(Commande commande, Barman barman){      
                            
            barman.chercherBoisson(commande);
                
            payerBoisson(commande, barman);               
                           
    }
    
    public void acheterBoisson(Commande commande, Serveur serveur){      
                            
            serveur.getBarman().chercherBoisson(commande);
                
            payerBoisson(commande, serveur);               
                           
    }
    
    private void runConsommer(ArrayList<Humain> listeConsomateur, Serveur serveur){
        
       
        
        Commande commande = new Commande();
        
        Commande commandeDispo = new Commande();
        
        Commande commandeNonDispo = new Commande();
        
        commande = creationCommande(listeConsomateur);
                
        Commande tabCommande[] = new Commande[2];
        
        this.parler("Je voudrais " + commande, serveur);
        
        tabCommande = serveur.getBarman().verifBoisson(serveur.getBarman().verifBlackList(commande));
        
        commandeDispo = tabCommande[0];
        
        commandeNonDispo = tabCommande[1];
        
        if (commandeNonDispo.getCommande().size() == 0){
            
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
            
            serveur.parler("Désolé J'ai pas de : " + commandeNonDispo + "Mais j'ai bien : " + commandeDispo);
            
            Commande commandeBis = new Commande();
            
            commandeBis = creationCommandeBis(commandeNonDispo);
            
            Commande commandeNew = new Commande();
            
            commandeNew.getCommande().addAll(commandeBis.getCommande());
            commandeNew.getCommande().addAll(commandeDispo.getCommande());
            
        
            Commande commandeDispoBis = new Commande();
        
            Commande commandeNonDispoBis = new Commande();        
                            
            Commande tabCommandeBis[] = new Commande[2];
        
            tabCommandeBis = serveur.getBarman().verifBoisson(commandeNew);
        
            commandeDispoBis = tabCommandeBis[0];
        
            commandeNonDispoBis = tabCommandeBis[1];
            
            this.parler("Bon alors mets moi :" + commandeNew, serveur);
            
            if (commandeNonDispoBis.getCommande().size() == 0){
            
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
            
                        serveur.parler("Désolé j'ai rien de tout ça");
            
                        this.parler("Ok tant pis", serveur);
            
                        }
                    
                    else
                        
                        serveur.parler("Désolé J'ai pas de : " + commandeNonDispoBis + "Mais j'ai bien : " + commandeDispoBis);
                    
                        this.parler("Ok mets moi juste : " + commandeDispoBis, serveur);
                    
                        if (verifPrix(commandeDispoBis)){
                
                            acheterBoisson(commandeDispoBis, serveur.getBarman());
                
                            boire(commandeDispoBis);
                
                        }
            
                        else{
                
                            this.parler("Pas assez d'argent !!", serveur);
                
                        } 
                        
                        
                        }
            
        }
        
    }
    
    private void runConsommer(ArrayList<Humain> listeConsomateur, Barman barman){
        
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
            
            barman.parler("Désolé J'ai pas de : " + commandeNonDispo + "Mais j'ai bien : " + commandeDispo);
            
            Commande commandeBis = new Commande();
            
            commandeBis = creationCommandeBis(commandeNonDispo);
            
            Commande commandeNew = new Commande();
            
            commandeNew.getCommande().addAll(commandeBis.getCommande());
            commandeNew.getCommande().addAll(commandeDispo.getCommande());
            
        
            Commande commandeDispoBis = new Commande();
        
            Commande commandeNonDispoBis = new Commande();        
                            
            Commande tabCommandeBis[] = new Commande[2];
        
            tabCommandeBis = barman.verifBoisson(commandeNew);
        
            commandeDispoBis = tabCommandeBis[0];
        
            commandeNonDispoBis = tabCommandeBis[1];
            
            this.parler("Bon alors mets moi :" + commandeNew);
            
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
                        
                        barman.parler("Désolé J'ai pas de : " + commandeNonDispoBis + "Mais j'ai bien : " + commandeDispoBis);
                    
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
    
    
    private void runTourneeGenerale(Barman barman){
        
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
    
    public void consommer(ArrayList<Humain> listeConsomateur, Barman barman){
        
        if (access){
            
            runConsommer(listeConsomateur, barman);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
    }
    
    public void consommer(ArrayList<Humain> listeConsomateur, Serveur serveur){
        
        if (access){
            
            runConsommer(listeConsomateur, serveur);  
        
        }
        
        else{
            
            System.out.println("Degage !!!!!!!!!!!!!!!!!!!");
            
        }
        
    }
    
    public void tourneeGenerale(Barman barman){
        
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
