import sys

def possibleFinder(y,x):
    global board
    total = set([i for i in range(10)])
    hori = set()
    vert = set()
    for i in range(9):
        vert.add(board[i][x])
        hori.add(board[y][i])
    sqre = set()
    for k in range(y//3*3,y//3*3+3):
        for l in range(x//3*3,x//3*3+3):
            sqre.add(board[k][l])
    hori = total - hori
    vert = total - vert
    sqre = total - sqre
    pssbl = set.intersection(hori,vert,sqre)
    
    return pssbl

def dfs(idx):
    global board, adj
    
    if idx == len(adj):
        return True
    
    y,x = adj[idx]
    pssbl = possibleFinder(y,x)
    
    for i in pssbl:
        board[y][x] = i
        if dfs(idx+1):
            return True
        # 각 재귀를 수행하면서 가능한 숫자를 판단할 때 possibleFinder를 수행하므로
        # 0으로 초기화 해줘야 재귀가 끝나고 돌아갈 때 다른 재귀에서 올바른 숫자를 뽑을 수 있다.
        board[y][x] = 0
    return False
    
    
board = []
adj = []

for i in range(9):
    board.append(list(map(int,sys.stdin.readline().strip().split())))
    for j in range(9):
        if board[i][j] != 0:
            continue
        adj.append((i,j))

dfs(0)
for i in range(9):
    print(*board[i])