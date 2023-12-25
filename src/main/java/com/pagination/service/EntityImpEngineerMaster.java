package com.pagination.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Collections;

import com.pagination.dto.DtoEngineerMaster;
import com.pagination.dto.DtoJsonResponce;
import com.pagination.entity.EntityEngineerMaster;
import com.pagination.repository.RepositoryEntityEngineerMaster;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class EntityImpEngineerMaster implements ServiceEntityEngineerMaster{
	
	
	@Autowired
	private RepositoryEntityEngineerMaster repositoryEntityEngineerMaster;

	@Override
	public Page<EntityEngineerMaster> findElementWithPages(int offset, int pagesize) {
		Page<EntityEngineerMaster> pages=  repositoryEntityEngineerMaster.findAll(PageRequest.of(offset, pagesize));
		return pages;
	}

	@Override
	public DtoJsonResponce getAllPosts(int pageNo, int pageSize) {
		// create Pageable instance
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EntityEngineerMaster> entityEnginnerPage = repositoryEntityEngineerMaster.findAll(pageable);
        List<EntityEngineerMaster> listOfPosts = entityEnginnerPage.getContent();
        
        
        List<DtoEngineerMaster> content= listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        DtoJsonResponce json=new DtoJsonResponce();
        json.setPageNo(entityEnginnerPage.getNumber());
        json.setPageSize(entityEnginnerPage.getSize());
        json.setTotalElements(entityEnginnerPage.getTotalElements());
        json.setTotalPages(entityEnginnerPage.getTotalPages());
        json.setLast(entityEnginnerPage.isLast());        
        json.setContent(content);
		return json;
	}
	
	
	private DtoEngineerMaster mapToDTO(EntityEngineerMaster post){
		DtoEngineerMaster postDto = new DtoEngineerMaster();
        postDto.setTypeidEm(post.getTypeidEm());
        postDto.setLoginidEm(post.getLoginidEm());
        postDto.setRoleRmEm(post.getRoleRmEm());
        postDto.setRegionEm(post.getRegionEm());
        postDto.setFnameEm(post.getFnameEm());
        postDto.setLnameEm(post.getLnameEm());
        postDto.setStateSmEm(post.getStateSmEm());
        return postDto;
    }

	
	
}
