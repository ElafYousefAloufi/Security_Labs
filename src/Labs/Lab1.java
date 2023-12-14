/*
 * Name: Elaf Yousef Aloufi 
 * ID: 1911265
 * Section: BAR
 * Lab Activity #01
 */
package Labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
      try {

            BufferedReader b = new BufferedReader(new FileReader("input.txt"));
            
            BufferedWriter w = new BufferedWriter(new FileWriter("Write.txt"));
    int i, length, counter[] = new int[10000];
            String str = "";
            while ((str= b.readLine()) != null) {
              

            w.write("The String is: " + str);
             w.newLine();
            str = str.replace(" ", "");
            length = str.length();

            for (i = 0; i < length; i++) {
                counter[(int) str.charAt(i)]++;
            }

            
            }
for (i = 0; i < 10000; i++) {
                if (counter[i] != 0) {
                    w.write((char) i + " = " + counter[i]);
                    w.newLine();
                }
            } 
           
            b.close();
            w.close();
            
        } catch (Exception x) {
            System.out.println(x.toString());
        }}

}
