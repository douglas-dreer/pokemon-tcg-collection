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
        final String TYPE_ATTACK = "Psychic";
        return new AttackDTO(
                UUID.randomUUID(),
                "Confuse Ray",
                Arrays.asList(TYPE_ATTACK, TYPE_ATTACK, TYPE_ATTACK),
                3,
                "30",
                "Flip a coin. If heads, the Defending Pokémon is now Confused."
        );


    }

    public static ImageDTO createImageDTO() {
        return new ImageDTO(
                UUID.randomUUID(),
                "https://images.pokemontcg.io/base1/symbol.png",
                "https://images.pokemontcg.io/base1/logo.png",
                "https://images.pokemontcg.io/base1/1.png",
                "https://images.pokemontcg.io/base1/1_hires.png"
        );
    }

    public static LegalityDTO createLegalityDTO() {
        return new LegalityDTO(UUID.randomUUID(), "Legal", "expanded");
    }

    public static SubTypeDTO createSubTypeDTO() {
        return new SubTypeDTO(UUID.randomUUID(), SubTypesEnum.BASIC);
    }



    public static SuperTypeDTO createSuperTypeDTO() {
        return new SuperTypeDTO(UUID.randomUUID(), SuperTypesEnum.POKEMON);
    }

    public static ResistanceDTO createResistanceDTO() {
        return ResistanceDTO.builder()
                .uuid(UUID.randomUUID())
                .type(PokemonTypeEnum.WATER)
                .effectiveness(-20)
                .build();
    }

    public static WeaknessDTO createWeaknessDTO() {
        return new WeaknessDTO(UUID.randomUUID(), PokemonTypeEnum.FIRE, "x2");
    }

    public static List<SuperTypeDTO> createThreeDifferentSuperTypeDTO(){
        SuperTypeDTO diff = SuperTypeDTO.builder()
                .uuid(UUID.randomUUID())
                .name(SuperTypesEnum.ENERGY)
                .build();

        return Arrays.asList(diff, diff, createSuperTypeDTO());
    }

    public static List<SubTypeDTO> createThreeDifferentSubTypeDTO() {
        SubTypeDTO diff = SubTypeDTO.builder()
                .uuid(UUID.randomUUID())
                .name(SubTypesEnum.EX)
                .build();

        return Arrays.asList(diff, diff, createSubTypeDTO());
    }

    public static List<AttackDTO> createThreeDifferentAttackDTO() {
        AttackDTO diff = AttackDTO.builder()
                .uuid(UUID.randomUUID())
                .name("Reflect Energy")
                .cost(Arrays.asList("Lightning", "Colorless", "Colorless"))
                .convertedEnergyCost(3)
                .damage("70")
                .text("Move an Energy card attached to Ampharos to 1 of your Benched Pokémon.")
                .build();

        return Arrays.asList(diff, diff, createAttackDTO());
    }

    public static List<WeaknessDTO> createThreeDifferentWeaknessDTO() {
        WeaknessDTO diff = WeaknessDTO.builder()
                .uuid(UUID.randomUUID())
                .type(PokemonTypeEnum.WATER)
                .vulnerability("x2")
                .build();

        return Arrays.asList(diff, diff, createWeaknessDTO());
    }

    public static List<AbilityDTO> createThreeDifferentAbilityDTO() {
        AbilityDTO diff = AbilityDTO.builder()
                .uuid(UUID.randomUUID())
                .name("Damage Bind")
                .type("Poké-Body")
                .text("Each Pokémon that has any damage counters on it (both yours and your opponent's) can't use any Poké-Powers.")
                .build();

        return Arrays.asList(diff, diff, createAbilityDTO());
    }

    public static List<ImageDTO> createThreeDifferentImageDTO() {
        ImageDTO diff = ImageDTO.builder()
                .uuid(UUID.randomUUID())
                .symbol("https://images.pokemontcg.io/pl1/symbol.png")
                .logo("https://images.pokemontcg.io/dp3/logo.png")
                .small("https://images.pokemontcg.io/pl1/1.png")
                .large("https://images.pokemontcg.io/pl1/1_hires.png")
                .build();

        return Arrays.asList(diff, diff, createImageDTO());
    }
    public static List<LegalityDTO> createThreeDifferentLegalityDTO() {
        LegalityDTO diff = LegalityDTO.builder()
                .uuid(UUID.randomUUID())
                .unlimited("Legal")
                .expanded("expanded")
                .build();

        return Arrays.asList(diff, diff, createLegalityDTO());
    }


}