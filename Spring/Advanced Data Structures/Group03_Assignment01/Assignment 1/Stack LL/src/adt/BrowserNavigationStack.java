package adt;

public class BrowserNavigationStack implements BrowserNavigation {
	private MyStack<String> backStack;
	private MyStack<String> forwardStack;
	private String currentPage;

	public BrowserNavigationStack() {
		backStack = new MyStack<>();
		forwardStack = new MyStack<>();
		currentPage = "Home"; // Default page
	}

	/**
	 * Visit a new page. This pushes the current page onto the back stack, resets
	 * the forward stack, and updates the current page.
	 *
	 * @param url The URL of the page to visit
	 */
	public void visitPage(String url) {
		if (currentPage != null) {
			backStack.push(currentPage);
		}
		currentPage = url;
		forwardStack = new MyStack<>(); // Clear forward stack
	}

	/**
	 * Go back to the previous page if possible. If the back stack is empty, throw
	 * IllegalStateException.
	 * 
	 * @throws IllegalStateException if there are no pages in the back stack.
	 */
	public void back() throws IllegalStateException {
		if (backStack.isEmpty()) {
			throw new IllegalStateException("No pages in back history.");
		}
		forwardStack.push(currentPage);
		currentPage = backStack.pop();
	}

	/**
	 * Go forward to the next page if possible. If the forward stack is empty, throw
	 * IllegalStateException.
	 * 
	 * @throws IllegalStateException if there are no pages in the forward stack.
	 */
	public void forward() throws IllegalStateException {
		if (forwardStack.isEmpty()) {
			throw new IllegalStateException("No pages in foward history.");
		}
		backStack.push(currentPage);
		currentPage = forwardStack.pop();
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