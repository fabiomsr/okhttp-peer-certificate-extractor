package org.fabiomsr.peercertificate;

/**
 * Created by fabiomsr on 3/7/16.
 */
public class HexUtil {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    private static final String HEX = "0123456789ABCDEF";

    /**
     * Convert byte array to hexadecimal string
     * @param data Input array
     * @return hexadecimal string
     */
    public static String toHexString(byte[] data) {
        StringBuilder result = new StringBuilder();

        if (data != null) {
            for (byte octet : data) {
                int firstIndex = (octet & 0xF0) >>> 4;
                int secondIndex = octet & 0x0F;
                result.append(HEX_CHARS[firstIndex]);
                result.append(HEX_CHARS[secondIndex]);
            }
        }

        return result.toString();
    }

    /**
     * Convert hexadecimal string to byte array
     * @param text Input hexadecimal text
     * @return Byte array
     */
    public static byte[] hexStringToByteArray(String text) {
        int length = text.length();
        byte[] result = new byte[length / 2];

        for (int i = 0, j = 0; i < length; i += 2, j++) {
            char firstChar = text.charAt(i);
            int firstIndex = HEX.indexOf(firstChar);
            char secondChar = text.charAt(i + 1);
            int secondIndex = HEX.indexOf(secondChar);

            int octet = firstIndex << 4 | secondIndex;
            result[j] = (byte) octet;
        }

        return result;
    }


}