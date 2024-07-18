import sys
sys.setrecursionlimit(10000)

def recur(y,x,ylim,xlim):
    global N,li
    
    if ylim == 1:
        return li[y][x]
    
    ul = recur(y,x,ylim//2,xlim//2)
    ur = recur(y,x+xlim//2,ylim//2,xlim//2)
    ll = recur(y+ylim//2,x,ylim//2,xlim//2)
    lr = recur(y+ylim//2,x+xlim//2,ylim//2,xlim//2)

    if (ul == ur == ll == lr) and len(ul) == 1:
        return ul
    return '('+ul+ur+ll+lr+')'

N = int(sys.stdin.readline().strip())
li = list()
for i in range(N):
    li.append(sys.stdin.readline().strip())
ans = recur(0,0,N,N)
print(ans)