/**
 * Created by efetoros on 2/8/17.
 */
public interface Deque<Item> {


    void addLast(Item x);



    Item get(int i);


    int size();


    Item removeLast();

    Item removeFirst();



    void addFirst(Item x);



    void printDeque();





}
