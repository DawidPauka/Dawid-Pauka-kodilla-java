package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;


public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }


        System.out.println("Zadanie 6.2: pierwszy test jednostkowy:");


        Calculator calculator = new Calculator(698,4343);

        int resultAdding = calculator.getResultAdd();
        int resultSubstract = calculator.getResultSubstract();








    }
}

