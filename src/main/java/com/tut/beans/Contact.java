package com.tut.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the contact")
public class Contact {

    @ApiModelProperty(notes = "it mush be 2-3 digit number")
    private String id;

    @ApiModelProperty(notes = "It must be a combination of firstname + lastname")
    private String name;

    @ApiModelProperty(notes = "must start with 0")
    private String phone;

    public Contact(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }
}
