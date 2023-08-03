import sys, math

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
cnt = 0
for i in li:
    lim = int(math.sqrt(i))
    flag = True
    for j in range(2,lim+1):
        if i%j==0:
            flag = False
            break
    if flag and i != 1:
        cnt += 1
print(cnt)