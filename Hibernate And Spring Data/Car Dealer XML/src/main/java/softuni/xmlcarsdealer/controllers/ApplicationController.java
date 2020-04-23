package softuni.xmlcarsdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.xmlcarsdealer.constants.GlobalConstants;
import softuni.xmlcarsdealer.domain.dto.seedDtos.carSeedDtos.CarRootSeedDto;
import softuni.xmlcarsdealer.domain.dto.seedDtos.customerSeedDtos.CustomerRootSeedDto;
import softuni.xmlcarsdealer.domain.dto.seedDtos.partSeedDtos.PartsRootSeedDto;
import softuni.xmlcarsdealer.domain.dto.seedDtos.supplierSeedDtos.SupplierSeedRoodDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.CarPartRootViewDtoWrapp;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carXmlDtos.CarRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerTotalSalesDto.CustomerSaleRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos.CustomerRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.supplierXmlDtos.SupplierRootViewDto;
import softuni.xmlcarsdealer.services.*;
import softuni.xmlcarsdealer.utils.xmlParser.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ApplicationController implements CommandLineRunner {

    private final XMLParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public ApplicationController(XMLParser xmlParser, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }


    @Override
    public void run(String... args) throws Exception {

//        this.seedSuppliers();
//        this.seedParts();
//        this.seedCars();
//        this.seedCustomers();
//        this.seedSales();



//        this.getAllCustomersOrderedByBirthDate();
//          this.getAllCarsMadeFromToyota();
//          this.getAllSupplierAbroadIsFalse();
//        this.getAllCarsAndTheirParts();

        this.getAllCustomerSales();

    }

    private void getAllCustomerSales() throws JAXBException {
        CustomerSaleRootViewDto customerSaleRootViewDto = this.customerService.getTotalSalesByCustomer();
        this.xmlParser.exportToXml(GlobalConstants.TOTAL_SALE_BY_CUSTOMER, customerSaleRootViewDto);
    }

    private void getAllCarsAndTheirParts() throws JAXBException {
        CarPartRootViewDtoWrapp carPartRootViewDtoWrapp = this.carService.getAllCarsWithTheirParts();
        this.xmlParser.exportToXml(GlobalConstants.CARS_AND_THEIR_LISTS_OF_PARTS, carPartRootViewDtoWrapp);
    }

    private void getAllSupplierAbroadIsFalse() throws JAXBException {
        SupplierRootViewDto supplierRootViewDto = this.supplierService.getAllAbroadIsFalse();
        this.xmlParser.exportToXml(GlobalConstants.LOCAL_SUPPLIERS, supplierRootViewDto);
    }

    private void getAllCarsMadeFromToyota() throws JAXBException {
        CarRootViewDto carRootViewDto = this.carService.getAllCarsByMake();
        this.xmlParser.exportToXml(GlobalConstants.CARS_FROM_MAKE_TOYOTA, carRootViewDto);

    }

    //todo delete the output and run again to fix the birthDate in the output
    private void getAllCustomersOrderedByBirthDate() throws JAXBException {

        CustomerRootViewDto customerRootViewDto = this.customerService.getAllOrderedByBirthDate();
        this.xmlParser.exportToXml(GlobalConstants.ORDERED_CUSTOMERS, customerRootViewDto);

    }

    private void seedSales() {

        this.saleService.seedSales();



    }

    private void seedCustomers() throws JAXBException, FileNotFoundException {
        CustomerRootSeedDto customerRootSeedDto = this.xmlParser.importFromXml(GlobalConstants.CUSTOMERS_IMPORT, CustomerRootSeedDto.class);

        this.customerService.seedCustomers(customerRootSeedDto.getCustomers());

    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        CarRootSeedDto carRootSeedDto = this.xmlParser.importFromXml(GlobalConstants.CARS_IMPORT, CarRootSeedDto.class);

        this.carService.seedCars(carRootSeedDto.getCars());
    }

    private void seedParts() throws JAXBException, FileNotFoundException {


        PartsRootSeedDto partsRootSeedDto = this.xmlParser.importFromXml(GlobalConstants.PARTS_IMPORT, PartsRootSeedDto.class);

        this.partService.seedParts(partsRootSeedDto.getParts());



    }

    private void seedSuppliers() throws JAXBException, FileNotFoundException {
        //Tis time without the xmlsParser which I already created in utils folder.
//        JAXBContext jaxbContext = JAXBContext.newInstance(SupplierSeedRoodDto.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        SupplierSeedRoodDto supplierSeedRoodDto = (SupplierSeedRoodDto) unmarshaller
//                .unmarshal(new FileReader(GlobalConstants.SUPPLIERS_IMPORT));

        SupplierSeedRoodDto supplierSeedRoodDto = this.xmlParser.importFromXml(GlobalConstants.SUPPLIERS_IMPORT, SupplierSeedRoodDto.class);

        this.supplierService.seedSuppliers(supplierSeedRoodDto.getSuppliers());


    }
}
