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
        Nodo tmp = root;
        while(tmp.hijoIzquierdo != null){
            tmp = tmp.hijoIzquierdo;
        }
        return tmp.data;
    }

    public T maximo(){
        Nodo tmp = root;
        while(tmp.hijoDerecho != null){
            tmp = tmp.hijoDerecho;
        }
        return tmp.data;
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem);
        Nodo actual = root;
        int i = 0;
        if (!this.pertenece(elem)){
            while (i < longitud){
                if (actual.data.compareTo(elem) < 0 && actual.hijoDerecho != null){
                    actual = actual.hijoDerecho;
                } else if (actual.data.compareTo(elem) > 0 && actual.hijoIzquierdo != null) {
                    actual = actual.hijoIzquierdo;
                }
                i ++;
            }

            if (longitud == 0){
                root = new Nodo(elem);
            } else if (actual.data.compareTo(elem) < 0){
                actual.hijoDerecho = nuevo;
                nuevo.padre = actual;
            }else if (actual.data.compareTo(elem) > 0){
                actual.hijoIzquierdo = nuevo;
                nuevo.padre = actual;
            }
            longitud ++;
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = root;
        boolean res = false;
        int i = 0;
        while (i < longitud){
            if (actual.data.compareTo(elem) == 0){
                res = true;
            } else if (actual.data.compareTo(elem) > 0 && actual.hijoIzquierdo != null){
                actual = actual.hijoIzquierdo;
            } else if (actual.hijoDerecho != null) {
                actual = actual.hijoDerecho;
            }
            i ++;
        }
        return res;
    }
    public void eliminar(T elem){
        Nodo actual = root;
        if (this.pertenece(elem)){
            while (actual.data.compareTo(elem) != 0){
                if (actual.data.compareTo(elem) > 0){
                    actual = actual.hijoIzquierdo;
                } else {
                    actual = actual.hijoDerecho;
                }
            }

            // Caso 1
            if ( actual.hijoIzquierdo == null && actual.hijoDerecho == null){
                if (actual.padre == null){
                    root.data = null;
                } else {
                    if (actual.padre.data.compareTo(elem) > 0){
                        actual.padre.hijoIzquierdo = null;
                    } else {
                        actual.padre.hijoDerecho = null;
                    }
                }

                //Caso 2 :
            } else if (actual.hijoIzquierdo == null && actual.hijoDerecho != null){
                if (actual.padre == null){
                    actual.hijoDerecho.padre = null;
                    root = actual.hijoDerecho;//
                } else if (actual.padre.data.compareTo(elem) > 0){
                    actual.padre.hijoIzquierdo = actual.hijoDerecho;
                    actual.hijoDerecho.padre = actual.padre;
                } else {
                    actual.padre.hijoDerecho = actual.hijoDerecho;
                    actual.hijoDerecho.padre = actual.padre;
                }

                //Caso 2
            } else if (actual.hijoIzquierdo != null && actual.hijoDerecho == null){
                if (actual.padre == null){
                    actual.hijoIzquierdo.padre = null;
                    root = actual.hijoIzquierdo;//
                } else if (actual.padre.data.compareTo(elem) > 0){
                    actual.padre.hijoIzquierdo = actual.hijoIzquierdo;
                    actual.hijoIzquierdo.padre = actual.padre;
                } else {
                    actual.padre.hijoDerecho = actual.hijoIzquierdo;
                    actual.hijoIzquierdo.padre = actual.padre;
                }

                //Caso en que tiene ambas descendencias
            } else {

                Nodo min = minimoDelSubABB(actual.hijoDerecho);

                eliminar(min.data);
                longitud ++;

                //asignar
                if (actual.padre == null){
                    min.padre = null;
                    root = min;//
                } else if (actual.padre.data.compareTo(elem) > 0){
                    actual.padre.hijoIzquierdo = min;
                    min.padre = actual.padre;
                } else {
                    actual.padre.hijoDerecho = min;
                    min.padre = actual.padre;
                }

                //asignar
                actual.hijoIzquierdo.padre = min;
                min.hijoIzquierdo = actual.hijoIzquierdo;

                if (actual.hijoDerecho != null){
                    actual.hijoDerecho.padre = min;
                    min.hijoDerecho = actual.hijoDerecho;
                }

            }
            longitud --;
        }
    }

    public Nodo minimoDelSubABB(Nodo actual){
        while(actual.hijoIzquierdo != null){
            actual = actual.hijoIzquierdo;
        }
        return actual;

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
        // toStringRecursivo arbol || toStringRecursivo(arbol.hijoIzquierdo) ++ [data] ++ toStringRecursivo(arbol.hijoDerecho)
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        ABB_Iterador(){
            _actual = null;
        }

        public boolean haySiguiente() {
            return maximo() != _actual ;
        }

        public T siguiente() {
            Nodo siguiente = null;
            if (_actual == null){
                siguiente = minimoDelSubABB(root);
            } else if (haySiguiente()){
                if (_actual.hijoDerecho != null){
                    siguiente = minimoDelSubABB(_actual.hijoDerecho);
                } else {
                    siguiente = _actual.padre;
                    while(siguiente.data.compareTo(_actual.data) < 0){
                        siguiente = siguiente.padre;
                    }
                }
            }
            _actual = siguiente;

            return siguiente.data;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}