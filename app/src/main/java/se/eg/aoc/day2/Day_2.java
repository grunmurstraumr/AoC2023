package se.eg.aoc.day2;

import se.eg.aoc.Day_1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day_2 {

    List<Game> games;
    public List<String> readInputFile(String filename) {
        List<String> lines;
        try {
            Day_2.class.getClassLoader().getResource(filename).toURI();
            return Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Game>parseInput(List<String> lines){
        return lines.stream().map(Game::fromLine).toList();
    }

    public void readGamesFromFile(String filename){
        var lines = readInputFile(filename);
        this.games = parseInput(lines);
    }

    public List<Integer> possibleGames(CubeSet cubeSet){
        return games.stream().filter(game -> game.isPossible(cubeSet)).map(game -> game.id).collect(Collectors.toList());
    }

    public int sumPossibleGames(CubeSet cubeSet){
        return possibleGames(cubeSet).stream().mapToInt(Integer::intValue).sum();
    }

    public long sumOfPowers(){
        return games.stream().map(Game::calculateMinumCubePower).mapToInt(Integer::intValue).sum();
    }

}
