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
    String surnom;
    String prenom;
    int porteMonnaie;
    int popularite;
    String cri;    
    
    
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
    
    public void payerBoisson(ArrayList<Boisson> listeBoisson, Serveur serveur){
        
        int somme = 0;
        
        for (int i = 0; i < listeBoisson.size(); i++){
            
            
            somme = somme +  listeBoisson.get(i).prixVente;
            
        
        }
               
        System.out.println("Boisson payée" + somme);
            
        this.porteMonnaie = this.porteMonnaie - somme;  
            
        serveur.encaissement(somme);        
          
    }
    
    public void payerBoisson(ArrayList<Boisson> listeBoisson, Barman barman){
        
        int somme = 0;
        
        for (int i = 0; i < listeBoisson.size(); i++){
            
            
            somme = somme +  listeBoisson.get(i).prixVente;
            
        
        }
               
            
        this.porteMonnaie = this.porteMonnaie - somme;  
            
        barman.encaissement(somme);        
          
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
