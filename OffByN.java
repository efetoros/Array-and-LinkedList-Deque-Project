/**
 * Created by efetoros on 2/8/17.
 */
public class OffByN implements CharacterComparator {
    private int offby;

    public OffByN(int n) {
        offby = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return ((x - y) == offby || (x - y) == -offby);
    }
}
