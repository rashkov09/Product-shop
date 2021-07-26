package com.example.productshop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "category")

@XmlAccessorType(XmlAccessType.FIELD)

public class CategorySeedDto implements Serializable {

        @XmlElement(name = "name")
        private String name;

    public CategorySeedDto() {
    }

    @Size(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
