package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.Attack;
import com.nintendo.tcg.pokemon.sdk.entity.PokemonType;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModelTest;
import com.nintendo.tcg.pokemon.sdk.utility.InformationGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AttackDTOTest extends InformationGenerator implements BaseModelTest {
    private static AttackDTO dto;
    private static UUID uuid;
    private static String name;
    private static List<String> cost;
    private static int convertedEnergyCost;
    private static String damage;
    private static String text;

    @BeforeAll
    public static void setup() {
        dto = createAttackDTO();
        uuid = dto.getUuid();
        name = dto.getName();
        cost = dto.getCost();
        convertedEnergyCost = dto.getConvertedEnergyCost();
        damage = dto.getDamage();
        text = dto.getText();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        AttackDTO result = new AttackDTO(uuid, name, cost, convertedEnergyCost, damage, text);
        checking(result);
    }

    @Test
    void mustReturnSuccessWhenInitializeWithoutId() {
        AttackDTO result = new AttackDTO(name, cost, convertedEnergyCost, damage, text);
        checkingWithIncompleteData(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        AttackDTO result = new AttackDTO();
        result.setUuid(uuid);
        result.setName(name);
        result.setCost(cost);
        result.setConvertedEnergyCost(convertedEnergyCost);
        result.setDamage(damage);
        result.setText(text);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        AttackDTO result = AttackDTO.builder()
                .uuid(uuid)
                .name(name)
                .cost(cost)
                .convertedEnergyCost(convertedEnergyCost)
                .damage(damage)
                .text(text)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() {
        Attack entity = dto.toEntity();
        checking(entity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<AttackDTO> dtoList = createThreeDifferentAttackDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<AttackDTO> dtoList = createThreeDifferentAttackDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1)),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );

    }

    public void checking(AttackDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The AttackDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertFalse(datas.getCost().isEmpty(), "The element cost should not be empty"),
                () -> assertEquals(cost, datas.getCost(), "The element cost must be the same as the one sent"),
                () -> assertEquals(cost.size(), datas.getCost().size(), "The element cost must be the same as the send"),
                () -> assertNotEquals(0, datas.getConvertedEnergyCost(), "The convertedEnergyCost should not be null"),
                () -> assertEquals(convertedEnergyCost, datas.getConvertedEnergyCost(), "The element cost must be the same as the send"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getDamage(), "The text should not be null"),
                () -> assertEquals(damage, datas.getDamage(), "The element text must be the same as the one sent")
        );
    }

    private void checking(Attack datas) {
        List<PokemonType> pokemonTypeList = datas.getCost();
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The AttackDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertFalse(datas.getCost().isEmpty(), "The element cost should not be empty"),
                () -> assertEquals(pokemonTypeList, datas.getCost(), "The element cost must be the same as the one sent"),
                () -> assertEquals(pokemonTypeList.size(), datas.getCost().size(), "The element cost must be the same as the send"),
                () -> assertNotEquals(0, datas.getConvertedEnergyCost(), "The convertedEnergyCost should not be null"),
                () -> assertEquals(convertedEnergyCost, datas.getConvertedEnergyCost(), "The element cost must be the same as the send"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getDamage(), "The text should not be null"),
                () -> assertEquals(damage, datas.getDamage(), "The element text must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(AttackDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The AttackDTO should not be null"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertFalse(datas.getCost().isEmpty(), "The element cost should not be empty"),
                () -> assertEquals(cost, datas.getCost(), "The element cost must be the same as the one sent"),
                () -> assertEquals(cost.size(), datas.getCost().size(), "The element cost must be the same as the send"),
                () -> assertNotEquals(0, datas.getConvertedEnergyCost(), "The convertedEnergyCost should not be null"),
                () -> assertEquals(convertedEnergyCost, datas.getConvertedEnergyCost(), "The element cost must be the same as the send"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getDamage(), "The text should not be null"),
                () -> assertEquals(damage, datas.getDamage(), "The element text must be the same as the one sent")
        );
    }
}
