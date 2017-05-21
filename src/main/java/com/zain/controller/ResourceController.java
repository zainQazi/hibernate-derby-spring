package com.zain.controller;

import com.zain.dao.ResourceDao;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by qhasan on 5/21/2017.
 */
@RestController
@RequestMapping("/")
public class ResourceController {

    @Autowired
    private ResourceDao resourceDao;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, ClassMetadata> sayHello(){
        //// TODO: 5/21/2017 try to return all endpoints
        return resourceDao.getMetadata();
    }




}
