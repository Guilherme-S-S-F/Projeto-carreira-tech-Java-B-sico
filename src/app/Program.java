package app;

public class Program {

	public static void main(String[] args) {
		// COLUNAS
		// id, nome, cpf, email, senha, dinheiro
		String[][] bancoDeDados = new String[15][6];
		String[][] db = {
				{"0", "pedro", "019131", "gmail", "qq115", "100.0"},
				{"1", "pedro", "019131", "gmail", "qq115", "200.0"}
		};
		
		
	}
	public static void sacarDinheiro(double valor, int id, String[][] db) {
		if (valor <= 0) {
			System.out.println("Digite um valor válido");
			return;
		}
		int count = 0;
		
		while(count <= db.length) {
			if(Integer.parseInt(db[count][0]) == id) {
				double temp = Double.parseDouble(db[count][5]) - valor;
				db[count][5] = temp + "";
				return;
			}
			count++;
		}
		System.out.println("Id inválido");
	}
	public static void depositarDinheiro(double valor, int id, String[][] db) {
		if (valor <= 0) {
			System.out.println("Digite um valor válido");
			return;
		}
		int count = 0;
		
		while(count <= db.length) {
			if(Integer.parseInt(db[count][0]) == id) {
				double temp = Double.parseDouble(db[count][5]) + valor;
				db[count][5] = temp + "";
				return;
			}
			count++;
		}
		System.out.println("Id inválido");
	}
	public static void transferir(double valor, int id, int pessoa, String[][]db) {
		int count = 0;
		if ( id < 0 || id > db.length  ) {
			System.out.println("id invalido");
			return;
		}
		if ( pessoa < 0 || pessoa > db.length  ) {
			System.out.println("pessoa invalida");
			return;
			
		}
		if(valor <= 0){
			System.out.println("Valor invalido");
			return;
			
		}
		while(count <= db.length) {
			if(Integer.parseInt(db[count][0]) == id) {
			double temp = Double.parseDouble(db[count][5]) - valor;
			db[count][5] = temp + "";
			}
			if(Integer.parseInt(db[count][0] ) == pessoa) {
				double temp = Double.parseDouble(db[count][5]) + valor;
				db[count][5] = temp + "";
			}
			count++;
		} 
	}
		
	


}

