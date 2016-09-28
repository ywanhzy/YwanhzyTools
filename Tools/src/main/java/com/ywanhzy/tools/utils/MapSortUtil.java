package com.ywanhzy.tools.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortUtil {
  	 /**
     * 使用 Map按key进行排序 
     * @param map 
     * @return 
     */  
    public static Map<String, String> sortMapByKey(Map<String, String> map) {  
        if (map == null || map.isEmpty()) {  
            return null;  
        }  
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());  
        sortMap.putAll(map);  
        return sortMap;  
    } 
    /**
     * 使用 Map按value进行排序 
     * @param map 
     * @return 
     */  
    public static Map<String, String> sortMapByValue(Map<String, String> map) {  
        if (map == null || map.isEmpty()) {  
            return null;  
        }  
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();  
        List<Entry<String, String>> entryList = new ArrayList<Entry<String, String>>(map.entrySet());
        Collections.sort(entryList, new MapValueComparator());  
        Iterator<Entry<String, String>> iter = entryList.iterator();
        Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {  
            tmpEntry = iter.next();  
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());  
        }  
        return sortedMap;  
    }
    //比较器类
    public static class MapKeyComparator implements Comparator<String>{
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }
    //比较器类
    public static class MapValueComparator implements Comparator<Entry<String, String>> {
        public int compare(Entry<String, String> me1, Entry<String, String> me2) {
            return me1.getValue().compareTo(me2.getValue());
        }
    }
}
