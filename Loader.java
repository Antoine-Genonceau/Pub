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
public class Loader {
    
    public void CreationLeSixRoses(){
        
        Boisson chimaybleue = new Boisson("chimaybleu", 9, 2, 5);
        Boisson jupiler = new Boisson("jupiler", 4, 1, 3);
        Boisson orval = new Boisson("orval", 6, 2, 5);
        Boisson leffe = new Boisson("leffe", 6, 2, 4);
        Boisson cocacola = new Boisson("cocacola", 0, 1, 3);
        Boisson fanta = new Boisson("fanta", 0, 1, 3);
        Boisson grenadine = new Boisson("grenadine", 0, 1, 2);
        Boisson cafe = new Boisson("café", 0, 1, 2);
        Boisson guinness = new Boisson("guinness", 0, 1, 2);
        
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
        Fournisseur euroDrink = new Fournisseur("ED", "Representant de Euro Drink", 100, "Chez Euro Drink c'est la passion avant tout !", stockFournisseur, caisseEuroDrink);
        
        
        
        Patronne mariecurie = new Patronne("La doc'", "Marie", 2000, "La science d'abord !", grenadine, grenadine, 0, SigneClient.bague);
        Barman jacqueschirac = new Barman("Le bulldozer", "Jacques", 360, "J'aimes les pommes, mangez des pommes !!");
        Serveur raymonddomenech = new Serveur("Le chauffeur", "Raymond", 210, "Terminus tout le monde descends !", SigneServeur.petitBiceps);
        Serveur isabelleautissier = new Serveur("Isa", "Isabelle", 105, "Hissez haut !", SigneServeur.hauteSeduction);
        Serveur zinedinezidane = new Serveur("Bouboule", "Zinedine", 600, "Et 1, et 2 et 3 zeros !", SigneServeur.normalBiceps);
        Serveur thomasvoeckler = new Serveur("Françis", "Thomas", 320, "Attaque Pierrot !", SigneServeur.grosBiceps);
        Serveur jeannielongo = new Serveur("ninie", "Jeannie", 230, "Par ici la monnaie !!", SigneServeur.basseSeduction);
        Client bono = new Client("Dieu", "Bono", 10000, "Rock n Roll !!!", guinness, chimaybleue, 28, SigneClient.tShirtNoir);
        Client arthurrimbaud = new Client("Le poete au semelles de vent", "Arthur", 10, "Vive les ardennes !!!", chimaybleue, orval, 18, SigneClient.tShirtBlanc);
        Client andywarhol = new Client("Le quatres couleurs", "Andy", 90, "Rock n Roll !!!", cocacola, guinness, 28, SigneClient.tShirtVert);
        Client scarlettjohansson = new Client("L'actrice", "scarlett", 1000, "Moteur, action !", cocacola, grenadine, 0, SigneClient.bague);
        Client antonCorbijn = new Client("Pellicule-Man", "Anton", 500, "Souriez... Wistiti !", guinness, grenadine, 0, SigneClient.tShirtBlanc);
        Client arethafranklin = new Client("Lady Soul", "aretha", 1000, "Respect !", grenadine, cocacola, 0, SigneClient.collier);
        Client georgesand = new Client("Amantine", "george", 160, "Qui aurait un timbre ?", orval, cocacola, 32, SigneClient.tShirtRouge);
        Client emilezola = new Client("Aurore-Man", "Emile", 580, "J'accuse !", orval, chimaybleue, 16, SigneClient.tShirtBlanc);
        Client pattismith = new Client("La poete", "Patty", 580, "Because the night...", chimaybleue, guinness, 22, SigneClient.collier);
        
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
        
        Bar lesixroses = new Bar("Le six roses", Tables, caisseLesixroses, stockLesixroses);
        
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
        
        System.out.println(lesixroses);
   
        ArrayList<Humain> listeConsomateur = new ArrayList<>();
        listeConsomateur.add(zinedinezidane);
        
        bono.consommer(listeConsomateur, zinedinezidane);
        
        
        
    }
    
   
    
}
