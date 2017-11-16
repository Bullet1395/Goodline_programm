package service.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class EncryptedPass {
    /**
     * Метод возвращает hash пароля
     * sha.update возвращает массив байтов для формирования MessageDigest в sha.digest
     * в цикле занчения массива bytes переводим в стринг и соединяем в одну строку.
     * 0xFF(это 1111 1111), b & 0xFF(это побитовое умножение) для отображения значений в диапазоне от 0..255,
     * если не использовать 0xFF числа будут отображаться -128 до 127
     * без - c-11-4b145e50-164a3f3-35-314948-17-36-784d54-55-36-18-5b1e-19-c-6116-6....
     * с   - 1237be4bc089863f2e58f72ff1cd8fe843d90ea69ac51eb6e72df5bd8....
     * radix 16 - система счисления 16-ричная
     *
     * @param password пароль для хэширования
     * @param salt salt
     * @return хэш пароля
     */
    private static String hashPassword(String password, byte salt) {
        try {
            StringBuilder hash = new StringBuilder();
            MessageDigest sha = MessageDigest.getInstance("SHA-512");

            sha.update((password + salt).getBytes());
            sha.update(sha.digest());

            for (byte b : sha.digest()) {
                hash.append(Integer.toString((b & 0xFF), 16));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Генерирует случайное значение salt и возвращает его
     *
     * @return массив байтов
     */
    public static String setSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

    /**
     * Задает пароль и сохраняет его в hash виде
     *
     * @param password пароль
     */
    public static String setPasswordHash(String password, String salt) {
        return EncryptedPass.hashPassword(password, salt);
    }
}
