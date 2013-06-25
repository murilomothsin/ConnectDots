package timu.dot;

public class Jogador {
	
	private int Pontuacao;
	private String nome;
	private char LetraJogador;
	
	public Jogador(String nome){
		Pontuacao = 0;
		this.nome = nome;
	}
	
	public int getPontuacao() {
		return Pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.Pontuacao = pontuacao;
	}
	
	public void aumentaPontos(){
		Pontuacao++;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getLetraJogador() {
		return LetraJogador;
	}
	public void setLetraJogador(char letraJogador) {
		LetraJogador = letraJogador;
	}
}
