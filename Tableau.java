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
public class Tableau {
    
    private ArrayList<TableauCase> tableau;
    
    public Tableau(){
        
        
    }
    
    public Tableau(ArrayList<Equipe> equipes){
        
        tableau = new ArrayList();
        
        for (int i = 0; i < equipes.size(); i++){
            
            TableauCase caseTemp = new TableauCase(equipes.get(i), i);
            
            tableau.add(caseTemp);           
            
            
        }
        
    }
    
    public ArrayList<TableauCase> getTableau(){
        
        return tableau;
        
    }
    
}
