package com.ivdev.spring.database.repository;

import com.ivdev.spring.bpp.Auditing;
import com.ivdev.spring.bpp.InjectBean;
import com.ivdev.spring.bpp.Transaction;
import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.ConnectionPoolDataSource;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company>{

    //Resource injects by bean name
//    @Resource(name = "pool1")
//    @Qualifier("pool1")
    //in practice, we can use field name like bean name in context
    private ConnectionPool pool1;

    @Autowired
    private List<ConnectionPool> pools;

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
