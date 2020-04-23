package hiberspring.util.xmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParserImpl implements XmlParser {



    @Override
    public <O> void exportToXml(String path, O object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(path));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <O> O importFromXml(String path, Class<O> klass) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(klass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (O) unmarshaller.unmarshal(new FileReader(path));
    }
}
