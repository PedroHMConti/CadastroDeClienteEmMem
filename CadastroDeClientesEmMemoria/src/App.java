import Projeto.DAO.ClienteMapDAO;
import Projeto.DAO.IClienteDAO;
import Projeto.Dominio.Cliente;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class App {
    private static final IClienteDAO iClienteDAO = new ClienteMapDAO();

    public static void main(String[] args) {
        while (true) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Digite:\n1 - Cadastrar\n2 - Consultar\n3 - Excluir\n4 - Alterar\n5 - Sair",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);

            if (opcao == null || !isOpcaoValida(opcao)) {
                JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case "1": cadastrar(); break;
                case "2": consultar(); break;
                case "3": excluir(); break;
                case "4": alterar(); break;
                case "5": sair(); return;
            }
        }
    }

    private static void cadastrar() {
        String dados = JOptionPane.showInputDialog(null,
                "Digite: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        if (dados == null || dados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length < 7) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Cliente cliente = new Cliente(
                    dadosSeparados[0], dadosSeparados[1], Long.parseLong(dadosSeparados[2]),
                    dadosSeparados[3], Integer.parseInt(dadosSeparados[4]), dadosSeparados[5], dadosSeparados[6]);

            if (iClienteDAO.cadastrar(cliente)) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro nos números informados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultar() {
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF:", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        Cliente cliente = iClienteDAO.consultar(cpf);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + cliente, "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void excluir() {
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF para exclusão:", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        iClienteDAO.excluir(cpf);
        JOptionPane.showMessageDialog(null, "Cliente excluído!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void alterar() {

        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente que deseja alterar:",
                "Alteração", JOptionPane.INFORMATION_MESSAGE);

        Cliente clienteExistente = iClienteDAO.consultar(cpf);

        if(clienteExistente == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String novosDados = JOptionPane.showInputDialog(null, "Digite os novos dados do cliente separados por vírgula:\n" +
                        "Nome, Telefone, Endereço, Número, Cidade, Estado\n" +
                        "(Deixe um campo vazio para manter o valor atual)",
                "Alteração", JOptionPane.INFORMATION_MESSAGE);
        if(novosDados == null || novosDados.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nunhuma alteração realizada!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String[] dadosSeparados = novosDados.split(",");
        Cliente clienteAtualizado = new Cliente(dadosSeparados[0],cpf,Long.parseLong(dadosSeparados[1]),dadosSeparados[2],Integer.parseInt(dadosSeparados[3]),dadosSeparados[4],dadosSeparados[5]);
        iClienteDAO.alterar(clienteAtualizado);
        JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isOpcaoValida(String opcao) {
        return Arrays.asList("1", "2", "3", "4", "5").contains(opcao);
    }
}
