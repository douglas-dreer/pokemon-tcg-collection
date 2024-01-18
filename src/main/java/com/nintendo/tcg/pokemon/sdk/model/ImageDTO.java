package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Image;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDTO extends BaseModel<Image> {
    private UUID uuid;
    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("logo")
    String logo;
    @JsonProperty("small")
    private String small;
    @JsonProperty("large")
    private String large;

    public ImageDTO(UUID uuid, String symbol, String logo, String small, String large) {
        super(Image.class);
        this.uuid = uuid;
        this.symbol = symbol;
        this.logo = logo;
        this.small = small;
        this.large = large;
    }

    public ImageDTO(String symbol, String logo, String small, String large) {
        super(Image.class);
        this.symbol = symbol;
        this.logo = logo;
        this.small = small;
        this.large = large;
    }

    public ImageDTO(String symbol, String logo) {
        this.symbol = symbol;
        this.logo = logo;
    }

    public ImageDTO(UUID uuid, String symbol, String logo) {
        this.uuid = uuid;
        this.symbol = symbol;
        this.logo = logo;
    }
}
