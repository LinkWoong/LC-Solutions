'''
More on bit manipulation
'''

class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        all_one = x ^ y
        result = 0
        while all_one:
            all_one &= all_one - 1
            result = result + 1
        return result
