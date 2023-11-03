package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private int longitud;
    private class Nodo {
        T data;
        Nodo padre;
        Nodo hijoIzquierdo;
        Nodo hijoDerecho;

        // Constructor del objeto
        Nodo(T d) {
            data = d;
            hijoDerecho = null;
            hijoIzquierdo = null;
            padre = null;
        }
    }

    Nodo root;

    public ABB() {
        root = null;
        longitud = 0;
    }

    public int cardinal() {
        return longitud;
    }

    public T minimo(){
        while(root.hijoIzquierdo != null){
            root = root.hijoIzquierdo;
        }
        return root.data;
    }

    public T maximo(){
        while(root.hijoDerecho != null){
            root = root.hijoDerecho;
        }
        return root.data;
    }

    public void insertar(T elem){

        if(pertenece(elem)){
        } else {
            if (root == null){
                root = new Nodo(elem);
                longitud++;
            } else {
                insertarEnHijo(root, elem);
            }
        }
    }

    public void insertarEnHijo(Nodo arbol, T elem){
        // checkear caso elem igual a arbol.data;
        if(arbol.data.compareTo(elem) <= 0){
            if (arbol.hijoDerecho == null) {
                arbol.hijoDerecho = new Nodo(elem);
                this.longitud++;
            } else {
                insertarEnHijo(arbol.hijoDerecho, elem);
            }
        } else {
            if(arbol.hijoIzquierdo == null){
                arbol.hijoIzquierdo = new Nodo(elem);
                this.longitud++;
            } else {
                insertarEnHijo(arbol.hijoIzquierdo, elem);
            }
        }
    }

    public boolean pertenece(T elem){
        if(root == null){
            return false;
        } else {
            return perteneceRecursivo(elem, root);
        }
    }

    public boolean perteneceRecursivo(T elem, Nodo nodo){
        boolean res = false;

        if (nodo == null){
            return false;
        }

        if (nodo.data == elem){
            res = true;
        } else {
            res = perteneceRecursivo(elem, nodo.hijoIzquierdo) || perteneceRecursivo(elem, nodo.hijoDerecho);
        }

        return res;
    }


    public void eliminar(T elem){
        if (this.pertenece(elem)){
            searchAndDestroy(root, elem);
        }
    }

    private void searchAndDestroy(Nodo nodo, T elem) {
        // caso 1: elemento es null

        if (nodo == null){
        }
        //
        if (nodo.data == elem){
            // caso es hoja
            if(nodo.hijoIzquierdo == null && nodo.hijoDerecho == null){

                nodo = null;
            }
            // caso con un hijo

            if (nodo.hijoIzquierdo == null && nodo.hijoDerecho != null) {
                nodo.padre = nodo.hijoDerecho;
            } else if (nodo.hijoIzquierdo != null && nodo.hijoDerecho == null) {
                nodo.padre = nodo.hijoIzquierdo;
            }

            longitud--;
        } else {
            if (elem.compareTo(nodo.data) > 0){
                searchAndDestroy(nodo.hijoDerecho, elem);
            } else {
                searchAndDestroy(nodo.hijoIzquierdo, elem);
            }
        }


        // caso 2: elemento no tiene ningun hijo

    }

    @Override
    public String toString(){
        return "{" + toStringRecursivo(root) + "}";
    }

    private String toStringRecursivo(Nodo nodo){
        if (nodo == null){
            return "";
        } else {

            String arbolIzquierdo = toStringRecursivo(nodo.hijoIzquierdo);
            if (!arbolIzquierdo.equals("")) {
                arbolIzquierdo = arbolIzquierdo + ",";
            }

            String arbolDerecho = toStringRecursivo(nodo.hijoDerecho);
            if (!arbolDerecho.equals("")) {
                arbolDerecho = "," + arbolDerecho;
            }

            return (arbolIzquierdo + nodo.data.toString() + arbolDerecho);
        }


        // esta implementacion sigue la idea de haskell de la siguiente manera
        // toStringRecursivo [] | []
        // toStringRecursivo arbol || toStringRecursivo(arbol.izquierda) ++ [data] ++ toStringRecursivo(arbol.derecha)
    }


    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            while(iterador().haySiguiente()){
                T res = iterador().siguiente();
            }
            return this._actual.data;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
