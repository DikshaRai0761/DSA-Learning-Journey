import java.util.*;

class FrontMiddleBackQueue {

    LinkedList<Integer> list;

    public FrontMiddleBackQueue() {
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        int index = list.size() / 2;
        list.add(index, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.removeFirst();
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }

        int index = (list.size() - 1) / 2;
        return list.remove(index);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.removeLast();
    }
}