package com.resellerapp.service;

import com.resellerapp.model.OtherUsersOffers;
import com.resellerapp.model.UserOfferDTO;
import com.resellerapp.model.bindings.OfferBindingModel;
import com.resellerapp.model.entity.OfferEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OfferService {
    void saveOffer(OfferBindingModel offerBindingModel);

    Set<OfferEntity> findAllByUserId(Long id);

    Set<OfferEntity> findAll();

    OfferEntity findById(Long id);

    List<UserOfferDTO> userOfferList();

    List<OtherUsersOffers> otherOfferList();
}
