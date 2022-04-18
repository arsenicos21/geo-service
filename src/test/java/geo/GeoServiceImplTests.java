package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImplTests {
    GeoService sut = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("source")
    public void testByIp(String ip, Country expectedCountry) {
        final Country resultCountry = sut.byIp(ip).getCountry();

        Assertions.assertEquals(expectedCountry, resultCountry);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("127.0.0.1", null),
                Arguments.of("172.0.32.11", Country.RUSSIA),
                Arguments.of("96.44.183.149", Country.USA));
    }
}
