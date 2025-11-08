package huffman;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class HuffmanHeader {
    private Map<Byte, Integer> frequencies;
    private int bitLength;
    private int headerByteLength; // total bytes occupied by header in the file

    public HuffmanHeader(Map<Byte, Integer> frequencies, int bitLength, int headerByteLength) {
        this.frequencies = frequencies;
        this.bitLength = bitLength;
        this.headerByteLength = headerByteLength;
    }

    public Map<Byte, Integer> getFrequencies() {
        return frequencies;
    }

    public int getBitLength() {
        return bitLength;
    }

    public int getHeaderByteLength() {
        return headerByteLength;
    }

    // Writes the header into a byte array.
    // Format:
    // Line 0: "HUFFMAN"
    // Line 1: frequency map size
    // Next freqCount lines: "byte frequency"
    // Next line: bit-length of the encoded bitstream
    // Then a blank line as a header delimiter.
    public static byte[] createHeader(Map<Byte, Integer> frequencies, int bitLength) {
        StringBuilder header = new StringBuilder();
        header.append("HUFFMAN\n");
        header.append(frequencies.size()).append("\n");
        for (Map.Entry<Byte, Integer> entry : frequencies.entrySet()) {
            header.append(entry.getKey() & 0xFF).append(" ").append(entry.getValue()).append("\n");
        }
        header.append(bitLength).append("\n\n");
        return header.toString().getBytes(StandardCharsets.UTF_8);
    }

    // Parses the header from a complete file byte array.
    // Returns a HuffmanHeader object that contains the frequency map, bit length, and header length.
    public static HuffmanHeader parseHeader(byte[] fileData) {
        byte[] delimiter = "\n\n".getBytes(StandardCharsets.UTF_8);
        int headerEndIndex = -1;
        for (int i = 0; i < fileData.length - delimiter.length + 1; i++) {
            boolean match = true;
            for (int j = 0; j < delimiter.length; j++) {
                if (fileData[i + j] != delimiter[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                headerEndIndex = i + delimiter.length;
                break;
            }
        }
        if (headerEndIndex == -1) {
            throw new RuntimeException("Header delimiter not found.");
        }
        String headerString = new String(fileData, 0, headerEndIndex, StandardCharsets.UTF_8);
        String[] headerLines = headerString.split("\n");
        if (headerLines.length < 4 || !headerLines[0].equals("HUFFMAN")) {
            throw new RuntimeException("Invalid header format.");
        }
        int freqCount = Integer.parseInt(headerLines[1].trim());
        Map<Byte, Integer> frequencies = new LinkedHashMap<>();
        for (int i = 2; i < 2 + freqCount; i++) {
            String[] tokens = headerLines[i].split(" ");
            int byteVal = Integer.parseInt(tokens[0]);
            int freq = Integer.parseInt(tokens[1]);
            frequencies.put((byte) byteVal, freq);
        }
        int bitLength = Integer.parseInt(headerLines[2 + freqCount].trim());
        return new HuffmanHeader(frequencies, bitLength, headerEndIndex);
    }
}