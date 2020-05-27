package encryptdecrypt;

public class UnicodeEncryption extends Encryption{

    @Override
    public String encrypt(String text, int key) {
        String cipherText = "";
        char[] textAsCharArray = text.toCharArray();
        for (char ch: textAsCharArray) {
            char newChar = (char) (ch + key);
            cipherText += newChar;
        }
        return cipherText;
    }
}
