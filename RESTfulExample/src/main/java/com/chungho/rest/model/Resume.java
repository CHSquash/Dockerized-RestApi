package com.chungho.rest.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Resume {


    private String name;

    private String title;

    private String description;

    private String company;


    public Resume(){}


    public Resume ( String name,  String title,  String description, String company){
        this.name = name;
        this.title = title;
        this.description = description;
        this.company = company;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }


}