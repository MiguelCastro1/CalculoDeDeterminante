import java.util.Random;
import java.util.Scanner;

//Implementacao do Sarrus e otimizacao pela  
//linha ou coluna que cotenha mais zeros
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

    private int detOrdem3(Matriz Mat){// Sarrus
        long DiP, DiS, Det;
		
        DiP = Mat.getElemento(0, 0) * Mat.getElemento(1, 1) * Mat.getElemento(2, 2);
        DiP = DiP + (Mat.getElemento(0, 1) * Mat.getElemento(1, 2) * Mat.getElemento(2, 0)); 		
        DiP = DiP + (Mat.getElemento(0, 2) * Mat.getElemento(1, 0) * Mat.getElemento(2, 1));
        
        DiS = Mat.getElemento(2, 0) * Mat.getElemento(1, 1) * Mat.getElemento(0, 2); 
        DiS = DiS + (Mat.getElemento(2, 1) * Mat.getElemento(1, 2) * Mat.getElemento(0, 0));
        DiS = DiS + (Mat.getElemento(2, 2) * Mat.getElemento(1, 0) * Mat.getElemento(0, 1));
            
	    Det = (DiP - DiS);
	    return (int) Det;
	
	}
    private int calculaSinal(int indiceL, int indiceC) {
        int sinal;

        sinal = -1;

        if (((indiceL + indiceC) % 2) == 0) {
            sinal = 1;
        }

        return sinal;
    }

    public void copiaMatrizMaiorParaMenor(Matriz maior, Matriz menor, int isqn, int jsqn) {
        int contAi, contAj, contBi, contBj, temp, numL, numC;
        numL = menor.getnumLinhas();
        numC = menor.getnumColunas();

        contAi = 0;
        for (contBi = 0; contBi < numL; contBi++) {
            if (contAi == isqn) {
                contAi++;
            }
            contAj = 0;
            for (contBj = 0; contBj < numC; contBj++) {
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

    private int ColunaMaisZeros(Matriz Mat){
        int numC, numL, i, j, totZeros, MaisZeros, ColZeros, Mais;
        
        ColZeros = 0;
        totZeros = 0;
        MaisZeros = 0;

        for (i = 0; i < Mat.Linhas; i++) {
            totZeros = 0;
            for (j = 0; j < Mat.Colunas; j++) {
                if (Mat.getElemento(j, i) == 0) {
                    totZeros++;
                }
            }
            if (totZeros > MaisZeros) {
                MaisZeros = totZeros;
                ColZeros = i;
            }
        }

        return MaisZeros;
    }

    private int LinhaMaisZeros(Matriz Mat) {
        int numC, numL, i, j, totZeros, MaisZeros, LinZeros;
        LinZeros = 0;
        totZeros = 0;
        MaisZeros = 0;

        for (i = 0; i < Mat.Linhas; i++) {
            totZeros = 0;
            for (j = 0; j < Mat.Colunas; j++) {
                if (Mat.getElemento(i, j) == 0) {
                    totZeros++;
                }
            }
            if (totZeros > MaisZeros) {
                MaisZeros = totZeros;
                LinZeros = i;
            }
        }
      return MaisZeros;
    }
    
    private boolean LinhaNula(Matriz mat){
    	int i, j, num;
    	boolean Nula;

    	for(i=0; i<mat.Linhas; i++){
            Nula = true;
    		for(j=0; j<mat.Colunas; j++){    			
    			num = mat.getElemento(i, j);
    			if(num == 0){
    				continue;
    			}else{
    				Nula = false;
    				break;
    			}   							
    		}
            if(Nula) return true;
    	}
   		Nula = mat.LinhaProporcional(mat);
   		//System.out.println();
   		//System.out.println("LinhaNula: ");
   		//System.out.println(Nula);
   		return Nula;
    }

	 private boolean ColunaNula(Matriz mat){
    	int i, j,  num;
    	boolean Nula;

    	for(i=0; i<mat.Linhas; i++){
            Nula = true;
    		for(j=0; j<mat.Colunas; j++){
    			num = mat.getElemento(j, i);
    			if(num == 0){
    				continue;
    			}else{
    				Nula = false;
    				break;
    			}   							
    		}
            if(Nula) return true;
    	}

   		Nula = mat.ColunaProporcional(mat);
   		//System.out.println();
   		//System.out.println("ColunaNula: ");
   		//System.out.println(Nula);
   		return Nula;
    }
    
   	private boolean LinhaProporcional(Matriz mat){
   		int i, j, numL, numC, num1, num2, resto;
    	boolean Nula;

   		for(i=0; i<mat.Linhas-1; i++){
            Nula = true;
   			for(j=0; j<mat.Colunas; j++){
   				num1 = mat.getElemento(i, j);
   				num2 = mat.getElemento((i+1), j);

   				if((num1 !=0) && (num2 !=0)){
   					if((num1 % num2) == 0){
   						continue;
   					}else{
   						Nula = false;
   						break;
   					}  					
   				}else{
   					if((num1== 0) && (num2 == 0)){
   						continue;
   					}else{
   						Nula = false;
   						break;
   					}	
   				}										
   			}
            if(Nula) return true;
   		}
   		//System.out.println();
   		//System.out.print("LinhaProporcional: ");
   		//System.out.println(Nula);
   		return false;
   	}
   	
   	private boolean ColunaProporcional(Matriz mat){
   		int i, j, num1, num2, resto;
    	boolean Nula = true;

   		for(i=0; i<mat.Linhas-1; i++){
            Nula = true;
   			for(j=0; j<mat.Colunas; j++){
   				num1 = mat.getElemento(j, i);
   				num2 = mat.getElemento(j, (i+1));

   				if((num1 !=0) && (num2 !=0)){
   					if((num1 % num2) == 0){
   						continue;
   					}else{
   						Nula = false;
   						break;
   					}
   				}else{
   					if((num1== 0) && (num2 == 0)){
   						continue;
   					}else{
   						Nula = false;
   						break;
   					}	
   				}										
   			}
            if(Nula) return true;
   		}
   		//System.out.println();
   		//System.out.print("ColunaProporcional: ");
   		//System.out.println(Nula);
   		return Nula;	
   	}
    
    
    private void MudaSinalLinha(Matriz mat, int Linha){
        int cont,  num;
        
        for(cont=0; cont<mat.Linhas; cont++){
            num = -1 * mat.getElemento(Linha, cont);
            mat.setElemento(Linha, cont, num);
        }   
    }

    private int TemUmLinha(Matriz Mat){
        int i, j, numC, numL;
        boolean TemUm = true;
     
        for (i = 0; i < Mat.Linhas; i++) {
            for (j = 0; j < Mat.Colunas; j++) {
                if(Mat.getElemento(i, j) == 1){
                   return i;
                }else{
                    if(Mat.getElemento(i, j) == -1){
                        Mat.MudaSinalLinha(Mat, i);
                        return i;
                    } 
                }
            }
        }
        return -1; // caso nao tenha 1;
    }
     
    // ve em que linha tem 1 e retorna a colunas
    private int UmNaColuna(Matriz Mat, int Linha){
       int contC, numC, numL;
        for (contC = 0; contC < Mat.Colunas; contC++) {
            if(Mat.getElemento(Linha, contC) == 1){
                 return contC;
            }
        }        
        return -1;
    }

    // troca pra por 1 no indice(0, 0)
    private boolean TrocaLinhasEColunas(Matriz mat, int Linha, int Coluna){
        int cont, aux,  num;
        boolean Sinal;

        if(Linha != 0){
            for (cont = 0; cont < mat.Linhas; cont++) {
                num = mat.getElemento(Linha, cont);
                aux = mat.getElemento(0,cont);
                mat.setElemento(0, cont, num);
                mat.setElemento(Linha, cont, aux);

            }
        }
        if(Coluna != 0){
            for (cont = 0; cont < mat.Linhas; cont++) {
                num = mat.getElemento(cont, Coluna);
                aux = mat.getElemento(cont, 0);
                mat.setElemento(cont, 0,  num);
                mat.setElemento(cont, Coluna, aux);
            }
        }

        if((Linha != 0) && (Coluna != 0)){
        	Sinal = false;
        }else{
        	Sinal = true;
        }
    	
    	//System.out.println();
    	//mat.imprime();
    	//System.out.println();
    	
    	return Sinal;
    }
    
    // copia para menor e faz o calculo dos elementos
    public void copiaMatrizMaiorParaMenorQuio(Matriz maior, Matriz menor){
        int i, j ,numL, numC;
        long produto, num;

        for (i = 0; i < menor.Linhas; i++) {
            for (j = 0; j < menor.Colunas; j++) {
                produto = maior.getElemento(i+1, 0) * maior.getElemento(0, j+1);
                num = (maior.getElemento(i+1, j+1) - produto);
                menor.setElemento(i, j, (int) num);
            }
        }
   		
   		//System.out.println();
    	//menor.imprime();
    	//System.out.println();
    }
    
    private long detOrdemN(Matriz mat) {
        int sinal, cofator,  contC,numC;
        int  LinMaisZeros, ColMaisZeros, TemUmLinha, UmColuna;
        long det, detTemp, resposta;
        boolean horizontal, Sinal;
        Matriz matmenor;

        resposta = 0;
        TemUmLinha = mat.TemUmLinha(mat);
        Sinal = false;
        
        if(mat.LinhaNula(mat)){
			resposta = 0;
			return resposta;
		}

		if(mat.ColunaNula(mat)){
			resposta = 0;
			return resposta;
		}
		
        //Se houver 1 na matriz - Quio
        if(TemUmLinha != -1){
            //System.out.println("TemUm");
            UmColuna = mat.UmNaColuna(mat, TemUmLinha);
            matmenor = new Matriz(mat.Linhas - 1, mat.Colunas - 1);

            //se o 1 nao estar no indice(0,0)
            if((TemUmLinha != 0) || (UmColuna != 0)){
               Sinal =  this.TrocaLinhasEColunas(mat, TemUmLinha, UmColuna) ;
            }
            
            this.copiaMatrizMaiorParaMenorQuio(mat, matmenor);
            det = matmenor.determinante();

            if(Sinal){
            	resposta = -1 * det; 
            }else{
            	resposta = det;            	
            }

            return resposta;
        }

        //caso Contrario
        //procura coluna ou linha com mais zeros
        ColMaisZeros = mat.ColunaMaisZeros(mat);
        LinMaisZeros = mat.LinhaMaisZeros(mat);
        horizontal = (ColMaisZeros > LinMaisZeros) ? false: true;
        
        for (contC = 0; contC < mat.getnumColunas(); contC++) {
            if (horizontal) {
                if (mat.getElemento(LinMaisZeros, contC) == 0) {
                    resposta = resposta + 0;
                    continue;
                }else{
                    cofator = mat.getElemento(LinMaisZeros , contC);
                    sinal = this.calculaSinal(LinMaisZeros , contC);
                }
            }else {
                if (mat.getElemento(contC, ColMaisZeros) == 0) {
                    resposta = resposta + 0;
                    continue;
                }else{
                    cofator = mat.getElemento(contC, ColMaisZeros);
                    sinal = this.calculaSinal(contC, ColMaisZeros);
                }
            }
           
            matmenor = new Matriz(mat.getnumLinhas() - 1,mat.getnumColunas() - 1);

            if(horizontal){
                this.copiaMatrizMaiorParaMenor(mat, matmenor, LinMaisZeros, contC);
            }else{
                this.copiaMatrizMaiorParaMenor(mat, matmenor, contC, ColMaisZeros);
            }

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
            case 3:
                det = this.detOrdem3(this);;
                break;
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

