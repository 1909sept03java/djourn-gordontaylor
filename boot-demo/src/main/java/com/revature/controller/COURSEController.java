package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.COURSE;
import com.revature.model.COURSE;
import com.revature.service.COURSEService;

@RestController 
@RequestMapping(value = "/Course")
public class COURSEController {

	private COURSEService COURSEService;

	@Autowired // setter injection
	public void setCOURSEService(COURSEService COURSEService) {
		this.COURSEService = COURSEService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<COURSE>> getAll() {
		return new ResponseEntity<>(this.COURSEService.allCOURSEs(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<COURSE> getCOURSEById(@PathVariable int id) {
		COURSE f = this.COURSEService.getCOURSEbyId(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) // parameterize the path
	public ResponseEntity<COURSE> UpdateCOURSEById(@PathVariable int id,String name) {
		COURSE f = this.COURSEService.getCOURSEbyId(id);
		
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			
			this.COURSEService.deleteCOURSE(f);
			f.setname(name);
			this.COURSEService.addCOURSE(f);
			
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST) // parameterize the path
	public ResponseEntity<COURSE> deleteCOURSEById(@PathVariable int id,String name) {
		COURSE f = this.COURSEService.getCOURSEbyId(id);
		
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			
		this.COURSEService.deleteCOURSE(f);
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<COURSE> getCOURSEByIdWithQueryString(@RequestParam int id) {
		COURSE f = this.COURSEService.getCOURSEbyId(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addCOURSE(@Valid @RequestBody COURSE COURSE) {
		ResponseEntity<String> resp = null;
		try {
			this.COURSEService.addCOURSE(COURSE);
			resp = new ResponseEntity<>("COURSE CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO CREATE COURSE", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
