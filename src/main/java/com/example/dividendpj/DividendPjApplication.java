package com.example.dividendpj;

import com.example.dividendpj.model.Company;
import com.example.dividendpj.scraper.Scraper;
import com.example.dividendpj.scraper.YahooFianceScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
public class DividendPjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DividendPjApplication.class, args);
    }

}
