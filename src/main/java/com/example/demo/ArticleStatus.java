package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ArticleStatus {
   
    private Map<Map<String,String>, Map<String,List<Article>>> map = new HashMap<>();
    Map<String, String> innerMapKey = new HashMap<>();
    Map<String, List<Article>> innerMapValue = new HashMap<>();
    
    
    public Map<Map<String,String>, Map<String,List<Article>>> respons(List<Article> list) {
    	if(! list.isEmpty()) {
    		innerMapKey.put("status", "True");
        	innerMapValue.put("Message", list);
        	map.put(innerMapKey, innerMapValue);
    		
    	}
        try {
            if (list.isEmpty()) {
                // Handle empty list scenario
            	
            } 
        } catch (Exception e) {
        	innerMapKey.put("status", "false");
            List<Article> errorList = new ArrayList<>();
            errorList.add(new Article("List is Empty")); // Assuming Article has a constructor that takes a string
            innerMapValue.put("Message", errorList);
            map.put(innerMapKey, innerMapValue);
        }
        
        	
        
        return map;
    }
}
