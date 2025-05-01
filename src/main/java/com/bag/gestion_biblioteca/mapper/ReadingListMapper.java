package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReadingListRequest;
import com.bag.gestion_biblioteca.model.dto.ReadingListResponse;
import com.bag.gestion_biblioteca.model.entity.ReadingList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class})
public interface ReadingListMapper {

    ReadingListResponse toReadingListResponse(ReadingList readingList);

    ReadingList toReadingList(CreateReadingListRequest request);
}
