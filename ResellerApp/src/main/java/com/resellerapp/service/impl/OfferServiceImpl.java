package com.resellerapp.service.impl;

import com.resellerapp.model.OtherUsersOffers;
import com.resellerapp.model.UserOfferDTO;
import com.resellerapp.model.bindings.OfferBindingModel;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.helpers.LoggedUser;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;


    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void saveOffer(OfferBindingModel offerBindingModel) {

        OfferEntity entity = OfferEntity.builder()
                .price(offerBindingModel.getPrice())
                .condition(conditionRepository.findByConditionName(offerBindingModel.getCondition()).orElseThrow())
                .description(offerBindingModel.getDescription())
                .user(userRepository.getById(loggedUser.getId()))
                .build();

        offerRepository.saveAndFlush(entity);
    }

    @Override
    public Set<OfferEntity> findAllByUserId(Long id) {
        return offerRepository.findAllByUserId(id).orElseThrow();
    }

    @Override
    public Set<OfferEntity> findAll() {
        return offerRepository.findAll().stream()
                .filter(item -> item.getUser().getId() != loggedUser.getId()).collect(Collectors.toSet());
    }

    @Override
    public OfferEntity findById(Long id) {
        return offerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<UserOfferDTO> userOfferList() {
       return offerRepository.findAllByUserId(loggedUser.getId()).orElseThrow().stream()
                 .map(offerEntity -> UserOfferDTO.builder()
                         .description(offerEntity.getDescription())
                         .price(offerEntity.getPrice())
                         .condition(offerEntity.getCondition())
                         .build()).toList();
    }

    @Override
    public List<OtherUsersOffers> otherOfferList() {
        return offerRepository.findAllByUserIdNot(loggedUser.getId()).orElseThrow().stream()
                .map(offerEntity -> OtherUsersOffers.builder()
                        .id(offerEntity.getId())
                        .description(offerEntity.getDescription())
                        .price(offerEntity.getPrice())
                        .condition(offerEntity.getCondition())
                        .build()).toList();
    }
}
