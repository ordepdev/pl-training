package com.ordepdev.whatisnew.examples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOExample {

    public static void main(String[] args) {

        try (BufferedReader reader =
            new BufferedReader(
            new FileReader(
            new File("src/main/resources/sample.txt")))) {

            Stream<String> stream = reader.lines();
            stream.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get("src/main/resources/sample.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("* list src *");
        Path path1 = Paths.get("src");
        try (Stream<Path> stream = Files.list(path1)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("* walk src *");
        try (Stream<Path> stream = Files.walk(path1)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("* walk src with depth limit*");
        try (Stream<Path> stream = Files.walk(path1, 2)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
