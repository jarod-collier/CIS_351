import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;


/**
* Jarod Collier and Josef Hartsough
*/
public class nCk {

    @Before
    public void before() {
        set(v0, 1337);
    }

    /******************************************************************
     *
     * Test makes10
     *
     *****************************************************************/

    @Test
    public void nCk_5_3() {
        run("nCk", 5, 3);
        Assert.assertEquals(10, get(v0));
    }

    @Test
    public void nCk_100_4() {
        run("nCk", 100, 4);
        Assert.assertEquals(3921225, get(v0));
    }

    @Test
    public void nCk_100_3() {
        run("nCk", 100, 3);
        Assert.assertEquals(161700, get(v0));
    }

    @Test
    public void nCk_150_3() {
        run("nCk", 150, 3);
        Assert.assertEquals(551300, get(v0));
    }

    @Test
    public void nCk_50_4() {
        run("nCk", 50, 4);
        Assert.assertEquals(230300, get(v0));
    }

    @Test
    public void nCk_50_2() {
        run("nCk", 50, 2);
        Assert.assertEquals(1225, get(v0));
    }

    // return 1 testers
    @Test
    public void nCk_nEqualk1() {
        run("nCk", 100, 100);
        Assert.assertEquals(1, get(v0));
    }

    @Test
    public void nCk_nEqualk2() {
        run("nCk", 5000, 5000);
        Assert.assertEquals(1, get(v0));
    }

    @Test
    public void nCk_nchoose1First() {
        run("nCk", 100, 1);
        Assert.assertEquals(100, get(v0));
    }

    @Test
    public void nCk_nchoose1Second() {
        run("nCk", 2, 1);
        Assert.assertEquals(2, get(v0));
    }

    @Test
    public void nCk_nchoose0First() {
        run("nCk", 100, 0);
        Assert.assertEquals(1, get(v0));
    }

    @Test
    public void nCk_nchoose0Second() {
        run("nCk", 2, 0);
        Assert.assertEquals(1, get(v0));
    }

    @Test
    public void nCk_nchoose0Third() {
        run("nCk", 0, 0);
        Assert.assertEquals(1, get(v0));
    }

    // return -1 testers
    @Test
    public void nCk_nLessThan0First() {
        run("nCk", -1, -1);
        Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void nCk_nLessThan0Second() {
        run("nCk", -1, 5);
        Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void nCk_kLessThan0First() {
        run("nCk", 3, -1);
        Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void nCk_kLessThan0Second() {
        run("nCk", 10, -10);
        Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void nCk_nLessThanK1() {
        run("nCk", 1, 2);
        Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void nCk_nLessThanK2() {
        run("nCk", 100, 200);
        Assert.assertEquals(-1, get(v0));
    }

} // end class
