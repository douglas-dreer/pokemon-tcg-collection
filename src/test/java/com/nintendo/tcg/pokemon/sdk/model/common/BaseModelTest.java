package com.nintendo.tcg.pokemon.sdk.model.common;

public interface BaseModelTest {
    void mustReturnSuccessWhenInitializeWithAllConstructor();
    void mustReturnSuccessWhenInitializeWithoutId();

    void mustReturnSuccessWhenInitializeWithSetters();

    void mustReturnSuccessWhenInitializeWithBuilder();

    void mustReturnSuccessWhenConvertToEntity() throws Exception;

    // void mustReturnSuccessWhenConvertToJSON() throws JsonProcessingException;

    // void mustReturnSuccessWhenConterToObject() throws IOException;
    void mustReturnSuccessWhenEquals();
    void mustReturnSuccessWhenHash();
}