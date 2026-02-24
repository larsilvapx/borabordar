package com.borabordar;

import com.borabordar.model.Cliente;
import com.borabordar.model.Pedido;
import com.borabordar.services.ClientService;
import com.borabordar.services.PedidosService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

public class BorabordarApplication {

	private final Scanner sc = new Scanner(System.in);
	private final ClientService service = new ClientService();

	private final PedidosService pedidosService = new PedidosService();

	private final ClientService clientService = new ClientService();



	public static void main(String[] args) {
		SpringApplication.run(BorabordarApplication.class, args);
		new BorabordarApplication().runMenu(); // start console menu


	}

	private void runMenu() {
		while (true) {
			System.out.println("\n === Bora Bodar ===");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Criar pedido");
			System.out.println("4 - Listar pedido");
			System.out.println("5 - Cancelar pedido");
			System.out.println("6 - Listar pedidos por cliente");
			System.out.println("0 - Sair");

			int opcao = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (opcao) {
				case 1:
					try {
						System.out.print("Nome: ");
						String nome = sc.nextLine();

						System.out.print("Telefone: ");
						String telefone = sc.nextLine();

						System.out.print("CPF: ");
						String cpf = sc.nextLine();

						service.cadastrarCliente(nome, telefone, cpf);
						System.out.println("Cliente cadastrado com sucesso!");
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;

				case 2:
					service.listarCliente().forEach(System.out::println);
					break;
				case 3:
					try {


						System.out.println("CPF do cliente");
						String cpfBusca = sc.nextLine();

						Cliente cliente = clientService.buscarPorCpf(cpfBusca);

						if (cliente == null) {
							System.out.println("Cliente não encontrado");
							break;
						}
						System.out.println("Descrição do pedido");
						String descricao = sc.nextLine();

						System.out.println("Valor");
						double valor = sc.nextDouble();

						pedidosService.criarPedido(cliente, descricao, valor);
						System.out.println("Pedido criado com sucesso!");
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}

					break;

				case 4:
					pedidosService.listarPedido().forEach(System.out::println);
					break;

				case 5:
					try{
						System.out.println("Informe o id do pedido");
						int idCancelamento = sc.nextInt();
						sc.nextLine();

						pedidosService.cancelarPedido(idCancelamento);

						System.out.println("Pedido cancelado com sucesso");
					} catch (Exception e) {
						System.out.println("Erro: "+ e.getMessage());
					}
					break;

				case 6:
					System.out.println("Informe o cpf do cliente");
					String cpfBuscaPorPedidos = sc.nextLine();

					List<Pedido> pedidoCliente = pedidosService.listarPedidoPorCliente(cpfBuscaPorPedidos);

					if(pedidoCliente.isEmpty()){
						System.out.println("Nenhum pedido foi encontardo para este clinte ");
					}
					else{
						pedidoCliente.forEach(System.out::println);
					}
					break;

				case 0:
					System.out.println("Saindo...");
					return;

				default:
					System.out.println("Opção inválida!");
			}
		}
	}
}
