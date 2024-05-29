import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean salida = true;
        var option = 0;
        ExchangeApi convirtiendo = new ExchangeApi();
        ExchangeRate cambio;
        double total;

        while(salida){

            System.out.println("**************************************************");
            System.out.println("Sea bienvenido/a al Convensor de Moneda =)");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Colón Costarricense");
            System.out.println("8) Colón Costarricense =>> Dólar");
            System.out.println("9) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("**************************************************");
            System.out.println("");

            try {
                option = Integer.valueOf(leer.nextInt());

                if(option == 9){
                    salida = false;
                } else if(option < 1 || option > 9){
                    System.out.println("El número ingresado debe estar entre 1 y 9");
                } else {
                    leer.nextLine();
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double cantidad = Double.parseDouble(leer.nextLine());

                    switch (option) {
                        case 1:
                            total = convirtiendo.buscandoTotal("USD", "ARS", cantidad);
                            System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + total + " [ARS]");
                            break;
                        case 2:
                            total = convirtiendo.buscandoTotal("ARS", "USD", cantidad);
                            System.out.println("El valor " + cantidad + " [ARS] corresponde al valor final de =>>> " + total + " [USD]");
                            break;
                        case 3:
                            total = convirtiendo.buscandoTotal("USD", "BRL", cantidad);
                            System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + total + " [BRL]");
                            break;
                        case 4:
                            total = convirtiendo.buscandoTotal("BRL", "USD", cantidad);
                            System.out.println("El valor " + cantidad + " [BRL] corresponde al valor final de =>>> " + total + " [USD]");
                            break;
                        case 5:
                            total = convirtiendo.buscandoTotal("USD", "COP", cantidad);
                            System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + total + " [COP]");
                            break;
                        case 6:
                            total = convirtiendo.buscandoTotal("COP", "USD", cantidad);
                            System.out.println("El valor " + cantidad + " [COP] corresponde al valor final de =>>> " + total + " [USD]");
                            break;
                        case 7:
                            total = convirtiendo.buscandoTotal("USD", "CRC", cantidad);
                            System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + total + " [CRC]");
                            break;
                        case 8:
                            total = convirtiendo.buscandoTotal("CRC", "USD", cantidad);
                            System.out.println("El valor " + cantidad + " [CRC] corresponde al valor final de =>>> " + total + " [USD]");
                            break;
                    }
                    System.out.println("");
                }
            } catch (Exception e){
                leer.nextLine();
                System.out.println("Favor ingresar un número entre 1 y 9 y un monto válido");
            }
        }

    }

}