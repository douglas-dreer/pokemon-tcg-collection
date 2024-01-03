package com.nintendo.tcg.pokemon.sdk.controller.common;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import com.nintendo.tcg.pokemon.sdk.model.PokemonSetDTO;
import com.nintendo.tcg.pokemon.sdk.service.common.PokemonSetService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.*;

@RestController
@RequestMapping("/pokemon-set")
@Log4j2
public class PokemonSetController extends BaseController<PokemonSet, PokemonSetDTO, PokemonSetService> {
    public PokemonSetController(PokemonSetService service) {
        super(service);
    }

    @GetMapping(value = "/import/json-file")
    public ResponseEntity<String> exportDataFromJsonFile() {
        try {
            service.exportDataFromJsonFile();
            return ResponseEntity.ok(OPERATION_SUCCESS.getEnUS());
        } catch (BusinessException exception) {
            return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(OPERATION_ERROR.getEnUS());
        }
    }


}
