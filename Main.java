import java.util.Scanner;
class Main{
	public static void main(String[] args){
        int Random,tamanho,i,j;
        int resposta1,resposta2;
	    double startTime ,endTime,Tempo;
        boolean saida;
        saida = true;
        tamanho = 0;
        Scanner ler = new Scanner(System.in);
	    Matriz Mat;
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CÁLCULO DETERMINANTE=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("                             -MENU DE COMANDO-                ");
        System.out.println();        
        System.out.println("PASSO 1:DETERMINE O TAMANHO DA MATRIZ");
        System.out.println();        
        System.out.println(" ->Digite 1:GERAR UMA MATRIZ DE ORDEM QUADRADA");
        System.out.println(" ->Digite 2:GERAR UMA MATRIZ DE ORDEM NAO QUADRADA");
        
        do{
            System.out.print("   ");
            resposta1 = ler.nextInt();
            if((resposta1 ==1)  || (resposta1 == 2)){
                saida = false;       
            }else{           
            System.out.println("COMANDO INVÁLIDO");
            System.out.println("Por favor,Digite novamente");
            }
        }while(saida);
        System.out.println();
        if(resposta1 == 1){
            System.out.print("INFORME A ORDEM DA MATRIZ: ");
            tamanho = ler.nextInt();
            Mat = new Matriz(tamanho);
        }else{
            System.out.print("INFORME O NUMERO DE LINHAS: ");
            i = ler.nextInt();
            System.out.print("INFORME O NUMERO DE COLUNAS: ");
            j = ler.nextInt();
            Mat = new Matriz(i,j);
        }
        System.out.println();
        System.out.println("                  -MATRIZ CRIADA! -                   ");
        System.out.println();
        System.out.println("PASSO 2:PREENCHER A  MATRIZ");
        System.out.println();
        System.out.println("->DIGITE 1:PREENCHER A MATRIZ COM UM ÚNICO VALOR");
        System.out.println("->DIGITE 2:PREENCHER A MATRIZ COM VALORES ALEATORIOS(0 A 20)");
        System.out.println("->DIGITE 3:PREENCHER A MATRIZ COM 0 ATE UM NUMERO INFORMADO");
        System.out.println("->DIGITE ,4:PREENCHER A MATRIZ MANUALMENTE");
        saida = true;
        do{
            System.out.print("  ");
            resposta2 = ler.nextInt();
            if((resposta2 ==1)  || (resposta2 == 2) || (resposta2 == 3) || (resposta2 == 4)){
                saida = false;       
            }else{           
                System.out.println("   COMANDO INVÁLIDO");
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
            Mat.IniciarManualmente();
        }

        System.out.println();
        System.out.println("MATRIZ");
	    System.out.println();
        Mat.imprime();
	    System.out.println();
        System.out.println("PASSO 3:CALCULO DA DETERMINANTE DA  MATRIZ");
        System.out.println();
        System.out.println("->DIGITE 1:CALCULAR COM ALGORITIMO BÁSICO");
        System.out.println("->DIGITE 2:CALCULAR COM ALGORITIMO COM OTIMIZAÇÃO BÁSICA");
        System.out.println("->DIGITE 3:CALCULAR COM ALGORITIMO COM OTIMIZAÇÃO EXTRA(TEOREMA DE CHIÓ)");
        System.out.println("->DIGITE 4:CALCULAR COM OS TRES ALGORITIMOS EM SEQUÊNCIA");
        saida = true; 
        do{
            System.out.print("  ");
            resposta2 = ler.nextInt();
            if((resposta2 ==1)  || (resposta2 == 2) || (resposta2 == 3) || (resposta2 == 4)){
                saida = false;       
            }else{           
                System.out.println("   COMANDO INVÁLIDO");
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
            System.out.println("                         ALGORITMO BÁSICO                                    ");
            System.out.println("==============================================================================");  
            System.out.println("Calculando Determinante...");
            System.out.println();
            if((Mat.retorneOrdem() == 13) || (Mat.retorneOrdem() == 15)){
                System.out.println("|LEMBRE-SE:A paciência é a arte de esperar|");
                System.out.println();
             }
        	    
            System.out.print("RESULTADO DO DETERMINANTE: ");
	        startTime = System.nanoTime();
	        System.out.println(Mat1.DetVersaoFusca());
	        endTime = System.nanoTime();
	        Tempo = endTime - startTime;
            System.out.print("TEMPO DE EXECUÇÃO DO ALGORITMO BÁSICO: ");
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
                System.out.println("|LEMBRE-SE:A paciência é a arte de esperar|");
                System.out.println();
            }
            System.out.println();            
            System.out.print("RESULTADO DO DETERMINANTE: ");
	        startTime = System.nanoTime();
	        System.out.println(Mat2.DetVersaoPalio());
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
                System.out.println("|LEMBRE-SE:A paciência é a arte de esperar|");
                System.out.println();
            }	    
            System.out.println();            
            System.out.print("RESULTADO DO DETERMINANTE: ");
            startTime = System.nanoTime();
	        System.out.println(Mat3.DetVersaoFerrari());
	        endTime = System.nanoTime();
	        Tempo = endTime - startTime;
	        System.out.print("TEMPO DE EXECUÇÃO DO ALGORITMO EXTRA OTIMIZADO(TEOREMA DE CHIO): ");       
            System.out.printf("%.1f\n",Tempo);
            System.out.println("=============================================================================="); 
            } 
        }      	
    }
}

