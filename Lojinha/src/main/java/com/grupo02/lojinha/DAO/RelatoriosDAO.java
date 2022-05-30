/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.lojinha.DAO;

import com.grupo02.lojinha.MODEL.DetalheVenda;
import com.grupo02.lojinha.MODEL.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bruno.vrufino
 */
public class RelatoriosDAO {
    public static ArrayList<Venda> consultarVendas()
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Venda> listaVendas = new ArrayList<Venda>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Venda");

            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setIdcli(rs.getInt("id_Cli"));
                v.setIdfunc(rs.getInt("id_Func"));
                v.setData(rs.getDate("dtVenda"));
                v.setValorTotal(rs.getDouble("valorTotal"));
                listaVendas.add(v);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVendas = null;
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
        
        return listaVendas;
    }
    
    public static ArrayList<Venda> consultarVendas(Date dtInicio, Date dtFim)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<Venda> listaVendas = new ArrayList<Venda>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Venda WHERE dtVenda BETWEEN ? AND ?");
            instrucaoSQL.setDate(1, dtInicio);
            instrucaoSQL.setDate(2, dtFim);
            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setIdcli(rs.getInt("id_Cli"));
                v.setIdfunc(rs.getInt("id_Func"));
                v.setData(rs.getDate("dtVenda"));
                v.setValorTotal(rs.getDouble("valorTotal"));
                listaVendas.add(v);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVendas = null;
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
        
        return listaVendas;
    }
    
    public static ArrayList<DetalheVenda> consultarDetalhe(int idV)
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        //Armazeno as informaçoes da tabela (resultSet) em um ArrayList
        ArrayList<DetalheVenda> listaVenda = new ArrayList<DetalheVenda>();
        
        try {
            
            //conexao = GerenciadorConexao.abrirConexao();
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/perfumariabd?allowPublicKeyRetrieval=true&useSSL=false?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            //conexao = DriverManager.getConnection(URL, "root", "Br@15687899");
            
            //Passo 3 - Executo a instrução SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM DetalheVenda WHERE id_venda = ?");
            instrucaoSQL.setInt(1, idV);
            //Executa a Query (Consulta) - Retorna um objeto da classe ResultSet
            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                
                DetalheVenda dv = new DetalheVenda();
                dv.setIdDetalheVenda(rs.getInt("id_detalheVenda"));
                dv.setIdVenda(rs.getInt("id_venda"));
                dv.setProd(ProdutoDAO.consultarProduto(rs.getInt("id_Prod")));
                dv.setQuantidade(rs.getInt("quantidade"));
                dv.setValor(rs.getDouble("Valor"));
                
                listaVenda.add(dv);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVenda = null;
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
        
        return listaVenda;
    }
}
