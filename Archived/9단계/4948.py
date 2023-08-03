#pypy3

import sys, math

def Bertrand(n):
    nn = n*2
    flag = True
    cnt = 0
    for i in range(n+1,nn+1):
        if i == 1:
            continue
        for j in range(2,math.floor(math.sqrt(i))+1):
            if i%j==0:
                flag = False
                break
        if flag == True:
            cnt +=1
        flag = True
    print(cnt)

while 1:
    n = int(sys.stdin.readline().strip())
    if n == 0:
        break
    Bertrand(n)

