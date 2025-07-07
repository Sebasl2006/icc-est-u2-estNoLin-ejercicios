package main;

import java.util.List;

import main.Ejercicio_01_insert.insertBST;
import main.Ejercicio_02_invert.invertirBinary;
import main.Ejercicio_03_listLeves.listLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;
import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ





        demonstrateInsertBST();
        demonstrateInvertTree();
        demonstrateListLevels();
        demonstrateTreeDepth();
    }
    
    private static void demonstrateInsertBST() {
        System.out.println(" ------------INSERTAR EN ARBOL BST---------");
    
        int[] input = {5, 3, 7, 2, 4, 6, 8};
        System.out.println("Entrada:");
        System.out.print("[");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            if (i < input.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        insertBST bst = new insertBST();
        Node root = null;
        for (int value : input) {
            root = bst.insert(root, value);
        }
    
        System.out.println("Salida:");
        printTreeHorizontal(root);
    }
    
    private static void demonstrateInvertTree() {
        System.out.println("----------- INVERTIR ARBOL BINARIO--------------");
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));
        
        System.out.println("Entrada:");
        printTreeHorizontal(root);
        
        invertirBinary inverter = new invertirBinary();
        Node inverted = inverter.invertTree(root);
        
        System.out.println("Salida:");
        printTreeHorizontal(inverted);
    }
    
    private static void demonstrateListLevels() {
        System.out.println("---------------LISTAR NIVELES---------------");
        
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));
        
        System.out.println("Entrada:");
        printTreeHorizontal(root);
       
        listLevels listLevels = new listLevels();
        List<List<Node>> levels = listLevels.listLevels(root);
        
        System.out.println("Salida:");
        for (int i = 0; i < levels.size(); i++) {
            System.out.print("Nivel " + i + " = " );
            for (Node node : levels.get(i)) {
                System.out.print(node.getValue() + " - ");
            }
            System.out.println();
        }
    }
    
    private static void demonstrateTreeDepth() {
        System.out.println("--------------- CALCULAR PROFUNDIDAD------------------");
    
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getLeft().getLeft().setLeft(new Node(8));
        
        System.out.println("Entrada:");
        printTreeHorizontal(root);
       
        Depth depthCalculator = new Depth();
        int depth = depthCalculator.maxDepth(root);
        
        System.out.println("Salida: " + depth);
    }
    
    private static void printTreeHorizontal(Node node) {
        if (node == null) return;
        
        System.out.println(node.getValue());
        printChildren(node, "");
    }
    
    private static void printChildren(Node node, String prefix) {
        if (node == null) return;
        
        if (node.getLeft() != null || node.getRight() != null) {
            if (node.getRight() != null) {
                System.out.print(prefix + "├── ");
                System.out.println(node.getRight().getValue());
                printChildren(node.getRight(), prefix + "│   ");
            }
            
            if (node.getLeft() != null) {
                System.out.print(prefix + "└── ");
                System.out.println(node.getLeft().getValue());
                printChildren(node.getLeft(), prefix + "    ");

            }
        }

        System.out.println("Sebastian Lopez");
    }
   
    }


