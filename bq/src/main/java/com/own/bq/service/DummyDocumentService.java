package com.own.bq.service;

import java.util.ArrayList;
import java.util.List;

import org.bq.elastic.model.DummyDocument;
import org.bq.elastic.repository.DummyDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.bq.dto.DummyDocumentDto;

@Service
public class DummyDocumentService {

	private static final Logger LOG = LoggerFactory.getLogger(DummyDocumentService.class);

	@Autowired
	DummyDocumentRepository dummyDocumentRepository;

	public List<DummyDocumentDto> findAllDummyDocs() {
		List<DummyDocumentDto> result = new ArrayList<>();
		dummyDocumentRepository.findAll().forEach(dd -> result.add(new DummyDocumentDto(dd)));
		return result;
	}

	public DummyDocumentDto save(DummyDocumentDto dummy) {

		DummyDocument dd = new DummyDocument();
		dd.setName(dummy.getName());
		return new DummyDocumentDto(dummyDocumentRepository.save(dd));
	}

}
