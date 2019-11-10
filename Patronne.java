/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.ArrayList;

/**
 *
 * @author Toine
 * 
 * 
 * La patronne a tous les aspects d'une cliente mais elle possede un bar
 * 
 */
public class Patronne extends Client{
    
    private Bar bar;
    
    public Patronne(){
    
        super();  
    
}
    
    
    public Patronne(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri, Boisson pBoissonFav, Boisson pBoissonFavBis, int pNiveauAlcool, SigneClient pSigne){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri, pBoissonFav, pBoissonFavBis, pNiveauAlcool, pSigne);    
                
    }

    
    /**
     * La patronne recoit la facture du fournisseur et le paye
     * 
     * @param stockNonDispo le stock que le fournisseur n'a pas pu lui fournir
     * @param prix la facture
     */
    
    public void receptionFournisseur(Stock stockNonDispo, Caisse caisse, int prix){
        
        this.parler("Merci, voici le reglement !");
        
        this.setPorteMonnaie(this.getPorteMonnaie() - prix);
        
        caisse.setLiquidite(caisse.getLiquidite() + prix);
        
    }
    

     
    /**
     * Contrairement autres clients, la patronne ne paye pas ses consomations donc lorsqu'elle achete une commande
     * le barman lui apporte mais elle ne paye rien
     * 
     * @param commande commande de la patronne
     * @param barman elle s'adresse au barman
     */
    
    public void acheterBoisson(Commande commande, Barman barman){      
                            
            barman.chercherBoisson(commande);
            
    }
 
    /**
     * La patronne exclu un client pour cela elle regarde si un des serveurs
     * est assez costaud, et le cas échéant elle lui demande de virer le client
     * 
     * @param client client soumis à une exclusion
     */
    
    public void exclureClient(Client client){
        
        boolean done = false;
        
        int i = 0;
        
                
        while(!done && i < bar.getServeurs().size()){
            
            if (bar.getServeurs().get(i).getSigne().getValeur() == "gros"){
                
                bar.virerClient(client, bar.getServeurs().get(i)); 
                
                this.parler(bar.getServeurs().get(i).getPrenom() + " vire moi " + client.getPrenom());
                               
            }           
 
            i = i + 1;            
        }           
        
    }
    
 
    /**
     * La patronne ordonne de ne plus servir un client 
     * dans ce cas le client est blacklisté
     * 
     * @param client client concerné par le rappel a l'ordre
     */
    
    public void rappelOrdre(Client client){
        
        BlackListed blacklisted = new BlackListed(client);
        
        this.parler("Arretez de servir " + client.getPrenom());
        
        bar.getBlackList().getListeNoire().add(blacklisted);
        
    }

    /**
     * La patronne scan son bar et pour voir si quelqu'un n'a pas trop bu
     * 
     */
    
    public void checkEtatClient(){
        
        for(int i = 0; i < bar.getClients().size(); i++){
            
            if (bar.getClients().get(i).getNiveauAlcool() > 50){
                
                rappelOrdre(bar.getClients().get(i));
                
            }
            
        }
        
    }
    
     
    /**
     * En cas de tournee générale le barman doit avoir access à la liste de tous les clients 
     * or celle ci n'est disponible que dans l'objet Bar, il passe donc par la patronne 
     * qui lui retourne la liste de tous les clients
     * 
     * @return liste des clients
     */
    
    public ArrayList<Humain> reclamationTG(){
        
        ArrayList<Humain> liste = new ArrayList<>();
        
                
        for (int i = 0; i < bar.getClients().size(); i++){
            
            liste.add(bar.getClients().get(i));
            
        }
        
        return liste;
        
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setBar(Bar pBar){
        
        bar = pBar;
        
    }
    
    @Override
    public Patronne clone(){        
        
        return new Patronne(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri(), super.getBoissonFav(), super.getBoissonFavBis(), super.getNiveauAlcool(), super.getSigne());        
        
    }
    
    public boolean equals(Patronne pPatronne){
        
        return (super.equals(pPatronne));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
