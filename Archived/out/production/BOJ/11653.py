import sys, math
tmp = int(sys.stdin.readline().strip())
for i in range(2,tmp+1):
    
    while 1:
        if tmp%i != 0:
            break
        tmp//=i
        print(i)
