package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseDao enterpriseDao;

    @Override
    public Enterprise insertEnterprise(Enterprise enterprise) {
        return enterpriseDao.save(enterprise);
    }

    @Override
    public List<Enterprise> findAllEnterprise() {
        return (List<Enterprise>) enterpriseDao.findAll();
    }
}
