package com.guitarcenter.lessons.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.guitarcenter.lessons.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class CourselinesTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Courselines.class);
        Courselines courselines1 = new Courselines();
        courselines1.setId(1L);
        Courselines courselines2 = new Courselines();
        courselines2.setId(courselines1.getId());
        assertThat(courselines1).isEqualTo(courselines2);
        courselines2.setId(2L);
        assertThat(courselines1).isNotEqualTo(courselines2);
        courselines1.setId(null);
        assertThat(courselines1).isNotEqualTo(courselines2);
    }
}
