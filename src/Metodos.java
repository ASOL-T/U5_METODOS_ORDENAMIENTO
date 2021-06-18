/*
EQUIPO: TEJUINOS
MIEMBROS:
FERNANDO PAUL JALOMO LUNA
ALAN SAMUEL ORTEGA LOPEZ
*/
import java.util.Random;

public class Metodos {

    int[] arreglo1;
    int[] arreglo2;

    public int[] crearArreglo(int tamaño) {
        Random aleatorio = new Random();
        aleatorio.setSeed(System.currentTimeMillis());
        arreglo1 = new int[tamaño];

        for (int i = 0; i < arreglo1.length; i++) {
            arreglo1[i] = aleatorio.nextInt(1000);
        }
        return arreglo1;
    }

    public int[] getArreglo() {
        return arreglo1;
    }

    public int[] getArregloOrdenado() {
        return arreglo2;
    }

    public int[] CopiaArreglo() {
        arreglo2 = arreglo1;
        return arreglo2;
    }

    public int getArreglo(int v) {
        return arreglo1[v];
    }

    public int getArregloOrdenado(int v) {
        return arreglo2[v];
    }

    public int[] Burbuja(int[] n) {
        int temp;
        int t = n.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (n[k] < n[k - 1]) {
                    temp = n[k];
                    n[k] = n[k - 1];
                    n[k - 1] = temp;
                }//fin if
            }// fin 2 for
        }//fin 1 for
        return n;
    }

    public void quickSort(int[] array, int i, int j) {
        int pivote = array[i];
        int inicio = i;
        int fin = j;

        do {

            while (array[i] < pivote) {
                i++;
            }

            while (array[j] > pivote) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

        } while (i <= j);
        if (inicio < j) {
            quickSort(array, inicio, j);
        }

        if (i < fin) {
            quickSort(array, i, fin);
        }
    }

    public void shellSort(int array[], int n) {
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
        }
    }
    
    public void radixSort(int[] arr){
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;
        for(k=0;k<4;k++){
            for(i=0;i<(np.length-1);i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i=0;i<q.length;i++)
                q[i] = -1;
            for(f=i=0;i<arr.length;i++){
                j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
                if(q[j] == -1)
                    l = q[j] = f;
                else{
                    l = q[j];
                    while(np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for(l=q[i=j=0];i<0x100;i++)
                for(l=q[i];l!=-1;l=np[l][1])
                        arr[j++] = np[l][0];
        }
    }
}
