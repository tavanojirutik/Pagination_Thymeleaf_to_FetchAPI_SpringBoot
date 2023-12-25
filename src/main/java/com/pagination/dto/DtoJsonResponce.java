package com.pagination.dto;

import lombok.Data;
import java.util.List;
@Data
public class DtoJsonResponce {

	
	private List<DtoEngineerMaster> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;	
}
