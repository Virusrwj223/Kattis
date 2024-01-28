import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class binarySearchTree{
  private class Node{
    private int key;
    private Node left, right;
    private int N;
    public Node(int key, int N){
      this.key = key;
      this.N = N;
    }
  }

  private Node root;
  private int counter;

  public int size(){
    return size(root);
  }
  public int size(Node x){
    if(x == null){
      return 0;
    }else{
      return x.N;
    }
  }

  public void put(int key){
    root = put(root, key);
  }
  private Node put(Node x, int key){
    if(x==null){
      return new Node(key,0);
    }
    if(key < x.key){
      x.left = put(x.left, key);
      counter += 1;
    }else if(key > x.key){
      x.right = put(x.right, key);
      counter += 1;
    }else{
      x.key = key;
      counter += 1;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public static void main(String[] args){
  
      //File myObj = new File("binarySearchTree.txt");
      Scanner myReader = new Scanner(System.in);
      String firstLine = myReader.nextLine();
      firstLine.trim();
      int loops = Integer.parseInt(firstLine);
      binarySearchTree bst = new binarySearchTree();
      int counter = 0;
      for (int i = 0; i < loops; i++){
        String nextLine = myReader.nextLine();
        nextLine.trim();
        int key = Integer.parseInt(nextLine);
        bst.put(key);
        System.out.println(bst.counter);
      }

    
  }

}
