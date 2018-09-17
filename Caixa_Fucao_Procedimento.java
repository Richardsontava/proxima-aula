import java.util.Scanner;
public class Main{
	public void Menu(){
		System.out.println("\tSimulador de Caixa");
		System.out.println("1 - Ver saldo");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Sair");
	}
	public void Saldo(double Ver_Saldo){
		System.out.println("Seu saldo é R$ " + Ver_Saldo);
	}
	public double Tirar_Dinheiro(double Ver_Saldo,double Sacar){
		Scanner tcl = new Scanner(System.in);
		System.out.println("=> Digite quanto quer sacar:");
		Sacar = tcl.nextInt();
		Ver_Saldo -= Sacar;
		return Ver_Saldo;
	}
	public double Colocar_Dinheiro(double saldo,double depositar){
		Scanner tcl = new Scanner(System.in);
		System.out.println("=> Digite quanto quer depositar:");
		depositar = tcl.nextInt();
		saldo += depositar;
		return saldo;
	}
	public int Sair(int opcao){
		opcao = 0;
		Scanner tcl = new Scanner(System.in);
		System.out.println("=> Deseja realmente sair?{S/N}");
		String resposta = tcl.next();
		if(resposta.equals("S")){
			 opcao = 1;
		}
		else if(resposta.equals("N")){
			opcao = 0;
		}
		else{
			while(resposta != "S" || resposta != "N"){
				System.out.println("* Essa resposta não é aceita");
				System.out.println("=> Deseja realmente sair?{S/N}");
				resposta = tcl.next();
				if(resposta.equals("S")){
					opcao = 1;
					break;
				}
				else if(resposta.equals("N")){
					opcao = 0;
					break;
				}
			}
		}
		return opcao;
	}
	public static void main(String[] args){
		Main obj = new Main();
		Scanner tcl = new Scanner(System.in);
		double Ver_Saldo = 0,Sacar = 0,Depositar = 0;
		int opçao = 0;
		while(opçao != 4){
			obj.Menu();
			opçao = tcl.nextInt();
			switch(opçao){
				case 1:
					obj.Saldo(Ver_Saldo);
					break;
				case 2:
					Ver_Saldo = obj.Tirar_Dinheiro(Ver_Saldo,Sacar);
					break;
				case 3:
					Ver_Saldo = obj.Colocar_Dinheiro(Ver_Saldo,Depositar);
					break;
				case 4:
					opçao = obj.Sair(opçao);
					if(opçao == 1){
						opçao = 4;
					}
					else{
						continue;
					}
					break;
				default:
				    System.out.println("Resposta invalida");
			}
		}
	}
}