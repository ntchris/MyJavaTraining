package myjavatraining;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpHelper {

   /*
    * 
   
    */
   void open(URL url) {
      try {
         URL url_DellU3415W = new URL(
               "http://accessories.dell.com/sna/products/Gaming_Accessories/productdetail.aspx?c=ca&l=en&s=dhs&cs=cadhs1&sku=210-ADTR");
         URLConnection myURLConnection = url_DellU3415W.openConnection();

         myURLConnection.connect();
      } catch (

      MalformedURLException ex)

      { // new

         // failed
         // ...
      } catch (

      IOException e)

      { // openConnection() failed
        // ...
      }
   }
   

   
}
