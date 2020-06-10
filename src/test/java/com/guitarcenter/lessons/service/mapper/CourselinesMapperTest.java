package com.guitarcenter.lessons.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourselinesMapperTest {
    private CourselinesMapper courselinesMapper;

    @BeforeEach
    public void setUp() {
        courselinesMapper = new CourselinesMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(courselinesMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(courselinesMapper.fromId(null)).isNull();
    }
}
