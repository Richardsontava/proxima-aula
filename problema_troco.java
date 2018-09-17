import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Main obj = new Main();
		Scanner entrada = new Scanner(System.in);
		double Caixa_Moedas[] = {0.05,0.1,0.25,0.5,1};
		double Caixa_Cedulas[] = {2,5,10,20,50,100};
		//Quantas moedas e cedulas foram pegas
		int[] Quantidade_total = {0,0,0,0,0,0,0,0,0,0,0};
//Abordadando o consumidor
		System.out.println("=> Qual o valor do produto?");
		double Valor_Produto = entrada.nextDouble();
//Se não tiver digitado um valor maior que zero
		while(Valor_Produto <= 0){
			System.out.println("Esse preço não existe");
			System.out.println("=> Qual o valor do produto?");
			Valor_Produto = entrada.nextDouble();
		}
//Perguntar como vai ser o pagamento
		System.out.println("=> Com quanto vai pagar?");
		double Valor_Pago = entrada.nextDouble();
//Se não tiver dado um valor maior ou igual o do produto
		while(Valor_Pago < Valor_Produto){
			double Restante = Valor_Produto - Valor_Pago;
			System.out.println("Valor pago é menor que o do produto");
			System.out.println("Faltam R$ " + Restante);
			System.out.println("=> Com quanto vai pagar?");
			Valor_Pago = entrada.nextDouble();
		}
		double Troco = Valor_Pago - Valor_Produto;
// Sem troco
		if(Troco == 0){
			System.out.println("Seu troco é R$ 0,00");
			System.out.println("Obrigado e tenha um bom dia!");
		}
		System.out.println("\n\nSeu troco é de R$ " + Troco);
		double Troco2 = Troco;
		while(Troco != 0){
//Se tiver que dar alguma cedula para o troco do usuário
			if(Troco >= 2){
				Troco = obj.Quantidade_Cedulas(Troco,Caixa_Cedulas,Quantidade_total);
				//Qual cedula foi pega desta vez
				for(int i = 0; i < Caixa_Cedulas.length; i++){
					if(Caixa_Cedulas[i] == Troco2 - Troco){
						break;
					}
					if(Troco2 - Troco == Caixa_Cedulas[i]){
						//Dizer para o contador quantas cedulas de cada foram pegas
						Quantidade_total[i + 5] = Quantidade_total[i + 5] + 1;
					}
				}
				//Novo troco
				Troco2 = Troco;
			}
//se tiver que pegar alguma moeda do caixa
			else if(Troco < 2){
				Troco = obj.Quantidade_Moedas(Troco,Caixa_Moedas,Quantidade_total);
//Qual moeda foi pega
				for(int i = 0; i < Caixa_Moedas.length; i++){
					if(Caixa_Moedas[i] == Troco2 - Troco){
						break;
					}
					if(Troco2 - Troco == Caixa_Moedas[i]){
						//Dizer para o contador quantas cedulas de cada foram pegas
						Quantidade_total[i + 5] = Quantidade_total[i + 5] + 1;
					}
				}
				//Novo troco
				Troco2 = Troco;
			}
			else{
				break;
			}
		}
//Quantas moedas e cedulas o usuário vai receber
		if(Quantidade_total[10] != 0){
			System.out.println("* " + Quantidade_total[10] + " cedula(s) de 100 reais");
		}
		if(Quantidade_total[9] != 0){
			System.out.println("* " + Quantidade_total[9] + " cedula(s) de 50 reais");
		}
		if(Quantidade_total[8] != 0){
			System.out.println("* " + Quantidade_total[8] + " cedula(s) de 20 reais");
		}
		if(Quantidade_total[7] != 0){
			System.out.println("* " + Quantidade_total[7] + " cedula(s) de 10 reais");
		}
		if(Quantidade_total[6] != 0){
			System.out.println("* " + Quantidade_total[6] + " cedula(s) de 5 reais");
		}
		if(Quantidade_total[5] != 0){
			System.out.println("* " + Quantidade_total[5] + " cedula(s) de 2 reais");
		}
		if(Quantidade_total[4] != 0){
			System.out.println("* " + Quantidade_total[4] + " moeda(s) de 1 real");
		}
		if(Quantidade_total[3] != 0){
			System.out.println("* " + Quantidade_total[3] + " moeda(s) de 50 centavos");
		}
		if(Quantidade_total[2] != 0){
			System.out.println("* " + Quantidade_total[2] + " moeda(s) de 25 centavos");
		}
		if(Quantidade_total[1] != 0){
			System.out.println("* " + Quantidade_total[1] + " moeda(s) de 10 centavos");
		}
		if(Quantidade_total[0] != 0){
			System.out.println("* " + Quantidade_total[0] + " moeda(s) de 5 centavos");
		}
		System.out.println("\n\t\tObrigado e volte sempre");
	}
//função para pegar as cedulas do caixa
	public double Quantidade_Cedulas(double Troco, double Caixa_Cedulas[],int Quantidade_total[]){
		if(Troco >= 100){
			Troco -= Caixa_Cedulas[5];
			Quantidade_total[10] = Quantidade_total[10] + 1;
		}
		else if(Troco >= 50){
			Troco -= Caixa_Cedulas[4];
			Quantidade_total[9] = Quantidade_total[9] + 1;
		}
		else if(Troco >= 20){
			Troco -= Caixa_Cedulas[3];
			Quantidade_total[8] = Quantidade_total[8] + 1;
		}
		else if(Troco >= 10){
			Troco -= Caixa_Cedulas[2];
			Quantidade_total[7] = Quantidade_total[7] + 1;
		}
		else if(Troco >= 5){
			Troco -= Caixa_Cedulas[1];
			Quantidade_total[6] = Quantidade_total[6] + 1;
		}
		else if(Troco >= 2){
			Troco -= Caixa_Cedulas[0];
			Quantidade_total[5] = Quantidade_total[5] + 1;
		}
		return Troco;
	}
//função para pegar as moedas do caixa
	public double Quantidade_Moedas(double Troco,double Caixa_Moedas[],int Quantidade_total[]){
		if(Troco >= 1){
			Troco -= Caixa_Moedas[4];
			Quantidade_total[4] = Quantidade_total[4] + 1;
		}
		else if(Troco >= 0.5){
			Troco -= Caixa_Moedas[3];
			Quantidade_total[3] = Quantidade_total[3] + 1;
		}
		else if(Troco >= 0.25){
			Troco -= Caixa_Moedas[2];
			Quantidade_total[2] = Quantidade_total[2] + 1;
		}
		else if(Troco >= 0.1){
			Troco -= Caixa_Moedas[1];
			Quantidade_total[1] = Quantidade_total[1] + 1;
		}
		else if(Troco >= 0.05){
			Troco -= Caixa_Moedas[0];
			Quantidade_total[0] = Quantidade_total[0] + 1;
		}
		return Troco;
	}
}


/*
produto = 6;
pagamento = 5;  <<<======
restante = 1;
Novo pagamento = restante || Novo pagamento > restante && 
! Novo pagamento < 




*/