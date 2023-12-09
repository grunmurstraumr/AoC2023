package se.eg.aoc.day8;

import se.eg.aoc.util.FileReader;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Network {

    Map<String, List<String>> nodes;
    List<String> instructions;
    static Network fromFile(String filename){
        Network network = new Network();
        network.nodes = new HashMap<>();
        network.instructions = new ArrayList<>();

        var lines = FileReader.readInputFile(filename);

        network.instructions = List.of(lines.get(0).strip().split(""));
        for (int i = 2; i < lines.size(); i++){
            String line = lines.get(i);
            if (line.isEmpty()){
                continue;
            }
            String[] split = line.split("=");
            String key = split[0].strip();
            List<String> directions = Arrays.stream(split[1].split(","))
                    .map(s -> s.replaceAll("[()\\s]", "")).toList();
            network.nodes.put(key, directions);

        }
        return network;
    }


    long stepsToReachDestination(String start, String destination){
        long stepsCounter = 0;
        String currentKey = start;
        List<String> currentTargets;
        int instructionsCounter = 0;
        while (!currentKey.equals(destination)){
            stepsCounter++;
            String instruction = instructions.get(instructionsCounter);
            currentTargets = nodes.get(currentKey);
            if (instruction.equals("R")){
                currentKey = currentTargets.get(1);
            }
            else {
                currentKey = currentTargets.get(0);

            }
            instructionsCounter++;
            if (instructionsCounter == instructions.size()){
                instructionsCounter = 0;
            }
        }
        return stepsCounter;
    }

    long stepsToReachDestinationPart2(String start, String destination){
        long stepsCounter = 0;
        String currentKey = start;
        List<String> currentTargets;
        int instructionsCounter = 0;
        while (!currentKey.endsWith(destination)){
            stepsCounter++;
            String instruction = instructions.get(instructionsCounter);
            currentTargets = nodes.get(currentKey);
            if (instruction.equals("R")){
                currentKey = currentTargets.get(1);
            }
            else {
                currentKey = currentTargets.get(0);

            }
            instructionsCounter++;
            if (instructionsCounter == instructions.size()){
                instructionsCounter = 0;
            }
        }
        return stepsCounter;
    }


    long lowestCommonMultiple(List<Long> numbers){
        Long[] arr = numbers.toArray(new Long[0]);
        if (arr.length < 2){
            throw new IllegalArgumentException("lowestCommonMultiple Requires at least two Arrays.asList( as input");
        }
        long lcm_of_array_elements = 1;
        long divisor = 2;
        while (true){
            int count = 0;
            boolean divisible = false;

            for (int i = 0; i < arr.length; i++){
                if (arr[i] == 1){
                    count++;
                }

                if (arr[i] == 0){
                    return 0;
                }
                if (arr[i] % divisor == 0){
                    divisible = true;
                    arr[i] = arr[i] / divisor;
                }
            }

            if (divisible){
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            if (count == arr.length){
                return lcm_of_array_elements;
            }

        }
    }

    long simlutaneousStepsToReachDestination(List<String> startNodes){
        long stepsCounter = 0;
        Map<String, String> currentKeyPerStartNode = startNodes.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        Map<String, List<String>> currentTargetsPerStartNode = startNodes.stream().collect(Collectors.toMap(Function.identity(), e -> Collections.emptyList()));;
        int instructionsCounter = 0;
        while (!allAtDestination(currentKeyPerStartNode.values(), "Z")){
            stepsCounter++;
            String instruction = instructions.get(instructionsCounter);
            for (Map.Entry<String, String> entry : currentKeyPerStartNode.entrySet()) {
                currentTargetsPerStartNode.put(entry.getKey(), nodes.get(entry.getValue()));
                if (instruction.equals("R")) {
                    currentKeyPerStartNode.put(entry.getKey(), currentTargetsPerStartNode.get(entry.getKey()).get(1));
                } else {
                    currentKeyPerStartNode.put(entry.getKey(), currentTargetsPerStartNode.get(entry.getKey()).get(0));
                }
            }
            instructionsCounter++;
            if (instructionsCounter >= instructions.size()){
                instructionsCounter = 0;
            }
            if (stepsCounter == Long.MAX_VALUE -1){
                throw new RuntimeException("Exceeded long");
            }
        }
        return stepsCounter;
    }

    List<Long> distanceToDestination(List<String> startNodes){
        return startNodes.parallelStream().map(node -> stepsToReachDestinationPart2(node, "Z")).collect(Collectors.toList());
    }

    long part2(){

        return lowestCommonMultiple(distanceToDestination(findStartNodes()));
    }

    boolean allAtDestination( Collection<String> currentKeys, String destination){
        return currentKeys.stream().filter(s -> s.endsWith(destination)).count() == currentKeys.size();
    }

    List<String> findStartNodes(){
        return nodes.keySet().stream().filter(s -> s.endsWith("A")).toList();
    }
}
