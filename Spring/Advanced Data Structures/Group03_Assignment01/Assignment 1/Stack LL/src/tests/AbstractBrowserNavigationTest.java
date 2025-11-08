package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import adt.BrowserNavigation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class AbstractBrowserNavigationTest {

	protected BrowserNavigation browser;

	/**
	 * Each concrete test class must create an instance of a BrowserNavigation
	 * BrowserNavigationStack or BrowserNavigationList.
	 */
	protected abstract BrowserNavigation createBrowser();

	@Before
	public void setUp() {
		browser = createBrowser();
	}

	@Test
	public void testInitialPageIsHome() {
		assertEquals("Home", browser.toString());
	}

	@Test
	public void testVisitPage() {
		browser.visitPage("example.com");
		assertEquals("example.com", browser.toString());
	}

	@Test
	public void testVisitPageClearsForwardStack() {
		browser.visitPage("page1.com");
		browser.visitPage("page2.com");

		// Go back once
		browser.back(); // Should move from page2.com -> page1.com
		assertEquals("page1.com", browser.toString());

		// Now visit a new page -> forward stack should clear
		browser.visitPage("newpage.com");
		// Attempting forward should fail now, if forwardStack is truly empty
		assertThrows(IllegalStateException.class, browser::forward);
		assertEquals("newpage.com", browser.toString());
	}

	@Test
	public void testBackNavigation() {
		browser.visitPage("page1.com");
		browser.visitPage("page2.com");
		browser.visitPage("page3.com");

		// Current: page3.com
		browser.back();
		// Now: page2.com
		assertEquals("page2.com", browser.toString());

		// Back again
		browser.back();
		// Now: page1.com
		assertEquals("page1.com", browser.toString());

		// Back again
		browser.back();
		// Should be "Home" now
		assertEquals("Home", browser.toString());

		// Going back once more => should throw exception
		assertThrows(IllegalStateException.class, browser::back);
		// Verify still "Home"
		assertEquals("Home", browser.toString());
	}

	@Test
	public void testForwardNavigation() {
		browser.visitPage("page1.com");
		browser.visitPage("page2.com");
		browser.visitPage("page3.com");

		// Go back twice: from page3.com -> page2.com -> page1.com
		browser.back();
		browser.back();
		assertEquals("page1.com", browser.toString());

		// Now go forward (should go to page2.com)
		browser.forward();
		assertEquals("page2.com", browser.toString());

		// Go forward again (page3.com)
		browser.forward();
		assertEquals("page3.com", browser.toString());

		// Forward again => should fail, because forward stack is empty
		assertThrows(IllegalStateException.class, browser::forward);
		assertEquals("page3.com", browser.toString());
	}

	@Test
	public void testForwardAfterNewVisit() {
		browser.visitPage("A");
		browser.visitPage("B");
		// Go back: B -> A
		browser.back();
		assertEquals("A", browser.toString());

		// Visit a new page "C" -> should clear forward stack
		browser.visitPage("C");

		// Now forward should fail because forward stack is empty
		assertThrows(IllegalStateException.class, browser::forward);
		assertEquals("C", browser.toString());
	}

	@Test
	public void testBackFromHomeThrowsException() {
		// Currently at "Home"
		assertThrows(IllegalStateException.class, browser::back);
		// Still "Home"
		assertEquals("Home", browser.toString());
	}

	@Test
	public void testForwardWithoutHistoryThrowsException() {
		// No forward history at the start
		assertThrows(IllegalStateException.class, browser::forward);
		assertEquals("Home", browser.toString());
	}

	@Test
	public void testComplexNavigation() {
		// Home -> page1 -> page2 -> page3
		browser.visitPage("page1");
		browser.visitPage("page2");
		browser.visitPage("page3");
		assertEquals("page3", browser.toString());

		// Back twice: page3 -> page2 -> page1
		browser.back();
		browser.back();
		assertEquals("page1", browser.toString());

		// Forward once: page1 -> page2
		browser.forward();
		assertEquals("page2", browser.toString());

		// Visit new page: "page4" => forward stack cleared
		browser.visitPage("page4");
		assertEquals("page4", browser.toString());

		// Forward now => should throw exception (forward stack empty)
		assertThrows(IllegalStateException.class, browser::forward);
		assertEquals("page4", browser.toString());

		// Back thrice: page4 -> page2 -> page1 -> Home
		browser.back();
		browser.back();
		browser.back();
		assertEquals("Home", browser.toString());

		// Another back => exception
		assertThrows(IllegalStateException.class, browser::back);
		assertEquals("Home", browser.toString());
	}

	@Test
	public void testStress() throws Exception {
		// Load URLs from CSV
		List<String> urls = loadUrlsFromCsv(
				browser.getClass().getSimpleName().equalsIgnoreCase("BrowserNavigationList") ? "link_1_80.csv" : "link_2_80.csv");

		assertFalse(urls.isEmpty());

		// Visit each URL in a loop
		for (String url : urls) {
			browser.visitPage(url);
		}

		for (int i = 0; i < urls.size(); ++i) {
			browser.back();
		}

		for (int i = 0; i < urls.size(); ++i) {
			browser.forward();
		}

		assertNotNull("Browser final state should not be null", browser.toString());
	}

	private List<String> loadUrlsFromCsv(String csvFileName) throws Exception {
		// Find if CSV exists
		var resource = getClass().getResource(csvFileName);
		if (resource == null) {
			throw new IllegalArgumentException("CSV file not found: " + csvFileName);
		}
		// Get CSV path
		var path = Paths.get(resource.toURI());

		// Read lines and delete first entry ("url")
		List<String> urls = Files.readAllLines(path);
		urls.remove(0);
		return urls;
	}
}