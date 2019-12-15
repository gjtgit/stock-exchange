package com.gao.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.StockExchangeEntity;
import com.gao.demo.model.StockExchangeVo;
import com.gao.demo.service.CompanyClient;
import com.gao.demo.service.ExchangeService;

@RestController
public class ExchangeController {
    Logger logger = LoggerFactory.getLogger(ExchangeController.class);
    
    @Autowired
    private ExchangeService exchangeService;
    
    @Autowired
    private CompanyClient companyClient;
    
    //getList of Companies in a exchange
//  @RequestMapping(path="/stockexchangecompanies/{name}",method=RequestMethod.GET)
//  public List<CompanyEntity> getCompanyListByStockExchange(@PathVariable String name )throws Exception{
//      return this.exchangeService.getCompanyListByStockExchange(name);
//  }
    
    //getList of Companies in a exchange
  @RequestMapping(path="/stockexchangecompanies/{stockExchange}",method=RequestMethod.GET)
  public List<CompanyEntity> getCompanyListByStockExchange(@PathVariable String stockExchange )throws Exception{
      logger.info("--- service-exchange call service start ---");
      List<CompanyEntity> l = this.companyClient.getCompanyListByStockExchange(stockExchange);
      logger.info("--- service-exchange call service end ---");
      return l; 
  }
    
    @RequestMapping(path="/getExchangeByName/{stockExchange}",method=RequestMethod.GET)
    public StockExchangeEntity getStockExchangeDetails(@PathVariable String stockExchange) throws Exception{
        return this.exchangeService.findByStockExchange(stockExchange);
    }
    
    @RequestMapping(path="/stockexchanges/{id}",method=RequestMethod.GET)
    public StockExchangeEntity getStockExchangeById(@PathVariable Long id) throws Exception{
        return this.exchangeService.findById(id);
    }
    
    @RequestMapping(path="/stockexchanges",method=RequestMethod.GET)
    public List<StockExchangeEntity> getStockExchangeList() throws Exception{
        return this.exchangeService.getStockExchangeList();
    }
    
    @RequestMapping(path="/stockexchanges", method=RequestMethod.POST)
    public StockExchangeEntity addStockExchange(@RequestBody StockExchangeVo vo) throws Exception {
        StockExchangeEntity se = new StockExchangeEntity();
        se.setStockExchange(vo.getStockExchange());
        se.setBrief(vo.getBrief());
        se.setContactAddress(vo.getContactAddress());
        se.setRemarks(vo.getRemarks());
        this.exchangeService.save(se);
        return se;
    }
    
    @RequestMapping(path="/stockexchanges", method=RequestMethod.PUT)
    public String updateStockExchange(@RequestBody StockExchangeVo vo) throws Exception {
        StockExchangeEntity se = this.exchangeService.findById(vo.getId());
        if(se!=null) {
            se.setStockExchange(vo.getStockExchange());
            se.setBrief(vo.getBrief());
            se.setContactAddress(vo.getContactAddress());
            se.setRemarks(vo.getRemarks());
            this.exchangeService.save(se);
            return "Update stock exchange successfully!";
        }else {
            return "Stock exchange doesn't exist.";
        }
    }
}
