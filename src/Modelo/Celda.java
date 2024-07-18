package Modelo;

import java.util.Objects;

public class Celda {

    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void toogleEstado(){
        
    }

    /*int row;
    int col;

    public Celda(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return row == celda.row && col == celda.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Celda{" + "row=" + row + ", col=" + col + '}';
    }*/
}
