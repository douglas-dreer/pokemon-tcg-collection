package com.nintendo.tcg.pokemon.sdk.utility;

import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class InformationGenerator {

    /**
     * @return AbilityDTO
     */
    public static AbilityDTO createAbilityDTO() {
        return AbilityDTO.builder()
                .uuid(UUID.randomUUID())
                .name("Damage Swap")
                .text("As often as you like during your turn (before your attack), you may move 1 damage counter from 1 of your Pokémon to another as long as you don't Knock Out that Pokémon. This power can't be used if Alakazam is Asleep, Confused, or Paralyzed.")
                .type("Pokémon Power")
                .build();
    }

    /**
     * @return AttackDTO
     */
    public static AttackDTO createAttackDTO() {
        return AttackDTO.builder()
                .uuid(UUID.randomUUID())
                .name("Confuse Ray")
                .cost(Arrays.asList("Psychic", "Psychic", "Psychic"))
                .convertedEnergyCost(3)
                .damage("30")
                .text("Flip a coin. If heads, the Defending Pokémon is now Confused.")
                .build();
    }

    public static ImageDTO createImageDTO() {
        return ImageDTO.builder()
                .uuid(UUID.randomUUID())
                .symbol("https://images.pokemontcg.io/base1/symbol.png")
                .logo("https://images.pokemontcg.io/base1/logo.png")
                .small("https://images.pokemontcg.io/base1/1.png")
                .large("https://images.pokemontcg.io/base1/1_hires.png")
                .build();
    }

    public static LegalityDTO createLegalityDTO() {
        return LegalityDTO.builder()
                .uuid(UUID.randomUUID())
                .unlimited("Legal")
                .expanded("expanded")
                .build();
    }

    public static SubTypeDTO createSubTypeDTO() {
        return SubTypeDTO.builder()
                .uuid(UUID.randomUUID())
                .name(SubTypesEnum.BASIC)
                .build();
    }



    public static SuperTypeDTO createSuperTypeDTO() {
        return SuperTypeDTO.builder()
                .uuid(UUID.randomUUID())
                .name(SuperTypesEnum.POKEMON)
                .build();
    }

    public static ResistanceDTO createResistanceDTO() {
        return ResistanceDTO.builder()
                .uuid(UUID.randomUUID())
                .type(PokemonTypeEnum.WATER)
                .effectiveness(-20)
                .build();
    }

    public static WeaknessDTO createWeaknessDTO() {
        return WeaknessDTO.builder()
                .uuid(UUID.randomUUID())
                .type(PokemonTypeEnum.FIRE)
                .vulnerability("x2")
                .build();
    }

    public static List<SuperTypeDTO> createThreeDifferentSuperTypeDTO(){
        SuperTypeDTO diff = SuperTypeDTO.builder()
                .uuid(UUID.randomUUID())
                .name(SuperTypesEnum.ENERGY)
                .build();

        return Arrays.asList(diff, diff, createSuperTypeDTO());
    }


}