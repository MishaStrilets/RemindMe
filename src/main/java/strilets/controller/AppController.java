package strilets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import strilets.service.LetterService;

@Controller
public class AppController {

	LetterService letterService;

	@Autowired
	public void setUserService(LetterService letterService) {
		this.letterService = letterService;
	}

	/**
	 * This method will return home page.
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
