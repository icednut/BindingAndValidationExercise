package org.springstudy.common.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangeun.lee@sk.com
 */
public class Product {
    @NumberFormat(pattern = "$###,##0.00")
    private BigDecimal price;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date orderDate;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", orderDate=" + orderDate +
                '}';
    }
}
