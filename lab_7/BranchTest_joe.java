import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

public class BranchTest {


    /******************************************************************
     *
     * Test makes10
     *
     *****************************************************************/

    @Test 
    public void makes10_aIs10_bIs3() {
	run("makes10", 10, 3);
	Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs9_bIs10() {
    run("makes10", 9, 10);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs9_bIs9() {
    run("makes10", 9, 9);
    Assert.assertEquals(0, get(v0));
    }

    @Test 
    public void makes10_aIs1_bIs9() {
    run("makes10", 1, 9);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs10_bIs1() {
    run("makes10", 10, 1);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs10_bIs10() {
    run("makes10", 10, 10);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs8_bIs2() {
    run("makes10", 8, 2);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs89_bIs3() {
    run("makes10", 8, 3);
    Assert.assertEquals(0, get(v0));
    }

    @Test 
    public void makes10_aIs10_bIs42() {
    run("makes10", 10, 42);
    Assert.assertEquals(1, get(v0));
    }

    @Test 
    public void makes10_aIs12_bIsneg2() {
    run("makes10", 12, -2);
    Assert.assertEquals(1, get(v0));
    }

     @Test 
    public void makes10_aIsneg6_bIsneg8() {
    run("makes10", -6, -8);
    Assert.assertEquals(0, get(v0));
    }



    // Write more tests!


    /******************************************************************
     *
     * Test intMax
     *
     *****************************************************************/

    @Test 
    public void intMax_5_6_7() {
	run("intMax", 5, 6, 7);
	Assert.assertEquals(7, get(v0));
    }

    @Test 
    public void intMax_1_2_3() {
    run("intMax", 1, 2, 3);
    Assert.assertEquals(3, get(v0));
    }

    @Test 
    public void intMax_1_3_2() {
    run("intMax", 1, 3, 2);
    Assert.assertEquals(3, get(v0));
    }

    @Test 
    public void intMax_3_2_1() {
    run("intMax", 3, 2, 1);
    Assert.assertEquals(3, get(v0));
    }

    @Test 
    public void intMax_9_3_3() {
    run("intMax", 9, 3, 3);
    Assert.assertEquals(9, get(v0));
    }

    @Test 
    public void intMax_3_9_3() {
    run("intMax", 3, 9, 3);
    Assert.assertEquals(9, get(v0));
    }

    @Test 
    public void intMax_3_3_9() {
    run("intMax", 3, 3, 9);
    Assert.assertEquals(9, get(v0));
    }



    // Write more tests!

    /******************************************************************
     *
     * Test close10
     *
     *****************************************************************/

    @Test 
    public void close10_aClosest() {
	run("close10", 8, 13);
	Assert.assertEquals(8, get(v0));
    }

    // Write more tests!


    /******************************************************************
     *
     * Test dateFashion
     *
     *****************************************************************/

    @Test 
    public void dateFashion_youOk_dateStylish() {
	run("dateFashion", 5, 10);
	Assert.assertEquals(2, get(v0));
    }

    // Write more tests!


} // end class

