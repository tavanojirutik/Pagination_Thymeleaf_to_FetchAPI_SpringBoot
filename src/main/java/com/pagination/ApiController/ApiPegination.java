package com.pagination.ApiController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.dto.DtoJsonResponce;
import com.pagination.entity.EntityEngineerMaster;
import com.pagination.service.ServiceEntityEngineerMaster;

@RestController
public class ApiPegination {
  
	@Autowired
	private ServiceEntityEngineerMaster serviceEntityEngineerMaster;
	
	   @GetMapping("/pagination")
	    public ResponseEntity<?> findProductsWithPagination(
	            @RequestParam(name="pageNo",defaultValue = "1") String m_Strpage,
	            @RequestParam(name="pageSize",defaultValue = "20") String m_strSize) {
	        
	        Page<EntityEngineerMaster> pagesAndField =
	                serviceEntityEngineerMaster.findElementWithPages(Integer.parseInt(m_Strpage), Integer.parseInt(m_strSize));
	        
	        System.err.println("API Hit pagination");
	     // Create a List<EntityEngineerMaster> to store the retrieved data
	        List<EntityEngineerMaster> engineersList = new ArrayList<>();

	        // Iterating through the content and adding each element to the list
	        for (EntityEngineerMaster engineer : pagesAndField.getContent()) {
	        	System.out.println("API hit");
	        	System.out.println(engineer+"  ROKCY BHAI");
	            engineersList.add(engineer);
	        }
	        
	        
	        return ResponseEntity.status(HttpStatus.OK).header("custom-header", "DirectApproximationMargin")
			 		.contentType(MediaType.APPLICATION_JSON).body(engineersList);
	    }
	
	   
	   @Autowired
	   private ServiceEntityEngineerMaster serviceEntityEngineerMaster2;
	   
	  @GetMapping("/getpagelist")
	  private ResponseEntity<?> getPagesWithPageSize(
	  @RequestParam(name="pageNo",defaultValue = "1") String m_strPageNo,
	  @RequestParam(name="pageSize",defaultValue = "3") String m_strPageSize){ 
		  
		  System.out.println("Received Parameter in API PAGENO= "+m_strPageNo+ " Pagre Size "+m_strPageSize);
		  DtoJsonResponce json=  serviceEntityEngineerMaster2.getAllPosts(Integer.parseInt(m_strPageNo),Integer.parseInt(m_strPageSize));
		  
		   
		  return ResponseEntity.status(HttpStatus.OK).header("custom-header", "DirectApproximationMargin")
					.contentType(MediaType.APPLICATION_JSON).body(json);
	  }
	
}
