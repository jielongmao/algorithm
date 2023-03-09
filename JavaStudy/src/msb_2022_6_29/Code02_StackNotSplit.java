package msb_2022_6_29;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 来自微软
// 请设计一种叫做“栈的管理器”的结构，实现如下6个功能
// 1) void createNewStack() : 可以在该结构中生成一个栈结构，编号从0开始
// 2) void push(int num, int stackIndex) : 将编号为stackIndex的栈里，压入num
// 3) int pop(int stackIndex) : 从编号为stackIndex的栈里，弹出栈顶返回
// 4) int peek(int stackIndex) ：从编号为stackIndex的栈里，返回栈顶但是不弹出
// 5) boolean isEmpty(int statckIndex)：返回编号为stackIndex的栈是否为空
// 6) int stackSize() : 返回一共生成了多少个栈
// 要求：不管用户调用多少次上面的方法，只使用有限几个动态数组(常数个)，完成代码实现
public class Code02_StackNotSplit {

    public static class Stacks1 {

        public ArrayList<Stack<Integer>> stacks;

        public Stacks1() {
            stacks = new ArrayList<>();
        }

        public int stackSize() {
            return stacks.size();
        }

        public void createNewStack() {
            stacks.add(new Stack<>());
        }

        public void push(int num, int stackIndex) {
            stacks.get(stackIndex).push(num);
        }

        public int pop(int stackIndex) {
            return stacks.get(stackIndex).pop();
        }

        public boolean isEmpty(int statckIndex) {
            return stacks.get(statckIndex).isEmpty();
        }

        public int peek(int stackIndex) {
            return stacks.get(stackIndex).peek();
        }

    }

    public static class Stacks2 {
        public ArrayList<Integer> heads;
        public ArrayList<Integer> values;
        public ArrayList<Integer> lasts;
        public ArrayList<Integer> frees;
        // occupySize : 值数组用到哪了？
        public int occupySize;
        // freeSize : 垃圾区的大小（最先用！）
        public int freeSize;

        public Stacks2() {
            heads = new ArrayList<>();
            values = new ArrayList<>();
            lasts = new ArrayList<>();
            frees = new ArrayList<>();
            occupySize = 0;
            freeSize = 0;
        }

        public int stackSize() {
            return heads.size();
        }

        public void createNewStack() {
            heads.add(-1);
        }

        public void push(int num, int stackIndex) {
            // 老头部出来，因为新头部往前跳，要能找到老头部
            int headIndex = heads.get(stackIndex);
            if (freeSize == 0) { // 垃圾区没有空闲的位置
                // value , occupySize, occupySize++
                heads.set(stackIndex, occupySize++);
                values.add(num);
                lasts.add(headIndex);
            } else { // 垃圾区有空闲空间
                // 新的数 -> freeIndex
                int freeIndex = frees.get(--freeSize);
                heads.set(stackIndex, freeIndex);
                values.set(freeIndex, num);
                lasts.set(freeIndex, headIndex);
            }
        }

        public int pop(int stackIndex) {
            // 当前的头部的位置
            int headIndex = heads.get(stackIndex);
            // values -> 当前的头部的位置 -> 要返回的数！
            int ans = values.get(headIndex);
            // 当前头要弹出了！接下来的头是谁？
            int newHeadIndex = lasts.get(headIndex);
            heads.set(stackIndex, newHeadIndex);
            // 垃圾区要接受，当前的头部的位置
            // frees动态数组！
            if (freeSize >= frees.size()) {
                frees.add(headIndex);
                freeSize++;
            } else {
                frees.set(freeSize++, headIndex);
            }
            return ans;
        }

        public boolean isEmpty(int statckIndex) {
            return heads.get(statckIndex) == -1;
        }

        public int peek(int stackIndex) {
            return values.get(heads.get(stackIndex));
        }

    }

