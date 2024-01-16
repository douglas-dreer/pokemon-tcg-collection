package com.nintendo.tcg.pokemon.sdk.service.common;

import com.nintendo.tcg.pokemon.sdk.entity.Card;
import com.nintendo.tcg.pokemon.sdk.model.CardDTO;

public interface CardService extends BaseService<Card, CardDTO> {
    CardDTO findByCode(String code);

    boolean exportDataFromJsonFile();
}