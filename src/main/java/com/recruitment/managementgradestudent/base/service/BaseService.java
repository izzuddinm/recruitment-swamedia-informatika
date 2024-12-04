package com.recruitment.managementgradestudent.base.service;

import com.recruitment.managementgradestudent.base.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {

    @Autowired
    private HttpService httpService;
}
