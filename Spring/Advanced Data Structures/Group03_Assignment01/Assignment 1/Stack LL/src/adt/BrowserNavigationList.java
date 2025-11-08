package adt;

import java.util.LinkedList;

public class BrowserNavigationList implements BrowserNavigation {
	private LinkedList<String> backList;
	private LinkedList<String> forwardList;
	private String currentPage;

	public BrowserNavigationList() {
		backList = new LinkedList<>();
		forwardList = new LinkedList<>();
		currentPage = "Home";
	}

	/**
	 * Visits a new page. The current page is added to the back list (if there is a
	 * valid current page), the forward list is cleared, and the current page is set
	 * to the new URL.
	 *
	 * @param url The URL of the page to visit.
	 */
	@Override
	public void visitPage(String url) {
		if (currentPage != null) {
			backList.addLast(currentPage);
			// or just backList.add(currentPage)
		}
		currentPage = url;
		forwardList = new LinkedList<>();
	}

	/**
	 * Navigates back to the most recently visited page in the back list. Throws an
	 * IllegalStateException if the back list is empty.
	 *
	 * @throws IllegalStateException if there are no pages in the back list.
	 */
	@Override
	public void back() throws IllegalStateException {
		if (backList.isEmpty()) {
			throw new IllegalStateException("No pages in back history.");
		}
		forwardList.addLast(currentPage);
		currentPage = backList.removeLast();
	}

	/**
	 * Navigates forward to the most recently added page in the forward list. Throws
	 * an IllegalStateException if the forward list is empty.
	 *
	 * @throws IllegalStateException if there are no pages in the forward list.
	 */
	@Override
	public void forward() throws IllegalStateException {
		if (forwardList.isEmpty()) {
			throw new IllegalStateException("No pages in forward history.");
		}
		backList.addLast(currentPage);
		currentPage = forwardList.removeLast();
	}

	/**
	 * Returns the current page as a string.
	 *
	 * @return The current page URL.
	 */
	@Override
	public String toString() {
		return currentPage;
	}
}