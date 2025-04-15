package Projeto.DAO;

import Projeto.Dominio.Cliente;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {

    private final Map<String, Cliente> clientes;

    public ClienteMapDAO() {
        this.clientes = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            return false;
        }
        clientes.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(String cpf) {
        clientes.remove(cpf); // Correção: Remove diretamente pelo CPF
    }

    @Override
    public void alterar(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            clientes.put(cliente.getCpf(), cliente); // Simplesmente sobrescreve
        }
    }

    @Override
    public Cliente consultar(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clientes.values();
    }
}
