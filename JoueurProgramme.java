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
public class JoueurProgramme{
	Carte monPaquet[]= new Carte [8];
	int recoitval = 0;
	String choixatout=new String("");
	Carte cartejoue; 
	boolean belote;
	//====================================================
	public void affichejoueur(int x){
		for (int i=0; i<Fenetre.nbcartej[x]; i++) {
			System.out.println("valeurjeux joueur "+x+" carte n "+i+" valeur "+this.monPaquet[i].figure.nom+" "+this.monPaquet[i].couleur.nom);
		}
		System.out.println("-----------------------");
	}
	//==========================================================
	// recoit la carte sur le paquet
	public int recoit(Carte[] x,int y,Carte u){
		this.monPaquet[y]=x[0];
		y++;
		for (int v=0 ; v<32; v++){
			if (v+1<32){
				x[v] = x[v+1];
			}else{
				x[v]= u;
			} 	
		}
	  	return y;
	}
	//========================================================
	// prend premier tour
	public void prendpremier(int y,Carte ret,int nbcarte){
		String rep;
		String rep2=new String("o");
		String coulatout;
		boolean recup;
		int totalpoint=0;
		int points=0;
		switch(y){
			case 0 :
				System.out.println("Vous voulez prendre aux premier tour ? (o,n)");
				rep=Terminal.lireString();
				recup=rep.equals(rep2);
				if (recup == true){
					this.recoitval=1;
					//il a pris donc recoitval=1
				}else{
					this.recoitval=0;	
				}
				break;
			default :
				for (int v=0 ; v<nbcarte; v++){
					points=Arbitre.Points(this.monPaquet[v],ret.couleur.nom);
					totalpoint=totalpoint+points;
				}
				totalpoint=totalpoint+Arbitre.Points(ret,ret.couleur.nom);
				if (totalpoint>=40){
					this.recoitval=1;
				}else{
					this.recoitval=0;
				}
				//affiche la valeur de toute les cartes
				//System.out.println("Valeur des cartes "+totalpoint);
				break;
		}
		
	}
	//====================================================
	// gestion pour prendre au deuxieme tour
	public void prenddeuxieme(int y,Carte ret,int nbcarte){
		String rep;
		String rep2=new String("o");
		boolean recup;
		int totalpoint=0;
		int points=0;
		String[] coulatout={"Coeur","Pique","Trefle","Carreau"};
		int Pointint=0;
		String atoutret=new String("");
		// En fonction du joueur
		switch(y){
			case 0 :
				System.out.println("Vous voulez prendre aux deuxiéme tour ? (o,n)");
				rep=Terminal.lireString();
				recup=rep.equals(rep2);
				if (recup == true){
					System.out.println("Vous voulez prendre a quel couleur ? (Coeur,Pique,Trefle,Carreau)");
					rep=Terminal.lireString();
					this.recoitval=1;
					rep2="Coeur";
					recup=rep.equals(rep2);
					if (recup == true){
						this.choixatout=rep2;
					}
					rep2="Carreau";
					recup=rep.equals(rep2);
					if (recup == true){
						this.choixatout=rep2;
					}
					rep2="Trefle";
					recup=rep.equals(rep2);
					if (recup == true){
						this.choixatout=rep2;
					}
					rep2="Pique";
					recup=rep.equals(rep2);
					if (recup == true){
						this.choixatout=rep2;
					}
				}else{
					this.recoitval=0;	
				}
				break;
			default :
				// boucle de teste sur les 4 couleurs pour l'ordinateur
				for(int u=0 ; u<4; u++){
				totalpoint=0;		
					for (int v=0 ; v<nbcarte; v++){
						points=Arbitre.Points(this.monPaquet[v],coulatout[u]);
						totalpoint=totalpoint+points;
					}
					totalpoint=totalpoint+Arbitre.Points(ret,coulatout[u]);
					if (Pointint<totalpoint){
						Pointint=totalpoint;
						atoutret=coulatout[u];
					}
				}
			//test pour la prise
			if (Pointint>=40){
				this.recoitval=1;
				this.choixatout=atoutret;
				System.out.println("Le joueur N"+y+" a pris a la couleur "+atoutret);	
			}else{
				this.recoitval=0;
			}		
			break;				
		}
	}
	//================================
	//Trie le jeux de carte
	public void trijeux(String coulatout){
		int respos;
		int pos=0;
		int val1;
		int val3;
		boolean recup;
		Carte Paquettampon1[]= new Carte [8];
		String[]couleurtri={"Coeur","Trefle","Carreau","Pique"};
		for (int x= 0 ; x<4 ; x++){
			respos=0;
			for (int y = 0 ; y<8 ;y++){	
				recup=couleurtri[x].equals(this.monPaquet[y].couleur.nom);
				if (recup == true){
					Paquettampon1[pos]=this.monPaquet[y];
					pos++;
				}
			}
		}
		for (int y = 0 ; y<8 ;y++){
			this.monPaquet[y]=Paquettampon1[y];
		}
	}
	//======================================
	//joue premier 
	public Carte jouepremier(int y,Carte u,String carteret,String coulatout){
		Carte renvoijouee=this.monPaquet[0];
		int rep;
		boolean test;
		switch(y){
			case 0 :
				int n=20;
				while (n!=0){
					System.out.println("Quel Numero de carte jouez vous?");
					try {
						rep=Terminal.lireInt();
						rep--;
						if (rep>=0 && rep<=7){
							renvoijouee=this.monPaquet[rep];
							test=Arbitre.testcartejouee(this.monPaquet,carteret,renvoijouee,coulatout);
							if(test==true){
								for (int v = rep ; v < 8 ;v++){
									if (v+1<8){
										this.monPaquet[v]=this.monPaquet[v+1];
									}else{
										this.monPaquet[v]=u;
									}
								}
								n=0;
							}
						}
					}catch (TerminalException e){
						System.out.println("erreur de saisie");
					}
				}
				break;
			default :
				rep=Arbitre.testcartejouee2(this.monPaquet,carteret,coulatout);
				renvoijouee=this.monPaquet[rep];
				for (int v =rep ; v < 8 ;v++){
					if (v+1<8){
						this.monPaquet[v]=this.monPaquet[v+1];
					}else{
						this.monPaquet[v]=u;
					}
				}
				break;
		}
		return renvoijouee;
	}
}