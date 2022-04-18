package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceImplTests {
    LocalizationServiceImpl sut = new LocalizationServiceImpl();

    @ParameterizedTest
    @MethodSource("source")
    public void testLocal(Country country, String expected) {
        String result = sut.locale(country);

        Assertions.assertEquals(result, expected);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"));
    }
}
