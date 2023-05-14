package listaempleado;

import java.util.Scanner;

class Empleado{
    private String []nombre;
    private int numEmpleados;
    private double []salario;
    private int []edad;
    private double PorcentajeAumento;
    private double promedioSalario;

    public Empleado(String[] nombre, double[] salario, int[] edad, double PorcentajeAumento,int numEmpleados) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
        this.PorcentajeAumento = PorcentajeAumento;
        this.numEmpleados=numEmpleados;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double[] salario) {
        this.salario = salario;
    }

    public void setEdad(int[] edad) {
        this.edad = edad;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }
    
    public void calcularPromedioSalario(){
        for(int i=0;i<this.salario.length;i++){
            this.promedioSalario=(this.promedioSalario+this.salario[i]);
        }
        this.promedioSalario=this.promedioSalario/this.numEmpleados;
    }
    public void calcularAumentoSalario(){
        for(int i=0;i<this.salario.length;i++){
            if(this.salario[i]<this.promedioSalario){
                this.salario[i]=(this.salario[i]*this.PorcentajeAumento)/100+this.salario[i];
            }
        }
    }
    public String[] getNombre() {
        return nombre;
    }

    public double[] getSalario() {
        return salario;
    }

    public int[] getEdad() {
        return edad;
    }

    public double getPorcentajeAumento() {
        return PorcentajeAumento;
    }

    public double getPromedioSalario() {
        return promedioSalario;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }
    
    public String toString(int i) {
             return ( "Empleado "+(i+1)+": "+ nombre[i] + "\nsalario: " + salario[i] + "\nedad: " + edad[i]);
    }
}
public class ListaEmpleado {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte n;
        System.out.println("Ingrese la cantidad de empleados a registrar: ");
        n=sc.nextByte();
        String nombres[]=new String[n];
        int edades[]=new int[n];
        double sueldos[]=new double[n];
        for(byte i=0;i<n;i++){
            System.out.println("Ingrese el nombre del trabajador "+(i+1)+(" :"));
            sc.nextLine();
            nombres[i]=sc.nextLine();
            System.out.println("Ingrese la edad del trabajador"+(i+1)+(" :"));  
            edades[i]=sc.nextInt();
            System.out.println("Ingrese el sueldo del trabajador"+(i+1)+(" :"));
            sueldos[i]=sc.nextDouble();
        }
        System.out.println("Ingrese un porcentaje de aumento salarial");
        Empleado empleado1=new Empleado(nombres, sueldos, edades, sc.nextDouble(),n);
        System.out.println("DATOS DE LOS EMPLEADOS");
        for(int i=0;i<n;i++){
             System.out.println( "Empleado "+(i+1)+": "+ nombres[i] + ",salario:" + sueldos[i] + ", edad:" + edades[i]);
        }
        empleado1.calcularPromedioSalario();
        empleado1.calcularAumentoSalario();
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("DATOS CON SALARIO ACTUALIZADO");
        for(int i=0;i<n;i++){
            System.out.println(empleado1.toString(i));
        }
    }
}
    