package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AvaliacaoFisica {
    private Aluno aluno;
    private LocalDate data;
    private double peso;
    private double altura;
    private double idade;
    private double imc;
    private Professor professor;
    
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public AvaliacaoFisica(Aluno aluno){
        this.aluno = aluno;
        data = LocalDate.now();
    }

    public AvaliacaoFisica() {
        
    }
    
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Pessoa getAluno() {
        return aluno;
    }
    
    public double calcularIMC(){
        return peso / (altura*altura);
    }
    
    public void calcularIdade(){
        idade  = Period.between(aluno.getDataNascimento(), data).getYears();
    }
    
    
    public String exibirDados(){
        

        String aux = "Dados da Avaliacao Fisica: \n";
        aux += "Aluno: " + aluno + "\n";
        calcularIdade();
        if (idade != 0) {
            aux += "Idade: " + idade + "\n";
        }
        if (data != null) {
            aux += "Data da Avaliacao: " + getFormato().format(data);
        }
        imc = calcularIMC();
        if(imc > 0){
            aux += "\nIMC: " + imc;
        }
        if(professor!=null)
            aux += "\nProfessor: "+professor;
        return aux;
    }

    @Override
    public String toString() {
        return getFormato().format(data) +" - IMC: "+ imc;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the formato
     */
    public DateTimeFormatter getFormato() {
        return formato;
    }
    
    
}
