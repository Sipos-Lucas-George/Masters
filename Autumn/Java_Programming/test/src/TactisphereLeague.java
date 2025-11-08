import java.util.ArrayList;

public class TactisphereLeague {
    private ArrayList<TactisphereTeam> team;
    private ArrayList<TactisphereResult> results;

    public TactisphereLeague() {
        team = new ArrayList<>();
    }

    public void addTeam(TactisphereTeam team) {
        this.team.add(team);
    }

    public ArrayList<TactisphereTeam> getTeams() {
        return this.team;
    }

    public void addResults(TactisphereResult game) {
        results.add(game);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (TactisphereTeam team : this.team) {
            str.append(team.toString()).append("\n");
        }
        return str.toString().trim();
    }

    public static void main(String[] args) {
        TactisphereTeam t1 = new TactisphereTeam("Team 1", 4);
        TactisphereTeam t2 = new TactisphereTeam("Team 2", 4);
        TactisphereLeague l = new TactisphereLeague();
        l.addTeam(t1);
        l.addTeam(t2);
        System.out.println(l);
        System.out.println(l.getTeams());
    }
}
