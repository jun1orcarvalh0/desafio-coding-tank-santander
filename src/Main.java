import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] salarioBrutoFuncionarios = new double[5];

        System.out.println("Digite o salario do primeiro funcionario: ");
        salarioBrutoFuncionarios[0] = scan.nextFloat();
        System.out.println("Digite o salario do segundo funcionario: ");
        salarioBrutoFuncionarios[1] = scan.nextFloat();
        System.out.println("Digite o salario do terceiro funcionario: ");
        salarioBrutoFuncionarios[2] = scan.nextFloat();
        System.out.println("Digite o salario do quarto funcionario: ");
        salarioBrutoFuncionarios[3] = scan.nextFloat();
        System.out.println("Digite o salario do quinto funcionario: ");
        salarioBrutoFuncionarios[4] = scan.nextFloat();

        System.out.println("");

       Main.calculoDeSalario(salarioBrutoFuncionarios);
    }
    public static void calculoDeSalario(double[] input) {
        for (int i=0; i < input.length; i++) {
            DecimalFormat formato = new DecimalFormat("0.00");
            double pagoInss = calculoInss(input[i]);
            double pagoIr = calculoIr(input[i]);
            double salarioLiquido = input[i] - (pagoInss + pagoIr);
            System.out.println((i + 1) + "o" + " Funcionario:");
            System.out.println("Salario bruto: " + input[i]);
            System.out.println("Quanto pagou ao INSS: " + formato.format(pagoInss));
            System.out.println("Quanto pagou ao Imposto de Renda: " + formato.format(pagoIr));
            System.out.println("Salario liquido: " + formato.format(salarioLiquido));
            System.out.println("");
        }
    }

    public static double calculoInss(double salario) {
        if (salario > 0 && salario <= 1212.00) {
            return salario * 0.075;
        }
        else if (salario >= 1212.01 && salario <= 2427.35) {
            return salario * 0.09;
        }
        else if (salario >= 2427.36 && salario <= 3641.03) {
            return salario * 0.12;
        }
        else if (salario >= 3641.04) {
            return salario * 0.14;
        }
        return 0;
    }

    public static double calculoIr(double salario) {
        if (salario > 0 && salario <= 1903.98) {
            return 0;
        }
        else if (salario >= 1903.99  && salario <= 2826.65) {
            return salario * 0.075;
        }
        else if (salario >= 2826.66 && salario <= 3751.05) {
            return salario * 0.15;
        }
        else if (salario >= 3751.06 && salario <= 4664.68) {
            return salario * 0.225;
        }
        else if (salario >= 4664.68) {
            return salario * 0.275;
        }
        return 0;
    }
}