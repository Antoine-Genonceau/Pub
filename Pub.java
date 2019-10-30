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
public class Pub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Boisson coca = new Boisson("Coca", 0, 2, 5);
        StockBoisson cocacola = new StockBoisson(coca, 3);
        Boisson fanta = new Boisson("fanta", 0, 1, 3);
        StockBoisson stockfanta = new StockBoisson(fanta, 12);
        Boisson chimaybleue = new Boisson("chimaybleu", 9, 1, 3);
        StockBoisson stockchimaybleue = new StockBoisson(chimaybleue, 25);
        
        ArrayList<StockBoisson> liste = new ArrayList<>();
        
        liste.add(cocacola);
        liste.add(stockfanta);
        liste.add(stockchimaybleue);
        
        Stock stock = new Stock(liste);
        
        Table table1 = new Table(4, 1);
        Table table2 = new Table(4, 2);
        
        ArrayList<Table> listeTables = new ArrayList<>();
        
        listeTables.add(table2);
        listeTables.add(table1);
        
        Client antoine = new Client("Toine", "Antoine", 20, 15, "Rock n Roll !!!", chimaybleue, coca, 3, SigneClient.tShirtNoir);
        Client pierremaxime = new Client("PM", "Pierre-Maxime", 21, 16, "On nous en tiendra pas rigueur.", chimaybleue, fanta, 4, SigneClient.tShirtBlanc);
        Serveur gabrielle = new Serveur("Gabi", "Gabrielle", 19, 3000, "Chaud Devant !", SigneServeur.hauteSeduction);
        Serveur mathieu = new Serveur("Frere Mathieu", "Mathieu", 25, 50, "Chaud Devant !", SigneServeur.grosBiceps);
        Barman bruno = new Barman("Stef", "Bruno", 56, 95, "A Poil !!");
        Patronne michelle = new Patronne("MichMich", "Michelle", 596, 65, "Par ici la monnaie !!");
        
        ArrayList<Client> listeClients = new ArrayList<>();
        
        listeClients.add(antoine);
        listeClients.add(pierremaxime);
        
        ArrayList<Serveur> listeServeurs = new ArrayList<>();
        
        listeServeurs.add(mathieu);
        listeServeurs.add(gabrielle);
        
        Caisse caisse = new Caisse(1000);
        
        Bar garderie = new Bar("La Garderie", listeTables, caisse, stock, michelle);
        
        garderie.embauche(bruno);
        garderie.embauche(mathieu);
        garderie.embauche(gabrielle);
        garderie.entreeClient(antoine);
        garderie.entreeClient(pierremaxime);
        
        
        
        System.out.println(garderie);
        
        antoine.boire(antoine.getBoissonFav());
        antoine.boire(coca);
        
        ArrayList<StockBoisson> listeBoisson = new ArrayList<>();
        
        listeBoisson.add(cocacola);        
        listeBoisson.add(stockchimaybleue);
        
        ArrayList<Humain> humainCoca = new ArrayList<>();
        
        humainCoca.add(antoine);
        humainCoca.add(pierremaxime);
        
        
        CommandeBoisson commandeToineCoca = new CommandeBoisson(cocacola, humainCoca);
        
        ArrayList<CommandeBoisson> listeCommandeToine = new ArrayList<>();
        
        listeCommandeToine.add(commandeToineCoca);
        
        Commande commandeToine = new Commande(listeCommandeToine);
        
        antoine.payerBoisson(commandeToine, gabrielle);
        
        System.out.println(garderie);
        
        
        
        
        
        
        
       
        
    }
    
}
