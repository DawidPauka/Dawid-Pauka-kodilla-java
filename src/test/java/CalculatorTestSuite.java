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
        //WHEN - typ i nazwa zmiennej czyli "typ result"
        //boolean result = dawid.machaj reka()(ty wiesz jaki będzie rezultat/wynik/ w tej METODZIE, która jest zapisana w innej klasie czyli inaczej mówiąc będziesz znał
        //WYNIK/REZULTAT pierwszego parametru z metody "machaj ręką"
        // np. w klasie xxx metoda "machaj ręką" zwraca wartość TRUE więc pierwszym parametrem/ARGUMENTEM w sekcji THEN będzie wartość TRUE

        double result = calculator.add(1000, 20);

        //Then
        // oczekiwany rezultat
        //asert.asertequals(PIERWSZY PARAMETR, KTÓRY ZAWSZE BĘDĘ WIEDZIAŁ JAKI JEST BO WIEM ŻE METODA XXX ZWRACA JAKĄŚ WARTOŚĆ W TYM PRZYPADKU "true",result)

        Assert.assertEquals(1020,result,0 );

        System.out.println("result addition = " + result);
    }


    @Test
    public void shouldSubstractCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        double result = calculator.substract(60,100);

        //Then
        Assert.assertEquals(result, 40, 0 );
        System.out.println("result subtraction  = " + result);

    }

    @Test
    public void shouldMultiplyCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        double result = calculator. multiply(60,100);

        //Then
        Assert.assertEquals(result, 6000, 0 );
        System.out.println("result multiplication = " + result);

    }

    @Test
    public void shouldDivisionCorrectly() {

        //Given
        Calculator calculator = new Calculator();

        //When
        double result = calculator. divide(100,25);

        //Then
        Assert.assertEquals(result, 4, 0 );
        System.out.println("result division  = " + result);


        String hello = "Witaj ";
        String world = "Świecie! ";
        String powitanie = hello+world; //łączenie Stringów
        System.out.println(powitanie);

        String ja = "Slawek";
        String ty = "Slawek";

        boolean porownanie1 = ja==ty;
        boolean porownanie2 = ja.equals(ty);
        System.out.println(porownanie1);
        System.out.println(porownanie2);


        Object d = new Object();
        Object dd = d;
        Object refferenceToObjectY = new Object();

        System.out.println(d.toString());
        System.out.println(dd.toString());
        System.out.println(refferenceToObjectY.toString());









        }

    }
