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
public class Table {
    
    private int nombrePlacesLibres;
    private int numero;
    private ArrayList<Humain> personnes;
    
    public Table(){
                
        nombrePlacesLibres = 100;
        numero = 0;           /*les tables numéro 0 doivent etre inutilisable*/
        personnes = new ArrayList<>();
        
    }
    
    public Table(int pNombrePlacesLibres, int pNumero){
                
        nombrePlacesLibres = pNombrePlacesLibres;
        numero = pNumero;
        personnes = new ArrayList<>();
    }
    
    public void setNumero(int pNumero){
        
        numero = pNumero;
        
    }
    
    public void setNombrePlacesLibres(int pNombrePlacesLibres){
        
        nombrePlacesLibres = pNombrePlacesLibres;
        
    }
    
    public int getNombrePlacesLibres(){
        
        return nombrePlacesLibres;
    }
    
    public int getNumero(){
        
        return numero;
    }
    
    public ArrayList<Humain> getPersonnes(){
        
        return personnes;
    }
    
    @Override
    public Table clone(){
        
        return new Table(nombrePlacesLibres, numero);
        
    }
    
    public boolean equals(Table pTable){
        
        return (this.nombrePlacesLibres == pTable.getNombrePlacesLibres() && this.numero == pTable.getNumero());
        
    }
    
    @Override
    public String toString(){
        
        return "Numéro : " + numero + " | Places Libres : " + nombrePlacesLibres;
        
    }
    
}
