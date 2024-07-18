import sys
sys.setrecursionlimit(100000)
def recur(y,x,ylim,xlim):
    global N,li, white, blue
    flag = li[y][x]
    
    for i in range(y,y+ylim):
        for j in range(x,x+xlim):
            if li[i][j] != flag:
                recur(y,x,ylim//2,xlim//2)
                recur(y,x+xlim//2,ylim//2,xlim//2) 
                recur(y+ylim//2,x,ylim//2,xlim//2) 
                recur(y+ylim//2,x+xlim//2,ylim//2,xlim//2)
                return
    if flag == 0:
        white+=1
    else:
        blue+=1

white = 0
blue = 0
N = int(sys.stdin.readline().strip())
li = list()
for i in range(N):
    li.append(list(map(int,sys.stdin.readline().strip().split())))
recur(0,0,N,N)
print(white)
print(blue)