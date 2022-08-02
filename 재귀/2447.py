import sys
sys.setrecursionlimit(10000000)

def recur(n,emp,y,x):
    global board
    if n == 1:
        if emp == True:
            board[y][x] = ' '
            return
        else:
            board[y][x] = '*'
            return
    else:
        for i in range(3):
            recur(n//3,emp,y,x+(n//3)*i)
        recur(n//3,emp,y+(n//3),x)
        recur(n//3,True,y+(n//3),x+(n//3))
        recur(n//3,emp,y+(n//3),x+(n//3)*2)
        for i in range(3):
            recur(n//3,emp,y+(n//3)*2,x+(n//3)*i)
    

n = int(sys.stdin.readline().strip())
board = [[None for j in range(n)] for i in range(n)]
recur(n,False,0,0)
for i in range(n):
    print(''.join(board[i]))
