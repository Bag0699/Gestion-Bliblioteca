package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.BookNotFoundException;
import com.bag.gestion_biblioteca.exception.ReportNotFoundException;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.ReportMapper;
import com.bag.gestion_biblioteca.model.dto.CreateReportRequest;
import com.bag.gestion_biblioteca.model.dto.ReportResponse;
import com.bag.gestion_biblioteca.model.entity.Report;
import com.bag.gestion_biblioteca.repository.BookRepository;
import com.bag.gestion_biblioteca.repository.ReportRepository;
import com.bag.gestion_biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public ReportResponse save(CreateReportRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user ->  bookRepository
                        .findById(request.getBookId())
                        .map(book -> {
                            Report report = new Report();
                            report.setUser(user);
                            report.setBook(book);
                            report.setType(request.getType());
                            report.setDescription(request.getDescription());
                            report.setReportDate(LocalDate.now());
                            report.setRestockDate(request.getRestockDate());
                            report.setResolved(request.getResolved());
                            return reportRepository.save(report);
                        })
                        .orElseThrow(BookNotFoundException::new))
                .map(reportMapper::toReportResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<ReportResponse> findAll() {
        return reportRepository.findAll()
                .stream()
                .map(reportMapper::toReportResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReportResponse findById(Long id) {
        return reportRepository.findById(id)
                .map(reportMapper::toReportResponse)
                .orElseThrow(ReportNotFoundException::new);
    }

    @Override
    public ReportResponse update(Long id, CreateReportRequest request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
