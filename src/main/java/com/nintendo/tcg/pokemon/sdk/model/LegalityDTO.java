package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Legality;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegalityDTO extends BaseModel<Legality> {
    private UUID uuid;
    @JsonProperty("unlimited")
    String unlimited;
    @JsonProperty("expanded")
    String expanded;
    public LegalityDTO() {
        super(Legality.class);
    }
}
