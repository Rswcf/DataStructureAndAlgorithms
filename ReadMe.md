# 1. 线性结构和非线性结构

## 1.1 线性结构

1. 线性结构作为最常用的数据结构，其特点是**数据元素之间存在一对一**的线性关系。
2. 线性结构有两种不同的存储结构，即**顺序存储结构**和**链式存储结构**。顺序存储的线性表称为**顺序表**，顺序表中的存储元素是连续的。 链式存储的线性表称为**链表**
   ，链表中的存储元素不一定是连续的，元素节点中存放数据元素以及相邻元素的地址信息。
3. 线性结构常见的有**数组**，**队列**，**链表**和**栈**

## 1.2 非线性结构

非线性结构包括:**二维数组**，**多维数组**，**广义表**，**树结构**，**图结构**。

# 2. 稀疏数组和队列

## 2.1 稀疏数组 (Sparse matrix/Sparse array)

### 2.1.1 基本介绍

当一个数组中大部分元素是0，或者为同一个值时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法:

1. 记录数组有几行几列，有多少不同的值 。
2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序规模。

### 2.1.2 二维数组与稀疏数组的转化

#### 二维数组转稀疏数组的思路

1. 遍历原始的二位数组，得到有效数据的个数`sum` 。
2. 根据`sum`就可以创建稀疏数组`SparseArr int[sum+1][3]` 。
3. 将二维数组的有效数据存入到稀疏数组 。

#### 稀疏数组转二维数组的思路

1. 读取第一行，根据第一行数据创建原始二维数组 。
2. 继续读取稀疏数组后几行数据，并赋值给原始的二维数组 。

### 2.1.3 代码

[二维数组与稀疏数组相互转化](src/com/yijie/sparsearray/SparseArray.java)

## 2.2 队列

### 2.2.1 队列介绍

队列是个有序列表，可以用**数组**或者**链表**来实现，队列遵循**FIFO**原则，即先入先出，后入后出

### 2.2.2 数组模拟队列

1. 若使用数组的结构来存储队列数据，则队列数组的声明如下图，其中`maxSize`是该队列的最大容量 。
2. 因为队列的输出，输入分别从前后端来处理，因此需要两个变量`front`及`rear`分别记录前后端的下标，`front`会随着数据输出改变，而`rear`则随着数据输入而改变
3. 将数据存入队列称为`addQueue`,`addQueue`的处理需要两个步骤:

- 将尾指针后移，`rear+1`,当`front=rear`,空
- 若尾指针`rear`小于队列最大下标`maxSize-1`，则将数据存入`rear`所指的数据元素中，否则无法存入数据。`rear == maxSize-1`，队列满。

![Example of queue](src/image/Queue.png "Queue")

4. 代码

[数组模拟队列](src/com/yijie/queue/ArrayQueueDemo.java)

### 2.2.3 数组模拟环形队列

- 目前的数组只可使用一次，没有达到复用的效果
- 将这个数组使用算法，改进成一个**环形的队列**，取模: %

#### 使用数组模拟环形序列的思路

1. 对`front`变量的含义做调整:`front`指向队列的第一个元素，也就是说`arr[front]`就是队列的第一个元素，`front`初始值为0。
2. 对`rear`变量的含义做调整:`rear`指向队列最后一个元素的后一个位置，空出空间作为约定，`rear`初始值为0 。
3. 当队列满时，条件为:`(rear+1)%maxSize=front`
4. 当队列为空的条件:`rear = front`
5. 队列中有效数据的个数`(rear+maxSize-front)%maxSize`

#### 代码

[数组模拟环形队列](src/com/yijie/queue/CircleArrayQueueDemo.java)

# 3. 链表

## 3.1 单链表

### 3.1.1 基本介绍

链表是有序的列表，在内存中存储方式如下:  
![Example of SingleLinkedList](src/image/SingleLinkedList.png "SingleLinkedList")

