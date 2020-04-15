package com.scholanova.ecommerce.product.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column
    private String description;
    @Column
    private float priceVatExcluded;
    @Column
    private float vat;
    @Column
    private String currency;

    public Product() {
    }

    public static Product create(String name, String description, float priceVatExcluded, float vat, String currency){
        Product entity = new Product();
        entity.name = name;
        entity.description = description;
        entity.priceVatExcluded = priceVatExcluded;
        entity.vat = vat;
        entity.currency = currency;
        return entity;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceVatExcluded() {return priceVatExcluded;}

    public void setPriceVatExcluded(float priceVatExcluded) {
        this.priceVatExcluded = priceVatExcluded;
    }

    public float getVat() {return vat;}

    public void setVat(float vat) {
        this.vat = vat;
    }

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
