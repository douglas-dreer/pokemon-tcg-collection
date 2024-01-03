package com.nintendo.tcg.pokemon.sdk.utility;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.nintendo.tcg.pokemon.sdk.utility.Converter.toList;

@Log4j2
public class ReadFiles {
    public static <T> List<T> readAndConvertFile(String filePath, Class<T> targetClass) throws IOException {
        try (InputStream inputStream = ReadFiles.class.getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String fileContent = reader.lines().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
            return Converter.toList(fileContent, targetClass);

        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }
}