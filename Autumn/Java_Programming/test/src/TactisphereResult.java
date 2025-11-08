import java.util.ArrayList;

public class TactisphereResult {
    private ArrayList<TactisphereTeam> teams;
    private ArrayList<int[]> roundsTeam1;
    private int[] surgeTeam1;
    private ArrayList<int[]> roundsTeam2;
    private int[] surgeTeam2;

    public TactisphereResult(ArrayList<TactisphereTeam> teams, int[] r11, int[] r12, int[] r13, int[] s1, int[] r21, int[] r22, int[] r23, int[] s2) {
        verifyRound(r11);
        verifyRound(r12);
        verifyRound(r13);
        verifyRound(r21);
        verifyRound(r22);
        verifyRound(r23);
        verifySurge(s1);
        verifySurge(s2);
        if (teams.size() != 2) {
            throw new IllegalArgumentException("Must have exactly 2 teams");
        }
        roundsTeam1 = new ArrayList<>();
        roundsTeam2 = new ArrayList<>();
        this.teams = teams;
        this.roundsTeam1.add(r11);
        this.roundsTeam1.add(r12);
        this.roundsTeam1.add(r13);
        this.surgeTeam1 = s1;
        this.roundsTeam2.add(r21);
        this.roundsTeam2.add(r22);
        this.roundsTeam2.add(r23);
        this.surgeTeam2 = s2;
        this.teams.getFirst().addResults(this);
        this.teams.getLast().addResults(this);
    }

    private void verifyRound(int[] round) {
        if (round.length != 4) {
            throw new IllegalArgumentException("Invalid round length");
        }
        for (int j : round) {
            if (j < 0) {
                throw new IllegalArgumentException("Invalid round score (only positive numbers)");
            }
        }
    }

    private void verifySurge(int[] surge) {
        if (surge.length != 3) {
            throw new IllegalArgumentException("Invalid surge length");
        }
        int used = 0;
        for (int j : surge) {
            if (j < 0 || j > 3) {
                throw new IllegalArgumentException("Invalid surge (0 <= surge <= 3)");
            } else if (used != 0 && j != 0) {
                throw new IllegalArgumentException("Surge can only be used once");
            } else if (j != 0) {
                used = 1;
            }
        }
    }

    public ArrayList<TactisphereTeam> getTeams() {
        return teams;
    }

    public ArrayList<int[]> getRoundsTeam1() {
        return roundsTeam1;
    }

    public int[] getSurgeTeam1() {
        return surgeTeam1;
    }

    public ArrayList<int[]> getRoundsTeam2() {
        return roundsTeam2;
    }

    public int[] getSurgeTeam2() {
        return surgeTeam2;
    }

    public TactisphereTeam getWinner() {
        return teams.getFirst().getPointsAgainst() > teams.getLast().getPointsAgainst() ? teams.getFirst() : teams.getLast();
    }

    @Override
    public String toString() {
        return "Tactisphere Result; Rounds Won: (" + teams.getFirst().getPointsFor() + ", " + teams.getLast().getPointsFor() + ")" + "\n"
                + teams.getFirst().getName() + " " + teams.getFirst().getPointsAgainst() + "/" + teams.getLast().getPointsAgainst() + "\n"
                + teams.getLast().getName() + " " + teams.getLast().getPointsAgainst() + "/" + teams.getFirst().getPointsAgainst() + "\n"
                + "Outcome: " + getWinner().toString() + " is the winner";
    }

    public static void main(String[] args) {
        TactisphereTeam t1 = new TactisphereTeam("Team 1", 4);
        TactisphereTeam t2 = new TactisphereTeam("Team 2", 4);
        TactisphereLeague l = new TactisphereLeague();
        l.addTeam(t1);
        l.addTeam(t2);

        int[] round1 = {1,0,0,0};
        int[] round2 = {0,1,0,1};
        int[] zeros = {0,0,0,0};
        int[] surge1 = {0,3,0};
        int[] surge2 = {2,0,0};

        TactisphereResult r3 = new TactisphereResult(l.getTeams(), round1, zeros, zeros, surge1, zeros, round2, zeros, surge2);
        System.out.println(r3);
    }
}
