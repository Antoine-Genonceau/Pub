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
public class LeRetro {
 
    public Charge CreationLeRetro(){
        
        ArrayList<Boisson> listeBoissons = new ArrayList<>();
        
        
        Boisson chimaybleue = new Boisson("chimayrouge", 9, 2, 5);
        Boisson jupiler = new Boisson("oubliette", 4, 1, 3);
        Boisson orval = new Boisson("duvel", 6, 2, 5);
        Boisson leffe = new Boisson("86", 6, 2, 4);
        Boisson cocacola = new Boisson("ice-tea", 0, 1, 3);
        Boisson fanta = new Boisson("orangina", 0, 1, 3);
        Boisson grenadine = new Boisson("limonade", 0, 1, 2);
        Boisson cafe = new Boisson("chocolat", 0, 1, 2);
        Boisson guinness = new Boisson("stela", 0, 1, 2);
        
        listeBoissons.add(chimaybleue);
        listeBoissons.add(jupiler);
        listeBoissons.add(orval);
        listeBoissons.add(leffe);
        listeBoissons.add(cocacola);
        listeBoissons.add(fanta);
        listeBoissons.add(grenadine);
        listeBoissons.add(cafe);
        listeBoissons.add(guinness);
        
        StockBoisson stockChimaybleue = new StockBoisson(chimaybleue, 500);
        StockBoisson stockJupiler = new StockBoisson(jupiler, 800);
        StockBoisson stockOrval = new StockBoisson(orval, 600);
        StockBoisson stockLeffe = new StockBoisson(leffe, 700);
        StockBoisson stockCocacola = new StockBoisson(cocacola, 5000);
        StockBoisson stockFanta = new StockBoisson(fanta, 2500);
        StockBoisson stockGrenadine = new StockBoisson(grenadine, 1000);
        StockBoisson stockCafe = new StockBoisson(cafe, 2000);
        
        Stock stockFournisseur = new Stock();
        
        stockFournisseur.getStock().add(stockCafe);
        stockFournisseur.getStock().add(stockChimaybleue);
        stockFournisseur.getStock().add(stockOrval);
        stockFournisseur.getStock().add(stockCocacola);
        stockFournisseur.getStock().add(stockFanta);
        stockFournisseur.getStock().add(stockGrenadine);
        stockFournisseur.getStock().add(stockLeffe);
        stockFournisseur.getStock().add(stockJupiler);
        
        Caisse caisseEuroDrink = new Caisse(10000);
        Fournisseur euroDrink = new Fournisseur("Neo", "Representant de Neodif", 100, "Chez Neodif c'est la boisson avant tout !", stockFournisseur, caisseEuroDrink);
        
        
        
        Patronne mariecurie = new Patronne("Le talent caché d'Einstein", "Mileva", 2000, "Derriere chaque grand homme se cache une femme", grenadine, grenadine, 0, SigneClient.bague);
        Barman jacqueschirac = new Barman("Clicli", "Bill", 360, "L'avenir n'est pas un heritage, c'est une obligation !");
        Serveur raymonddomenech = new Serveur("PouPou", "Raymond", 210, "Deuxieme c'est toujours mieux que troiseme...", SigneServeur.petitBiceps);
        Serveur isabelleautissier = new Serveur("La quebecoise", "mary", 105, "On remet deux balles ?", SigneServeur.hauteSeduction);
        Serveur zinedinezidane = new Serveur("Le tgv de aix les bains", "Christophe", 600, "Bouzour, za va ?", SigneServeur.normalBiceps);
        Serveur thomasvoeckler = new Serveur("Le blaireau", "Bernard", 320, "La gagne !", SigneServeur.grosBiceps);
        Serveur jeannielongo = new Serveur("La nageuse", "Laure", 230, "Ok phillipe !!", SigneServeur.basseSeduction);
        Client bono = new Client("Le cameleon", "David", 10000, "Une pression !!!", guinness, chimaybleue, 28, SigneClient.tShirtNoir);
        Client arthurrimbaud = new Client("Le litteraire", "Victor", 10, "Misère, misère !!!", chimaybleue, orval, 18, SigneClient.tShirtBlanc);
        Client andywarhol = new Client("Le peintre", "Claude", 90, "J'en ai marre !", cocacola, guinness, 28, SigneClient.tShirtVert);
        Client scarlettjohansson = new Client("Celle qui porte bien son nom", "Angelina", 1000, "Moteur, action !", cocacola, grenadine, 0, SigneClient.bague);
        Client antonCorbijn = new Client("Capa", "Robert", 500, "Souriez... Wistiti !", guinness, grenadine, 0, SigneClient.tShirtBlanc);
        Client arethafranklin = new Client("La plus française des françaises", "Edith", 1000, "Rien mais alors vraiment rien !", grenadine, cocacola, 0, SigneClient.collier);
        Client georgesand = new Client("Youyou", "Marguerite", 160, "Alors là c'est le coup de grace !", orval, cocacola, 32, SigneClient.tShirtRouge);
        Client emilezola = new Client("Le realisateur", "Luc", 580, "Taxi ?!", orval, chimaybleue, 16, SigneClient.tShirtBlanc);
        Client pattismith = new Client("L'égérie", "Brigitte", 580, "C'etait mieux avant !", chimaybleue, guinness, 22, SigneClient.collier);
        
        ArrayList<Table> Tables = new ArrayList<>();
        Table table1 = new Table(4, 1);
        Table table2 = new Table(4, 2);
        Table table3 = new Table(4, 3);
        Table table4 = new Table(4, 4);
        Table table5 = new Table(4, 5);
        Table table6 = new Table(4, 6);
        
        Tables.add(table1);
        Tables.add(table2);
        Tables.add(table3);
        Tables.add(table4);
        Tables.add(table5);
        Tables.add(table6);
        
        
        
        
        Caisse caisseLesixroses = new Caisse();
        
        caisseLesixroses.setLiquidite(500);
        
        Stock stockLesixroses = new Stock();
        
        Bar lesixroses = new Bar("Le Retro", Tables, caisseLesixroses, stockLesixroses);
        
        lesixroses.achatPatronne(mariecurie);
        lesixroses.embauche(jacqueschirac);
        lesixroses.embauche(jeannielongo);
        lesixroses.embauche(thomasvoeckler);
        lesixroses.embauche(zinedinezidane);
        lesixroses.embauche(raymonddomenech);
        lesixroses.entreeClient(bono);
        lesixroses.entreeClient(arthurrimbaud);
        lesixroses.entreeClient(andywarhol);
        lesixroses.entreeClient(scarlettjohansson);
        lesixroses.entreeClient(antonCorbijn);
        lesixroses.entreeClient(arethafranklin);
        lesixroses.entreeClient(georgesand);
        lesixroses.entreeClient(emilezola);
        lesixroses.entreeClient(pattismith);
        
        Stock premiereCommande = new Stock();
        
        StockBoisson stockChimaybleuecommande = new StockBoisson(chimaybleue, 50);
        StockBoisson stockOrvalcommande = new StockBoisson(orval, 50);
        StockBoisson stockJupilercommande = new StockBoisson(jupiler, 120);
        StockBoisson stockLeffecommande = new StockBoisson(leffe, 80);
        StockBoisson stockCocacolacommande = new StockBoisson(cocacola, 200);
        StockBoisson stockFantacommande = new StockBoisson(fanta, 180);
        StockBoisson stockGrenadinecommande = new StockBoisson(grenadine, 200);
        StockBoisson stockCafecommande = new StockBoisson(cafe, 300);
        
        premiereCommande.getStock().add(stockChimaybleuecommande);
        premiereCommande.getStock().add(stockOrvalcommande);
        premiereCommande.getStock().add(stockJupilercommande);
        premiereCommande.getStock().add(stockLeffecommande);
        premiereCommande.getStock().add(stockCocacolacommande);
        premiereCommande.getStock().add(stockFantacommande);
        premiereCommande.getStock().add(stockGrenadinecommande);
        premiereCommande.getStock().add(stockCafecommande);
        
        jacqueschirac.envoieCommandeFournisseur(premiereCommande, euroDrink);
        
        return new Charge(lesixroses, euroDrink, listeBoissons, "Le Retro");
        
    }
    
}
