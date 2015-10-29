package myjavatraining;

import java.util.HashMap;

/**
 * 
 * 
 * @author ntchris@hotmail.com
 * 
 *         Chris
 * 
 *         28 Oct 2015
 *
 */

public class MapTesting {

   static public void testMapAdd() {

      HashMap<String, String> mHashMap;

      mHashMap = new HashMap<String, String>();
      String key = "AAAKey";
      mHashMap.put(key, "AAAValue");
      String val = mHashMap.get(key);
      System.out.println("Value is " + val);
      // <String, String>;

   }

}
