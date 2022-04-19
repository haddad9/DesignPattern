package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class GarudaKurir implements Kurir {
    private int pricePerKilogram;
    private Kurir nextKurir;
    public GarudaKurir(int pricePerKilogram) {
        // TODO
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        // TODO
        return "Garuda";
    }

    public int calculatePrice(int weight) {
        // TODO
        return this.pricePerKilogram*weight + 2000;
    }
    public void setNextKurir(Kurir k){
        this.nextKurir=k;
    }

    @Override
    //this method will be useful if there are another courier to add
    public int passToNext(int weight) {
        return 0;
    }

    @Override
    public String handlerName(int weight) {
        return this.getName();
    }

    @Override
    public String passToNextName(int weight) {
        //this method would be useful if there are another courier to add
        return null;
    }

    @Override
    public int getPricePerKilogram() {
        return this.pricePerKilogram;
    }
}
