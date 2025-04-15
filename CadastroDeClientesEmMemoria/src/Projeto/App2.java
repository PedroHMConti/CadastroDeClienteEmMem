package Projeto;

import Projeto.DAO.ClienteMapDAO2;
import Projeto.DAO.IclienteDAO2;
import Projeto.Dominio.Cliente;

import javax.swing.*;

public class App2 {

    public static final IclienteDAO2 iclienteDAO2 = new ClienteMapDAO2();


    public static void main(String[] args) {
        while(true){
            //selecionar uma opção valida
            String opcao = JOptionPane.showInputDialog(null,
                    "escolha uma opção: \n"+
                            "1-CADASTRAR \n"+
                            "2-CONSULTAR \n"+
                            "3-ALTERAR \n"+
                            "4-EXCLUIR \n"+
                            "5-CONSULTAR TODOS\n"+
                            "6-SAIR","TELA INICIAL",JOptionPane.INFORMATION_MESSAGE);

            if(opcao == null || opcao.isEmpty()){
                JOptionPane.showMessageDialog(null,"OPÇÃO INCORRETA!","ERRO",JOptionPane.INFORMATION_MESSAGE);
                continue;
            }
            switch (opcao){
                case "1":cadastrar();break;
                case "2":consultar();break;
                case "3":alterar();break;
                case "4":excluir();break;
                case "5":buscarTodos();break;
                case "6":sair();break;
            }
        }
    }
    //implementação dos metodos descritos

    public static void cadastrar(){
        String dados = JOptionPane.showInputDialog(null,"Insira os dados separados por virgula\nnome,\ncpf,\ntelefone\n,endereço,\nnumeroENdereco,\ncidade,\nestado","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
        String[] dadosSeparados = dados.split(",");
        if(dadosSeparados.length == 7){
            Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],Long.parseLong(dadosSeparados[2]),dadosSeparados[3],Integer.parseInt(dadosSeparados[4]),dadosSeparados[5],dadosSeparados[6]);
            if(iclienteDAO2.cadastrar(cliente)){
                JOptionPane.showMessageDialog(null,"Cliente cadastrado","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não cadastrado","Falha",JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //metodo consultar

    public static void consultar(){
        String cpf = JOptionPane.showInputDialog(null,"DIGITE O CPF:","CONSULTA",JOptionPane.INFORMATION_MESSAGE);

        if(iclienteDAO2.consultar(cpf) == null){
            JOptionPane.showMessageDialog(null,"CLIENTE NÃO ENCONTRADO","ERRO",JOptionPane.INFORMATION_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(null,iclienteDAO2.consultar(cpf).toString(),"SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //metodo alterar

    public static void alterar(){
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente que deseja alterar:",
                "Alteração", JOptionPane.INFORMATION_MESSAGE);

        Cliente clienteExistente = iclienteDAO2.consultar(cpf);

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
        iclienteDAO2.alterar(clienteAtualizado);
        JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void excluir(){
        String cpf = JOptionPane.showInputDialog(null,"INFORME O CPF","EXCLUSÃO",JOptionPane.INFORMATION_MESSAGE);
        if(iclienteDAO2.consultar(cpf)==null){
            JOptionPane.showMessageDialog(null,"CLIENTE NÃO ENCONTRADO","FALHA",JOptionPane.INFORMATION_MESSAGE);
        }else if(iclienteDAO2.excluir(cpf)==true){
            JOptionPane.showMessageDialog(null,"CLIENTE EXCLUIDO","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não excluido","falha",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void buscarTodos(){
        JOptionPane.showMessageDialog(null,iclienteDAO2.buscarTodos().toString(),"Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void sair(){
        System.exit(0);
    }
}
