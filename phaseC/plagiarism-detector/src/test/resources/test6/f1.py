class Solution:
    def groupAnagrams(self, strs):
        dict = {}
        for i in strs:
            sort = ''.join(sorted(i))
            if dict.get(sort) == None:
                dict[sort] = [i]
            else:
                dict[sort].append(i)
        return list(dict.values())