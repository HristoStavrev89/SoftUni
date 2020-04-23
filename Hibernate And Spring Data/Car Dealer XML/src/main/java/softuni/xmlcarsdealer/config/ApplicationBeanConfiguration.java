package softuni.xmlcarsdealer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.xmlcarsdealer.utils.ValidationUtil;
import softuni.xmlcarsdealer.utils.ValidationUtilImpl;
import softuni.xmlcarsdealer.utils.xmlParser.XMLParser;
import softuni.xmlcarsdealer.utils.xmlParser.XMLParserImpl;

import java.util.Random;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public XMLParser xmlParser() {
        return new XMLParserImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public Random random() {
        return new Random();
    }

}
