package com.guitarcenter.lessons.service.mapper;

import com.guitarcenter.lessons.domain.*;
import com.guitarcenter.lessons.service.dto.CourselinesDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Courselines} and its DTO {@link CourselinesDTO}.
 */
@Mapper(componentModel = "spring", uses = { CoursesMapper.class })
public interface CourselinesMapper extends EntityMapper<CourselinesDTO, Courselines> {
    @Mapping(source = "courses.id", target = "coursesId")
    CourselinesDTO toDto(Courselines courselines);

    @Mapping(source = "coursesId", target = "courses")
    Courselines toEntity(CourselinesDTO courselinesDTO);

    default Courselines fromId(Long id) {
        if (id == null) {
            return null;
        }
        Courselines courselines = new Courselines();
        courselines.setId(id);
        return courselines;
    }
}
