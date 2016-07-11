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

    private ResumeDao() {
        Resume r1 = new Resume();
        r1.setName("c");
        r1.setTitle("java");
        r1.setDescription("coding");
        r1.setCompany("kaiserxxcv");
        storedData.put(id++, r1);
    }

    public int setModel(JAXBElement<Resume> resume){
        Resume r = resume.getValue();
//        Resume r2 = new Resume("chungho", "jdcdava ", "coding", "kaiscvdsfer");
        storedData.put(id, r);
        return id++;
    }

    public Resume getModelbyId(String id){
        Integer.parseInt(id);
        return storedData.get(Integer.parseInt(id));
    }

}
