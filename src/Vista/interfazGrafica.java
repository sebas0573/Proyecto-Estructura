package Vista;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import Controlador.Laberinto;

public class interfazGrafica extends Frame {
    private Laberinto laberinto;
    private List<Point> path;
    private final int cellSize = 20;

    public interfazGrafica(Laberinto laberinto, List<Point> path) {
        this.laberinto = laberinto;
        this.path = path;
        setSize(laberinto.getM() * cellSize, laberinto.getN() * cellSize);
        setTitle("Laberinto");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        int[][] grid = laberinto.getGrid();
        for (int x = 0; x < laberinto.getN(); x++) {
            for (int y = 0; y < laberinto.getM(); y++) {
                if (grid[x][y] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(y * cellSize, x * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(y * cellSize, x * cellSize, cellSize, cellSize);
            }
        }

        g.setColor(Color.GREEN);
        for (Point p : path) {
            g.fillRect(p.y * cellSize, p.x * cellSize, cellSize, cellSize);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };
        Laberinto laberinto = new Laberinto(grid);
        laberinto.setStart(new Point(0, 0));
        laberinto.setEnd(new Point(4, 4));
        Busqueda busqueda = new Busqueda(laberinto);
        List<Point> path = busqueda.bfs();
        new interfazGrafica(laberinto, path);
    }
}