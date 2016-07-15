package com.chungho.rest.dao;

import com.chungho.rest.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chungho on 7/11/16.
 */

import javax.xml.bind.JAXBElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum ResumeDao {

    instance;

    private int id = 1;
    private Map<Integer, Resume> storedData = new HashMap<>();

    ResumeDao() {
        Resume r1 = new Resume();
        r1.setName("chungho");
        r1.setTitle("java");
        r1.setDescription("write a program");
        r1.setCompany("kaiser");
        storedData.put(id++, r1);
    }

    public int setModel(Resume r){
        storedData.put(id, r);
        return id++;
    }

    public Resume getModelbyId(String id){
        Integer.parseInt(id);
        return storedData.get(Integer.parseInt(id));
    }

}
