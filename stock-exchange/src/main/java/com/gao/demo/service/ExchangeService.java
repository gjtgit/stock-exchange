package com.gao.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.StockExchangeEntity;
import com.gao.demo.repository.ExchangeRepo;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepo exchangeRepo;
    
    public StockExchangeEntity findById(Long id) throws Exception{
        StockExchangeEntity stockExchangeEntity = null;
        try {
            Optional<StockExchangeEntity> u = exchangeRepo.findById(id);
            if(u.isPresent()) {
                stockExchangeEntity = u.get();
            }
            return stockExchangeEntity;
        }catch(Exception e) {
            throw new Exception(e);
        }
    }
    
    public void save(StockExchangeEntity u) throws Exception{
        try{
            exchangeRepo.saveAndFlush(u);
        }catch(Exception e) {
            throw new Exception(e);
        }
    }
    
    
    public List<StockExchangeEntity> getStockExchangeList() throws Exception{
        return exchangeRepo.findAll();
    }
    
    public StockExchangeEntity findByStockExchange(String stockExchange) throws Exception{
        return exchangeRepo.findByStockExchange(stockExchange);
    }
    
//    public List<CompanyEntity> getCompanyListByStockExchange(String name) throws Exception{
//        return exchangeRepo.getCompanyListByStockExchange(name);
//    }
    
}
