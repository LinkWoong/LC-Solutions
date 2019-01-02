
# coding: utf-8

# In[45]:


class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s
        #Zigzag的定义：
        #Zigzag（1，11）(numRows=3)
        #1   5    9
        #2 4 6 8 10 
        #3   7   11
        #Zigzag（1，21）(numRows=5)
        #1        9          17
        #2     8 10       16 18
        #3   7   11    15    19
        #4 6     12 14       20
        #5       13          21
        #目标：Zigzag String变为如上图一行一行从左往右数下来的string
        #算法思路：
        # 按给定的行数新建的一个有numRows空sub string的string
        # 给这个gstring里的sub string加入s中的字符
        # 根据当前所在Zigzag string中的位置，依靠当前row_index和numRows的关系，到上底(row_index=0)加行或者到下底(row_index=numRows-1)减行，找到下一个正确的row_index
        # 用join（）函数将string中表示不同row的sub string连起来
        String = [''] * numRows
        row_index, up_or_down = 0, 1
      
        for x in s:
            String[row_index] += x
            if row_index == 0:
                up_or_down = 1
            elif row_index == numRows -1:
                up_or_down = -1
            index += up_or_down

        return ''.join(String)