1. 链表是以节点的方式来存储，是链式存储
2. 每个节点包含data域，next域: 指向下一个节点
3. 链表的各个节点不一定是连续存储
4. 链表分带头节点的链表和不带头节点的链表

### 3.1.2 单链表的创建

1. 先创建一个`head`头节点，作用为表示链表的头
2. 依次添加后续节点到链表最后遍历

### 3.1.3 添加元素到链表指定位置

1. 通过**遍历**以及**辅助变量**`temp`找到新添加节点的位置
2. `新节点.next = temp.next`
3. `temp.next = 新节点`

### 3.1.4 修改链表中节点

1. 通过遍历找到该节点
2. 修改节点信息

### 3.1.5 从单链表中删除一个节点

1. 找到需要删除的节点的前一个节点`temp`
2. `temp.next = temp.next.next`
3. 被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收

### 3.1.6 代码

[单链表](src/com/yijie/linkedlist/SingleLinkedListDemo.java)

## 3.2 双向链表

### 3.2.1 基本介绍

单链表缺点分析:

1. 单链表只能从一个方向进行查找，双向链表可以前向或者后向进行查找
2. 单项链表不能自我删除，需要依靠辅助节点，双向可以**自我删除**

### 3.2.2 双向链表的创建及增删改查操作

1. 遍历方法与单链表一直，区别:可以前向，也可后向查找
2. **添加**:默认添加到双向链表最后
1. 找到双向链表的最后节点
2. `temp.next = newHeroNode`
3. `newHeroNode.pre = temp`
3. **修改**的思路及原理与单向链表一致
4. **删除**:
    1. 双向链表可实现自我删除
2. 直接定位到待删除节点`temp`
3. `temp.pre.next = temp.next`
4. `temp.next.pre = temp.pre`

### 3.2.3 代码

[双向链表](src/com/yijie/linkedlist/DoubleLinkedListDemo.java)

## 3.3 单向环形链表

### 3.3.1 单向环形链表的应用: Josephus Problem

Josephu问题:编号为1,2,...,n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，数到m的人出列，m的下一位继续从0开始报数。依次类推，直到所有人出列为止，由此产生一个出列编号的序列。

![Josephus Problem](src/image/JosephusProblem.png "Josephus Problem")

*示例:

* n=5,共有5人
* k=1,从第一人开始报数
* m=2,数两次
* 出队列顺序:
    * 2=>4=>1=>5=>3

### 3.3.2 单向环形链表的创建及操作

1. **创建**一个单向环形链表
1. 创建第一个节点，让first指针指向该节点，并形成环形
2. 之后每创建一个新节点，就把该节点加入到已有的环形链表即可
2. **遍历**单向环形链表
1. 先让一个辅助指针指向first节点
2. 后通过一个while循环遍历该链表即可(`cur.next first`)

### 3.3.3 代码

[单向环形链表及Josephu Problem](src/com/yijie/linkedlist/JosephuProblem.java)

# 4. 栈

## 4.1 基本介绍

1. 栈是一个先入先出的有序列表
2. 栈是限制线性表中元素的插入与删除**只能在线性表同一端**进行的一种特殊线性表。允许插入与删除的一段，为变化的一端，称为**栈顶**(Top),另一端为固定的一端，称为**栈底**(Bottom)。
3. 由栈的特性可知，最先放入栈的元素在栈底，最后放入栈的元素在栈顶。而删除元素恰好相反，最后放入的元素最先删除，最先放入的元素最后删除。

![Stack](src/image/Stack.webp "Stack")

### 4.2 栈的应用场景

1. 子程序的调用:在跳往子程序前，会将下个指令的地址存到堆栈中，直到子程序执行完后再将地址取出，以回到原来程序。
2. 处理递归调用:与子程序的调用类似，除了存储下一个指令的地址外，也将参数，区域变量等数据存入堆栈中。
3. 表达式的转换[中缀表达式转后缀表达式]与求职
4. 二叉树的遍历
5. 图形的深度优先(depth-first)搜索法

