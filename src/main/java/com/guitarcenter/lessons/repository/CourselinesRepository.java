package com.guitarcenter.lessons.repository;

import com.guitarcenter.lessons.domain.Courselines;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Courselines entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourselinesRepository extends JpaRepository<Courselines, Long>, JpaSpecificationExecutor<Courselines> {}
