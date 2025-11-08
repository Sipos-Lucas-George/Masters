import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestsQuestionTwo {

	@Test
	public void testInterface() {

		try {
			Method m = Stringifier.class.getDeclaredMethod("stringify", Object[].class);
		} catch (NoSuchMethodException e) {
			fail("interface method incorrectly declared");
		} catch (SecurityException e) {
			// should never happen, but just in case:
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testException() {
		assertTrue(new StringifyException() instanceof Throwable);
	}
	
	@Test
	public void testConcatenate() throws Throwable {
		Main m = new Main();
		Stringifier c = m.getConcatenate();
		
		Object [] array = {Double.valueOf(1), Integer.valueOf(2), Float.valueOf(3), "4"};
		
		String output = c.stringify(array).get(0);
		assertEquals("1.0 2 3.0 4.", output);
	}
	
	@Test
	public void testTranslator() throws Throwable {
		Main m = new Main();
		Stringifier t = m.getTranslator();
		
		Object [] array = {"1 + 1 = 2"};
		
		String output = t.stringify(array).get(0);
		assertEquals("one plus one equals two", output);
		
		array[0] = "2 x 3 + 1 = 7";
		output = t.stringify(array).get(0);
		assertEquals("two times three plus one equals seven", output);
		
		Object [] array2 = {"1 + 1 = 2", "2 x 3 + 1 = 7"};
		ArrayList<String> a = t.stringify(array2);
		
		assertEquals("one plus one equals two", a.get(0));
		assertEquals("two times three plus one equals seven", a.get(1));
	}
	
	@Test
	public void testSumUp() throws Throwable {
		Main m = new Main();
		Stringifier s = m.getSumUp();
		
		Object [] arrayStrings = {"this", "is", "an", "array", "of", "Strings"};
		ArrayList<String> output = s.stringify(arrayStrings);
		
		assertEquals(1, output.size());
		assertEquals("this is an array of Strings.", output.get(0));
		
		Object [] arrayNumbers = {Double.valueOf(1), Double.valueOf(2), Integer.valueOf(3)};
		output = s.stringify(arrayNumbers);
		
		assertEquals(1, output.size());
		assertEquals("6.0", output.get(0));
		
		Object [] arrayError = {"one", Integer.valueOf(1)};
		try {
			s.stringify(arrayError);
			fail("SumUp allowed incorrect input");
		} catch (Exception ex) {
			//do nothing
		}
	}
	
	@Test
	public void testReverser() throws Throwable {
		Main m = new Main();
		Stringifier r = m.getReverser();
		
		Object [] returnTrue = {Integer.valueOf(1), "6", Integer.valueOf(1)};
		ArrayList<String> output = r.stringify(returnTrue);
		
		assertEquals(1, output.size());
		assertEquals("true", output.get(0));
		
		Object [] returnFalse = {"A", "B", "C"};
		output = r.stringify(returnFalse);
		
		assertEquals(1, output.size());
		assertEquals("false", output.get(0));
	}

}
