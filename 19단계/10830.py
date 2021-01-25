import sys
sys.setrecursionlimit(10000)

def pow(idx):
    global elem, A
    if idx == 0:
        return elem
    
    if idx %2 == 1:
        return mul(A,pow(idx-1))
    tmp = pow(idx//2)
    return mul(tmp,tmp)
    

def mul(a,b):
    global N
    tmp = list([0 for i in range(N)] for j in range(N))
    for i in range(N):
        for j in range(N):
            ttmp = 0
            for k in range(N):
                ttmp += a[i][k] * b[k][j]
            tmp[i][j] = ttmp%1000
    return tmp

N,B = map(int,sys.stdin.readline().strip().split())
A = list()
for i in range(N):
    A.append(tuple(map(int,sys.stdin.readline().strip().split())))

elem = list([0 for i in range(N)] for j in range(N))
for i in range(N):
    elem[i][i] = 1

res = pow(B)
for i in range(N):
    print(' '.join(map(str,res[i])))