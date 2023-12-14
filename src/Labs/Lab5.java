/*
 * Name: Elaf Yousef Aloufi 
 * ID: 1911265
 * Section: BAR
 * Lab Activity #5
 */

package Labs;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Lab5 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair pair = generator.generateKeyPair();
        Cipher cipher = Cipher.getInstance("RSA");

        PrivateKey privateKey = pair.getPrivate();
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        PublicKey publicKey = pair.getPublic();
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //-----------------------------------------------------------------------------------------------------
        
        //String we want to encrypt
        String message = "Java programming language support the RSA and DES algorithms.";

        //convert string to byte array using getBytes() method
        byte[] utf8 = message.getBytes();

        //Generate the Key for DES algorithm (two lines)
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("RSA");//******
//        SecretKey key = keyGenerator.generateKey();
        //Create the Cipher object with DES algorithm
        Cipher c = Cipher.getInstance("RSA");//******

        //initialize the cipherobject, set mode to encrypt and pass the key.
        c.init(Cipher.ENCRYPT_MODE, publicKey);

        //encrypt the message using doFinal
        byte[] myEncryptedBytes = c.doFinal(utf8);

        // to convert the byte array to a readable string use the encoding scheme "base64" 
        //Ex. String encryptedText =Base64.getEncoder().encodeToString(myEncryptedBytes);
        String encryptedText = Base64.getEncoder().encodeToString(myEncryptedBytes);

        //to decrypt initialize the same cipher object, set mode to decrypt and pass the key.
        c.init(Cipher.DECRYPT_MODE, privateKey);
        // decrypt using doFinal
        byte[] myDecryptedBytes = c.doFinal(myEncryptedBytes);

        // convert byte array to string for printing 
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted Message: " + decrypteddata);
    }
}
