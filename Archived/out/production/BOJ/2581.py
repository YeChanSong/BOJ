import sys,math
sys.setrecursionlimit(1000000)

def recur(curr,end):
    global sm, mn
    if curr > end:
        return
    
    for i in range(2,math.floor(math.sqrt(curr))+1):
        if curr%i == 0:
            recur(curr+1,end)
            return
    if mn > curr and curr != 1:
        mn = curr
    if curr != 1:
        sm += curr
    recur(curr+1,end)
    return


M = int(sys.stdin.readline().strip())
N = int(sys.stdin.readline().strip())
sm = 0
mn = 123456789
recur(M,N)
if sm == 0:
    print(-1)
else:
    print(sm)
    print(mn)
