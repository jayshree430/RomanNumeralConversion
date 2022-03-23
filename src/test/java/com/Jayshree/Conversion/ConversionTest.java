package com.Jayshree.Conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ConversionTest {

    private Conversion convert;

    @BeforeEach
    public void setup() {
        convert = new Conversion();
    }

    @Test
    public void checkEmptySentenceIsNotRomanNumeral(){
        Assertions.assertEquals(-1,convert.romanToDecimal(""));
    }

    @Test
    public void checkInputWithNumberIsNotRomanNumeral(){
        Assertions.assertEquals(-1,convert.romanToDecimal("1234"));
    }

    @Test
    public void checkInputWithProperRomanNumeral(){
        Assertions.assertEquals(990,convert.romanToDecimal("CMXC"));
    }

    @Test
    public void checkInputWithRomanNumeral(){
        Assertions.assertEquals(55,convert.romanToDecimal("LV"));
    }

    @Test
    public void checkRomanNumeralWithLowerCase(){
        Assertions.assertEquals(1500,convert.romanToDecimal("md"));
    }

    @Test
    public void checkInputWithRomanNumeralMixedWithNumber(){
        Assertions.assertEquals(-1,convert.romanToDecimal("IV3"));
    }

}

