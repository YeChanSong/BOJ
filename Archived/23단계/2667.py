import sys

def dfsall(N):
    global board, visited
    numHouse = []
    num = 0
    cnt = 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == '1' and visited[i][j] == False:
                num = dfs(i,j)
                cnt += 1
                numHouse.append(num)
    print(cnt)
    return numHouse

def dfs(y,x):
    global board, visited, N
    
    visited[y][x] = True
    num = 1
    
    if y-1 >= 0 and board[y-1][x] == '1' and visited[y-1][x] == False:
        num += dfs(y-1,x)
    
    if y+1 < N and board[y+1][x] == '1' and visited[y+1][x] == False:
        num += dfs(y+1,x)
        
    if x-1 >= 0 and board[y][x-1] == '1' and visited[y][x-1] == False:
        num += dfs(y,x-1)
    
    if x+1 < N and board[y][x+1] == '1' and visited[y][x+1] == False:
        num += dfs(y,x+1)
    
    return num
    

global board, visited, N
N = int(sys.stdin.readline().strip())
visited = list([False for i in range(N)] for j in range(N))
board = list()
for i in range(N):
    board.append(sys.stdin.readline().strip())
ans = sorted(dfsall(N))
for i in ans:
    print(i)
    