### 4.3 数组模拟栈

1. 定义一个`top`来表示栈顶，初始化为-1
2. 入栈的操作，当有数据加入到栈时，`top++`;`stack[top] = data`
3. 出栈的操作，`int value = stack[top];top--; return value`
4. [代码](src/com/yijie/stack/ArrayStack.java)

### 4.4 栈实现综合计算器

1. 通过一个`index`值遍历表达式
2. 如果是一个**数字**，就直接入数栈
3. 如果是一个**符号**，分如下情况处理:
    1. 如果当前的符号栈为空，就直接入栈
2. 如果符号符号栈有操作符，就进行比较，**如当前的操作符的优先级小于或者等于栈中的操作符**，就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算。将得到的结果入数栈，后将当前的符号入符号栈。**  
   如果当前操作符的优先级大于栈中的操作符**，就直接入符号栈。
4. 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号,并运行。
5. 最后在数栈只有一个数字，就是表达式的结果。
6. 代码: [以栈为底的计算器](src/com/yijie/stack/Calculator.java)

### 4.5 栈的前缀，中缀以及后缀表达式（逆波兰表达式）

#### 4.5.1 前缀表达式

* 前缀表达式又称波兰表达式，前缀表达式的运算符位于操作数之前
* 示例: (3+4)\*5-6对应的前缀表达式为-*+3456
* 前缀表达式的计算机求值: **从右到左扫描表达式**，遇到数字式时，将数字压入堆栈，遇到运算符时，弹出栈顶两个数，用运算符对他们作相应的运算(栈顶元素和次顶元素)
  ，将结果入栈。重复上述过程直到到大表达式最左端，最后运算出的值即为表达式的结果。

#### 4.5.2 中缀表达式

* 中缀表达式就是最常见的表达式，如(3+4)*5-6
* 人类习惯于中缀表达式，但其不利于计算机操作。因此在计算机运行时会将中缀表达式转换成其他表达式来操作。 一般为后缀表达式。

#### 4.5.3 后缀表达式

* 后缀表达式又称逆波兰表达式，与前缀表达式相似,但运算符位于操作数之后
* 示例: (3+4)\*5-6对应的后缀表达式为: 34+5\*6-
* 后缀表达式的计算机求值: **从左到右**扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶两个数，用运算符对他们左相应的计算(次顶元素和栈顶元素)
  ，并将结果入栈;重复上述过程直至表达式最右端，最后运算得出的值即为表达式的结果。

* 示例:

|   正常表达式    |  逆波兰表达式  |   
|:----------:|:--------:|  
|    a+b     |   ab+    |  
|  a+(b-c)   |  abc-+   |  
| a+(b-c)*d  | abc-d*+  |  
| a+d*(b-c)  | adbc-*+  |  
|   a=1+3    |  a13+=   |

#### 4.5.4 逆波兰计算器:

   代码: [逆波兰计算器](src/com/yijie/stack/ReversePolishNotation.java)

#### 4.5.5 中缀表达式转后缀表达式
    1. 初始化两个栈，运算符栈`s1`以及存储中间结果的栈`s2`
    2. 从左到右扫描中缀表达式
    3. 遇到操作数时，将其压入`s2`
    4. 遇到运算符时，比较其与`s1`栈顶运算符的优先级
        1. 如果`s1`为空，或栈顶运算符为左括号"("，则直接将此运算符入栈;
        2. 若优先级比栈顶运算符高，也将运算符压入`s1`
        3. 若优先级不高于栈顶运算符，将`s1`栈顶运算符弹出并压入`s2`中，重复上述比较
    5. 遇到括号时:
        1. 如果左括号"("，则直接压入`s1`
        2. 如果是右括号")"，则依次弹出`s1`栈顶运算符，并压入`s2`，直到遇到左括号为止，丢弃括号
    6. 重复步骤2-5，直到表达式最右端。
    7. 将`s1`剩余运算符依次弹出并压入`s2`
    8. 依次弹出`s2`中元素并输出，结果的逆序为重缀表达式的后缀表达式
    9. 代码: [中缀表达式转后缀表达式](src/com/yijie/stack/ReversePolishNotation.java)

