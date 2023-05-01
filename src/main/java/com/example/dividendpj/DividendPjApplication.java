package com.example.dividendpj;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DividendPjApplication {

    public static void main(String[] args) {

        Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/COKE/history?period1=1651322474&period2=1682858474&interval=1mo&filter=history&frequency=1mo&includeAdjustedClose=true");
        try {
            Document document = connection.get();

            Elements attributeValue = document.getElementsByAttributeValue("data-test", "historical-prices");
            Element ele = attributeValue.get(0);

            Element tbody = ele.children().get(1);
            for(Element e :tbody.children()){
                String txt = e.text();
                if(!txt.endsWith("Dividend")){
                    continue;
                }
                String[] splits = txt.split(" ");
                String month = splits[0];
                int day = Integer.valueOf(splits[1].replace(",",""));
                int year = Integer.valueOf(splits[2]);
                String dividend = splits[3];

                System.out.println(year + "/" + month + "/" + day + "->" + dividend);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
