package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import id.ac.ui.cs.advprog.tutorial4.core.util.RedeemCodeUtil;

import java.util.Map;

public  class RedeemFactory {
   RedeemCode r;
   Item i;


    public RedeemCode createCode(String itemType, String codeType, String code, String itemName, Map<String, String> data) {

        //TODO
        if( !(data.get("amount") == null)){

            if(itemType.equals("MEMBERSHIP")){
                i = new MembershipItem(itemName);
                r = new GiveawayMembership(code.equals("") ? RedeemCodeUtil.generateCode():code, i, Integer.parseInt(data.get("amount")));
            }
            else{
                i = new MerchItem(itemName);
                r = new GiveawayMerch(code.equals("") ? RedeemCodeUtil.generateCode():code, i, Integer.parseInt(data.get("amount")));
            }



        }
        else{

            if(itemType.equals("MEMBERSHIP")){
                i = new MembershipItem(itemName);
                r = new PromoMembership(code.equals("") ? RedeemCodeUtil.generateCode():code,i , Double.parseDouble(data.get("discount")));
            }
            else{
                i = new MerchItem(itemName);
                r = new PromoMerch(code.equals("") ? RedeemCodeUtil.generateCode():code,i , Double.parseDouble(data.get("discount")));
            }

        }


        return r;
    }

    public Item getItem() {
        return this.i;
    }
}
