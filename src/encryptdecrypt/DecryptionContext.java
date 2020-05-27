package encryptdecrypt;

public class DecryptionContext {

    private Decryption decryption;

    public void setDecryption(Decryption decryption) {
        this.decryption = decryption;
    }

    public String decrypt(String text, int key) {
        return decryption.decrypt(text, key);
    }
}
