package com.zain.dao;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by qhasan on 5/21/2017.
 */
@Repository
public class ResourceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Map<String, ClassMetadata> getMetadata(){
        return sessionFactory.getAllClassMetadata();
    }
}


