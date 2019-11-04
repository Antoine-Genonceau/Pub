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
 */
public class BlackList {
    
    private ArrayList<BlackListed> listeNoire;
    
    public BlackList(){
        
        listeNoire = new ArrayList<>();        
        
    }
    
    public BlackList(ArrayList<BlackListed> pListe){
        
        listeNoire = pListe;
        
    }
    
    public ArrayList<BlackListed> getListeNoire(){
        
        return listeNoire;
        
    }
    
    public void setListeNoire(ArrayList<BlackListed> pListeNoire){
        
        listeNoire = pListeNoire;
        
    }
    
}
