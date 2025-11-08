package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import huffman.HuffmanNode;

public class HuffmanTree<T> {
    private HuffmanNode<T> root;

    // Building Huffman tree using frequency map
    public HuffmanTree(Map<T, Integer> frequencyMap) {
        this.root = buildTree(frequencyMap);
    }

    private HuffmanNode<T> buildTree(Map<T, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode<T>> pq = new PriorityQueue<>();
        for (Map.Entry<T, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode<>(entry.getKey(), entry.getValue()));
        }
        while (pq.size() > 1) {
            HuffmanNode<T> left = pq.poll();
            HuffmanNode<T> right = pq.poll();
            HuffmanNode<T> parent = new HuffmanNode<>(left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }
        return pq.poll();
    }

    // Generate Huffman codes for each char/symbol
    public Map<T, String> generateCodes() {
        Map<T, String> codes = new HashMap<>();
        generateCodesHelper(root, "", codes);
        return codes;
    }

    private void generateCodesHelper(HuffmanNode<T> node, String code, Map<T, String> codes) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            // If only one unique symbol, assign "0" if code is empty.
            codes.put(node.symbol, code.length() > 0 ? code : "0");
            return;
        }
        generateCodesHelper(node.left, code + "0", codes);
        generateCodesHelper(node.right, code + "1", codes);
    }

    // Print the tree (level-order traversal)
    public void printLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<HuffmanNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        System.out.println("Huffman Tree (Level Order):");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            StringBuilder levelLine = new StringBuilder();
            levelLine.append(String.format("Level %d: ", level));
            for (int i = 0; i < levelSize; i++) {
                HuffmanNode<T> node = queue.poll();
                levelLine.append(formatNode(node) + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(levelLine.toString());
            level++;
        }
        System.out.println();
    }

    // Helper method - format node for printing
    private String formatNode(HuffmanNode<T> node) {
        if (node.isLeaf()) {
            String symbolRepresentation = formatSymbol(node.symbol);
            return String.format("[%s:%d]", symbolRepresentation, node.frequency);
        } else {
            return String.format("[#:%d]", node.frequency);
        }
    }

    // Format symbols to show the char and its hexadecimal value.
    private String formatSymbol(T symbol) {
        if (symbol instanceof Byte) {
            byte b = (Byte) symbol;
            int unsignedByte = b & 0xFF;
            char ch = (char) unsignedByte;
            String charStr = (ch == '\n') ? "\\n"
                             : (ch == '\r') ? "\\r"
                             : Character.toString(ch);
            return String.format("%s (0x%02X)", charStr, unsignedByte);
        } else if (symbol instanceof Character) {
            char ch = (Character) symbol;
            String charStr = (ch == '\n') ? "\\n"
                             : (ch == '\r') ? "\\r"
                             : Character.toString(ch);
            return String.format("%s (0x%02X)", charStr, (int) ch);
        } else {
            return symbol.toString();
        }
    }

    // Getter for the root of the Huffman tree
    public HuffmanNode<T> getRoot() {
        return this.root;
    }
}