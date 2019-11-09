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
public enum SigneClient {
    
    tShirtNoir("tee-shirt", "noir", "Tee-Shirt Noir", "un"),
    tShirtBlanc("tee-shirt", "blanc", "Tee-Shirt Blanc", "un"),
    tShirtVert("tee-shirt", "vert", "Tee-Shirt Vert", "un"),
    tShirtRouge("tee-shirt", "rouge", "Tee-Shirt Rouge", "un"),
    tShirtBleu("tee-shirt", "bleu", "Tee-Shirt Bleu", "un"),
    bracellet("bijoux", "bracellet", "Bracellet", "un"),
    bague("bijoux", "bague", "Bague", "une"), 
    collier("bijoux", "collier", "Collier", "un"), 
    boucleOreille("bijoux", "boucleOreille", "Boucles d'oreilles", "des"),
    montre("bijoux", "montre", "Montre", "une");
    
    private String type = "";
    private String valeur = "";
    private String toString = "";
    private String genre = "";
    
    SigneClient(String pType, String pValeur, String pToString, String pGenre){
        
        type = pType;
        valeur = pValeur;
        toString = pToString;
        genre = pGenre;
        
    }
    
    public String getType(){
        
        return type;
        
    }
    
    public String getValeur(){
        
        return valeur;
        
    }
    
    public String getGenre(){
        
        return genre;
        
    }
    
        
    @Override
    public String toString(){
        
        return toString;
        
    }
    
    
    
}
