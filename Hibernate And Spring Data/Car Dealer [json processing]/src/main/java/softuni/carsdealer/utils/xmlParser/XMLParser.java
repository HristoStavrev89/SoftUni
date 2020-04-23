package softuni.carsdealer.utils.xmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XMLParser {

    <O> void exportToXml(O object, String path) throws JAXBException;

    <O> O importFromXml(Class<O> klass, String path) throws JAXBException, FileNotFoundException;

}
