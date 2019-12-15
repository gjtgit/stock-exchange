package com.gao.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.StockExchangeEntity;

@Repository
public interface ExchangeRepo extends JpaRepository<StockExchangeEntity,Long>{
    
//    @Query("select c from CompanyEntity c, StockExchangeEntity s where c.listedExchanges=s.stockExchange and s.stockExchange=?1")
//    public List<CompanyEntity> getCompanyListByStockExchange(String stockExchange);
    
    public StockExchangeEntity findByStockExchange(String stockExchange);
    
}
