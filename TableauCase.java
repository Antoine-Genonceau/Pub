/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 * 
 * Une case de tableau contient une Equipe, un numéro d'équipe, un nombre de points, un classement
 * 
 */
public class TableauCase {
    
    private Equipe equipe;
    private int numero;
    private int points;
    private int classement;
    
    public TableauCase(){
        
        equipe = new Equipe();        
        numero = -1;
        points = -1;
        classement = -1;
        
    }
    
    public TableauCase(Equipe pEquipe, int pNumero){
        
        equipe = pEquipe;        
        numero = pNumero;
        points = -1;
        classement = -1;
        
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
    
    public int getClassement(){
        
        return classement;
        
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
    
    public void setClassement(int pClassement){
        
        classement = pClassement;
        
    }
    
    
}
