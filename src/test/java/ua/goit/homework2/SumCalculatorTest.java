package ua.goit.homework2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    void testSumShouldReturnOk() {
        //given
        int num = 1;
        //when
        int actualResult = sumCalculator.sum(num);
        //then
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);


    }

    @Test
    void testExceptionShouldReturnOk() {
        //given
        int num = 0;
        //when
        boolean thrown = false;
        try {
            int actualResult = sumCalculator.sum(num);
        } catch (IllegalArgumentException e) {
            thrown = true;
        };
        //then
        assertTrue(thrown);
    }

    @ParameterizedTest(name = "#{index} - Run test with arguments input={0} expectedResult={1}")
    @MethodSource("predefinedData")
    public void testSumParametrizedShouldCompleteCorrect(int num, int expectedResult) {
        //given
        //when
        int actualResult = sumCalculator.sum(num);
        //then
        assertEquals(actualResult, expectedResult);
    }


    static Stream<Arguments> predefinedData() {
        return Stream.of(
            Arguments.arguments(1, 1),
            Arguments.arguments(2, 3),
            Arguments.arguments(3, 6),
            Arguments.arguments(4, 10),
            Arguments.arguments(5, 15),
            Arguments.arguments(6, 21),
            Arguments.arguments(7, 28),
            Arguments.arguments(8, 36),
            Arguments.arguments(9, 45),
            Arguments.arguments(10, 55)
        );
    }
}