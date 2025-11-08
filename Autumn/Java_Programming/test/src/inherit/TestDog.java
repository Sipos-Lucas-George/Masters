package inherit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDog {
    private Dog dog;

    @Before
    public void setUp() {
        dog = new Dog(2, 200, Dog.types.GUNDOG, "Hot dog");
    }

    @Test
    public void testDog() {
        assertEquals("Hot dog", dog.getBreed());
    }
}
