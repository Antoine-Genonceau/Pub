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
public class Cible {
    
    ArrayList<Integer> cases;
    
    public Cible(){
        
        int casesliste[] = {20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5};
        
        cases = new ArrayList<>();
        
        cases.add(20);
        cases.add(1);
        cases.add(18);
        cases.add(4);
        cases.add(13);
        cases.add(6);
        cases.add(10);
        cases.add(15);
        cases.add(2);
        cases.add(17);
        cases.add(3);
        cases.add(19);
        cases.add(7);
        cases.add(16);
        cases.add(8);
        cases.add(11);
        cases.add(14);
        cases.add(9);
        cases.add(12);
        cases.add(5);
        
        
    }
    
    
    public int calculPoints(int r, int alpha){
        
        int points = 0;
        
        r = safeR(r);
        alpha = safeAlpha(alpha);
        
        if (r == 10){
            
            points = cases.get(alpha) * 2;
            
        }
        
        if (r <= 9 && r > 5){
            
            
            points = cases.get(alpha);
            
        }
        
        if (r == 5){
            
            points = cases.get(alpha) * 3;
            
        }
        
        if (r <= 4 && r > 2){
            
            points = cases.get(alpha);
        }
        
        if (r == 1){
            
            points = 25;
            
        }
        
        if (r == 0){
            
            points = 50;
        }
        
        return points;
        
    }
    
    public String calculCases(int r, int alpha){
        
        r = safeR(r);
        alpha = safeAlpha(alpha);
        
        String caseTouchée = "Hors cible !";
        
        if (r == 10){
            
            caseTouchée = "Double " + cases.get(alpha);
            
        }
        
        if (r <= 9 && r > 5){
            
            
            caseTouchée = "Simple " + cases.get(alpha);
            
        }
        
        if (r == 5){
            
            caseTouchée = "Triple " + cases.get(alpha);
            
        }
        
        if (r <= 4 && r > 2){
            
            caseTouchée = "Simple " + cases.get(alpha);
        }
        
        if (r == 1){
            
            caseTouchée = "Bull !";
            
        }
        
        if (r == 0){
            
            caseTouchée = "Eye-Bull !!";
        }
        
        return caseTouchée;
        
    }
    
    public int safeAlpha(int alpha){
        
        int safeAlpha = alpha;
        
        if (alpha < 0){
            
            safeAlpha = cases.size() + alpha;
            
        }
        
        if (alpha > cases.size() - 1){
            
            while(safeAlpha > cases.size() - 1){
            
                safeAlpha = alpha - cases.size();
            
            }
            
        }
        
        
        return safeAlpha;
        
    }
    
    
    public int safeR(int r){
        
        int safeR = r;
        
        if (safeR < 0){
            
            safeR = - safeR;
            
        }
        
        
        return safeR;        
        
    }
    
}
