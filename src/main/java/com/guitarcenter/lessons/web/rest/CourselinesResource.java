package com.guitarcenter.lessons.web.rest;

import static org.elasticsearch.index.query.QueryBuilders.*;

import com.guitarcenter.lessons.service.CourselinesQueryService;
import com.guitarcenter.lessons.service.CourselinesService;
import com.guitarcenter.lessons.service.dto.CourselinesCriteria;
import com.guitarcenter.lessons.service.dto.CourselinesDTO;
import com.guitarcenter.lessons.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST controller for managing {@link com.guitarcenter.lessons.domain.Courselines}.
 */
@RestController
@RequestMapping("/api")
public class CourselinesResource {
    private final Logger log = LoggerFactory.getLogger(CourselinesResource.class);

    private static final String ENTITY_NAME = "courselines";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CourselinesService courselinesService;

    private final CourselinesQueryService courselinesQueryService;

    public CourselinesResource(CourselinesService courselinesService, CourselinesQueryService courselinesQueryService) {
        this.courselinesService = courselinesService;
        this.courselinesQueryService = courselinesQueryService;
    }

    /**
     * {@code POST  /courselines} : Create a new courselines.
     *
     * @param courselinesDTO the courselinesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new courselinesDTO, or with status {@code 400 (Bad Request)} if the courselines has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/courselines")
    public ResponseEntity<CourselinesDTO> createCourselines(@Valid @RequestBody CourselinesDTO courselinesDTO) throws URISyntaxException {
        log.debug("REST request to save Courselines : {}", courselinesDTO);
        if (courselinesDTO.getId() != null) {
            throw new BadRequestAlertException("A new courselines cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CourselinesDTO result = courselinesService.save(courselinesDTO);
        return ResponseEntity
            .created(new URI("/api/courselines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /courselines} : Updates an existing courselines.
     *
     * @param courselinesDTO the courselinesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated courselinesDTO,
     * or with status {@code 400 (Bad Request)} if the courselinesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the courselinesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/courselines")
    public ResponseEntity<CourselinesDTO> updateCourselines(@Valid @RequestBody CourselinesDTO courselinesDTO) throws URISyntaxException {
        log.debug("REST request to update Courselines : {}", courselinesDTO);
        if (courselinesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CourselinesDTO result = courselinesService.save(courselinesDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, courselinesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /courselines} : get all the courselines.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courselines in body.
     */
    @GetMapping("/courselines")
    public ResponseEntity<List<CourselinesDTO>> getAllCourselines(CourselinesCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Courselines by criteria: {}", criteria);
        Page<CourselinesDTO> page = courselinesQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /courselines/count} : count all the courselines.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/courselines/count")
    public ResponseEntity<Long> countCourselines(CourselinesCriteria criteria) {
        log.debug("REST request to count Courselines by criteria: {}", criteria);
        return ResponseEntity.ok().body(courselinesQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /courselines/:id} : get the "id" courselines.
     *
     * @param id the id of the courselinesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the courselinesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/courselines/{id}")
    public ResponseEntity<CourselinesDTO> getCourselines(@PathVariable Long id) {
        log.debug("REST request to get Courselines : {}", id);
        Optional<CourselinesDTO> courselinesDTO = courselinesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(courselinesDTO);
    }

    /**
     * {@code DELETE  /courselines/:id} : delete the "id" courselines.
     *
     * @param id the id of the courselinesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/courselines/{id}")
    public ResponseEntity<Void> deleteCourselines(@PathVariable Long id) {
        log.debug("REST request to delete Courselines : {}", id);
        courselinesService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code SEARCH  /_search/courselines?query=:query} : search for the courselines corresponding
     * to the query.
     *
     * @param query the query of the courselines search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/courselines")
    public ResponseEntity<List<CourselinesDTO>> searchCourselines(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Courselines for query {}", query);
        Page<CourselinesDTO> page = courselinesService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
