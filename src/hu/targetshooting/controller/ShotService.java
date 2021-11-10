package hu.targetshooting.controller;

import hu.targetshooting.model.domain.ShoutResult;

import java.util.List;
import java.util.stream.Collectors;

public class ShotService {

    private final List<ShoutResult> results;

    public ShotService(List<ShoutResult> results) {
        this.results = results;
    }
    public String getTwoSuccessShotIds() {
        return results.stream()
                .filter(ShoutResult::hasTwoSuccessShotsInRow)
                .map(ShoutResult::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
