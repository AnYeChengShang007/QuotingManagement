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
public class PriceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vendorid;

    private String vendorname;

    private String pdtid;

    private String phone;

    private String email;

    private Double realtimeprice;

    private LocalDate pricetime;


    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getPdtid() {
        return pdtid;
    }

    public void setPdtid(String pdtid) {
        this.pdtid = pdtid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getRealtimeprice() {
        return realtimeprice;
    }

    public void setRealtimeprice(Double realtimeprice) {
        this.realtimeprice = realtimeprice;
    }

    public LocalDate getPricetime() {
        return pricetime;
    }

    public void setPricetime(LocalDate pricetime) {
        this.pricetime = pricetime;
    }

    @Override
    public String toString() {
        return "Priceinfo{" +
        "vendorid=" + vendorid +
        ", vendorname=" + vendorname +
        ", pdtid=" + pdtid +
        ", phone=" + phone +
        ", email=" + email +
        ", realtimeprice=" + realtimeprice +
        ", pricetime=" + pricetime +
        "}";
    }
}
