import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

/**
* Tested by Jarod Collier and Josef Hartsough
*/
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

    @Test
    public void intMax_8_2_3() {
    	run("intMax", 8, 2, 3);
    	Assert.assertEquals(8, get(v0));
    }

    @Test
    public void intMax_neg3_neg1_neg2() {
    	run("intMax", -3, -1, -2);
    	Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void intMax_6_2_5() {
    	run("intMax", 6, 2, 5);
    	Assert.assertEquals(6, get(v0));
    }

    @Test
    public void intMax_5_6_2() {
    	run("intMax", 5, 6, 2);
    	Assert.assertEquals(6, get(v0));
    }

    @Test
    public void intMax_5_2_6() {
    	run("intMax", 5, 2, 6);
    	Assert.assertEquals(6, get(v0));
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

    @Test
    public void close10_a_13_b_8() {
    	run("close10", 13, 8);
    	Assert.assertEquals(8, get(v0));
    }

    @Test
    public void close10_a_13_b_7() {
    	run("close10", 13, 7);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void close10_a_7_b_13() {
    	run("close10", 7, 13);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void close10_a_9_b_13() {
    	run("close10", 9, 13);
    	Assert.assertEquals(9, get(v0));
    }

    @Test
    public void close10_a_10_b_12() {
    	run("close10", 10, 12);
    	Assert.assertEquals(10, get(v0));
    }

    @Test
    public void close10_a_11_b_10() {
    	run("close10", 11, 10);
    	Assert.assertEquals(10, get(v0));
    }

    @Test
    public void close10_a_5_b_21() {
    	run("close10", 5, 21);
    	Assert.assertEquals(5, get(v0));
    }

    @Test
    public void close10_a_0_b_20() {
    	run("close10", 0, 20);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void close10_a_10_b_10() {
    	run("close10", 10, 10);
    	Assert.assertEquals(0, get(v0));
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

    @Test
    public void dateFashion_you_5_date_2() {
    	run("dateFashion", 5, 2);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void dateFashion_you_5_date_5() {
    	run("dateFashion", 5, 5);
    	Assert.assertEquals(1, get(v0));
    }

    @Test
    public void dateFashion_you_3_date_3() {
    	run("dateFashion", 3, 3);
    	Assert.assertEquals(1, get(v0));
    }

    @Test
    public void dateFashion_you_10_date_2() {
    	run("dateFashion", 10, 2);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void dateFashion_you_2_date_9() {
    	run("dateFashion", 2, 9);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void dateFashion_you_9_date_9() {
    	run("dateFashion", 9, 9);
    	Assert.assertEquals(2, get(v0));
    }

    @Test
    public void dateFashion_you_10_date_5() {
    	run("dateFashion", 10, 5);
    	Assert.assertEquals(2, get(v0));
    }

    @Test
    public void dateFashion_you_2_date_2() {
    	run("dateFashion", 2, 2);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void dateFashion_you_3_date_7() {
    	run("dateFashion", 3, 7);
    	Assert.assertEquals(1, get(v0));
    }

    @Test
    public void dateFashion_you_2_date_7() {
    	run("dateFashion", 2, 7);
    	Assert.assertEquals(0, get(v0));
    }

    @Test
    public void dateFashion_you_6_date_2() {
    	run("dateFashion", 6, 2);
    	Assert.assertEquals(0, get(v0));
    }

    // Write more tests!


} // end class
