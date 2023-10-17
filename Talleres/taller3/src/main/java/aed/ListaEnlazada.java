package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private class Nodo {
        Nodo siguiente;
        Nodo anterior;
        T data;
        Nodo(T d) { data = d;}

    }

    private Nodo primero;

    private Nodo ultimo;

    // Devuelve el ultimo nodo de una lista enlazada
    private Nodo ultimoNodo(){
        Nodo nodoActual = primero;

        while (nodoActual.siguiente != null){
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual;
    }

    // Devuelve el i-esimo nodo de la lista enlazada
    private Nodo obtenerNodo(int i) {
        Nodo nodoActual = primero;
        int j;
        j = 0;

        while(j != i){
            nodoActual = nodoActual.siguiente;
            j += 1;
        }

        return nodoActual;
    }


    //Constructor listaEnlazada
    public ListaEnlazada() {
        primero = null;

        ultimo = null;
    }



    // funciones de mi clase
    public int longitud() {
        int res;
        res = 0;
        Nodo nodoActual = primero;

        while(nodoActual != null){
            res += 1;
            nodoActual = nodoActual.siguiente;
        }

        return res;
    }

    public void agregarAdelante(T elem) {
        Nodo insertar = new Nodo(elem);

        if (primero == null && ultimo == null){
            primero = insertar;
            return;
        }

        insertar.siguiente = primero;
        primero = insertar;

    }

    public void agregarAtras(T elem) {
        Nodo insertar = new Nodo(elem);

        if (primero == null){
            primero = insertar;
            return;
        }

        Nodo ultimo = ultimoNodo();
        ultimo.siguiente = insertar;
    }

    public T obtener(int i) {
        Nodo nodoActual = primero;
        int j;
        j = 0;

        while(j != i){
            nodoActual = nodoActual.siguiente;
            j += 1;
        }

        return nodoActual.data;
    }

    public void eliminar(int indice) {
        if (indice == 0) {
            primero = primero.siguiente;
        } else {
            Nodo antes = obtenerNodo(indice - 1);
            if (antes != null && antes.siguiente != null) {
                antes.siguiente = antes.siguiente.siguiente;
            }
        }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo insertar = new Nodo(elem);

        if (indice == 0) {
            if (primero != null) {
                insertar.siguiente = primero.siguiente;
                insertar.siguiente.anterior = insertar;
                primero = insertar;
            } else {
                // If the list is empty, simply add the new node as the first node
                primero = insertar;
            }
        } else {
            Nodo nodoAnterior = obtenerNodo(indice - 1);
            if (nodoAnterior != null && nodoAnterior.siguiente != null) {
                insertar.siguiente = nodoAnterior.siguiente.siguiente;
                if (insertar.siguiente != null) {
                    insertar.siguiente.anterior = insertar;
                }
                nodoAnterior.siguiente = insertar;
                insertar.anterior = nodoAnterior;
            }
        }
    }


    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> res = new ListaEnlazada<>();
        Nodo actual = primero;
        int i = 0;

        while(i < this.longitud()) {
            res.agregarAtras(actual.data);
            actual = actual.siguiente;
            i++;
        }

        return res;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> res = new ListaEnlazada<>();

        primero = lista.primero;

        res.agregarAtras(primero.data);

    }


    @Override
    public String toString() {
        StringBuffer lista = new StringBuffer();
        Nodo actual = primero;
        int longitud = this.longitud();
        int i = 0;

        while(i < longitud){
            if (i == 0) {
                lista.append("[").append(actual.data).append(", ");
                actual = actual.siguiente;
            } else if (i == longitud - 1) {
                lista.append(actual.data).append("]");
            } else {
                lista.append(actual.data).append(", ");
                actual = actual.siguiente;
            }
            i++;
        }

        return lista.toString();
    }

    private class ListaIterador implements Iterador<T> {
        int puntero;
        ListaIterador(){
            puntero = 0;
        }
        public boolean haySiguiente() {
            return puntero < longitud();
        }

        public boolean hayAnterior() {
	        return puntero > 0;
        }

        public T siguiente() {
            T res;
            int i = puntero;
            if(haySiguiente()){
                puntero++;
            }
            res = obtener(i);
            return res;
        }


        public T anterior() {
            if(hayAnterior()){
                puntero--;
            }
            return obtener(puntero);
        }

    }

    public Iterador<T> iterador() {
        Iterador<T> iterator = new ListaIterador();
        return iterator;
    }


} // fin del codigo
