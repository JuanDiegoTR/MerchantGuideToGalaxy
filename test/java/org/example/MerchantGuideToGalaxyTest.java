package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MerchantGuideToGalaxyTest {
    private MerchantGuideToGalaxy merchantGuideToGalaxy;
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

    @BeforeEach
    void setUp() {
        merchantGuideToGalaxy = new MerchantGuideToGalaxy();
        // Configurar metalCreditsMap para incluir al menos una entrada
        Map<String, Integer> metalCreditsMap = new HashMap<>();
        metalCreditsMap.put("Gold",  1000); // Asumiendo que "Gold" es un metal válido

        // Redirigir System.out a ByteArrayOutputStream para capturar la salida
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testConvertIntergalacticToCredits() {
        String expectedOutput = "El valor en números romanos es: II. El valor en créditos es:  1000\n";
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalOut);
    }

    @Test
    void main() {
        String input = "1\nglob glob\n4\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }

}