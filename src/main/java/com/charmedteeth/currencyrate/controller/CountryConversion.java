package com.charmedteeth.currencyrate.controller;

import com.charmedteeth.currencyrate.model.RateConversionResponse;
import com.charmedteeth.currencyrate.model.RateConvertRequest;
import com.charmedteeth.currencyrate.services.CountryConversionServImp;
import com.charmedteeth.currencyrate.services.CountryConversionService;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@RestController
@RequestMapping("floatrates/api/convert/currency")
public class CountryConversion {

    private static final Logger logger = LoggerFactory.getLogger(CountryConversion.class);

    @Autowired
    CountryConversionService conversionService;

    @PostMapping("")
    public ResponseEntity<RateConversionResponse> convertCurrency(@RequestBody RateConvertRequest request) throws IOException {
        RateConversionResponse conversionResponse = conversionService.convertToCountryRate(request);
        return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
    }

    @GetMapping("/{curr}")
    public String testingConvertor(@PathVariable String curr){
        try {
            String rateUrl = "http://www.floatrates.com/daily/"+curr+".json";
            logger.info("URL for base curr {} ",rateUrl);
            JSONObject json = new JSONObject(IOUtils.toString(new URL(rateUrl), Charset.forName("UTF-8")));
            return json.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello Convertor";
    }
}
