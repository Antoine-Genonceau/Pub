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
public class Barman extends Humain{
    
    public Barman(){
    
        super();  
    
}
    
    
    public Barman(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);    
                
    }
    
    @Override
    public Barman clone(){        
        
        return new Barman(surnom, prenom, porteMonnaie, popularite, cri);        
        
    }
    
    public boolean equals(Barman pBarman){
        
        
        return (super.equals(pBarman));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
