package com.grupo02.lojinha.DAO;

import com.grupo02.lojinha.MODEL.DetalheVenda;
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
public class DetalheVendaDAO {

    /**
     * Método para salvar os detalhes das vendas feitas na tabela Detalhevenda
     * @param dv - <code>ArrayList</code>
     * @return boolean - Retorna um boolean com true para salvo com sucesso  e false para caso algo de errado
     */
    public static boolean salvar(ArrayList<DetalheVenda> dv)
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
            
            for(int i = 0; i < dv.size(); i++){
                //Passo 3 - Executar uma instrução SQL
                instrucaoSQL = conexao.prepareStatement("INSERT INTO DetalheVenda(id_Prod,quantidade,Valor,id_venda) VALUES(?, ?, ?, ?)"
                                                        , Statement.RETURN_GENERATED_KEYS);

                //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
                //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
                //conexao = GerenciadorConexao.abrirConexao();

    //            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,CPF) VALUES(?, ?)"
    //                                                    , Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
    //            
                //Adiciono os parâmetros ao meu comando SQL

                instrucaoSQL.setInt(1,dv.get(i).getProd().getIdProd());
                instrucaoSQL.setInt(2, dv.get(i).getQuantidade());
                instrucaoSQL.setDouble(3, dv.get(i).getValor());
                instrucaoSQL.setInt(4, dv.get(i).getIdVenda());


                //Executar a instrução SQL
                int linhasAfetadas = instrucaoSQL.executeUpdate();

                if(linhasAfetadas>0)
                {
                    retorno = true;

                    ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                    if (generatedKeys.next()) {
                            dv.get(i).setIdDetalheVenda(generatedKeys.getInt(1));
                    }
                    else {
                        throw new SQLException("Falha ao obter o ID do cliente.");
                    }
                }
                else{
                    retorno = false;
                }
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
        
}
