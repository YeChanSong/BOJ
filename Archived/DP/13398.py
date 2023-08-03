import sys

n = int(sys.stdin.readline().strip())
arr = list(map(int,sys.stdin.readline().split()))

def consum(li):
    global n
    
    cache = list(-1 for i in range(n))
    cache[0] = li[0]
    for i in range(1,n):
        cache[i] = max(cache[i-1]+li[i],li[i])
        
    return cache
asc = consum(arr)
desc = consum(arr[::-1])[::-1]
ans = -10**300
mx = -10**300
for i in range(n):
    ans = max(ans,asc[i])
    if mx<arr[i]:
        mx = arr[i]
if mx>0:
    for i in range(n):
        ans = max(ans,asc[i]+desc[i]-2*arr[i])

print(ans)