/*
 * Name: Elaf Yousef Aloufi 
 * ID: 1911265
 * Section: BAR
 * Lab Activity #2
 */

package Labs;
import javax.swing.JOptionPane;

public class Lab2 {

    static public int key;
    // define an array of the alphabetical order (OR) define  string of the alphabetical order, and 
    //then fill it with the letters (A to Z)
    static public String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // The class constructor. It receives the secret key as parameter
    public Lab2(String s) {
        key = Integer.parseInt(s.trim()); // convert the key from string to integer
    }

    public String encrypt(String plaintext) {

        // define the ciphertext as empty string i.e. = ""
        String ciphertext = "";

        int value;
        plaintext = plaintext.toUpperCase();

        // do a for loop to go through the "plaintext" variable char by char,  
        for (int i = 0; i < plaintext.length(); i++) {

            // and then calculate the index of the ciphertext letter using the Caesar algorithm, then add the 
            // letter of the calculated index to the ciphertext string
            if (plaintext.charAt(i) == ' ') {
                ciphertext += ' ';
            } else {
                value = (alph.indexOf(plaintext.charAt(i)) + key) % 26;
                ciphertext += alph.charAt(value);
            }

        }

        // return the ciphertext
        return ciphertext;
    }

    //------------------------------------------------------
    public String decrypt(String ciphertext) {

        // define the plaintext as empty string i.e. = ""
        String plaintext = "";

        int value;
        ciphertext = ciphertext.toUpperCase();

        // do a for loop to go through the "ciphertext" variable char by char,  
        for (int i = 0; i < ciphertext.length(); i++) {

            // and then calculate the index of the plaintext letter using the Caesar algorithm, then add the 
            // letter of the calculated index to the plaintext string
            value = (alph.indexOf(ciphertext.charAt(i)) - key) % 26;
            if (value < 0) {
                value = alph.length() + value;
            }
            if (ciphertext.charAt(i) == ' ') {
                plaintext += ' ';
            } else {
                plaintext += alph.charAt(value);
            }
            
        }

        // return the plaintext
        return plaintext.toLowerCase();
    }

    public static void main(String[] args) {
        String plaintext = JOptionPane.showInputDialog("Input your message: "); // to input the plaintext
        String sk = JOptionPane.showInputDialog("Input the key (a number [0-25]): "); // to input the key

        // error message 
        while (Integer.parseInt(sk.trim()) < 0 || Integer.parseInt(sk.trim()) > 25) {
            sk = JOptionPane.showInputDialog("Please retry input the key (a number [0-25]): ");
        }

        Lab2 cipher = new Lab2(sk); // Create a Caesar cipher object
        String ciphertext = cipher.encrypt(plaintext); // get the encrypted text (ciphertext)
        System.out.println(ciphertext);
        plaintext = cipher.decrypt(ciphertext); // get the decrypted text (should be plaintext again)
        System.out.println(plaintext);
        JOptionPane.showMessageDialog(null,
                "encrypted text: " + ciphertext + "\n"
                + "decrypted text: " + plaintext);
    }
}
