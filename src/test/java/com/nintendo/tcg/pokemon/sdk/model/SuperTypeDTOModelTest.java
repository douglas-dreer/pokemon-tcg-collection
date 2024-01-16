package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModelTest;
import com.nintendo.tcg.pokemon.sdk.utility.InformationGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class SuperTypeDTOModelTest extends InformationGenerator implements BaseModelTest {


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
    public void mustReturnSuccessWhenInitializeWithConstructor() {
        SuperTypeDTO result = new SuperTypeDTO(uuid, name);
        checking(result);
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
    @Disabled("Este teste vai ser disabilitado, por causa que necessita ser uma classe abstrata")
    public void mustReturnSuccessWhenConvertToEntity() {
        SuperType result = dto.toEntity();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToJSON() throws JsonProcessingException {
        String dtoJSON = dto.toJSON();
        assertFalse(dtoJSON.isBlank());
    }

    @Override
    @Test
    @Disabled("Este teste vai ser disabilitado, por causa que necessita ser uma classe abstrata")
    public void mustReturnSuccessWhenConterToObject() throws IOException {
        final String toJSON = dto.toJSON();
        checking(dto.toObject(toJSON));
    }

    @Override
    @Test
    @Disabled("Este teste vai ser disabilitado, por causa que necessita ser uma classe abstrata")
    public void mustReturnSuccessWhenEquals() {
        List<SuperTypeDTO> superTypeDTOList = createThreeDifferentSuperTypeDTO();

        assertThat(superTypeDTOList.get(0)).isEqualTo(superTypeDTOList.get(1));
        assertThat(superTypeDTOList.get(0)).isNotEqualTo(superTypeDTOList.get(2));
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<SuperTypeDTO> superTypeDTOList = createThreeDifferentSuperTypeDTO();

        assertThat(superTypeDTOList.get(0).hashCode()).isEqualTo(superTypeDTOList.get(1).hashCode());
        assertThat(superTypeDTOList.get(0).hashCode()).isNotEqualTo(superTypeDTOList.get(2).hashCode());
    }

    public void checking(SuperTypeDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The SuperTypeDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }

    public void checking(SuperType datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The SuperTypeDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getName(), "The name should not be null"),
                () -> assertEquals(name, datas.getName(), "The element name must be the same as the one sent")
        );
    }


}
