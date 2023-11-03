package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

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
    }

    public int cardinal() {
        return cardinal_recursivo(root);
    }

    public int cardinal_recursivo(Nodo nodo){
        int _cardinalRecursivo = 0;

        if(nodo != null){
            _cardinalRecursivo++;
            _cardinalRecursivo += cardinal_recursivo(nodo.hijoDerecho) + cardinal_recursivo(nodo.hijoIzquierdo);
        }

        return _cardinalRecursivo;
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
        if (root == null){
            root = new Nodo(elem);
        } else {
            insertarEnHijo(root, elem);
        }
    }

    public void insertarEnHijo(Nodo arbol, T elem){

        if(arbol.data.compareTo(elem) <= 0){
            if (arbol.hijoDerecho == null) {
                arbol.hijoDerecho = new Nodo(elem);
            } else {
                insertarEnHijo(arbol.hijoDerecho, elem);
            }
        } else {
            if(arbol.hijoIzquierdo == null){
                arbol.hijoIzquierdo = new Nodo(elem);
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
        eliminarRecursivo(root, elem);
    }

    private void eliminarRecursivo(Nodo nodo, T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString(){
        return toStringRecursivo(this.root);
    }

    private String toStringRecursivo(Nodo nodo){
        throw new UnsupportedOperationException("Falta implementar");
    }



    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