# 5. 递归

## 5.1 基本介绍

递归就是方法自己调用自己，每次调用时传入不同的变量，递归有助于编程者解决复杂的问题。同时可以让代码变得简洁。

## 5.2 递归调用机制

1. 当程序执行到一个方法时，就会开辟一个独立的空间。（栈）
2. 每个空间的数据（局部变量）是独立的，不会相互影响
3. 如果方法中使用的是应用类型变量（如数组），就会共享该引用类型的数据。
4. 递归必须向退出条件逼近，否则会无限递归，出现`StackOverFlowError`
5. 当一个方法执行完毕，或者遇到`return`，就会返回，遵守谁调用将结果返回给谁的原则。同时，当方法执行完毕或者返回时，该方法也执行完毕。

## 5.3 递归:迷宫问题

![Maze](src/image/Maze.png "Maze")

代码: [迷宫问题代码](src/com/yijie/recursion/Maze.java)

## 5.4 递归:八皇后问题（回溯算法）

### 5.4.1 八皇后问题介绍

八皇后问题，是回溯算法的典型案例。该问题由国际西洋棋棋手马克斯·贝瑟尔于 1848 年提出： 在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。 高斯认为有 76
种方案。1854 年在柏林的象棋杂志上不同的作者发表了 40 种不同的解，后来有人用图论的方法解出 92 种结果。计算机发明后，有多种计算机语言可以编程解决此问题。

### 5.4.2 八皇后问题思路分析

1. 第一个皇后放第一行第一列
2. 第二个皇后放在第二行第一列，判断是否符合条件。如果不符合，继续放到第二行第二咧，第三列...直至第二个皇后处于符合条件的位置上
3. 将第三个皇后置于第三行第一列，第二列...依次判断是否符合条件，直至其处于符合条件位置上。重复同样的步骤，直至第八个皇后处于正确位置。
4. 当取得第一个正确解时，当栈回退到上一个栈时，就会开始回溯。即获取当第一个皇后处于第一列时的所有正确解。
5. 将第一个皇后置于第一行第二列，重复执行步骤1至4，

### 5.4.3 代码

[八皇后问题代码](src/com/yijie/recursion/EightQueens.java)

# 6. 排序

## 6.1 基本介绍

排序也称排序算法，是将一组数据按照指定的顺序进行排列的过程。

## 6.2 排序的分类:

* 内部排序:指将需要排序的数据加载到内部存储器中进行排序。
* 外部排序:数据量过大，无法全部加载到内存中，他需要借助外部存储进行排序。

## 6.3 算法的时间复杂度

1. 事后统计的方法: 该方法可行，但面临两个问题:
    * 需要实际运行该程序
    * 所得时间的统计量依赖于计算机硬件，软件等环境因素
2. 事先估计的方法: 通过计算算法的时间复杂度来判断算法的优劣

### 6.3.1 时间频度

时间频度(Temporal Frequency): 一个算法所需时间与算法中语句执行的次数成正比。算法中语句执行次数多，花费时间就多。**算法中语句执行次数称为语句频度或时间频度**，记为T(n)。

#### 示例:

计算1-100之间所有数之和，设计两种算法:

* 使用for循环，T(n) = n + 1 :

```java
        int total=0;
        int end=100;

        for(i=0;i<end; i++){
        total+=i;
```

* 直接计算，T(n) = 1:

```java
    int total=0;
    int end=100;
    total=(1+end)*end/2
```

随着n的变大时间频度有3个特点(3种可以忽略的项):

