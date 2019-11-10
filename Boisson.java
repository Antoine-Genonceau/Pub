/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 * 
 * Une boisson à un nom, une unite d'alcool, un prix d'achat et un prix de vente
 */
public class Boisson {
    
    private String nom;
    private int uniteAlcool;    /*si 0 boisson sans alcool*/
    private int prixAchat;
    private int prixVente;
    
    public Boisson(){
        
        nom = new String();
        uniteAlcool = 0;
        prixAchat = 0;
        prixVente = 0;
        
    }
    
    public Boisson(String pNom, int pUniteAlcool, int pPrixAchat, int pPrixVente){
        
        nom = pNom;
        uniteAlcool = pUniteAlcool;
        prixAchat = pPrixAchat;
        prixVente = pPrixVente;
        
    }
    
    public void setPrixVente(int pPrixVente){
        
        prixVente = pPrixVente;
        
    }
    
    public void setPrixAchat(int pPrixAchat){
        
        prixAchat = pPrixAchat;
        
    }
    
    public void setUniteAlcool(int pUniteAlcool){
        
        uniteAlcool = pUniteAlcool;
        
    }
    
    public void setNom(String pNom){
        
        nom = pNom;
        
    }
    
    
    public String getNom(){
        
        return nom;
    }
    
    public int getUniteAlcool(){
        
        return uniteAlcool;
    }
    
    public int getPrixAchat(){
        
        return prixAchat;
    }
    
    public int getPrixVente(){
        
        return prixVente;
    }
    
    @Override
    public Boisson clone(){
        
        return new Boisson(nom, uniteAlcool, prixAchat, prixVente);
        
    } 
    
    public boolean equals(Boisson pBoisson){
        
        
        return ( this.nom.equals(pBoisson.getNom()) && this.prixAchat == pBoisson.getPrixAchat() && this.prixVente == pBoisson.prixVente && this.uniteAlcool == pBoisson.getUniteAlcool());
        
    }
    
    @Override
    public String toString(){
        
        return "Nom : " + nom + " | Prix Achat : " + prixAchat + " | Prix Vente : " + prixVente + " | Unite Alcool : " + uniteAlcool;
        
    }
}
