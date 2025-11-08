import java.util.ArrayList;

public class Metal {
    private int mass;
    private double purity;
    public static enum types {GOLD, LEAD, TIN};
    private types type;
    private ArrayList<String> history;

    public static final double GOLD = 48.75;
    public static final double LEAD = 0.01;
    public static final double TIN = 0.03;

    public Metal(int mass, types type) {
        if (mass < 1) {
            throw new IllegalArgumentException("mass must be a positive integer");
        }
        this.mass = mass;
        this.type = type;

        purity = 1;
        history = new ArrayList<>();
    }

    public int getMass() {
        return mass;
    }

    public double getPurity() {
        return purity;
    }

    public types getType() {
        return type;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public double getValue() {
        return switch (type) {
            case GOLD -> purity * mass * GOLD;
            case TIN -> purity * mass * TIN;
            case LEAD -> purity * mass * LEAD;
            default -> throw new RuntimeException("Have not considered type: " + type);
        };
    }

    public void mixWith(Metal m) {
        history.add("Mixed with: " + m);
        if (type.equals(m.getType())) {
            mass += m.getMass();
        } else if (type.equals(types.TIN) && m.getType().equals(types.LEAD) || type.equals(types.LEAD) && m.getType().equals(types.TIN)) {
            type = types.GOLD;
            mass += m.getMass();
        } else if (type.equals(types.GOLD) && (m.getType().equals(types.LEAD) || m.getType().equals(types.TIN))) {
            double d = mass;
            mass += m.getMass();
            purity = d / (double)mass;
            if (purity < 0.5) {
                type = m.getType();
                purity = 1;
            }
        } else if ((type.equals(types.LEAD) || type.equals(types.TIN)) && m.getType().equals(types.GOLD)) {
            mass += m.getMass();
            purity = (double)m.getMass() / (double)mass;
            if (purity >= 0.5) {
                type = types.GOLD;
            } else {
                purity = 1 - purity;
            }
        }
    }

    @Override
    public String toString() {
        String metal = switch (type) {
            case GOLD -> "Gold";
            case TIN -> "Tin";
            case LEAD -> "Lead";
            default -> "Unknown";
        };
        return "Metal: " + metal + ", Mass: " + mass + ", Value: " + getValue() + ", Purity: " + purity;
    }

    public static void main(String[] args) {
        Metal m = new Metal(100, types.GOLD);
//        System.out.println(m);
        m.mixWith(m);
        System.out.println(m);
//
//        Metal n = new Metal(50, types.LEAD);
//        Metal p = new Metal(25, types.TIN);
//
//        System.out.println(n);
//        n.mixWith(p);
//        System.out.println(n);
//
//        m.mixWith(p);
//        System.out.println(m);
//
//        for (String s: m.getHistory()) {
//            System.out.println(s);
//        }
    }
}
