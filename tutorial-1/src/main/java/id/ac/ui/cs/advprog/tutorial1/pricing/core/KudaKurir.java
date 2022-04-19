package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KudaKurir implements Kurir {
    private int pricePerKilogram;
    private Kurir nextKurir;

    public KudaKurir(int pricePerKilogram) {
        // TODO
        this.pricePerKilogram=pricePerKilogram;
    }

    public String getName() {
        // TODO
        return "Kuda";
    }

    public int calculatePrice(int weight) {
        // TODO
        int ret = 0;
        if(weight <= 50 ){
            ret = this.pricePerKilogram *weight;

        }
        else{
            ret = this.passToNext(weight);
        }
        return ret;
    }

    public void setNextKurir(Kurir k){
        this.nextKurir=k;
    }

    @Override
    public int passToNext(int weight) {
        int ret = 0;
        ret = this.nextKurir.calculatePrice(weight);
        return ret;
    }

    @Override
    public String handlerName(int weight) {
        String name = "";
        if(weight <=50 ){
            name = this.getName();
        }
        else{
            name = passToNextName(weight);
        }
        return name;
    }

    @Override
    public String passToNextName(int weight) {
        return this.nextKurir.handlerName(weight);
    }

    @Override
    public int getPricePerKilogram() {
        return this.pricePerKilogram;
    }
}
