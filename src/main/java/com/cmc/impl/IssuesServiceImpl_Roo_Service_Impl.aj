// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.impl;

import com.cmc.domain.Issues;
import com.cmc.domain.Projects;
import com.cmc.domain.Users;
import com.cmc.impl.IssuesServiceImpl;
import com.cmc.repo.GlobalSearch;
import com.cmc.repo.IssuesRepository;
import com.cmc.svr.IssuesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect IssuesServiceImpl_Roo_Service_Impl {
    
    declare parents: IssuesServiceImpl implements IssuesService;
    
    declare @type: IssuesServiceImpl: @Service;
    
    declare @type: IssuesServiceImpl: @Transactional(readOnly = true);
    
    public IssuesRepository IssuesServiceImpl.issuesRepository;
    
    @Autowired
    public IssuesServiceImpl.new(IssuesRepository issuesRepository) {
        this.issuesRepository = issuesRepository;
    }

    @Transactional(readOnly = false)
    public Issues IssuesServiceImpl.save(Issues entity) {
        return issuesRepository.save(entity);
    }
    
    @Transactional(readOnly = false)
    public void IssuesServiceImpl.delete(Long id) {
         issuesRepository.delete(id);
    }
    
    @Transactional(readOnly = false)
    public List<Issues> IssuesServiceImpl.save(Iterable<Issues> entities) {
        return issuesRepository.save(entities);
    }
    
    @Transactional(readOnly = false)
    public void IssuesServiceImpl.delete(Iterable<Long> ids) {
        List<Issues> toDelete = issuesRepository.findAll(ids);
        issuesRepository.deleteInBatch(toDelete);
    }
    
    public List<Issues> IssuesServiceImpl.findAll() {
        return issuesRepository.findAll();
    }
    
    public List<Issues> IssuesServiceImpl.findAll(Iterable<Long> ids) {
        return issuesRepository.findAll(ids);
    }
    
    public Issues IssuesServiceImpl.findOne(Long id) {
        return issuesRepository.findOne(id);
    }
    
    public long IssuesServiceImpl.count() {
        return issuesRepository.count();
    }
    
    public List<Issues> IssuesServiceImpl.findByDoneRatioEquals(int doneRatio) {
        return issuesRepository.findByDoneRatioEquals(doneRatio);
    }
    
    public Page<Issues> IssuesServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return issuesRepository.findAll(globalSearch, pageable);
    }
    
    public Long IssuesServiceImpl.countByProjecIdId(Long id) {
        return issuesRepository.countByProjecIdId(id);
    }
    
    public Long IssuesServiceImpl.countByAssignedToIdId(Long id) {
        return issuesRepository.countByAssignedToIdId(id);
    }
    
    public Page<Issues> IssuesServiceImpl.findAllByProjects(Projects projectsField, GlobalSearch globalSearch, Pageable pageable) {
        return issuesRepository.findAllByProjects(projectsField, globalSearch, pageable);
    }
    
    public Page<Issues> IssuesServiceImpl.findAllByUsers(Users usersField, GlobalSearch globalSearch, Pageable pageable) {
        return issuesRepository.findAllByUsers(usersField, globalSearch, pageable);
    }
    
}
