package com.epoint.domain;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 冯金星
 * @since 2020-10-04
 */
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pdtid;

    private String pdtname;

    private Integer country;

    private String pdtlanguage;

    private Integer pdtusage;

    private Double latestprice;

    private Integer pricecount;

    private LocalDate releasetime;

    private String notes;


    public String getPdtid() {
        return pdtid;
    }

    public void setPdtid(String pdtid) {
        this.pdtid = pdtid;
    }

    public String getPdtname() {
        return pdtname;
    }

    public void setPdtname(String pdtname) {
        this.pdtname = pdtname;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getPdtlanguage() {
        return pdtlanguage;
    }

    public void setPdtlanguage(String pdtlanguage) {
        this.pdtlanguage = pdtlanguage;
    }

    public Integer getPdtusage() {
        return pdtusage;
    }

    public void setPdtusage(Integer pdtusage) {
        this.pdtusage = pdtusage;
    }

    public Double getLatestprice() {
        return latestprice;
    }

    public void setLatestprice(Double latestprice) {
        this.latestprice = latestprice;
    }

    public Integer getPricecount() {
        return pricecount;
    }

    public void setPricecount(Integer pricecount) {
        this.pricecount = pricecount;
    }

    public LocalDate getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(LocalDate releasetime) {
        this.releasetime = releasetime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Productinfo{" +
        "pdtid=" + pdtid +
        ", pdtname=" + pdtname +
        ", country=" + country +
        ", pdtlanguage=" + pdtlanguage +
        ", pdtusage=" + pdtusage +
        ", latestprice=" + latestprice +
        ", pricecount=" + pricecount +
        ", releasetime=" + releasetime +
        ", notes=" + notes +
        "}";
    }
}
