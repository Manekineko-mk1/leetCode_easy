package com.leetcode.easy;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxCityFinder {
    HashMap <String, Integer> cities = new HashMap<String, Integer>();
    String maxCity;
    Integer maxCityCount = 0;

    public void findMaxCity () throws Exception {
      FileInputStream inputStream = null;
      Scanner sc = null;
      
      try {
        inputStream = new FileInputStream("../resource/cities.txt");
        sc = new Scanner(inputStream, "UTF-8");
        String cityName, currentLine;
         
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
			String[] columns = currentLine.split("\\t");
				
			cityName = columns[1];

            if(cities.containsKey(cityName)) {
                cities.put(cityName, cities.get(cityName) + 1);
            } else {
                cities.put(cityName, 1);
            }
        }
      } catch(Exception e) {
        e.printStackTrace();
      }

      //get max city
      for(Map.Entry<String, Integer> entry : cities.entrySet()) {
        // if 2 cities has equal value there could be problem  
        if(entry.getValue() > maxCityCount) {
              maxCityCount = entry.getValue();
              maxCity = entry.getKey();
          }          
      }
   }

   public String getMaxCity() {
       return maxCity;
   }
}
