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
public class Arbitre{
	public static int quidonne(int donne){
		//affiche avant le traitement qui doit donner le jeux
		//Terminal.ecrireStringln("qui donne dans arbitre J"+donne);
		switch(donne){
			case 0 : donne = 1;
				break;
			case 1 : donne = 2;
				break;
			case 2 : donne = 3;
				break;
			case 3 : donne = 0;
				break;
		}
		//affiche la personne qui doit donner le jeux
		//Terminal.ecrireStringln("qui donne dans arbitre J"+donne);
		return donne;
	}
	//======================================
	// figure d'une carte
	public static int fig2(Carte x){
		int vaaff=0;
		if (x.figure==Figure.Sept){
			vaaff=1;
		}
		if (x.figure==Figure.Huit){
			vaaff=2;
		}
		if (x.figure==Figure.Neuf){
			vaaff=3;
		}
		if (x.figure==Figure.Dix){
			vaaff=4;
		}
		if (x.figure==Figure.Valet){
			vaaff=5;
		}
		if (x.figure==Figure.Dame){
			vaaff=6;
		}
		if (x.figure==Figure.Roi){
			vaaff=7;
		}
		if (x.figure==Figure.As){
			vaaff=8;
		}
		return vaaff;
	}
	//===================================
	// le rang d'une couleur de la carte
	public static int coulrang(Carte x){
		int vaaff2=0;
		if (x.couleur==Couleur.Coeur){
			vaaff2=0;
		}
		if (x.couleur==Couleur.Pique){
			vaaff2=1;
		}
		if (x.couleur==Couleur.Carreau){
			vaaff2=2;
		}
		if (x.couleur==Couleur.Trefle){
			vaaff2=3;
		}
		return vaaff2;		
	}
	//======================================
	// renvois la valeur d'une carte	
	public static int Points(Carte x,String y){
		int point1=0;
		String vcouleur;
		int vfigure;
		vcouleur=x.couleur.nom;
		vfigure=fig2(x);
		if (y==vcouleur){
			switch(vfigure){
				case 1 : point1=0;
					break;
				case 2 : point1=0;
					break;
				case 3 : point1=14;
					break;
				case 4 : point1=10;
					break;	
				case 5 : point1=20;
					break;
				case 6 : point1=3;
					break;
				case 7 : point1=4;
					break;
				case 8 : point1=11;
					break;
			}
		}else{
			switch(vfigure){
				case 1 : point1=0;
					break;
				case 2 : point1=0;
					break;
				case 3 : point1=0;
					break;
				case 4 : point1=10;
					break;	
				case 5 : point1=2;
					break;
				case 6 : point1=3;
					break;
				case 7 : point1=4;
					break;
				case 8 : point1=11;
					break;
			}
			
		}
		return point1;
	}
	//=====================================================
	//points sur une manche
	public static int Pointsjeu(Carte x,String y,String u){
		int point1=0;
		int vfigure;
		vfigure=fig2(x);
		if (y==x.couleur.nom){
			switch(vfigure){
				case 1 : point1=9;
					break;
				case 2 : point1=10;
					break;
				case 3 : point1=15;
					break;
				case 4 : point1=13;
					break;	
				case 5 : point1=16;
					break;
				case 6 : point1=11;
					break;
				case 7 : point1=12;
					break;
				case 8 : point1=14;
					break;
			}
		}else{
			
			if (u==x.couleur.nom){
				switch(vfigure){
					case 1 : point1=1;
						break;
					case 2 : point1=2;
						break;
					case 3 : point1=3;
						break;
					case 4 : point1=7;
						break;	
					case 5 : point1=4;
						break;
					case 6 : point1=5;
						break;
					case 7 : point1=6;
						break;
					case 8 : point1=8;
						break;
				}
			}else{
				
				switch(vfigure){
					case 0 :point1=0;
						break;
					case 1 : point1=0;
						break;
					case 2 : point1=0;
						break;
					case 3 : point1=0;
						break;
					case 4 : point1=0;
						break;	
					case 5 : point1=0;
						break;
					case 6 : point1=0;
						break;
					case 7 : point1=0;
						break;
					case 8 : point1=0;
						break;
				}
				
			}
		}
		return point1;
	}
	//=====================================================
	//gagne la manche
	public static boolean Gagnemanche(int[] x,int y){
		boolean v= false;
		if (y==1 || y==3){
			if(x[0]<x[1]){
				v=true;
			}else{
				v=false;
			}
		}else{
			if(x[0]>x[1]){
				v=true;
			}else{
				v=false;
			}
		}
		return v;
	}
	//====================================================
	// test fijn manche pour savoir si la partie est fini
	public static int testfinmanche(int x,int y){
		int v=0;
		if(x<y){
			v=y;	
		}else{
			y=v;
		}
		return v;
	}
	//==============================================
	//test carte jouer
	public static boolean testcartejouee(Carte[] x,String y, Carte uv,String coulatout){
		boolean v=false;
		boolean test;
		test=y.equals("");
		testc :	if(test==true){
				v=true;	
				break testc ;
			}else{
				//test si la carte est de la couleur du jeux jouer
				test=uv.couleur.nom.equals(y);
			 	if(test==true){
					v=true;	
					break testc ;		
				}else{
					//test si une des cartes est de la couleur du jeux 
					for(int i=0 ; i<8 ;i++){
						test=x[i].couleur.nom.equals(y);
						if(test==true){
							v=false;
							System.out.println("Jouer une carte de la couleur demander "+y);
							break testc ;
						}
					}
					//Test si la carte est de la couleur de l'atout
					test=uv.couleur.nom.equals(coulatout);
					if (test==true){
						v=true;
						break testc ;		
					}else{
						// test si au moins une carte est de la couleur de l'atout
						for(int i=0 ; i<8 ;i++){
							test=x[i].couleur.nom.equals(coulatout);
							if(test==true){
								v=false;
								System.out.println("Jouer une carte d'atout  "+coulatout);
								break testc ;
							}
						}
						v=true;
						break testc ;
					}
				}
			}
		return v;
	}
	//========================================================
	//test pour jeux nieme
	public static int testcartejouee2(Carte[] x,String carteret,String coulatout){
		int v=0;
		boolean test;
		test=carteret.equals("");
		testc :	if(test==false){
				for(int i=0 ; i<8 ;i++){
					test=x[i].couleur.nom.equals(carteret);
					if(test==true){
						v=i;
						break testc ;
					}	
				}
				for(int i=0 ; i<8 ;i++){
					test=x[i].couleur.nom.equals(coulatout);
					if(test==true){
						v=i;
						break testc ;
					}	
				}
				v=0;
			}
		return v;
	}
}