* 常数项可忽略
* 低次项可忽略
* 高次项系数可忽略

### 6.3.2 时间复杂度

1. 一般情况下，算法的时间频度是问题规模n的某个函数, 用T(n)表示。 若有某辅助函数f(n)，使得n趋近于无穷大时，T(n)/f(n)的极限值为不等于零的常数，记作**T(n)=O(f(n))**, O(f(n))
   为算法的渐进时间复杂度, 简称时间复杂度。
2. T(n)不同，但时间复杂度可能相同。
3. 计算时间复杂度的方法:
    * 用常数1代替所有常数
    * 只保留最高阶项
    * 去除最高阶项的系数
4. 常见的时间复杂度，由小到大排列如下。随着n的不断增大, 算法的执行效率会随时间复杂度的不断增大而越来越低。
    1. 常数阶O(1)
    2. 对数阶O(log2n)
    3. 线性阶O(n)
    4. 线性对数阶O(nlog2n)
    5. 平方阶O(n^2)
    6. 立方阶O(n^3)
    7. k次方阶O(n^k)
    8. 指数阶O(2^n)

### 6.3.3 平均时间复杂度和最坏时间复杂度

1. **平均时间复杂度**是指，所有输入实例等概率出现情况下，该算法的运行时间。
2. 最坏情况下时间复杂度称为**最坏时间复杂度**，**一般讨论的时间复杂度均为最坏时间复杂度**。最坏时间复杂度确定了算法在任何输入实例上运行时间的上限，保证了算法运行时间不会比最坏情况更长。
3. 平均时间复杂度与最坏时间复杂度是否一致，取决于算法。

### 6.3.4 空间复杂度

1. 一个算法的空间复杂度定义为算法所耗费的存储空间，是问题规模n的函数。
2. 算法的空间复杂度是一个对算法在运行过程中临时占用存储空间大小的量度。
3. 在做算法分析时，主要讨论的是时间复杂度。**从用户体验角度，更看重程序执行的速度**。一些缓存产品(redis, memcache)和算法(基数排序)的本质即为空间换时间。

## 6.4 冒泡排序

### 6.4.1 基本介绍

对待排序数列从前向后，依次比较相邻元素的值。若发现逆序则交换，使值较大的元素向后移动。重复遍历要排序的数列，直至数列排序已完成。

* **优化**: 冒泡排序还有一种优化算法，就是立一个 flag，当在一趟序列遍历中元素没有发生交换，则证明该序列已经有序。

### 6.4.2 代码

[冒泡排序](src/com/yijie/sort/BubbleSort.java)

## 6.5 选择排序

### 6.5.1 基本介绍

选择排序是一种简单的排序方法。它的基本思想是，第一次从`arr[0]-arr[n-1]`中选取最小值，与`arr[0]`交换。第二次从`arr[1]-arr[n-1]`选取最小值，与`arr[1]`交换。第三次...
第i次从`arr[i-1]-arr[n-1]`选取最小值，与`arr[i-1]`交换...第n-1次从`arr[n-2]-arr[n-1]`中选取最小值，与`arr[n-2]`交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。

![Selection Sort](src/image/SelectionSort.gif "SelectionSort")

### 6.5.2 代码

[选择排序](src/com/yijie/sort/SelectionSort.java)

## 6.6 插入排序

### 6.6.1 基本介绍

把n个待排序的元素看作一个有序表和一个无序表。开始时有序表值包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出一个元素，插入到有序表的相应位置。

![InsertionSort](src/image/InsertionSort.gif "InsertionSort")

### 6.6.2 代码

[选择排序](src/com/yijie/sort/InsertionSort.java)

## 6.7 希尔排序

### 6.7.1 基本介绍

希尔排序是希尔于1959年提出的一种排序算法。希尔排序也是一种**插入排序**，它是简单插入排序经过改进之后的一个**更高效的版本**，也称为**缩小增量排序**。
希尔排序先将整个待排序的序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。


