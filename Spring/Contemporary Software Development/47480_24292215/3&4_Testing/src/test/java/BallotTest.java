import org.example.Ballot;
import org.example.Result;
import org.example.Vote;
import org.example.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BallotTest {
    private Ballot ballot;

    @BeforeEach
    void setUp() {
        ballot = new Ballot();
    }

    @Test
    void testMajorityYes() {
        ArrayList<Voter> mockVoters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.YES);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        for (int i = 0; i < 3; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.NO);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        ballot.holdVote();
        assertEquals(Result.YES, ballot.getResult());
        for (Voter voter : mockVoters) {
            verify(voter).inform(Result.YES);
        }
    }

    @Test
    void testMajorityNo() {
        ArrayList<Voter> mockVoters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.YES);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        for (int i = 0; i < 5; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.NO);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        ballot.holdVote();
        assertEquals(Result.NO, ballot.getResult());
        for (Voter voter : mockVoters) {
            verify(voter).inform(Result.NO);
        }
    }

    @Test
    void testDraw() {
        ArrayList<Voter> mockVoters = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.YES);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        for (int i = 0; i < 4; i++) {
            Voter mockVoter = mock(Voter.class);
            when(mockVoter.vote()).thenReturn(Vote.NO);
            mockVoters.add(mockVoter);
            ballot.registerVoter(mockVoter);
        }
        ballot.holdVote();
        assertEquals(Result.DRAW, ballot.getResult());
        for (Voter voter : mockVoters) {
            verify(voter).inform(Result.DRAW);
        }
    }
}
