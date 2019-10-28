/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 */
public class Serveur extends Humain{
    
    SigneServeur signe;
    
    public Serveur(){
    
        super(); 
        
        signe = SigneServeur.normalBiceps;      
    
}
    
    
    public Serveur(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, SigneServeur pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri); 
        
        signe = pSigne;
                        
    }    
     
    public SigneServeur getSigne(){
        
        return signe;
        
    }
    
    public void setSigne(SigneServeur pSigne){
        
        signe = pSigne;
        
    }
    
    
    @Override
    public Serveur clone(){        
        
        return new Serveur(surnom, prenom, porteMonnaie, popularite, cri, signe);        
        
    }
    
    public boolean equals(Serveur pServeur){
        
        
        return (super.equals(pServeur) && signe.equals(pServeur.getSigne()));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + " | Signe Distinctif : " + signe; 
        
    }
    
}
