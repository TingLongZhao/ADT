package list;

import java.util.Arrays;
import java.util.Date;

public class MyList<E> {
    private Object[] data = null;
    private int length = 0;
    private int current; //实际表长
    public MyList(){
        this(10);
    }
    public MyList(int initialSize){
        if(initialSize >= 0){
            this.length = initialSize; //设置线性表容量
            this.data = new Object[initialSize]; //初始化数组
            this.current = 0; //下标设置为0

        }else{
            throw new RuntimeException("初始化大小不能小于0:" + initialSize); //异常提示
        }
    }

    /**
     * 在线性表末尾添加元素,添加之前判断线性表是否已经满了
     * @param e
     * @return
     */
    public boolean add(E e){
        //判断是否已满
        ensureCapacity();
        //将元素添加到数组末尾
        this.data[current++] = e;
        return true;
    }
    /**
     * 判断表容量是否超出预定大小，如果超出将自动扩充容量
     */
    public void ensureCapacity(){
        if(current>=length){
            length *= 2;
            data = Arrays.copyOf(data,length);
        }
    }

    /**
     *
     * @param index
     * @return
     */
    public boolean removeToIndex(int index){
        if(index >= current){
            System.err.print(new Date() + ": 下标超出表长");
            return false;
        }
        for (int i = index; i < current - 1; i++){
            data[i] = data[i+1];
        }
        data[current-1] = null;
        --current;
        return true;
    }

    /**
     * 根据下标返回元素值
     * @param index
     * @return
     */
    public E get(int index){
        if(index >= 0){
            return (E) data[index];
         }else {
            throw new RuntimeException("下标不能小于0:" + index);
       }
    }
    public int size(){
        return this.current;
    }
    public int length(){
        return this.length;
    }
    public boolean isEmpty(){
        return current == 0;
    }
    //主方法测试
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>(); //创建arrayList
        for (int i = 1; i <= 22; i++) {
            list.add(i);
        }
        list.removeToIndex(0);
//        list.removeToIndex(list.size());
        //遍历list数组
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
