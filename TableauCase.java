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
public class TableauCase {
    
    private Equipe equipe;
    private int numero;
    private int points;
    
    
    public TableauCase(Equipe pEquipe, int pNumero){
        
        equipe = pEquipe;        
        numero = pNumero;
        points = -1;
        
    }
    
    public Equipe getEquipe(){
        
        return equipe;
        
    }
    
    public int getNumero(){
        
        return numero;
        
    }
    
    public int getPoints(){
        
        return points;
        
    }
    
    public void setEquipe(Equipe pEquipe){
        
        equipe = pEquipe;
        
    }
    
    public void setNumero(int pNumero){
        
        numero = pNumero;
        
    }
    
    
    public void setPoints(int pPoints){
        
        points = pPoints;
        
    }
    
    
}
