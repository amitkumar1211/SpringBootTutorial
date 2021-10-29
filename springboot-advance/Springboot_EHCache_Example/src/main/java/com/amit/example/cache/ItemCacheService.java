package com.amit.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.amit.example.model.Item;
import com.amit.example.repo.ItemRepository;

@Component
public class ItemCacheService {

    @Autowired
    ItemRepository itemRepo;

    @Cacheable(value="itemCache", key="#id")
    public Item getItem(int id) throws Exception{
        System.out.println("Item cached..");
        return itemRepo.getItem(id);
    }

    @CacheEvict(value="itemCache", key = "#id")
    public int deleteItem(int id){
        System.out.println("Item deleted in cache.");
        return itemRepo.deleteItem(id);
    }

    @CachePut(value="itemCache", key = "#id")
    public void updateItem(int id, Item item){
        System.out.println("Item updated from cache.");
        itemRepo.updateItem(id, item);
    }
}
