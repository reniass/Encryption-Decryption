package encryptdecrypt;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;
        FileWriter fileWriter = null;

        String mode = "enc";
        int key = 0;
        String data = "";
        String algorithm = "shift";
        //boolean isData = false;

        File fileInput = null;
        //boolean isIn = false;

        File fileOutput = null;
        boolean isOut = false;

        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
//                isData = true;
            } else if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            } else if (args[i].equals("-in")) {
                try {

                    fileInput = new File("road_to_treasure.txt");
                    boolean exist = fileInput.exists();
//                    isIn = true;
                    scanner = new Scanner(fileInput);
                    data = scanner.nextLine();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    scanner.close();
                }
            } else if (args[i].equals("-out")) {
                fileOutput = new File(args[i + 1]);
                isOut = true;
            }

        }

        if (mode.equals("enc")) {
            EncryptionContext encryptionContext = new EncryptionContext();
            if (algorithm.equals("shift")) {
                encryptionContext.setEncryption(new ShiftEncryption());
                if (isOut) {
                    try {
                        fileWriter = new FileWriter(fileOutput);
                        fileWriter.write(encryptionContext.encrypt(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(encryptionContext.encrypt(data, key));
                }
            } else if (algorithm.equals("unicode")){
                encryptionContext.setEncryption(new UnicodeEncryption());
                if (isOut) {
                    try {
                        fileWriter = new FileWriter(fileOutput);
                        fileWriter.write(encryptionContext.encrypt(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(encryptionContext.encrypt(data, key));
                }
            }

        } else {
            DecryptionContext decryptionContext = new DecryptionContext();
            if (algorithm.equals("shift")) {
                decryptionContext.setDecryption(new ShiftDecryption());
                if (isOut) {
                    try {
                        fileWriter = new FileWriter(fileOutput);
                        fileWriter.write(decryptionContext.decrypt(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(decryptionContext.decrypt(data, key));
                }
            } else if (algorithm.equals("unicode")){
                decryptionContext.setDecryption(new UnicodeDecryption());
                if (isOut) {
                    try {
                        fileWriter = new FileWriter(fileOutput);
                        fileWriter.write(decryptionContext.decrypt(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(decryptionContext.decrypt(data, key));
                }
            }
        }

//        if (scanner != null) {
//            scanner.close();
//        }

        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
