package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
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
class SuperTypeDTOTest extends InformationGenerator implements BaseModelTest {
    private static SuperTypeDTO dto;
    private static UUID uuid;
    private static SuperTypesEnum name;

    @BeforeAll
    public static void setup() {
        dto = createSuperTypeDTO();
        uuid = dto.getUuid();
        name = dto.getName();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        SuperTypeDTO result = new SuperTypeDTO(uuid, name);
        checking(result);
    }

    @Test
    void mustReturnSuccessWhenIntializeWithParamEnum() {
        SuperTypeDTO result = new SuperTypeDTO(name);
        checkingWithIncompleteData(result);
    }

    @Test
    void mustReturnSuccessWhenIntializeWithParamsSuperType() {
        SuperTypeDTO result = new SuperTypeDTO(name.getSuperType());
        checkingWithIncompleteData(result);
    }



    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        SuperTypeDTO result = new SuperTypeDTO();
        result.setUuid(uuid);
        result.setName(name);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        SuperTypeDTO result = SuperTypeDTO.builder()
                .uuid(uuid)
                .name(name)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() {
        SuperType resultEntity = dto.toEntity();
        checking(resultEntity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<SuperTypeDTO> dtoList = createThreeDifferentSuperTypeDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<SuperTypeDTO> dtoList = createThreeDifferentSuperTypeDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1).hashCode()),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );
    }

    private void checking(SuperTypeDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The music should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }

    private void checking(SuperType datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The music should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(SuperTypeDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The SubType should not be null"),
                () -> assertNull(datas.getUuid(), "The id should be null"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(datas.getName(), name, "The element name must be the same as the one sent" )
        );
    }
}