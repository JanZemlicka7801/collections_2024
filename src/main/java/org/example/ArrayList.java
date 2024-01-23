package org.example;
public class ArrayList {

    private int fixed;
    private int[] data;
    private int num_elements;

    public void List(){
        fixed = 10;
        data = new int[10];
    }

    public void List(int growValue){
        fixed = growValue;
        data = new int[10];
    }

    public int size(){
        return num_elements;
    }

    public void add(int number){
        if(num_elements == data.length){
            grow();
        }
        data[num_elements] = number;
        num_elements++;
    }

    private int[] grow(){
        int[] junk = new int[data.length + fixed];

        for(int i = 0; i < data.length; i++){
            junk[i] = data[i];
        }

        data = junk;

        return data;
    }
}
