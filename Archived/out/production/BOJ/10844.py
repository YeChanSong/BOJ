import sys

N = int(sys.stdin.readline().strip())
cache = list([-1 for i in range(10)] for j in range(100))

def recur(idx,curr):
    if curr>9 or curr<0:
        return 0
    if idx==N-1:
        return 1
    
    if cache[idx][curr] != -1:
        return cache[idx][curr]
    
    tmp = (recur(idx+1,curr+1)%1000000000 + recur(idx+1,curr-1)%1000000000)%1000000000
    cache[idx][curr] = tmp
    return tmp
    
ans = 0
for i in range(1,10):
    ans += recur(0,i)%1000000000
print(ans%1000000000)
    