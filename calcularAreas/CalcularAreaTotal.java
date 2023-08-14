import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Poligono {
    double lado;
    double area;

    public double getArea() {
        return area;
    }
}

class Triangulo extends Poligono {
    public Triangulo(double lado) {
        this.lado = lado;
        calcularAreaTriangulo();
    }

    private void calcularAreaTriangulo() {
        area = (lado * lado * Math.sqrt(3)) / 4;
    }

    @Override
    public String toString() {
        return "triângulo de lado " + lado + " cm e área " + String.format("%.2f", area) + " cm2";
    }
}

class Quadrado extends Poligono {
    public Quadrado(double lado) {
        this.lado = lado;
        calcularAreaQuadrado();
    }

    private void calcularAreaQuadrado() {
        area = lado * lado;
    }

    @Override
    public String toString() {
        return "quadrado de lado " + lado + " cm e área " + String.format("%.2f", area) + " cm2";
    }
}

public class CalcularAreaTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Poligono> poligonos = new ArrayList<>();

        while (true) {
            System.out.print("Informe o número de lados do polígono (3 para Triângulo, 4 para Quadrado, ou outro para sair): ");
            int numLados = scanner.nextInt();

            if (numLados == 3) {
                System.out.print("Informe o tamanho do lado (em cm): ");
                double lado = scanner.nextDouble();

                if (lado > 0) {
                    poligonos.add(new Triangulo(lado));
                } else {
                    System.out.println("Tamanho do lado inválido. Deve ser um valor positivo.");
                }
            } else if (numLados == 4) {
                System.out.print("Informe o tamanho do lado (em cm): ");
                double lado = scanner.nextDouble();

                if (lado > 0) {
                    poligonos.add(new Quadrado(lado));
                } else {
                    System.out.println("Tamanho do lado inválido. Deve ser um valor positivo.");
                }
            } else {
                break;
            }
        }

        double areaTotal = 0;
        for (Poligono poligono : poligonos) {
            System.out.println(poligono);
            areaTotal += poligono.getArea();
        }

        System.out.println("Area total " + String.format("%.2f", areaTotal) + " cm2");
    }
}