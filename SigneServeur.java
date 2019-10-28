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
public enum SigneServeur {
    
    
    
    
    grosBiceps("biceps", "gros", "Colosse"),
    petitBiceps("biceps", "petit", "Crevette"),
    normalBiceps("biceps", "normal", "Bien batît"),
    hauteSeduction("Seduction", "Haute", "Canon"),
    moyenneSeduction("Seduction", "Haute", "Mignonne"),
    basseSeduction("Seduction", "Haute", "Gentille");
    
    private String type = "";
    private String valeur = "";
    private String toString = "";
   
  
    SigneServeur(String pType, String pValeur, String pToString){
        
        type = pType;
        valeur = pValeur;
        toString = pToString;
        
    }
    
    public String getType(){
        
        return type;
        
    }
    
    public String getValeur(){
        
        return valeur;
        
    }
    
    @Override
    public String toString(){
        
        return toString;
        
    }
   
    
    
    
    
}
