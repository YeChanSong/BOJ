import sys

N,L = map(int,sys.stdin.readline().split())
board = list()
for i in range(N):
    board.append(list(map(int,sys.stdin.readline().split())))
cache = list([False for i in range(N)] for j in range(N))
ttl = 0
for i in range(N):
    curr = board[i][0]; flag = True
    hist = list(); j=1
    while j < N:
        if board[i][j] > curr+1 or board[i][j] < curr -1:
            # 높이 차이가 1 이상인 경우
            flag = False
            break
        if board[i][j] == curr +1:
            # 다음 칸이 1 높은 경우
            for k in range(1,L+1):
                if j-k<0:
                    flag = False
                    break
                if cache[i][j-k] == False:
                    cache[i][j-k] = True
                    hist.append(j-k)
                else:
                    # 이미 경사로가 놓인 경우
                    flag = False
                    break
            if not flag:
                break
            curr = board[i][j]
            j+=1
        elif board[i][j] == curr -1:
            for k in range(L):
                if j+k>=N:
                    # 지도를 벗어나는 경우
                    flag = False
                    break
                if (board[i][j] != board[i][j+k] or cache[i][j+k] == True):
                    # 칸이 일정한 높이를 갖지 않거나, 이미 경사로가 놓인 경우
                    flag = False
                    break
                else:
                    cache[i][j+k] = True
                    hist.append(j+k)
            if not flag:
                break
            curr = board[i][j]
            j+=L-1
        else:
            curr = board[i][j]
            j+=1
    
    if flag:
        ttl += 1
    else:
        for k in hist:
            cache[i][k] = False

cache = list([False for i in range(N)] for j in range(N))
for i in range(N):
    curr = board[0][i]; flag = True
    hist = list(); j=1
    while j < N:
        if board[j][i] > curr+1 or board[j][i] < curr -1:
            # 높이 차이가 1 이상인 경우
            flag = False
            break
        if board[j][i] == curr +1:
            # 다음 칸이 1 높은 경우
            for k in range(1,L+1):
                if j-k<0:
                    flag = False
                    break
                if cache[j-k][i] == False:
                    cache[j-k][i] = True
                    hist.append(j-k)
                else:
                    # 이미 경사로가 놓인 경우
                    flag = False
                    break
            if not flag:
                break
            curr = board[j][i]
            j+=1
        elif board[j][i] == curr -1:
            for k in range(L):
                if j+k>=N:
                    # 지도를 벗어나는 경우
                    flag = False
                    break
                if (board[j][i] != board[j+k][i] or cache[j+k][i] == True):
                    # 칸이 일정한 높이를 갖지 않거나, 이미 경사로가 놓인 경우
                    flag = False
                    break
                else:
                    cache[j+k][i] = True
                    hist.append(j+k)
            if not flag:
                break
            curr = board[j][i]
            j+=L-1
        else:
            curr = board[j][i]
            j+=1
    
    if flag:
        ttl += 1
    else:
        for k in hist:
            cache[k][i] = False

print(ttl)