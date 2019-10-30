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
public class Fournisseur extends Humain{
    
    public Fournisseur(){
    
        super();  
    
}
    
    
    public Fournisseur(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);    
                
    }
    
    
    @Override
    public Fournisseur clone(){        
        
        return new Fournisseur(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri());        
        
    }
    
    public boolean equals(Fournisseur pFournisseur){
        
        return (super.equals(pFournisseur));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
