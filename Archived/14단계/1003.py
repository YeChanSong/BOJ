import sys

def recur(idx):
    global cache
    
    if idx == 0:
        cache[0] = (1,0)
        return (1,0)
    elif idx == 1:
        cache[1] = (0,1)
        return (0,1)
    
    if cache[idx] != (-1,-1):
        return cache[idx]
    
    tmp0 = recur(idx-1)
    tmp1 = recur(idx-2)
    tmp = (tmp0[0]+tmp1[0] ,tmp0[1]+tmp1[1])
    cache[idx] = tmp
    return tmp

N = int(sys.stdin.readline().strip())
for k in range(N):
    fib = int(sys.stdin.readline().strip())
    cache = [(-1,-1) for i in range(fib+1)]
    cnt0 = 0
    cnt1 = 0
    ans = recur(fib)
    #print(ans)
    cnt0, cnt1 = cache[fib]
    print(cnt0,cnt1)