package com.nintendo.tcg.pokemon.sdk.repository;

import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PokemonSetRepository extends JpaRepository<PokemonSet, UUID> {
    Optional<PokemonSet> findAllByCode(String code);

    List<PokemonSet> findAllByNameContainingIgnoreCase(String name);

    List<PokemonSet> findAllBySeries(String serie);
}
