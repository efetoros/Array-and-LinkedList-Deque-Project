/**
 * Created by efetoros on 2/1/17.
 */

public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    /**
     * Resizes the underlying array to the target capacity.
     */

    private void resize(int capacity, int x) {


        int startingPosition = items.length - (nextFirst + 1);
        Item[] copy = (Item[]) new Object[capacity];
        if (x == 1) {
            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst + 1, copy, 0, size);
            } else {
                System.arraycopy(items, nextFirst + 1, copy, 0, startingPosition);
                System.arraycopy(items, 0, copy, startingPosition, size - startingPosition);
            }
        }
        if (x == 0) {
            if (nextFirst + 1 == items.length) {
                System.arraycopy(items, 0, copy, 0, size);
            } else {
                System.arraycopy(items, nextFirst + 1, copy, 0, startingPosition);
                System.arraycopy(items, 0, copy, startingPosition, size - startingPosition);
            }
        }

        items = copy;
        nextFirst = items.length - 1;
        nextLast = size;


    }
    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x) {
        if (size == items.length) {

            resize(size * 2, 0);
        }

        items[nextLast] = x;
        if (nextLast + 1 == items.length) {
            nextLast = 0;
        } else {
            nextLast = nextLast + 1;
        }

        size = size + 1;
    }

    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2, 0);
        }

        items[nextFirst] = x;
        if (nextFirst - 1 == -1) {
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
        size = size + 1;
    }

    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Item removeLast() {
        int index = nextLast - 1;
        if (size == 0) {
            return null;
        }
        if (index == -1) {
            index = items.length - 1;
        }
        nextLast = index;
        Item x = items[index];
        size = size - 1;
        Integer nume = new Integer(size);
        Integer denom = new Integer(items.length);
        float ratio =  nume.floatValue() / denom.floatValue();
        if (ratio <= .25 && items.length > 16) {
            resize(items.length / 2, 1);
        }
        return x;
    }

    public Item removeFirst() {
        int index = nextFirst + 1;
        if (size == 0) {
            return null;
        }
        if (index == items.length) {
            index = 0;
        }
        nextFirst = index;
        Item x = items[index];
        size = size - 1;
        Integer nume = new Integer(size);
        Integer denom = new Integer(items.length);
        float ratio =  nume.floatValue() / denom.floatValue();
        if (ratio <= .25 && items.length > 16) {
            resize(items.length / 2, 1);
        }
        return x;

    }

    public void printDeque() {
        while (nextFirst + 1 != items.length) {
            System.out.print(items[nextFirst++] + " ");
        }
        while (nextLast != 0) {
            System.out.print(items[nextLast--] + " ");
        }
    }
    @Override
    public Item get(int index) {
        int first = nextFirst + 1;
        if (first == items.length) {
            first = 0;
        }
        if (first + index < items.length) {
            return items[first + index];
        }
        return items[(first + index) % items.length];


    }

//    public static void main (String[] args) {
//        ArrayDeque<Integer> myArray = new ArrayDeque<>();
//        myArray.addFirst(0);
//        myArray.addFirst(1);
//        myArray.addFirst(2);
//        myArray.addFirst(3);
//        myArray.addFirst(4);
//        myArray.addFirst(5);
//        myArray.addFirst(6);
//        myArray.addFirst(7);
//        myArray.addFirst(8);
//        myArray.addFirst(9);
//        myArray.addFirst(10);
//        myArray.addFirst(11);
//        myArray.addFirst(12);
//        myArray.addFirst(13);
//        myArray.addFirst(14);
//        myArray.addFirst(15);
//        myArray.addFirst(16);
//        myArray.addFirst(17);
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//        myArray.removeFirst();
//
//        myArray.printDeque();
//    }

}









