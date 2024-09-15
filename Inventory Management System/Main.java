import java.util.*;


class Node{
    int id;
    String name;
    int quantity;
    int price;
    Node next;
    Node prev;
    Node(int id,  String name, int quantity, int price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price =price;
        this.next = null;
        this.prev =  null;
    }
}
 class Inventory{
    Scanner sc = new Scanner(System.in);
    Node head;

    Inventory(){
        Node head = null;
    }
    void Add(){
        System.out.println("Enter the id: ");
        int id= sc.nextInt();
        System.out.println("Enter the name");
        String name = sc.next();
        System.out.println("enter Quantity");
        String quantity = sc.next();
        System.out.println("Enter price");
        int price = sc.nextInt();

        Node new_node = new Node(id, name, id, price);
        if(head == null){
            head = new_node;
            return;
        }
        head.prev  = new_node;
        new_node.next =head;
        head = head.prev; 
    }
    void Display(){
        if (head ==null){
            System.out.println("Inventory is empty");

        }
        Node current = head;
        while(current!=null){
            System.out.println("{" + current.id+ " " + current.name+ " " + current.price+ " "+ current.quantity+ " }"+ " -->" );
            current =  current.next;
        }

    }
    void Update(){
        System.out.println("Enter id of product");
        int pid = sc.nextInt();
        Node current = head;
        while(current.id!=pid && current!= null){
            current = current.next;
        }
        System.out.println("Enter the values to update");
        System.out.println("Enter the name");
        current.name = sc.next();
        System.out.println("Enter the Quantity");
        current.quantity = sc.nextInt();
        System.out.println("Enter the price");

        current.price = sc.nextInt();
        System.out.println("product is updated");

    }
    void Search(){
        System.out.println("Enter name of product");
        String pname = sc.next();
        Node current = head;
        while( !current.name.equals(pname) && current!= null){
            current = current.next;
        }
        if(current==null){
            System.out.println("invalid input");
            
        }
        else{
            System.out.println("{" + current.id + " " + current.name + " " + current.price + "  " + current.quantity +" }");
        }

    }
    void Delete(){
        System.out.println("Enter id of product");
        int pid = sc.nextInt();
        Node current = head;
        while(current.id!=pid && current!= null){
            current =  current.next;
        }
        if(current == null){
            System.out.println("product not found");
            return;
        }
        if(current==head){
            head=current.next;
            if(head!=  null){
                head.prev = null;
            }

        }
        else{
            if(current.prev!= null){
                current.prev.next = current.next;
            }
            if(current.next!= null){
                current.next.prev = current.prev;

            }
        }
        System.out.println(" Product is deleted");
        
    }
    void menu(){
        System.out.println("1. Add Products");
        System.out.println("2. Display Products");
        System.out.println("3. Delete Product");
        System.out.println("4.Update Product");
        System.out.println("5. Search Product");
        System.out.println("6.Exit");
    }


}   




public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        Inventory obj =  new Inventory();
        while(true){
            obj.menu();
            System.out.println("Enter the choice");
            int ch = sc.nextInt();
            switch(ch){

                case 1:
                    obj.Add();
                    break;
                case 2:
                    obj.Display();
                    break;
                case 3:
                    obj.Delete();
                    break;

                case 4:
                    obj.Update();
                    break;
                case 5:
                    obj.Search();
                    break;
                case 6:
                     System.out.println("Exiting...");
                     return;
                default:
                    System.out.println("enter valid choice");
                    break;

            }


        }
    }
}
