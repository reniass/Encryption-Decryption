package encryptdecrypt;

public class ShiftDecryption extends Decryption{


    @Override
    public String decrypt(String cipherText, int key) {
        //int key = scanner.nextInt() % 26;
        key = 26 - 5;
        char[] textAsCharArray = cipherText.toCharArray();

        String text = "";
        for (char ch: textAsCharArray) {
            char decryptedChar;
            if (ch >= 65 && ch <= 90) {
                if (ch + key > 90) {
                    decryptedChar = (char) (64 + (ch + key - 90));
                } else {
                    decryptedChar = (char) (ch + key);
                }
            } else if (ch >= 97 && ch <= 122) {
                if (ch + key > 122) {
                    decryptedChar = (char) (96 + (ch + key - 122));
                } else {
                    decryptedChar = (char) (ch + key);
                }

            } else {
                decryptedChar = ch;
            }
            text += decryptedChar;
        }
        return text;
    }
}
