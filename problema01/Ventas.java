package ventas;

import java.util.Scanner;


public class Ventas {

    private double precioProducto;
    private int productos;
    private double descuento;
    private double precioFinal;

    public Ventas(int productos, double precioProducto) {
        this.productos = productos;
        this.precioProducto = precioProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public double getDescuento() {
        return descuento;
    }

    public void CalcularDescuento() {

        if (this.precioProducto >= 1000 && this.productos >= 10) {
            this.descuento = this.precioProducto * 0.10;
        } else if (this.precioProducto < 1000) {
            this.descuento = this.precioProducto * 0.05;
        }
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void CalcularPrecioFinal() {
        this.precioFinal = precioProducto - descuento;
    }

    @Override
    public String toString() {
        return String.format("Ventas"
                + "\nCantidad de productos: %d"
                + "\nPrecio de productos: %.2f"
                + "\nDescuento(dependiendo de la cantidad de productos): %.2f"
                + "\nPrecio Final: %.2f",
                this.getProductos(),
                this.getPrecioProducto(),
                this.getDescuento(),
                this.getPrecioFinal());

    }
}

class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de productos y su precio: ");
        Ventas venta1 = new Ventas(sc.nextInt(), sc.nextDouble());
        venta1.CalcularDescuento();
        venta1.CalcularPrecioFinal();
        System.out.println(venta1);
    }
}