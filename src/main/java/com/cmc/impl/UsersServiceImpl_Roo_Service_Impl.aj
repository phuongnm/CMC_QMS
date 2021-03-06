// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.impl;

import com.cmc.domain.Users;
import com.cmc.impl.UsersServiceImpl;
import com.cmc.repo.GlobalSearch;
import com.cmc.repo.UsersRepository;
import com.cmc.svr.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UsersServiceImpl_Roo_Service_Impl {
    
    declare parents: UsersServiceImpl implements UsersService;
    
    declare @type: UsersServiceImpl: @Service;
    
    declare @type: UsersServiceImpl: @Transactional(readOnly = true);
    
    public UsersRepository UsersServiceImpl.usersRepository;
    
    @Autowired
    public UsersServiceImpl.new(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional(readOnly = false)
    public Users UsersServiceImpl.save(Users entity) {
        return usersRepository.save(entity);
    }
    
    @Transactional(readOnly = false)
    public void UsersServiceImpl.delete(Long id) {
         usersRepository.delete(id);
    }
    
    @Transactional(readOnly = false)
    public List<Users> UsersServiceImpl.save(Iterable<Users> entities) {
        return usersRepository.save(entities);
    }
    
    @Transactional(readOnly = false)
    public void UsersServiceImpl.delete(Iterable<Long> ids) {
        List<Users> toDelete = usersRepository.findAll(ids);
        usersRepository.deleteInBatch(toDelete);
    }
    
    public List<Users> UsersServiceImpl.findAll() {
        return usersRepository.findAll();
    }
    
    public List<Users> UsersServiceImpl.findAll(Iterable<Long> ids) {
        return usersRepository.findAll(ids);
    }
    
    public Users UsersServiceImpl.findOne(Long id) {
        return usersRepository.findOne(id);
    }
    
    public long UsersServiceImpl.count() {
        return usersRepository.count();
    }
    
    public Page<Users> UsersServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return usersRepository.findAll(globalSearch, pageable);
    }
    
}
