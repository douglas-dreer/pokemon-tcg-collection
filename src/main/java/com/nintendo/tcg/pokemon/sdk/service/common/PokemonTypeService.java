package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonType;
import com.nintendo.tcg.pokemon.sdk.model.PokemonTypeDTO;
import com.nintendo.tcg.pokemon.sdk.model.SubTypeDTO;

public interface PokemonTypeService  extends BaseService<PokemonType, PokemonTypeDTO>{
    SubTypeDTO findByCode(String code);
    boolean checkIfExistByName(String name);
}
