package com.nintendo.tcg.pokemon.sdk.model;

import com.nintendo.tcg.pokemon.sdk.entity.Image;
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
public class ImageDTOTest extends InformationGenerator implements BaseModelTest {

    private static ImageDTO dto;
    private static UUID uuid;
    private static String symbol;
    private static String logo;
    private static String small;
    private static String large;

    @BeforeAll
    public static void setup() {
        dto = createImageDTO();
        uuid = dto.getUuid();
        symbol = dto.getSymbol();
        logo = dto.getLogo();
        small = dto.getSmall();
        large = dto.getLarge();
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithAllConstructor() {
        ImageDTO result = new ImageDTO(uuid, symbol, logo, small, large);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithoutId() {
        ImageDTO result = new ImageDTO(symbol, logo, small, large);
        checkingWithIncompleteData(result);
    }

    @Test
    void mustReturnSuccessWhenInitializeWithParametersSymbolAndLogo() {
        ImageDTO result = new ImageDTO(uuid, symbol, logo);
        assertAll(
                "Checkint ImageDTO with parameters",
                () -> assertNotNull(result, "The ImageDTO should not be null"),
                () -> assertNotNull(result.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, result.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(result.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, result.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(result.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, result.getLogo(), "The element logo must be the same as the one sent")
        );
    }

    @Test
    void mustReturnSuccessWhenInitializeWithParametersSymbolAndLogoWithoutId() {
        ImageDTO result = new ImageDTO(symbol, logo);
        assertAll(
                "Checkint ImageDTO with parameters",
                () -> assertNull(result.getUuid(), "The id should be null"),
                () -> assertNotNull(result.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, result.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(result.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, result.getLogo(), "The element logo must be the same as the one sent")
        );
    }

    @Test
    void mustReturnSuccessWhenInitializeWithParametersSmallAndLarge() {
        ImageDTO result = new ImageDTO();
        result.setUuid(uuid);
        result.setSmall(small);
        result.setLarge(large);
        assertAll(
                "Checkint ImageDTO with parameters",
                () -> assertNotNull(result, "The ImageDTO should not be null"),
                () -> assertNotNull(result.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, result.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(result.getSmall(), "The small should not be null"),
                () -> assertEquals(small, result.getSmall(), "The element small must be the same as the one sent"),
                () -> assertNotNull(result.getLarge(), "The large should not be null"),
                () -> assertEquals(large, result.getLarge(), "The element large must be the same as the one sent")
        );
    }

    @Test
    void mustReturnSuccessWhenInitializeWithParametersSmallAndLargeWithoutId() {
        ImageDTO result = new ImageDTO(symbol, logo);
        assertAll(
                "Checkint ImageDTO with parameters",
                () -> assertNull(result.getUuid(), "The id should be null"),
                () -> assertNotNull(result.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, result.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(result.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, result.getLogo(), "The element logo must be the same as the one sent")
        );
    }



    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithSetters() {
        ImageDTO result = new ImageDTO();
        result.setUuid(uuid);
        result.setSymbol(symbol);
        result.setLogo(logo);
        result.setSmall(small);
        result.setLarge(large);
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenInitializeWithBuilder() {
        ImageDTO result = ImageDTO.builder()
                .uuid(uuid)
                .symbol(symbol)
                .logo(logo)
                .small(small)
                .large(large)
                .build();
        checking(result);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenConvertToEntity() throws Exception {
        Image entity = dto.toEntity();
        checking(entity);
    }

    @Override
    @Test
    public void mustReturnSuccessWhenEquals() {
        List<ImageDTO> dtoList = createThreeDifferentImageDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).isEqualTo(dtoList.get(1)),
                () -> assertThat(dtoList.get(0)).isNotEqualTo(dtoList.get(2))
        );
    }

    @Override
    @Test
    public void mustReturnSuccessWhenHash() {
        List<ImageDTO> dtoList = createThreeDifferentImageDTO();
        assertAll(
                "Verify result list",
                () -> assertThat(dtoList.get(0)).hasSameHashCodeAs(dtoList.get(1).hashCode()),
                () -> assertThat(dtoList.get(0).hashCode()).isNotEqualTo(dtoList.get(2).hashCode())
        );
    }

    public void checking(ImageDTO datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The ImageDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, datas.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(datas.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, datas.getLogo(), "The element logo must be the same as the one sent"),
                () -> assertNotNull(datas.getSmall(), "The small should not be null"),
                () -> assertEquals(small, datas.getSmall(), "The element small must be the same as the one sent"),
                () -> assertNotNull(datas.getLarge(), "The large should not be null"),
                () -> assertEquals(large, datas.getLarge(), "The element large must be the same as the one sent")
        );
    }

    private void checking(Image datas) {
        assertAll("Verify result list",
                () -> assertNotNull(datas, "The ImageDTO should not be null"),
                () -> assertNotNull(datas.getUuid(), "The id should not be null"),
                () -> assertEquals(uuid, datas.getUuid(), "The element id must be the same as the one sent"),
                () -> assertNotNull(datas.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, datas.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(datas.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, datas.getLogo(), "The element logo must be the same as the one sent"),
                () -> assertNotNull(datas.getSmall(), "The small should not be null"),
                () -> assertEquals(small, datas.getSmall(), "The element small must be the same as the one sent"),
                () -> assertNotNull(datas.getLarge(), "The large should not be null"),
                () -> assertEquals(large, datas.getLarge(), "The element large must be the same as the one sent")
        );
    }

    private void checkingWithIncompleteData(ImageDTO datas) {
        assertAll(
                "Checking with data incomplete",
                () -> assertNotNull(datas, "The ImageDTO should not be null"),
                () -> assertNotNull(datas.getSymbol(), "The symbol should not be null"),
                () -> assertEquals(symbol, datas.getSymbol(), "The element symbol must be the same as the one sent"),
                () -> assertNotNull(datas.getLogo(), "The logo should not be null"),
                () -> assertEquals(logo, datas.getLogo(), "The element logo must be the same as the one sent"),
                () -> assertNotNull(datas.getSmall(), "The small should not be null"),
                () -> assertEquals(small, datas.getSmall(), "The element small must be the same as the one sent"),
                () -> assertNotNull(datas.getLarge(), "The large should not be null"),
                () -> assertEquals(large, datas.getLarge(), "The element large must be the same as the one sent")
        );
    }
}
