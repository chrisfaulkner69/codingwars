package org.lucidant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageDecoder {
    private static final String SPACE_DELIMITER = " ";

    public static String decode(String messageFile) {
        StringBuilder decodedMessage = new StringBuilder();
        Map<Integer, String> numberWords = mapNumbersToWords(messageFile);
        List<Integer> sortedNumbers = numberWords.keySet().stream().sorted().collect(Collectors.toList());
        List<List<Integer>> pyramid = buildPyramid(sortedNumbers);

        for (List<Integer> level : pyramid) {
            String decodedWord = numberWords.get(level.get(level.size() - 1));
            decodedMessage.append(decodedWord).append(SPACE_DELIMITER);
        }

        return decodedMessage.toString().trim();
    }

    private static List<List<Integer>> buildPyramid(List<Integer> sortedNumbers) {
        List<List<Integer>> pyramid = new ArrayList<>();
        for (int i = 1; i <= sortedNumbers.size(); i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                level.add(sortedNumbers.remove(0));
            }
            pyramid.add(level);
        }
        return pyramid;
    }

    private static Map<Integer, String> mapNumbersToWords(String messageFile) {
        Map<Integer, String> numberWords = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(messageFile))) {
            lines.forEach(line -> {
                String[] parts = line.split(SPACE_DELIMITER);
                int number = Integer.parseInt(parts[0]);
                numberWords.put(number, parts[1]);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return numberWords;
    }
}
