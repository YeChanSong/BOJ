import sys, collections

def buildGraph(N):
    global board
    for i in range(N):
        board.append(sys.stdin.readline().strip())

def bfs():
    global board, distance, N, M, dist
    q = collections.deque()
    q.append((0,0))
    q.append((N-1,M-1))
    distance[0][0] = 1
    distance[N-1][M-1] = -1
    adder = 0
    x=[1,-1,0,0]
    y=[0,0,1,-1]
    
    '''
    x,y배열과 for문을 사용하지 않고 4가지의 경우를 하나하나 조건문으로 쓸 경우
    py3 시간초과 pypy3 공간초과가 발생한다.
    bfs 양방향 탐색으로 변경해도 마찬가지.
    '''
    
    while len(q):
        itm = q.popleft()
        if distance[itm[0]][itm[1]] < 0:
            adder = -1
        else:
            adder = 1
        
        for i in range(4):
            if not(0<= itm[0]+y[i] < N and 0<= itm[1]+x[i] < M):
                continue
            else:
                if distance[itm[0]+y[i]][itm[1]+x[i]] == 0 and board[itm[0]+y[i]][itm[1]+x[i]] == '1':
                    q.append((itm[0]+y[i],itm[1]+x[i]))
                    distance[itm[0]+y[i]][itm[1]+x[i]] = distance[itm[0]][itm[1]] + adder
                if distance[itm[0]+y[i]][itm[1]+x[i]] * distance[itm[0]][itm[1]] <0:
                    dist = abs(distance[itm[0]+y[i]][itm[1]+x[i]]) + abs(distance[itm[0]][itm[1]])
                    return
                
        
global board, distance, N, M, dist
N,M = map(int,sys.stdin.readline().strip().split())
board = list()
distance = list([0 for i in range(M)] for j in range(N))
dist = 0
buildGraph(N)
bfs()
print(dist)
