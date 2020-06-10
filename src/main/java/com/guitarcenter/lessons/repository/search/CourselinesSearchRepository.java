package com.guitarcenter.lessons.repository.search;

import com.guitarcenter.lessons.domain.Courselines;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Courselines} entity.
 */
public interface CourselinesSearchRepository extends ElasticsearchRepository<Courselines, Long> {}
