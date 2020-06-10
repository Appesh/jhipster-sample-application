package com.guitarcenter.lessons.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.guitarcenter.lessons.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class CourselinesDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CourselinesDTO.class);
        CourselinesDTO courselinesDTO1 = new CourselinesDTO();
        courselinesDTO1.setId(1L);
        CourselinesDTO courselinesDTO2 = new CourselinesDTO();
        assertThat(courselinesDTO1).isNotEqualTo(courselinesDTO2);
        courselinesDTO2.setId(courselinesDTO1.getId());
        assertThat(courselinesDTO1).isEqualTo(courselinesDTO2);
        courselinesDTO2.setId(2L);
        assertThat(courselinesDTO1).isNotEqualTo(courselinesDTO2);
        courselinesDTO1.setId(null);
        assertThat(courselinesDTO1).isNotEqualTo(courselinesDTO2);
    }
}
