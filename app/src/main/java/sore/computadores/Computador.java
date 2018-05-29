package sore.computadores;

/**
 * Created by android on 28/05/2018.
 */

public class Computador {
    private String id, marca, color, tipo, SO;
    private int ram, foto;

    public Computador() {

    }

    public Computador(String id, String marca, String color, String tipo, String SO, int ram, int foto) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;
        this.SO = SO;
        this.ram = ram;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }
}
