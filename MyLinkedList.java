public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if (size==0){
      Node n = new Node(value);
      start = n;
      end = n;
      size++;
    }
    else {
      Node n = new Node(value);
      n.setPrev(end);
      end.setNext(n);
      end = n;
      size++;
    }
    return true;
  }

  public void add(int index, String value){
    if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index" + index + "is out of bounds.");
    else if (size()==0) add(value);
    else if (index==size()){
      Node n = new Node(value);
      n.setNext(null);
      n.setPrev(end);
      end.setNext(n);
      end = n;
      size++;
    }
    else if (index==0){
      Node n = new Node(value);
      n.setNext(start);
      start.setPrev(n);
      start = n;
      size++;
    }
    else {
      Node current = start;
      for (int i=0; i<index; i++){
	current = current.getNext();
      }
      Node n = new Node(value);
      //setting up links
      n.setNext(current);
      n.setPrev(current.getPrev());
      current.getPrev().setNext(n);
      current.setPrev(n);
      size++;
    }
  }

  public String get(int index){
    if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index" + index + "is out of bounds.");
    else{
      Node current = start;
      for (int i=0; i<index; i++){
	current = current.getNext();
      }
      return current.getData();
    }
  }

  public String set(int index, String value){
    if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index" + index + "is out of bounds.");
    else{
      Node current = start;
      for (int i=0; i<index; i++){
	current = current.getNext();
      }
      String temp = current.getData();
      current.setData(value);
      return temp;
    }
  }

  public String toString(){
    String s = "";
    Node current = start;
    s += "[";
    while (current != null){
      if (current != start) s += ", ";
      s += current.getData();
      current = current.getNext();
    }
    s += "]";
    return s;
  }

  public String remove(int index){
    if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index" + index + "is out of bounds.");
    else if (index==0){
      (start.getNext()).setPrev(null);
      start.setNext(null);
      start = start.getNext();
      return "wow";  //placeholder
    }
    else {
      Node current = start;
      for (int i=0; i<index; i++){
	current = current.getNext();
      }
      (current.getPrev()).setNext(current.getNext());
      (current.getNext()).setPrev(current.getPrev());
      current.setPrev(null);
      current.setNext(null);
      return current.getData();
    }
  }

}
