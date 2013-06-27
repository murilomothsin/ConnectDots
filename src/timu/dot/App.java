package timu.dot;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		char char1origem, char2origem, char1dest, char2dest, letra1, letra2;
		int x = 0;
		Scanner scanner = new Scanner(System.in);
		String texto = new String();
		String nome1 = new String();
		String nome2 = new String();
		
		System.out.println(". . . . . . . .ConnectDots. . . . . . . . \n\n");
		System.out.println("Digite o nome do primeiro jogador: ");
		nome1 = scanner.nextLine();
		Jogador jog1 = new Jogador(nome1);
		System.out.println("Digite a letra que irá representar o jogador " + jog1.getNome() + ": ");
		texto = scanner.nextLine();
		letra1 = texto.charAt(0);
		jog1.setLetraJogador(letra1);
		int flag = 0;
		do{
			if(flag >= 1){
				System.out.println("Nome já utilizado por outro jogador!");
			}
			System.out.println("\nDigite o nome do segundo jogador:");
			nome2 = scanner.nextLine();
			flag++;
		}while(nome2.equalsIgnoreCase(nome1));
		Jogador jog2 = new Jogador(nome2);
		flag = 0;
		do{
			if(flag >= 1){
				System.out.println("Letra já utilizada por outro jogador!");
			}
			System.out.println("Digite a letra que irá representar o jogador " + jog2.getNome() + ": ");
			texto = scanner.nextLine();
			letra2 = texto.charAt(0);
			flag++;
		}while(letra2 == letra1);
		jog2.setLetraJogador(letra2);
		
		Partida partida = new Partida(jog1, jog2);
		
		while(partida.reiniciaTabuleiro()){
			while(!partida.getTabuleiro().tabuleiroCompleto()){
				boolean jogada = false;
				while(!jogada){
					System.out.println("Nível: " + partida.getNivel());
					int limitLetra = partida.getNivel()+66;
					int limitNumero = partida.getNivel()+50;
					partida.getTabuleiro().render();
					do{
						System.out.println("Jogador " + partida.getJogador(x).getNome() + ": \n");
						System.out.print("Origem: ");
						texto = scanner.nextLine().toUpperCase();
					}while((texto.length() < 2) || (texto.isEmpty()));
					char1origem = texto.charAt(0);
					char2origem = texto.charAt(1);
					texto = null;
					do{
						System.out.print("Destino: ");
						texto = scanner.nextLine().toUpperCase();
					}while((texto.length() < 2) || (texto.isEmpty()));
					char1dest = texto.charAt(0);
					char2dest = texto.charAt(1);
					
					jogada = partida.getTabuleiro().jogada(char1origem, char2origem, char1dest, char2dest, partida.getJogador(x));
				}
				if(x == 0){
					x = 1;
				}else
					x = 0;
			}
			
			partida.getTabuleiro().render();
			
			System.out.println("Pontuação do jogador " + partida.getJogador(0).getNome() + ": " + partida.getJogador(0).getPontuacao());
			System.out.println("Pontuação do jogador " + partida.getJogador(1).getNome() + ": " + partida.getJogador(1).getPontuacao());
			
			partida.incrementaNivel();
		}
	}
}