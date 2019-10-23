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
    
    public Serveur(){
    
        super();  
    
}
    
    
    public Serveur(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);    
                
    }
    
    @Override
    public Serveur clone(){        
        
        return new Serveur(surnom, prenom, porteMonnaie, popularite, cri);        
        
    }
    
    public boolean equals(Serveur pServeur){
        
        
        return (super.equals(pServeur));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
