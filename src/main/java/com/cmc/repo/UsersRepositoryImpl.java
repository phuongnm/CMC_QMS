package com.cmc.repo;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.cmc.domain.Users;
import com.cmc.domain.QUsers;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = UsersRepositoryCustom.class)
public class UsersRepositoryImpl extends QueryDslRepositorySupport{

    UsersRepositoryImpl() {
        super(Users.class);
    }
    
    private JPQLQuery getQueryFrom(QUsers qEntity){
        return from(qEntity);
    }
}