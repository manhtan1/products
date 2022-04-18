package com.shop.product.service.impl;

import com.shop.product.model.Carts;
import com.shop.product.service.CartService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.math.BigDecimal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
@Component
public class CartServiceimpl implements CartService {

    Map<Long,Carts> map = new HashMap<Long, Carts>();
    @Override
    public void addproduct(Carts item){
        Carts existedItem =map.get(item.getId());
        if(existedItem!=null){
            existedItem.setSL(item.getSL()+existedItem.getSL());
        }
        else{
            map.put(item.getId(), item);
        }
    }
    @Override
    public Collection<Carts> getCarts(){
        return map.values();
    }
    @Override
    public void clear(){
        map.clear();
    }
    @Override
    public void updateGioHang(Long id,Long SL){
        Carts item=map.get(id);
        item.setSL(SL);
        if(item.getSL()<=0){
            map.remove(id);
        }
    }
    @Override
    public void remove(Long id){
        map.remove(id);
    }

}
