package app;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// db conta
		// COLUNAS
		// id, nome, cpf, email, senha
		String[][] contas = new String[15][6];
		String[][] db = { { "0", "pedro", "019131", "gmail", "qq115" }, { "1", "pedro", "019131", "gmail", "qq115" } };
		// db banco
		// COLUNAS
		// id, nome, cpf, email, senha, saldo
		String[][] contasBanco = new String[15][6];
		String[][] db2 = { { "0", "pedro", "019131", "gmail", "qq115", "100.0" },
				{ "1", "pedro", "019131", "gmail", "qq115", "200.0" } };

	}

	// CRUD usuario
	public static void criarUsuario(String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (db[i][0] == "") {
				db[i][0] = i + "";// id auto-incrementavel;
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
			}
		}
	}

	public static String lerUsuario(int id, String[][] db) {
		return "Nome: " + db[id][1] + "\nEmail: " + db[id][3] + "\nCpf: " + db[id][2];
	}

	public static void editarUsuario(int id, String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
			}
		}
	}

	public static void deletarUsuario(int id, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][0] = "";
				db[i][1] = "";
				db[i][2] = "";
				db[i][3] = "";
				db[i][4] = "";
			}
		}
	}

	// CRUD conta Bancaria
	public static void criarContaBanco(String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (db[i][0] == "") {
				db[i][0] = i + "";// id auto-incrementavel;
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
				db[i][5] = 0 + "";
			}
		}
	}

	public static String lerContaBanco(int id, String[][] db) {
		return "Nome: " + db[id][1] + "\nEmail: " + db[id][3] + "\nCpf: " + db[id][2] + "\nSaldo: " + db[id][5];
	}

	public static void editarContaBanco(int id, String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
			}
		}
	}

	public static void deletarContaBanco(int id, String[][] db) {
		for (int i = 0; i <= db.length; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][0] = "";
				db[i][1] = "";
				db[i][2] = "";
				db[i][3] = "";
				db[i][4] = "";
				db[i][5] = "";
			}
		}
	}

	// ----------------------#--------------------#----------------------------
	public static void sacarDinheiro(double valor, int id, String[][] db) {
		if (valor <= 0) {
			System.out.println("Digite um valor válido");
			return;
		}
		int count = 0;

		while (count <= db.length) {
			if (Integer.parseInt(db[count][0]) == id) {
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

		while (count <= db.length) {
			if (Integer.parseInt(db[count][0]) == id) {
				double temp = Double.parseDouble(db[count][5]) + valor;
				db[count][5] = temp + "";
				return;
			}
			count++;
		}
		System.out.println("Id inválido");
	}

	public static void transferir(double valor, int id, int pessoa, String[][] db) {
		int count = 0;
		if (id < 0 || id > db.length) {
			System.out.println("id invalido");
			return;
		}
		if (pessoa < 0 || pessoa > db.length) {
			System.out.println("pessoa invalida");
			return;

		}
		if (valor <= 0) {
			System.out.println("Valor invalido");
			return;

		}
		while (count <= db.length) {
			if (Integer.parseInt(db[count][0]) == id) {
				double temp = Double.parseDouble(db[count][5]) - valor;
				db[count][5] = temp + "";
			}
			if (Integer.parseInt(db[count][0]) == pessoa) {
				double temp = Double.parseDouble(db[count][5]) + valor;
				db[count][5] = temp + "";
			}
			count++;
		}
	}

	public static int verificarConta(String nome, String senha, String[][] db) {
		int count = 0;
		while (count <= db.length) {
			if (db[count][1] == nome && db[count][4] == senha) {
				return count;
			}
			count++;
		}
		System.out.println("Usuario ou senha errados");
		return -1;
	}



	public static void telaPrincipal(Scanner input, String[][] db) {
		System.out.println("1-Criar Usuario");
		System.out.println("2-Entrar No Usuario");
		System.out.println("3-Ver Usuarios");
		System.out.println("4- Deletar Usuario");
		System.out.println("Digite A Escolha");
		int escolha = Integer.parseInt(input.nextLine());
		switch (escolha) {
		case 1:
			System.out.print("Seu  Nome: ");
			String nome = input.nextLine();
			System.out.print("Seu  Email: ");
			String email = input.nextLine();
			System.out.print("Seu  CPF: ");
			String cpf = input.nextLine();
			System.out.print("Seu  Senha: ");
			String senha = input.nextLine();
			criarUsuario(nome, cpf, email, senha, db);
			break;
		case 2:
			System.out.print("Qual Seu Nome: ");
			String nome2 = input.nextLine();
			System.out.print("Qual Sua Senha: ");
			String senha2 = input.nextLine();
			int id = verificarConta(nome2, senha2, db);
			// chamar segunda tela
			break;
		case 3:
			for (int i = 0; i <= db.length; i++) {
				System.out.println(lerUsuario(i, db));

			}
			break;
		case 4:
			System.out.print("Qual id voce quer deletar: ");
			int id2 = Integer.parseInt(input.nextLine());
            deletarUsuario(id2, db);		}
		
		
	}
	public static void telaUsuario(Scanner input,int id,  String[][] db) {
		System.out.print("1-Criar Conta Bancaria: ");
		System.out.print("2-Entrar Na Conta Bancaria: ");
		System.out.print("3-Deletar Conta Bancaria: ");
		int escolha = Integer.parseInt(input.nextLine());
		switch (escolha) {
		case 1:
			System.out.print("Escolha Uma Senha: ");
	        String senha = input.nextLine();
	        criarContaBanco(db[id][1], db[id][2], db[id][3], senha, db);
		case 2:
			System.out.print("Nome:" );
			String nome = input.nextLine();
			System.out.print("Sua Senha: ");
			String senha2 = input.nextLine();
			int id2 = verificarConta(nome, senha2, db);
			//chamar tela  conta bancaria
			break;
		case 3:
			System.out.print("Qual id voce quer deletar: ");
			int id3 = Integer.parseInt(input.nextLine());
            deletarUsuario(id3, db);
			
			
		}
		


		
		
	}
}
