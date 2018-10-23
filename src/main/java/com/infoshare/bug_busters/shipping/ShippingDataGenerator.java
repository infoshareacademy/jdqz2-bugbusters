package com.infoshare.bug_busters.shipping;


import com.infoshare.bug_busters.TestData;
import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.random.RandomDataGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShippingDataGenerator {

    public static ShippingData prepareShippingData() throws IOException {

        Integer houseNumber = RandomDataGenerator.prepareHouseNumber();
        String streetName = RandomDataGenerator.prepareStreetName();
        String city = RandomDataGenerator.prepareCity() ;
        String postCode = RandomDataGenerator.preparePostCode();
        String country = RandomDataGenerator.prepareCountry();

        return new ShippingData(houseNumber, streetName, city, postCode, country);
    }
    public List<ShippingData> getDataFromXml() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(TestData.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        TestData testData = (TestData) unmarshaller.unmarshal(new File("/jdqz2-bugbusters/TestData.xml"));
        return testData.getShippingData();
    }
}

