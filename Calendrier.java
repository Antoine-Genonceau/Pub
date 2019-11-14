/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 *
 * @author Toine
 */
public class Calendrier {
    
    private ArrayList<Equipe[]> calendrier;
    
    public Calendrier(ArrayList<Equipe> listeEquipe){
        
        calendrier = new ArrayList<>();
            
        for (int i = 0; i < listeEquipe.size() - 1; i++){
            
            for (int j = i + 1; j < listeEquipe.size(); j++){
            
                Equipe[] match = new Equipe[2];
                
                match[0] = listeEquipe.get(i);
                match[1] = listeEquipe.get(j);
                
                calendrier.add(match);
            
        }
            
        }
        
        shuffle(calendrier);
            
    }
    
    public ArrayList<Equipe[]> getClendrier(){
        
        return calendrier;
        
    }
    
}
