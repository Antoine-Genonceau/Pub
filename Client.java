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
public class Client extends Humain{
    
    Boisson boissonFav;
    Boisson boissonFavBis;
    int niveauAlcool;
    
    
    public Client(){
    
        super();
        
        boissonFav = new Boisson();
        boissonFavBis = new Boisson();
        niveauAlcool = 0;    
    
}
    
    
    public Client(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);
        
        boissonFav = pBoissonFav;
        boissonFavBis = pBoissonFavBis;
        niveauAlcool = pNiveauAlcool;       
                
    }
    
    public int getNiveauAlcool(){
        
        return niveauAlcool;
    }
    
    public Boisson getBoissonFavBis(){
        
        return boissonFavBis;
    }
    
    
    public Boisson getBoissonFav(){
        
        return boissonFav;
    }
    
    
    @Override
    public Client clone(){        
        
        return new Client(surnom, prenom, porteMonnaie, popularite, cri, boissonFav, boissonFavBis, niveauAlcool);        
        
    }
    
    public boolean equals(Client pClient){
        
        
        return (  super.equals(pClient)&& this.boissonFav.equals(pClient.getBoissonFav()) && this.boissonFavBis.equals(pClient.getBoissonFavBis()) && this.niveauAlcool == pClient.getNiveauAlcool());
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + " | Boisson Favorite : " + boissonFav.getNom() + " | Boisson De Secours : " + boissonFavBis.getNom() + " | Alcoolemie : " + niveauAlcool;
        
    }
    
    
    
}
