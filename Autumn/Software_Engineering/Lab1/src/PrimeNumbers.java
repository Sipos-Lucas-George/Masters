public class PrimeNumbers {
    static final int N = 1000;
    public static void main(String[] args) {
        boolean[] primesVisited = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (!primesVisited[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= N; j += i) {
                    primesVisited[j] = true;
                }
            }
        }
    }
}
