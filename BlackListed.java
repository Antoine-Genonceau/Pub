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
public class BlackListed {
    
    private Client client;
    
    private int rappel;
    
    public BlackListed(){
    
        client = new Client();
        
        rappel = 3;
    
    }
    
    public BlackListed(Client pClient){
    
        client = pClient;
        
        rappel = 3;
    
    }
    
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
        
        return client.getPrenom() + " à été rapellé à l'ordre " + (rappel - 2) + " fois ";
        
    }
    
}
