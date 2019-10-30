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
public class Stock {
    
    private ArrayList<StockBoisson> stock;
    
    public Stock(){
        
        stock = new ArrayList<>();
        
    }
    
    public Stock(ArrayList<StockBoisson> pStock){
        
        stock = pStock;
        
    }
    
    public void setStock(ArrayList<StockBoisson> pStock){
        
        stock = (ArrayList<StockBoisson>) pStock.clone();
        
    }
    
    public ArrayList<StockBoisson> getStock(){
        
        return stock;
    }
    
    @Override
    public Stock clone(){
        
        return new Stock((ArrayList<StockBoisson>) stock.clone());
        
    }
    
    public boolean equals(Stock pStock){
        
        return this.stock.equals(pStock.getStock());
        
    }
    
    @Override
    public String toString(){
        
        return stock.toString();
        
    }
    
}
