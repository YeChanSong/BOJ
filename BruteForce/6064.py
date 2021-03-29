import sys

T = int(sys.stdin.readline().strip())
for i in range(T):
    M,N,x,y = map(int,sys.stdin.readline().strip().split())
    if M>N:
        M,N = N,M
        x,y = y,x
    year = x
    start = [x,x]
    tmp = [x,x]
    end = [x,y]
    flag = False
    while 1:
        if tmp == end:
            break
        year += M
        tmp[1] += M
        if tmp[1] > N:
            tmp[1] -= N
        if tmp == start:
            flag = True
            break
    if flag:
        print(-1)
    else:
        print(year)