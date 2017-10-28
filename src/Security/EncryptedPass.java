package Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptedPass {
    public static String hashPassword(String Password, String Salt) throws NoSuchAlgorithmException {
        StringBuffer hash = new StringBuffer();
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        sha.update((Password + Salt).getBytes());
        byte[] bytes = sha.digest();

        for (int i = 0; i < bytes.length; i++) {
            hash.append(Integer.toString((bytes[i] & 0xFF) + 0x100, 16).substring(1));
        }
        return hash.toString();
    }
}
