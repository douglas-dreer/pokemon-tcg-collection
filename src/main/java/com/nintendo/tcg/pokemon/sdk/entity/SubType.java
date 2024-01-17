package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.SubTypeDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL010_SUBTYPES")
@Getter
@Setter
@Builder
public class SubType extends BaseEntity<SubTypeDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private SubTypesEnum name;

    public SubType(UUID uuid, SubTypesEnum subType) {
        super(SubTypeDTO.class);
        this.uuid = uuid;
        this.name = subType;
    }

    public SubType(SubTypesEnum name) {
        super(SubTypeDTO.class);
        this.name = name;
    }

    public SubType(String name) {
        super(SubTypeDTO.class);
        this.name = SubTypesEnum.findByName(name);
    }

    public SubType() {
        super(SubTypeDTO.class);
    }
}
