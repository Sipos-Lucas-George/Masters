package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StackTest.class, BrowserNavigationListTest.class, BrowserNavigationStackTest.class })
public class AllTests {

}
