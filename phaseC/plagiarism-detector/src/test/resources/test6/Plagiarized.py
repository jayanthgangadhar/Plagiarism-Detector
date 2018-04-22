class Solution:
    def groupAnagrams(self, strs):
        dict = {}
        iterate(strs)

	def iterate(strs):        
        for i in strs:
            sort = ''.join(sorted(i))
            check(dict,sort,i)
        return list(dict.values())

    def check(dict,sort,i):    
        if dict.get(sort) == None:
                dict[sort] = [i]
            else:
                dict[sort].append(i)    

        