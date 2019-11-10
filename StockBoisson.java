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
 * Cet objet correspond au stock d'une boisson spécifique
 * 
 */
public class StockBoisson {
    
    private Boisson boisson;
    private int nombre;
    
    public StockBoisson(){
        
        boisson = new Boisson();
        nombre = 0;
                
    }
    
    public StockBoisson(Boisson pBoisson, int pNombre){
        
        boisson = pBoisson;
        nombre = pNombre;
                
        
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setNombre(int pNombre){
        
        nombre= pNombre;
        
    }
    
    public void setBoisson(Boisson pBoisson){
        
        boisson = pBoisson;
        
    }
    
    public Boisson getBoisson(){
        
        return boisson;
    }
    
    public int getNombre(){
        
        return nombre;
    }
    
    @Override
    public StockBoisson clone(){
        
        return new StockBoisson(boisson, nombre);
        
    }
    
    public boolean equals(StockBoisson pStockBoisson){
        
        return(this.boisson.equals(pStockBoisson.getBoisson()) && this.nombre == pStockBoisson.getNombre());
        
    }
    
    @Override
    public String toString(){
        
        return "Type : " + boisson.getNom() + " | Nombre : " + nombre;
        
    }
    
}
