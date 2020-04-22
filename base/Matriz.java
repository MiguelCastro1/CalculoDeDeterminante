//package CALCULODEDETERMINANTE;
import java.util.Random;
import java.util.Scanner;
class Matriz {

    private int [][] Matriz;
    private int Colunas;
    private int Linhas;

    Matriz(int ordem) {
        this.Matriz = new int[ordem][ordem];
        this.Colunas = ordem;
        this.Linhas = ordem;
    }

    Matriz(int Linhas, int Colunas) {
        this.Matriz = new int[ Linhas][Colunas];
        this.Colunas = Colunas;
        this.Linhas = Linhas;
    }

    public int getnumColunas(){
        return this.Colunas;
    }

    public int getnumLinhas(){
        return this.Linhas;
    }
    public void setElemento(int I, int J, int V) {
        this.Matriz[I][J] = V;
    }

    public int getElemento(int I, int J) {
        return this.Matriz[I][J];
    }

    //inicia a matriz com numeros aleatoria entre 0 e parametro
    public void iniciaRandom(int Num) {
        int i, j, num;
        Random aleatorio = new Random();
        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                num = aleatorio.nextInt(Num+1);
                this.setElemento(i, j, num);
            }
        }
    }

    //inicia a matriz com numeros aleatoria entre 0 e 21
    public void iniciaRandom() {
        int i, j, num;

        Random aleatorio = new Random();

        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                num = aleatorio.nextInt(21);
                this.setElemento(i, j, num);
            }
        }
    }

    //inicia a matriz com numero do parametro
    public void iniciarComNumero(int Valor) {
        int i, j;

        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                this.setElemento(i, j, Valor);
            }
        }
    }

    //inicia Matriz a parti de uma matriz passada como parametro
    public void iniciaPelaMatriz(Matriz MatA) {
        int i, j, num;
        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                num = MatA.getElemento(i, j);
                this.setElemento(i, j, num);
            }
        }
    }

    public void copiaParaMatriz(Matriz MatA) {
        int i, j, num;

        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                num = this.getElemento(i, j);
                MatA.setElemento(i, j, num);
            }
        }
    }

    public void imprime() {
        int i, j, Linhas, C;

        for (i = 0; i < this.Linhas; i++) {
            for (j = 0; j < this.Colunas; j++) {
                System.out.print(this.getElemento(i, j)+" ");
            }
            System.out.println();
        }
    }

    public int retorneOrdem() {
        int numL, numC, ordem;

        numL = this.getnumLinhas();
        numC = this.getnumColunas();
        ordem = -1;
        if (numL == numC) {
            ordem = numL;
        }
        return ordem;
    }

    private int detOrdem1(Matriz mat) {
        return mat.getElemento(0, 0);
    }

    private int detOrdem2(Matriz mat) {
        int diagonalP, diagonalI;

        diagonalP = mat.getElemento(0, 0) * mat.getElemento(1, 1);
        diagonalI = mat.getElemento(1, 0) * mat.getElemento(0, 1);

        return (diagonalP - diagonalI);
    }

    private int calculaSinal(int indiceL, int indiceC) {
        int sinal = -1;

        if (((indiceL + indiceC) % 2) == 0) {
            sinal = 1;
        }
        return sinal;
    }

    public void copiaMatrizMaiorParaMenor(Matriz maior, Matriz menor, int isqn, int jsqn) {
        int contAi, contAj, contBi, contBj, temp, numL, numC;

        contAi = 0;
        for (contBi = 0; contBi < menor.Linhas; contBi++) {
            if (contAi == isqn) {
                contAi++;
            }
            contAj = 0;
            for (contBj = 0; contBj < menor.Colunas; contBj++) {
                if (contAj == jsqn) {
                    contAj++;
                }

                temp = maior.getElemento(contAi, contAj);
                menor.setElemento(contBi, contBj, temp);
                contAj++;
            }
            contAi++;
        }
    }

    
    private long detOrdemN(Matriz mat) {
        int sinal, cofator, contC;
        long det, detTemp, resposta;
        Matriz matmenor;

        resposta = 0;
        for (contC = 0; contC < mat.getnumColunas(); contC++) {
            if (mat.getElemento(0, contC) == 0) {
                resposta = resposta + 0;
                continue;
            }else{
                cofator = mat.getElemento(0, contC);
                sinal = this.calculaSinal(0, contC);
            }
           
            matmenor = new Matriz(mat.getnumLinhas() - 1, mat.getnumLinhas() - 1);
            this.copiaMatrizMaiorParaMenor(mat, matmenor, 0, contC);
            detTemp = matmenor.determinante();
            resposta = resposta + (cofator * sinal * detTemp);
        }
        return (resposta);
    }

    public long determinante() {
        int ordem;
        long det;

        ordem = this.retorneOrdem();
        det = 0;

        if (ordem > 0) {
            switch (ordem) {
            case 1:
                det = this.detOrdem1(this);
                break;
            case 2:
                det = this.detOrdem2(this);;
                break;
            //case 3:
               // det = this.detOrdem3(this);;
               // break;
            default:
                det = this.detOrdemN(this);;
                break;
            }

        } else {
            System.out.println("Matriz nao eh quadrada!! retornando 0");
        }

        return det;
    }

}

