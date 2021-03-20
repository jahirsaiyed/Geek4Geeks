package com.geek4geeks.codility.extra;

import java.util.Optional;

public class UserStats {
    Optional<Long> visitCount = Optional.empty();

    public UserStats() {
    }

    public UserStats(Long visitCount) {
        this.visitCount = Optional.of(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
