/**************************************************************
 * A Simple Program to Print the Public Certificate Information
 * @author Samson Yeow @version 1
 * @author Calvin Siak  @version 1.1
 *
 ***************************************************************/

import java.io.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.math.BigInteger;
import java.security.PublicKey;


public class myCertStud {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Usage: java myCertStud certificate_name");
            return;
        }

        // Get the instance from the CertificateFactory class
        // Insert your statement here
        CertificateFactory cert = CertificateFactory.getInstance("X.509");
        // Open the file input stream
        FileInputStream info = new FileInputStream(args[0]);

        // Generate a certificate from that file
        Certificate printCert = cert.generateCertificate(info);
        info.close();

        // Display the information in the certificate
        System.out.println(printCert);
        System.out.println(printCert.getPublicKey());


        // Display more information in the certificate
        //Create X509Certificate object
        X509Certificate t = (X509Certificate) printCert;
        System.out.println("Verson: " + t.getVersion());
        System.out.println("Serial No: " + t.getSerialNumber().toString(16));
        byte[] sig = t.getSignature();
        System.out.println("\nSignature: \n" + new BigInteger(sig).toString(16));
    }
}
