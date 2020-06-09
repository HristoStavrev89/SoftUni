package softuni.workshop.service.services.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dto.companyDto.CompanyDto;
import softuni.workshop.data.dto.companyDto.RootCompanyDto;
import softuni.workshop.data.entities.Company;
import softuni.workshop.data.repositories.CompanyRepository;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final String XML_PATH = "src/main/resources/files/xmls/companies.xml";

    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCompanies() throws JAXBException {

       RootCompanyDto rootCompanyDto = this.xmlParser.importXML(RootCompanyDto.class, XML_PATH);

       for (CompanyDto companyDto : rootCompanyDto.getCompanies()) {

           this.companyRepository.save(this.modelMapper.map(companyDto, Company.class));

       }

    }

    @Override
    public boolean areImported() {

        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesXmlFile()  {
        String xml = "";
        try {
            xml = Files.readString(Path.of(XML_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @Override
    public Company findCompanyByName(String name) {
        return this.companyRepository.findByName(name);
    }
}
