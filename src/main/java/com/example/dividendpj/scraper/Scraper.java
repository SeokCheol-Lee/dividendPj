package com.example.dividendpj.scraper;

import com.example.dividendpj.model.Company;
import com.example.dividendpj.model.ScrapedResult;

public interface Scraper {

    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}
