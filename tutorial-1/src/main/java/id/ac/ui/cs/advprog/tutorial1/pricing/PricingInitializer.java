package id.ac.ui.cs.advprog.tutorial1.pricing;

import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@Component
public class PricingInitializer {

    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @PostConstruct
    public void init() {

        Kurir kadal = new KadalKurir(10);
        Kurir kuda = new KudaKurir(50);
        Kurir garuda = new GarudaKurir(100);

        Asuransi alpha = new AlphaAsuransi(1000);
        Asuransi beta = new BetaAsuransi(200);
        Asuransi sigma = new SigmaAsuransi(5000);



        //create next courier and insurance, designed with COR design pattern
        kadal.setNextKurir(kuda);
        kuda.setNextKurir(garuda);
        garuda.setNextKurir(null); // used when adding another courier

        beta.setNextAsuransi(alpha);
        alpha.setNextAsuransi(sigma);
        sigma.setNextAsuransi(null); // used when adding another insurance



        kurirRepository.addKurir("Kadal", kadal);
        kurirRepository.addKurir("Kuda", kuda);
        kurirRepository.addKurir("Garuda", garuda);




        asuransiRepository.addAsuransi("Alpha",alpha);
        asuransiRepository.addAsuransi("Beta",beta);
        asuransiRepository.addAsuransi("Sigma", sigma);



    }
}
