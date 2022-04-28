package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemFactory;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CreateCodeServiceImpl implements CreateCodeService {

    @Autowired
    RedeemCodeRepository repositoryRedeem;

    @Autowired
    ItemRepository repositoryItem;

    @Override
    public RedeemCode createCode(String itemType, String codeType, String code, String itemName, Map<String, String> data) {
        RedeemFactory redeemFactory = new RedeemFactory();
        RedeemCode r = redeemFactory.createCode( itemType,  codeType,  code,  itemName,  data);




        repositoryRedeem.save(r);
        repositoryItem.save(redeemFactory.getItem());


        return r;
    }
}
