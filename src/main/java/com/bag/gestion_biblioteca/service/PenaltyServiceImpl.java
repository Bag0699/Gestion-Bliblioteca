package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.PenaltyNotFoundException;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.PenaltyMapper;
import com.bag.gestion_biblioteca.model.dto.CreatePenaltyRequest;
import com.bag.gestion_biblioteca.model.dto.PenaltyResponse;
import com.bag.gestion_biblioteca.model.entity.Penalty;
import com.bag.gestion_biblioteca.repository.PenaltyRepository;
import com.bag.gestion_biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService{

    private final PenaltyRepository penaltyRepository;
    private final PenaltyMapper penaltyMapper;
    private final UserRepository userRepository;

    @Override
    public PenaltyResponse save(CreatePenaltyRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user -> {
                    Penalty penalty = new Penalty();
                    penalty.setUser(user);
                    penalty.setAmount(request.getAmount());
                    penalty.setReason(request.getReason());
                    penalty.setSuspensionDate(LocalDate.now());
                    penalty.setSuspensionEndDate(request.getSuspensionEndDate());
                    penalty.setPaid(request.getPaid());
                    return penaltyRepository.save(penalty);
                })
                .map(penaltyMapper::toPenaltyResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<PenaltyResponse> findAll() {
        return penaltyRepository.findAll()
                .stream()
                .map(penaltyMapper::toPenaltyResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PenaltyResponse findById(Long id) {
        return penaltyRepository.findById(id)
                .map(penaltyMapper::toPenaltyResponse)
                .orElseThrow(PenaltyNotFoundException::new);
    }

    @Override
    public PenaltyResponse update(Long id, CreatePenaltyRequest request) {
        return penaltyRepository.findById(id)
                .map(penalty -> userRepository
                        .findById(request.getUserId())
                        .map(user -> {
                          penalty.setUser(user);
                          penalty.setAmount(request.getAmount());
                          penalty.setReason(request.getReason());
                          penalty.setPaid(request.getPaid());
                          penalty.setSuspensionEndDate(request.getSuspensionEndDate());
                          return penaltyRepository.save(penalty);
                        })
                        .orElseThrow(UserNotFoundException::new))
                .map(penaltyMapper::toPenaltyResponse)
                .orElseThrow(PenaltyNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(penaltyRepository.findById(id).isEmpty()) {
            throw new PenaltyNotFoundException();
        }
        penaltyRepository.deleteById(id);
    }
}
