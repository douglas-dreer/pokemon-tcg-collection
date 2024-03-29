package com.nintendo.tcg.pokemon.sdk.entity.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.nintendo.tcg.pokemon.sdk.utility.Converter.convertTo;

@AllArgsConstructor
@Getter
public abstract class BaseEntity<T> {
    private Class<T> modelClass;

    protected BaseEntity() {
        this.modelClass = getModelClass();
    }

    private Class<T> getModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }

    public T toDTO() {
        return convertTo(this, modelClass);
    }

    public String toJSON(BaseEntity<T> BaseEntity) {
        return toJSON(this);
    }

    public T toObject(String dados, Class<T> modelClass) {
        return toObject(dados, this.modelClass);
    }
}