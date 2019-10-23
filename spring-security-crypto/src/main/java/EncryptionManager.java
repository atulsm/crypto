import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class EncryptionManager {
    private final String initializationString; //Example: Use product name
    private static final String SALT = KeyGenerators.string().generateKey();

    public EncryptionManager(String initializationString){
        this.initializationString=initializationString;
    }

    public String encrypt(String plainText){
        TextEncryptor encryptor = Encryptors.text(initializationString, SALT);
        String encryptedText = encryptor.encrypt(plainText);
        return encryptedText;
    }

    public String decrypt(String encryptedText) {
        TextEncryptor decryptor = Encryptors.text(initializationString, SALT);
        String decryptedText = decryptor.decrypt(encryptedText);
        return decryptedText;
    }
}
