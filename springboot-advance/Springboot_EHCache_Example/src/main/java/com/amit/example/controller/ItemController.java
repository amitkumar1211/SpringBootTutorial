package com.amit.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amit.example.cache.ItemCacheService;
import com.amit.example.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemCacheService itemCache;
    @GetMapping("/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId) throws Exception{
        System.out.println("Rest Controller....");
        Item item = itemCache.getItem(itemId);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item){
        if(item != null){
            itemCache.updateItem(id, item);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        itemCache.deleteItem(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
