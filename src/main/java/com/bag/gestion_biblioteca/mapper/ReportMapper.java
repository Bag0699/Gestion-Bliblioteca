package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReportRequest;
import com.bag.gestion_biblioteca.model.dto.ReportResponse;
import com.bag.gestion_biblioteca.model.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class})
public interface ReportMapper {

    @Mapping(target = "reportDate", expression = "java(mapFormatReportDate(report))")
    @Mapping(target = "restockDate", expression = "java(mapFormatRestockDate(report))")
    ReportResponse toReportResponse(Report report);

    Report toReport(CreateReportRequest request);

    default String mapFormatReportDate(Report report) {
        return report
                .getReportDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    default String mapFormatRestockDate(Report report) {
        return report
                .getRestockDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
