/***************************************************************
 *
 * A Simple Program on MD5
 * Written by Samson Yeow
 * Singapore Polytechnic
 * (c) Mar 2007. Singapore Polytechnic
 *
 ***************************************************************/

import java.io.*;
import java.security.*;
import sun.misc.*;

public class myMd5Stud {

  public static void main(String[] args) throws Exception {

    // Check arguments.
    if (args.length != 1) {
      System.out.println("Usage: myMd5Stud filename");
      return;
    }

    // Obtain a message digest object.
    // Insert your statement here
    MessageDigest mySHA256 = MessageDigest.getInstance("SHA-256");

    // Calculate the digest for the given file.
    FileInputStream in = new FileInputStream(args[0]);
    byte[] buffer = new byte[8192];
    int length;

    while ((length = in.read(buffer)) != -1)
      mySHA256.update(buffer, 0, length);
    byte[] md = mySHA256.digest();

    // Print Header.
    System.out.println("A Simple Program on SHA-256\n");

    // Print out the MD5 digest in hexadecimal format.
    // Insert your statement here
      System.out.println("SHA-256 Hex =>" +   asHex(md) );

      System.out.println("SHA-256 Base 64 =>" + md);




    System.out.println("\nEnd of Program");
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

/*   The End   */
