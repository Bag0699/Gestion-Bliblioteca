package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreatePenaltyRequest;
import com.bag.gestion_biblioteca.model.dto.PenaltyResponse;
import com.bag.gestion_biblioteca.model.entity.Penalty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PenaltyMapper {

    @Mapping(target = "reportDate", expression = "java(mapFormatReportDate(penalty))")
    @Mapping(target = "suspensionDate", expression = "java(mapFormatSuspensionDate(penalty))")
    PenaltyResponse toPenaltyResponse(Penalty penalty);

    Penalty toPenalty(CreatePenaltyRequest request);

    default String mapFormatReportDate(Penalty penalty) {
        return penalty
                .getReportDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    default String mapFormatSuspensionDate(Penalty penalty) {
        return penalty
                .getSuspensionDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
