/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

import java.io.Serializable;

/**
 *
 * @author Toine
 * 
 * Le fournisseur à un stock et une caisse, il ressoit une commande d'un barman et est payé par la patronne
 */
public class Fournisseur extends Humain implements Serializable{
    
    private Stock stock;
    
    private Caisse caisse;
    
    
    public Fournisseur(){
    
        super();  
        
        stock = new Stock();
        
        caisse = new Caisse();
    
}
    
    
    public Fournisseur(String pSurnom, String pPrenom, int pPorteMonnaie, String pCri, Stock pStock, Caisse pCaisse){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pCri);
        
        stock = pStock;
        
        caisse = pCaisse;
                
    }
    
    /**
     * Le fournisseur satisfait une commande en livrant un bar, il informe la patronne de ce qu'il n'a pas pu livrer
     * 
     * @param stockDemande stock demandé par le barman
     * @param stockApprovision stock du barman
     * @param pPatronne patronne du barman
     */
    
    public void commande(Stock stockDemande, Stock stockApprovision, Patronne pPatronne){
               
        Stock nonDispo = new Stock();
        
        Stock correspondantDispo = new Stock();
        
        int facture = 0;
        
        for (int i = 0; i < stockDemande.getStock().size(); i++){
            
            boolean done = false;
            
            facture = facture + stockDemande.getStock().get(i).getNombre() * stockDemande.getStock().get(i).getBoisson().getPrixAchat();
            
            for (int j  = 0; j < stock.getStock().size(); j++){
                
                if (stockDemande.getStock().get(i).getBoisson().equals(stock.getStock().get(j).getBoisson())){
                    
                    correspondantDispo.getStock().add(stock.getStock().get(j).clone());    
                    
                    done = true;
                                        
                }                
                
            }    
            
            if (!done){
                
                StockBoisson zero = new StockBoisson(stockDemande.getStock().get(i).getBoisson(), 0);
                
                correspondantDispo.getStock().add(zero);
                
            }
            
        }
                
        for (int i = 0; i < stockDemande.getStock().size(); i++){
            
            
            
            boolean done = false;
            
            for (int j = 0; j < stockApprovision.getStock().size(); j++){              
                
                
                if (stockDemande.getStock().get(i).getBoisson().equals(stockApprovision.getStock().get(j).getBoisson())){
                    
                    int diff = correspondantDispo.getStock().get(i).getNombre() - stockDemande.getStock().get(i).getNombre();
                    
                                        
                    if (diff >= 0){                  
                        
                        stockApprovision.getStock().get(j).setNombre(stockApprovision.getStock().get(j).getNombre() + stockDemande.getStock().get(i).getNombre());
                        
                        correspondantDispo.getStock().get(i).setNombre(diff);
                        
                       
                    }
                    
                    else{
                        
                        StockBoisson stockBoissonNonDispo = new StockBoisson();
                        
                        stockBoissonNonDispo.setBoisson(correspondantDispo.getStock().get(i).getBoisson());
                        
                        if (correspondantDispo.getStock().get(i).getNombre() == 0){
                            
                            stockBoissonNonDispo.setNombre(stockDemande.getStock().get(i).getNombre());
                            
                        }
                        
                        else{
                        
                        stockApprovision.getStock().get(j).setNombre(stockApprovision.getStock().get(j).getNombre() + stock.getStock().get(i).getNombre());
                        
                        correspondantDispo.getStock().get(i).setNombre(0); 
                        
                        stockBoissonNonDispo.setNombre(- diff);
                                                
                        }
                        
                        nonDispo.getStock().add(stockBoissonNonDispo);
                        
                    }
                            
                    done = true;
                    
                }
                
            }
                
                
                if (!done){
                    
                    int diff = correspondantDispo.getStock().get(i).getNombre() - stockDemande.getStock().get(i).getNombre();
                    
                    StockBoisson newBoisson = new StockBoisson();
                    
                    newBoisson.setBoisson(correspondantDispo.getStock().get(i).getBoisson());
                    
                    if (diff >= 0){                  
                        
                        newBoisson.setNombre(stockDemande.getStock().get(i).getNombre());
                        
                        correspondantDispo.getStock().get(i).setNombre(diff);
                        
                    }
                    
                    else{
                        
                        StockBoisson stockBoissonNonDispo = new StockBoisson();
                        
                        stockBoissonNonDispo.setBoisson(correspondantDispo.getStock().get(i).getBoisson());
                        
                        if (correspondantDispo.getStock().get(i).getNombre() == 0){
                            
                            stockBoissonNonDispo.setNombre(stockDemande.getStock().get(i).getNombre());
                            
                        }
                        
                        else{
                        
                        newBoisson.setNombre(stockDemande.getStock().get(i).getNombre() - diff);;
                        
                        correspondantDispo.getStock().get(i).setNombre(0);                                 
                                                
                        }
                        
                        nonDispo.getStock().add(stockBoissonNonDispo);
                        
                    }
                    
                    stockApprovision.getStock().add(newBoisson);
                    
                }
                
            
            
           
            
        }
        

                
        for (int i = 0; i < stock.getStock().size(); i++){
            
            for (int j  = 0; j < correspondantDispo.getStock().size(); j++){
                
                if (stock.getStock().get(i).getBoisson().equals(correspondantDispo.getStock().get(j).getBoisson())){
                    
                    stock.getStock().get(i).setNombre(correspondantDispo.getStock().get(j).getNombre());
                    
                }                
                
            }            
            
        }       
        
        int rabais = 0;
        
        for (int i = 0; i < nonDispo.getStock().size(); i++){
            
            rabais = rabais + nonDispo.getStock().get(i).getNombre() * nonDispo.getStock().get(i).getBoisson().getPrixAchat();
            
        }
        
        facture = facture - rabais;
        
        if (nonDispo.getStock().size() != 0){
        
            this.parler("Je n'avait pas " + nonDispo + " en stock");
        
        }
        
        else{
            
            this.parler("J'ai bien apporté tous ce que " + pPatronne.getBar().getBarman().getPrenom() + " m'avais demandé !");
        }
        
        this.parler("Donc ça fait " + facture + " € s'il te plait !");
        
        pPatronne.receptionFournisseur(nonDispo, caisse, facture);
                
    }    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////***********Fonctions de Base*************//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public Stock getStock(){
        
        return stock;
        
    }
    
    public void setStock(Stock pStock){
        
        stock = pStock;
        
    }
    
    public Caisse getCaisse(){
        
        return caisse;
        
    }
    
    public void setCaisse(Caisse pCaisse){
        
        caisse = pCaisse;
        
    }
    
    @Override
    public Fournisseur clone(){        
        
        return new Fournisseur(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getCri(), stock, caisse);        
        
    }
    
    public boolean equals(Fournisseur pFournisseur){
        
        return (super.equals(pFournisseur) && this.stock.equals(pFournisseur.getStock()));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
