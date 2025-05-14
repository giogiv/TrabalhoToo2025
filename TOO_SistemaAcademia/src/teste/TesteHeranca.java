package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.AvaliacaoFisica;
import modelo.Professor;
import modelo.Plano;

public class TesteHeranca {
    public static void main(String[] args) {

        Professor p = new Professor();
        p.setNome("Pedro");
        p.setCpf("123.123.123-67");
        p.setEspecializacao("Musculacao");
        
        System.out.println(p.exibirDados());

        Plano plano = new Plano("Plano Basico", "Direito a ir todos os dias e montar um plano especializado!", 400.0);
        
        AvaliacaoFisica av = new AvaliacaoFisica();
        DateTimeFormatter formato = av.getFormato();  // acessando o formato de avaliacaofisica

        // Aluno sem desconto
        Aluno a1 = new Aluno();
        a1.setNome("Carolina Lima");
        a1.setMatricula("MAT-001"); 
        a1.setDataNascimento(LocalDate.parse("10/01/2008", formato)); 
        a1.setDataMatricula(LocalDate.parse("11/05/2025", formato)); 
        a1.setPlano(plano);
        a1.verificaDesconto();

        System.out.println("\n=== Dados do Aluno ===");
        System.out.println(a1.exibirDados());
        
        // Aluno com desconto
        Aluno a2 = new Aluno();
        a2.setNome("Maria Clara");
        a2.setMatricula("MAT-002");
        a2.setDataNascimento(LocalDate.parse("15/02/2005", formato));
        a2.setDataMatricula(LocalDate.parse("07/01/2024", formato)); 
        a2.setPlano(plano);
        a2.verificaDesconto();

        System.out.println("\n=== Dados do Aluno ===");
        System.out.println(a2.exibirDados());
        
        AvaliacaoFisica av1 = new AvaliacaoFisica(a2);
        av1.setProfessor(p);
        a2.adicionarAvaliacao(av1);

        System.out.println("\n---- Dados da Avaliacao ----");
        System.out.println(av1.exibirDados());
    }
}
