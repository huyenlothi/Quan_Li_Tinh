package com.quanli.model;

import javax.persistence.*;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProvince;

    public Province() {
    }

    public Province(Long id, String province) {
        this.id = id;
        this.nameProvince = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String province) {
        this.nameProvince = province;
    }
}
