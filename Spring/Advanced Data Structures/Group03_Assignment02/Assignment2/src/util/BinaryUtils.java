package util;

public class BinaryUtils {
    // Converts a binary string (composed of '0's and '1's) to a byte array by packing 8 bits per byte.
    public static byte[] binaryStringToByteArray(String binary) {
        int byteCount = (binary.length() + 7) / 8;
        byte[] bytes = new byte[byteCount];
        for (int i = 0; i < byteCount; i++) {
            int start = i * 8;
            int end = Math.min(start + 8, binary.length());
            String byteString = binary.substring(start, end);
            // Pad the last byte if necessary
            if (byteString.length() < 8) {
                byteString = String.format("%-8s", byteString).replace(' ', '0');
            }
            bytes[i] = (byte) Integer.parseInt(byteString, 2);
        }
        return bytes;
    }

    // Converts a byte array to a binary string, returning only the first 'bitLength' bits.
    public static String byteArrayToBinaryString(byte[] bytes, int bitLength) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }
        return sb.substring(0, bitLength);
    }
}