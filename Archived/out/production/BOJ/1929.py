import sys, math

M,N = map(int,sys.stdin.readline().strip().split())
flag = True
for i in range(M,N+1):
    if i == 1:
        continue
    for j in range(2,math.floor(math.sqrt(i))+1):
        if i%j==0:
            flag = False
            break
    if flag == True:
        print(i)
    flag = True

