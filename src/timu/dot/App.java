package timu.dot;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		char char1origem, char2origem, char1dest, char2dest;
		int x = 0;
		Scanner scanner = new Scanner(System.in);
		String texto = new String();
		System.out.println("Digite o nome do primeiro jogador: ");
		texto = scanner.nextLine();
		Jogador jog1 = new Jogador(texto);
		System.out.println("\nDigite o nome do segundo jogador:");
		texto = scanner.nextLine();
		Jogador jog2 = new Jogador(texto);
		Partida partida = new Partida(jog1, jog2);
		
		for(int i = 0; i < 3; i++){
			partida.reiniciaTabuleiro();
			while(!partida.getTabuleiro().tabuleiroCompleto()){
				System.out.println(partida.getTabuleiro().tabuleiroCompleto());
				partida.getTabuleiro().render();
				System.out.println("Jogador " + partida.getJogador(x).getNome() + ": \n");
				System.out.print("Origem: ");
				texto = scanner.nextLine();
				char1origem = texto.charAt(0);
				char2origem = texto.charAt(1);
				System.out.print("Destino: ");
				texto = scanner.nextLine();
				char1dest = texto.charAt(0);
				char2dest = texto.charAt(1);
				partida.getTabuleiro().jogada(char1origem, char2origem, char1dest, char2dest, partida.getJogador(x));
				if(x == 0){
					x = 1;
				}else
					x = 0;
			}
			
			partida.getTabuleiro().render();
			
			System.out.println("Pontuação do jogador " + partida.getJogador(0).getNome() + ": " + partida.getJogador(0).getPontuacao());
			System.out.println("Pontuação do jogador " + partida.getJogador(1).getNome() + ": " + partida.getJogador(1).getPontuacao());
			
		}
	}
}