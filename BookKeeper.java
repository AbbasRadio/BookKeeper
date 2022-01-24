import java.util.*;

class Node {
	int num,price,copies;
	String name,author,publisher;
    Node next;
    Node(int b_num,String b_name,String b_author,String b_publisher,int b_price,int b_copies)
    {
		num = b_num;
		name = b_name;
		author = b_author;
		publisher = b_publisher;
		price = b_price;
		copies = b_copies;
		next = null;
    }
}
class BookKeeper{
	// Inititalising head and Node class for creating new nodes
	Node head=null;	
    Scanner sc = new Scanner(System.in);
	public static func14 append(func14 list){
		int b_num,b_price,b_copies;
		String b_name, b_author, b_publisher;
		Scanner sc = new Scanner(System.in);
		try{
			System.out.print("\n\nEnter Book Number : ");
			b_num = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Book Name : ");
			b_name = sc.nextLine();
			System.out.print("Enter Book Author : ");
			b_author = sc.nextLine();
			System.out.print("Enter Book Publisher : ");
			b_publisher = sc.nextLine();
			System.out.print("Enter Book Price : ");
			b_price = sc.nextInt();
			System.out.print("Enter Number Of Copies of Book : ");
			b_copies = sc.nextInt();
			// Creating a node
			Node new_node = new Node(b_num,b_name,b_author,b_publisher,b_price,b_copies);
	        new_node.next = null;

	        // Check if node is empty then new node is head node
	        if (list.head == null) {
	            list.head = new_node;
	        }
	        // Insert or append the new node
	        else {
	            Node last = list.head;
	            while (last.next != null) {
	                last = last.next;
	            }
	            last.next = new_node;
	        }
		}
		catch (InputMismatchException e){
			// e.printStackTrace();
			System.out.println("Please Enter Correct Details in Respective Fields");
			System.out.println("Please Enter Again...\n");
			append(list);
		}

		
        System.out.println("Book Has Been Inserted Successfully\n");
	    // return printList(list);
	    return list;
	}
	public static func14 printList(func14 list)
    {
        Node currNode = list.head;    
        System.out.println("\n\nBook Details :- ");
        System.out.println("===================================================================================================================");
        int i=0;
        // loop until the whole linked list is searched or visited
        while (currNode != null) {
        	// print all values 
            System.out.println(++i+"=>>  Number : "+currNode.num + " >>  Name : "+currNode.name + " >>  Author : "+currNode.author + " >>  Publisher : "+currNode.publisher + " >>  Price : "+currNode.price+ " >>  Copies : "+currNode.copies);
            currNode = currNode.next;
        }
        System.out.println("\n===================================================================================================================");
        return list;
    }
	public static func14 printBookName(func14 list)
    {
        Node currNode = list.head;    
        System.out.println("\n\nBooks Available :- ");
        int i=0;
        // loop until the whole linked list is searched or visited
        while (currNode != null) {
        	// print all values 
        	if(currNode.copies > 0)
            	System.out.println(++i+"=>>  Number : "+currNode.num);
            currNode = currNode.next;
        }
        return list;
    }
    public static func14 issueBook(func14 list){
    	Scanner sc = new Scanner(System.in);
    	if(list.head == null){
    		System.out.println("Please Insert A Book First");
    		return list;
    	}
		String getChar,b_name;
		printBookName(list);
		// get name of book you want to issue
		System.out.print("\nEnter Name of The Book : ");
		b_name = sc.nextLine();
		Node currNode = list.head;
		// looping towards the end
		while(currNode != null){
			if(currNode.name.equals(b_name)){
				// Check if book is available or not
				if(currNode.copies > 0){
					int total = currNode.copies;
					System.out.println("\nBook is Available !");
					System.out.print("\nDo You Want To Issue This Book(Y/N) : ");
					getChar = sc.next();
					if(getChar.equals("y") || getChar.equals("Y")){
						System.out.println("\nBook Has Been Issued.");
						currNode.copies = total-1;
					}
				}else{
					System.out.println("\nBook is Out of Stock !");
					break;
				}
			}
			currNode = currNode.next;
		}
		// System.out.println("Thank You");
		return list;
	}
	public static func14 returnBook(func14 list){
		Scanner sc = new Scanner(System.in);
		String getChar,b_name;
		System.out.print("\nEnter Name of The Book : ");
		b_name = sc.nextLine();
		Node currNode = list.head;
		while(currNode != null){
			if(currNode.name.equals(b_name)){
				int total = currNode.copies;
				System.out.println("\nBook Found !\n");
				System.out.print("\nDo You Want To Return This Book(Y/N) : ");
				getChar = sc.next();
				if(getChar.equals("y") || getChar.equals("Y")){
					System.out.println("\nBook Has Been Returned.\n");
					currNode.copies = total+1;
				}				
			}else{
				System.out.println("No Book Found For This Name");
			}
			currNode = currNode.next;
		}
		// System.out.println("Thank You");
		return list;
	}
    public static void main(String args[]){
		func14 f = new func14();
		int n;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\n 1. INSERT BOOK \n 2. ISSUE A BOOK \n 3. RETURN A BOOK \n 4. DISPLAY ALL BOOK \n 5. EXIT");
			System.out.print(" ENTER YOUR CHOICE : ");
			n = sc.nextInt();
			switch(n){
				case 1 : f = append(f);break;
				case 2 : f = issueBook(f);break;
				case 3 : f = returnBook(f);break;
				case 4 : printList(f);break;
				default : System.exit(0);
			}
		}while(n != 5);
	}
}
