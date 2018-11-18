package com.infoshare.bug_busters.dataFromXML;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import static javax.xml.bind.JAXBContext.newInstance;

public class TestDataGenerator {
    public TestData getDataFromXml() throws JAXBException{
        JAXBContext jaxbContext = newInstance(TestData.class);
        File file = new File("TestData.xml");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (TestData) jaxbUnmarshaller.unmarshal(file);
    }
}
