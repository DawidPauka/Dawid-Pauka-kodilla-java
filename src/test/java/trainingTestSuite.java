import org.junit.Assert;
import org.junit.Test;

public class trainingTestSuite {



    @Test
    public void shouldAddCorrectly() {
        Calc calc = new Calc();

        int result = calc.add(1, 2);

        Assert.assertEquals(3, result);
    }
}