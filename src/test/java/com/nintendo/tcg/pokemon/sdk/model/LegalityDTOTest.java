package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.Legality;
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
public class LegalityDTOTest extends InformationGenerator implements BaseModelTest {

    private static LegalityDTO dto;
    private static UUID uuid;
    private static String unlimited;
    private static String expanded;

    @BeforeAll
    public static void setup() {
        dto = createLegalityDTO();
        uuid = dto.getUuid();
        unlimited = dto.getUnlimited();
        expanded = dto.getExpanded();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        LegalityDTO result = new LegalityDTO(uuid, unlimited, expanded);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithoutId() {
        LegalityDTO result = new LegalityDTO(unlimited, expanded);
        checkingWithIncompleteData(result);
    }

    @Test
    void mustReturnSuccessWHenInitializeParamsUnlimited() {
        LegalityDTO result = new LegalityDTO(uuid, unlimited);
        assertAll(
                "Checking Constructor with some parameters",
                () -> assertNotNull(result, "The LegalityDTO should not be null"),
                () -> assertNotNull(result.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, result.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(result.getUnlimited(), "The unlimited should not be null"),
                () -> assertEquals(unlimited, result.getUnlimited(), "The element unlimited must be the same as the one sent")
        );
    }

    @Test
    void mustReturnSuccessWHenInitializeParamsUnlimitedWithoutId() {
        LegalityDTO result = new LegalityDTO(unlimited);
        assertAll(
                "Checking Constructor with some parameters",
                () -> assertNotNull(result, "The LegalityDTO should not be null"),
                () -> assertNotNull(result.getUnlimited(), "The unlimited should not be null"),
                () -> assertEquals(unlimited, result.getUnlimited(), "The element unlimited must be the same as the one sent")
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        LegalityDTO result = new LegalityDTO();
        result.setUuid(uuid);
        result.setExpanded(expanded);
        result.setUnlimited(unlimited);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        LegalityDTO result = LegalityDTO.builder()
                .uuid(uuid)
                .unlimited(unlimited)
                .expanded(expanded)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() throws Exception {
        Legality entity = dto.toEntity();
        checking(entity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<LegalityDTO> dtoList = createThreeDifferentLegalityDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<LegalityDTO> dtoList = createThreeDifferentLegalityDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1).hashCode()),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );
    }

    public void checking(LegalityDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The LegalityDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getExpanded(), "The expanded should not be null"),
                () -> assertEquals(expanded, datas.getExpanded(), "The element expanded must be the same as the one sent"),
                () -> assertNotNull(datas.getUnlimited(), "The unlimited should not be null"),
                () -> assertEquals(unlimited, datas.getUnlimited(), "The element unlimited must be the same as the one sent")
        );
    }

    private void checking(Legality datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The Legality should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getExpanded(), "The symbol should not be null"),
                () -> assertEquals(expanded, datas.getExpanded(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(datas.getUnlimited(), "The logo should not be null"),
                () -> assertEquals(unlimited, datas.getUnlimited(), "The element logo must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(LegalityDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The LegalityDTO should not be null"),
                () -> assertNotNull(datas.getUnlimited(), "The unlimited should not be null"),
                () -> assertEquals(unlimited, datas.getUnlimited(), "The element unlimited must be the same as the one sent"),
                () -> assertNotNull(datas.getExpanded(), "The expanded should not be null"),
                () -> assertEquals(expanded, datas.getExpanded(), "The element expanded must be the same as the one sent")
        );
    }
}
