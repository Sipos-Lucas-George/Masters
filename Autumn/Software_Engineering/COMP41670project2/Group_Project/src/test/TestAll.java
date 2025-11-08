package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//      here you can add the test class
//      e.g.: <TestClass>.class
//      between diamond braces is the class name
//      which should start with "Test" in its name
        TestChecker.class,
        TestBearOff.class
})

public class TestAll {
    // This class remains empty. It is used only as a holder for the above annotations
}
