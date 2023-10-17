package aed;

import java.util.Scanner;
import java.io.PrintStream;

class Archivos {
    float[] leerVector(Scanner entrada, int largo) {
        float[] vector = new float[largo];
        float valor;

        for (int i = 0; i < vector.length; i++) {
            valor = entrada.nextFloat();
            vector[i] = valor;
        }

        return vector;
    }


    float[][] leerMatriz(Scanner entrada, int filas, int columnas) {
        float[][] matriz = new float[filas][columnas];
        float[] v = new float[columnas];

        for (int i = 0; i < filas; i++) {
            v = leerVector(entrada, columnas);
            matriz[i] = v;
        }

        return matriz;
    }
    // -- implementación un poquito más ineficiente (pero funcional)
    
    // float[][] leerMatriz(Scanner entrada, int filas, int columnas) {
    //     float[][] matriz = new float[filas][columnas];
    //     float valor;

    //     for (int i = 0; i < filas; i++) {
    //         for (int j = 0; j < columnas; j++) {
    //             valor = entrada.nextFloat();
    //             matriz[i][j] = valor; 
    //         }
    //     }

    //     return matriz;
    // }



    void imprimirPiramide(PrintStream salida, int alto) {
        int k= 2*alto - 1;//cantidad de caracteres por linea
        for(int i=0;i<alto;i++){
            String linea="";//inicio una linea vacia
            String espacios="";
            for(int j=0;j<alto-1-i;j++){//calcula cuantos espacios van al principio
                espacios=espacios+" ";
            }
            linea=linea+espacios;
            for(int j=0;j<k-2*(alto-1-i);j++){//caldula cuantos asteriscos van en el piso
                linea=linea+"*";
            }
            linea=linea+espacios;//agrego los espacios al final
            salida.println(linea);
        }
        salida.close();//cierro archivo
    }
}
