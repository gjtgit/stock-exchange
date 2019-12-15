package com.gao.demo.model;

public class StockExchangeVo {
    private Long id;
    private String stockExchange;
    private String brief;
    private String contactAddress;
    private String Remarks;
    
    public StockExchangeVo() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStockExchange() {
        return stockExchange;
    }
    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }
    public String getBrief() {
        return brief;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }
    public String getContactAddress() {
        return contactAddress;
    }
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
    public String getRemarks() {
        return Remarks;
    }
    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
    
}
