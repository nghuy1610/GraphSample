package com.huyha.graphsample.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class Mapper {
    ModelMapper mapper;

    public Mapper() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.addMappings(new BookAuthorToAuthorDto());
    }

    public <S, D> D map(S source, Class<D> clazz) {return mapper.map(source, clazz);}
    public <S, D> List<D> mapToList(S source, Type type) {return mapper.map(source, type);}
}
