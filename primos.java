import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		System.out.println("Diga um número para saber se é primo ou não");
		float num = entrada.nextInt();
		if(num % 2 == 1){
			for(float i = 3; i <= num; i++){
				if(i == num){
					System.out.println(num + " é primo");
					break;
				}
				if(num % i == 0){
					System.out.println(num + " não é primo");
				}
			}
		}
		else{
			System.out.println(num + " não é primo");
		}
	}
}