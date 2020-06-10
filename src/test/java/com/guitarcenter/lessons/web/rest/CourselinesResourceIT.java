package com.guitarcenter.lessons.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.guitarcenter.lessons.JhipsterSampleApplicationApp;
import com.guitarcenter.lessons.domain.Courselines;
import com.guitarcenter.lessons.domain.Courses;
import com.guitarcenter.lessons.repository.CourselinesRepository;
import com.guitarcenter.lessons.repository.search.CourselinesSearchRepository;
import com.guitarcenter.lessons.service.CourselinesQueryService;
import com.guitarcenter.lessons.service.CourselinesService;
import com.guitarcenter.lessons.service.dto.CourselinesCriteria;
import com.guitarcenter.lessons.service.dto.CourselinesDTO;
import com.guitarcenter.lessons.service.mapper.CourselinesMapper;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link CourselinesResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class CourselinesResourceIT {
    private static final String DEFAULT_COURSELINE = "AAAAAAAAAA";
    private static final String UPDATED_COURSELINE = "BBBBBBBBBB";

    private static final String DEFAULT_TEXTDESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_TEXTDESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_HTMLDESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_HTMLDESCRIPTION = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    @Autowired
    private CourselinesRepository courselinesRepository;

    @Autowired
    private CourselinesMapper courselinesMapper;

    @Autowired
    private CourselinesService courselinesService;

    /**
     * This repository is mocked in the com.guitarcenter.lessons.repository.search test package.
     *
     * @see com.guitarcenter.lessons.repository.search.CourselinesSearchRepositoryMockConfiguration
     */
    @Autowired
    private CourselinesSearchRepository mockCourselinesSearchRepository;

    @Autowired
    private CourselinesQueryService courselinesQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCourselinesMockMvc;

    private Courselines courselines;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Courselines createEntity(EntityManager em) {
        Courselines courselines = new Courselines()
            .courseline(DEFAULT_COURSELINE)
            .textdescription(DEFAULT_TEXTDESCRIPTION)
            .htmldescription(DEFAULT_HTMLDESCRIPTION)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE);
        return courselines;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Courselines createUpdatedEntity(EntityManager em) {
        Courselines courselines = new Courselines()
            .courseline(UPDATED_COURSELINE)
            .textdescription(UPDATED_TEXTDESCRIPTION)
            .htmldescription(UPDATED_HTMLDESCRIPTION)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        return courselines;
    }

    @BeforeEach
    public void initTest() {
        courselines = createEntity(em);
    }

    @Test
    @Transactional
    public void createCourselines() throws Exception {
        int databaseSizeBeforeCreate = courselinesRepository.findAll().size();
        // Create the Courselines
        CourselinesDTO courselinesDTO = courselinesMapper.toDto(courselines);
        restCourselinesMockMvc
            .perform(
                post("/api/courselines").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(courselinesDTO))
            )
            .andExpect(status().isCreated());

        // Validate the Courselines in the database
        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeCreate + 1);
        Courselines testCourselines = courselinesList.get(courselinesList.size() - 1);
        assertThat(testCourselines.getCourseline()).isEqualTo(DEFAULT_COURSELINE);
        assertThat(testCourselines.getTextdescription()).isEqualTo(DEFAULT_TEXTDESCRIPTION);
        assertThat(testCourselines.getHtmldescription()).isEqualTo(DEFAULT_HTMLDESCRIPTION);
        assertThat(testCourselines.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testCourselines.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);

        // Validate the Courselines in Elasticsearch
        verify(mockCourselinesSearchRepository, times(1)).save(testCourselines);
    }

    @Test
    @Transactional
    public void createCourselinesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = courselinesRepository.findAll().size();

        // Create the Courselines with an existing ID
        courselines.setId(1L);
        CourselinesDTO courselinesDTO = courselinesMapper.toDto(courselines);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCourselinesMockMvc
            .perform(
                post("/api/courselines").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(courselinesDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Courselines in the database
        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeCreate);

        // Validate the Courselines in Elasticsearch
        verify(mockCourselinesSearchRepository, times(0)).save(courselines);
    }

    @Test
    @Transactional
    public void checkCourselineIsRequired() throws Exception {
        int databaseSizeBeforeTest = courselinesRepository.findAll().size();
        // set the field null
        courselines.setCourseline(null);

        // Create the Courselines, which fails.
        CourselinesDTO courselinesDTO = courselinesMapper.toDto(courselines);

        restCourselinesMockMvc
            .perform(
                post("/api/courselines").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(courselinesDTO))
            )
            .andExpect(status().isBadRequest());

        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCourselines() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList
        restCourselinesMockMvc
            .perform(get("/api/courselines?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(courselines.getId().intValue())))
            .andExpect(jsonPath("$.[*].courseline").value(hasItem(DEFAULT_COURSELINE)))
            .andExpect(jsonPath("$.[*].textdescription").value(hasItem(DEFAULT_TEXTDESCRIPTION)))
            .andExpect(jsonPath("$.[*].htmldescription").value(hasItem(DEFAULT_HTMLDESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }

    @Test
    @Transactional
    public void getCourselines() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get the courselines
        restCourselinesMockMvc
            .perform(get("/api/courselines/{id}", courselines.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(courselines.getId().intValue()))
            .andExpect(jsonPath("$.courseline").value(DEFAULT_COURSELINE))
            .andExpect(jsonPath("$.textdescription").value(DEFAULT_TEXTDESCRIPTION))
            .andExpect(jsonPath("$.htmldescription").value(DEFAULT_HTMLDESCRIPTION.toString()))
            .andExpect(jsonPath("$.imageContentType").value(DEFAULT_IMAGE_CONTENT_TYPE))
            .andExpect(jsonPath("$.image").value(Base64Utils.encodeToString(DEFAULT_IMAGE)));
    }

    @Test
    @Transactional
    public void getCourselinesByIdFiltering() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        Long id = courselines.getId();

        defaultCourselinesShouldBeFound("id.equals=" + id);
        defaultCourselinesShouldNotBeFound("id.notEquals=" + id);

        defaultCourselinesShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultCourselinesShouldNotBeFound("id.greaterThan=" + id);

        defaultCourselinesShouldBeFound("id.lessThanOrEqual=" + id);
        defaultCourselinesShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineIsEqualToSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline equals to DEFAULT_COURSELINE
        defaultCourselinesShouldBeFound("courseline.equals=" + DEFAULT_COURSELINE);

        // Get all the courselinesList where courseline equals to UPDATED_COURSELINE
        defaultCourselinesShouldNotBeFound("courseline.equals=" + UPDATED_COURSELINE);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineIsNotEqualToSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline not equals to DEFAULT_COURSELINE
        defaultCourselinesShouldNotBeFound("courseline.notEquals=" + DEFAULT_COURSELINE);

        // Get all the courselinesList where courseline not equals to UPDATED_COURSELINE
        defaultCourselinesShouldBeFound("courseline.notEquals=" + UPDATED_COURSELINE);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineIsInShouldWork() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline in DEFAULT_COURSELINE or UPDATED_COURSELINE
        defaultCourselinesShouldBeFound("courseline.in=" + DEFAULT_COURSELINE + "," + UPDATED_COURSELINE);

        // Get all the courselinesList where courseline equals to UPDATED_COURSELINE
        defaultCourselinesShouldNotBeFound("courseline.in=" + UPDATED_COURSELINE);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineIsNullOrNotNull() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline is not null
        defaultCourselinesShouldBeFound("courseline.specified=true");

        // Get all the courselinesList where courseline is null
        defaultCourselinesShouldNotBeFound("courseline.specified=false");
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineContainsSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline contains DEFAULT_COURSELINE
        defaultCourselinesShouldBeFound("courseline.contains=" + DEFAULT_COURSELINE);

        // Get all the courselinesList where courseline contains UPDATED_COURSELINE
        defaultCourselinesShouldNotBeFound("courseline.contains=" + UPDATED_COURSELINE);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCourselineNotContainsSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where courseline does not contain DEFAULT_COURSELINE
        defaultCourselinesShouldNotBeFound("courseline.doesNotContain=" + DEFAULT_COURSELINE);

        // Get all the courselinesList where courseline does not contain UPDATED_COURSELINE
        defaultCourselinesShouldBeFound("courseline.doesNotContain=" + UPDATED_COURSELINE);
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionIsEqualToSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription equals to DEFAULT_TEXTDESCRIPTION
        defaultCourselinesShouldBeFound("textdescription.equals=" + DEFAULT_TEXTDESCRIPTION);

        // Get all the courselinesList where textdescription equals to UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldNotBeFound("textdescription.equals=" + UPDATED_TEXTDESCRIPTION);
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionIsNotEqualToSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription not equals to DEFAULT_TEXTDESCRIPTION
        defaultCourselinesShouldNotBeFound("textdescription.notEquals=" + DEFAULT_TEXTDESCRIPTION);

        // Get all the courselinesList where textdescription not equals to UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldBeFound("textdescription.notEquals=" + UPDATED_TEXTDESCRIPTION);
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionIsInShouldWork() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription in DEFAULT_TEXTDESCRIPTION or UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldBeFound("textdescription.in=" + DEFAULT_TEXTDESCRIPTION + "," + UPDATED_TEXTDESCRIPTION);

        // Get all the courselinesList where textdescription equals to UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldNotBeFound("textdescription.in=" + UPDATED_TEXTDESCRIPTION);
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionIsNullOrNotNull() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription is not null
        defaultCourselinesShouldBeFound("textdescription.specified=true");

        // Get all the courselinesList where textdescription is null
        defaultCourselinesShouldNotBeFound("textdescription.specified=false");
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionContainsSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription contains DEFAULT_TEXTDESCRIPTION
        defaultCourselinesShouldBeFound("textdescription.contains=" + DEFAULT_TEXTDESCRIPTION);

        // Get all the courselinesList where textdescription contains UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldNotBeFound("textdescription.contains=" + UPDATED_TEXTDESCRIPTION);
    }

    @Test
    @Transactional
    public void getAllCourselinesByTextdescriptionNotContainsSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        // Get all the courselinesList where textdescription does not contain DEFAULT_TEXTDESCRIPTION
        defaultCourselinesShouldNotBeFound("textdescription.doesNotContain=" + DEFAULT_TEXTDESCRIPTION);

        // Get all the courselinesList where textdescription does not contain UPDATED_TEXTDESCRIPTION
        defaultCourselinesShouldBeFound("textdescription.doesNotContain=" + UPDATED_TEXTDESCRIPTION);
    }

    @Test
    @Transactional
    public void getAllCourselinesByCoursesIsEqualToSomething() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);
        Courses courses = CoursesResourceIT.createEntity(em);
        em.persist(courses);
        em.flush();
        courselines.setCourses(courses);
        courselinesRepository.saveAndFlush(courselines);
        Long coursesId = courses.getId();

        // Get all the courselinesList where courses equals to coursesId
        defaultCourselinesShouldBeFound("coursesId.equals=" + coursesId);

        // Get all the courselinesList where courses equals to coursesId + 1
        defaultCourselinesShouldNotBeFound("coursesId.equals=" + (coursesId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultCourselinesShouldBeFound(String filter) throws Exception {
        restCourselinesMockMvc
            .perform(get("/api/courselines?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(courselines.getId().intValue())))
            .andExpect(jsonPath("$.[*].courseline").value(hasItem(DEFAULT_COURSELINE)))
            .andExpect(jsonPath("$.[*].textdescription").value(hasItem(DEFAULT_TEXTDESCRIPTION)))
            .andExpect(jsonPath("$.[*].htmldescription").value(hasItem(DEFAULT_HTMLDESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));

        // Check, that the count call also returns 1
        restCourselinesMockMvc
            .perform(get("/api/courselines/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultCourselinesShouldNotBeFound(String filter) throws Exception {
        restCourselinesMockMvc
            .perform(get("/api/courselines?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restCourselinesMockMvc
            .perform(get("/api/courselines/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingCourselines() throws Exception {
        // Get the courselines
        restCourselinesMockMvc.perform(get("/api/courselines/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCourselines() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        int databaseSizeBeforeUpdate = courselinesRepository.findAll().size();

        // Update the courselines
        Courselines updatedCourselines = courselinesRepository.findById(courselines.getId()).get();
        // Disconnect from session so that the updates on updatedCourselines are not directly saved in db
        em.detach(updatedCourselines);
        updatedCourselines
            .courseline(UPDATED_COURSELINE)
            .textdescription(UPDATED_TEXTDESCRIPTION)
            .htmldescription(UPDATED_HTMLDESCRIPTION)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        CourselinesDTO courselinesDTO = courselinesMapper.toDto(updatedCourselines);

        restCourselinesMockMvc
            .perform(
                put("/api/courselines").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(courselinesDTO))
            )
            .andExpect(status().isOk());

        // Validate the Courselines in the database
        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeUpdate);
        Courselines testCourselines = courselinesList.get(courselinesList.size() - 1);
        assertThat(testCourselines.getCourseline()).isEqualTo(UPDATED_COURSELINE);
        assertThat(testCourselines.getTextdescription()).isEqualTo(UPDATED_TEXTDESCRIPTION);
        assertThat(testCourselines.getHtmldescription()).isEqualTo(UPDATED_HTMLDESCRIPTION);
        assertThat(testCourselines.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testCourselines.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);

        // Validate the Courselines in Elasticsearch
        verify(mockCourselinesSearchRepository, times(1)).save(testCourselines);
    }

    @Test
    @Transactional
    public void updateNonExistingCourselines() throws Exception {
        int databaseSizeBeforeUpdate = courselinesRepository.findAll().size();

        // Create the Courselines
        CourselinesDTO courselinesDTO = courselinesMapper.toDto(courselines);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCourselinesMockMvc
            .perform(
                put("/api/courselines").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(courselinesDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Courselines in the database
        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeUpdate);

        // Validate the Courselines in Elasticsearch
        verify(mockCourselinesSearchRepository, times(0)).save(courselines);
    }

    @Test
    @Transactional
    public void deleteCourselines() throws Exception {
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);

        int databaseSizeBeforeDelete = courselinesRepository.findAll().size();

        // Delete the courselines
        restCourselinesMockMvc
            .perform(delete("/api/courselines/{id}", courselines.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Courselines> courselinesList = courselinesRepository.findAll();
        assertThat(courselinesList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the Courselines in Elasticsearch
        verify(mockCourselinesSearchRepository, times(1)).deleteById(courselines.getId());
    }

    @Test
    @Transactional
    public void searchCourselines() throws Exception {
        // Configure the mock search repository
        // Initialize the database
        courselinesRepository.saveAndFlush(courselines);
        when(mockCourselinesSearchRepository.search(queryStringQuery("id:" + courselines.getId()), PageRequest.of(0, 20)))
            .thenReturn(new PageImpl<>(Collections.singletonList(courselines), PageRequest.of(0, 1), 1));

        // Search the courselines
        restCourselinesMockMvc
            .perform(get("/api/_search/courselines?query=id:" + courselines.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(courselines.getId().intValue())))
            .andExpect(jsonPath("$.[*].courseline").value(hasItem(DEFAULT_COURSELINE)))
            .andExpect(jsonPath("$.[*].textdescription").value(hasItem(DEFAULT_TEXTDESCRIPTION)))
            .andExpect(jsonPath("$.[*].htmldescription").value(hasItem(DEFAULT_HTMLDESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }
}
