package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.BookNotFoundException;
import com.bag.gestion_biblioteca.exception.ReadingListNotFound;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.BookMapper;
import com.bag.gestion_biblioteca.mapper.ReadingListMapper;
import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReadingListRequest;
import com.bag.gestion_biblioteca.model.dto.ReadingListResponse;
import com.bag.gestion_biblioteca.model.entity.ReadingList;
import com.bag.gestion_biblioteca.repository.BookRepository;
import com.bag.gestion_biblioteca.repository.ReadingListRepository;
import com.bag.gestion_biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadingListServiceImpl implements ReadingListService{

    private final ReadingListRepository repository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ReadingListMapper mapper;
    private final BookMapper bookMapper;
    private final ReadingListRepository readingListRepository;

    @Override
    public ReadingListResponse save(CreateReadingListRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user -> bookRepository.findById(request.getBookId())
                        .map(book -> {
                            ReadingList readingList = new ReadingList();
                            readingList.setUser(user);
                            readingList.setBook(book);
                            return repository.save(readingList);
                        })
                        .orElseThrow(BookNotFoundException::new))
                .map(mapper::toReadingListResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public ReadingListResponse findById(Long id) {
        return readingListRepository.findById(id)
                .map(mapper::toReadingListResponse)
                .orElseThrow(ReadingListNotFound::new);
    }

    @Override
    public List<ReadingListResponse> findAll() {
        return readingListRepository.findAll()
                .stream()
                .map(mapper::toReadingListResponse)
                .collect(Collectors.toList()) ;
    }

    @Override
    public List<BookResponse> findAllByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(user -> readingListRepository.findAllByUser_Id(userId))
                .map(readingLists -> readingLists.stream()
                        .map(ReadingList::getBook)
                        .map(bookMapper::toBookResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(UserNotFoundException::new);

    }

    @Override
    public void deleteById(Long id) {
        if(readingListRepository.findById(id).isEmpty()) {
            throw new ReadingListNotFound();
        }
        readingListRepository.deleteById(id);
    }
}
