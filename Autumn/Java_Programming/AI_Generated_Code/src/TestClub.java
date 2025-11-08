import static org.junit.Assert.*;

import org.junit.Test;

import java.util.stream.Collectors;

public class TestClub {
    Club club;

    // test the input with maxDifference length = 1
    // also ensure getters work accordingly
    @Test
    public void testGettersSmall() {
        club = new Club("1," + constructQueueString(0, 4, 1));
        assertEquals(club.getMaxDifference(), 1);
        for (int i = 0; i < 4; ++i) {
            assertEquals(club.getQueue().poll().getGender(), (i % 2 == 0) ? Gender.MALE : Gender.FEMALE);
        }
    }

    // test the input with maxDifference length = 2
    // also ensure getters work accordingly
    @Test
    public void testGettersMedium() {
        club = new Club("10," + constructQueueString(0, 10, 1));
        assertEquals(club.getMaxDifference(), 10);
        for (int i = 0; i < 10; ++i) {
            assertEquals(club.getQueue().poll().getGender(), (i % 2 == 0) ? Gender.MALE : Gender.FEMALE);
        }
    }

    // test the input with maxDifference length = 3
    // also ensure getters work accordingly
    @Test
    public void testGettersLarge() {
        club = new Club("100," + constructQueueString(0, 100, 1));
        assertEquals(club.getMaxDifference(), 100);
        for (int i = 0; i < 100; ++i) {
            assertEquals(club.getQueue().poll().getGender(), (i % 2 == 0) ? Gender.MALE : Gender.FEMALE);
        }
    }

