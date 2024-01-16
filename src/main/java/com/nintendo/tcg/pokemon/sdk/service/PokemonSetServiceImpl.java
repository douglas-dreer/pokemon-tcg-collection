package com.nintendo.tcg.pokemon.sdk.service;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import com.nintendo.tcg.pokemon.sdk.model.PokemonSetDTO;
import com.nintendo.tcg.pokemon.sdk.repository.PokemonSetRepository;
import com.nintendo.tcg.pokemon.sdk.service.common.PokemonSetService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.*;
import static com.nintendo.tcg.pokemon.sdk.utility.Converter.mapList;
import static com.nintendo.tcg.pokemon.sdk.utility.ReadFiles.readAndConvertFile;

@Service
@AllArgsConstructor
@Log4j2
public class PokemonSetServiceImpl implements PokemonSetService {
    private static final String FILENAME = "static/data/pokemon-set/pokemon-set.json";
    private static final String language = "pt-BR";
    private PokemonSetRepository repository;

    @Override
    public List<PokemonSetDTO> list() {
        return mapList(repository.findAll(), PokemonSetDTO.class);
    }

    @Override
    public PokemonSetDTO findByUUID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(POKEMON_SET_NOT_FOUND.getEnUS())).toDTO();
    }

    @Override
    public PokemonSetDTO findByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(() -> new BusinessException(POKEMON_SET_NOT_FOUND.getEnUS())).toDTO();
    }

    @Override
    public List<PokemonSetDTO> findByName(String name) {
        return mapList(repository.findAllByNameContainingIgnoreCase(name), PokemonSetDTO.class);
    }

    @Override
    public List<PokemonSetDTO> findBySerie(String serie) {
        return mapList(repository.findAllBySeries(serie), PokemonSetDTO.class);
    }

    public boolean exportDataFromJsonFile() {
        try {
            List<PokemonSetDTO> pokemonSetDTOList = readAndConvertFile(FILENAME, PokemonSetDTO.class);
            saveAll(pokemonSetDTOList);
            log.info(POKEMON_SET_EXPORT_SUCCESS.getMessageLocation(language), pokemonSetDTOList);
            return true;
        } catch (IOException e) {
            log.error(OPERATION_READ_OR_CONVERTER_ERROR.getMessageLocation(language), e.getMessage());
        } catch (Exception e) {
            log.error("Error exporting data: {}", e.getMessage());
            throw new BusinessException(OPERATION_ERROR.getEnUS());
        }
        return false;
    }

    @Override
    public PokemonSetDTO save(PokemonSetDTO model) {
        try {
            PokemonSet saved = repository.save(model.toEntity());
            return saved.toDTO();
        } catch (BusinessException e) {
            log.error(POKEMON_SET_NOT_FOUND.getEnUS());
            return null;
        }
    }

    @Override
    public List<PokemonSetDTO> saveAll(List<PokemonSetDTO> modelList) {
        List<PokemonSetDTO> resultList = new ArrayList<>();
        for (PokemonSetDTO model : modelList) {
            resultList.add(save(model));
        }
        return resultList;
    }

    @Override
    public PokemonSetDTO edit(PokemonSetDTO model) {
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
}
