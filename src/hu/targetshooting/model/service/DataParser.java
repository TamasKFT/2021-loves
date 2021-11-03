package hu.targetshooting.model.service;

import hu.targetshooting.model.domain.ShoutResult;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id;

    public List<ShoutResult> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(line -> new ShoutResult(++id, line))
                .collect(Collectors.toList());
    }
}
