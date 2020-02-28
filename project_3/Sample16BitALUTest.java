import org.junit.Assert;
import org.junit.Test;
import java.util.function.BiFunction;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Test cases for a signed 16-bit ALU.
 * <p>
 * IMPORTANT:  These test cases do *not* thoroughly test the circuit.  You need to
 * re-name this class and add more tests!
 * <p>
 * <p>
 * Created by kurmasz on 8/8/16.
 */
public class Sample16BitALUTest {

  public static class OpCodes {
    public static final int ADDU = 0;
    public static final int SUBU = 1;
    public static final int AND  = 2;
    public static final int OR   = 3;
    public static final int NOT  = 4;
    public static final int XOR  = 5;
    public static final int LUI  = 6;
    public static final int SLTU = 7;
    public static final int ADD  = 8;
    public static final int SUB  = 9;
    public static final int SLT  = 15;
  }

  @Test
  public void testAddu() {
    setPinUnsigned("InputA", 53400);
    setPinUnsigned("InputB", 53500);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (53400 + 53500) % 65536, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu_a_Zero() {
    setPinUnsigned("InputA", 0);
    setPinUnsigned("InputB", 77);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (0 + 77) % 65536, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu_b_Zero() {
    setPinUnsigned("InputA", 77);
    setPinUnsigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (0 + 77) % 65536, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void test_Subu() {
    setPinUnsigned("InputA", 65535);
    setPinUnsigned("InputB", 101);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Addition Output", (65535 - 101), readPinUnsigned("Output"));

    // Overflow for unsigned subtraction is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void test_Subu_Roll_Over() {
    setPinUnsigned("InputA", 1);
    setPinUnsigned("InputB", 2);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Addition Output", 65535 , readPinUnsigned("Output"));

    // Overflow for unsigned subtraction is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void test_Subu_Zero() {
    setPinUnsigned("InputA", 77);
    setPinUnsigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Addition Output", 77, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddition() {
    setPinSigned("InputA", 23);
    setPinSigned("InputB", 44);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 23 + 44, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

@Test
  public void testAddition_Neg_Pos() {
    setPinSigned("InputA", -77);
    setPinSigned("InputB", 777);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", -77 + 777, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }


@Test
  public void testAddition_Pos_Neg() {
    setPinSigned("InputA", 77);
    setPinSigned("InputB", -777);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 77 + -777, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

@Test
  public void testAddition_Neg_Neg() {
    setPinSigned("InputA", -77);
    setPinSigned("InputB", -777);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", -77 + -777, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

@Test
  public void testAddition_Pos_Zero() {
    setPinSigned("InputA", 77);
    setPinSigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 77 + 0, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

@Test
  public void testAddition_OverFlow() {
    setPinSigned("InputA", 32000);
    setPinSigned("InputB", 777);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", -32759, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", true, readPin("Overflow"));
  }

  @Test
  public void testSubtraction() {
    setPinSigned("InputA", 24);
    setPinSigned("InputB", 45);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", 24 - 45, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

 @Test
  public void testSubtraction_Pos_Neg() {
    setPinSigned("InputA", 77);
    setPinSigned("InputB", -33);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", 77 - -33, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

 @Test
  public void testSubtraction_Neg_Pos() {
    setPinSigned("InputA", -77);
    setPinSigned("InputB", 33);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", -77 - 33, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

 @Test
  public void testSubtraction_Neg_Neg() {
    setPinSigned("InputA", -77);
    setPinSigned("InputB", -33);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", -77 - -33, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

@Test
  public void testSubtraction_Neg_Zero() {
    setPinSigned("InputA", -77);
    setPinSigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", -77 - 0, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

@Test
  public void testSubtraction_OverFlow() {
    setPinSigned("InputA", -32767);
    setPinSigned("InputB", 77);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", 32692, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", true, readPin("Overflow"));
  }

  @Test
  public void ltSigned() {
    setPinSigned("InputA", 5);
    setPinSigned("InputB", 6);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    Assert.assertEquals("Signed Less Than Output", 1, readPinSigned("Output"));
    Assert.assertEquals("Signed Less Than Overflow", false, readPin("Overflow"));
  }

  @Test
  public void ltSigned2() {
    setPinSigned("InputA", 32767);
    setPinSigned("InputB", -1);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    Assert.assertEquals("Signed Less Than Output", 0, readPinSigned("Output"));
    Assert.assertEquals("Signed Less Than Overflow", false, readPin("Overflow"));
  }


  public static void verifySigned(long a, long b, boolean checkOverflow) {
    long expected = (a < b) ? 1 : 0;

    setPinSigned("InputA", a);
    setPinSigned("InputB", b);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    String message = String.format(" of %d < %d (signed) ", a, b);
    Assert.assertEquals("Output" + message, expected, readPinUnsigned("Output"));
    if (checkOverflow) {
      Assert.assertEquals("Overflow" + message, false, readPin("Overflow"));
    }
  }


  @Test
  public void ltSigned_allPairs() {
    long[] values = {-32768, -32767, -1, 0, 1, 32766, 32767};
    for (long a : values) {
      for (long b : values) {
        verifySigned(a, b, true);
      }
    }
  }

  public static void verifyUnsigned(long a, long b, boolean checkOverflow) {
    long expected = (a < b) ? 1 : 0;

    setPinUnsigned("InputA", a);
    setPinUnsigned("InputB", b);
    setPinUnsigned("Op", OpCodes.SLTU);
    run();
    String message = String.format(" of %d < %d (unsigned) ", a, b);
    Assert.assertEquals("Output" + message, expected, readPinUnsigned("Output"));
    if (checkOverflow) {
      Assert.assertEquals("Overflow" + message, false, readPin("Overflow"));
    }
  }

  @Test
  public void ltUnsigned_allPairs() {
    long[] values = {0, 1, 2, 65534, 65535};
    for (long a : values) {
      for (long b : values) {
        verifyUnsigned(a, b, true);
      }
    }
  }

  private void verifyLogic(String name, int op, long a, long b, BiFunction<Long, Long, Long> func) {
    setPinUnsigned("InputA", a);
    setPinUnsigned("InputB", b);
    setPinUnsigned("Op", op);
    run();
    String message = String.format("0x%x %s 0x%x", a, name, b);
    Assert.assertEquals(message, (long)func.apply(a, b), readPinUnsigned("Output"));
    Assert.assertFalse(message + " overflow", readPin("Overflow"));
  }

  @Test
  public void testAnd() {
    verifyLogic("and", OpCodes.AND, 0xFF00, 0x0F0F, (a, b) -> a & b);
  }
  @Test
  public void testOr() {
    verifyLogic("or", OpCodes.OR, 0xFF00, 0x0F0F, (a, b) -> a | b);
  }

  @Test
   public void testXor() {
    setPinUnsigned("InputA", 7777);
    setPinUnsigned("InputB", 77);
    setPinUnsigned("Op", OpCodes.XOR);
    run();
    Assert.assertEquals("XOR Output", 7724, readPinSigned("Output"));
    Assert.assertEquals("XOR Overflow", false, readPin("Overflow"));
   }

   @Test
    public void testNot() {
     setPinUnsigned("InputA", 7777);
     setPinUnsigned("Op", OpCodes.NOT);
     run();
     Assert.assertEquals("NOT Output", -7778, readPinSigned("Output"));
     Assert.assertEquals("NOT Overflow", false, readPin("Overflow"));
    }

    @Test
     public void testLUI() {
      setPinUnsigned("InputA", 7777);
      setPinUnsigned("Op", OpCodes.LUI);
      run();
      Assert.assertEquals("LUI Output", 24832, readPinSigned("Output"));
      Assert.assertEquals("LUI Overflow", false, readPin("Overflow"));
     }



}
