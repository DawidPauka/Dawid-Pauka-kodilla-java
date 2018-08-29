import org.junit.Assert;
import org.junit.Test;

public class CalculatorTestSuite {



    @Test
    public void shouldAddCorrectly() {

        //Given
        //deklaruje obiekty
        //W sekcji Given doprowadzam kod do takiego stanu abym w sekcji "when" mógł zrobić pożądaną operacje na obiekcie w metodzie, która wykonuje określone zachowanie np. dodaje dwie liczby do siebie
        //Czyli np. jak deklaruje obiekt calulator w sekcji Given i chcę zrobić test metody, która dodaje do siebie dwie liczby
        // to muszę w sekcji "Given" zrobić tak, aby w sekcji When użyć tylko tej metody która dodaje do siebie dwie liczby   czyli musze w sekcji "Given"
        //zadbać o to aby powstał obiekt "Calculator" a w sekcji When zadbać o to aby uruchomić metodę na tym obiekcie czyli uruchomić metode np. o nazwie "add ()"
        Calculator calculator = new Calculator();

        //When robisz próby tego co chcesz testować czyli co w tej metodzie chcesz testować
        //(wykonanie testowanej metody)

        int result = calculator.add(5, 10);

        //Then
        // oczekiwany rezultat

        Assert.assertEquals(15, result);

        System.out.println("result addition = " + result);
    }


    @Test
    public void shouldSubstractCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        int result = calculator.substract(60,100);

        //Then
        Assert.assertEquals(40, result);
        System.out.println("result subtraction  = " + result);

    }

    @Test
    public void shouldMultiplyCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        int result = calculator. multiply(60,100);

        //Then
        Assert.assertEquals(6000, result);
        System.out.println("result multiplication = " + result);

    }

    @Test
    public void shouldDivisionCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        int result = calculator. divide(100,25);

        //Then
        Assert.assertEquals(4, result);
        System.out.println("result division  = " + result);

    }
}