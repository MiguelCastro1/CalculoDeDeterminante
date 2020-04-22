import java.util.Scanner;

class main{
	public static void main(String[] args){
		int num, numC, numL;
		Matriz Mat;
		
		Mat = new Matriz(6);
		numL = Mat.getnumLinhas();
        numC = Mat.getnumColunas();
        Mat.iniciarComNumero(42);
		Mat.imprime();
		
		double StartTime = System.nanoTime();
		System.out.println(Mat.determinante());
		double endTime = System.nanoTime();
		double Tempo = endTime - StartTime;
		System.out.print(Tempo);
	}
}