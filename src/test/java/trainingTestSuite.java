import org.junit.Assert;
import org.junit.Test;

public class trainingTestSuite {



    @Test
    public void shouldAddCorrectly() {
        Calc calc = new Calc();

        int result = calc.add(5, 10, 20);

        Assert.assertEquals(35, result);

        System.out.println("result = " + result);
    }
}