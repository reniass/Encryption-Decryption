package encryptdecrypt;

public class EncryptionContext {

    private Encryption encryption;

    public void setEncryption(Encryption encryption) {
        this.encryption = encryption;
    }

    public String encrypt(String text, int key) {
        return encryption.encrypt(text, key);
    }
}
