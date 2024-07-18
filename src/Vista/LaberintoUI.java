package Vista;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.*;
import java.awt.event.*;

public class LaberintoUI extends Frame {
    private int[][] maze;
    private TextField startRowField, startColField, endRowField, endColField;
    private TextArea mazeArea;
    private Button solveButton;

    public LaberintoUI() {
        setTitle("Maze Solver");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel de configuración
        Panel configPanel = new Panel();
        configPanel.setLayout(new GridLayout(2, 4, 10, 10));
        configPanel.setBackground(new Color(224, 224, 224));
        configPanel.setFont(new Font("Arial", Font.PLAIN, 14));

        configPanel.add(createLabeledField("Start Row:", startRowField = new TextField()));
        configPanel.add(createLabeledField("Start Col:", startColField = new TextField()));
        configPanel.add(createLabeledField("End Row:", endRowField = new TextField()));
        configPanel.add(createLabeledField("End Col:", endColField = new TextField()));

        solveButton = new Button("Solve");
        solveButton.setBackground(new Color(0, 123, 255));
        solveButton.setForeground(Color.WHITE);
        solveButton.setFont(new Font("Arial", Font.BOLD, 14));
        solveButton.addActionListener(new SolveButtonListener());
        configPanel.add(new Label(""));
        configPanel.add(solveButton);
        configPanel.add(new Label(""));

        add(configPanel, BorderLayout.NORTH);

        // Área de texto para el laberinto
        mazeArea = new TextArea();
        mazeArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mazeArea.setBackground(new Color(248, 248, 248));
        add(mazeArea, BorderLayout.CENTER);

        // Manejo del cierre de la ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Mejorar la apariencia
        setVisible(true);
    }

    private Panel createLabeledField(String labelText, TextField textField) {
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        Label label = new Label(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private class SolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener las coordenadas de inicio y fin
            int startRow = Integer.parseInt(startRowField.getText());
            int startCol = Integer.parseInt(startColField.getText());
            int endRow = Integer.parseInt(endRowField.getText());
            int endCol = Integer.parseInt(endColField.getText());

            // Leer y procesar el laberinto desde el área de texto
            String[] lines = mazeArea.getText().split("\n");
            int rows = lines.length;
            int cols = lines[0].length();
            maze = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maze[i][j] = lines[i].charAt(j) == '1' ? 1 : 0;
                }
            }

            // Resolver el laberinto (implementar los métodos de búsqueda aquí)
            boolean pathFound = findPath(startRow, startCol, endRow, endCol);

            // Mostrar el resultado
            Dialog resultDialog = new Dialog(LaberintoUI.this, "Resultado", true);
            resultDialog.setLayout(new FlowLayout());
            resultDialog.setSize(300, 100);
            resultDialog.add(new Label(pathFound ? "¡Solución encontrada!" : "No se encontró solución."));
            Button okButton = new Button("OK");
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultDialog.setVisible(false);
                }
            });
            resultDialog.add(okButton);
            resultDialog.setVisible(true);
        }
    }

    private boolean findPath(int startRow, int startCol, int endRow, int endCol) {
        if (maze[startRow][startCol] == 1 || maze[endRow][endCol] == 1) {
            return false;
        }

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == endRow && col == endCol) {
                return true;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length &&
                        !visited[newRow][newCol] && maze[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false;
    }

}