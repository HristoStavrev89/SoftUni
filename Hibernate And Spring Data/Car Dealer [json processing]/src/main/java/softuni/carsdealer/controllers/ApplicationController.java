package softuni.carsdealer.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.carsdealer.constants.GlobalConstants;
import softuni.carsdealer.domain.dtos.seedDtos.CarDtoSeed;
import softuni.carsdealer.domain.dtos.seedDtos.CustomerDtoSeed;
import softuni.carsdealer.domain.dtos.seedDtos.PartDtoSeed;
import softuni.carsdealer.domain.dtos.seedDtos.SupplierDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.carsFromMakeToyota.CarToyotaDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts.CarPartDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.localSupliers.SupplierDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.orderedCustomers.CustomerDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.totalSalesByCustomer.CustomerSalesDtoView;
import softuni.carsdealer.services.*;
import softuni.carsdealer.utils.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class ApplicationController implements CommandLineRunner {
    private final Gson gson;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final FileUtil fileUtil;

    @Autowired
    public ApplicationController(Gson gson, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, FileUtil fileUtil) {
        this.gson = gson;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.fileUtil = fileUtil;
    }


    @Override
    public void run(String... args) throws Exception {

//        this.seedDatabase();

//        this.getOrderedCustomers();

//        this.getAllToyotaCars();

//       this.getSuppliersWithNoAbroadImporter();

//       this.getAllCarsWithTheirParts();

        this.getTotalSalesByCustomer();


    }

    private void getTotalSalesByCustomer() throws IOException {
        List<CustomerSalesDtoView> customers = this.customerService.getAllCustomersAtLEastOneCar();
        String toJson = this.gson.toJson(customers);
        this.fileUtil.write(toJson, GlobalConstants.TOTAL_SALES_BY_CUSTOMER);

    }

    private void getAllCarsWithTheirParts() throws IOException {
      List<CarPartDtoView> carPartDtoViews = this.carService.getCarsAndTheirParts();
      String toJson = this.gson.toJson(carPartDtoViews);
      this.fileUtil.write(toJson, GlobalConstants.ALL_CARS_AND_THEIR_PARTS);

    }

    private void getSuppliersWithNoAbroadImporter() throws IOException {
      List<SupplierDtoView> suppliers = this.supplierService.getByImporterIsNotAbroad();
      String toJson = this.gson.toJson(suppliers);
      this.fileUtil.write(toJson, GlobalConstants.LOCAL_SUPPLIERS);

    }

    private void getAllToyotaCars() throws IOException {
        List<CarToyotaDtoView> carsList = this.carService
                .getAllCarsMadeFromToyota();

        String toJson = this.gson.toJson(carsList);

        this.fileUtil.write(toJson, GlobalConstants.TOYOTA_CARS_FILE_PATH);
    }

    private void getOrderedCustomers() throws IOException {
        List<CustomerDtoView> customerDtoViews = this.customerService.getCustomersOrderedByBirthDate();

        String toJson = this.gson.toJson(customerDtoViews);

        this.fileUtil.write(toJson, GlobalConstants.ORDERED_CUSTOMERS_BY_BIRTH_DATE_FILE_PATH);

    }


    private void seedDatabase() throws IOException {
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.seedSales();
    }

    private void seedSales() {
        this.saleService.seedSale();
    }

    private void seedCustomers() throws IOException {

        String content = this.fileUtil.readFileContent(GlobalConstants.CUSTOMERS_FILE_PATH);
        CustomerDtoSeed[] customerSeedDTOs = this.gson
                .fromJson(content, CustomerDtoSeed[].class);



        this.customerService.seedCustomer(customerSeedDTOs);
    }

    private void seedCars() throws FileNotFoundException {
        CarDtoSeed[] carDtoSeeds = this.gson
                .fromJson(new FileReader(GlobalConstants.CARS_FILE_PATH), CarDtoSeed[].class);



        this.carService.seedCar(carDtoSeeds);

    }

    private void seedParts() throws FileNotFoundException {
        PartDtoSeed[] partDtoSeeds = this.gson
                .fromJson(new FileReader(GlobalConstants.PARTS_FILE_PATH), PartDtoSeed[].class);

        this.partService.seedPart(partDtoSeeds);
    }

    private void seedSuppliers() throws FileNotFoundException {
        SupplierDtoSeed[] supplierDtoSeeds = this.gson
                .fromJson(new FileReader(GlobalConstants.SUPPLIERS_FILE_PATH), SupplierDtoSeed[].class);

        this.supplierService.seedSuppliers(supplierDtoSeeds);
    }
}
