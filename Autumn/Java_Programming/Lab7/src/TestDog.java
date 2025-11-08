import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestDog {
    private Dog dog;

    @BeforeEach
    public void setUp() {
        dog = new Dog(2, 200, Dog.types.GUNDOG, "Hot dog");
    }

    @Test
    public void testDog() {
        assertEquals("Hot dog", dog.getBreed());
    }
}
