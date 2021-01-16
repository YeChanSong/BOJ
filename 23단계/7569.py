#pypy3
import sys, collections

def bfs():
    global M,N,H,q, board, distance, dist, cnt0

    x = [1,-1,0,0,0,0]
    y = [0,0,1,-1,0,0]
    z = [0,0,0,0,1,-1]
    
    while len(q):
        itm = q.popleft()
        
        for i in range(6):
            if not (0<=itm[0]+z[i]<H and 0<=itm[1]+y[i]<N and 0<=itm[2]+x[i]<M):
                continue
            
            if distance[itm[0]+z[i]][itm[1]+y[i]][itm[2]+x[i]] == -1 and board[itm[0]+z[i]][itm[1]+y[i]][itm[2]+x[i]] == 0:
                q.append((itm[0]+z[i],itm[1]+y[i],itm[2]+x[i]))
                distance[itm[0]+z[i]][itm[1]+y[i]][itm[2]+x[i]] = distance[itm[0]][itm[1]][itm[2]] +1
                cnt0-=1
                if dist < distance[itm[0]+z[i]][itm[1]+y[i]][itm[2]+x[i]]:
                    dist = distance[itm[0]+z[i]][itm[1]+y[i]][itm[2]+x[i]]

global M,N,H,q, board, distance, dist, cnt0
M,N,H = map(int,sys.stdin.readline().strip().split())
board = list()
distance = list([[-1 for i in range(M)] for j in range(N)] for k in range(H))
dist = 0
cnt1 = 0
cnt0 = 0
cnt_1 = 0
q = collections.deque()
for i in range(H):
    board.append([])
    for j in range(N):
        tmp = list(map(int,sys.stdin.readline().strip().split()))
        board[i].append(tmp)
        for k in range(M):
            if tmp[k] == 1:
                cnt1+=1
                q.append((i,j,k))
                distance[i][j][k] = 0
            elif tmp[k] == -1:
                cnt_1+=1
            else:
                cnt0+=1
if M*N*H == cnt1+cnt_1:
    print(0)
else:
    bfs()
    if cnt0 != 0:
        print(-1)
    else:
        print(dist)