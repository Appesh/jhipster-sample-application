package com.guitarcenter.lessons.service;

import static org.elasticsearch.index.query.QueryBuilders.*;

import com.guitarcenter.lessons.domain.Courselines;
import com.guitarcenter.lessons.repository.CourselinesRepository;
import com.guitarcenter.lessons.repository.search.CourselinesSearchRepository;
import com.guitarcenter.lessons.service.dto.CourselinesDTO;
import com.guitarcenter.lessons.service.mapper.CourselinesMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Courselines}.
 */
@Service
@Transactional
public class CourselinesService {
    private final Logger log = LoggerFactory.getLogger(CourselinesService.class);

    private final CourselinesRepository courselinesRepository;

    private final CourselinesMapper courselinesMapper;

    private final CourselinesSearchRepository courselinesSearchRepository;

    public CourselinesService(
        CourselinesRepository courselinesRepository,
        CourselinesMapper courselinesMapper,
        CourselinesSearchRepository courselinesSearchRepository
    ) {
        this.courselinesRepository = courselinesRepository;
        this.courselinesMapper = courselinesMapper;
        this.courselinesSearchRepository = courselinesSearchRepository;
    }

    /**
     * Save a courselines.
     *
     * @param courselinesDTO the entity to save.
     * @return the persisted entity.
     */
    public CourselinesDTO save(CourselinesDTO courselinesDTO) {
        log.debug("Request to save Courselines : {}", courselinesDTO);
        Courselines courselines = courselinesMapper.toEntity(courselinesDTO);
        courselines = courselinesRepository.save(courselines);
        CourselinesDTO result = courselinesMapper.toDto(courselines);
        courselinesSearchRepository.save(courselines);
        return result;
    }

    /**
     * Get all the courselines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CourselinesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Courselines");
        return courselinesRepository.findAll(pageable).map(courselinesMapper::toDto);
    }

    /**
     * Get one courselines by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CourselinesDTO> findOne(Long id) {
        log.debug("Request to get Courselines : {}", id);
        return courselinesRepository.findById(id).map(courselinesMapper::toDto);
    }

    /**
     * Delete the courselines by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Courselines : {}", id);
        courselinesRepository.deleteById(id);
        courselinesSearchRepository.deleteById(id);
    }

    /**
     * Search for the courselines corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CourselinesDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Courselines for query {}", query);
        return courselinesSearchRepository.search(queryStringQuery(query), pageable).map(courselinesMapper::toDto);
    }
}
