package tests;

import adt.BrowserNavigationList;

public class BrowserNavigationListTest extends AbstractBrowserNavigationTest {

    @Override
    protected BrowserNavigationList createBrowser() {
        return new BrowserNavigationList();
    }
}