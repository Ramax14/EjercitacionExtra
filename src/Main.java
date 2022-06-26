import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcion;


        System.out.println("Bienvenido! Indique la opción a realizar");
        do{
            System.out.println("Menú de opciones:");
            System.out.println("1- Indicar si es primo.");
            System.out.println("2- Mostrar los números primos entre 1 y n.");
            System.out.println("3- Operaciones con una matriz de nxm.");
            System.out.println("4- Mostrar la tabla de un número ingresado.");
            System.out.println("5- Programa convertidor Pesos a Real/Dólar/Euro.");
            System.out.println("0- Salir");
            opcion = read.nextInt();
            if(opcion == 1){
                int num;

                System.out.println("Ingrese un número: ");
                num = read.nextInt();
                if(EsPrimo(num)){
                    System.out.println("El número "+num+" es primo");
                }
                else{
                    System.out.println("El número "+num+" no es primo");
                }
            } else if (opcion == 2) {
                int num;

                System.out.println("Ingrese un número: ");
                num = read.nextInt();
                MostrarPrimos(num);

            } else if (opcion == 3) {
                int n,m;
                System.out.println("Ingrese las dimensiones de la matriz nxm");
                System.out.println("Valor de n:");
                n = read.nextInt();
                System.out.println("Valor de m:");
                m = read.nextInt();
                MetodoMatriz(read,n,m);
            } else if (opcion == 4) {

            } else if (opcion == 5) {

            } else if (opcion == 0) {
                continue;
            }else
                System.out.println("Valor erroneo. Intente nuevamente.");
        }while(opcion != 0);
    }

    public static boolean EsPrimo(int num){

        if(num == 0 || num == 1 || num == 4){
            return false;
        } else {
            for (int i = 2; i < num/2; i++){
                if (num % i == 0)
                    return  false;
            }
            return true;
        }
    }

    public static void MostrarPrimos(int num){
        for (int i = 1; i < num/2; i++) {
            if(EsPrimo(i))
                System.out.println(i);
        }
    }

    public static void MetodoMatriz(Scanner read, int n, int m){

        int matriz[][] = new int[n][m];
        int option;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                System.out.println("Valor de ["+i+"]["+j+"]:");
                matriz[i][j] = read.nextInt();
            }
        }
        do {
            System.out.println("Qué desea realizar?");
            System.out.println("1- Sumar todos sus elementos.");
            System.out.println("2- Producto de todos sus elementos.");
            System.out.println("3- La suma de la diagonal principal.");
            System.out.println("4- Producto de la diagonal principal.");
            System.out.println("5- La suma de la diagonal secundaria.");
            System.out.println("6- Producto de la diagonal secundaria.");
            System.out.println("0- Salir.");
            option = read.nextInt();
            if (option == 1){
                System.out.println("La suma de todos los elementos es: "+SumaDeProductos(matriz, n-1, m-1, n-1));
            }
            else if(option == 2){
                System.out.println("El producto de todos sus elementos es: "+ProductoTotal(matriz,n-1,m-1,n-1));
            } else if (option == 3) {
                if(n>m){
                    System.out.println("La suma de los elementos en la diagonal principal es: "+SumaPrincipal(matriz,m));
                }else{
                    System.out.println("La suma de los elementos en la diagonal principal es: "+SumaPrincipal(matriz,n));
                }
            }
        }while (option != 0);




    }

    public static int SumaDeProductos(int [][] mat, int n, int m, int i){

        if(n == 0 && m == 0){
            return mat[n][m];
        }
        else if(n == 0){
            return mat[n][m]+SumaDeProductos(mat,i,m-1,i);
        }
        else
            return mat[n][m]+SumaDeProductos(mat,n-1,m,i);
    }
}