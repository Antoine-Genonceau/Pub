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
 * Un client à une boisson favorite et une de secours, un niveau d'alcool, et signe distinctif, un tee-shirt pour les hommes et un bijoux pour les femmes
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
    
    
    public Client(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri);
        
        boissonFav = pBoissonFav;
        boissonFavBis = pBoissonFavBis;
        niveauAlcool = pNiveauAlcool; 
        signe = pSigne;
        
                
    }
    
    /**
     * Quand un client s'adresse à un serveur il peut finir ses phrases différemant suivant son sexe et son alcoolemie
     * 
     * @param phrase phrase de base
     * @param serveur serveur auquel le client s'adresse
     */
    
    public void parler(String phrase, Serveur serveur){
        
        String extention = "";
        
        if (this.getSigne().getType() == "tee-shirt" && this.getNiveauAlcool() > 14){
            
            if (serveur.getSigne().getType() == "Seduction"){
                
                extention = ", ma jolie";
                
            }
            
            else{
                
                if (this.getPopularite() > serveur.getPopularite()){
                    
                    extention = serveur.getSigne().getExtention();
                    
                }
                
                
            }
            
        }
        
        else{
            
            if (serveur.getSigne().getType() == "biceps" && this.getNiveauAlcool() > 14){
                
                extention = ", beau gosse";
                
            }
            
            else{
                
                if (this.getPopularite() > serveur.getPopularite()){
                    
                    extention = serveur.getSigne().getExtention();
                    
                }
                
                
            }
            
        }
        
        
        this.parler(phrase + extention);
        
    }
    
    /**
     * Un client se presente en precisant son signe distinctif
     * 
     */
   
    @Override
    public void presentation(){
        
        String presentation = "Salut moi c'est " + this.getPrenom() + ", mais tout le monde m'appelle " + this.getSurnom() + ", je suis " + this.getClass().getSimpleName() + ", et je porte " + this.getSigne().getGenre() + " " + this.getSigne().toString() + ".";
        
        this.parler(presentation);
        
    }
    
    /**
     * Le client à un niveau d'alcool qui evolue
     * 
     * @param pBoisson boisson bu
     */
    
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
        
        return new Client(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri(), boissonFav, boissonFavBis, niveauAlcool, signe);        
        
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
