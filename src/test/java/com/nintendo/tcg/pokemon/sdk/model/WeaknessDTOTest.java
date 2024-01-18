package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonType;
import com.nintendo.tcg.pokemon.sdk.entity.Weakness;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
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
class WeaknessDTOTest extends InformationGenerator implements BaseModelTest {
    private static WeaknessDTO dto;
    private static UUID uuid;
    private static PokemonTypeEnum type;
    private static String vulnerability;

    @BeforeAll
    public static void setup() {
        dto = createWeaknessDTO();
        uuid = dto.getUuid();
        type = dto.getType();
        vulnerability = dto.getVulnerability();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        WeaknessDTO result = new WeaknessDTO(uuid, type, vulnerability);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithoutId() {
        WeaknessDTO result = new WeaknessDTO(type, vulnerability);
        checkingWithIncompleteData(result);
    }

    @Test
    void mustReturnSuccessWhenInitializeOnlyWithTypeString(){
        WeaknessDTO result = new WeaknessDTO(type.getType(), vulnerability);
        checkingWithIncompleteData(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        WeaknessDTO result = new WeaknessDTO();
        result.setUuid(uuid);
        result.setType(type);
        result.setVulnerability(vulnerability);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        WeaknessDTO result = WeaknessDTO.builder()
                .uuid(uuid)
                .type(type)
                .vulnerability(vulnerability)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() throws Exception {
        Weakness toEntity = dto.toEntity();
        if (toEntity.getType() == null) {
           toEntity.setType(new PokemonType(dto.getType()));
        }
        checking(toEntity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<WeaknessDTO> dtoList = createThreeDifferentWeaknessDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<WeaknessDTO> dtoList = createThreeDifferentWeaknessDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1).hashCode()),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );
    }

    private void checking(WeaknessDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The Weakness should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getType(), "The type should not be null"),
                () -> assertEquals(type, datas.getType(), "The element name must be the same as the one sent"),
                () -> assertFalse(datas.getVulnerability().isBlank(), "The element vunerability must be the same as the one sent"),
                () -> assertEquals(vulnerability, datas.getVulnerability(), "The element vunerability must be the same as the one sent")
        );
    }

    private void checking(Weakness datas) {
        PokemonType pokemonType = new PokemonType(type);
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The Weakness should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getType(), "The type should not be null"),
                () -> assertEquals(pokemonType.getName(), datas.getType().getName(), "The element type must be the same as the one sent"),
                () -> assertFalse(datas.getVulnerability().isBlank(), "The element vunerability must be the same as the one sent"),
                () -> assertEquals(vulnerability, datas.getVulnerability(), "The element vunerability must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(WeaknessDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The Weakness should not be null"),
                () -> assertNotNull(datas.getType(), "The type should not be null"),
                () -> assertEquals(type, datas.getType(), "The element name must be the same as the one sent"),
                () -> assertFalse(datas.getVulnerability().isBlank(), "The element vunerability must be the same as the one sent"),
                () -> assertEquals(vulnerability, datas.getVulnerability(), "The element vunerability must be the same as the one sent")
        );
    }
}