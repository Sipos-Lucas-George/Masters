import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TestDoorman {
    Doorman doorman;
    Queue<Person> queue;

    @Test
    public void testConstructorPositive() {
        doorman = new Doorman(1);
        assertEquals(doorman.getMaxDifference(), 1);
        assertEquals(doorman.getMenCount(), 0);
        assertEquals(doorman.getWomenCount(), 0);
    }

    @Test
    public void testConstructorZero() {
        try {
            doorman = new Doorman(0);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorNegative() {
        try {
            doorman = new Doorman(-1);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testLetInEmptyQueue() {
        doorman = new Doorman(1);
        queue = new LinkedList<>();
        assertEquals(doorman.letIn(queue), 0);
    }

    // testing only using a gender and not going over maxDifference
    // e.g.: M, MM, MMM
    @Test
    public void testLetInOneGenderNotOverLimit() {
        for (int g = 0; g <= 4; ++g) {
            queue = new LinkedList<>();
            for (int i = 1; i <= 100; ++i) {
                doorman = new Doorman(100);
                queue.add(new Person(chooseGender(g)));
                assertEquals(doorman.letIn(copyQueue(queue)), i);
            }
        }
    }

    // testing only using a gender and going over small maxDifference
    // e.g.: M, MM, MMM
    @Test
    public void testLetInOneGenderOverLimitSmall() {
        for (int g = 0; g <= 4; ++g) {
            queue = new LinkedList<>();
            for (int i = 1; i <= 6; ++i) {
                doorman = new Doorman(5);
                queue.add(new Person(chooseGender(g)));
                assertEquals(doorman.letIn(copyQueue(queue)), Math.min(i, 5));
            }
        }
    }

    // testing only using a gender and going over big maxDifference
    // e.g.: M, MM, MMM 
    @Test
    public void testLetInOneGenderOverLimitLarge() {
        for (int g = 0; g <= 4; ++g) {
            queue = new LinkedList<>();
            for (int i = 1; i <= 100; ++i) {
                doorman = new Doorman(99);
                queue.add(new Person(chooseGender(g)));
                assertEquals(doorman.letIn(copyQueue(queue)), Math.min(i, 99));
            }
        }
    }

    // testing mix genders and not going over small maxDifference
    // e.g.: MWMWMW...
    @Test
    public void testLetInMixGenderNotOverLimitSmall() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(1);
            for (int i = 1; i <= 5; ++i) {
                queue.add(new Person((g == 0) ? 'M' : 'm'));
                queue.add(new Person((g == 0) ? 'W' : 'w'));
            }
            assertEquals(doorman.letIn(queue), 10);
        }
    }

    // testing mix genders uppercase letter and not going over medium maxDifference
    // e.g.: WMMMMMWWWWWM...
    @Test
    public void testLetInMixGenderNotOverLimitMediumUppercase() {
        queue = new LinkedList<>();
        doorman = new Doorman(5);
        for (int i = 1; i <= 4; ++i) {
            queue.add(new Person((i % 2 == 0) ? 'M' : 'W'));
            for (int j = 1; j <= 4; ++j) {
                queue.add(new Person((i % 2 == 1) ? 'M' : 'W'));
            }
        }
        assertEquals(doorman.letIn(queue), 20);
    }

    // same as above, but with lowercase letters
    @Test
    public void testLetInMixGenderNotOverLimitMediumLowercase() {
        queue = new LinkedList<>();
        doorman = new Doorman(5);
        for (int i = 1; i <= 4; ++i) {
            queue.add(new Person((i % 2 == 0) ? 'm' : 'w'));
            for (int j = 1; j <= 4; ++j) {
                queue.add(new Person((i % 2 == 1) ? 'm' : 'w'));
            }
        }
        assertEquals(doorman.letIn(queue), 20);
    }

    // testing mix genders uppercase letter and not going over big maxDifference
    // e.g.: M(W*99), W(M*99)
    @Test
    public void testLetInMixGenderNotOverLimitLargeUppercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(98);
            queue.add(new Person((g == 0) ? 'M' : 'W'));
            for (int i = 1; i <= 99; ++i) {
                queue.add(new Person((g != 0) ? 'M' : 'W'));
            }
            assertEquals(doorman.letIn(queue), 100);
        }
    }

    // same as above, but with lowercase letters
    @Test
    public void testLetInMixGenderNotOverLimitLargeLowercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(98);
            queue.add(new Person((g == 0) ? 'm' : 'w'));
            for (int i = 1; i <= 99; ++i) {
                queue.add(new Person((g != 0) ? 'm' : 'w'));
            }
            assertEquals(doorman.letIn(queue), 100);
        }
    }

    // testing mix genders uppercase letter and going over small maxDifference
    // e.g.: MMMW, WWWM
    @Test
    public void testLetInMixGenderOverLimitSmallUppercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(1);
            for (int i = 0; i < 3; ++i) {
                queue.add(new Person((g == 0) ? 'M' : 'W'));
            }
            queue.add(new Person((g != 0) ? 'M' : 'W'));
            assertEquals(doorman.letIn(queue), 1);
        }
    }

    // same as above, but with lowercase letters
    @Test
    public void testLetInMixGenderOverLimitSmallLowercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(1);
            for (int i = 0; i < 3; ++i) {
                queue.add(new Person((g == 0) ? 'm' : 'w'));
            }
            queue.add(new Person((g != 0) ? 'm' : 'w'));
            assertEquals(doorman.letIn(queue), 1);
        }
    }

    // testing mix genders uppercase letter and going over medium maxDifference
    // e.g.: M(W*8)(M*7)... and reverse gender
    @Test
    public void testLetInMixGenderOverLimitMediumUppercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(5);
            for (int i = 1; i <= 2; ++i) {
                queue.add(new Person(((g == 0 && i % 2 == 0) || (g == 1 && i % 2 != 0)) ? 'M' : 'W'));
                for (int j = 1; j <= 7; ++j) {
                    queue.add(new Person(((g == 0 && i % 2 == 1) || (g == 1 && i % 2 != 1)) ? 'M' : 'W'));
                }
            }
            assertEquals(doorman.letIn(queue), 7);
        }
    }

    // same as above, but with lowercase letters
    @Test
    public void testLetInMixGenderOverLimitMediumLowercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(5);
            for (int i = 1; i <= 2; ++i) {
                queue.add(new Person(((g == 0 && i % 2 == 0) || (g == 1 && i % 2 != 0)) ? 'm' : 'w'));
                for (int j = 1; j <= 7; ++j) {
                    queue.add(new Person(((g == 0 && i % 2 == 1) || (g == 1 && i % 2 != 1)) ? 'm' : 'w'));
                }
            }
            assertEquals(doorman.letIn(queue), 7);
        }
    }

    // testing mix genders uppercase letter and going over large maxDifference
    // e.g.: M(W*99), W(M*99)
    @Test
    public void testLetInMixGenderOverLimitLargeUppercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(97);
            queue.add(new Person((g == 0) ? 'M' : 'W'));
            for (int i = 1; i <= 99; ++i) {
                queue.add(new Person((g != 0) ? 'M' : 'W'));
            }
            assertEquals(doorman.letIn(queue), 99);
        }
    }

    // same as above, but with lowercase letters
    @Test
    public void testLetInMixGenderOverLimitLargeLowercase() {
        for (int g = 0; g <= 1; ++g) {
            queue = new LinkedList<>();
            doorman = new Doorman(97);
            queue.add(new Person((g == 0) ? 'm' : 'w'));
            for (int i = 1; i <= 99; ++i) {
                queue.add(new Person((g != 0) ? 'm' : 'w'));
            }
            assertEquals(doorman.letIn(queue), 99);
        }
    }

    // creates a copy to queue of type <T>
    private static <T> Queue<T> copyQueue(Queue<T> originalQueue) {
        return new LinkedList<>(originalQueue);
    }

    // given a number, returns a gender with a type of case
    private char chooseGender(int i) {
        return switch (i % 4) {
            case 0 -> 'M';
            case 1 -> 'W';
            case 2 -> 'm';
            case 3 -> 'w';
            default -> ' ';
        };
    }
}
