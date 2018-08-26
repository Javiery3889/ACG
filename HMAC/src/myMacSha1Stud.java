/***************************************************************
 *
 * A Simple Program on HmacSHA1
 *
 * Written by Samson Yeow
 *
 * Singapore Polytechnic
 *
 * (c) Mar 2007. Singapore Polytechnic
 *
 ***************************************************************/

import java.io.*;
import sun.misc.*;
import java.security.*;
import javax.crypto.*;

public class myMacSha1Stud {

    public static void main(String[] args) throws Exception {

        // Check arguments.
        if (args.length != 1) {
            System.out.println("Usage: myMacSha1Stud filename");
            return;
        }

        // Generate a secret MAC key
        // Insert the KeyGenerator and SecreKey here

        KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = kg.generateKey();

        // Create and initialize a MAC with the key
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);

        // Calculate the digest for the given file.
        String extension = "";

        int i = args[0].lastIndexOf('.');
        if (i > 0) {
            extension = args[0].substring(i+1);
        }

        if (extension.equalsIgnoreCase("txt")) {

            FileInputStream in = new FileInputStream(args[0]);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = in.read(buffer)) != -1)
                mac.update(buffer, 0, length);
            byte[] result = mac.doFinal();
            // Print Header
            System.out.println("A Simple Program on HmacSHA1\n");

            // Print the key
            System.out.println("Key (Hex):\n" + asHex(key.getEncoded()));

            // Print out the resulting MAC
            System.out.println("\nMAC:" + asHex(result));


            System.out.println("\nEnd of Program");


        } else{
            byte[] result = mac.doFinal(args[0].getBytes());
            // Print Header
            System.out.println("A Simple Program on HmacSHA1\n");

            // Print the key
            System.out.println("Key (Hex):\n" + asHex(key.getEncoded()));

            // Print out the resulting MAC
            System.out.println("\nMAC:" + asHex(result));


            System.out.println("\nEnd of Program");

        }

    }



    public static String asHex (byte buf[]) {

        //Obtain a StringBuffer object
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        // Return result string in Hexadecimal format
        return strbuf.toString();
    }
}