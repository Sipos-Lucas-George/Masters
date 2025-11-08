package tests;

import adt.BrowserNavigationStack;

public class BrowserNavigationStackTest extends AbstractBrowserNavigationTest {

    @Override
    protected BrowserNavigationStack createBrowser() {
        return new BrowserNavigationStack();
    }
}