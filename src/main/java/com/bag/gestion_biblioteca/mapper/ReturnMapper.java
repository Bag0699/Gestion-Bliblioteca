package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReturnRequest;
import com.bag.gestion_biblioteca.model.dto.ReturnResponse;
import com.bag.gestion_biblioteca.model.entity.Reservation;
import com.bag.gestion_biblioteca.model.entity.Return;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class})
public interface ReturnMapper {

    @Mapping(target = "date", expression = "java(mapFormatDate(aReturn))")
    ReturnResponse toReturnResponse(Return aReturn);

    Return toReturn(CreateReturnRequest request);

    default String mapFormatDate(Return aReturn) {
        return aReturn
                .getDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
