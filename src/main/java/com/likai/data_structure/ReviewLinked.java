package com.likai.data_structure;

class ReviewNode {
    int data ;
    ReviewNode next ;
    public ReviewNode() {
        super();
    }
    public ReviewNode(int data) {
        this.data = data ;
    }

    public void display() {
        System.out.println(this.data + ",");
    }
}
public class ReviewLinked {

    private ReviewNode first ;

    public ReviewLinked() {
        super();
    }

    public void addFirst(int data) {
        if(this.first == null) {
            this.first = new ReviewNode(data) ;
            return ;
        }

        ReviewNode node = this.first ;
        this.first = new ReviewNode(data) ;
        this.first.next = node ;
    }

    public ReviewNode removeFirst() {
        if(this.first == null) {
            return null ;
        }
        ReviewNode node = this.first ;
        this.first = this.first.next ;

        return node ;
    }

    public void addLast(int data) {
        if(this.first == null) {
            this.first = new ReviewNode(data) ;
            return ;
        }
        ReviewNode current = this.first ;
        while (current.next != null) {
            current = current.next ;
        }

        current.next = new ReviewNode(data) ;

    }

    public ReviewNode removeLast() {
        if(this.first == null) {
            return null ;
        } else if(this.first.next == null) {
            ReviewNode node = this.first ;
            this.first = null ;
            return node ;
        } else {
            ReviewNode previous = null ;
            ReviewNode current = this.first ;
            while (current.next != null) {
                previous = current ;
                current = current.next ;
            }

            previous.next = null ;
            return current ;
        }
    }

    public ReviewNode get(int data) {
        if(this.first == null) {
            return null ;
        }
        ReviewNode current = this.first ;
        while(current.data != data) {
            current = current.next ;
            if(current == null) {
                return null ;
            }
        }
        return current ;
    }

    public ReviewNode remove(int data) {
        if(this.first == null) {
            return null ;
        }
        ReviewNode current = this.first ;
        ReviewNode previous = null ;
        while (current.data != data) {
            previous = current ;
            current = current.next ;
            if (current == null) {
                return null ;
            }
        }

        if(this.first.data == data) {
            ReviewNode node = this.first ;
            this.first = this.first.next ;
            return node ;
        } else {
            previous.next = current.next ;
            return current ;
        }
    }

    public void display() {
        if(this.first == null) {
            return ;
        }
        ReviewNode current = this.first ;
        while(current != null) {
            current.display();
            current = current.next ;
        }
    }

    public static void main(String [] args) {
        ReviewLinked reviewLinked = new ReviewLinked() ;
        reviewLinked.addFirst(4);
        reviewLinked.addFirst(3);
        reviewLinked.addFirst(1);
        reviewLinked.addFirst(7);
        reviewLinked.addFirst(5);
        reviewLinked.addFirst(9);

        reviewLinked.removeFirst() ;

        reviewLinked.addLast(6);

        reviewLinked.removeLast();

        reviewLinked.display();

        System.out.println(reviewLinked.get(4).data);

        System.out.println(reviewLinked.remove(4).data);

        reviewLinked.display();
    }

}