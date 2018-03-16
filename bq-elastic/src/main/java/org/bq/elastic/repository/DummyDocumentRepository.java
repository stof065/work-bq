package org.bq.elastic.repository;

import org.bq.elastic.model.DummyDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DummyDocumentRepository extends ElasticsearchRepository<DummyDocument, Long> {

	

}
