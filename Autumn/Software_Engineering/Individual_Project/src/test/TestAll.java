package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CardTest.class,
//        CardsPileTest.class,
        DeckTest.class,
        DrawPileTest.class,
        FoundationTest.class,
        FoundationsTest.class,
        GameTrackerTest.class,
        LaneTest.class,
        LanesTest.class
})

public class TestAll {
    // This class remains empty. It is used only as a holder for the above annotations
}
