package kz.sabyrzhan.algo.leetcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GenerateNextTask {
    public static void main(String[] args) throws Exception {
        int startTask = 201;
        int endTaskNumber = 1396;
        String filePath = "/Users/sabyrzhan/projects/algo-solutions/src/main/java/kz/sabyrzhan/algo/leetcode/nextTasks.txt";
        Set<Integer> finishedTasks = new HashSet<>();
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        while(scanner.hasNextLine()) {
            finishedTasks.add(Integer.valueOf(scanner.nextLine().trim()));
        }
        scanner.close();

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath, true));

        Random random = new Random(System.currentTimeMillis());
        int endBound = endTaskNumber - startTask;
        while(true) {
            int randomNumber = random.nextInt(endBound + 1);
            int nextTaskNumber = startTask + randomNumber;
            if (finishedTasks.contains(nextTaskNumber)) {
                continue;
            }

            System.out.println("Next task number: " + nextTaskNumber);
            printWriter.println(nextTaskNumber);
            printWriter.close();
            break;
        }
    }
}
