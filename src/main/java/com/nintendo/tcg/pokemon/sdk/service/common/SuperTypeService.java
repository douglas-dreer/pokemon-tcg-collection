package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.SuperTypeDTO;

public interface SuperTypeService extends BaseService<SuperType, SuperTypeDTO> {
    SuperTypeDTO findByName(SuperTypesEnum superType);

}