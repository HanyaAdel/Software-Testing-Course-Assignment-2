import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {
    Question1 question1;

    @BeforeEach
    public void init (){
        question1 = new Question1();

    }
    @Nested
    public class TestEven{
        @Test
        public void isTwoEven () {
            question1.getParity(2);
            Assertions.assertEquals("even", question1.getParity(2));
        }
        @Test
        public void isZeroEven () {
            question1.getParity(0);
            Assertions.assertEquals("even", question1.getParity(0));
        }
        @Test
        public void isSixEven () {
            question1.getParity(6);
            Assertions.assertEquals("even", question1.getParity(6));
        }
        @Test
        public void is1000Even () {
            question1.getParity(1000);
            Assertions.assertEquals("even", question1.getParity(1000));
        }
    }

    @Nested
    public class TestOdd{
        @Test
        public void isOneOdd () {
            question1.getParity(1);
            Assertions.assertEquals("odd", question1.getParity(1));
        }
        @Test
        public void is9Odd () {
            question1.getParity(9);
            Assertions.assertEquals("odd", question1.getParity(9));
        }
        @Test
        public void is7Odd () {
            question1.getParity(7);
            Assertions.assertEquals("odd", question1.getParity(7));
        }
        @Test
        public void is1001Odd () {
            question1.getParity(1001);
            Assertions.assertEquals("odd", question1.getParity(1001));
        }
    }

    @Nested
    public class TestMax{
        @Test
        public void ex1(){
            int[] a = new int[]{1, 2, 3, -6, 10, 899};
            question1.getMax(a);
            Assertions.assertEquals(899, question1.getMax(a));
        }
        @Test
        public void ex2(){
            int[] a = new int[]{1, 2, 3, -6, 10, -899};
            question1.getMax(a);
            Assertions.assertEquals(10, question1.getMax(a));
        }
        @Test
        public void ex3(){
            int[] a = new int[]{-6, -10, -899};
            question1.getMax(a);
            Assertions.assertEquals(-6, question1.getMax(a));
        }
    }
    @Nested
    public class TestMin{
        @Test
        public void ex1(){
            int[] a = new int[]{1, 2, 3, -6, 10, 899};
            question1.getMax(a);
            Assertions.assertEquals(-6, question1.getMin(a));
        }
        @Test
        public void ex2(){
            int[] a = new int[]{1, 2, 3, -6, 10, -899};
            question1.getMax(a);
            Assertions.assertEquals(-899, question1.getMin(a));
        }
        @Test
        public void ex3(){
            int[] a = new int[]{10,100,89};
            question1.getMax(a);
            Assertions.assertEquals(10, question1.getMin(a));
        }
    }
    @AfterEach
    public void clean(){
        question1 = null;
    }

}