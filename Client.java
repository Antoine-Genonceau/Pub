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
    SigneClient signe;
    
    public Client(){
    
        super();
        
        boissonFav = new Boisson();
        boissonFavBis = new Boisson();
        niveauAlcool = 0;    
        signe = SigneClient.tShirtBlanc;
    
}
    
    
    public Client(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);
        
        boissonFav = pBoissonFav;
        boissonFavBis = pBoissonFavBis;
        niveauAlcool = pNiveauAlcool; 
        signe = pSigne;
                
    }
    
    public SigneClient getSigne(){
        
        return signe;
        
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
    
    public void setSigne(SigneClient pSigne){
        
        signe = pSigne;
        
    }
    
    public void setBoisseonFav(Boisson pBoissonFav){
        
        boissonFav = pBoissonFav;
        
    }
    
    public void setBoisseonFavBis(Boisson pBoissonFavBis){
        
        boissonFavBis = pBoissonFavBis;
        
    }
    
    public void setNiveauAlcool(int pNiveauAlcool){
        
        niveauAlcool = pNiveauAlcool;
        
    }
    
    
    @Override
    public Client clone(){        
        
        return new Client(surnom, prenom, porteMonnaie, popularite, cri, boissonFav, boissonFavBis, niveauAlcool, signe);        
        
    }
    
    public boolean equals(Client pClient){
        
        
        return (  super.equals(pClient)&& this.boissonFav.equals(pClient.getBoissonFav()) && this.boissonFavBis.equals(pClient.getBoissonFavBis()) && this.niveauAlcool == pClient.getNiveauAlcool() && signe.equals(pClient.signe));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + " | Boisson Favorite : " + boissonFav.getNom() + " | Boisson De Secours : " + boissonFavBis.getNom() + " | Alcoolemie : " + niveauAlcool + " | Signe Distinctif : " + signe.toString();
        
    }
    
    
    
}
