package com.shop.product.service.impl;

import com.shop.product.model.Carts;
import com.shop.product.service.CartService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
@Component
public class CartServiceimpl implements CartService {
    private Map<Long, Carts> map= new HashMap<Long,Carts>();
//    public List<Carts> getAllCarts(){
//        return c.findAll();
//    }//findAll

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
    public void update(Long id, Integer SL){
        Carts item=map.get(id);
        item.setSL(SL+ item.getSL());
        if(item.getSL()<=0){
            map.remove(id);
        }
    }

}
