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
public class Caisse {
    
    private int liquidite;
    
    public Caisse(){
        
        liquidite = 0;        
        
    }
    
    public Caisse(int pLiquidite){
        
        liquidite = pLiquidite;
        
    }
    
    public void setLiquidite(int pLiquidite){
        
        liquidite = pLiquidite;
        
    }
    
    public int getLiquidite(){
        
        return liquidite;
        
    }
    
    public Caisse clone(){
        
        return new Caisse(liquidite);
        
    }
    
    public boolean equals(Caisse pCaisse){
        
        return this.liquidite == pCaisse.liquidite;
        
    }
    
    @Override
    public String toString(){
        
        return String.valueOf(liquidite);
        
    }
}
