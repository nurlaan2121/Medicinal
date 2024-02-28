package mypackeg.entities;

import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public class BigDecimalToMedicinesConverter implements Converter<BigDecimal, Medicines> {
    @Override
    public Medicines convert(BigDecimal source) {
        // Implement the conversion logic here
        // Create a new instance of Medicines and set values based on the BigDecimal
        return new Medicines(/* set values */);
    }
}
