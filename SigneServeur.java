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
    
    
    
    
    grosBiceps("biceps", "gros", "Colosse", 100, " popeye"),
    petitBiceps("biceps", "petit", "Crevette", 1, "minus"),
    normalBiceps("biceps", "normal", "Bien batît", 10, "mon petit"),
    hauteSeduction("Seduction", "Haute", "Canon", 100, "la miss"),
    moyenneSeduction("Seduction", "Moyenne", "Mignonne", 10, "poulette"),
    basseSeduction("Seduction", "Basse", "Gentille", 1, "ma petite");
    
    private String type = "";
    private String valeur = "";
    private String toString = "";
    private int coeff = 0;
    private String extention = "";
   
  
    SigneServeur(String pType, String pValeur, String pToString, int pCoeff, String pExtention){
        
        type = pType;
        valeur = pValeur;
        toString = pToString;
        coeff = pCoeff;
        extention = pExtention;
        
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
    
    public String getExtention(){
        
        return extention;
        
    }
    
    @Override
    public String toString(){
        
        return toString;
        
    }
   
    
    
    
    
}
