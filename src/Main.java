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
                GenerarTabla(read);
            } else if (opcion == 5) {
                Convertidor(read);
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
                System.out.println("La suma de todos los elementos es: "+SumaTotal(matriz, n-1, m-1, n-1));
            }
            else if(option == 2){
                System.out.println("El producto de todos sus elementos es: "+ProductoTotal(matriz,n-1,m-1,n-1));
            } else if (option == 3) {
                if(n>m){
                    System.out.println("La suma de los elementos en la diagonal principal es: "+SumaPrincipal(matriz,m));
                }else{
                    System.out.println("La suma de los elementos en la diagonal principal es: "+SumaPrincipal(matriz,n));
                }
            } else if(option == 4){
                if(n>m){
                    System.out.println("El producto de los elementos en la diagonal principal es: "+ProductoPrincipal(matriz,m));
                }else{
                    System.out.println("El producto de los elementos en la diagonal principal es: "+ProductoPrincipal(matriz,n));
                }
            } else if(option == 5){
                if(n>m){
                    System.out.println("La suma de los elementos en la diagonal secundaria es: "+SumaSecundario(matriz,m));
                }else{
                    System.out.println("La suma de los elementos en la diagonal secundaria es: "+SumaSecundario(matriz,n));
                }
            } else if(option == 6){
                if(n>m){
                    System.out.println("El producto de los elementos en la diagonal secundaria es: "+ProductoSecundario(matriz,m));
                }else{
                    System.out.println("El producto de los elementos en la diagonal secundaria es: "+ProductoSecundario(matriz,n));
                }
            } else if(option == 0){
                continue;
            } else {
                System.out.println("Opción incorrecta. Intente nuevamente.");
            }

        }while (option != 0);

    }

    public static int SumaTotal(int [][] mat, int n, int m, int i){

        if(n == 0 && m == 0){
            return mat[n][m];
        }
        else if(n == 0){
            return mat[n][m]+SumaTotal(mat,i,m-1,i);
        }
        else
            return mat[n][m]+SumaTotal(mat,n-1,m,i);
    }

    public static int ProductoTotal(int [][] mat, int n, int m, int i){

        if(n == 0 && m == 0){
            return mat[n][m];
        }
        else if(n == 0){
            return mat[n][m]*ProductoTotal(mat,i,m-1,i);
        }
        else
            return mat[n][m]*ProductoTotal(mat,n-1,m,i);
    }

    public static int SumaPrincipal(int [][] mat, int i){

        int res = 0;
        for (int j = 0; j < i; j++) {
            res += mat[j][j];
        }
        return res;
    }

    public static int ProductoPrincipal(int [][] mat, int i){

        int prod = 1;
        for (int j = 0; j < i; j++) {
            prod *= mat[j][j];
        }
        return prod;
    }

    public static int SumaSecundario(int [][] mat, int i) {
        
        int res = 0, k = i-1;
        for (int j = 0; j < i; j++) {
            res += mat[j][k-j];
        }
        return res;
    }

    public static int ProductoSecundario(int [][] mat, int i){

        int prod = 1, k = i-1;
        for (int j = 0; j < i; j++) {
            prod *= mat[j][k-j];
        }
        return prod;
    }

    public static void GenerarTabla(Scanner read){

        int number;

        do{
            System.out.println("Ingrese un número entre 2 y 9 (inclusive):");
            number = read.nextInt;
            if (number < 2 || number > 9){
                System.out.println("Número fuera de rango. Intente nuevamente.");
            }
            else {
                System.out.println("Tabla del "+number+":");
                for (int i = 1; i <= 10; i++) {
                    System.out.println(number+" x "+i+" = "+(number*i));
                }
            }
        }while (number < 2 || number > 9);
    }

    public static void Convertidor(Scanner read) { //dolar blue $232.00 - euro blue $249.00 - real blue $52.00

        int divisa, convertir;
        float cifra;

        System.out.println("Ingrese el tipo de divisa de entrada:");
        System.out.println("1- Pesos.");
        System.out.println("2- Dolar.");
        System.out.println("3- Euro.");
        System.out.println("4- Real.");
        divisa = read.nextInt;
        while (divisa > 4 || divisa < 1){
            System.out.println("Código inválido. Intente nuevamente.");
            System.out.println("Ingrese el tipo de divisa de entrada:");
            System.out.println("1- Pesos.");
            System.out.println("2- Dolar.");
            System.out.println("3- Euro.");
            System.out.println("4- Real.");
            divisa = read.nextInt;
        }
        System.out.println("Ingrese el tipo de divisa de salida:");
        System.out.println("1- Pesos.");
        System.out.println("2- Dolar.");
        System.out.println("3- Euro.");
        System.out.println("4- Real.");
        convertir = read.nextInt;
        while (convertir>4 || convertir<1 || divisa == convertir){
            System.out.println("Código inválido. Intente nuevamente.");
            System.out.println("Ingrese el tipo de divisa de salida:");
            System.out.println("1- Pesos.");
            System.out.println("2- Dolar.");
            System.out.println("3- Euro.");
            System.out.println("4- Real.");
            convertir = read.nextInt;
        }
        System.out.println("Cifra que desea convertir:");
        cifra = read.nextFloat;
        while (cifra < 0){
            System.out.println("Valor incorrecto. Vuelva a ingresar por favor.");
            System.out.println("Cifra que desea convertir:");
            cifra = read.nextFloat;
        }
        if(divisa == 1){
            if(convertir == 2){
                System.out.println("El valor de "+cifra+" pesos es igual a "+(Math.round((cifra/232.0)*100.0)/100.0)+" dólares."); //valor del dolar al momento
            } else if (convertir == 3) {
                System.out.println("El valor de "+cifra+" pesos es igual a "+(Math.round((cifra/249.0)*100.0)/100.0)+" euros."); //valor del euro al momento
            } else {
                System.out.println("El valor de "+cifra+" pesos es igual a "+(Math.round((cifra/52.0)*100.0)/100.0)+" reales."); //valor del real al momento
            }
        } else if (divisa == 2) {
            if (convertir == 1){
                System.out.println("El valor de "+cifra+" dólares es igual a "+(Math.round((cifra*232.0)*100.0)/100.0)+" pesos.");
            } else if (convertir == 3) {
                System.out.println("El valor de "+cifra+" dólares es igual a "+(Math.round((cifra*232.0/249.0)*100.0)/100.0)+" euros.");
            } else{
                System.out.println("El valor de "+cifra+" dólares es igual a "+(Math.round((cifra*232.0/52.0)*100.0)/100.0)+" reales.");
            }
        } else if (divisa == 3) {
            if (convertir == 1){
                System.out.println("EL valor de "+cifra+" euros es igual a "+(Math.round((cifra*249.0)*100.0)/100.0)+" pesos.");
            } else if (convertir == 2) {
                System.out.println("EL valor de "+cifra+" euros es igual a "+(Math.round((cifra*249.0/232.0)*100.0)/100.0)+" dólares.");
            } else {
                System.out.println("EL valor de "+cifra+" euros es igual a "+(Math.round((cifra*249.0/52.0)*100.0)/100.0)+" reales.");
            }
        } else {
            if (convertir == 1){
                System.out.println("EL valor de "+cifra+" reales es igual a "+(Math.round((cifra*52.0)*100.0)/100.0)+" pesos.");
            } else if (convertir == 2) {
                System.out.println("EL valor de "+cifra+" reales es igual a "+(Math.round((cifra*52.0/232.0)*100.0)/100.0)+" dólares.");
            } else {
                System.out.println("EL valor de "+cifra+" reales es igual a "+(Math.round((cifra*52.0/249.0)*100.0)/100.0)+" euros.");
            }
        }
    }

}