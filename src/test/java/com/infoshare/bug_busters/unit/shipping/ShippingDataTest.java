package com.infoshare.bug_busters.unit.shipping;

import com.infoshare.bug_busters.shipping.ShippingData;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShippingDataTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie

    ShippingData shippingData = new ShippingData("12", "Grunwaldzka", "Gdansk", "80399", "Polska");

    @Test
    public void houseNumberFromManuallyCreatedObject(){

        Assertions.assertThat(shippingData.getHouseNumber()).isEqualTo("12");
    }

    @Test
    public void streetNameFromManuallyCreatedObject(){

        Assertions.assertThat(shippingData.getStreetName()).isEqualTo("Grunwaldzka");
    }

    @Test
    public void cityFromManuallyCreatedObject(){
        Assertions.assertThat(shippingData.getCity()).isEqualTo("Gdansk");
    }

    @Test
    public void postCodeFromManuallyCreatedObject(){
        Assertions.assertThat(shippingData.getPostCode()).isEqualTo("80399");
    }

    @Test
    public void countryCodeFromManuallyCreatedObject(){
        Assertions.assertThat(shippingData.getCountry()).isEqualTo("Polska");
    }

    @Test
    public void validToString(){
        Assertions.assertThat(shippingData.toString()).isEqualTo("ShippingData{houseNumber='12', " +
                "streetName='Grunwaldzka', city='Gdansk', postCode='80399', country='Polska'}" + "\n");
    }
}
