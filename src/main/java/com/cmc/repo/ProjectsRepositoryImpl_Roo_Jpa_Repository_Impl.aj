// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.repo;

import com.cmc.domain.Projects;
import com.cmc.domain.QProjects;
import com.cmc.repo.GlobalSearch;
import com.cmc.repo.ProjectsRepositoryCustom;
import com.cmc.repo.ProjectsRepositoryImpl;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.NumberPath;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProjectsRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare parents: ProjectsRepositoryImpl implements ProjectsRepositoryCustom;
    
    declare @type: ProjectsRepositoryImpl: @Transactional(readOnly = true);
    
    public Page<Projects> ProjectsRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        NumberPath<Long> idProjects = new NumberPath<Long>(Long.class, "id");
        QProjects projects = QProjects.projects;
        JPQLQuery query = getQueryFrom(projects);
        BooleanBuilder where = new BooleanBuilder();

        if (globalSearch != null) {
            String txt = globalSearch.getText();
            where.and(
                projects.name.containsIgnoreCase(txt)
                .or(projects.status.like("%".concat(txt).concat("%")))
                .or(projects.description.containsIgnoreCase(txt))
                .or(projects.identifier.containsIgnoreCase(txt))
            );

        }
        query.where(where);

        long totalFound = query.count();
        if (pageable != null) {
            if (pageable.getSort() != null) {
                for (Sort.Order order : pageable.getSort()) {
                    Order direction = order.isAscending() ? Order.ASC : Order.DESC;

                    switch(order.getProperty()){
                        case "name":
                           query.orderBy(new OrderSpecifier<String>(direction, projects.name));
                           break;
                        case "status":
                           query.orderBy(new OrderSpecifier<Integer>(direction, projects.status));
                           break;
                        case "description":
                           query.orderBy(new OrderSpecifier<String>(direction, projects.description));
                           break;
                        case "identifier":
                           query.orderBy(new OrderSpecifier<String>(direction, projects.identifier));
                           break;
                    }
                }
            }
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }
        query.orderBy(idProjects.asc());
        
        List<Projects> results = query.list(projects);
        return new PageImpl<Projects>(results, pageable, totalFound);
    }
    
}
