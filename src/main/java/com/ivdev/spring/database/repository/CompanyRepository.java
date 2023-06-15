package com.ivdev.spring.database.repository;

import com.ivdev.spring.bpp.InjectBean;
import com.ivdev.spring.bpp.Transaction;
import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import javax.sql.ConnectionPoolDataSource;
import java.util.Optional;

@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company>{

    //custom annotation over field for inject bean
    @InjectBean
    private ConnectionPool connectionPool;

    //to see how lifecycle bean works here
    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method..");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company Entity) {
        System.out.println("delete method..");
    }
}
