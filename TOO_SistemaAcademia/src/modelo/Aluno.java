package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    private Plano plano;
    private double valorMensalidade;
    private LocalDate dataMatricula;

    public Aluno() {
    }

    public Aluno(String matricula, LocalDate dataMatricula) {
        this.matricula = matricula;
        this.dataMatricula = dataMatricula;
    }

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public String mostrarAvaliacoes() {
        String aux = "Historico de Avaliacoes: \n";
        for (AvaliacaoFisica cadaAvaliacao : avaliacoes) {
            aux += "->> " + cadaAvaliacao + "\n";
        }
        return aux;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
        valorMensalidade = plano.getValor(); 
    }

    public void verificaDesconto() {
        if (plano != null && dataMatricula != null) {
            
            long mesesMatriculado = dataMatricula.until(LocalDate.now()).toTotalMonths();

            if (mesesMatriculado >= 3) {
                valorMensalidade = plano.getValor() * 0.9;
                System.out.println("Desconto de 10% aplicado! Nova mensalidade: R$ " + valorMensalidade);
            } else {
                valorMensalidade = plano.getValor();
                System.out.println("Sem desconto. Mensalidade: R$ " + valorMensalidade);
            }
        } else {
            System.out.println("Plano ou data de matricula nao definidos.");
        }
    }

    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nMatricula: " + (matricula != null ? matricula : "Nao definida");
        aux += "\nData de Matricula: " + (dataMatricula != null ? dataMatricula : "Nao definida");
        aux += "\nPlano: " + (plano != null ? plano.getNome() : "Nao definido");
        aux += "\nAvaliacoes Fisicas Realizadas: " + avaliacoes.size();
        aux += "\nValor da Mensalidade: R$ " + valorMensalidade;
        return aux;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
