package encryptdecrypt;

public class UnicodeDecryption extends Decryption {

    @Override
    public String decrypt(String cipherText, int key) {
        String text = "";
        char[] cipherTextAsCharArray =  cipherText.toCharArray();
        for (char ch: cipherTextAsCharArray) {
            char newChar = (char) (ch - key);
            text += newChar;
        }
        return text;
    }
}
