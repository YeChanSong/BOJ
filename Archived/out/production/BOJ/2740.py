import sys
sys.setrecursionlimit(10000)

def recur(y,x):
    global N,K,M,res,A,B
    tmp = 0
    for m in range(M):
        tmp += A[y][m] * B[m][x]

    res[y][x] = tmp

def builder():
    global res, N, K
    for n in range(N):
        for k in range(K):
            recur(n,k)

N,M = map(int,sys.stdin.readline().strip().split())
A = list()
for i in range(N):
    A.append(tuple(map(int,sys.stdin.readline().strip().split())))
M,K = map(int,sys.stdin.readline().strip().split())
B = list()
for i in range(M):
    B.append(tuple(map(int,sys.stdin.readline().strip().split())))
res = list([0 for i in range(K)] for j in range(N))
builder()
for i in range(N):
    print(' '.join(map(str,res[i])))