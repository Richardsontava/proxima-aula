import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		int num1 = 0,num2 = 0,fat1 = 0,fat2 = 0,Soma_fat;
		while(0 <= num1 || num1 <= 20 && 0 <= num2 || num2 <= 20){
			num1 = entrada.nextInt();
			while(num1 < 0){
				num1 = entrada.nextInt();
			}
			num2 = entrada.nextInt();
			while(num2 < 0){
				num2 = entrada.nextInt();
			}
			System.out.println("eof");
			if(num1 == 0 || num1 == 1){
				fat1 = 1;
			}
			else{
				for(int i = num1; i > 1; i--){
					fat1 = num1 * (i - 1);
					num1 = fat1;
				}
			}
			if(num2 == 0 || num2 == 1){
				fat2 = 1;
			}
			else{
				for(int i = num2; i > 1; i--){
					fat2 = num2 * (i - 1);
					num2 = fat2;
				}
			}
			Soma_fat = fat1 + fat2;
			System.out.println(Soma_fat);
		}
	}
}