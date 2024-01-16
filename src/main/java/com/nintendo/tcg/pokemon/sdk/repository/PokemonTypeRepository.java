package com.nintendo.tcg.pokemon.sdk.repository;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonType;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonType, UUID> {
    PokemonType existsPokemonTypeByName(PokemonTypeEnum pokemonType);

    @Query("SELECT pt FROM PokemonType pt WHERE pt.name = :name")
    PokemonType buscarPorNome(@Param("name") String name);

    @Query("SELECT COUNT(py) FROM PokemonType py")
    Long hasExistRegisters();
}
