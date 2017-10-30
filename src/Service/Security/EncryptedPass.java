package Service.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptedPass {
    public static String hashPassword(String Password, String Salt) throws NoSuchAlgorithmException {
        StringBuffer hash = new StringBuffer();
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        /*
         * Метод возвращает hash пароля
         * sha.update возвращает массив байтов для формирования MessageDigest в sha.digest
         * в цикле занчения массива bytes переводим в стринг и соединяем в одну строку.
         * 0xFF для коррктного отображения значений в диапазоне от 0..255 для 16-ричной системы счисления
         * radix 16 - система счисления 16-ричная
         */
        sha.update((Password + Salt).getBytes());
        byte[] bytes = sha.digest();

        for (byte b: bytes) {
            hash.append(Integer.toString((b & 0xFF), 16));
        }

        return hash.toString();
    }
}
