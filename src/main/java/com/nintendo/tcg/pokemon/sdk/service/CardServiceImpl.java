package com.nintendo.tcg.pokemon.sdk.service;

import com.nintendo.tcg.pokemon.sdk.entity.Card;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import com.nintendo.tcg.pokemon.sdk.model.CardDTO;
import com.nintendo.tcg.pokemon.sdk.repository.CardRepository;
import com.nintendo.tcg.pokemon.sdk.service.common.CardService;
import com.nintendo.tcg.pokemon.sdk.service.common.SuperTypeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.*;
import static com.nintendo.tcg.pokemon.sdk.utility.Converter.mapList;
import static com.nintendo.tcg.pokemon.sdk.utility.ReadFiles.readAndConvertFile;

@Service
@AllArgsConstructor
@Log4j2
public class CardServiceImpl implements CardService {

    private static final String language = "pt-BR";
    private static final String PATHFILE = "static/data/cards/";
    private static final List<String> FILENAME_LIST = Arrays.asList(
            "base1", "base2", "base3", "base4", "base5", "base6", "basep", "bp", "bw1", "bw10",
            "bw11", "bw2", "bw3", "bw4", "bw5", "bw6", "bw7", "bw8", "bw9", "bwp",
            "cel25", "cel25c", "col1", "dc1", "det1", "dp1", "dp2", "dp3", "dp4", "dp5",
            "dp6", "dp7", "dpp", "dv1", "ecard1", "ecard2", "ecard3", "ex1", "ex10", "ex11",
            "ex12", "ex13", "ex14", "ex15", "ex16", "ex2", "ex3", "ex4", "ex5", "ex6", "ex7",
            "ex8", "ex9", "fut20", "g1", "gym1", "gym2", "hgss1", "hgss2", "hgss3", "hgss4",
            "hsp", "mcd11", "mcd12", "mcd14", "mcd15", "mcd16", "mcd17", "mcd18", "mcd19", "mcd21",
            "mcd22", "neo1", "neo2", "neo3", "neo4", "np", "pgo", "pl1", "pl2", "pl3", "pl4",
            "pop1", "pop2", "pop3", "pop4", "pop5", "pop6", "pop7", "pop8", "pop9", "ru1",
            "si1", "sm1", "sm10", "sm11", "sm115", "sm12", "sm2", "sm3", "sm35", "sm4",
            "sm5", "sm6", "sm7", "sm75", "sm8", "sm9", "sma", "smp", "sv1", "sv2", "sv3",
            "sv3pt5", "sv4", "sve", "svp", "swsh1", "swsh10", "swsh10tg", "swsh11", "swsh11tg",
            "swsh12", "swsh12pt5", "swsh12pt5gg", "swsh12tg", "swsh2", "swsh3", "swsh35", "swsh4",
            "swsh45", "swsh45sv", "swsh5", "swsh6", "swsh7", "swsh8", "swsh9", "swsh9tg", "swshp",
            "tk1a", "tk1b", "tk2a", "tk2b", "xy0", "xy1", "xy10", "xy11", "xy12", "xy2",
            "xy3", "xy4", "xy5", "xy6", "xy7", "xy8", "xy9", "xyp", "decks/en", "base1",
            "base2", "base3", "base4", "base5", "base6", "bw1", "bw10", "bw2", "bw3", "bw4",
            "bw5", "bw6", "bw7", "bw8", "bw9", "col1", "dp1", "dp2", "dp3", "dp4", "dp5",
            "dp6", "dp7", "ecard1", "ecard2", "ecard3", "ex1", "ex10", "ex11", "ex12", "ex13",
            "ex14", "ex15", "ex16", "ex2", "ex3", "ex4", "ex5", "ex6", "ex7", "ex8", "ex9",
            "gym1", "gym2", "hgss1", "hgss2", "hgss3", "hgss4", "neo1", "neo2", "neo4", "pl1",
            "pl2", "pl3", "pl4", "sm1", "sm10", "sm2", "sm3", "sm4", "sm5", "sm6", "sm7",
            "sm8", "sm9", "swsh1", "swsh2", "xy1", "xy10", "xy11", "xy12", "xy2", "xy3",
            "xy4", "xy5", "xy6", "xy7", "xy8", "xy9"
    );
    private CardRepository repository;
    private SuperTypeService superTypeService;

    @Override
    public List<CardDTO> list() {
        return mapList(repository.findAll(), CardDTO.class);
    }

    @Override
    public CardDTO findByUUID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(POKEMON_CARD_NOT_FOUND.getEnUS())).toDTO();
    }

    @Override
    @Transactional
    public CardDTO save(CardDTO model) {
        try {
            Card entityToSave = model.toEntity();
            //SuperTypeDTO superTypeSaved = superTypeService.save(model.getSuperType());
            //entityToSave.setSuperType(superTypeSaved.toEntity());
//
//            List<SubType> subTypeList = subTypeRepository.saveAll(entityToSave.getSubTypes());
//            entityToSave.setSubTypes(subTypeList);

            Card saved = repository.save(entityToSave);
            return saved.toDTO();
        } catch (BusinessException e) {
            log.error(POKEMON_CARD_NOT_FOUND.getEnUS());
            return null;
        }
    }

    @Override
    public List<CardDTO> saveAll(List<CardDTO> modelList) {
        List<CardDTO> resultList = new ArrayList<>();
        for (CardDTO model : modelList) {
            resultList.add(save(model));
        }
        return resultList;
    }

    @Override
    public CardDTO edit(CardDTO model) {
        try {
            if (!repository.existsById(model.getUuid())) {
                throw new BusinessException(POKEMON_SET_NOT_FOUND.getMessageLocation(language));
            }
            return repository.saveAndFlush(model.toEntity()).toDTO();

        } catch (BusinessException e) {
            log.info(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean delete(UUID id) {
        try {
            if (!repository.existsById(id)) {
                throw new BusinessException(POKEMON_SET_NOT_FOUND.getMessageLocation(language));
            }
            repository.deleteById(id);
        } catch (BusinessException e) {
            log.info(e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public CardDTO findByCode(String code) {
        return null;
    }

    @Override
    public boolean exportDataFromJsonFile() {
        try {
            final String FILENAME = PATHFILE.concat(FILENAME_LIST.get(0)).concat(".json");
            List<CardDTO> cardDTOList = readAndConvertFile(FILENAME, CardDTO.class);
            saveAll(cardDTOList);
            log.info(POKEMON_CARD_EXPORT_SUCCESS.getMessageLocation(language), cardDTOList);
            return true;
        } catch (IOException e) {
            log.error(OPERATION_READ_OR_CONVERTER_ERROR.getMessageLocation(language), e.getMessage());
        } catch (Exception e) {
            log.error("Error exporting data: {}", e.getMessage());
            throw new BusinessException(OPERATION_ERROR.getEnUS());
        }
        return false;
    }
}
