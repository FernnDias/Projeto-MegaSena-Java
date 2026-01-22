/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;       
import java.util.List;   
import java.util.ArrayList;

/**
 *
 * @author denis
 */
public class Sorteio {
    // Atributos 
    private int Concurso;
    private int n1, n2, n3, n4, n5, n6;

    public int getConcurso() { return Concurso; }
    public int getN1() { return n1; }
    public int getN2() { return n2; }
    public int getN3() { return n3; }
    public int getN4() { return n4; }
    public int getN5() { return n5; }
    public int getN6() { return n6; }

    public Sorteio(int Concurso, int n1, int n2, int n3, int n4, int n5, int n6 ) {
        this.Concurso = Concurso;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
    }
    
    public void Cadastrar () {
        Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/bancoprojetomegasena", "root","");
        
        String comando;
        comando = "insert into sorteios (Concurso, n1, n2, n3, n4, n5, n6 ) values("+Concurso+","+n1+","+n2+","+n3+","+n4+","+n5+","+n6+")";
        System.out.println(comando);
        
        Statement Instrucao;        
        Instrucao = conexao.createStatement();  
        Instrucao.executeUpdate(comando); 
    }catch( ClassNotFoundException erro){ 
        System.out.println("Erro clase");
    }catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
    }

public List<Sorteio> buscarTodosDoBanco() {
    List<Sorteio> lista = new ArrayList<>();
    try {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bancoprojetomegasena", "root", "");
        ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM sorteios ORDER BY Concurso DESC");

        while (rs.next()) {
            lista.add(new Sorteio(
                rs.getInt("Concurso"), rs.getInt("n1"), rs.getInt("n2"), 
                rs.getInt("n3"), rs.getInt("n4"), rs.getInt("n5"), rs.getInt("n6")
            ));
        }
        conexao.close();
    } catch (Exception e) { System.out.println("Erro: " + e); }
    return lista;
}

public String montarTabela(List<Sorteio> listaParaExibir) {
    StringBuilder html = new StringBuilder("<html><table border='1'>");
    for (Sorteio s : listaParaExibir) {
        html.append("<tr><td>").append(s.getConcurso()).append("</td>")
            .append("<td>").append(s.getN1()).append("</td><td>").append(s.getN2()).append("</td>")
            .append("<td>").append(s.getN3()).append("</td><td>").append(s.getN4()).append("</td>")
            .append("<td>").append(s.getN5()).append("</td><td>").append(s.getN6()).append("</td></tr>");
    }
    return html.append("</table></html>").toString();
}
public void excluir() {
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bancoprojetomegasena", "root", "");
        
        String comando = "DELETE FROM sorteios WHERE Concurso = " + this.Concurso;
        
        System.out.println("Executando: " + comando);
        
        Statement instrucao = conexao.createStatement();   
        instrucao.executeUpdate(comando); 
        
        instrucao.close();
        conexao.close();
        
    } catch(ClassNotFoundException erro) { 
        System.out.println("Erro classe: " + erro);
    } catch(SQLException erro) {
        System.out.println("Erro SQL: " + erro);
    }
}
 public void Atualizar() {
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bancoprojetomegasena", "root", "");
        
        String comando;
        comando = "UPDATE sorteios SET "
                + "n1 = " + n1 + ", "
                + "n2 = " + n2 + ", "
                + "n3 = " + n3 + ", "
                + "n4 = " + n4 + ", "
                + "n5 = " + n5 + ", "
                + "n6 = " + n6 + " "
                + "WHERE Concurso = " + Concurso;

        System.out.println("Executando: " + comando);
        
        Statement instrucao = conexao.createStatement();  
        instrucao.executeUpdate(comando);
        
        instrucao.close();
        conexao.close();
        
    } catch (ClassNotFoundException erro) {
        System.out.println("Erro na classe do Driver");
    } catch (SQLException erro) {
        System.out.println("Erro SQL: " + erro);
    }
}
} //Fim
