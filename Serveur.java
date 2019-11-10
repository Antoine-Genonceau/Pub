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
    
    private SigneServeur signe;
    private Barman barman;    
    
    public Serveur(){
    
        super(); 
        
        signe = SigneServeur.normalBiceps;   
        
        barman = new Barman();
    
}
    
    
    public Serveur(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri, SigneServeur pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri); 
        
        signe = pSigne;
        
        barman = new Barman();
                        
    }    
    
        
    public void encaissement(int somme,Commande commande){
        
        this.parler("Tiens " + barman.getPrenom() + " " + somme + " € pour " + commande);
        
        barman.parler("Merci ! Je te sors ça tout de suite !");
        
        barman.encaissement(somme);       
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    
    public void setBarman(Barman pBarman){
        
        barman = pBarman;
        
    }
    
    public Barman getBarman(){
        
        return barman;
        
    }
    
    public SigneServeur getSigne(){
        
        return signe;
        
    }
    
    public void setSigne(SigneServeur pSigne){
        
        signe = pSigne;
        
    }
    
        
    @Override
    public Serveur clone(){        
        
        return new Serveur(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri(), signe);        
        
    }
    
    public boolean equals(Serveur pServeur){
        
        
        return (super.equals(pServeur) && signe.equals(pServeur.getSigne()));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + " | Signe Distinctif : " + signe; 
        
    }
    
}
