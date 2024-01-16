package com.nintendo.tcg.pokemon.sdk.model.common;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface BaseModelTest {

    void mustReturnSuccessWhenInitializeWithConstructor();

    void mustReturnSuccessWhenInitializeWithSetters();

    void mustReturnSuccessWhenInitializeWithBuilder();

    void mustReturnSuccessWhenConvertToEntity();

    void mustReturnSuccessWhenConvertToJSON() throws JsonProcessingException;

    void mustReturnSuccessWhenConterToObject() throws IOException;
    void mustReturnSuccessWhenEquals();
    void mustReturnSuccessWhenHash();
}