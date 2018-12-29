package net.tmhung.example;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@Component
public class DateTimeProvider {
    private final Map<Class, Supplier> nowProviders;

    public DateTimeProvider() {
        nowProviders = new HashMap<>();
        nowProviders.put(LocalDateTime.class, LocalDateTime::now);
    }

    public <T> T now(Class<T> clazz) {
        return clazz.cast(getNowProvider(clazz).get());
    }

    private Supplier getNowProvider(Class clazz) {
        var nowProvider = nowProviders.get(clazz);
        if (Objects.isNull(nowProvider)) {
            throw new IllegalArgumentException(String.format("No provider is defined for class %s", clazz.getSimpleName()));
        }
        return nowProvider;
    }
}
