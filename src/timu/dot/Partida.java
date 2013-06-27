package timu.dot;

import java.util.ArrayList;

public class Partida {
	ArrayList<Jogador> Jogadores = new ArrayList<Jogador>();
	private int nivel;
	private Tabuleiro tabuleiro;

	public Partida(Jogador Jog1, Jogador Jog2){
		Jogadores.add(Jog1);
		Jogadores.add(Jog2);
		nivel = 1;
	}
	
	public Jogador getJogador(int i) {
		return Jogadores.get(i);
	}

	public int getNivel() {
		return nivel;
	}

	public void incrementaNivel() {
		this.nivel++;
	}
	
	public boolean reiniciaTabuleiro(){
		int tam = 3;
		switch (nivel) {
		case 1:
			tam = 3;
		break;
		case 2:
			tam = 4;
		break;
		case 3:
			tam = 5;
		break;
		default:
			return false;
		}
		Tabuleiro tab = new Tabuleiro(tam);
		tabuleiro = tab;
		return true;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
}