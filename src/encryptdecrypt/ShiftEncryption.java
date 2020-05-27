package encryptdecrypt;

public class ShiftEncryption extends Encryption {


    @Override
    public String encrypt(String text, int key) {
        //int key = scanner.nextInt() % 26;

        char[] textAsCharArray = text.toCharArray();

        String cipherText = "";
        for (char ch: textAsCharArray) {
            char cipherChar;
            if (ch >= 65 && ch <= 90) {
                if (ch + key > 90) {
                    cipherChar = (char) (64 + (ch + key - 90));
                } else {
                    cipherChar = (char) (ch + key);
                }
            } else if (ch >= 97 && ch <= 122) {
                if (ch + key > 122) {
                    cipherChar = (char) (96 + (ch + key - 122));
                } else {
                    cipherChar = (char) (ch + key);
                }

            } else {
                cipherChar = ch;
            }
            cipherText += cipherChar;
        }
        return cipherText;
    }
}
