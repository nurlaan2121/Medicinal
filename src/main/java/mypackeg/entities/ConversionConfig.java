package mypackeg.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

@Configuration
public class ConversionConfig {

    @Bean
    public Converter<BigDecimal, Medicines> bigDecimalToMedicinesConverter() {
        return new BigDecimalToMedicinesConverter();
    }
}
