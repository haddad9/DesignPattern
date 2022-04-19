package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class SigmaAsuransi implements Asuransi {
    private int price;
    private Asuransi nextAsuransi;
    public SigmaAsuransi(int price) {
        // TODO
        this.price=price;
    }

    @Override
    public String getName() {
        // TODO
        return "Sigma";
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String handlerName(int value) {
       return  this.getName();
    }

    @Override
    //this method would be useful for adding another insurance
    public String passToNextName(int value) {
        return null;
    }
    @Override
    public void setNextAsuransi(Asuransi a) {
        this.nextAsuransi = a;
    }

}
