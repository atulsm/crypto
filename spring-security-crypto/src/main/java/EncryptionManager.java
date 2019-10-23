import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class EncryptionManager {
    private static final String GENERATOR_PASS = "payments"; //Use product name as key
    private static final String SALT = KeyGenerators.string().generateKey();

    public static String encrypt(String plainText){
        TextEncryptor encryptor = Encryptors.text(GENERATOR_PASS, SALT);
        String encryptedText = encryptor.encrypt(plainText);
        return encryptedText;
    }

    public static String decrypt(String encryptedText) {
        TextEncryptor decryptor = Encryptors.text(GENERATOR_PASS, SALT);
        String decryptedText = decryptor.decrypt(encryptedText);
        return decryptedText;
    }

    public static void main(String[] args) {
        String textToEncrypt = "Testing encryption";
        String encryptedText = encrypt(textToEncrypt);
        String decryptedText = decrypt(encryptedText);

        if(textToEncrypt.equals(decryptedText)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed. " + textToEncrypt + "|" + decryptedText);
        }
    }
}
