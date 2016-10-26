// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.repo;

import com.cmc.domain.Issues;
import com.cmc.domain.Projects;
import com.cmc.domain.QIssues;
import com.cmc.domain.Users;
import com.cmc.repo.GlobalSearch;
import com.cmc.repo.IssuesRepositoryCustom;
import com.cmc.repo.IssuesRepositoryImpl;
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

privileged aspect IssuesRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare parents: IssuesRepositoryImpl implements IssuesRepositoryCustom;
    
    declare @type: IssuesRepositoryImpl: @Transactional(readOnly = true);
    
    public Page<Issues> IssuesRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        NumberPath<Long> idIssues = new NumberPath<Long>(Long.class, "id");
        QIssues issues = QIssues.issues;
        JPQLQuery query = getQueryFrom(issues);
        BooleanBuilder where = new BooleanBuilder();

        if (globalSearch != null) {
            String txt = globalSearch.getText();
            where.and(
                issues.trackerId.like("%".concat(txt).concat("%"))
                .or(issues.subject.containsIgnoreCase(txt))
                .or(issues.description.containsIgnoreCase(txt))
                .or(issues.statusId.like("%".concat(txt).concat("%")))
                .or(issues.doneRatio.like("%".concat(txt).concat("%")))
            );

        }
        query.where(where);

        long totalFound = query.count();
        if (pageable != null) {
            if (pageable.getSort() != null) {
                for (Sort.Order order : pageable.getSort()) {
                    Order direction = order.isAscending() ? Order.ASC : Order.DESC;

                    switch(order.getProperty()){
                        case "trackerId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.trackerId));
                           break;
                        case "subject":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.subject));
                           break;
                        case "description":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.description));
                           break;
                        case "statusId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.statusId));
                           break;
                        case "doneRatio":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.doneRatio));
                           break;
                    }
                }
            }
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }
        query.orderBy(idIssues.asc());
        
        List<Issues> results = query.list(issues);
        return new PageImpl<Issues>(results, pageable, totalFound);
    }
    
    public Page<Issues> IssuesRepositoryImpl.findAllByProjects(Projects projectsField, GlobalSearch globalSearch, Pageable pageable) {
        NumberPath<Long> idIssues = new NumberPath<Long>(Long.class, "id");
        QIssues issues = QIssues.issues;
        JPQLQuery query = getQueryFrom(issues);
        BooleanBuilder where = new BooleanBuilder(issues.projecId.eq(projectsField));

        if (globalSearch != null) {
            String txt = globalSearch.getText();
            where.and(
                issues.trackerId.like("%".concat(txt).concat("%"))
                .or(issues.subject.containsIgnoreCase(txt))
                .or(issues.description.containsIgnoreCase(txt))
                .or(issues.statusId.like("%".concat(txt).concat("%")))
                .or(issues.doneRatio.like("%".concat(txt).concat("%")))
            );

        }
        query.where(where);

        long totalFound = query.count();
        if (pageable != null) {
            if (pageable.getSort() != null) {
                for (Sort.Order order : pageable.getSort()) {
                    Order direction = order.isAscending() ? Order.ASC : Order.DESC;

                    switch(order.getProperty()){
                        case "trackerId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.trackerId));
                           break;
                        case "subject":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.subject));
                           break;
                        case "description":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.description));
                           break;
                        case "statusId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.statusId));
                           break;
                        case "doneRatio":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.doneRatio));
                           break;
                    }
                }
            }
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }
        query.orderBy(idIssues.asc());
        
        List<Issues> results = query.list(issues);
        return new PageImpl<Issues>(results, pageable, totalFound);
    }
    
    public Page<Issues> IssuesRepositoryImpl.findAllByUsers(Users usersField, GlobalSearch globalSearch, Pageable pageable) {
        NumberPath<Long> idIssues = new NumberPath<Long>(Long.class, "id");
        QIssues issues = QIssues.issues;
        JPQLQuery query = getQueryFrom(issues);
        BooleanBuilder where = new BooleanBuilder(issues.assignedToId.eq(usersField));

        if (globalSearch != null) {
            String txt = globalSearch.getText();
            where.and(
                issues.trackerId.like("%".concat(txt).concat("%"))
                .or(issues.subject.containsIgnoreCase(txt))
                .or(issues.description.containsIgnoreCase(txt))
                .or(issues.statusId.like("%".concat(txt).concat("%")))
                .or(issues.doneRatio.like("%".concat(txt).concat("%")))
            );

        }
        query.where(where);

        long totalFound = query.count();
        if (pageable != null) {
            if (pageable.getSort() != null) {
                for (Sort.Order order : pageable.getSort()) {
                    Order direction = order.isAscending() ? Order.ASC : Order.DESC;

                    switch(order.getProperty()){
                        case "trackerId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.trackerId));
                           break;
                        case "subject":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.subject));
                           break;
                        case "description":
                           query.orderBy(new OrderSpecifier<String>(direction, issues.description));
                           break;
                        case "statusId":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.statusId));
                           break;
                        case "doneRatio":
                           query.orderBy(new OrderSpecifier<Integer>(direction, issues.doneRatio));
                           break;
                    }
                }
            }
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }
        query.orderBy(idIssues.asc());
        
        List<Issues> results = query.list(issues);
        return new PageImpl<Issues>(results, pageable, totalFound);
    }
    
}
