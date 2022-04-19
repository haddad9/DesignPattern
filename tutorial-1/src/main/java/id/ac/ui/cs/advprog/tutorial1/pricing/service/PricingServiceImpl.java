package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Service
public class PricingServiceImpl implements PricingService {
    
    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @Override
    public List<String> calculatePrice(int weight, int value) {
        // TODO

        String kurirName = kurirRepository.firstHandler("Kadal").handlerName(weight);


        Kurir kurir = kurirRepository.findByName(kurirName);
        int totalPriceKurir = kurir.calculatePrice(weight);
        int kurirPrice = kurir.getPricePerKilogram();

        String asuransiName = asuransiRepository.findByName("Beta").handlerName(value);
        Asuransi asuransi = asuransiRepository.findByName(asuransiName);
        int totalAsuransiPrice = asuransi.getPrice();


        List<String> ret = new ArrayList<>();

        ret.add("Menggunakan Kurir " +  kurirName);
        ret.add("Harga jasa kurir:"+ weight+ " x " +kurirPrice+" ="+ totalPriceKurir+" civil credits");
        ret.add("Menggunakan Asuransi "+ asuransiName );
        ret.add("Harga jasa asuransi:" + totalAsuransiPrice +" civil credits");
        ret.add("total harga: " +totalPriceKurir+ " + " + totalAsuransiPrice + " = "+ (totalAsuransiPrice+totalPriceKurir)  + " civil credits");





        return ret;
    }

}
