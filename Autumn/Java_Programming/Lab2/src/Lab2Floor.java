import java.util.ArrayList;

public class Lab2Floor {
    private ArrayList<ArrayList<Character>> floor;
    private boolean square;

    public Lab2Floor() {}

    public void draw(int columns, int lines, int position) {
        square = columns == lines;
        floor = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            floor.add(new ArrayList<>());
        }
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (square && i == j) {
                    floor.get(i).add('\\');
                } else if (square && j + i == columns - 1) {
                    floor.get(i).add('/');
                } else if (i % position == 0) {
                    if (j % position == 0) {
                        floor.get(i).add('+');
                    } else {
                        floor.get(i).add('-');
                    }
                } else {
                    if (j % position == 0) {
                        floor.get(i).add('|');
                    } else if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                        floor.get(i).add('x');
                    } else {
                        floor.get(i).add('o');
                    }
                }
                System.out.printf("%c ", floor.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void outputPrice() {
        int[] priceList = new int[7];
        for (int i = 0; i < floor.size(); i++) {
            for (int j = 0; j < floor.get(i).size(); j++) {
                switch (floor.get(i).get(j)) {
                    case '+':
                        ++priceList[0];
                        break;
                    case '-':
                        ++priceList[1];
                        break;
                    case '|':
                        ++priceList[2];
                        break;
                    case 'o':
                        ++priceList[3];
                        break;
                    case 'x':
                        ++priceList[4];
                        break;
                    case '\\':
                        ++priceList[5];
                        break;
                    case '/':
                        ++priceList[6];
                        break;
                }
            }
        }
        int sum = 0;
        System.out.printf("No +:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[0], priceList[0] * 5);
        sum += priceList[0] * 5;
        System.out.printf("No -:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[1], priceList[1] * 4);
        sum += priceList[1] * 4;
        System.out.printf("No |:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[2], priceList[2] * 3);
        sum += priceList[2] * 3;
        System.out.printf("No o:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[3], priceList[3] * 2);
        sum += priceList[3] * 2;
        System.out.printf("No x:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[4], priceList[4]);
        sum += priceList[4];
        if (square){
            System.out.printf("No \\:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[5], priceList[5] * 3);
            sum += priceList[5] * 3;
            System.out.printf("No /:\t\t\t%d\t\t\tCost\t\t\t%d\n", priceList[6], priceList[6] * 3);
            sum += priceList[6] * 3;
        }
        System.out.printf("No tiles:\t\t%d\t\t\tCost\t\t\t%.3f\n", floor.size() * floor.get(0).size(), (float) sum * 1.23);
    }

    public static void main(String[] args) {
        Lab2Floor floor = new Lab2Floor();
        floor.draw(16, 16, 5);
        floor.outputPrice();
        floor.draw(13, 7, 3);
        floor.outputPrice();
        floor.draw(9, 9, 4);
        floor.outputPrice();
    }
}
