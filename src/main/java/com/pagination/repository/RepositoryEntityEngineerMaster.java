package com.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagination.entity.EntityEngineerMaster;

@Repository
public interface RepositoryEntityEngineerMaster extends JpaRepository<EntityEngineerMaster, Long>{

	
}
