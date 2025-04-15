package Projeto.DAO;

import Projeto.Dominio.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO2 implements IclienteDAO2 {

    public Map<String,Cliente> mapa = new HashMap<>();

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(mapa.containsKey(cliente.getCpf())){
            return false;
        }else{
            mapa.put(cliente.getCpf(),cliente);
            return true;
        }
    }

    @Override
    public Cliente consultar(String cpf) {
        if(mapa.containsKey(cpf)){
            return mapa.get(cpf);
        }else{
            return null;
        }
    }

    @Override
    public Boolean alterar(Cliente cliente) {
        if(mapa.containsKey(cliente.getCpf())){
            mapa.put(cliente.getCpf(),cliente);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean excluir(String cpf) {
        if(mapa.containsKey(cpf)){
            mapa.remove(cpf);
            return true;
        }else{
            return false;
        }
    }
    public Map<String,Cliente> buscarTodos(){
        return mapa;
    }
}
