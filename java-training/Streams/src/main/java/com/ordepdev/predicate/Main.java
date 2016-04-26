package com.ordepdev.predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<String> predicate1 = s -> s.length() < 20;
        Predicate<String> predicate2 = s -> s.length() > 5;
        Predicate<String> predicate3 = predicate1.and(predicate2);
        Predicate<String> predicate4 = predicate1.or(predicate2);
        Predicate<String> predicate5 = Predicate.isEqualTo("Yes");
        Predicate<Integer> predicate6 = Predicate.isEqualTo(29);

        System.out.println(predicate1.test("test this String"));
        System.out.println(predicate3.test("test this String"));
        System.out.println(predicate4.test("test this String"));
        System.out.println(predicate5.test("Yes"));
        System.out.println(predicate5.test("No"));
        System.out.println(predicate6.test(29));
        System.out.println(predicate6.test(30));
    }
}
