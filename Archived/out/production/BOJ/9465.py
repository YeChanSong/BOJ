import sys
sys.setrecursionlimit(200000)

def recur(y,x):
    global board,n,cache
    if x>=n:
        return 0
    
    if cache[y][x] != -1:
        return cache[y][x]
    
    k = max(recur(~y,x+1),recur(~y,x+2)) + board[y][x]
    cache[y][x] = k
    return k
       
T = int(sys.stdin.readline().strip())
for i in range(T):
    n = int(sys.stdin.readline().strip())
    cache = list([-1 for i in range(n)] for i in range(2))
    board = list()
    tmp = list(map(int,sys.stdin.readline().strip().split()))
    board.append(tmp)
    tmp2 = list(map(int,sys.stdin.readline().strip().split()))
    board.append(tmp2)
    print(max(recur(0,0),recur(1,0)))
    