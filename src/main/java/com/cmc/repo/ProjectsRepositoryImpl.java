package com.cmc.repo;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.cmc.domain.Projects;
import com.cmc.domain.QProjects;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = ProjectsRepositoryCustom.class)
public class ProjectsRepositoryImpl extends QueryDslRepositorySupport{

    ProjectsRepositoryImpl() {
        super(Projects.class);
    }
    
    private JPQLQuery getQueryFrom(QProjects qEntity){
        return from(qEntity);
    }
}