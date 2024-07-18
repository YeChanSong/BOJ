import sys
sys.setrecursionlimit(1000000)

def recur(idx,cnt):
    global li
    if idx == len(li):
        return cnt
    if li[idx] == 1:
        return recur(idx+1,cnt)
    
    for i in range(2,li[idx]):
        if li[idx]%i == 0:
            return recur(idx+1,cnt)
    return recur(idx+1,cnt+1)
    
    


N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
ans = recur(0,0)
print(ans)
