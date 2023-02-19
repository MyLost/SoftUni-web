package com.resellerapp.service.impl;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.enums.ConditionNames;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if(this.conditionRepository.count() == 0 ) {
            List<ConditionEntity> conditions = Arrays.stream(ConditionNames.values()).map(conditionName -> ConditionEntity.
                            builder()
                            .conditionName(conditionName)
                            .description(getDescription(conditionName))
                            .build()).collect(Collectors.toList());

            this.conditionRepository.saveAllAndFlush(conditions);
        }
    }

    private String getDescription(ConditionNames conditionName) {

        if(conditionName.equals(ConditionNames.EXCELLENT)) {
            return "In perfect condition";
        } else if (conditionName.equals(ConditionNames.GOOD)) {
            return "Some signs of wear and tear or minor defects";
        } else {
           return  "The item is fairly worn but continues to function properly";
        }
    }
}
