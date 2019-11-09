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
            
        System.out.println(this.surnom + " a bu la boisson : " + pBoisson.toString());
        
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
               
            
        this.porteMonnaie = this.porteMonnaie - somme;  
            
        barman.encaissement(somme);        
          
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
        
        tabCommande = serveur.getBarman().verifBoisson(serveur.getBarman().verifBlackList(commande));
        
        commandeDispo = tabCommande[0];
        
        commandeNonDispo = tabCommande[1];
        
        if (commandeNonDispo.getCommande().size() == 0){
            
            System.out.println("Ok j'ai Tout !");
            
            if (verifPrix(commandeDispo)){
                
                acheterBoisson(commandeDispo, serveur);
                
                boire(commandeDispo);
                
            }
            
            else{
                
                System.out.println("Pas assez d'argent !!");
                
            } 
            
        }
        
        else{
            
            System.out.println("Désolé J'ai pas de : " + commandeNonDispo + "Mais j'ai bien : " + commandeDispo);
            
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
            
            System.out.println("Bon alors mets moi :" + commandeNew);
            
            if (commandeNonDispoBis.getCommande().size() == 0){
            
                System.out.println("Ok j'ai Tout !");
            
                if (verifPrix(commandeDispoBis)){
                
                    acheterBoisson(commandeDispoBis, serveur);
                
                    boire(commandeDispoBis);
                
                }
            
                else{
                
                    System.out.println("Pas assez d'argent !!");
                
                } 
                
            }
                
                
            else{
                                        
                    if(commandeDispoBis.getCommande().size() == 0){
            
                        System.out.println("Désolé j'ai rien de tout ça, coco");
            
                         System.out.println("Ok tant pis");
            
                        }
                    
                    else
                        
                        System.out.println("Désolé J'ai pas de : " + commandeNonDispoBis + "Mais j'ai bien : " + commandeDispoBis);
                    
                        System.out.println("Ok mets moi juste : " + commandeDispoBis);
                    
                        if (verifPrix(commandeDispoBis)){
                
                            acheterBoisson(commandeDispoBis, serveur.getBarman());
                
                            boire(commandeDispoBis);
                
                        }
            
                        else{
                
                            System.out.println("Pas assez d'argent !!");
                
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
        
        tabCommande = barman.verifBoisson(barman.verifBlackList(commande));
        
        commandeDispo = tabCommande[0];
        
        commandeNonDispo = tabCommande[1];
        
        
                
        if (commandeNonDispo.getCommande().size() == 0){
            
            System.out.println("Ok j'ai Tout !");
            
            if (verifPrix(commandeDispo)){
                
                acheterBoisson(commandeDispo, barman);
                
                boire(commandeDispo);
                
            }
            
            else{
                
                System.out.println("Pas assez d'argent !!");
                
            } 
            
        }
        
        else{
            
            System.out.println("Désolé J'ai pas de : " + commandeNonDispo + "Mais j'ai bien : " + commandeDispo);
            
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
            
            System.out.println("Bon alors mets moi :" + commandeNew);
            
            if (commandeNonDispoBis.getCommande().size() == 0){
            
                System.out.println("Ok j'ai Tout !");
            
                if (verifPrix(commandeDispoBis)){
                
                    acheterBoisson(commandeDispoBis, barman);
                
                    boire(commandeDispoBis);
                
                }
            
                else{
                
                    System.out.println("Pas assez d'argent !!");
                
                } 
                
            }
                
                
            else{
                                        
                    if(commandeDispoBis.getCommande().size() == 0){
            
                        System.out.println("Désolé j'ai rien de tout ça, coco");
            
                         System.out.println("Ok tant pis");
            
                        }
                    
                    else
                        
                        System.out.println("Désolé J'ai pas de : " + commandeNonDispoBis + "Mais j'ai bien : " + commandeDispoBis);
                    
                        System.out.println("Ok mets moi juste : " + commandeDispoBis);
                    
                        if (verifPrix(commandeDispoBis)){
                
                            acheterBoisson(commandeDispoBis, barman);
                
                            boire(commandeDispoBis);
                
                        }
            
                        else{
                
                            System.out.println("Pas assez d'argent !!");
                
                        } 
                        
                        
                        }
                }
            
        
            
            
            
            
            
            
            
        }
    
    
    private void runTourneeGenerale(Barman barman){
        
        this.updatePopulariteTournee();
        
        ArrayList<Humain> listeConsomateur = new ArrayList<>();
        
        listeConsomateur = barman.reclamationTG();   
        
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
