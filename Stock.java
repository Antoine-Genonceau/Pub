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
 * 
 * L'objet Stock est une liste de StockBoisson
 * 
 */
public class Stock {
    
    private ArrayList<StockBoisson> stock;
    
    public Stock(){
        
        stock = new ArrayList<>();
        
    }
    
    public Stock(ArrayList<StockBoisson> pStock){
        
        stock = pStock;
        
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setStock(ArrayList<StockBoisson> pStock){
        
        stock = (ArrayList<StockBoisson>) pStock.clone();
        
    }
    
    public ArrayList<StockBoisson> getStock(){
        
        return stock;
    }
    
    @Override
    public Stock clone(){
        
        ArrayList<StockBoisson> list = new ArrayList<>();
        
        for (int i = 0; i<stock.size(); i++){
        
        list.add(stock.get(i).clone());
        
        }               
        
        return new Stock(list);
        
    }
    
    public boolean equals(Stock pStock){
        
        return this.stock.equals(pStock.getStock());
        
    }
    
    @Override
    public String toString(){
        
        return stock.toString();
        
    }
    
}
