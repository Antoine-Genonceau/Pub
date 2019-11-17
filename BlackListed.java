/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;

/**
 *
 * @author Toine
 * 
 * Un client blacklisté à droit à trois rappel avant de risquer d'etre viré
 */
public class BlackListed implements Serializable{
    
    private Client client;
    
    private int rappel;
    
    public BlackListed(){
    
        client = new Client();
        
        rappel = 3;
    
    }
    
    public BlackListed(Client pClient){
    
        client = pClient;
        
        rappel = 0;
    
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Client getClient(){
        
        return client;
        
    }
    
    public int getRappel(){
        
        return rappel;
        
    }
    
    public void setRappel(int pRappel){
        
        rappel = pRappel;
        
    }
    
    @Override
    public BlackListed clone(){
        
        return new BlackListed(client.clone());
        
    }
    
    public boolean equals(BlackListed pBlack){
        
        return client.equals(pBlack.getClient()) && rappel == pBlack.getRappel();
        
    }
    
    @Override
    public String toString(){
        
        return client.getPrenom() + " rapelles à l'ordre : " + rappel;
        
    }
    
}
