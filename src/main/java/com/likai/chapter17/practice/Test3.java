package com.likai.chapter17.practice;

/**
 * 链表
 * @param <E>
 */
class SList<E> {
    private Link<E> headLink = new Link<E>(null) ;
    SListIterator<E> iterator() {
        return new SListIterator<E>(headLink) ;
    }

    public String toString() {
        if(headLink.next == null) {
            return "SList: []" ;
        }
        System.out.print("SList: [");
        SListIterator<E> it = this.iterator() ;
        StringBuilder sb = new StringBuilder() ;
        while (it.hasNext()) {
            sb.append(it.next() + (it.hasNext()? ", " : "")) ;
        }

        return sb.toString() + "]" ;
    }
}

class SListIterator<E> {
    Link<E> current ;

    SListIterator(Link<E> link) {
        this.current = link ;
    }

    public boolean hasNext() {
        return current.next != null ;
    }

    public Link<E> next() {
        current = current.next ;
        return current ;
    }

    public void add(E e) {
        current.next = new Link<E>(e,current.next) ;
        current = current.next ;
    }

    public void remove() {
        if(current.next != null) {
            current.next = current.next.next ;
        }
    }
}
class Link<E> {
    E e ;
    Link<E> next ;
    Link(E e,Link<E> next) {
        this.e = e ;
        this.next = next ;
    }

    Link(E e) {
        this(e,null) ;
    }

    public String toString() {
        if(e == null) {
            return null ;
        } else {
            return e.toString() ;
        }
    }
}
public class Test3 {

    public static void main(String [] args) {
        SList<String> s1 = new SList<String>() ;
        System.out.println(s1);

        SListIterator<String> it1 = s1.iterator() ;
        it1.add("hello");

        System.out.println(s1);
    }

}
