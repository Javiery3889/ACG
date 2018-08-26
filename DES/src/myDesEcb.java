/***************************************************************
 *
 * A Program on DES, using ECB mode
 *
 * Written by Samson Yeow
 *
 * Singapore Polytechnic
 *
 * (c) Mar 2007. Singapore Polytechnic
 *
 ***************************************************************/


import java.security.*;
import javax.crypto.*;

public class myDesEcb
{
    public static void main (String[] args) throws Exception
    {

        String text = "Hello123Hello123Hello123";

        System.out.println("Original Text=" + text + "\n");
        System.out.println("Generating a 56-bit DES key...");

        // Create a 56-bit DES key
        KeyGenerator kg = KeyGenerator.getInstance("DES");

        // need to initialize with the keysize
        kg.init(56);
        Key mykey = kg.generateKey();

        System.out.println("The key is generated.");

        // Create a cipher object and use the generated key to initialize it
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, mykey);

        byte[] plaintext = text.getBytes("UTF8");

        // Print out the bytes of the plaintext
        System.out.println("\nPlaintext: ");
        for (int i=0;i<plaintext.length;i++) {
            if (i % 8 == 0){
                System.out.println("\n");
            }
            System.out.print(plaintext[i]+" ");
        }

        // Now encrypt the text
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Print the ciphertext
        System.out.println("\n\nCiphertext: ");
        for (int i=0;i<ciphertext.length;i++) {
            if (i % 8 == 0){
                System.out.println("\n");
            }
            System.out.print(ciphertext[i]+" ");

        }

        System.out.println("\n\nCiphertext (Hex): ");
        System.out.println(asHex(ciphertext));

        /************************************************
         *
         * Can you decrypt the message?
         *
         ************************************************/
        // Change to decrypt mod+e
        cipher.init(Cipher.DECRYPT_MODE,mykey);

        // Now decrypt the text

        byte[] decryptedText = cipher.doFinal(ciphertext);

//       done by tdy lec String plain = new String(decryptedText,"UTF-8");
        // Print the message
//        System.out.println("\nPlaintext=" + plain);

//        own method
        System.out.print("\nPlaintext=");
        for(int i = 0; i < decryptedText.length; i++){
            System.out.print((char)decryptedText[i]);
        }

    }


    public static String asHex (byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");

            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }

        return strbuf.toString();
    }




}