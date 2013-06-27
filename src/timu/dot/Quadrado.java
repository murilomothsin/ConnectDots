package timu.dot;

public class Quadrado {
	private boolean status = false;
	private boolean lados[] = new boolean[4];
	private Jogador preenchido;
	
	public Quadrado(){
		for(int i = 0; i < 4; i++){
			lados[i] = false;
		}
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public Jogador getJogador(){
		return preenchido;
	}
	
	public boolean getLado(int i){
		return lados[i];
	}
	
	public boolean setLados(int i, Jogador j){
		boolean completo = true;
		if(lados[i] == false){
			lados[i] = true;
			for (i = 0; i < 4; i++){
				if(!lados[i]){
					completo = false;
				}
			}
			if(completo){
				preenchido = j;
				status = true;
				j.aumentaPontos();
			}
			return true;
		}else
			return false;
	}
}