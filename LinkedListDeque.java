/**
 * Created by efetoros on 1/31/17.
 */


public class LinkedListDeque<Item> implements Deque<Item> {


    private class Naked {
        private  Item item;
        private Naked next;
        private Naked previous;

        Naked(Item i, Naked n, Naked p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private Naked sentinal;
    private int size;

    @Override
    public int size() {
        return size;
    }

    public LinkedListDeque() {
        sentinal = new Naked(null, null, null);
        sentinal.next = sentinal;
        sentinal.previous = sentinal;
        size = 0;
    }

    /**
     * Adds an item to the front of the Deque
     */

    @Override
    public void addFirst(Item thing) {
        if (sentinal.next == null) {
            sentinal.next = new Naked(thing, sentinal, sentinal);
            sentinal.previous = sentinal.next;
        } else {
            Naked oldNext = sentinal.next;
            sentinal.next = new Naked(thing, oldNext, sentinal);
            oldNext.previous = sentinal.next;
        }
        size = size + 1;
    }

    /**
     * Adds an item to the front of the Deque
     */
    @Override
    public void addLast(Item thing) {

        if (sentinal.previous == null) {
            sentinal.previous = new Naked(thing, sentinal, sentinal);
            sentinal.next = sentinal.previous;
        } else {
            Naked oldPrev = sentinal.previous;
            sentinal.previous = new Naked(thing, sentinal, oldPrev);
            oldPrev.next = sentinal.previous;
        }
        size = size + 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    @Override
    public void printDeque() {
        Naked node = sentinal;
        while (node.next != sentinal) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
    }

    @Override
    public Item removeFirst() {
        if (sentinal.next.item == null) {
            return null;
        }
        Item deleted = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.previous = sentinal;
        size = size - 1;
        return deleted;
    }

    @Override
    public Item removeLast() {
        if (sentinal.previous.item == null) {
            return null;
        }
        Item deleted = sentinal.previous.item;
        sentinal.previous = sentinal.previous.previous;
        sentinal.previous.next = sentinal;
        size = size - 1;
        return deleted;
    }

    @Override
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Naked node = sentinal.next;
        while (index != 0) {
            node = node.next;
            index = index - 1;
        }
        return node.item;
    }

    private Item keeptrack(int index, Naked node) {
        if (index == 0) {
            return node.item;
        }
        return keeptrack(index - 1, node.next);
    }

//    @Override
//    public Item getRecursive(int index) {
//        if (index < 0 || index >= size) {
//            return null;
//        }
//        return keeptrack(index, sentinal.next);
//    }


}


