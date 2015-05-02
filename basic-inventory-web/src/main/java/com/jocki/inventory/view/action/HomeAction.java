package com.jocki.inventory.view.action;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeAction {

	@RequestMapping("home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("emptyTable")	
	public String emptyTable() {
		Map<String, ? super Object> properties = new HashMap<>();
		properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("javax.persistence.jtaDataSource", "java:comp/env/jdbc/inventory");
		Persistence.generateSchema("mainPU", properties);
		return "redirect:home";
	}
	
	@RequestMapping("resetDatabase")
	public String resetDatabase() {
		Map<String, ? super Object> properties = new HashMap<>();
		properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("javax.persistence.jtaDataSource", "java:comp/env/jdbc/inventory");
		properties.put("javax.persistence.sql-load-script-source", "sandbox.sql");
		Persistence.generateSchema("mainPU", properties);
		return "redirect:home";
	}
	
}
