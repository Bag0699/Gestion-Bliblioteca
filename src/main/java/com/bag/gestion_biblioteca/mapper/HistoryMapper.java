package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateHistoryRequest;
import com.bag.gestion_biblioteca.model.dto.HistoryResponse;
import com.bag.gestion_biblioteca.model.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class})
public interface HistoryMapper {

    @Mapping(target = "date", expression = "java(mapFormatDate(history))")
    HistoryResponse toHistoryResponse(History history);

    History toHistory(CreateHistoryRequest request);

    default String mapFormatDate(History history) {
        return history
                .getDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
