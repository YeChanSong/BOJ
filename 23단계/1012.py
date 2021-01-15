import sys
sys.setrecursionlimit(10000)


def buildGraph(K):
    global board
    
    for i in range(K):
        x,y = map(int,sys.stdin.readline().strip().split())
        board[y][x] = 1
    
def dfsall(x,y):
    global board, visited
    cnt = 0
    for i in range(y):
        for j in range(x):
            if board[i][j] == 1 and visited[i][j] == False:
                dfs(i,j)
                cnt += 1
                
    return cnt

def dfs(y,x):
    global board, visited, M, N
    
    visited[y][x] = True
    
    if y-1 >= 0 and board[y-1][x] == 1 and visited[y-1][x] == False:
        dfs(y-1,x)

    if y+1 < N and board[y+1][x] == 1 and visited[y+1][x] == False:
        dfs(y+1,x)
    
    if x-1 >= 0 and board[y][x-1] == 1 and visited[y][x-1] == False:
        dfs(y,x-1)
    
    if x+1 < M and board[y][x+1] == 1 and visited[y][x+1] == False:
        dfs(y,x+1)


T = int(sys.stdin.readline().strip())
global board, visited, M, N
for i in range(T):
    M, N, K = map(int, sys.stdin.readline().strip().split())
    board = list([0 for j in range(M)] for i in range(N))
    visited = list([False for i in range(M)] for j in range(N))
    buildGraph(K)
    ans = dfsall(M,N)
    print(ans)
