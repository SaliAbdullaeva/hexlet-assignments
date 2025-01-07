package exercise;

class SafetyList {
    // BEGIN
    private int[] elementData = new int[10];
    private int size = 0;

    public synchronized void add(int number) {
        if (size + 1 >= elementData.length) {
            int oldCapacity = elementData.length;
            int newSize = (oldCapacity * 3) / 2 + 1;
            int[] oldData = elementData;
            elementData = new int[newSize];
            System.arraycopy(oldData, 0, elementData, 0, size);
        }
        elementData[size++] = number;
    }

    public int get(int index) {
        return elementData[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
