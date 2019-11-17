/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.IOException;

/**
 *
 * @author Toine
 */
public class QuitException extends Exception{
    
    public QuitException(Interface inter) throws IOException{
        
            inter.creerSauvegarde();
            System.out.print("\nAu revoir, à bientot !\n");
        
            System.exit(0);
        
        }
}
