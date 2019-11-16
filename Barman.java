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
 * 
 * Un Barman gere une caisse et un stock, il detient le la blacklist et à une patronne
 */
public class Barman extends Humain{
    
    private Caisse caisse;
    private Stock stock;
    private Patronne patronne;
    private BlackList blacklist;
    private ArrayList<Tournoi> tournois;
    
    public Barman(){
    
        super(); 
        stock = new Stock();
        caisse = new Caisse();
        patronne = new Patronne();
        blacklist = new BlackList();
        tournois = new ArrayList();
    
}
    
    
    public Barman(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri); 
        stock = new Stock();
        caisse = new Caisse();
        patronne = new Patronne();
        blacklist = new BlackList();
        tournois = new ArrayList();
                
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions Tournoi*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void fermetureInscription(Tournoi tournoi){
        
        if (tournois.size() != 0){
            
            for (int i = 0; i < tournois.size(); i++){                
                
                if (tournoi.equals(tournois.get(i))){
                    
                    tournois.get(i).fermetureInscription();
                    
                }
                
                                
            }
            
            
        }
        
    }
    
    public void deroulementTournoi(Tournoi tournoi){
        
        if (tournois.size() != 0 ){
            
            for (int i = 0; i < tournois.size(); i++){
                
                if (tournoi.equals(tournois.get(i))){
            
                    if (!(tournois.get(i).getInscriptionsOuvertes())){
            
                        tournois.get(i).deroulementTournoi();
            
                    }
            
                }
            
            }
            
        }
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions Bar*****************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Le barman fini ses phrases par "coco"
     * 
     * @param phrase phrase de base 
     */
    
    @Override
    public void parler(String phrase){
           
        System.out.println("<" + this.getClass().getSimpleName() + " " + this.getPrenom() + "> " + phrase + ", coco.");
        
    }
    
    /**
     * Le barman anonce les tournee generales
     */
    
    public void annonceTG(){
           
        System.out.println("<" + this.getClass().getSimpleName() + " " + this.getPrenom() + "> " + "TOURNEE GENERALE !!!");
        
    }
    
    /**
     * Le barman encaisse 
     * 
     * @param somme somme ajoutée dans la caisse
     */
    
    public void encaissement(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() + somme);
        
    }
    
    /**
     * Le barman decaisse 
     * 
     * @param somme somme retirée la caisse
     */
    
