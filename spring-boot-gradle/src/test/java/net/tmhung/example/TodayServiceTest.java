package net.tmhung.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Junit 5 & Mockito 2 tests")
public class TodayServiceTest {
    @InjectMocks
    private TodayService todayService;

    @Mock
    private DateTimeProvider dateTimeProvider;

    @Test
    void getToday_ExpectTheCurrentDayInISOFormat() {
        when(dateTimeProvider.now(LocalDateTime.class)).thenReturn(LocalDate.of(2018, 11, 30).atStartOfDay());
        assertThat(todayService.getToday()).isEqualTo("2018-11-30");
    }
}
