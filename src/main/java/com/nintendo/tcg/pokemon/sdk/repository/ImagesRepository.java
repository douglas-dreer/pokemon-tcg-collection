package com.nintendo.tcg.pokemon.sdk.repository;

import com.nintendo.tcg.pokemon.sdk.entity.Images;
import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImagesRepository extends JpaRepository<Images, UUID> {
}
