package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Legality;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
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

    public LegalityDTO(UUID uuid, String unlimited, String expanded) {
        super(Legality.class);
        this.uuid = uuid;
        this.unlimited = unlimited;
        this.expanded = expanded;
    }

    public LegalityDTO(String unlimited, String expanded) {
        super(Legality.class);
        this.unlimited = unlimited;
        this.expanded = expanded;
    }

    public LegalityDTO(UUID uuid, String unlimited) {
        this.uuid = uuid;
        this.unlimited = unlimited;
    }

    public LegalityDTO(String unlimited){
        super(Legality.class);
        this.unlimited = unlimited;
    }


}
