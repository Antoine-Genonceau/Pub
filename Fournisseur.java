/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub;

/**
 *
 * @author Toine
 */
public class Fournisseur extends Humain{
    
    private Stock stock;
    
    private Caisse caisse;
    
    
    public Fournisseur(){
    
        super();  
        
        stock = new Stock();
        
        caisse = new Caisse();
    
}
    
    
    public Fournisseur(String pSurnom, String pPrenom, int pPorteMonnaie, int pPopularite, String pCri, Stock pStock, Caisse pCaisse){
        
        super(pSurnom, pPrenom, pPorteMonnaie, pPopularite, pCri);
        
        stock = pStock;
        
        caisse = pCaisse;
                
    }
    
    public void commande(Stock stockDemande, Stock stockApprovision, Patronne pPatronne){
        
        Stock nonDispo = new Stock();
        
        Stock correspondantDispo = new Stock();
        
        int facture = 0;
        
        for (int i = 0; i < stockDemande.getStock().size(); i++){
            
            facture = facture + stockDemande.getStock().get(i).getNombre() * stockDemande.getStock().get(i).getBoisson().getPrixAchat();
            
            for (int j  = 0; j < stock.getStock().size(); j++){
                
                if (stockDemande.getStock().get(i).getBoisson().equals(stock.getStock().get(j).getBoisson())){
                    
                    correspondantDispo.getStock().add(stock.getStock().get(j).clone());                   
                                        
                }                
                
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
                        
                        stockApprovision.getStock().get(j).setNombre(stockApprovision.getStock().get(j).getNombre() + stockDemande.getStock().get(i).getNombre() - diff);
                        
                        correspondantDispo.getStock().get(i).setNombre(0);                                 
                                                
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
        
        pPatronne.receptionFournisseur(nonDispo, caisse, facture);
                
    }    
    
    
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
        
        return new Fournisseur(super.getSurnom(), super.getPrenom(), super.getPorteMonnaie(), super.getPopularite(), super.getCri(), stock, caisse);        
        
    }
    
    public boolean equals(Fournisseur pFournisseur){
        
        return (super.equals(pFournisseur) && this.stock.equals(pFournisseur.getStock()));
        
    }
    
    @Override
    public String toString(){
        
        return super.toString();
        
    }
    
}
