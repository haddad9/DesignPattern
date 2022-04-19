package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public interface Kurir {
    
    String getName();
    int calculatePrice(int weight);
    void setNextKurir(Kurir k);
    int passToNext(int weight);
    String handlerName(int weight);
    String passToNextName(int weight);
    int getPricePerKilogram();

}
