import java.util.Scanner;
class main{
	public static void main(String[] args){
        int Random,tamanho,i,j;
        int resposta1,resposta2;
	    double startTime ,endTime,Tempo;
        boolean saida;
        saida = true;
        tamanho = 0;
        Scanner ler = new Scanner(System.in);
	    Matriz Mat;
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CALCULO DETERMINANTE=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("                             -MENU DE COMANDO-               \n\n");
        System.out.print("INFORME A ORDEM DA MATRIZ: ");
        tamanho = ler.nextInt();
        Mat = new Matriz(tamanho);
        

        System.out.println();
        System.out.println("                  -MATRIZ CRIADA! -                   ");
        System.out.println();
        System.out.println("PASSO 2:PREENCHER A  MATRIZ");
        System.out.println();
        System.out.println("->DIGITE 1:PREENCHER A MATRIZ COM UM UNICO VALOR");
        System.out.println("->DIGITE 2:PREENCHER A MATRIZ COM VALORES ALEATORIOS(0 A 20)");
        System.out.println("->DIGITE 3:PREENCHER A MATRIZ COM 0 ATE UM NUMERO INFORMADO");
        System.out.println("->DIGITE 4:PREENCHER A MATRIZ MANUALMENTE");
        saida = true;

        do{
            System.out.print("  ");
            resposta2 = ler.nextInt();
            if((resposta2 ==1)  || (resposta2 == 2) || (resposta2 == 3) || (resposta2 == 4)){
                saida = false;       
            }else{           
                System.out.println("   COMANDO INVALIDO");
                System.out.println("  Por favor,Digite novamente"); 
            }
        }while(saida);
       
        if(resposta2 == 1){
            System.out.print("  INFORME O VALOR:");
            Random = ler.nextInt();               
            Mat.iniciarComNumero(Random);
        }
        if(resposta2 == 2){
            Mat.iniciaRandom();
        }
        if(resposta2 ==3){
            System.out.print(" INFORME O NUMERO:");
            Random = ler.nextInt();
            Mat.iniciaRandom(Random);
        }
        if(resposta2 ==4){
            for(i=0;i<Mat.getnumLinhas();i++){
                for(j = 0;j<Mat.getnumColunas();j++){
                    int elem = ler.nextInt();
                    Mat.setElemento(i,j,elem);
                }
            }
            //Mat.IniciarManualmente();
        }

        System.out.println();
        System.out.println("MATRIZ");
	    System.out.println();
        Mat.imprime();
	    System.out.println();
        System.out.println("PASSO 3:CALCULO DA DETERMINANTE DA  MATRIZ");
        System.out.println();
        System.out.println("->DIGITE 1:CALCULAR COM ALGORITIMO BASICO");
        System.out.println("->DIGITE 2:CALCULAR COM ALGORITIMO COM OTIMIZACAO BASICA");
        System.out.println("->DIGITE 3:CALCULAR COM ALGORITIMO COM OTIMIZACAO EXTRA(TEOREMA DE CHIÓ)");
        System.out.println("->DIGITE 4:CALCULAR COM OS TRES ALGORITIMOS EM SEQUENCIA");
        saida = true; 
        do{
            System.out.print("  ");
            resposta2 = ler.nextInt();
            if((resposta2 ==1)  || (resposta2 == 2) || (resposta2 == 3) || (resposta2 == 4)){
                saida = false;       
            }else{           
                System.out.println("   COMANDO INVALIDO");
                System.out.println("  Por favor,Digite novamente"); 
            }
        }while(saida);
       
        if((resposta2 == 1) || (resposta2 == 4)){
            if(Mat.retorneOrdem() == -1){
              System.out.println("Matriz nao eh quadrada!! retornando 0");
            }else{            
            Matriz Mat1 = new Matriz(Mat.retorneOrdem());            
            Mat1.iniciaPelaMatriz(Mat);            
            
            System.out.println("==============================================================================");  
            System.out.println("                         ALGORITMO BASICO                                    ");
            System.out.println("==============================================================================");  
            System.out.println("Calculando Determinante...");
            System.out.println();
            if((Mat.retorneOrdem() == 13) || (Mat.retorneOrdem() == 15)){
                System.out.println("|LEMBRE-SE:A paciencia eh a arte de esperar|");
                System.out.println();
             }
        	    
            System.out.print("RESULTADO DO DETERMINANTE: ");
	        startTime = System.nanoTime();
	        System.out.println(Mat1.determinante(1));
	        endTime = System.nanoTime();
	        Tempo = endTime - startTime;
            System.out.print("TEMPO DE EXECUCAO DO ALGORITMO BASICO: ");
            System.out.printf("%.1f\n",Tempo);
            }  
        }
      
        
        if((resposta2 == 2) || (resposta2 == 4)){
            if(Mat.retorneOrdem() == -1){
              System.out.println("Matriz nao eh quadrada!! retornando 0");
            }else{
               
            Matriz Mat2 = new Matriz(Mat.retorneOrdem());            
            Mat2.iniciaPelaMatriz(Mat);
            System.out.println("=============================================================================="); 
	        System.out.println("                      ALGORITMO OTIMIZADO                                 ");          
            System.out.println("==============================================================================");  
            System.out.println("Calculando Determinante...");
            System.out.println();
            if((Mat.retorneOrdem() == 13) || (Mat.retorneOrdem() == 15)){
                System.out.println("|LEMBRE-SE:A paciencia eh a arte de esperar|");
                System.out.println();
            }
            System.out.println();            
            System.out.print("RESULTADO DO DETERMINANTE: ");
	        startTime = System.nanoTime();
	        System.out.println(Mat2.determinante(2));
	        endTime = System.nanoTime();
	        Tempo = endTime - startTime;
            System.out.print("TEMPO DE EXECUÇÃO DO ALGORITMO OTIMIZADO: ");       
            System.out.printf("%.1f\n",Tempo);
            }
        }
        
        if((resposta2 == 3) || (resposta2 == 4)){        
           if(Mat.retorneOrdem() == -1){
              System.out.println("Matriz nao eh quadrada!! retornando 0");
            }else{
            Matriz Mat3 = new Matriz(Mat.retorneOrdem());            
            Mat3.iniciaPelaMatriz(Mat);
            System.out.println("=============================================================================="); 
            System.out.println("                  ALGORITMO EXTRA OTIMIZADO                               ");   
             System.out.println("=============================================================================="); 
            if(Mat.retorneOrdem() == 15){
                System.out.println("|LEMBRE-SE:A paciencia eh a arte de esperar|");
                System.out.println();
            }	    
            System.out.println();            
            System.out.print("RESULTADO DO DETERMINANTE: ");
            startTime = System.nanoTime();
	        System.out.println(Mat3.determinante(3));
	        endTime = System.nanoTime();
	        Tempo = endTime - startTime;
	        System.out.print("TEMPO DE EXECUCAO DO ALGORITMO EXTRA OTIMIZADO(TEOREMA DE CHIO): ");       
            System.out.printf("%.1f\n",Tempo);
            System.out.println("=============================================================================="); 
            } 
        }      	
    }
}

