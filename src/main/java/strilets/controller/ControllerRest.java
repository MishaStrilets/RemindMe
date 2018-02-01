package strilets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import strilets.model.Letter;
import strilets.service.LetterService;

@RestController
public class ControllerRest {

	LetterService letterService;

	@Autowired
	public void setUserService(LetterService letterService) {
		this.letterService = letterService;
	}

	@PostMapping("/api")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody Letter letter, Errors errors) {

		if (errors.hasErrors())
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

		letterService.saveLetter(letter);

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}