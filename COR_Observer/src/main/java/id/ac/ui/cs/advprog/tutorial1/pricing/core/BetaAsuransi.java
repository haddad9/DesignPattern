package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class BetaAsuransi implements Asuransi {
    private int price;
    private Asuransi nextAsuransi;

    public BetaAsuransi(int price) {
        // TODO
        this.price = price;
    }

    @Override
    public String getName() {
        // TODO
        return "Beta";
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String handlerName(int value) {
        String name="";
        if(value < 1000){
            name = this.getName();

        }
        else{
            name = passToNextName(value);
        }
        return name;
    }

    @Override
    public String passToNextName(int value) {
        return this.nextAsuransi.handlerName(value);
    }
    @Override
    public void setNextAsuransi(Asuransi a) {
        this.nextAsuransi = a;
    }


}
