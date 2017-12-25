/**
 * Created by efetoros on 2/8/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    StudentArrayDeque<Integer> arrayTest = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> arraySolution = new ArrayDequeSolution<>();
    OperationSequence end = new OperationSequence();
    @Test
    public void testDeque() {
        Integer i = 0;
        while (true) {
            Integer number = StdRandom.uniform(3);

            if (number == 0) {
                arrayTest.addLast(i);
                arraySolution.addLast(i);
                end.addOperation(new DequeOperation("addLast", i));
            }
            if (number == 1) {
                arrayTest.addFirst(i);
                arraySolution.addFirst(i);
                end.addOperation(new DequeOperation("addFirst", i));
            }
            if (number == 2) {
                Integer student = arrayTest.removeLast();
                Integer solution = arraySolution.removeLast();
                end.addOperation(new DequeOperation("removeLast"));
                assertEquals(end.toString(), solution, student);
            }
            if (number == 3) {
                Integer student = arrayTest.removeFirst();
                Integer solution = arraySolution.removeFirst();
                end.addOperation(new DequeOperation("removeFirst"));
                assertEquals(end.toString(), solution, student);
            }
            i = i + 1;
        }
    }

}