    // 个人尝试完成此无穷栈
    public static class MyStack{
        // 4个动态数组中只有valueList存放实际参数，其余都值存储的是value的指针或下标
        public ArrayList<Integer> headList;// 栈顶列表
        public ArrayList<Integer> valueList;// 值列表
        public ArrayList<Integer> lastList;// 上一位置列表
        public ArrayList<Integer> freeList;// 空闲位置列表

        // 值数组大小
        public int valueSize = 0;
        // 垃圾数组大小
        public int freeSize = 0;

        public MyStack() {
            headList = new ArrayList<>();
            valueList = new ArrayList<>();
            lastList = new ArrayList<>();
            freeList = new ArrayList<>();
            valueSize = 0;
            freeSize = 0;
        }

        public int stackSize() {
            return headList.size();
        }

        public void createNewStack() {
            headList.add(-1);
        }

        public void push(int num, int stackIndex) {
            // 先把老头部取出来
            int oldHead = headList.get(stackIndex);
            // 判断空闲区有没: 没有，新增值空间
            if(freeSize == 0) {
                headList.set(stackIndex,valueSize++);
                valueList.add(num);
                lastList.add(oldHead);
            }else {
                // 空闲空间有的时候
                // 空闲空间位置
                int free = freeList.get(--freeSize);
                headList.set(stackIndex,free);
                valueList.set(free,num);
                lastList.set(free,oldHead);
            }
        }

        public int pop(int stackIndex) {
            // 1.取老头部
            int oldHead = headList.get(stackIndex);
            int oldHeadValue = valueList.get(oldHead);
            // 2.上一节点位置
            int last = lastList.get(oldHead);
            // 3.上一节点位置设置成新头部
            headList.set(stackIndex,last);
            // 4.增加空闲区
            // 判断空闲区是否满，满则扩容
            if(freeSize==freeList.size()) {
                freeList.add(oldHead);
            }else {
                freeList.set(freeSize,oldHead);
            }
            freeSize++;
            return oldHeadValue;
        }

        public boolean isEmpty(int statckIndex) {
            return headList.get(statckIndex) == -1;
        }

        public int peek(int stackIndex) {
            return valueList.get(headList.get(stackIndex));
        }

    }


    public static void main(String[] args) {
        int V = 10000;
        int testTime = 20000;
        System.out.println("测试开始");
        Stacks1 stack1 = new Stacks1();
//        Stacks2 stack2 = new Stacks2();
        MyStack stack2 = new MyStack();
        for (int i = 0; i < testTime; i++) {
            double decide = Math.random();
            if (decide < 0.25) {
                stack1.createNewStack();
                stack2.createNewStack();
            } else {
                int stackSize1 = stack1.stackSize();
                int stackSize2 = stack2.stackSize();
                if (stackSize1 != stackSize2) {
                    System.out.println("栈的数量不一致！");
                    break;
                }
                if (stackSize1 > 0) {
                    int stackIndex = (int) (Math.random() * stackSize1);
                    if (decide < 0.5) {
                        int num = (int) (Math.random() * V);
                        stack1.push(num, stackIndex);
                        stack2.push(num, stackIndex);
                    } else if (decide < 0.75) {
                        if (stack1.isEmpty(stackIndex) != stack2.isEmpty(stackIndex)) {
                            System.out.println(stackIndex + "号栈的是否为空不一致！");
                            break;
                        }
                        if (!stack1.isEmpty(stackIndex)) {
                            if (stack1.pop(stackIndex) != stack2.pop(stackIndex)) {
                                System.out.println(stackIndex + "号栈的弹出数据不一致！");
                                break;
                            }
                        }
                    } else {
                        if (stack1.isEmpty(stackIndex) != stack2.isEmpty(stackIndex)) {
                            System.out.println(stackIndex + "号栈的是否为空不一致！");
                            break;
                        }
                        if (!stack1.isEmpty(stackIndex)) {
                            if (stack1.peek(stackIndex) != stack2.peek(stackIndex)) {
                                System.out.println(stackIndex + "号栈的栈顶数据不一致！");
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("测试结束");
    }

}
