package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.SuperTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL011_SUPERTYPES")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuperType extends BaseEntity<SuperTypeDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "SEQ_SUPERTYPE")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private SuperTypesEnum name;


    public SuperType() {
        super(SuperTypeDTO.class);
    }
}


