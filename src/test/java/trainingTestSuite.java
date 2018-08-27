import org.junit.Assert;
import org.junit.Test;

public class trainingTestSuite {



    @Test
    public void shouldAddCorrectly() {

        //Given
        //deklaruje obiekty
        //doprowadzam kod do takiego stanu abym w sekcji when mógł zrobić operacje dodawania
        //Czyli np. jak deklaruje obiekt calulator i chcę zrobić test metody o nazwie "add()"
        // to muszę w Given zrobić tak, aby w When użyć tylko metody add() czyli musze w Given
        //zadbać o to aby powstał obiekt "Calculator" i w When uruchomić metode add
        Calc calc = new Calc();

        //When
        // robisz próby tego co chcesz testować czyli co w tej metodzie chcesz testować

        int result = calc.add(5, 10, 20);

        //Then
        // oczekiwany rezultat

        Assert.assertEquals(35, result);

        System.out.println("result = " + result);
    }
}