package com.guitarcenter.lessons.service;

import com.guitarcenter.lessons.domain.*; // for static metamodels
import com.guitarcenter.lessons.domain.Courselines;
import com.guitarcenter.lessons.repository.CourselinesRepository;
import com.guitarcenter.lessons.repository.search.CourselinesSearchRepository;
import com.guitarcenter.lessons.service.dto.CourselinesCriteria;
import com.guitarcenter.lessons.service.dto.CourselinesDTO;
import com.guitarcenter.lessons.service.mapper.CourselinesMapper;
import io.github.jhipster.service.QueryService;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for executing complex queries for {@link Courselines} entities in the database.
 * The main input is a {@link CourselinesCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CourselinesDTO} or a {@link Page} of {@link CourselinesDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CourselinesQueryService extends QueryService<Courselines> {
    private final Logger log = LoggerFactory.getLogger(CourselinesQueryService.class);

    private final CourselinesRepository courselinesRepository;

    private final CourselinesMapper courselinesMapper;

    private final CourselinesSearchRepository courselinesSearchRepository;

    public CourselinesQueryService(
        CourselinesRepository courselinesRepository,
        CourselinesMapper courselinesMapper,
        CourselinesSearchRepository courselinesSearchRepository
    ) {
        this.courselinesRepository = courselinesRepository;
        this.courselinesMapper = courselinesMapper;
        this.courselinesSearchRepository = courselinesSearchRepository;
    }

    /**
     * Return a {@link List} of {@link CourselinesDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CourselinesDTO> findByCriteria(CourselinesCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Courselines> specification = createSpecification(criteria);
        return courselinesMapper.toDto(courselinesRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CourselinesDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CourselinesDTO> findByCriteria(CourselinesCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Courselines> specification = createSpecification(criteria);
        return courselinesRepository.findAll(specification, page).map(courselinesMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CourselinesCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Courselines> specification = createSpecification(criteria);
        return courselinesRepository.count(specification);
    }

    /**
     * Function to convert {@link CourselinesCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Courselines> createSpecification(CourselinesCriteria criteria) {
        Specification<Courselines> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Courselines_.id));
            }
            if (criteria.getCourseline() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCourseline(), Courselines_.courseline));
            }
            if (criteria.getTextdescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTextdescription(), Courselines_.textdescription));
            }
            if (criteria.getCoursesId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCoursesId(), root -> root.join(Courselines_.courses, JoinType.LEFT).get(Courses_.id))
                    );
            }
        }
        return specification;
    }
}
