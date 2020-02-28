import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

/**
* Jarod Collier and Josef Hartsough
*/
public class LoopTest {


    /******************************************************************
     *
     * Test indexOf
     *
     ******************************************************************/

    Label array1 = wordData(5, 4, 10, 7, 6, 9, 8, 2, 1, 10, -1);

    @Test
    public void indexOf_findsValueOccurringOnceOnly() {
	run("indexOf", 2, array1);
	Assert.assertEquals(7, get(v0));
    }

    @Test
    public void indexOf_returns_neg1_ifNotFound() {
	run("indexOf", 3, array1);
	Assert.assertEquals(-1, get(v0));
    }

    @Test
    public void indexOf_Foundtwice() {
	run("indexOf", 10, array1);
	Assert.assertEquals(2, get(v0));
    }

    @Test
    public void indexOf_first() {
	run("indexOf", 5, array1);
	Assert.assertEquals(0, get(v0));
    }
    // Write more tests.  Your tests shouldn't all use array1.

    /******************************************************************
     *
     * Test max
     *
     ******************************************************************/

    Label array3 = wordData(5, 4, 10, 7, 6, 9, 8, 2, 1, 10, -1);

    @Test
    public void max_findsMaximum() {
	run("max", array3, 11);
	Assert.assertEquals(10, get(v0));
    }

    // Write **a lot** more tests.


    /******************************************************************
     *
     * Test sum13
     *
     ******************************************************************/

    Label sum13_array1 = wordData(1, 2, 2, 1);
    Label sum13_array2 = wordData(1, 2, 13, 2, 1, 13);

    @Test
    public void sum13_sumsAllIfNo13() {
	run("sum13", sum13_array1, 4);
	Assert.assertEquals(6, get(v0));
    }

    @Test
    public void sum13_ignore13_andFollowing() {
	run("sum13", sum13_array2, 6);
	Assert.assertEquals(4, get(v0));
    }

    Label sum13_array3 = wordData(1,1);

    @Test
    public void sum13_1() {
	run("sum13", sum13_array3, 2);
	Assert.assertEquals(2, get(v0));
    }

    Label sum13_array4 = wordData(1, 2, 2, 1, 13);

    @Test
    public void sum13_2() {
	run("sum13", sum13_array4, 5);
	Assert.assertEquals(6, get(v0));
    }

    Label sum13_array5 = wordData(13, 1, 2, 13, 2, 1, 13);

    @Test
    public void sum13_3() {
	run("sum13", sum13_array5, 7);
	Assert.assertEquals(3, get(v0));
    }

    Label sum13_array6 = wordData();

    @Test
    public void sum13_4() {
	run("sum13", sum13_array6, 0);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array7 = wordData(13);

    @Test
    public void sum13_5() {
	run("sum13", sum13_array7, 1);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array8 = wordData(13, 13);

    @Test
    public void sum13_6() {
	run("sum13", sum13_array8, 2);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array9 = wordData(13,0,13);

    @Test
    public void sum13_7() {
	run("sum13", sum13_array9, 3);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array10 = wordData(13,1,13);

    @Test
    public void sum13_8() {
	run("sum13", sum13_array10, 3);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array11 = wordData(5,7,2);

    @Test
    public void sum13_9() {
    run("sum13", sum13_array11, 3);
    Assert.assertEquals(14, get(v0));
    }

    Label sum13_array12 = wordData(5,13,2);

    @Test
    public void sum13_10() {
	run("sum13", sum13_array12, 3);
	Assert.assertEquals(5, get(v0));
    }

    Label sum13_array13 = wordData(0);

    @Test
    public void sum13_11() {
	run("sum13", sum13_array13, 1);
	Assert.assertEquals(0, get(v0));
    }

    Label sum13_array14 = wordData(13,0);

    @Test
    public void sum13_12() {
	run("sum13", sum13_array14, 2);
	Assert.assertEquals(0, get(v0));
    }
    // Write **a lot** more tests.

    /******************************************************************
     *
     * Test sum67
     *
     ******************************************************************/

    Label sum67_array1 = wordData(14, 6, 2, 3, 4, 7, 9, 10);

    @Test
    public void sum67_1() {
	run("sum67", sum67_array1, 8);
	Assert.assertEquals(33, get(v0));
    }

    Label sum67_array2 = wordData(1,2,2);

    @Test
    public void sum67_2() {
	run("sum67", sum67_array2, 3);
	Assert.assertEquals(5, get(v0));
    }

    Label sum67_array3 = wordData(1,2,2,6,99,99,7);

    @Test
    public void sum67_3() {
	run("sum67", sum67_array3, 7);
	Assert.assertEquals(5, get(v0));
    }

    Label sum67_array4 = wordData(1,1,6,7,2);

    @Test
    public void sum67_4() {
	run("sum67", sum67_array4, 5);
	Assert.assertEquals(4, get(v0));
    }

    Label sum67_array5 = wordData(1,6,2,2,7,1,6,99,99,7);

    @Test
    public void sum67_5() {
	run("sum67", sum67_array5, 10);
	Assert.assertEquals(2, get(v0));
    }

    Label sum67_array6 = wordData(1,6,2,6,2,7,1,6,99,99,7);

    @Test
    public void sum67_6() {
    run("sum67", sum67_array6, 11);
    Assert.assertEquals(2, get(v0));
    }

    Label sum67_array7 = wordData(2,7,6,2,6,7,2,7);

    @Test
    public void sum67_7() {
    run("sum67", sum67_array7, 8);
    Assert.assertEquals(18, get(v0));
    }

    Label sum67_array8 = wordData(2,7,6,2,6,2,7);

    @Test
    public void sum67_8() {
    run("sum67", sum67_array8, 7);
    Assert.assertEquals(9, get(v0));
    }

    Label sum67_array9 = wordData(1,6,7,7);

    @Test
    public void sum67_9() {
    run("sum67", sum67_array9, 4);
    Assert.assertEquals(8, get(v0));
    }

    Label sum67_array10 = wordData(6,7,1,6,7,7);

    @Test
    public void sum67_10() {
    run("sum67", sum67_array10, 6);
    Assert.assertEquals(8, get(v0));
    }

    Label sum67_array11 = wordData(6,8,1,6,7);

    @Test
    public void sum67_11() {
    run("sum67", sum67_array11, 5);
    Assert.assertEquals(0, get(v0));
    }

    Label sum67_array12 = wordData();

    @Test
    public void sum67_12() {
    run("sum67", sum67_array12, 0);
    Assert.assertEquals(0, get(v0));
    }

    Label sum67_array13 = wordData(6,7,11);

    @Test
    public void sum67_13() {
    run("sum67", sum67_array13, 3);
    Assert.assertEquals(11, get(v0));
    }

    Label sum67_array14 = wordData(11,6,7,11);

    @Test
    public void sum67_14() {
    run("sum67", sum67_array14, 4);
    Assert.assertEquals(22, get(v0));
    }

    Label sum67_array15 = wordData(2,2,6,7,7);

    @Test
    public void sum67_15() {
    run("sum67", sum67_array15, 5);
    Assert.assertEquals(11, get(v0));
    }



    // Write **a lot** more tests

}
