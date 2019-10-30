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
public class Table {
    
    private int nombrePlacesLibres;
    private int numero;
    
    public Table(){
                
        nombrePlacesLibres = 0;
        numero = 0;           /*les tables numéro 0 doivent etre inutilisable*/
        
    }
    
    public Table(int pNombrePlacesLibres, int pNumero){
                
        nombrePlacesLibres = pNombrePlacesLibres;
        numero = pNumero;
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
