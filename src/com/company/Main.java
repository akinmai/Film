package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Film film1 = new Film("The Godfather", 9.4);
        Film film2 = new Film("Inception", 8.7);
        Film film3 = new Film("Mad Max: Fury Road", 9.4);
        Film film4 = new Film("Aladdin", 8.0);
        Film film5 = new Film("Room", 8.1);
        Film film6 = new Film("Before Sunset", 8.2);
        Film film7 = new Film("Mission: Impossible - Fallout", 9.6);


        List<Film> list1 = new ArrayList<>(Arrays.asList(film1, film2, film3, film4, film5));
        System.out.println(list1.toString());
        List<Film> list2 = new ArrayList<>(Arrays.asList(film5, film1, film7, film6));
        System.out.println(list2.toString());

        List<Film> copy = list2.stream()
                .collect(Collectors.toList());
        System.out.println(copy);

        list1.stream()
                .filter(el -> list2.stream().anyMatch(el::equals))
                .filter(el -> el.rating > 8.5)
                .forEach(System.out::println);

        List<Film> combined_list = Stream.of(list1, list2)
                .flatMap(el -> el.stream())
                .collect(Collectors.toList());
        System.out.println(combined_list.toString());

        combined_list.stream()
                .sorted(Comparator.comparing(Film::getRating).thenComparing(Film::getTitle))
                .forEach(System.out::println);

        boolean match_rating = combined_list.stream().allMatch(el -> el.rating > 0 && el.rating <= 10);
        System.out.println(match_rating);

        boolean match_alphabet = combined_list.stream().allMatch(el -> el.title.matches("^[A-Za-z]+$"));
        System.out.println(match_alphabet);



        Optional<Film> the_coolest = combined_list.stream().max(Comparator.comparing(Film::getRating));
        System.out.println(the_coolest);
        Optional<Film> the_worst = combined_list.stream().min(Comparator.comparing(Film::getRating));
        System.out.println(the_worst);



        list2.stream()
                //я не понимаю как удалить, поэтому вот
                .filter(el -> list1.stream().noneMatch(el::equals))
                .forEach(System.out::println);


        //без stream api

        List<Film> copy_list = new ArrayList<>(list1);
        System.out.println(copy_list);

        List<Film> new_list = new ArrayList<Film>();
        new_list.addAll(list1);
        new_list.addAll(list2);

        new_list.sort(Comparator.comparing(Film::getRating).thenComparing(Film::getTitle));
        System.out.println(new_list);

        list2.removeAll(list1);
        System.out.println(list2);


        System.out.println("The coolest movie: " + Collections.max(new_list, Comparator.comparing(Film::getRating)));
        System.out.println("The worst movie: " + Collections.min(new_list, Comparator.comparing(Film::getRating)));

        for (Film i: new_list) {
            if (i.rating > 9.0)
                System.out.println(i);
        }

        list1.retainAll(list2);
        System.out.println(list2);

        for (Film i: new_list) {
            boolean ch = i.title.matches("^[A-Za-z]+$");
            System.out.println(ch);
        }

        for (Film i: new_list) {
            if(i.rating > 0 && i.rating <= 10)
                System.out.println("true");
            else System.out.println("false");
        }




    }
}

