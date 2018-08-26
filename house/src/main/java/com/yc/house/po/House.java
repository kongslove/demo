package com.yc.house.po;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class House {
    private Integer id;

    private Integer userId;
    
    @NotNull(message="请选择户型")
    private Integer typeId;

    private String title;
    @NotNull(message="价格必填")
    private Double price;

    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date pubdate;

    private Integer floorage;
    
    @NotEmpty(message="电话号码必填")
    private String contact;
    
   
    private Integer streetId;

    private String description;

    private Integer districtId;
    
    private District district;
    
    private Street street;

    
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}


	@Override
	public String toString() {
		return "House [id=" + id + ", userId=" + userId + ", typeId=" + typeId + ", title=" + title + ", price=" + price
				+ ", pubdate=" + pubdate + ", floorage=" + floorage + ", contact=" + contact + ", streetId=" + streetId
				+ ", description=" + description + ", districtId=" + districtId + ", district=" + district + ", street="
				+ street + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
}