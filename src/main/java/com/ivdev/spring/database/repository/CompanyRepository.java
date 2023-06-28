package com.ivdev.spring.database.repository;

import com.ivdev.spring.bpp.Auditing;
import com.ivdev.spring.bpp.Transaction;
import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company>{

    //in practice, we can use field name like bean name in context
    private final ConnectionPool pool1;

    //all ConnectionPool-type beans will be injected into pools var
    private final List<ConnectionPool> pools;

    //@Value - for inject values from propertiy-file
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

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
