package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MerchantGuideToGalaxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntergalacticUnits intergalacticUnits = new IntergalacticUnits();

        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Convertir unidades intergalácticas a números romanos.");
            System.out.println("2. Crear metal");
            System.out.println("3. Realizar consulta sobre el valor de un metal.");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    intergalacticUnits.convertToRoman();
                    break;
                case 2:
                    intergalacticUnits.valorMetal();
                    break;
                case 3:
                    intergalacticUnits.TotalCreditoMetal();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (option != 4);
    }
}

class IntergalacticUnits {
    private Map<String, Integer> metalCreditsMap;

    // Constructor para inicializar el mapa
    public IntergalacticUnits() {
        metalCreditsMap = new HashMap<>();
    }
    public void valorMetal() {
        Scanner scanner = new Scanner(System.in);
        String agregarMetal;
        do {
            System.out.print("Ingrese el nombre del metal o 'done' para terminar: ");
            agregarMetal = scanner.nextLine();
            if (!agregarMetal.equals("done")) {
                System.out.print("Ingrese el valor en créditos para " + agregarMetal + ": ");
                String creditsInput = scanner.nextLine(); // Leer la entrada como String para poder verificar si es "done"
                if (creditsInput.equalsIgnoreCase("done")) {
                    System.out.println("No se puede ingresar 'done' como valor de crédito. Intente de nuevo.");
                    continue; // Saltar al siguiente ciclo del bucle sin guardar el metal
                }
                try {
                    int credits = Integer.parseInt(creditsInput); // Intentar convertir la entrada a un entero
                    metalCreditsMap.put(agregarMetal, credits);
                    System.out.println("El metal " + agregarMetal + " ha sido creado con un valor de " + credits + " créditos.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida para el valor de crédito. Por favor, ingrese un número entero.");
                }
            }

        } while (!agregarMetal.equals("done"));
    }

    public void TotalCreditoMetal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("glob " + "I" + "\nprok " + "V" + "\npish " + "X" + "\ntegj " + "L");
        System.out.print("Ingrese las unidades intergalácticas: ");
        String unidades = scanner.nextLine();
        System.out.print("Ingrese el nombre del metal: ");
        String metalName = scanner.nextLine();
        System.out.println(unidades);
        System.out.println(metalName);
        convertIntergalacticToCredits(unidades, metalName);
    }

    public void convertIntergalacticToCredits(String intergalacticUnits, String metalName) {
        String[] units = intergalacticUnits.split(" ");
        StringBuilder romanValue = new StringBuilder();

        int decimalValue = 0;
        for (String unit : units) {
            String romanNumeral = getRomanNumeral(unit);

            if (romanNumeral.equals("")) {
                System.out.println("Unidad intergaláctica no válida: " + unit);
                return; // Terminar el método si una unidad intergaláctica no es válida
            }

            romanValue.append(romanNumeral);
            decimalValue += romanToInt(romanNumeral);
        }

        if (metalCreditsMap.containsKey(metalName)) {
            int credits = metalCreditsMap.get(metalName);
            String decimalRoman = convertDecimalToRoman(credits);
            String combinedRoman = romanValue.toString() + decimalRoman;
            System.out.println("El valor en números romanos es: " + combinedRoman +
                    ". El valor en créditos es: " + credits);
        } else {
            System.out.println("El metal " + metalName + " no existe en la base de datos.");
        }
    }

    private String convertDecimalToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("El número debe estar en el rango de 1 a 3999");
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number / 1000] +
                hundreds[(number % 1000) / 100] +
                tens[(number % 100) / 10] +
                ones[number % 10];
    }


    public void convertToRoman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("glob " + "I" + "\nprok " + "V" + "\npish " + "X" + "\ntegj " + "L");
        System.out.print("Ingrese las unidades intergaláctica: ");
        String intergalacticUnit = scanner.nextLine();

        String[] units = intergalacticUnit.split(" ");
        StringBuilder romanValue = new StringBuilder();

        int decimalValue = 0;
        for (String unit : units) {
            String romanNumeral = getRomanNumeral(unit);

            if (romanNumeral.equals("")) {
                System.out.println("" + unit);
                return;
            }

            // Agregar el valor romano al valor total
            romanValue.append(romanNumeral);

            // Agregar el valor decimal al valor total
            decimalValue += romanToInt(romanNumeral);
        }

        System.out.println("El valor en números romanos es: " + romanValue);
        System.out.println("El valor decimal es: " + decimalValue);
    }

    private String getRomanNumeral(String intergalacticUnit) {
        Map<String, String> intergalacticToRomanMap = new HashMap<>();
        intergalacticToRomanMap.put("", "");
        intergalacticToRomanMap.put("glob", "I");
        intergalacticToRomanMap.put("prok", "V");
        intergalacticToRomanMap.put("pish", "X");
        intergalacticToRomanMap.put("tegj", "L");

        return intergalacticToRomanMap.getOrDefault(intergalacticUnit, "");
    }

    private int romanToInt(String romanNumeral) {
        int result = 0;
        int previousValue = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
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
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
