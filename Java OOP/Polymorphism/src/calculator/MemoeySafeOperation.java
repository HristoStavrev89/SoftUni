package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemoeySafeOperation implements Operation {
    private Deque<Integer> memory;

    public MemoeySafeOperation(Deque<Integer> memory) {
        this.memory = memory;
    }




    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
