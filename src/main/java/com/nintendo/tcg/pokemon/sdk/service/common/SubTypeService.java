package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.SubType;
import com.nintendo.tcg.pokemon.sdk.model.SubTypeDTO;

public interface SubTypeService extends BaseService<SubType, SubTypeDTO> {
    SubTypeDTO findByCode(String code);

    boolean checkIfExistByName(String name);
}