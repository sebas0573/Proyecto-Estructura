package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Laberinto {

    private Celda[][] celdas;
    private int ancho;
    private int alto;

    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Laberinto(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    public Celda[][] getCeldas() {
        return celdas;
    }
    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }

    //public Celda getCelda(int row, int col){

    //}
    public void toogleCelda(int row, int col){

    }
    

    



    /*public List<Celda> getPath(boolean[][] grid) {
        List<Celda> path = new ArrayList<>();
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }

        Map<Celda, Boolean> cache = new HashMap<>();
        if (getPath(grid, 0, 0, path, cache)) {
            Collections.reverse(path); 
            return path;
        }

        return new ArrayList<>();
    }

    private boolean getPath(boolean[][] grid, int row, int col, List<Celda> path, Map<Celda, Boolean> cache) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        Celda point = new Celda(row, col);
        if (cache.containsKey(point)) {
            return cache.get(point);
        }

        boolean isAtEnd = (row == grid.length - 1 && col == grid[0].length - 1);
        boolean success = false;
        if (isAtEnd || 
            getPath(grid, row + 1, col, path, cache) || // abajo
            getPath(grid, row - 1, col, path, cache) || // arriba
            getPath(grid, row, col + 1, path, cache) || // derecha
            getPath(grid, row, col - 1, path, cache)) { //izquierda
            path.add(point);
            success = true;
        }

        cache.put(point, success);
        return success;
    }*/
    
}
