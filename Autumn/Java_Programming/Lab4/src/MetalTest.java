import static org.junit.Assert.*;

import org.junit.Test;

public class MetalTest {
    @Test
    public void testConstructor() {
        Metal m = new Metal(100, Metal.types.GOLD);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Metal(-1, Metal.types.LEAD));
        assertNotNull(e.getMessage());

        try {
            m = new Metal(-1, Metal.types.LEAD);
            fail("Constructor permitted negative mass");
        } catch (IllegalArgumentException ex) {
            assertNotNull(ex.getMessage());
        } catch (Exception ex) {
            fail("Some other error happened");
        }
    }

    @Test
    public void testGetValue() {
        double solution = 4875;
        Metal m = new Metal(100, Metal.types.GOLD);
        assertEquals(solution, m.getValue(), 0.0);

        solution = 30;
        m = new Metal(1000, Metal.types.TIN);
        assertEquals(solution, m.getValue(), 0.0);

        solution = 0.1;
        m = new Metal(10, Metal.types.LEAD);
        assertEquals(solution, m.getValue(), 0.0);
    }

    @Test
    public void testToString() {
        String s = "Metal: Gold, Mass: 100, Value: 4875.0, Purity: 1.0";
        Metal m = new Metal(100, Metal.types.GOLD);
        assertEquals(s, m.toString());

        s = "Metal: Tin, Mass: 1000, Value: 30.0, Purity: 1.0";
        m = new Metal(1000, Metal.types.TIN);
        assertEquals(s, m.toString());

        s = "Metal: Lead, Mass: 10, Value: 0.1, Purity: 1.0";
        m = new Metal(10, Metal.types.LEAD);
        assertEquals(s, m.toString());
    }

    @Test
    public void testMixWithSame() {
        Metal m = new Metal(100, Metal.types.GOLD);
        Metal n = new Metal(100, Metal.types.TIN);
        Metal p = new Metal(100, Metal.types.LEAD);

        m.mixWith(m);
        n.mixWith(n);
        p.mixWith(p);

        assertEquals(200, m.getMass());
        assertEquals(Metal.types.GOLD, m.getType());

        assertEquals(200, n.getMass());
        assertEquals(Metal.types.TIN, n.getType());

        assertEquals(200, p.getMass());
        assertEquals(Metal.types.LEAD, p.getType());
    }

    @Test
    public void testMakeGold() {
        Metal n = new Metal(100, Metal.types.TIN);
        Metal p = new Metal(100, Metal.types.LEAD);

        n.mixWith(p);

        assertEquals(200, n.getMass());
        assertEquals(Metal.types.GOLD, n.getType());
        assertEquals(1, n.getPurity(), 0.0);

        n = new Metal(100, Metal.types.TIN);
        p = new Metal(100, Metal.types.LEAD);

        p.mixWith(n);

        assertEquals(200, p.getMass());
        assertEquals(Metal.types.GOLD, p.getType());
        assertEquals(1, p.getPurity(), 0.0);
    }

    @Test
    public void testDiluteGold() {
        Metal m = new Metal(100, Metal.types.GOLD);
        Metal n = new Metal(100, Metal.types.TIN);
        Metal p = new Metal(400, Metal.types.LEAD);

        m.mixWith(n);
        assertEquals(200, m.getMass());
        assertEquals(Metal.types.GOLD, m.getType());
        assertEquals(0.5, m.getPurity(), 0.0);

        m = new Metal(100, Metal.types.GOLD);
        m.mixWith(p);
        assertEquals(500, m.getMass());
        assertEquals(Metal.types.LEAD, m.getType());
        assertEquals(1, p.getPurity(), 0.0);

        m = new Metal(100, Metal.types.GOLD);
        n = new Metal(100, Metal.types.TIN);
        p = new Metal(400, Metal.types.LEAD);

        n.mixWith(m);
        assertEquals(200, n.getMass());
        assertEquals(0.5, n.getPurity(), 0.0);
        assertEquals(Metal.types.GOLD, n.getType());

        p.mixWith(m);
        assertEquals(500, p.getMass());
        assertEquals(Metal.types.LEAD, p.getType());
        assertEquals(0.8, p.getPurity(), 0.0);
    }

}