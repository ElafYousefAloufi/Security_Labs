/*
 * Name: Elaf Yousef Aloufi 
 * ID: 1911265
 * Section: BAR
 * Lab Activity #4
 */
package Labs;

import java.io.*;
import java.util.*;
import javax.crypto.*;
import java.security.*;
import java.awt.RenderingHints.Key;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class des {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        //String we want to encrypt
        String message = "This is a confidential message.";

        //convert string to byte array using getBytes() method
        byte[] bArray = message.getBytes();

        //Generate the Key for DES algorithm (two lines)
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    
        SecretKey key= keyGenerator.generateKey();
        //Create the Cipher object with DES algorithm
        Cipher c = Cipher.getInstance("DES");

        //initialize the cipherobject, set mode to encrypt and pass the key.
        c.init(Cipher.ENCRYPT_MODE, key);

        //encrypt the message using doFinal
        byte[] myEncryptedBytes = c.doFinal(bArray);

        // to convert the byte array to a readable string use the encoding scheme "base64" 
        //Ex. String encryptedText =Base64.getEncoder().encodeToString(myEncryptedBytes);
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        //to decrypt initialize the same cipher object, set mode to decrypt and pass the key.
        c.init(Cipher.DECRYPT_MODE, key);
        // decrypt using doFinal
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);

        // convert byte array to string for printing 
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("Message : " + message);
        System.out.println("Encrypted - " + encryptedText);
        System.out.println("Decrypted Message - " + decrypteddata);
    }
}
