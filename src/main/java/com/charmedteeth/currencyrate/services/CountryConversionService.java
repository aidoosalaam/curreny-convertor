package com.charmedteeth.currencyrate.services;

import com.charmedteeth.currencyrate.model.RateConversionResponse;
import com.charmedteeth.currencyrate.model.RateConvertRequest;

import java.io.IOException;
import java.net.MalformedURLException;

public interface CountryConversionService {
     RateConversionResponse convertToCountryRate(RateConvertRequest converSionRequest) throws IOException;
}
