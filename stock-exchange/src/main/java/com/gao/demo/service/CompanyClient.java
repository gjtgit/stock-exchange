package com.gao.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gao.demo.entity.CompanyEntity;

@FeignClient(name="service-company",fallback=CompanyClientHystric.class, url="http://localhost:8082")
public interface CompanyClient {
    
    @RequestMapping(path="/exchangecompanies",method = RequestMethod.GET)
    public List<CompanyEntity> getCompanyListByStockExchange(@RequestParam String stockExchange);
    
}
