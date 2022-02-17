package br.com.infox.dal;

import java.sql.*;// Importa todas as bibliotecas do SQL

public class ModuloConexao {
    // método responsável pela conexão
    // Connection - conjunto de funcionalidade
    // trazido do pacote SQL
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //variável com um conector que faz referência
        //ao driver carregado na biblioteca
        String driver = "com.mysql.jdbc.Driver";
        // variável com o caminho de acesso o BD -local
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        //variável com usuário do BD
        String user = "root";
        //variável com a senha do BD
        String password = "";
        //estabelecendo a conexão com o bd
        try {
            //executa o driver do bd que está na variavel driver
            Class.forName(driver);
            
            //realiza a conexão com os valores de: url.user,password
            //conecta o sistema em java com o bd mysql
            //salva a informação da conexão na variável conexão
            conexao = DriverManager.getConnection(url, user, password);
            
            //se não houver nenhum problema retorna o valor de conexao
            return conexao;
        } catch (Exception e) {
            //mostra a execeção
            System.out.println(e);
            //se houver algum problema retorna null
            return null;
        }
    }
}
