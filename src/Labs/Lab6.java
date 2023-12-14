//-----------------------
//LAB#6 Message Digest (LAB WORK)
//Student Name: Elaf Yousef Aloufi
//ID: 1911265
//Section: BAR
//------------------------
package Labs;

import java.security.*;
import java.io.*;

public class Lab6 {

    public static void main(String args[]) throws Exception {

        MessageDigest sh = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int i;

        String str = "Java security technology includes a large set of APIs, tools, and implementations of "
                + "commonly used security algorithms, mechanisms, and protocols. The Java security APIs span a wide range of areas,"
                + "	including cryptography, public key infrastructure, secure communication, authentication, and access control. "
                + "	Java security technology provides the developer with a comprehensive security framework for writing applications,"
                + "and also provides the user or administrator with a set of tools to securely manage applications. ";

        String str2 = "Java security technology includes a large set of APIs, tools, and implementations of "
                + "commonly used security algorithms, mechanisms, and protocols. The Java security APIs span a wide range of areas,"
                + "	including cryptography, public key infrastructure, secure communication, authentication, and access control. ";

        byte[] data1 = str.getBytes("UTF8");
        sh.update(data1);
        byte[] msgDigest_sh = sh.digest();

        // TO DO...
        byte[] data2 = str2.getBytes("UTF8");
        sh.update(data2);
        byte[] msgDigest_sh2 = sh.digest();

        //--------------------------------------------------Using SHA-1-------------------------------------------------
        System.out.println("--- The First Message Digest Using SHA-1---");
        System.out.println(new String(msgDigest_sh));
        StringBuffer hexString1 = new StringBuffer();
        for (i = 0; i < msgDigest_sh.length; i++) {
             System.out.print(msgDigest_sh[i] + " ");
             hexString1.append(Integer.toHexString(0xFF & msgDigest_sh[i]));
            
        }
        System.out.println("\nHex format : " + hexString1.toString());
        System.out.println("The output size is  : " + i + "   ");

        System.out.print("\n");

        System.out.println("--- The Second Message Digest Using SHA-1---");
        System.out.println(new String(msgDigest_sh2));
        StringBuffer hexString2 = new StringBuffer();
        for (i = 0; i < msgDigest_sh2.length; i++) {
             System.out.print(msgDigest_sh2[i] + " ");
             hexString2.append(Integer.toHexString(0xFF & msgDigest_sh2[i]));
        }
        System.out.println("\nHex format : " + hexString2.toString());
        System.out.println("The output size is  : " + i + "   ");
        System.out.print("\n");
        // TO DO...

        //--------------------------------------------------Using MD5-------------------------------------------------
        // TO DO...
        byte[] data3 = str.getBytes("UTF8");
        md5.update(data3);
        byte[] msgDigest_md = md5.digest();

        byte[] data4 = str2.getBytes("UTF8");
        md5.update(data4);
        byte[] msgDigest_md2 = md5.digest();

        System.out.println("--- The First Message Digest Using MD5---");
        System.out.println(new String(msgDigest_md));
        StringBuffer hexString3 = new StringBuffer();
        for (i = 0; i < msgDigest_md.length; i++) {
             System.out.print(msgDigest_md[i] + " ");
             hexString3.append(Integer.toHexString(0xFF & msgDigest_md[i]));
        }
        System.out.println("\nHex format : " + hexString3.toString());
        System.out.println("The output size is  : " + i + "   ");
        System.out.print("\n");

        System.out.println("--- The Second Message Digest Using MD5---");
        System.out.println(new String(msgDigest_md2));
        StringBuffer hexString4 = new StringBuffer();
        for (i = 0; i < msgDigest_md2.length; i++) {
             System.out.print(msgDigest_md2[i] + " ");
             hexString4.append(Integer.toHexString(0xFF & msgDigest_md2[i]));
        }
        System.out.println("\nHex format : " + hexString4.toString());
        System.out.println("The output size is  : " + i + "   ");
        System.out.print("\n");

    }
}
