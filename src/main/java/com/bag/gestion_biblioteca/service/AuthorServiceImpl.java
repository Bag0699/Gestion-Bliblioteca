package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.AuthorNotFoundException;
import com.bag.gestion_biblioteca.mapper.AuthorMapper;
import com.bag.gestion_biblioteca.model.dto.AuthorResponse;
import com.bag.gestion_biblioteca.model.dto.CreateAuthorRequest;
import com.bag.gestion_biblioteca.model.entity.Author;
import com.bag.gestion_biblioteca.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponse save(CreateAuthorRequest request) {
        Author author = authorMapper.toAuthor(request);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    @Override
    public List<AuthorResponse> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toAuthorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse findById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toAuthorResponse)
                .orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public AuthorResponse update(Long id, CreateAuthorRequest request) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(request.getName());
                    return authorRepository.save(author);
                })
                .map(authorMapper::toAuthorResponse)
                .orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(authorRepository.findById(id).isEmpty()) {
            throw new AuthorNotFoundException();
        }
        authorRepository.deleteById(id);
    }
}
