package com.ordepdev.coffeeshop;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class CoffeeShopTests {

    private Cafe cafe;

    @Before
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso() {
        withBeans();

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        assertThat(coffee, hasProperty("beans", equalTo(CoffeeType.Espresso.getRequiredBeans())));
        //assertEquals("Wrong number of beans",  CoffeeType.Espresso.getRequiredBeans(), coffee.getBeans());
        assertEquals("Wrong amount of milk", CoffeeType.Espresso.getRequiredMilk(), coffee.getMilk());
        assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType());
    }

    @Test
    public void canBrewLatte() {
        withBeans();
        cafe.restockMilk(227);

        Coffee coffee = cafe.brew(CoffeeType.Latte);

        assertEquals("Wrong number of beans", CoffeeType.Latte.getRequiredBeans(), coffee.getBeans());
        assertEquals("Wrong number of milk", CoffeeType.Latte.getRequiredMilk(), coffee.getMilk());
        assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        withBeans();

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        assertEquals("Wrong number of beans in stock", 0, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk() {
        withBeans();

        cafe.brew(CoffeeType.Latte);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantRestockBeans() {
        Cafe cafe = new Cafe();

        cafe.restockBeans(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantRestockMilk() {
        Cafe cafe = new Cafe();

        cafe.restockMilk(0);
    }

    private void withBeans() {
        cafe.restockBeans(7);
    }
}
