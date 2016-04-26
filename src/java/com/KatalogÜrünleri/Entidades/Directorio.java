package com.KatalogÜrünleri.Entidades;

public class Directorio {

    private int vdir[];
    int ndir;
    int N;

    public Directorio(int N) {
        this.N = N;
        vdir = new int[N];
    }

    public int pedirDireccion() {
        int n;
        do {
            n = (int) (Math.random() * 100);
        } while (dirUtilizada(n) == true);
        vdir[ndir++] = n;
        return n;
    }

    public boolean dirUtilizada(int x) {
        boolean respuesta = false;
        int i = 0;
        while (i < ndir && respuesta == false) {
            if (vdir[ i] == x) {
                respuesta = true;
            }
            i = i + 1;
        }
        return respuesta;
    }

}
