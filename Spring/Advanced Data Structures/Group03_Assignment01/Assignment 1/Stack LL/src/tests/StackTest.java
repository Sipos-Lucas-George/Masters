package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import adt.MyStack;

public class StackTest {

	@Test
	public void testStackInitialization() {
		MyStack<Integer> stack = new MyStack<>();
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	public void testPushAndPop() {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(10);
		stack.push(20);

		assertEquals(2, stack.size());
		assertEquals(20, (int) stack.pop());
		assertEquals(10, (int) stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testPeek() {
		MyStack<String> stack = new MyStack<>();
		stack.push("Hello");
		stack.push("World");

		assertEquals("World", stack.peek());
		assertEquals(2, stack.size()); // Ensure peek doesn't remove the element
	}

	@Test
	public void testPopFromEmptyStack() {
		MyStack<Integer> stack = new MyStack<>();
		assertThrows(RuntimeException.class, stack::pop);
	}

	@Test
	public void testPeekFromEmptyStack() {
		MyStack<Integer> stack = new MyStack<>();
		assertThrows(RuntimeException.class, stack::peek);
	}

	@Test
	public void testMultiplePushPop() {
		MyStack<Integer> stack = new MyStack<>();
		// Push 5 numbers
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}
		// Pop them all
		for (int i = 5; i >= 1; i--) {
			assertEquals(i, (int) stack.pop());
		}
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testPushNullElements() {
		MyStack<String> stack = new MyStack<>();
		stack.push(null);
		stack.push("NotNull");
		stack.push(null);

		assertEquals(3, stack.size());

		// Pop and verify
		assertNull(stack.pop()); // last pushed null
		assertEquals("NotNull", stack.pop());
		assertNull(stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testPushAfterEmpty() {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(100);
		stack.pop(); // stack should now be empty

		// Reuse the stack
		stack.push(200);
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals(200, (int) stack.peek());
	}

	@Test
	public void testPushSameValues() {
		MyStack<String> stack = new MyStack<>();
		stack.push("Repeat");
		stack.push("Repeat");
		stack.push("Repeat");

		assertEquals(3, stack.size());
		assertEquals("Repeat", stack.pop());
		assertEquals("Repeat", stack.pop());
		assertEquals("Repeat", stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testPopUntilEmpty() {
		MyStack<Integer> stack = new MyStack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		// Pop until empty
		for (int i = 9; i >= 0; i--) {
			assertEquals(i, (int) stack.pop());
		}
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testSizeAfterOperations() {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.size());

		stack.pop();
		assertEquals(2, stack.size());

		stack.peek(); // Should not change size
		assertEquals(2, stack.size());

		stack.pop();
		stack.pop();
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testLargeNumberOfElements() {
		MyStack<Integer> stack = new MyStack<>();
		final int largeCount = 1000000;
		for (int i = 0; i < largeCount; i++) {
			stack.push(i);
		}
		assertEquals(largeCount, stack.size());

		for (int i = largeCount - 1; i >= 0; i--) {
			int popped = stack.pop();
			assertEquals(i, popped);
		}
		assertTrue(stack.isEmpty());
	}
}
