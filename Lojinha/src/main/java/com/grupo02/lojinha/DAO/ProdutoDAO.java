package com.grupo02.lojinha.DAO;

import com.grupo02.lojinha.MODEL.Cliente;
import com.grupo02.lojinha.MODEL.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author NatanDantas
 * @author rufin
 */
public class ProdutoDAO {

    /**
     * Método para salvar/inserir dados na tabela Produto
     * @param p - Objeto do tipo Produto
     * @return boolean - true: Dado inserido; false: Dado não inserido
     */
    public static boolean salvar(Produto p)
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
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Produto (nmProd,valor,descricao,qtde) VALUES(?, ?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            //conexao = GerenciadorConexao.abrirConexao();
            
//            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,CPF) VALUES(?, ?)"
//                                                    , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
//            
            //Adiciono os parâmetros ao meu comando SQL

            instrucaoSQL.setString(1, p.getNmProd());
            instrucaoSQL.setDouble(2, p.getValor());
            instrucaoSQL.setString(3, p.getDescricao());
            instrucaoSQL.setInt(4, p.getQtde());
            
            
            //Executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        p.setIdProd(generatedKeys.getInt(1));
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
     * Método para atualizar dados da tabela Produto
     * @param p - Objeto do tipo Produto
     * @return boolean - true: Dados atualizados; false: Dados não atualizados
     */
    public static boolean atualizar(Produto p)
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
            
            instrucaoSQL = conexao.prepareStatement("UPDATE Produto SET nmProd = ?, valor = ?, descricao = ?, qtdEstoque = ? WHERE id_Prod =? ");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, p.getNmProd());
            instrucaoSQL.setDouble(2, p.getValor());
            instrucaoSQL.setString(3, p.getDescricao());
            instrucaoSQL.setInt(4, p.getQtde());
            instrucaoSQL.setInt(5, p.getIdProd());
           

            
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
     * Método para excluir dados da tabela Produto
     * @param pID - <code>Int</code>
     * @return boolean - true: Dado excluido; false: Dado não excluido
     */
    public static boolean excluir(int pID)
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
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Produto WHERE id_Prod = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pID);

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
     * Criação de uma ArrayList para consultar os produtos na tabela Produto
     * @return ArrayList - Retorna uma ArrayList com os dados pesquisados
     */
    public static ArrayList<Produto> consultarProdutos()
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Produto");

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Produto p = new Produto();
                
                p.setIdProd(rs.getInt("id_Prod"));
                p.setNmProd(rs.getString("nmProd"));
                p.setValor(rs.getDouble("valor"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtde(rs.getInt("qtde"));
               
                //Adiciono na listaClientes
                listaProdutos.add(p);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
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
        
        return listaProdutos;
    }
     public static Produto consultarProduto(int idP)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        Produto p = new Produto();  
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            //conexao = DriverManager.getConnection(URL, "root", "");
            conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Produto where id_Prod = ?");
            instrucaoSQL.setInt(1,idP);
            
            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet 
            while(rs.next())
            {
                p.setIdProd(rs.getInt("id_Prod"));
                p.setNmProd(rs.getString("nmProd"));
                p.setValor(rs.getDouble("valor"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtde(rs.getInt("qtdEstoque"));
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            p = null;
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
        
        return p;
    }
}
