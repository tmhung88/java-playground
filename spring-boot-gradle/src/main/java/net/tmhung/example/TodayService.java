package net.tmhung.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TodayService {
    private final DateTimeProvider dateTimeProvider;

    @Autowired
    public TodayService(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public String getToday() {
        return dateTimeProvider.now(LocalDateTime.class).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
