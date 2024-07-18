import sys, collections

def bfs():
    global M, N, board, q, distance, dist, cnt0
    x = [1,-1,0,0]
    y = [0,0,1,-1]
    
    while len(q):
        itm = q.popleft()
        
        for i in range(4):
            if not (0 <= itm[0]+y[i] < N and 0 <= itm[1]+x[i] < M):
                continue
            elif distance[itm[0]+y[i]][itm[1]+x[i]] == -1 and board[itm[0]+y[i]][itm[1]+x[i]] != -1:
                q.append((itm[0]+y[i],itm[1]+x[i]))
                cnt0-=1
                distance[itm[0]+y[i]][itm[1]+x[i]] = distance[itm[0]][itm[1]] +1
                if dist < distance[itm[0]+y[i]][itm[1]+x[i]]:
                    dist = distance[itm[0]+y[i]][itm[1]+x[i]]

global M, N, board, q, distance, dist, cnt0
M,N = map(int,sys.stdin.readline().strip().split())
board = list()
cnt1 = 0
cnt_1 = 0
cnt0 = 0
dist = 0
q = collections.deque()
distance = list([-1 for i in range(M)] for j in range(N))
for i in range(N):
    tmp = list(map(int,sys.stdin.readline().strip().split()))
    board.append(tmp)
    for j in range(M):
        if tmp[j] == 1:
            q.append((i,j))
            distance[i][j] = 0
            cnt1 +=1
        elif tmp[j] == -1:
            cnt_1+=1
    
if M*N == cnt1+cnt_1:
    print(0)
else:
    cnt0 = M*N-(cnt1+cnt_1)
    bfs()
    if cnt0 == 0:
        print(dist)
    else:
        print(-1)