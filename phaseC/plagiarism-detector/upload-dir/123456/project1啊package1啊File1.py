class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        counter = 0
        count=0
        if nums:
            for num in nums:
                if num==val:
                    continue
                else:
                    nums[count]= num
                    count+=1
        return count,nums

obj1 = Solution()
print(obj1.removeElement([3,2,2,3],3))
