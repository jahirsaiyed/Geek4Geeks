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
        if(!Objects.nonNull(visits)) {
            return Collections.emptyMap();
        }
        Map<Long, Long> collect = Arrays.stream(visits)
                .flatMap(m -> m.entrySet().stream())
                .filter(userStatsEntry -> userStatsEntry.getKey() != null && userStatsEntry.getKey().matches("\\d+")
                        && userStatsEntry.getValue() != null && userStatsEntry.getValue().getVisitCount().isPresent())
                .collect(Collectors.toMap(o -> Long.parseLong(o.getKey()), o -> o.getValue().getVisitCount().get()));
        return collect;
    }

    @Test
    public void test() {
        List<Map<String, UserStats>> userStats = new ArrayList<>();
        Map<String, UserStats> u1 = new HashMap<>();
        u1.put("1", null);
        u1.put("2", new UserStats(500l));
        u1.put("3", new UserStats(300l));
        u1.put("4", new UserStats(800l));
//        Map<String, UserStats>[] objects = (Map<String, UserStats>[]) userStats.toArray();
//        Assertions.assertEquals(0, count().size());
//        Assertions.assertEquals(0, count(null).size());
        Assertions.assertEquals(3, count(u1).size());
    }
}