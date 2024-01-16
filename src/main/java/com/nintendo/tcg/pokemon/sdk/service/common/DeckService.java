package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.Deck;
import com.nintendo.tcg.pokemon.sdk.model.DeckDTO;

public interface DeckService extends BaseService<Deck, DeckDTO> {
    DeckDTO findByCode(String code);

    boolean exportDataFromJsonFile();
}