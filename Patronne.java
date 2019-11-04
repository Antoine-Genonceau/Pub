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
public class Patronne extends Client{
    
    public Patronne(){
    
        super();  
    
}
    
    
    public Patronne(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri, pBoissonFav, pBoissonFavBis, pNiveauAlcool, pSigne);    
                
    }
    
    public void receptionFournisseur(Stock stockNonDispo, Caisse caisse, int prix){
        
        System.out.println("stockNonDispo" + stockNonDispo);
        
        this.setPorteMonnaie(this.getPorteMonnaie() - prix);
        
        caisse.setLiquidite(caisse.getLiquidite() + prix);
        
    }
    
    public void acheterBoisson(Commande commande, Barman barman){      
                            
            barman.chercherBoisson(commande);
            
    }
    
    @Override
    public Patronne clone(){        
        
        return new Patronne(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri(), super.getBoissonFav(), super.getBoissonFavBis(), super.getNiveauAlcool(), super.getSigne());        
        
    }
    
    public boolean equals(Patronne pPatronne){
        
        return (super.equals(pPatronne));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
