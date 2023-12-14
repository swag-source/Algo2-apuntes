package aed;

public class InternetToolkit {

    public InternetToolkit() {
    }

    // Ejercicio 1
    public Fragment[] tcpReorder(Fragment[] fragments) {
        // vamos a implementar insertion sort

        for (int i = 1 ; i < fragments.length ; i++){
            Fragment actual = fragments[i];
            int j = i - 1;

            while (j >= 0 && (fragments[j].compareTo(actual) > 0)){
                fragments[j + 1] = fragments[j];
                fragments[j] = actual;
                j--;
            }
        }

        return fragments;
    }

    // Ejercicio 2
    public int cumplen(Router[] r, int umbral){
        int res = 0;
        for(int i = 0; i < r.length; i++){
            if (r[i].getTrafico() > umbral){
                res++;
            }
        }
        return res;
    }

    public Router[] kTopRouters(Router[] routers, int k, int umbral){
        int pasan_umbral = cumplen(routers, umbral);
        Heap heap = new Heap(routers);
        Router[] res = new Router[Math.min(k, pasan_umbral)];

        for(int j = 0; j < res.length; j++){
            Router max = heap.maximo();
            heap.descencolar();
            if (max.getTrafico() > umbral) {
                res[j] = max;
            } else {
                j--;
            }
        }
        return res;
    }

    public IPv4Address[] sortIPv4(String[] ipv4) {
        IPv4Address[] IPv4 = new IPv4Address[ipv4.length];
        // inserto mis string IP's a IPv4Address
        for (int i = 0; i < IPv4.length; i++) {
            IPv4[i] = new IPv4Address(ipv4[i]);
        }

        //Implemento mi estrategia de bubblesort -> O(n²)
        for (int i = 0; i < IPv4.length - 1; i++) {
            for (int j = 0; j < IPv4.length - i - 1; j++) {
                IPv4Address dir1 = IPv4[j];
                IPv4Address dir2 = IPv4[j+1];

                int octeto = 0;
                while(octeto < 4){
                    int num_a = dir1.getOctet(octeto);
                    int num_b = dir2.getOctet(octeto);

                    if(num_a < num_b){
                        octeto = 4;
                    } else if (num_a > num_b) {
                        IPv4[j] = IPv4[j+1];
                        IPv4[j+1] = dir1;
                        octeto = 4;
                    } else {
                        octeto++;
                    }
                }
            }
        }
        return IPv4;
    }

    // Auxiliares ejercicio 1)



    // auxiliares ejercicio 2)

}

