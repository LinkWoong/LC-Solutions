# LC-Solutions
大家好，这个repo是为了分享各位刷题的solution，同时也起到监督打卡的作用。还请各位积极contribute。
刷题对于找intern/full time的重要性不必多说。第一遍不追求最优解，能够理清解题思路即可，待水平到达一定高度时再追求最优解。
刚开始刷如何下手？请看这篇[文章](https://www.zhihu.com/question/31092580/answer/500616393)

目前的成员有
* @lmy1108
* @MAGI003769
* @Gavinwxy
* @Chetyh
* @Chenhui Wang

## How to
各类算法题已经按照topic创建好了各自的文件夹(thanks @lmy1108 for his contribution)，大家可以选择：
* 直接在对应的目录下选择*upload files*直接从本地上传代码；
* git（关于如何clone一个repo到本地修改，并远程提交请见[这里](https://help.github.com/articles/fork-a-repo/)) 
**注意**：Please keep the formatting(codes, filenames etc.) correct and clean

## 格式
语言不限，各位可以选择自己较为熟悉的语言（当然不同语言写起来复杂程度不同，比如Python很好用的list comprehension），重点是学会各类数据结构和常用算法（对于转专业选手:D）和尽快熟悉大厂面试题。  
* **文件名**：请大家按照*难度_题目_编号_姓名.language*的格式来命名文件。例如 
> Easy_MergeBinaryTree_617_ASS.java
（大家如果见到文件名没有名字的代码，那就是repo作者wch的:D）
* **文件位置**：大家可以选择上传到各个topic，例如ReverseString系列就传到String目录下；也可以按照难度来上传，例如Easy开头的就传到Easy里面。
* **Issues**：哪些题目自己Google后无法解决可以新开一个issue，大家一起讨论。
* **版本控制**：大家直接传到master branch就好，或者自己想开一个new branch也可以
* **其他**: 慢慢完善，比如以后Wiki可以放一些讲解算法的博客/文章，或者大厂面经OA之类

## 一些其他想说的
这个repo的作者目前还处于失学状态，每天也只能做两三道easy，还是在学校状态好啊sigh。对于转专业选手还是建议大家先从基础补起，比如最基本的在数组中添加一个元素到指定的位置
```Java
public void add(int index, E e)
```
通过索引add一个E类型的元素（这里使用了泛型），会导致该index以后的元素全部挪动一位（时间复杂度o(n/2)的大头就是从这里来的），并且为了追求高效还涉及到了扩/缩容。数组的优缺点一目了然。
*道阻且长，希望大家通过刷题+运气拿到不错的offer，祝大家好运*
