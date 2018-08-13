import org.junit.Assert;
import org.junit.Test;

public class trainingTestSuite {



    @Test
    public void shouldAddCorrectly() {
        Calc calc = new Calc();

        int result = calc.add(5, 15);

        Assert.assertEquals(20, result);
    }
}