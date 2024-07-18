import sys
aset = [[1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1]]

bset = [[0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0],
        [0,1,0,1,0,1,0,1],
        [1,0,1,0,1,0,1,0]]

N, M = map(int,sys.stdin.readline().strip().split())
start = [(j,i) for i in range(M-7)
               for j in range(N-7)]
board = []
for i in range(N):
    line = sys.stdin.readline().strip()
    line = line.replace('W','1')
    line = line.replace('B','0')
    line = list(map(int,line))
    board.append(line)

rst = []

for y,x in start:
    a = 0
    acnt = 0
    bcnt = 0
    for i in range(y,y+8):
        tmp = board[i][x:x+8]
        for j in range(len(tmp)):
            acnt += aset[a][j] ^ tmp[j]
            bcnt += bset[a][j] ^ tmp[j]
        a +=1
    rst.append(acnt)
    rst.append(bcnt)
print(min(rst))