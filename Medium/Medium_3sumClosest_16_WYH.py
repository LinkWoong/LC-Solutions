
# coding: utf-8

# In[1]:


class Solution:
    # @return an integer
    # 算法思路：
    # step1:将输入的整数list从小到大排序
    # step2:遍历所有三个整数组合的方式，得到和记为sum，这个遍历是三个数中，尾数（最后一个数）不变，头数从1遍历到len(num) - 2，
    # 中间数从头数后面一个数遍历到尾数的前面一个数(*这里只是sum一直小于target的情况)
    # step3:遍历过程中，遇到sum==target, 返回结果，
    #                  存储sum的值为result,当sum_new比sum_prevs更接近target是，overwrite result为新sum
    #                   sum的值小于target，中间数向后推进一位
    #                   sum的值大于target, 尾数想前进一位
    def threeSumClosest(self, num, target):
        num.sort()
        result = num[0] + num[1] + num[2]
        for i in range(len(num) - 2):
            j, k = i+1, len(num) - 1
            while j < k:
                sum = num[i] + num[j] + num[k]
                if sum == target:
                    return sum
                
                if abs(sum - target) < abs(result - target):
                    result = sum
                
                if sum < target:
                    j += 1
                elif sum > target:
                    k -= 1
            
        return result


# In[2]:


A=set(i) for i in range(9)