### 6.7.2 代码

[希尔排序](src/com/yijie/sort/ShellSort.java)

## 6.8 快速排序

### 6.8.1 基本介绍

快速排序的基本思想是: 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另一部分的所有数据要小，再按这种方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进行，使整个数据变成有序序列。

![QuickSort](src/image/QuickSort.gif "QuickSort")

### 6.8.2 代码

[快速排序](src/com/yijie/sort/QuickSort.java)

## 6.9 归并排序

### 6.9.1 基本介绍

归并排序(Merge Sort)是利用**归并**思想实现的排序方法。该算法采用经典的**分治策略(divide and conquer)**，将问题**分**(divide)成小问题递归求解，在**治**(conquer)阶段则将分阶段得到的各答案修补在一起，分而治之。

![MergeSort](src/image/MergeSort.png "MergeSort")

### 6.9.2 代码

[归并排序](src/com/yijie/sort/MergeSort.java)

## 6.10 基数排序

### 6.10.1 基本介绍

1. 基数排序(Radix Sort)属于分配式排序，又称桶子法或bin sort，顾名思义，它是通过键值各个位的值，将要排序的元素分配到某些桶中，达到排序的作用。
2. 基数排序法属于稳定性的排序，基数排序法是效率高的稳定性排序法。
3. 基数排序是桶排序的扩展。
4. 基数排序的实现:将整数按位数切割成不同的数字，然后按每个位数分别比较。
5. 基数排序是经典的**空间换时间的方式**，占用空间很大，当对海量数据排序时，容易造成OutOfMemoryError。

![RadixSort](src/image/RadixSort.webp "RadixSort")

### 6.10.2 代码

[基数排序](src/com/yijie/sort/RadixSort.java)

## 6.11 常用排序算法的总结与对比

### 6.11.1 相关术语解释

1. 稳定: 如果a原本位于b之前且a=b，排序之后a仍然在b之前
2. 不稳定: 如果a原本位于b之前且a=b，排序之后a可能出现在b之后
3. 内排序: 所有排序过程都在内存中完成
4. 外排序: 由于数据量过大，因此把数据存入磁盘中，排序需通过磁盘和内存间的数据传输才能进行。
5. 时间复杂度: 一个算法执行所耗费的时间。
6. 空间复杂度: 运行一个程序所需内存的大小。
7. n: 数据规模
8. k: "桶"的个数
9. In-place: 不占用额外内存
10. Out-place: 占用额外内存

### 6.11.2 常用排序算法对比

![SortComplexity](src/image/SortComplexity.png "SortComplexity")

# 7. 查找算法

## 7.1 线性查找

### 7.1.1 基本介绍

线性查找或顺序查找是搜索某一特定值的搜索算法。线性查找按一定顺序检查数组中每一个元素，直到找到索要搜寻的特定值为止。

### 7.1.2 代码

[线性查找](src/com/yijie/search/LinearSearch.java)

## 7.2 二分查找

### 7.2.1 基本介绍

二分查找的思路:

1. 首先确定该数组中间值的下标: `mid = (left + right) / 2`
2. 然后比较待查找数`findVal`与`arr[mid]`
    * `findVal > arr[mid]` 递归向右查找
    * `findVal < arr[mid]` 递归向左查找
    * `findVal == arr[mid]` 找到待查数，返回
3. 递归完整个数组，仍未找到`findVal`，结束递归 (`left > right`)

### 7.2.2 代码

[二分查找](src/com/yijie/search/BinarySearch.java)

# 8. 哈希表

### 8.1 基本介绍

哈希表，也称散列表，是根据关键码值直接进行访问的数据结构。哈希表通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。 这个映射函数叫做散列函数，存放记录的数组叫散列表。

### 8.2 代码

[哈希表](src/com/yijie/hashtable/HashTableDemo.java)


