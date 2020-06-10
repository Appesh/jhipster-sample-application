package com.guitarcenter.lessons.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link CourselinesSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class CourselinesSearchRepositoryMockConfiguration {
    @MockBean
    private CourselinesSearchRepository mockCourselinesSearchRepository;
}
