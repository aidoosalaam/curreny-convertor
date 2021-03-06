package com.charmedteeth.currencyrate.services;

import com.charmedteeth.currencyrate.model.CurrencyRateDetails;
import com.charmedteeth.currencyrate.model.RateConversionResponse;
import com.charmedteeth.currencyrate.model.RateConvertRequest;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

@Service
public class CountryConversionServImp implements CountryConversionService {
    @Override
    public RateConversionResponse convertToCountryRate(RateConvertRequest converSionRequest) throws IOException {
        JSONObject json = new JSONObject(IOUtils.toString(new URL("http://www.floatrates.com/daily/"+converSionRequest.getSourceCurr().toLowerCase()+".json"), Charset.forName("UTF-8")));
        JSONObject destCurrJson = json.getJSONObject(converSionRequest.getDestCurr().toLowerCase());
        System.out.println("Destination Currency Details : "+ destCurrJson.toString());
        Gson gson = new Gson();
        CurrencyRateDetails currencyRateDetails = gson.fromJson(destCurrJson.toString(),CurrencyRateDetails.class);
        double convertedAmount = converSionRequest.getAmount() * Double.parseDouble(currencyRateDetails.getRate());
        System.out.println("Converted Amount : "+ convertedAmount);
        RateConversionResponse response = new RateConversionResponse();
        response.setAmount(String.valueOf(converSionRequest.getAmount()));
        response.setConvertedAmount(String.valueOf(convertedAmount));
        response.setLastUpdated(currencyRateDetails.getDate());
        response.setDestCurr(currencyRateDetails.getCode());
        response.setRate(currencyRateDetails.getRate());
        response.setInverseRate(currencyRateDetails.getInverseRate());
        response.setSourceCurr(converSionRequest.getSourceCurr());
        response.setSource("http://www.floatrates.com/");
        return response;
    }

    public static String getJSON(String url) {
        HttpsURLConnection con = null;
        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}
