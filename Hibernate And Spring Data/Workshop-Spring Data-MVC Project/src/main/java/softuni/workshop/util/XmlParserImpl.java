package softuni.workshop.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParserImpl implements XmlParser{


    @Override
    @SuppressWarnings("unchecked")
    public <O> O importXML(Class<O> oClass, String path) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(oClass);
        Unmarshaller u = jc.createUnmarshaller();
        Object o = u.unmarshal( new File( path) );
        return (O) o;
    }

    @Override
    public <O> void exportToXml(O object, Class<O> oClass, String path) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(oClass);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(oClass, new File(path));
    }
}
