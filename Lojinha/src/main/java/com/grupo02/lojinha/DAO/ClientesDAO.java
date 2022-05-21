/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.lojinha.DAO;

import com.grupo02.lojinha.MODEL.Cliente;
import com.grupo02.lojinha.MODEL.Endereco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bruno.vrufino
 */
public class ClientesDAO {
    public static boolean salvar(Cliente c)
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            //conexao = GerenciadorConexao.abrirConexao();
            
            
            //Passo 3 - Executar uma instrução SQL
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Cliente (nmCli,cpf,telefone,celular,email,id_enderecoCli) VALUES(?, ?, ?, ?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
//            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,CPF) VALUES(?, ?)"
//                                                    , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
//            
            //Adiciono os parâmetros ao meu comando SQL
            Endereco e = c.getEndereco();
            instrucaoSQL.setString(1, c.getNomeCli());
            instrucaoSQL.setString(2, c.getCPF());
            instrucaoSQL.setString(3, c.getTelefoneCli());
            instrucaoSQL.setString(4, c.getCelularCli());
            instrucaoSQL.setString(5, c.getEmail());
            instrucaoSQL.setInt(6, e.getIdEndereco());
            
            //Executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        c.setIdCliente(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
//                GerenciadorConexao.fecharConexao();
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static boolean atualizar(Cliente c)
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            instrucaoSQL = conexao.prepareStatement("UPDATE Cliente SET nmCli = ?, cpf = ?, telefone = ?, celular = ?, email = ? WHERE id_Cli =? ");
            
            //Adiciono os parâmetros ao meu comando SQL
            Endereco e = c.getEndereco();
            instrucaoSQL.setString(1, c.getNomeCli());
            instrucaoSQL.setString(2, c.getCPF());
            instrucaoSQL.setString(3, c.getTelefoneCli());
            instrucaoSQL.setString(4, c.getCelularCli());
            instrucaoSQL.setString(5, c.getEmail());
            instrucaoSQL.setInt(6, c.getIdCliente());

            
            //Mando executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                //GerenciadorConexao.fecharConexao();
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static boolean excluir(int cID)
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Cliente WHERE id_Cli = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, cID);

            //Mando executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                //GerenciadorConexao.fecharConexao();
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static ArrayList<Cliente> consultarClientes()
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente inner join Endereco on Cliente.id_enderecoCli = Endereco.id_endereco");

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Cliente c = new Cliente();
                Endereco e = new Endereco();
                c.setIdCliente(rs.getInt("id_Cli"));
                c.setNomeCli(rs.getString("nmCli"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefoneCli(rs.getString("telefone"));
                c.setCelularCli(rs.getString("celular"));
                c.setEmail(rs.getString("email"));        
                e.setIdEndereco(rs.getInt("id_enderecoCli"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setBairro(rs.getString("bairro"));
                e.setNum(rs.getInt("numero"));
                c.setEndereco(e);
                //Adiciono na listaClientes
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                conexao.close();
                //GerenciadorConexao.fecharConexao();
                        
              } catch (SQLException ex) {
             }
        }
        
        return listaClientes;
    }
    
    public static ArrayList<Cliente> consultarClientes(String nm)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente inner join Endereco on Cliente.id_enderecoCli = Endereco.id_endereco where Cliente.nmCli like ? ");
            
            instrucaoSQL.setString(1, nm);

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Cliente c = new Cliente();
                Endereco e = new Endereco();
                c.setIdCliente(rs.getInt("id_Cli"));
                c.setNomeCli(rs.getString("nmCli"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefoneCli(rs.getString("telefone"));
                c.setCelularCli(rs.getString("celular"));
                c.setEmail(rs.getString("email"));        
                e.setIdEndereco(rs.getInt("id_enderecoCli"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setBairro(rs.getString("bairro"));
                e.setNum(rs.getInt("numero"));
                c.setEndereco(e);
                //Adiciono na listaClientes
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                conexao.close();
                //GerenciadorConexao.fecharConexao();
                        
              } catch (SQLException ex) {
             }
        }
        
        return listaClientes;
    }

    public static boolean salvar(Endereco e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static boolean atualizar(Endereco e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
