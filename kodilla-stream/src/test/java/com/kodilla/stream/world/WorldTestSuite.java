package com.kodilla.stream.world;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //GIVEN - the world with continents
        World world = new World();
        Continent africa = new Continent("Asia");
        Continent asia = new Continent("Africa");
        Continent europe = new Continent("North America");
        Continent northAmerica = new Continent("Europe");
        Continent southAmerica = new Continent("South America");
        Continent oceania = new Continent("Antarctica");
        Continent antarctica = new Continent("Oceania");
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(europe);
        world.addContinent(southAmerica);
        world.addContinent(antarctica);
        world.addContinent(oceania);

        //WHEN - adding countries with their populations
        africa.addCountry(new Country("Nigeria", new BigDecimal("181563000")));
        africa.addCountry(new Country("Ethiopia", new BigDecimal("99391000")));
        africa.addCountry(new Country("Egypt", new BigDecimal("89125000")));
        africa.addCountry(new Country("*The rest of Africa", new BigDecimal("783229000")));
        asia.addCountry(new Country("China", new BigDecimal("1387160730")));
        asia.addCountry(new Country("India", new BigDecimal("1324009090")));
        asia.addCountry(new Country("Indonesia", new BigDecimal("255462000")));
        asia.addCountry(new Country("*The rest of Asia",new BigDecimal("1549685180")));
        europe.addCountry(new Country("Poland", new BigDecimal("38426000")));
        europe.addCountry(new Country("Russia", new BigDecimal("144031000")));
        europe.addCountry(new Country("Germany", new BigDecimal("81459000")));
        europe.addCountry(new Country("Turkey", new BigDecimal("79817849")));
        europe.addCountry(new Country("*The rest of Europe", new BigDecimal("496289956")));
        northAmerica.addCountry(new Country("USA", new BigDecimal("321234000")));
        northAmerica.addCountry(new Country("Mexico", new BigDecimal("121006000")));
        northAmerica.addCountry(new Country("Canada", new BigDecimal("35819000")));
        northAmerica.addCountry(new Country("*The rest of North America", new BigDecimal("89702000")));
        southAmerica.addCountry(new Country("Brazil", new BigDecimal("204519000")));
        southAmerica.addCountry(new Country("Colombia", new BigDecimal("48549000")));
        southAmerica.addCountry(new Country("Argentina", new BigDecimal("43132000")));
        southAmerica.addCountry(new Country("*The rest of South America", new BigDecimal("118463000")));
        oceania.addCountry(new Country("Australia", new BigDecimal("23792000")));
        oceania.addCountry(new Country("Papua New Guinea", new BigDecimal("8219000")));
        oceania.addCountry(new Country("New Zealand", new BigDecimal("4579000")));
        oceania.addCountry(new Country("*The rest of Oceania", new BigDecimal("3181060")));

        //THEN
        assertEquals(new BigDecimal("7531843865"), world.getPeopleQuantity());
    }
}