package com.pagination.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="engineermst_em")
public class EntityEngineerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="typeid_em")
	private Long typeidEm;
		
	
	@Column(name="loginid_em")
	private String loginidEm;
	
	@Column(name="role_rm_em")
	private String roleRmEm;

	@Column(name="region_em")
	private String regionEm;
	
	@Column(name="city_cm_em")
	private String cityCmEm;
	
//	@NotBlank(message = "First Name cannot be blank")
//	@Size(max = 10, message = "Name must be at most 10 characters")
	@Column(name="fname_em")
	private String fnameEm;
//	@NotBlank(message = "Last Name cannot be blank")
//	@Size(max = 10, message = "Name must be at most 10 characters")
	@Column(name="lname_em")
	private String lnameEm;
    	
	@Column(name="state_sm_em")
	private String stateSmEm;

	@Column(name="resignedflag_em")
	private String resignedFlagEm;
	
	@Column(name="deleteflag_em")
	private String deleteFlagEm;
	
	@Column(name="password_em")
	private String passwordEm;
}
