package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KadalKurir implements Kurir {
    private int pricePerKilogram;
    private Kurir nextKurir;

    public KadalKurir(int pricePerKilogram) {
        // TODO
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        // TODO
        return "Kadal";
    }

    public int calculatePrice(int weight) {
        // TODO
        int ret = 0;
        //handle if weight below 10
        if (weight<10 ){
            ret = this.pricePerKilogram* weight;
        }
        else{
            ret = this.passToNext(weight);
        }
        return ret;
    }


   public void setNextKurir(Kurir k){
        this.nextKurir=k;
   }


    public int passToNext(int weight) {
        int ret = 0;
        ret = this.nextKurir.calculatePrice(weight);
        return ret;
    }

    @Override
    public String handlerName(int weight) {
        String ret = "";
        //handle if weight below 10
        if (weight<10 ){
            ret = this.getName();
        }
        else{
            ret = this.passToNextName(weight);
        }
        return ret;
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
