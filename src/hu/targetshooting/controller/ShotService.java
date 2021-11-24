package hu.targetshooting.controller;

import hu.targetshooting.model.domain.ShoutResult;

import java.util.Comparator;
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

    public int getLongestShotSequenceId() {
        return results.stream()
                .max(Comparator.comparing(ShoutResult::getShotCount))
                .map(ShoutResult::getId)
                .get();
    }

    public String getSuccessShotIndexesById(int id) {
        return results.stream()
                .filter(i -> i.getId() == id)
                .map(ShoutResult::getSuccessShotIndexes)
                .findFirst()
                .get();
    }

    public int getScoreById(int id) {
        return results.stream()
                .filter(i -> i.getId()==id)
                .map(ShoutResult::getScore)
                .findFirst()
                .get();
    }
    private ShotResult getResultById(int id) {
        return results.stream()
                .filter(i -> i.getId() == id)
                ...(!)

    }

}
