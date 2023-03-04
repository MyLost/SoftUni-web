package com.resellerapp.model;

import com.resellerapp.model.entity.OfferEntity;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;

    private String email;

    private Set<OfferEntity> offers;

    private Set<OfferEntity> boughtOffers;
}
