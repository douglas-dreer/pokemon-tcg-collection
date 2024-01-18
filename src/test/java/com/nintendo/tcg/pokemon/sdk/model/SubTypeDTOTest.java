package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.SubType;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
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
class SubTypeDTOTest extends InformationGenerator implements BaseModelTest {
    private static SubTypeDTO dto;
    private static UUID uuid;
    private static SubTypesEnum name;

    @BeforeAll
    public static void setup() {
        dto = createSubTypeDTO();
        uuid = dto.getUuid();
        name = dto.getName();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        SubTypeDTO result = new SubTypeDTO(uuid, name);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithoutId() {
        SubTypeDTO result = new SubTypeDTO(name);
        checkingWithIncompleteData(result);
    }

    @Test
    void mustReturnSuccessWhenInitializeOnlyWithNameString(){
        SubTypeDTO result = new SubTypeDTO(name.getName());
        checkingWithIncompleteData(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        SubTypeDTO result = new SubTypeDTO();
        result.setUuid(uuid);
        result.setName(name);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        SubTypeDTO result = SubTypeDTO.builder()
                .uuid(uuid)
                .name(name)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() throws Exception {
        SubType resultEntity = dto.toEntity();
        checking(resultEntity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<SubTypeDTO> dtoList = createThreeDifferentSubTypeDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<SubTypeDTO> dtoList = createThreeDifferentSubTypeDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1).hashCode()),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );
    }

    public void checking(SubTypeDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The SubType should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }

    private void checking(SubType datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The SubType should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(SubTypeDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The SubType should not be null"),
                () -> assertNull(datas.getUuid(), "The id should be null"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(datas.getName(), name, "The element name must be the same as the one sent" )
        );
    }
}