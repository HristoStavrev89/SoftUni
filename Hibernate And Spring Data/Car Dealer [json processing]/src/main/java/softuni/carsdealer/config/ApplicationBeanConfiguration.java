package softuni.carsdealer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.carsdealer.utils.*;
import softuni.carsdealer.utils.dtoConverter.DtoConverter;
import softuni.carsdealer.utils.dtoConverter.DtoConverterImpl;
import softuni.carsdealer.utils.xmlParser.XMLParser;
import softuni.carsdealer.utils.xmlParser.XMLParserImpl;

import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter().nullSafe())
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
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
    public FileUtil fileUtil(){
        return new FileUtilImpl();
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public DtoConverter dtoConverter(){
        return new DtoConverterImpl(this.modelMapper());
    }

    @Bean
    public XMLParser xmlParser() {
        return new XMLParserImpl();
    }


}
