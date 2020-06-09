package softuni.workshop.service.services;

import softuni.workshop.data.entities.Company;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CompanyService {

    void importCompanies() throws JAXBException;

    boolean areImported();

    String readCompaniesXmlFile() throws IOException;

    Company findCompanyByName(String name);
}
