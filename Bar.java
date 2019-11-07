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
public class Bar {
    
    private String nom;
    private ArrayList<Table> tables;
    private Caisse caisse;
    private Stock stock;
    private Patronne patronne;
    private Barman barman;
    private ArrayList<Serveur> serveurs;
    private ArrayList<Client> clients;
    private BlackList blacklist;
    
    public Bar(){
        
        nom = new String();
        tables = new ArrayList<>();
        caisse = new Caisse();
        stock = new Stock();
        patronne = new Patronne();
        barman = new Barman();
        serveurs = new ArrayList<>();
        clients = new ArrayList<>();
        blacklist = new BlackList();
        
        
        
    }
    
    public Bar(String pNom, ArrayList<Table> pTables, Caisse pCaisse, Stock pStock, Patronne pPatronne){
        
        nom = pNom;
        tables = pTables;
        caisse = pCaisse;
        stock = pStock;
        patronne = pPatronne;
        barman = new Barman();
        serveurs = new ArrayList<>();
        clients = new ArrayList<>();
        blacklist = new BlackList();
        
    }
    
    /*Uniquement pour le clonage*/
    public Bar(String pNom, ArrayList<Table> pTables, Caisse pCaisse, Stock pStock, Patronne pPatronne, Barman pBarman, ArrayList<Serveur> pServeurs, ArrayList<Client> pClients, BlackList pBlackList){
        
        nom = pNom;
        tables = pTables;
        caisse = pCaisse;
        stock = pStock;
        patronne = pPatronne;
        barman = pBarman;
        serveurs = pServeurs;
        clients = pClients;
        blacklist = pBlackList;
        
    }
    
    public void achatPatronne(Patronne patronne){
        
        patronne.setBar(this);
        patronne.setAccess(true);
        
    }
    
    public void embauche(Barman pBarman){
        
        pBarman.setCaisse(caisse);
        pBarman.setStock(stock);
        pBarman.setPatronne(patronne);
        pBarman.setBlackList(blacklist);
        
        barman = pBarman;
        pBarman.setAccess(true);
        
    }
    
    public void embauche(Serveur pServeur){
        
        pServeur.setBarman(barman);
        
        serveurs.add(pServeur);
        
        pServeur.setAccess(true);
        
        
    }
    
    public void entreeClient(Client pClient){
        
        clients.add(pClient);
        
        pClient.setAccess(true);
        
    }
    
    public void virerClient(Client pClient, Serveur pServeur){
        
        clients.remove(pClient);
        
        pClient.setAccess(false);
                
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setClients(ArrayList<Client> pClients){
        
        clients = (ArrayList<Client>) pClients.clone();
        
    }
    
    public void setServeurs(ArrayList<Serveur> pServeurs){
        
        serveurs = (ArrayList<Serveur>) pServeurs.clone();
        
    }
    
    public void setBarman(Barman pBarman){
        
        barman = pBarman;
        
    }
    
    public void setPatronnes(Patronne pPatronne){
        
        patronne = pPatronne;
        
    }
    
    public void setStock(Stock pStock){
        
        stock = pStock;
        
    }
    
    public void setCaisse(Caisse pCaisse){
        
        caisse = pCaisse;
        
    }
    
    public void setTables(ArrayList<Table> pTables){
        
        tables = (ArrayList<Table>) pTables.clone();
        
    }
    
    public void setNom(String pNom){
        
        nom = pNom;
        
    }
    
    public BlackList getBlackList(){
        
        return blacklist;
    }
    
    public ArrayList<Client> getClients(){
        
        return clients;
    }
    
    public ArrayList<Serveur> getServeurs(){
        
        return serveurs;
    }
    
    public Barman getBarman(){
        
        return barman;
    }
    
    public Patronne getPatronne(){
        
        return patronne;
    }
    
    public Stock getStocko(){
        
        return stock;
    }
    
    public Caisse getCaisse(){
        
        return caisse;
    }
    
    public ArrayList<Table> getTables(){
        
        return tables;
    }
    
    public String getNom(){
        
        return nom;
    }
    
    @Override
    public Bar clone(){
        
        return new Bar(nom, (ArrayList<Table>) tables.clone(), caisse.clone(), stock.clone(), patronne.clone(), barman.clone(), (ArrayList<Serveur>) serveurs.clone(), (ArrayList<Client>) clients.clone(), blacklist);
        
    }
    
    public boolean equals(Bar pBar){
        
        return ( this.nom.equalsIgnoreCase(pBar.getNom())&& this.tables.equals(pBar.getTables())&& this.caisse.equals(pBar.getCaisse()) && this.stock.equals(pBar.getStocko()) && this.patronne.equals(pBar.getPatronne()) && this.barman.equals(pBar.getBarman()) && this.serveurs.equals(pBar.getServeurs()) && this.clients.equals(pBar.getClients()));
        
    }
    
    @Override
    public String toString(){
        
        return "\n\nNom : " + nom + "\n\n" + "Tables : \n" + tables.toString() + "\n\n" + "Caisse : \n" + caisse.toString() + "\n\n" + "Stock : \n" + stock.toString() + "\n\n" + "Patronne : \n" + patronne.toString() + "\n\n" + "Barman :\n" + barman.toString() + "\n\n" + "Serveurs : \n" + serveurs.toString() + "\n\n" + "Clients : \n" + clients.toString() + "\n\n";
        
    }
    
}
