package com.own.bq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.own.bq.dto.DummyDocumentDto;
import com.own.bq.service.DummyDocumentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dummiesdocs")
public class DummyDocumentController {

	@Autowired
	DummyDocumentService dummyDocumentService;

	@GetMapping
	@ApiOperation(value = "extraire tout les dummies document")
	public List<DummyDocumentDto> getAllDummiesDocs() {
		return dummyDocumentService.findAllDummyDocs();
	}
	//
	// @GetMapping("/{id}")
	// @ApiOperation(value = "extraire un dummy par id")
	// public DummyDto getDummy(@PathVariable("id") Long id) {
	// return dummyService.findDummy(id);
	// }
	//
	//
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 @ApiOperation(value = "creer un dummy document")
	 public DummyDocumentDto saveDummy(@Validated @RequestBody DummyDocumentDto dummy) {
	 return dummyDocumentService.save(dummy);
	 }
	//
	// @DeleteMapping(value="/{id}",produces="application/json")
	// @ApiOperation(value = "supprimer un dummy par id")
	// public void deleteDummy(@PathVariable("id") Long id) {
	//
	// dummyService.removeDummy(id);
	// }
	//
	//
}
