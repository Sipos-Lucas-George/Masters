package org.example;

import java.util.ArrayList;

public class Ballot {
    private Result result;
    private ArrayList<Voter> voters;

    public Ballot() {
        this.voters = new ArrayList<Voter>();
    }

    public void registerVoter(Voter voter) {
        this.voters.add(voter);
    }

    public void holdVote() {
        int totalYes = 0;
        int totalNo = 0;
        int i = 0;
        while (i < this.voters.size() && totalYes < (this.voters.size() / 2 + 1) && totalNo < (this.voters.size() / 2 + 1)) {
            if (this.voters.get(i).vote() == Vote.YES) {
                totalYes++;
            } else {
                totalNo++;
            }
            i++;
        }
        if (totalYes > totalNo) {
            this.result = Result.YES;
        } else if (totalNo > totalYes) {
            this.result = Result.NO;
        } else {
            this.result = Result.DRAW;
        }
        this.informVoters();
    }

    private void informVoters() {
        for (int i = 0; i < this.voters.size(); i++) {
            this.voters.get(i).inform(this.result);
        }
    }

    public Result getResult() {
        return this.result;
    }
}
