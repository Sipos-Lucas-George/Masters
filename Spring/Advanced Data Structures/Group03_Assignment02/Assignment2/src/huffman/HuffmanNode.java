package huffman;

@SuppressWarnings("unchecked")
public class HuffmanNode<T> implements Comparable<HuffmanNode<T>> {
    public T symbol;
    public int frequency;
    public HuffmanNode<T> left, right;

    // Constructor for leaf nodes
    public HuffmanNode(T symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    // Constructor for internal nodes
    public HuffmanNode(int frequency, HuffmanNode<T> left, HuffmanNode<T> right) {
        this.symbol = null; // internal node
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode<T> other) {
        int freqComp = Integer.compare(this.frequency, other.frequency);
        if (freqComp != 0)
            return freqComp;
        if (this.symbol != null && other.symbol != null 
                && this.symbol instanceof Comparable<?> 
                && other.symbol instanceof Comparable<?>) {
            return ((Comparable<T>) this.symbol).compareTo(other.symbol);
        }
        if (this.symbol != null)
            return -1;
        if (other.symbol != null)
            return 1;
        return 0;
    }
}