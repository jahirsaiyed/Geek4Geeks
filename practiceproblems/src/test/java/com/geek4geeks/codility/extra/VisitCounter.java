package com.geek4geeks.codility.extra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class VisitCounter {
//    https://app.codility.com/c/feedback/J9UX7Z-MRT/

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        return Arrays.stream(visits)
                .filter(Objects::nonNull)
                .flatMap(m -> m.entrySet().stream())
                .filter(u -> Objects.nonNull(u.getValue()) && Objects.nonNull(u.getKey()))
                .filter(u -> u.getValue().getVisitCount().isPresent())
                .filter(u -> u.getKey().matches("\\d+"))
                .collect(Collectors.toMap(o -> Long.parseLong(o.getKey()), o -> o.getValue().getVisitCount().get()));
    }

    @Test
    public void test() {
        List<Map<String, UserStats>> userStats = new ArrayList<>();
        Map<String, UserStats> u1 = new HashMap<>();
        u1.put("1", null);
        u1.put("2", new UserStats(500l));
        u1.put("2", new UserStats(600l));
        u1.put("3", new UserStats(300l));
        u1.put("4", new UserStats(800l));
        u1.put("jhs", new UserStats(800l));


        Map<String, UserStats> u2 = new HashMap<>();
        u2.put("7", null);
        u2.put("21", new UserStats(500l));
        u2.put("42", new UserStats(600l));
        u2.put("23", new UserStats(300l));
        u2.put("64", new UserStats(800l));
        u2.put("1a", new UserStats(800l));

        Assertions.assertEquals(7, count(u1, null, u2).size());
    }
}