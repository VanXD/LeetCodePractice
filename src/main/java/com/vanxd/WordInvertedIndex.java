package com.vanxd;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * File A : the quick brown fox .
 * File B : the slow blue fox.
 */
public class WordInvertedIndex {
    public static void main(String[] args) {
        String a = "File A : the quick brown fox.";
        String b = "File B : the slow blue fox.";
        String[] aArray = a.split(":");
        String[] bArray = b.split(":");
        String aName = aArray[0].split(" ")[1];
        String bName = bArray[0].split(" ")[1];
        String[] aData = aArray[1].split(" ");
        String[] bData = bArray[1].split(" ");
        Map<String, String> result = new TreeMap<String, String>();
        for( String tmp : aData ) {
            result.put(tmp, aName);
        }
        for( String tmp : bData ) {
            if ( null != result.get(tmp) ) {
                result.put(tmp, result.get(tmp) + " " + bName);
            } else {
                result.put(tmp, bName);
            }
        }
        result.remove("");
        Set<Map.Entry<String, String>> entries = result.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
