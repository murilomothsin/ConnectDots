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
		tabuleiro = new Tabuleiro(3);
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
	
	public void reiniciaTabuleiro(){
		int tam = 3;
		if(nivel == 1){
			tam = 3;
		}
		if(nivel == 2){
			tam = 4;
		}
		if(nivel == 3){
			tam = 5;
		}
		Tabuleiro tab = new Tabuleiro(tam);
		tabuleiro = tab;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
}