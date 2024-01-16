package com.nintendo.tcg.pokemon.sdk.controller;

import com.nintendo.tcg.pokemon.sdk.controller.common.BaseController;
import com.nintendo.tcg.pokemon.sdk.entity.Card;
import com.nintendo.tcg.pokemon.sdk.enums.OriginEnum;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import com.nintendo.tcg.pokemon.sdk.model.CardDTO;
import com.nintendo.tcg.pokemon.sdk.service.common.CardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.OPERATION_ERROR;
import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.OPERATION_SUCCESS;

@RestController
@RequestMapping("/card")
@Log4j2
public class CardController extends BaseController<Card, CardDTO, CardService> {
    public CardController(CardService service) {
        super(service);
    }

    @GetMapping(value = "/import/json-file")
    public ResponseEntity<String> exportDataFromJsonFile() {
        try {
            service.exportDataFromJsonFile();
            return ResponseEntity.ok(OPERATION_SUCCESS.getMessageLocation("pt-BR"));
        } catch (BusinessException e) {
            return ResponseEntity.internalServerError().body(OPERATION_ERROR.getMessageLocation("pt-BR"));
        }
    }

    @GetMapping(value = "/import", params = "origin")
    public ResponseEntity<String> exportDataFromOrigin(@PathVariable(name = "origin", required = true) OriginEnum origin) {
        try {
            if (origin.equals(OriginEnum.SITE)) {
                return ResponseEntity.ok(OPERATION_SUCCESS.getMessageLocation("pt-BR"));
            }
            service.exportDataFromJsonFile();
            return ResponseEntity.ok(OPERATION_SUCCESS.getMessageLocation("pt-BR"));
        } catch (BusinessException e) {
            return ResponseEntity.internalServerError().body(OPERATION_ERROR.getMessageLocation("pt-BR"));
        }
    }
}
