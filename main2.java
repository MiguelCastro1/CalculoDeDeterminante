import java.util.Scanner;

class main2{
	public static void main(String[] args){
		int num, numC, numL;
		Matriz Mat;
		
		Mat = new Matriz(12);
		numL = Mat.getnumLinhas();
        numC = Mat.getnumColunas();
        Mat.iniciaRandom(50);
		Mat.imprime();
        		
		double StartTime = System.nanoTime();
		System.out.println(Mat.determinante());
		double endTime = System.nanoTime();
		double Tempo = endTime - StartTime;
		System.out.print(Tempo);
	}
}