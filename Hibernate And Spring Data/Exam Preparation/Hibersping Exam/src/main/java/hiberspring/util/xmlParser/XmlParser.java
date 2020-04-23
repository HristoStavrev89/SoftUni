package hiberspring.util.xmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <O> void exportToXml(String path, O object) throws JAXBException;

    <O> O importFromXml(String path, Class<O> klass) throws JAXBException, FileNotFoundException;

}
