package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        double res;
        res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        return res;

    }

    boolean esPar(int n) {
        if(n % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    boolean esBisiesto(int n) {
        if(n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
            return true;
        } else {
            return false;   
        }
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n ; i++) {
            res *= i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if(n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecursivo(n-1);
        }
    }

    boolean esPrimo(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    int sumatoria(int[] numeros) {
        int res, i;
        res = 0;
        i = 0;

        while (i < numeros.length) {
            res += numeros[i];
            i++;
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res;
        res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == buscado){
                return i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res;
        res = false;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                res = true;
                return res;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res;
        res = true;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                return false;
            } 
        }
        return res;

    }

    boolean esPrefijo(String s1, String s2) {
        boolean res;
        res = false;

        if (s1.length() <= s2.length() && s2.startsWith(s1)) {
            res = true;
        } 

        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res;
        res = false;

        if(s1.length() <= s2.length() && s2.endsWith(s1) ){
            res = true;
        }

        return res;
    }
}
