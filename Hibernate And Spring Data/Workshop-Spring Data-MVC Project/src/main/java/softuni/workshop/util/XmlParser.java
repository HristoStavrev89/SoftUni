package softuni.workshop.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {


    <O> O importXML(Class<O> oClass, String path) throws JAXBException;

    <O> void exportToXml(O object, Class<O> oClass, String path) throws JAXBException;

}
