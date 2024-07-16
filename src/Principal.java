import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        Consulta consulta = new Consulta();
        DecimalFormat df = new DecimalFormat("#.##");

        String base_code = "", target_code = "";
        double cantidad = 0.0;

        while(true){
            int opcion = 0;
            System.out.println("""
                Elige la conversión que deseas realizar (digite la opción del 1 al 9)
                1. Dolares a Euros
                2. Dolares a Pesos Mexicanos
                3. Dolares a Pesos Argentinos
                4. Dolares a Real Brasileño
                5. Euros a Dolares
                6. Pesos Mexicanos a Dolares
                7. Pesos Argentinos a Dolares
                8. Real Brasileño a Dolares
                9. Salir del Programa
                """);
            try {
                opcion = Integer.parseInt(consola.nextLine());
                if (opcion >= 1 && opcion <= 9){
                    switch (opcion) {
                        case 1:
                            base_code = "USD";
                            target_code = "EUR";
                            break;
                        case 2:
                            base_code = "USD";
                            target_code = "MXN";
                            break;
                        case 3:
                            base_code = "USD";
                            target_code = "ARS";
                            break;
                        case 4:
                            base_code = "USD";
                            target_code = "BRL";
                            break;
                        case 5:
                            base_code = "EUR";
                            target_code = "USD";
                            break;
                        case 6:
                            base_code = "MXN";
                            target_code = "USD";
                            break;
                        case 7:
                            base_code = "ARS";
                            target_code = "USD";
                            break;
                        case 8:
                            base_code = "BRL";
                            target_code = "USD";
                            break;
                        case 9:
                            System.out.println("Gracias por usar el programa!.");
                            return;
                    }
                    System.out.println("Digite el monto a convertir:");
                    cantidad = Double.valueOf(consola.nextLine());

                    Monedas moneda = consulta.convertir(base_code, target_code, cantidad);
                    System.out.println("La conversión de " + cantidad + " [" + base_code + "] es igual a " +
                            df.format(moneda.conversion_result()) + " [" + target_code + "]." );
                }else {
                    System.out.println("Opción no válida. Por favor, digite una opción correcta.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El monto ingresado no es correcto. Por favor, ingrese un número entero.");
                System.out.println(e.getMessage());
            }
        }

    }
}
