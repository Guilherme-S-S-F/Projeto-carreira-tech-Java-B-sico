package app;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// db conta
		// COLUNAS
		// id, nome, cpf, email, senha
		String[][] contas = new String[15][5];
		String[][] db = { { "0", "gui", "23232", "gui@", "123" }, { "1", "paulo", "019131", "paulo@", "123" } };
		// db banco
		// COLUNAS
		// id, nome, cpf, email, senha, saldo
		String[][] contasBanco = new String[15][6];
		String[][] db2 = { { "0", "gui", "23232", "gui@", "123", "100.0" },
				{ "1", "paulo", "019131", "paulo@", "123", "200.0" } };

		telaPrincipal(input, contas, contasBanco);
	}

	// CRUD usuario
	public static void criarUsuario(String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i][0] == null) {
				db[i][0] = i + "";// id auto-incrementavel;
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
				return;
			}
		}
	}

	public static String lerUsuario(int id, String[][] db) {
		return "Nome: " + db[id][1] + "\nEmail: " + db[id][3] + "\nCpf: " + db[id][2];
	}

	public static void editarUsuario(int id, String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
				return;
			}
		}
	}

	public static void deletarUsuario(int id, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][0] = null;
				db[i][1] = null;
				db[i][2] = null;
				db[i][3] = null;
				db[i][4] = null;
				return;
			}
		}
	}

	// CRUD conta Bancaria
	public static void criarContaBanco(String id, String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i][0] == null) {
				db[i][0] = id;// id auto-incrementavel;
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
				db[i][5] = 0.0 + "";
				return;
			}
		}
	}

	public static String lerContaBanco(int id, String[][] db) {
		return "Nome: " + db[id][1] + "\nEmail: " + db[id][3] + "\nCpf: " + db[id][2] + "\nSaldo: " + db[id][5];
	}

	public static double verSaldo(int id, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				return Double.parseDouble(db[i][5]);
			}
		}

		return 0.0;
	}

	public static void editarContaBanco(int id, String nome, String cpf, String email, String senha, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][1] = nome;
				db[i][2] = cpf;
				db[i][3] = email;
				db[i][4] = senha;
				return;
			}
		}
	}

	public static void deletarContaBanco(int id, String[][] db) {
		for (int i = 0; i <= db.length - 1; i++) {
			if (Integer.parseInt(db[i][0]) == id) {
				db[i][0] = null;
				db[i][1] = null;
				db[i][2] = null;
				db[i][3] = null;
				db[i][4] = null;
				db[i][5] = null;
				return;
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

		while (count <= db.length - 1) {
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

		while (count <= db.length - 1) {
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
		while (count <= db.length - 1) {
			
			if(Integer.parseInt(db[count][0]) == pessoa) {
				double temp = Double.parseDouble(db[count][5]) + valor;
				db[count][5] = temp + "";
				break;
			}
			count++;
		}
		while (count <= db.length - 1) {
			if (Integer.parseInt(db[count][0]) == id) {
				double temp = Double.parseDouble(db[count][5]) - valor;
				db[count][5] = temp + "";
				break;
			}
			
			count++;
		}
	}

	public static int verificarConta(String nome, String senha, String[][] db) {
		int count = 0;
		while (count <= db.length) {
			if (db[count][1].equals(nome) && db[count][4].equals(senha)) {
				return Integer.parseInt(db[count][0]);
			}
			count++;
		}
		System.out.println("Usuario ou senha errados");
		return -1;
	}

	public static void telaPrincipal(Scanner input, String[][] dbUsuario, String[][] dbBanco) {
		int op = 1;

		while (op != 0) {
			System.out.println("1-Criar Usuario");
			System.out.println("2-Entrar No Usuario");
			System.out.println("3-Ver Usuarios");
			System.out.println("4- Deletar Usuario");
			System.out.println("0- Sair");
			System.out.println("Digite A Escolha");
			op = Integer.parseInt(input.nextLine());
			switch (op) {
			case 1:
				System.out.print("Seu  Nome: ");
				String nome = input.nextLine();
				System.out.print("Seu  Email: ");
				String email = input.nextLine();
				System.out.print("Seu  CPF: ");
				String cpf = input.nextLine();
				System.out.print("Seu  Senha: ");
				String senha = input.nextLine();
				criarUsuario(nome, cpf, email, senha, dbUsuario);
				break;
			case 2:
				System.out.print("Qual Seu Nome: ");
				String nome2 = input.nextLine();
				System.out.print("Qual Sua Senha: ");
				String senha2 = input.nextLine();
				int id = verificarConta(nome2, senha2, dbUsuario);
				if (id == -1) {
					System.out.println("Senha ou nome invalido");
				} else {

					// chamar segunda tela
					System.out.printf("id:$d\n",id);
					telaUsuario(input, id, dbUsuario, dbBanco);
				}

				break;
			case 3:
				for (int i = 0; i <= dbUsuario.length - 1; i++) {
					if (dbUsuario[i][0] != null) {
						System.out.println(lerUsuario(i, dbUsuario));
					}

				}
				break;
			case 4:
				System.out.print("Qual id voce quer deletar: ");
				int id2 = Integer.parseInt(input.nextLine());
				deletarUsuario(id2, dbUsuario);
				break;
			case 0:
				System.out.println("Fechando o programa...");
			}
		}

	}

	public static void telaUsuario(Scanner input, int id, String[][] dbUsuario, String[][] dbBanco) {
		int op = 1;
		while (op != 0) {
			System.out.println("1-Criar Conta Bancaria: ");
			System.out.println("2-Entrar Na Conta Bancaria: ");
			System.out.println("3-Deletar Conta Bancaria: ");
			System.out.println("0- Voltar");
			op = Integer.parseInt(input.nextLine());
			switch (op) {
			case 1:
				System.out.print("Escolha Uma Senha: ");
				String senha = input.nextLine();
				criarContaBanco(dbUsuario[id][0], dbUsuario[id][1], dbUsuario[id][2], dbUsuario[id][3], senha, dbBanco);
				break;
			case 2:
				System.out.print("Nome:");
				String nome = input.nextLine();
				System.out.print("Sua Senha: ");
				String senha2 = input.nextLine();
				int id2 = verificarConta(nome, senha2, dbBanco);
				if (id2 == -1) {
					System.out.println("Senha ou nome invalido");
				} else {

					// chamar contaBancaria tela
					telaBanco(input, id2, dbUsuario, dbBanco);
				}
				break;
			case 3:
				System.out.print("Qual id voce quer deletar: ");
				int id3 = Integer.parseInt(input.nextLine());
				deletarUsuario(id3, dbBanco);
				break;
			case 0:
				System.out.println("Voltando para tela principal");
				break;
			default:
				System.out.println("Opção inválida");
			}
		}
	}

	public static void telaBanco(Scanner input, int id, String[][] dbUsuario, String[][] dbBanco) {
		int op = 1;
		while (op != 0) {
			System.out.println("1-Ver saldo");
			System.out.println("2-Depositar");
			System.out.println("3-Sacar");
			System.out.println("4-Transferir");
			System.out.println("0- Voltar");

			op = Integer.parseInt(input.nextLine());
			switch (op) {
			case 1:
				System.out.println(verSaldo(id, dbBanco));
				break;
			case 2:
				System.out.println("Valor R$");
				double valor = Double.parseDouble(input.nextLine());
				depositarDinheiro(valor, id, dbBanco);
				break;
			case 3:
				System.out.println("Valor R$");
				double valor2 = Double.parseDouble(input.nextLine());
				sacarDinheiro(valor2, id, dbBanco);
				break;
			case 4:
				System.out.println("id para transferir: ");
				int id2 = Integer.parseInt(input.nextLine());
				System.out.println("Valor R$");
				double valor3 = Double.parseDouble(input.nextLine());
				System.out.println(id);
				transferir(valor3, id, id2, dbBanco);
				break;
			case 0:
				System.out.println("Voltando para tela de usuario...");
				break;
			default:
				System.out.println("Opção inválida");
			}

		}
	}
}
