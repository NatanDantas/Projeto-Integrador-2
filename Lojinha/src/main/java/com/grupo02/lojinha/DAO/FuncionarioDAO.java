/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.lojinha.DAO;

import com.grupo02.lojinha.MODEL.Endereco;
import com.grupo02.lojinha.MODEL.Funcionario;
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
public class FuncionarioDAO {
    public static boolean salvar(Funcionario f)
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            //conexao = GerenciadorConexao.abrirConexao();
            
            
            //Passo 3 - Executar uma instrução SQL
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Funcionario (nmFunc,cpf,telefone,celular,cargo,login,senha,id_enderecoFunc) VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
//            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,CPF) VALUES(?, ?)"
//                                                    , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
//            
            //Adiciono os parâmetros ao meu comando SQL
            Endereco e = f.getEndereco();
            instrucaoSQL.setString(1, f.getNomeFunc());
            instrucaoSQL.setString(2, f.getCpf());
            instrucaoSQL.setString(3, f.getTelefoneFunc());
            instrucaoSQL.setString(4, f.getCelularFunc());
            instrucaoSQL.setString(5, f.getCargo());
            instrucaoSQL.setString(6, f.getLogin());
            instrucaoSQL.setString(7, f.getSenha());
            instrucaoSQL.setInt(8, e.getIdEndereco());
            
            //Executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        f.setIdFunc(generatedKeys.getInt(1));
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
    
    /**
     * Método para realizar um update na tabela cliente
     * @param f - Objeto do tipo cliente
     * @return boolean - true: Dado atualizado; false: Dado não atualizado
     */
    public static boolean atualizar(Funcionario f)
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
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            instrucaoSQL = conexao.prepareStatement("UPDATE Funcionario SET nmFunc = ?, cpf = ?, telefone = ?, celular = ?, cargo = ?, login = ? , senha = ? WHERE id_Func =? ");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, f.getNomeFunc());
            instrucaoSQL.setString(2, f.getCpf());
            instrucaoSQL.setString(3, f.getTelefoneFunc());
            instrucaoSQL.setString(4, f.getCelularFunc());
            instrucaoSQL.setString(5, f.getCargo());
            instrucaoSQL.setString(6, f.getLogin());
            instrucaoSQL.setString(7, f.getSenha());
            instrucaoSQL.setInt(8, f.getIdFunc());

            
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
    
    /**
     * Método para Excluir um dado da tabela cliente
     * @param cID - <code>Int</code>
     * @return boolean - true: Dado excluido; false: Dado não excluido
     */
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
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Funcionario WHERE id_Func = ?");
            
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
    
    /**
     * Array List que retorna os dados para o Método de pesquisa de cliente
     * @return ArrayList - Retorna uma ArrayList com os dados pesquisados
     * @see #consultarClientes(java.lang.String) 
     */
    public static ArrayList<Funcionario> consultarFuncs()
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Funcionario> listaFuncs = new ArrayList<Funcionario>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Funcionario inner join Endereco on Funcionario.id_enderecoFunc = Endereco.id_endereco");

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Funcionario c = new Funcionario();
                Endereco e = new Endereco();
                c.setIdFunc(rs.getInt("id_Func"));
                c.setNomeFunc(rs.getString("nmFunc"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefoneFunc(rs.getString("telefone"));
                c.setCelularFunc(rs.getString("celular"));
                c.setCargo(rs.getString("cargo"));   
                c.setLogin(rs.getString("login")); 
                c.setSenha(rs.getString("senha")); 
                e.setIdEndereco(rs.getInt("id_enderecoFunc"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setBairro(rs.getString("bairro"));
                e.setNum(rs.getInt("numero"));
                c.setEndereco(e);
                //Adiciono na listaClientes
                listaFuncs.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaFuncs = null;
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
        
        return listaFuncs;
    }
    
    /**
     * Método para consultar a tabela cliente pelo nome do cliente
     * @param nm - <code>String</code> 
     * @return ArrayList - Retorna uma ArrayList com os dados pesquisados
     */
    public static ArrayList<Funcionario> consultarFuncs(String nm)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Funcionario> listaFuncs = new ArrayList<Funcionario>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Funcionario inner join Endereco on Funcionario.id_enderecoFunc = Endereco.id_endereco where Funcionario.nmFunc like ? ");
            
            instrucaoSQL.setString(1, nm);

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Funcionario c = new Funcionario();
                Endereco e = new Endereco();
                c.setIdFunc(rs.getInt("id_Func"));
                c.setNomeFunc(rs.getString("nmFunc"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefoneFunc(rs.getString("telefone"));
                c.setCelularFunc(rs.getString("celular"));
                c.setCargo(rs.getString("cargo"));   
                c.setLogin(rs.getString("login")); 
                c.setSenha(rs.getString("senha")); 
                e.setIdEndereco(rs.getInt("id_enderecoFunc"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setBairro(rs.getString("bairro"));
                e.setNum(rs.getInt("numero"));
                c.setEndereco(e);
                //Adiciono na listaClientes
                listaFuncs.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaFuncs = null;
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
        
        return listaFuncs;
    }
    public static boolean consultarFuncs(String log,String sen)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        boolean retorno = false;
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Funcionario where login like ? and senha like ?");
            
            instrucaoSQL.setString(1, log);
            instrucaoSQL.setString(2, sen);

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                retorno = true;
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
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
        
        return retorno;
    }
}
