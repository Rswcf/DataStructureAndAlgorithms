# 线性结构和非线性结构

## 线性结构

1. 线性结构作为最常用的数据结构，其特点是**数据元素之间存在一对一**的线性关系

2. 线性结构有两种不同的存储结构，即**顺序存储结构**和**链式存储结构**。顺序存储的线性表称为**顺序表**,顺序表种的存储元素是连续的。 链式存储的线性表称为**链表**
   ，链表中的存储元素不一定是连续的，元素节点种存放数据元素以及相邻元素的地址信息。

3. 线性结构常见的有**数组**，**队列**，**链表**和**栈**

## 非线性结构

非线性结构包括:**二维数组**，**多维数组**，**广义表**，**树结构**，**图结构**。

# 3. 稀疏数组和队列

## 3.1 稀疏数组 (Sparse matrix/Sparse array)

### 3.1.1 基本介绍

当一个数稀组中大部分元素是0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法:

1. 记录数组有几行几列，有多少不同的值
2. 把具有不同值的元素的行列及值记录在一个小规模得数组中，从而缩小程序得规模

### 3.1.2 二维数组与系数数组的转化

* 二维数组转稀疏数组的思路
    1. 遍历原始的二位数组，得到有效数据的个数`sum`
    2. 根据sum就可以创建稀疏数组`SparseArr int[sum+1][3]`
    3. 将二位数组的有效数据存入到稀疏数组

* 稀疏数组转二维数组的思路
    1. 读取第一行，根据第一行数据创建原始二位数组
    2. 积蓄读取稀疏数组后几行数据，并赋给原始二位数组

### 3.1.3 代码

[二维数组与稀疏数组相互转化](src/com/yijie/sparsearray/SparseArray.java)

## 3.2队列

### 3.2.1队列介绍

队列是个有序列表，可以用**数组**或者**链表**来实现，队列遵循**FIFO**原则，即先入先出，后入后出

### 3.2.2 数组模拟队列

1. 若使用数组的结构来存储队列数据，则队列数组的声明如下图，其中`maxSize`是该队列的最大容量
2. 因为队列的输出，输入分别从前后端来处理，因此需要两个变量`front`及`rear`分别记录前后端的下标，`front`会随着数据输出改变，而`rear`则随着数据输入而改变
3. 将数据存入队列称为`addQueue`,`addQueue`额处理需要两个步骤:
    1. 将尾指针后移，`rear+1`,当`front=rear`,空
    2. 若尾指针`rear`小于队列最大下标`maxSize-1`，则将数据存入`raer`所指的数据元素中，否则无法存入数据。`rear == maxSize-1`，队列满。

![Example of queue](src/image/Queue.png "Queue")

#### 数组模拟环形队列
1. 目前的数组只可使用一次，没有达到复用的效果
2. 将这个数组使用算法，改进成一个**环形的队列**，取模: %
##### 使用数组模拟环形序列的思路
1. 对`front`变量的含义做调整:`front`指向队列的第一个元素，也就是说`arr[front]`就是队列的第一个元素，`front`初始值为0
2. 对`rear`变量的含义做调整:`rear`指向队列最后一个元素的后一个位置，空出空间作为约定，`rear`初始值为0
3. 当队列满时，条件为:`(rear+1)%maxSize=front`
4. 当队列为空的条件:`rear = front`
5. 队列中有效数据的个数`(rear+maxSize-front)%maxSize`

# 4. 链表
## 4.1 单链表
### 4.1.1
### 4.1.2 单链表的创建
1. 先创建一个`head`头节点，作用为表示链表的头
2. 依次添加后续节点到链表最后遍历