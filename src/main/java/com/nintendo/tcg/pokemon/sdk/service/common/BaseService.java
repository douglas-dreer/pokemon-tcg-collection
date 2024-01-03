package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;

import java.util.List;
import java.util.UUID;

public interface BaseService<T extends BaseEntity, M extends BaseModel> {
    List<M> list();

    M findByUUID(UUID id);

    M save(M model);
    List<M> saveAll(List<M> modelList);

    M edit(M model);

    boolean delete(UUID id);
}