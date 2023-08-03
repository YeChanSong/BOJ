import sys

X = [1,-1,0,0]
Y = [0,0,1,-1]

N,M,K = map(int,sys.stdin.readline().strip().split())
li = [list(map(int,sys.stdin.readline().split())) for i in range(N)]
sel = [[False for i in range(M)] for j in range(N)]

mxsm = -40000
def recur(y,acc,cnt):
    global mxsm
    if cnt == K:
        mxsm = max(mxsm,acc)
        return
    for i in range(y,N):
        for j in range(M):
            flag = False
            if sel[i][j]:
                continue
            for k in range(4):
                ny,nx = i+Y[k], j+X[k]
                if not (0<=ny<N and 0<=nx<M):
                    continue
                if sel[ny][nx]:
                    flag = True
                    break
            if flag:
                continue
            sel[i][j] = True
            recur(i,acc+li[i][j],cnt+1)
            sel[i][j] = False
            
recur(0,0,0)
print(mxsm)