package velykyi.vladyslav.introduction;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

@SuppressWarnings("unused")
public class Sequence {

    @NotThreadSafe
    static class UnsafeSequence {
        private int value;

        /*
        Thread 1: value -> 9 ->- 9 + 1 = 10
        Thread 2: value -> 9 ->- 9 + 1 = 10

        Result = 10, instead of 11;
         */
        public int getNext() {
            return value++;
        }
    }

    @ThreadSafe
    static class SafeSequence {
        @GuardedBy("this") private int nextValue;

        public synchronized int getNext() {
            return nextValue++;
        }
    }
}
