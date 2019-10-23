import junit.framework.Assert;
import junit.framework.TestCase;

public class TestEncryptionManager extends TestCase {

    public void testSingleInstance(){
        EncryptionManager crypto = new EncryptionManager("payments");
        String textToEncrypt = "Testing encryption";
        String encryptedText = crypto.encrypt(textToEncrypt);
        String decryptedText = crypto.decrypt(encryptedText);

        Assert.assertEquals(textToEncrypt, decryptedText);
    }

    public void testMultiInstance(){
        EncryptionManager crypto = new EncryptionManager("payments");
        String textToEncrypt = "Testing encryption";
        String encryptedText = crypto.encrypt(textToEncrypt);

        EncryptionManager crypto1 = new EncryptionManager("payments");
        String decryptedText = crypto1.decrypt(encryptedText);

        Assert.assertEquals(textToEncrypt, decryptedText);
    }
}
