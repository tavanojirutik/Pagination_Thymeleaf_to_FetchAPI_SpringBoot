package com.pagination.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginatioinControl {

	
	@GetMapping("/firstpage")
	public String returnPage(Model model) {
		return "pageno";
	}
}
