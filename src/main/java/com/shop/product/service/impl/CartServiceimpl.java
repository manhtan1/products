package com.shop.product.service.impl;

import com.shop.product.model.Carts;
import com.shop.product.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceimpl implements CartService {

    private Map<Integer,Carts> map = new HashMap<Integer, Carts>();
    @Override
    public void addproduct(Carts item){
        Carts existedItem =map.get(item.getId());
        if(existedItem!=null){
            existedItem.setSL(item.getSL()+existedItem.getSL());
        }
        else{
            map.put(Math.toIntExact(item.getId()), item);
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
        item.setSL(SL);
        item.setTotal(item.getDON_GIA()* item.getSL());
        if(item.getSL()<=0){
            map.remove(id);
        }
    }
    @Override
    public void remove(Long id){
        map.remove(id);
    }

}
