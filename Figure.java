/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Edouard
 */
public class Figure {
	String nom;
	public static Figure Sept = new Figure("Sept");
	public static Figure Huit = new Figure("Huit");
	public static Figure Neuf = new Figure("Neuf");
	public static Figure Dix = new Figure("Dix");
	public static Figure Valet = new Figure("Valet");
	public static Figure Dame = new Figure("Dame");
	public static Figure Roi = new Figure("Roi");
	public static Figure As = new Figure("As");
        
	public Figure ( String nomFigure ){
		this.nom = nomFigure ;
	}
}
