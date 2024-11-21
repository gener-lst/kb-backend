package com.kb.itisme.exchangeRate.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class ExchangeRateService {

    private static final String AUTH_KEY = "LmBJSDPgtOLqoprUCu92d0MuZkKBxtpc";
    private static final String BASE_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
    private static final BigDecimal DEFAULT_EXCHANGE_RATE = new BigDecimal("1200.00");

    public BigDecimal getExchangeRate(String currencyCode) {
        HttpURLConnection connection = null;
        BufferedReader reader;
        JSONParser parser = new JSONParser();
        BigDecimal exchangeRate = null;

        try {
            String searchDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String requestUrl = BASE_URL + "?authkey=" + AUTH_KEY + "&searchdate=" + searchDate + "&data=AP01";
            URL url = new URL(requestUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                // 에러 응답 읽기
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    errorResponse.append(line);
                }
                reader.close();
                System.err.println("Error Response: " + errorResponse.toString());
            } else {
                // 성공 응답 읽기
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

                // JSON 파싱
                JSONArray exchangeRateInfoList = (JSONArray) parser.parse(responseContent.toString());
                for (Object o : exchangeRateInfoList) {
                    JSONObject exchangeRateInfo = (JSONObject) o;
                    if (currencyCode.equals(exchangeRateInfo.get("cur_unit"))) {
                        String rateString = exchangeRateInfo.get("deal_bas_r").toString();
                        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
                        exchangeRate = new BigDecimal(format.parse(rateString).doubleValue());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        if (exchangeRate == null) {
            System.err.println("Requested currency not found: " + currencyCode);
            exchangeRate = DEFAULT_EXCHANGE_RATE;
        }

        return exchangeRate;
    }
}
