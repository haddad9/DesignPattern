package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.springframework.beans.factory.annotation.Autowired;

public interface Asuransi {
    String getName();
    int getPrice();
    String handlerName(int value);
    String passToNextName(int value);
    void setNextAsuransi(Asuransi a);


}
