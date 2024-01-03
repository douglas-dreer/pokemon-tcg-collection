package com.nintendo.tcg.pokemon.sdk.model.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nintendo.tcg.pokemon.sdk.utility.Converter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Objects;

import static com.nintendo.tcg.pokemon.sdk.utility.Converter.convertTo;

@NoArgsConstructor
public abstract class BaseModel<T> implements Identifiable {

    private Class<T> entityClass;

    protected BaseModel(Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass must not be null");
        this.entityClass = entityClass;
    }

    public T toEntity() {
        return convertTo(this, entityClass);
    }

    public String toJSON() throws JsonProcessingException {
        return Converter.toJSON(this);
    }

    public T toObject(String dados) throws IOException {
        return Converter.toObject(dados, entityClass);
    }
}