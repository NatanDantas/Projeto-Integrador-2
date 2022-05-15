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
public class EnderecoDAO {
    public static boolean salvar(Endereco c)
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            //conexao = GerenciadorConexao.abrirConexao();
            
            
            //Passo 3 - Executar uma instrução SQL
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Endereco (cep, rua, bairro, numero) VALUES(?, ?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
//            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,CPF) VALUES(?, ?)"
//                                                    , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
//            
            //Adiciono os parâmetros ao meu comando SQL
 
            instrucaoSQL.setString(1, c.getCep());
            instrucaoSQL.setString(2, c.getRua());
            instrucaoSQL.setString(3, c.getBairro());
            instrucaoSQL.setInt(4, c.getNum());
            
            //Executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        c.setIdEndereco(generatedKeys.getInt(1));
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
                  System.out.println("Erro ao fechar conexão");
             }
        }
        
        return retorno;
    }
    
    public static boolean atualizar(Endereco c)
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
            
            instrucaoSQL = conexao.prepareStatement("UPDATE Endereco SET cep = ?, rua = ?, bairro = ?, numero = ?  WHERE id_endereco = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, c.getCep());
            instrucaoSQL.setString(2, c.getRua());
            instrucaoSQL.setString(3, c.getBairro());
            instrucaoSQL.setInt(4, c.getNum());

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
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Endereco WHERE id_endereco = ?");
            
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
    
    public static ArrayList<Endereco> consultarEnderecos()
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Endereco> listaClientes = new ArrayList<Endereco>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Endereco;");

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Endereco e = new Endereco();
                
                e.setIdEndereco(rs.getInt("id_endereco"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setBairro(rs.getString("bairro"));
                e.setNum(rs.getInt("numero"));
                
                //Adiciono na listaClientes
                listaClientes.add(e);
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
}
