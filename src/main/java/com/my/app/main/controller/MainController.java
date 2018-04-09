package com.my.app.main.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/main")
	public String main(Model model) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		model.addAttribute("timestamp", timestamp);
		return "main/main";
	}

	@GetMapping(value = "/get")
	public ResponseEntity<Object> get() {
		return ResponseEntity.ok().build();
	}

}
