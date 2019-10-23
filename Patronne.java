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
public class Patronne extends Humain{
    
    public Patronne(){
    
        super();  
    
}
    
    
    public Patronne(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);    
                
    }
    
    @Override
    public Patronne clone(){        
        
        return new Patronne(surnom, prenom, porteMonnaie, popularite, cri);        
        
    }
    
    public boolean equals(Patronne pPatronne){
        
        return (super.equals(pPatronne));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
