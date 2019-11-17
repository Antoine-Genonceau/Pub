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
public class JeuxBelote{
	public static void main (String [] arguments){
		Paquet jeux = new Paquet();
		JoueurProgramme[] joueur = new JoueurProgramme[4];
		Fenetre tapis = new Fenetre();
		int prend = 4;// variable pour savoir qui prend
		String jeuxatout= new String(" ");// variable pour la couleur d'atout
		//qui donne le jeux
		int donne = 0;
		int n = 0;
		int n1 = 0;
		int n2 = 0;
		int gagne = 0;
		boolean manchej;
		Carte retourne;
		for (int i=0;i<4;i++){
			joueur[i] = new JoueurProgramme();
		}
		//========================================================
		jeux.creelejeux();
		//affiche le nombre de carte dans le paquet initial
		//System.out.println("valeur "+jeux.initial.length);
		//========================================================
		//melange le jeux
		jeux.donneJeuBeloteBattu();
		tapis.fenetre();
		for (int pmax=0; pmax<500;){
			jeux.razpaquet();
			//affiche sur le terminal le jeux du paquet
			//jeux.affiche();
			//affiche le jeux des joueurs
			//for (int y = 0 ; y<4 ;y++){
			//	joueur[y].affichejoueur(y);
			//}
			//=====================
			//donne premier tour
			n=2;
			n1=donne;
			n2=0;
			//donne 3 cartes
			while (n!=0){
				n1++;
				if(n1>3){
					n1=0;	
				}
				for (int i=0; i<3; i++) {
					tapis.nbcartej[n1]=joueur[n1].recoit(jeux.Jeuxdist,tapis.nbcartej[n1],jeux.blanc);
				}
				jeux.longjeuxdist=jeux.longjeuxdist-3;
				n2++;
				if(n2==4){
					n=0;
				}
			}
			//donne 2 cartes
			n=2;
			n1=donne;
			n2=0;
			while (n!=0){
				n1++;
				if(n1>3){
					n1=0;	
				}
				for (int i=0; i<2; i++) {
					tapis.nbcartej[n1]=joueur[n1].recoit(jeux.Jeuxdist,tapis.nbcartej[n1],jeux.blanc);
				}
				jeux.longjeuxdist=jeux.longjeuxdist-2;
				n2++;
				if(n2==4){
					n=0;
				}
			}
			//retourne la carte pour atout
			retourne=jeux.Jeuxdist[0];
			for (int v=0 ; v<32; v++){
				if (v+1<32){
					jeux.Jeuxdist[v] = jeux.Jeuxdist[v+1];
				}else{
					jeux.Jeuxdist[v]= jeux.blanc;
				} 	
			}
			jeux.longjeuxdist=jeux.longjeuxdist-1;
			jeuxatout=retourne.couleur.nom;
			tapis.affiche();
			//affiche le jeux des joueurs
			//for (int y = 0 ; y<4 ;y++){
			//	joueur[y].affichejoueur(y);
			//}
			tapis.affichecarter(retourne,jeuxatout);
			//=========================================
			//affiche sur le terminal le jeux du paquet
			//jeux.affiche();
			//affiche sur l'interface graphique le jeux du joueur 0
			tapis.affichejeux(joueur[0].monPaquet);
			//prend premier tour
			n=2;
			n1=donne;
			n2=0;
			while (n!=0){
				n1++;
				if(n1>3){
					n1=0;	
				}
				joueur[n1].prendpremier(n1,retourne,tapis.nbcartej[n1]);
				if (joueur[n1].recoitval==1){
					prend=n1;
					jeux.modifiemaitre(retourne,0);
					n=0;
				}
				n2++;
				if(n2==4){
					n=0;
				}
			}
			// prend deuxieme tour
			if (prend==4){
				n=2;
				n1=donne;
				n2=0;
				while (n!=0){
					n1++;
					if(n1>3){
						n1=0;	
					}
					joueur[n1].prenddeuxieme(n1,retourne,tapis.nbcartej[n1]);
					if (joueur[n1].recoitval==1){
						prend=n1;
						jeuxatout=joueur[n1].choixatout;
						n=0;
					}
					n2++;
					if(n2==4){
						n=0;
					}
				}
			}
			if (prend==4){
			// remet les cartes dans le paquet
				for (int i=0;i<4;i++){
					tapis.nbcartej[i]=jeux.remetjeux(joueur[i].monPaquet,tapis.nbcartej[i]);
				}	
				jeux.Jeuxdist[jeux.longjeuxdist]=retourne;
				retourne=jeux.blanc;
				jeux.longjeuxdist++;
			}else{
				tapis.joueurpris=("Joueur "+prend);
				tapis.affichecarter(retourne,jeuxatout);
				//distribution du reste des cartes
				n=2;
				n1=donne;
				n2=0;
				while (n!=0){
					n1++;
					if(n1>3){
						n1=0;	
					}
					if(prend==n1){
						for (int i=0; i<2; i++) {
								tapis.nbcartej[n1]=joueur[n1].recoit(jeux.Jeuxdist,tapis.nbcartej[n1],jeux.blanc);
							}
							joueur[n1].monPaquet[7]=retourne;
							retourne=jeux.blanc;
							jeux.longjeuxdist=jeux.longjeuxdist-2;
							tapis.nbcartej[n1]=tapis.nbcartej[n1]+1;
						}else{
							for (int i=0; i<3; i++) {
								tapis.nbcartej[n1]=joueur[n1].recoit(jeux.Jeuxdist,tapis.nbcartej[n1],jeux.blanc);
							}
							jeux.longjeuxdist=jeux.longjeuxdist-3;
						}
					n2++;
					if(n2==4){
						n=0;
					}
				}
				tapis.affichecarter(retourne,jeuxatout);
				joueur[0].trijeux(jeuxatout);
				tapis.affichejeux(joueur[0].monPaquet);
				tapis.effacecarteplis();
				
				// joue 
				for (int y =0 ; y<8;y++){
					if(y==0){
						n1=donne+1;	
					}else{
						n1=gagne;
					}
					n2=0;
					jeux.cartejoue=("");
					while (n2!=4){
						
						if(n1>3){
							n1=0;	
						}
						System.out.println("le joueur "+n1+" joue");
						jeux.tapisjeux[n1]=joueur[n1].jouepremier(n1,jeux.blanc,jeux.cartejoue,jeuxatout);
						if (n2==0){
							jeux.cartejoue=jeux.tapisjeux[n1].couleur.nom;
						}
						tapis.nbcartej[n1]=tapis.nbcartej[n1]-1;
						tapis.affichej(jeux.tapisjeux[n1],n1);
						tapis.affichejeux(joueur[0].monPaquet);
						n2++;
						n1++;
					}
					System.out.println("Pause appuyer sur la touche entrer pour continuer");
					Terminal.lireString();
					gagne=jeux.remportemanche(jeuxatout,y);
					//affiche la joue sur l'interface graphique
					for (int yy = 0 ; yy<4 ;yy++){
						tapis.affichej(jeux.tapisjeux[yy],yy);
					}
					System.out.println("le joueur "+gagne+" gagne le plis");
					//affiche les plis
					jeux.affiche2();
				}
				//affiche le jeux des joueur
				//for (int y = 0 ; y<4 ;y++){
				//	joueur[y].affichejoueur(y);
				//}
				//=========================
				//Qui gagne la manche
				if (jeux.posplis[0]==0 || jeux.posplis[1]==0){
					if (jeux.posplis[0]==0){
						tapis.pointj1j3=tapis.pointj1j3+250;
					}else{
						tapis.pointj0j2=tapis.pointj0j2+250;
					}
				}else{
					manchej=Arbitre.Gagnemanche(jeux.pointplis,prend);
					if (manchej==true){
						tapis.pointj1j3=tapis.pointj1j3+jeux.pointplis[1];
						tapis.pointj0j2=tapis.pointj0j2+jeux.pointplis[0];
					}else{
						if (prend==1 || prend==3){
							tapis.pointj0j2=tapis.pointj0j2+162;
						}else{
							tapis.pointj1j3=tapis.pointj1j3+162;
						}
					}
				}
				//=========================
				//remet les cartes dans le paquet
				jeux.remetjeux2();
				jeuxatout=("");
				tapis.affichecarter(retourne,jeuxatout);
				tapis.affichejeux(joueur[0].monPaquet);
			}
			//on coupe
			jeux.coupe(donne);
			//change de donneur
			donne=Arbitre.quidonne(donne);
			if(tapis.pointj1j3>500 && tapis.pointj1j3>tapis.pointj0j2)tapis.gagnant=("Joueur 1 et joueur 3 gagne je jeux");
			if(tapis.pointj0j2>500 && tapis.pointj0j2>tapis.pointj1j3)tapis.gagnant=("Joueur 0 et joueur 2 gagne je jeux");
			tapis.raffiche();
			pmax=Arbitre.testfinmanche(tapis.pointj1j3,tapis.pointj0j2);
		}
	}
}
