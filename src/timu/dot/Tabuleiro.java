package timu.dot;

public class Tabuleiro {
	
	private Quadrado q[][];
	private int tamanho;
	
	public Tabuleiro(int tam){
		tamanho = tam;
		q = new Quadrado[tamanho][tamanho];
		for(int j = 0; j < tamanho; j++){
			for(int i = 0; i < tamanho; i++){
				q[i][j] = new Quadrado();
			}
		}
	}
	
	public boolean jogada(char ch1, char ch2, char ch3, char ch4, Jogador jog){
		int coordenada1 = (int)ch2-48;
		int coordenada2 = (int)ch4-48;
		char letra = 'A';
		for(int j = 0; j < this.tamanho; j++){
			if(ch1 == letra){
				if(ch3 == letra){
					for(int i = 0; i < this.tamanho; i++){
						if(coordenada1 == i+1){
							if(coordenada2 == i){
								if(j == 0)
									q[i-1][j].setLados(0, jog);
								else{
									q[i-1][j].setLados(0, jog);
									q[i-1][j-1].setLados(2, jog);
								}
								return true;
							}else if(coordenada2 == i+2){
								if(j == 0)
									q[i][j].setLados(0, jog);
								else{
									q[i][j].setLados(0, jog);
									q[i][j-1].setLados(2, jog);
								}
								return true;
							}
						}
					}
				}else if(ch3 == letra-1){
					for(int i = 0; i < this.tamanho; i++){
						if(coordenada1 == i+1 && coordenada2 == i+1){
							if(i == 0){
								q[i][j-1].setLados(3, jog);
								return true;
							}else if(i == this.tamanho-1){
								q[i][j-1].setLados(3, jog);
								return true;
							}else{
								q[i-1][j-1].setLados(1, jog);
								q[i][j-1].setLados(3, jog);
								return true;
							}
						}
					}
				}else if(ch3 == letra+1){
					for(int i = 0; i < this.tamanho; i++){
						if(coordenada1 == i+1 && coordenada2 == i+1){
							if(i == 0){
								q[i][j].setLados(3, jog);
								return true;
							}else if(i == this.tamanho-1){
								q[i][j].setLados(3, jog);
								q[i-1][j].setLados(1, jog);
								return true;
							}else{
								q[i-1][j].setLados(1, jog);
								q[i][j].setLados(3, jog);
								return true;
							}
						}
					}
				}
			}
			letra += 1;
		}
		return false;
	}
	
	public boolean tabuleiroCompleto() {
		boolean completo = true;
		for(int j = 0; j < tamanho-1; j++){
			for(int i = 0; i < tamanho-1; i++){
				if(!q[i][j].getStatus()){
					completo = false;
				}
			}
		}
		return completo;
	}
 
	public void render(){

		char letra = 'A';
		int limit = tamanho;
		boolean lado;
		boolean vertical[] = new boolean[limit];
		for(int j = 0; j < limit; j++){
			for(int i = 0; i < limit; i++){
				System.out.print(letra);
				System.out.print(i+1);
				vertical[i] = q[i][j].getLado(3);
				if(i == limit){
					vertical[i] = q[i][j].getLado(1);
				}
				if(j == 0){
					lado = q[i][j].getLado(0);
				}else{
					if(j == limit){
						lado = q[i][j].getLado(2);
					}
					lado = q[i][j].getLado(0);
					if(!lado){
						lado = q[i][j-1].getLado(2);
					}
				}
				if(lado){
					System.out.print("---");
				}else
					System.out.print("   ");
				}
				letra += 1;
				System.out.println("");
				for(int i = 0; i <limit; i++){
					if(vertical[i]){
						System.out.print(" |   ");
					}else
						System.out.print("    ");
				}
				System.out.println();
			}
	}
}