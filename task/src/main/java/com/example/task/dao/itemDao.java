package com.example.task.dao;

import com.example.task.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class itemDao {
    private static final List<Item> itemlist = new ArrayList<>();

    public void addItem(Item item){
        itemlist.add(item);
    }
    public Item getItem(String id){
        for(Item i : itemlist){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public List<Item> getAllItem(){
        return itemlist;
    }
}



