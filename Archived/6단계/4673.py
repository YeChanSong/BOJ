import sys
sys.setrecursionlimit(1000000)

def selfnum(idx,numset):
    if idx >= 10000:
        return None
    tmp = str(idx)
    res = idx
    for i in tmp:
        res += int(i)
    numset.add(res)
    selfnum(idx+1,numset)

a = set()
selfnum(1,a)
for i in range(1,10001):
    if i not in a:
        print(i)
