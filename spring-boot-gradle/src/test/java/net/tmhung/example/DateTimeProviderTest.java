package net.tmhung.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Simple JUnit 5 tests")
public class DateTimeProviderTest {

    private final DateTimeProvider dateTimeProvider = new DateTimeProvider();

    @Test
    void now_WithLocalDateTime_ExpectCurrentTime() {
        assertThat(dateTimeProvider.now(LocalDateTime.class)).isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void now_WithUnknownClass_ExpectException() {
        assertThatThrownBy(() -> dateTimeProvider.now(Integer.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No provider is defined for class Integer");
    }


}
