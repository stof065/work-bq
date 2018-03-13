package com.own.bq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.own.bq.dto.DummyDto;
import com.own.bq.service.DummyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dummies")
public class DummyController {

	@Autowired
	DummyService dummyService;

	@GetMapping
	@ApiOperation(value = "extraire tout les dummies")
	public List<DummyDto> getAllDummies() {
		return dummyService.findAllDummyDto();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "extraire un dummy par id")
	public DummyDto getDummy(@PathVariable("id") Long id) {
		return dummyService.findDummy(id);
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "creer un dummy")
	public DummyDto saveDummy(@Validated @RequestBody DummyDto dummy) {
		return dummyService.save(dummy);
	}
	
	@DeleteMapping(value="/{id}",produces="application/json")
	@ApiOperation(value = "supprimer un dummy par id")
	public void deleteDummy(@PathVariable("id") Long id) {
		
		dummyService.removeDummy(id);
	}
	
	
}
