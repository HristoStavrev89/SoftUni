package hiberspring.service;

import hiberspring.domain.dtos.productDtos.seedProductDtos.ProductSeedDto;
import hiberspring.domain.dtos.productDtos.seedProductDtos.ProductSeedRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidatorUtil;
import hiberspring.util.xmlParser.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;

import static hiberspring.common.ConstantPath.PRODUCTS_PATH_LOCATION;
import static hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;
import static hiberspring.common.Constants.SUCCESSFUL_IMPORT_PRODUCT;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final XmlParser xmlParser;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final BranchService branchService;

    @Autowired
    public ProductServiceImpl(XmlParser xmlParser, ProductRepository productRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil, BranchService branchService) {
        this.xmlParser = xmlParser;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
        this.branchService = branchService;
    }


    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return this.fileUtil.readFile(PRODUCTS_PATH_LOCATION);
    }

    @Override
    public String importProducts() throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();

        ProductSeedRootDto prductRootDto = this.xmlParser.importFromXml(PRODUCTS_PATH_LOCATION, ProductSeedRootDto.class);

        for (ProductSeedDto productDto : prductRootDto.getProducts()) {

            if (this.validatorUtil.isValid(productDto)) {

                if (this.productRepository.findByName(productDto.getName()) == null) {

                    Product product = this.modelMapper.map(productDto, Product.class);

                    Branch branch = this.branchService.getBranchByName(productDto.getBranch());
                    product.setBranch(branch);


                    if (branch != null) {
                        this.productRepository.saveAndFlush(product);
                        sb.append(String.format(SUCCESSFUL_IMPORT_PRODUCT, product.getName()))
                                .append(System.lineSeparator());
                    }



                }

            } else {
                sb.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }

        }

        return sb.toString();
    }
}
