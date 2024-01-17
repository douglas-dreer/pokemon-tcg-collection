package com.nintendo.tcg.pokemon.sdk.model.common;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface BaseModelTest {
    void mustReturnSuccessWhenInitializeWithAllConstructor();

    void mustReturnSuccessWhenInitializeWithSetters();

    void mustReturnSuccessWhenInitializeWithBuilder();

    void mustReturnSuccessWhenConvertToEntity() throws Exception;

    // void mustReturnSuccessWhenConvertToJSON() throws JsonProcessingException;

    // void mustReturnSuccessWhenConterToObject() throws IOException;
    void mustReturnSuccessWhenEquals();
    void mustReturnSuccessWhenHash();
}