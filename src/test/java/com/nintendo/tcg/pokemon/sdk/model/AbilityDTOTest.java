package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.Ability;
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
public class AbilityDTOTest extends InformationGenerator implements BaseModelTest {
    private static AbilityDTO dto;
    private static UUID uuid;
    private static String name;
    private static String text;
    private static String type;

    @BeforeAll
    public static void setup() {
        dto = createAbilityDTO();
        uuid = dto.getUuid();
        text = dto.getText();
        name = dto.getName();
        type = dto.getType();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        AbilityDTO result = new AbilityDTO(uuid, name, text, type);
        checking(result);
    }

    @Test
    @Override
    public void mustReturnSuccessWhenInitializeWithoutId() {
        AbilityDTO result = new AbilityDTO(name, text, type);
        checkingWithIncompleteData(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        AbilityDTO result = new AbilityDTO();
        result.setUuid(uuid);
        result.setName(name);
        result.setText(text);
        result.setType(type);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        AbilityDTO result = AbilityDTO.builder()
                .uuid(uuid)
                .name(name)
                .text(text)
                .type(type)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() {
        Ability entity = dto.toEntity();
        checking(entity);

    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<AbilityDTO> dtoList = createThreeDifferentAbilityDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<AbilityDTO> dtoList = createThreeDifferentAbilityDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1)),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );

    }

    public void checking(AbilityDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The AbilityDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getType(), "The text should not be null"),
                () -> assertEquals(type, datas.getType(), "The element text must be the same as the one sent")
        );
    }

    private void checking(Ability datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The AbilityDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getType(), "The text should not be null"),
                () -> assertEquals(type, datas.getType(), "The element text must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(AbilityDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The SubType should not be null"),
                () -> assertNull(datas.getUuid(), "The id should be null"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent"),
                () -> assertNotNull(datas.getText(), "The text should not be null"),
                () -> assertEquals(text, datas.getText(), "The element text must be the same as the one sent"),
                () -> assertNotNull(datas.getType(), "The text should not be null"),
                () -> assertEquals(type, datas.getType(), "The element text must be the same as the one sent")
        );
    }
}
