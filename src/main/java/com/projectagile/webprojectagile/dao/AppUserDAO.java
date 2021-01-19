package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Repository
@Transactional
public class AppUserDAO {

    @Autowired
    private EntityManager entityManager;
    public AppUser findUserAccount(String UserName){
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", UserName);
 
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    }
    

