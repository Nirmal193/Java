package com.design.Jayspt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Test {
        private static String mpCryptoPassword = "aorsecret";
        private static String algo = "PBEWITHSHA1ANDDESEDE";
        public static void main(String[] args) {
            String value = "Retp_all_1234";

            System.out.println("Original Value : "+value);
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(mpCryptoPassword);
            encryptor.setAlgorithm(algo);
            String encryptedPassword = encryptor.encrypt(value);
            System.out.println(encryptedPassword);

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(mpCryptoPassword);
        decryptor.setAlgorithm(algo);
        System.out.println(decryptor.decrypt(value));
    }
}
