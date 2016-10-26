package com.cmc.repo;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.cmc.domain.Issues;
import com.cmc.domain.QIssues;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = IssuesRepositoryCustom.class)
public class IssuesRepositoryImpl extends QueryDslRepositorySupport{

    IssuesRepositoryImpl() {
        super(Issues.class);
    }
    
    private JPQLQuery getQueryFrom(QIssues qEntity){
        return from(qEntity);
    }
}