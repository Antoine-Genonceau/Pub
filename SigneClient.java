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
    
    tShirtNoir("tee-shirt", "noir", "Tee-Shirt Noir"),
    tShirtBlanc("tee-shirt", "blanc", "Tee-Shirt Blanc"),
    tShirtVert("tee-shirt", "vert", "Tee-Shirt Vert"),
    tShirtRouge("tee-shirt", "rouge", "Tee-Shirt Rouge"),
    tShirtBleu("tee-shirt", "bleu", "Tee-Shirt Bleu"),
    bracellet("bijoux", "bracellet", "Bracellet"),
    bague("bijoux", "bague", "Bague"), 
    collier("bijoux", "collier", "Collier"), 
    boucleOreille("bijoux", "boucleOreille", "Boucles d'oreilles"),
    montre("bijoux", "montre", "Montre");
    
    private String type = "";
    private String valeur = "";
    private String toString = "";
    
    SigneClient(String pType, String pValeur, String pToString){
        
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
