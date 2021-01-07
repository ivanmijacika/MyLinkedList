public class Node{
  public Node(String value){
    data = value;
  }
  private String data;
  private Node next,prev;

  public String getData(){
    return data;
  }

  public void setData(String data){
    this.data = data;
  }

  public Node getNext(){
    return next;
  }

  public void setNext(Node next){
    this.next = next;
  }

  public Node getPrev(){
    return prev;
  }

  public void setPrev(Node Prev){
    this.prev = prev;
  }
}
