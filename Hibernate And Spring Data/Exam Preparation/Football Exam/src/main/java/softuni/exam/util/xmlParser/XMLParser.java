package softuni.exam.util.xmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XMLParser {

    <O> void exportToXml(String path, O object) throws JAXBException;

    <O> O importFromXml(String path, Class<O> klass) throws JAXBException, FileNotFoundException;

}
