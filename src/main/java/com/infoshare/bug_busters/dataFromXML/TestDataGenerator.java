package com.infoshare.bug_busters.dataFromXML;

import com.infoshare.bug_busters.pageObject.ShoppingCart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

public class TestDataGenerator {

    private static Logger logger = LoggerFactory.getLogger(TestDataGenerator.class);

    public TestData getDataFromXml() {
        TestData testData = null;
        try {
            JAXBContext jaxbContext = newInstance(TestData.class);
            File file = new File("TestData.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            testData = (TestData) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            logger.info(e.getMessage());
        }
        return testData;
    }
}