    public void decaissement(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() - somme);
        
    }
    
    /**
     * Le barman transmet une partie de la caisse à sa patronne
     * 
     * @param somme transmise à la patronne 
     */
    
    public void decaissementVersPatronne(int somme){
        
        caisse.setLiquidite(caisse.getLiquidite() - somme);
        
        patronne.setPorteMonnaie(patronne.getPorteMonnaie() + somme);
        
    }
    
    /**
     * le barman verifie si le stock contient bien les boissons demandées
     * 
     * @param boisson boisons demandées
     * @return retourne le nombre de boissons non disponibles
     */
    
    public int verifBoisson(StockBoisson boisson){
                      
        int boissonNonDispo = 0;
        
        boolean done = false;
        
        for (int i = 0; i < stock.getStock().size(); i++){
            
            if (stock.getStock().get(i).getBoisson().equals(boisson.getBoisson())){
                                    
                if (stock.getStock().get(i).getNombre() < boisson.getNombre()){
                
                    boissonNonDispo = boisson.getNombre() - stock.getStock().get(i).getNombre();
                
                }             
                
                done = true;
                
            }
            
        }
            
        if (!done){
            
            boissonNonDispo = boisson.getNombre();
            
        }
        
        return boissonNonDispo;
        
    }
    
    /**
     * Le barman verifie si un humain est blacklisté 
     * 
     * @param humain humain correspondant
     * @return indique si oui ou non l'humain est blacklisté
     */
    
    public boolean verifBlackListed(Humain humain){
        
        boolean blacklisted = false;
        Class<?> classe = humain.getClass();          
                
        if (classe == Client.class){
            
            for (int i = 0; i < blacklist.getListeNoire().size(); i++){
                
                if (humain.equals(blacklist.getListeNoire().get(i).getClient())){
                    
                    blacklisted = true;
                    
                }
                
            }
            
        }      
        
        return blacklisted;
        
    }
    
    /**
     * Le barman demande la liste des clients en cas de tournee generale
     * 
     * @return retourne la liste des client
     */
    
    public ArrayList<Humain> reclamationTG(){
        
        return patronne.reclamationTG();        
        
    }
    
    /**
     * Le barman indique à la patronne qu'un client blacklisté insiste pour qu'on lui serve à boire
     * 
     * @param client client faissant de la resistance
     */
    
    public void prevenirPatronne(Client client){
        
        patronne.exclureClient(client);
        
    }
    
    /**
     * Le barman rappel à l'ordre un client blacklisté qui insiste pour boire
     * 
     * @param client client blacklisté demandant à boire
     */
    
    public void rappelClient(Client client){
        
        
        
        for (int i = 0; i < blacklist.getListeNoire().size(); i++){
            
            if (blacklist.getListeNoire().get(i).getClient().equals(client)){
                
                blacklist.getListeNoire().get(i).setRappel(blacklist.getListeNoire().get(i).getRappel() + 1);
                
                if (blacklist.getListeNoire().get(i).getRappel() > 3){
                    
                    prevenirPatronne(client);
                    
                                        
                }
                
            }
            
        }
        
        
    }
    
    /**
     * Le barman vérifie si une commande contient des clients blacklistés
     * 
     * @param commande commande correspondante
     * @return retourne la commande sans les boisson destinées à des clients blacklistés
     */
    
    public Commande verifBlackList(Commande commande){
        
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            for (int j = 0; j < commande.getCommande().get(i).getListeConsomateur().size(); j++){
                
                if (verifBlackListed(commande.getCommande().get(i).getListeConsomateur().get(j))){
                    
                    this.parler("Désolé mais " + commande.getCommande().get(i).getListeConsomateur().get(j) + " ne peut plus boire !");
                    
                    rappelClient((Client) commande.getCommande().get(i).getListeConsomateur().get(j));
                    
                    commande.getCommande().get(i).getListeConsomateur().remove(j);
                    
                    commande.getCommande().get(i).getStockBoisson().setNombre(commande.getCommande().get(i).getStockBoisson().getNombre() - 1);
                    
                }
                
            }
            
        }
       
        return commande;
        
    }
    
    /**
     * Le barman vérifie la disponibilitée des boissons d'une commande 
     * 
     * @param commande commande correspondante
     * @return retourne une commande contenant les boissons disponible et une autre contenant les boisson non disponibles sous forme d'un tableau de deux éléments
     */
    
    public Commande[] verifBoisson(Commande commande){
        
        Commande tabVerif[] = new Commande[2];
        
        Commande commandeDispo = new Commande();
        
        commandeDispo = commande;
        
        Commande commandeNonDispo = new Commande();
        
        for (int i = 0; i < commande.getCommande().size(); i++){         
                        
            CommandeBoisson commandeBoissonNonDispo = new CommandeBoisson();         
            
                    
            int boissonNonDispo = verifBoisson(commande.getCommande().get(i).getStockBoisson());
               
            if (boissonNonDispo > 0){
            
                commandeBoissonNonDispo.getStockBoisson().setBoisson(commande.getCommande().get(i).getStockBoisson().getBoisson().clone());
            
            }
           
            for(int j = 0; j < boissonNonDispo; j++){                
                
                commandeBoissonNonDispo.getStockBoisson().setNombre(commandeBoissonNonDispo.getStockBoisson().getNombre() + 1);
                
                commandeBoissonNonDispo.getListeConsomateur().add(commandeDispo.getCommande().get(i).getListeConsomateur().get(0));
                
                commandeDispo.getCommande().get(i).getStockBoisson().setNombre(commandeDispo.getCommande().get(i).getStockBoisson().getNombre() - 1);
                
                commandeDispo.getCommande().get(i).getListeConsomateur().remove(0);    
               
                
            }        
            
            if (commandeDispo.getCommande().get(i).getStockBoisson().getNombre() == 0){
                
                commandeDispo.getCommande().remove(i);
                
            }
            
            if (commandeBoissonNonDispo.getStockBoisson().getNombre() > 0){
            
                commandeNonDispo.getCommande().add(commandeBoissonNonDispo);
            
            }
            
        }     
        
        tabVerif[0] = commandeDispo;
        
        tabVerif[1] = commandeNonDispo;
        
        
        
        return tabVerif;
        
    } 
    
    /**
     * Le barman retire Les boisson achetées de son stock
     * 
     * @param boisson boissons achetées
     */
    
    public void chercherBoisson(StockBoisson boisson){
                
        for (int i = 0; i < stock.getStock().size(); i++){
            
            if (stock.getStock().get(i).getBoisson() == boisson.getBoisson()){
                
                stock.getStock().get(i).setNombre(stock.getStock().get(i).getNombre() - boisson.getNombre());
                
            }
            
        }
                
    }
    
    /**
     * Le barman retire les boissons contenues dans une commande de son stock
     * 
     * 
     * @param commande commande achetée
     */
    
    
    public void chercherBoisson(Commande commande){
                
        for (int i = 0; i < commande.getCommande().size(); i++){
            
            chercherBoisson(commande.getCommande().get(i).getStockBoisson());           
            
        }     
       
    }
    
    /**
     * Le barman passe une commande au fournisseur
     * 
     * @param pStock stock demandé
     * @param fournisseur fournisseur contacté
     */
    
    public void envoieCommandeFournisseur(Stock pStock, Fournisseur fournisseur){
        
        
        fournisseur.commande(pStock, stock, patronne);        
        
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setBlackList(BlackList pBlackList){
        
        
        blacklist = pBlackList;
        
    }
    
    public void setCaisse(Caisse pCaisse){
        
        
        caisse = pCaisse;
        
    }
    
    public void setStock(Stock pStock){
        
        stock = pStock;
        
    }
    
    public void setPatronne(Patronne pPatronne){
        
        patronne = pPatronne;
        
    }
    
    public ArrayList<Tournoi> getTournois(){
        
        return tournois;
        
    }
    
    public Caisse getCaisse(){
        
        return caisse;
        
    }
    
    public Stock getStock(){
        
        return stock;
        
    }
    
    public Patronne getPatronne(){
        
        return patronne;
        
    }
    
    @Override
    public Barman clone(){        
        
        return new Barman(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri());        
        
    }
    
    public boolean equals(Barman pBarman){
        
        
        return (super.equals(pBarman));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
