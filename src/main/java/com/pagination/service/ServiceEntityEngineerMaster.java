package com.pagination.service;

import org.springframework.data.domain.Page;

import com.pagination.dto.DtoJsonResponce;
import com.pagination.entity.EntityEngineerMaster;

public interface ServiceEntityEngineerMaster {

	Page<EntityEngineerMaster> findElementWithPages(int offset , int pagesize);
	
	DtoJsonResponce getAllPosts(int pageNo, int pageSize);
}
