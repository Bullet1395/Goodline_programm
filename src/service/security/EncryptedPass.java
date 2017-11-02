package service.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class EncryptedPass {
    /*
     * Метод возвращает hash пароля
     * sha.update возвращает массив байтов для формирования MessageDigest в sha.digest
     * в цикле занчения массива bytes переводим в стринг и соединяем в одну строку.
     * 0xFF для коррктного отображения значений в диапазоне от 0..255 для 16-ричной системы счисления
     * radix 16 - система счисления 16-ричная
     */
    public static String hashPassword(String Password, String Salt) {
        try {
            StringBuilder hash = new StringBuilder();
            MessageDigest sha = MessageDigest.getInstance("SHA-512");

            sha.update((Password + Salt).getBytes());
            sha.update(sha.digest());

            for (byte b : sha.digest()) {
                hash.append(Integer.toString((b & 0xFF), 16));
            }

            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            return e.getMessage();
        }
    }

    public static String setSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }
}
