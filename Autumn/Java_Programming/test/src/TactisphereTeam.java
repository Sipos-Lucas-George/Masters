import java.util.ArrayList;
import java.util.Objects;

public class TactisphereTeam {
    private String name;
    private int teamSize;
    private int leaguePoints;
    private int pointsFor;
    private int pointsAgainst;
    private int surgePoints;

    public final static int BasicGoal = 2;
    public final static int HazardGoal = 4;
    public final static int TrapScore = 3;
    public final static int Bonus = 2;

    public TactisphereTeam(String teamName, int teamSize) {
        if (teamName == null || teamName.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
        if (teamSize != 4) {
            throw new IllegalArgumentException("Team size needs to be 4");
        }
        this.name = teamName;
        this.teamSize = teamSize;
        this.leaguePoints = 0;
        this.pointsFor = 0;
        this.pointsAgainst = 0;
        this.surgePoints = 10;
    }

    public String getName() {
        return name;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getSurgePoints() {
        return surgePoints;
    }

    void addResults(TactisphereResult game) {
        ArrayList<int[]> rounds;
        ArrayList<int[]> oppRounds;
        int[] surge;
        int[] oppSurge;
        if (game.getTeams().getFirst().equals(this)) {
            rounds = game.getRoundsTeam1();
            oppRounds = game.getRoundsTeam2();
            surge = game.getSurgeTeam1();
            oppSurge = game.getSurgeTeam2();
        } else {
            rounds = game.getRoundsTeam2();
            oppRounds = game.getRoundsTeam1();
            surge = game.getSurgeTeam2();
            oppSurge = game.getSurgeTeam1();
        }
        for (int i = 0; i < rounds.size(); i++) {
            int oppScore = 0;
            int teamScore = 0;
            for (int j = 0; j < rounds.getFirst().length; j++) {
                if (j == 0) {
                    teamScore += rounds.get(i)[j] * BasicGoal;
                    oppScore += oppRounds.get(i)[j] * BasicGoal;
                } else if (j == 1) {
                    teamScore += rounds.get(i)[j] * HazardGoal;
                    oppScore += oppRounds.get(i)[j] * HazardGoal;
                } else if (j == 2) {
                    teamScore += rounds.get(i)[j] * TrapScore;
                    oppScore += oppRounds.get(i)[j] * TrapScore;
                } else if (j == 3) {
                    teamScore += rounds.get(i)[j] * Bonus;
                    oppScore += oppRounds.get(i)[j] * Bonus;
                }
            }
            teamScore += surge[i];
            oppScore += oppSurge[i];
            surgePoints -= surge[i];
            this.pointsAgainst += teamScore;
            if (oppScore < teamScore) {
                pointsFor += 1;
                leaguePoints += 2;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TactisphereTeam that = (TactisphereTeam) o;
        return teamSize == that.teamSize && leaguePoints == that.leaguePoints && pointsFor == that.pointsFor && pointsAgainst == that.pointsAgainst && surgePoints == that.surgePoints && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "TactisphereTeam: " + name + " (" + surgePoints + " League Surge Points)";
    }

    public static void main(String[] args) {
        TactisphereTeam t = new TactisphereTeam("Team 1", 4);
        System.out.println(t);
    }
}
