package sort;

public class InsertSort {
    private int[] array;
    private int length;

    public InsertSort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public void display(){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    /*
     * 插入排序方法
     */
    public void doInsertSort(){
        for (int i = 1;i<length;i++){
            int temp = array[i];
             int index = i-1;
            while(index>=0&&array[index]>temp){
                array[index+1] = array[index];
                index --;
            }
            array[index+1] = temp;
        }
    }
    public static void main(String[] args){
        int[] array = {38,65,97,76,13,27,49};
        InsertSort is = new InsertSort(array);
        System.out.println("排序前的数据为：");
        is.display();
        is.doInsertSort();
        System.out.println("排序后的数据为：");
        is.display();
    }
}
