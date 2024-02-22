package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticUnitsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void testConvertIntergalacticToCredits() throws Exception {
        Map<String, Integer> metalCreditsMap = new HashMap<>();
        metalCreditsMap.put("Gold",  1000); // Asumiendo que "Gold" es un metal válido

        IntergalacticUnits units = new IntergalacticUnits();

        Field field = IntergalacticUnits.class.getDeclaredField("metalCreditsMap");
        field.setAccessible(true); // Hacer el campo accesible
        field.set(units, metalCreditsMap); // Configurar el campo con el mapa

        units.convertIntergalacticToCredits("glob glob", "Gold");

        String expectedOutput = "El valor en números romanos es: II. El valor en créditos es:  1000\n";
    }


    @Test
    void valorMetal() {
        String input = "Gold\n10\ndone\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        IntergalacticUnits units = new IntergalacticUnits();
        units.valorMetal();
    }

    @Test
    void TotalCreditoMetal(){
        String input = "glob glob\nGold\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        IntergalacticUnits units = new IntergalacticUnits();
        units.convertIntergalacticToCredits("Gold",  "10"); // Asegúrate de tener este método en IntergalacticUnits

        units.TotalCreditoMetal();
        System.setOut(originalOut);
        String expectedOutput = "glob glob\nGold\nEl valor en números romanos es: II. El valor en créditos es:  10";
    }

    @Test
    void testConvertDecimalToRoman() {
        assertEquals("I", convertDecimalToRoman(1));
        assertEquals("IV", convertDecimalToRoman(4));
        assertEquals("V", convertDecimalToRoman(5));
        assertEquals("IX", convertDecimalToRoman(9));
        assertEquals("X", convertDecimalToRoman(10));
        assertEquals("XL", convertDecimalToRoman(40));
        assertEquals("L", convertDecimalToRoman(50));
        assertEquals("XC", convertDecimalToRoman(90));
        assertEquals("C", convertDecimalToRoman(100));
        assertEquals("CD", convertDecimalToRoman(400));
        assertEquals("D", convertDecimalToRoman(500));
        assertEquals("CM", convertDecimalToRoman(900));
        assertEquals("M", convertDecimalToRoman(1000));
        assertEquals("MMMCMXCIX", convertDecimalToRoman(3999)); // Número romano para   3999
        // Puedes agregar más casos si es necesario
    }

    @Test
    void testConvertDecimalToRomanOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> convertDecimalToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> convertDecimalToRoman(4000));
    }

    private String convertDecimalToRoman(int number) {
        if (number <  1 || number >  3999) {
            throw new IllegalArgumentException("El número debe estar en el rango de  1 a  3999");
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number /  1000] +
                hundreds[(number %  1000) /  100] +
                tens[(number %  100) /  10] +
                ones[number %  10];
    }

    @Test
    void testConvertIntergalacticToCreditsValidUnitsButMetalDoesNotExist() {
        IntergalacticUnits units = new IntergalacticUnits();
        units.convertIntergalacticToCredits("glob glob", "Silver");

        String expectedOutput = "El metal Silver no existe en la base de datos.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void testConvertIntergalacticToCreditsInvalidUnits() {
        IntergalacticUnits units = new IntergalacticUnits();
        units.convertIntergalacticToCredits("glob glob invalid", "Gold");

        String expectedOutput = "Unidad intergaláctica no válida: invalid";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
    @Test
    void convertToRoman() {
        String input = "glob glob\n\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        IntergalacticUnits units = new IntergalacticUnits();
        units.convertToRoman();
    }

    @Test
    void testRomanToInt() {
        assertEquals(1, romanToInt("I"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(5, romanToInt("V"));
        assertEquals(9, romanToInt("IX"));
        assertEquals(10, romanToInt("X"));
        assertEquals(40, romanToInt("XL"));
        assertEquals(50, romanToInt("L"));
        assertEquals(90, romanToInt("XC"));
        assertEquals(100, romanToInt("C"));
        assertEquals(400, romanToInt("CD"));
        assertEquals(500, romanToInt("D"));
        assertEquals(900, romanToInt("CM"));
        assertEquals(1000, romanToInt("M"));
        assertEquals(1989, romanToInt("MCMLXXXIX"));
        assertEquals(3999, romanToInt("MMMCMXCIX"));
    }

    private int romanToInt(String romanNumeral) {
        int result =   0;
        int previousValue =   0;
        for (int i = romanNumeral.length() -   1; i >=   0; i--) {
            int currentValue = getValue(romanNumeral.charAt(i));
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            previousValue = currentValue;
        }
        return result;
    }

    private int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return   1;
            case 'V':
                return   5;
            case 'X':
                return   10;
            case 'L':
                return   50;
            case 'C':
                return   100;
            case 'D':
                return   500;
            case 'M':
                return   1000;
            default:
                return   0;
        }
    }
}