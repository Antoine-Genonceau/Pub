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
    
    
    public Humain(){
        surnom = new String();
        prenom = new String();
        porteMonnaie=0;
        popularite=0;
        cri = new String();
        
        
    }
    
    public Humain(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
    
        
        surnom = pSurnom;
        prenom = pPrenom;
        porteMonnaie = pPorteMonnaie;
        popularite = pPopularite;
        cri = pCri;
    
            
    
    }
    
    
    public void boire(Boisson pBoisson){        
            
        System.out.println(this.surnom + " a bu la boisson : " + pBoisson.toString());
        
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
               
        System.out.println("Boisson payée" + somme);
            
        this.porteMonnaie = this.porteMonnaie - somme;  
            
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
        
            if (barman.verifBoisson(commande)){
                
                barman.chercherBoisson(commande);
                
                payerBoisson(commande, barman);
                
            }          
       
    }
    
    public void consommer(ArrayList<Humain> listeConsomateur, Barman barman){
        
        Commande commande = new Commande();
        
        commande = creationCommande(listeConsomateur);
                
        if (barman.verifBoisson(commande)){
            
            if (verifPrix(commande)){
                
                acheterBoisson(commande, barman);
                
                boire(commande);
                
            }
            
            else{
                
                System.out.println("Pas assez d'argent !!");
                
            }
            
            
        }
        
        
        else{
            
            System.out.println("Pas en stock !!");
            
        }
        
        
        
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
                
                commandeBoissonServeurTemp.setCommandeBoisson((Client) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonServeurTemp.clone();
                
            }
            
            if (classe == Barman.class){
                
                CommandeBoisson commandeBoissonBarmanTemp = new CommandeBoisson();
                
                commandeBoissonBarmanTemp.setCommandeBoisson((Client) listeConsomateur.get(i));
                
                commandeBoissonTemp = commandeBoissonBarmanTemp.clone();
                
            }
            
            if (classe == Patronne.class){
                
                CommandeBoisson commandeBoissonPatronneTemp = new CommandeBoisson();
                
                commandeBoissonPatronneTemp.setCommandeBoisson((Client) listeConsomateur.get(i));
                
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
    
    
    public boolean equals(Humain pHumain){        
        
        return ( this.surnom.equals(pHumain.getSurnom()) && this.prenom.equals(pHumain.getPrenom()) && this.porteMonnaie == pHumain.getPorteMonnaie() && this.popularite == pHumain.getPopularite() && this.cri.equals(pHumain.getCri()));
        
    }
    
    @Override
    public String toString(){
        
        return "Surnom : " + surnom + " | Prenom : " + prenom + " | Porte Monnaie : " + porteMonnaie + " | Popularite : " + popularite + " | Cri : " + cri;
        
    }
    
}
