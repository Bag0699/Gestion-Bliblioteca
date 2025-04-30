package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.BookNotFoundException;
import com.bag.gestion_biblioteca.exception.HistoryNotFoundException;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.HistoryMapper;
import com.bag.gestion_biblioteca.model.dto.CreateHistoryRequest;
import com.bag.gestion_biblioteca.model.dto.HistoryResponse;
import com.bag.gestion_biblioteca.model.entity.History;
import com.bag.gestion_biblioteca.repository.BookRepository;
import com.bag.gestion_biblioteca.repository.HistoryRepository;
import com.bag.gestion_biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    @Override
    public HistoryResponse save(CreateHistoryRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user ->  bookRepository.findById(request.getBookId())
                        .map(book -> {
                            History history = new History();
                            history.setUser(user);
                            history.setBook(book);
                            history.setActivity(request.getActivity());
                            history.setDetails(request.getDetails());
                            history.setDate(request.getDate());
                            return historyRepository.save(history);
                        })
                        .orElseThrow(BookNotFoundException::new))
                .map(historyMapper::toHistoryResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<HistoryResponse> findAll() {
        return historyRepository.findAll()
                .stream()
                .map(historyMapper::toHistoryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HistoryResponse findById(Long id) {
        return historyRepository.findById(id)
                .map(historyMapper::toHistoryResponse)
                .orElseThrow(HistoryNotFoundException::new);
    }

    @Override
    public HistoryResponse update(Long id, CreateHistoryRequest request) {
        return historyRepository.findById(id)
                .map(history -> userRepository.findById(request.getUserId())
                        .map(user -> bookRepository.findById(request.getBookId())
                                .map(book -> {
                                    history.setUser(user);
                                    history.setBook(book);
                                    history.setActivity(request.getActivity());
                                    history.setDate(request.getDate());
                                    history.setDetails(request.getDetails());
                                    return historyRepository.save(history);
                                })
                                .orElseThrow(BookNotFoundException::new))
                        .map(historyMapper::toHistoryResponse)
                        .orElseThrow(UserNotFoundException::new))
                .orElseThrow(HistoryNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(historyRepository.findById(id).isEmpty()){
            throw new HistoryNotFoundException();
        }
        historyRepository.deleteById(id);
    }
}
