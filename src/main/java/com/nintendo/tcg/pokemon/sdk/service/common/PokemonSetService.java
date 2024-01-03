package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import com.nintendo.tcg.pokemon.sdk.model.PokemonSetDTO;

import java.util.List;

public interface PokemonSetService extends BaseService<PokemonSet, PokemonSetDTO> {
    PokemonSetDTO findByCode(String code);
    List<PokemonSetDTO> findByName(String name);
    List<PokemonSetDTO> findBySerie(String serie);

    boolean exportDataFromJsonFile();
}