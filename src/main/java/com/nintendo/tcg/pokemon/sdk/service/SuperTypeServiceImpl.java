package com.nintendo.tcg.pokemon.sdk.service;

import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import com.nintendo.tcg.pokemon.sdk.model.SuperTypeDTO;
import com.nintendo.tcg.pokemon.sdk.repository.SuperTypeRepository;
import com.nintendo.tcg.pokemon.sdk.service.common.SuperTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.POKEMON_CARD_NOT_FOUND;
import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.POKEMON_SET_NOT_FOUND;

@Service
@AllArgsConstructor
@Log4j2
public class SuperTypeServiceImpl implements SuperTypeService {
    private static final String language = "pt-BR";
    private SuperTypeRepository repository;

    @Override
    public List<SuperTypeDTO> list() {
        return null;
    }

    @Override
    public SuperTypeDTO findByUUID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(POKEMON_CARD_NOT_FOUND.getEnUS())).toDTO();
    }

    @Override
    public SuperTypeDTO save(SuperTypeDTO model) {
        try {
            SuperTypeDTO superTypeDTOSaved = this.findByName(model.getName());
            if (superTypeDTOSaved.getUuid() != null) {
                return superTypeDTOSaved;
            }
            return repository.save(model.toEntity()).toDTO();
        } catch (BusinessException e) {
            log.error(POKEMON_SET_NOT_FOUND.getEnUS());
            return null;
        }
    }

    @Override
    public List<SuperTypeDTO> saveAll(List<SuperTypeDTO> modelList) {
        return modelList.stream()
                .map(this::save)
                .toList();
    }


    @Override
    public SuperTypeDTO edit(SuperTypeDTO model) {
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
    public SuperTypeDTO findByName(SuperTypesEnum superTypes) {
        try {

        } catch (Exception e) {

        }
        return repository
                .findAllByName(superTypes)
                .orElse(new SuperType())
                .toDTO();
    }
}
