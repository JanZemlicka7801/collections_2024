package org.example;
public class ArrayList {

    private int [] data;
    private int numElements;
    private int capacity = 10;
    private int expansionFactor = 10;
    private static final int MAX_EXPANSION = 10000;
    private static final int MIN_EXPANSION = 0;
    private static final int MAX_INITIAL_CAPACITY = 10000;

    public ArrayList(int capacity){
        if (capacity <= MAX_INITIAL_CAPACITY && capacity > 0){
            this.capacity = capacity;
        } else if (capacity > MAX_INITIAL_CAPACITY) {
            this.capacity = MAX_INITIAL_CAPACITY;
        }
        data = new int[capacity];
    }

    public ArrayList(int capacity, int expansionFactor){
        if (capacity <= MAX_INITIAL_CAPACITY && capacity > 0){
            this.capacity = capacity;
        } else if (capacity > MAX_INITIAL_CAPACITY) {
            this.capacity = MAX_INITIAL_CAPACITY;
        }
        if(expansionFactor <= MAX_EXPANSION && expansionFactor > MIN_EXPANSION){
            this.expansionFactor = expansionFactor;
        } else if (expansionFactor > MAX_EXPANSION || expansionFactor < MIN_EXPANSION){
            this.expansionFactor = MAX_EXPANSION;
        }
        data = new int[capacity];
    }

    public ArrayList(){
        capacity = 10;
        data = new int[capacity];
    }

    public int size(){
        return numElements;
    }

    // Grow
    // create new array with X extra slots
    // loop through original array and copy to new array
    // Replace the original array with the new one
    private void grow(){
        int [] tempArray = new int[data.length + 10];
        for(int i = 0; i < data.length; i++){
            tempArray[i] = data[i];
        }

        data = tempArray;
    }

    public int get(int i){
        if(i < 0 || i >= data.length)
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds!");
        return data[i];
    }

    public void add(int num){
        if (numElements == data.length){
            grow();
            int [] duplicatedData = new int [data.length+expansionFactor];
            System.arraycopy(data, 5, data, 4, numElements - 5);
        }
        data[numElements] = num;
        numElements++;
    }

}
