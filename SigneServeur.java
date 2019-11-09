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
    
    
    
    
    grosBiceps("biceps", "gros", "Colosse", 100),
    petitBiceps("biceps", "petit", "Crevette", 1),
    normalBiceps("biceps", "normal", "Bien batît", 10),
    hauteSeduction("Seduction", "Haute", "Canon", 100),
    moyenneSeduction("Seduction", "Haute", "Mignonne", 10),
    basseSeduction("Seduction", "Haute", "Gentille", 1);
    
    private String type = "";
    private String valeur = "";
    private String toString = "";
    private int coeff = 0;
   
  
    SigneServeur(String pType, String pValeur, String pToString, int pCoeff){
        
        type = pType;
        valeur = pValeur;
        toString = pToString;
        coeff = pCoeff;
        
    }
    
    public String getType(){
        
        return type;
        
    }
    
    public String getValeur(){
        
        return valeur;
        
    }
    
    public int getCoeff(){
        
        return coeff;
        
    }
    
    @Override
    public String toString(){
        
        return toString;
        
    }
   
    
    
    
    
}
