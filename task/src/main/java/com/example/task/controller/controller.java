package com.example.task.controller;

import com.example.task.dao.itemDao;
import com.example.task.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class controller{
    @Autowired
    private itemDao itemDao;
    //get all item api
    @GetMapping("/all_items")
    public ResponseEntity<Object> getAllItem() {
        List<Item> itemList = itemDao.getAllItem();
        return ResponseEntity.ok().header("OK!").body(itemList);
    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody Item item){
        itemDao.addItem(item);
        return ResponseEntity.ok("Created!");
    }
    //get by itemname
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Object> getItembyId(@PathVariable("id") String id){
        Item item = itemDao.getItem(id);
        return ResponseEntity.ok().body(item);
    }
    //update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateItem(@PathVariable(name = "id") String id, @RequestBody Item updateItem){
        Item item = itemDao.getItem(id);
        item.setName(updateItem.getName());
        item.setPrice(updateItem.getPrice());
        item.setDesc(updateItem.getDesc());
        return ResponseEntity.ok("Updated!");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        Item item= itemDao.getItem(id);
        item.setDeleteFlag("1");
        return ResponseEntity.ok("Deleted");
    }

}

