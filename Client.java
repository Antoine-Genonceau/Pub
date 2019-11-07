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
    
    private Boisson boissonFav;
    private Boisson boissonFavBis;
    private int niveauAlcool;  
    private SigneClient signe;
    
    
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
    
    
    @Override
    public void boire(Boisson pBoisson){
        
        super.boire(pBoisson);
        
        if (pBoisson.getUniteAlcool() == 0 && this.niveauAlcool > 1){
            
            this.niveauAlcool = this.niveauAlcool - 1;
            
        }
        
        else{
        
            this.niveauAlcool = this.niveauAlcool + pBoisson.getUniteAlcool();      
        
        }
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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
        
        return new Client(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri(), boissonFav, boissonFavBis, niveauAlcool, signe);        
        
    }
    
    public boolean equals(Client pClient){
        
        
        return (  super.equals(pClient)&& this.boissonFav.equals(pClient.getBoissonFav()) && this.boissonFavBis.equals(pClient.getBoissonFavBis()) && this.niveauAlcool == pClient.getNiveauAlcool() && signe.equals(pClient.signe));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + " | Boisson Favorite : " + boissonFav.getNom() + " | Boisson De Secours : " + boissonFavBis.getNom() + " | Alcoolemie : " + niveauAlcool + " | Signe Distinctif : " + signe.toString();
        
    }
    
    @Override
    public void finalize()
     {
          System.out.println("Objet nettoyé de la mémoire");   
     }
    
    
    
}