    @Test
    public void testConstructorEmpty() {
        try {
            club = new Club("");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorEmptyAbsoluteDifference() {
        try {
            club = new Club(",WWMM");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorEmptyQueueLine() {
        try {
            club = new Club("1,");
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            fail("It can have an empty queue line");
        }
    }

    @Test
    public void testConstructorEmptyButSpace() {
        try {
            club = new Club("            ");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorEmptyAbsoluteDifferenceButSpace() {
        try {
            club = new Club("          ,WWMM");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorEmptyQueueLineButSpace() {
        try {
            club = new Club("1,                 ");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorWrongQueueLine() {
        try {
            club = new Club("1,WwvmM");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorNegativeAbsoluteDifference() {
        try {
            club = new Club("-1,W");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorZeroAbsoluteDifference() {
        try {
            club = new Club("0,W");
            fail("There should be an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorPositiveAbsoluteDifference() {
        try {
            club = new Club("1,W");
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            fail("It should have been valid input");
        }
    }

    @Test
    public void testConstructorQueueLineUppercase() {
        try {
            club = new Club("1,WMW");
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            fail("It should have been valid input");
        }
    }

    @Test
    public void testConstructorQueueLineLowercase() {
        try {
            club = new Club("1,wmw");
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            fail("It should have been valid input");
        }
    }

    @Test
    public void testConstructorQueueLineMixCase() {
        try {
            club = new Club("1,WmWMwm");
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            fail("It should have been valid input");
        }
    }

    // test letIn, not over maxDifference, for every gender and letter case separately
    // e.g.: M,W,m,w
    @Test
    public void testLetInNotOverLimitSmall() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("1," + chooseGender(i));
            assertEquals(club.getMaxPeopleLetIn(), 1);
        }
    }

    // test letIn, not over maxDifference, for a mix queue and mix letter case
    // e.g.: (M*4)(W*4)(m*4)(w*4) and cycles of this with shift 4
    @Test
    public void testLetInNotOverLimitLarge() {
        for (int i = 0; i <= 3; ++i) {
            club = new Club("4," + constructQueueString(i * 4, 16 + i * 4, 4));
            assertEquals(club.getMaxPeopleLetIn(), 16);
        }
    }

    // test letIn, small queue, over maxDifference from start, for a mix queue and mix letter case
    // e.g.: Mm, Ww, mM, wW
    @Test
    public void testLetInOverLimitSmallStartError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("1," + chooseGender(i) + chooseGender(i + 2));
            assertEquals(club.getMaxPeopleLetIn(), 1);
        }
    }

    // test letIn, large queue, over maxDifference from start, for a mix queue and mix letter case
    // e.g.: (M*2)(M*4)(W*4)(m*4)(w*4)
    @Test
    public void testLetInOverLimitLargeStartError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("4,"
                    + constructQueueString(i * 4, i * 4 + 2, 4)
                    + constructQueueString(i * 4, (i + 1) * 4 + 64, 4));
            assertEquals(club.getMaxPeopleLetIn(), 4);
        }
    }

    // test letIn, small queue, over maxDifference from middle, for a mix queue and mix letter case
    // e.g.: MWmwMMMWWmmwwMMWWmmww
    @Test
    public void testLetInOverLimitSmallMidError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("1,"
                    + constructQueueString(0, 4 + i + 1, 1)
                    + constructQueueString(i * (2 + i % 2), 16, 2 + i % 2));
            assertEquals(club.getMaxPeopleLetIn(), 4 + i + 1 + i % 2);
        }
    }

    // test letIn, big queue, over maxDifference from middle, for a mix queue and mix letter case
    // e.g.: MWmwMMMMMMMWWWWWWm...
    @Test
    public void testLetInOverLimitLargeMidError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("4,"
                    + constructQueueString(0, 4 + i + 1, 1)
                    + constructQueueString(i * (6 + i % 2), i * (6 + i % 2) + 64 - i, 6 + i % 2));
            assertEquals(club.getMaxPeopleLetIn(), 2 * 4 + i + i % 2);
        }
    }

    // test letIn, big queue, over maxDifference at the end, for a mix queue and mix letter case
    // e.g.: ends with MM, WW, mm, ww
    @Test
    public void testLetInOverLimitSmallEndError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("1,"
                    + constructQueueString(i % 2, 1 + i % 2, 1)
                    + constructQueueString(i + 1, 96 + i + 1, 1)
                    + chooseGender(i));
            assertEquals(club.getMaxPeopleLetIn(), 99);
        }
    }

    // test letIn, big queue, over maxDifference at the end, for a mix queue and mix letter case
    // e.g.: ends with (M*12)
    @Test
    public void testLetInOverLimitLargeEndError() {
        for (int i = 0; i < 4; ++i) {
            club = new Club("11,"
                    + constructQueueString(i % 2 * 11, 88 + i % 2 * 11, 11)
                    + constructQueueString(i * 12, i * 12 + 12, 12));
            assertEquals(club.getMaxPeopleLetIn(), 99);
        }
    }

    @Test
    public void testLetInSkipCaseStart() {
        String s = "mMMmmMWwwwwwWWwWWwMmMm";
        for (int i = 0; i < 4; ++i) {
            club = new Club("5," + modifyQueue(s, i));
            assertEquals(club.getMaxPeopleLetIn(), s.length());
        }
    }

    @Test
    public void testLetInSkipCaseEnd() {
        String s = "MmMMWwMwwMMmwwWwWm".repeat(5) + "wMmwWWwwWM";
        for (int i = 0; i < 4; ++i) {
            club = new Club("4," + modifyQueue(s, i));
            assertEquals(club.getMaxPeopleLetIn(), s.length());
        }
    }

    // construct a queue string which starts at a value 'start', ends at 'end'
    // and repeats the same character/gender every 'repeat' times
    private String constructQueueString(int start, int end, int repeat) {
        StringBuilder s = new StringBuilder();
        for (int i = start; i < end; ++i) {
            s.append(chooseGender(i / repeat));
        }
        return s.toString();
    }

    // given a number, returns a gender with a type of case
    private String chooseGender(int i) {
        return switch (i % 4) {
            case 0 -> "M";
            case 1 -> "W";
            case 2 -> "m";
            case 3 -> "w";
            default -> "";
        };
    }

    // return a different combination depending on type
    // 0 = string, 1 = change letter case
    // 2 = swap letters, case-sensitive, 3 = 1 + 2
    private String modifyQueue(String s, int type) {
        if (type == 0) return s;
        if (type == 1 || type == 3) {
            s = s.chars()
                    .mapToObj(c -> Character.toString((Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c)))
                    .collect(Collectors.joining());
        }
        if (type == 2 || type == 3) {
            s = s.chars()
                    .mapToObj(c -> "" + ((Character.toLowerCase(c) == 'm') ? (char) (c + 10) : (char) (c - 10)))
                    .collect(Collectors.joining());
        }
        return s;
    }
}
