import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
ans = -1000
idx = 0
tmp = 0
while 1:
    if idx == N:
        break
    tmp += li[idx]
    if tmp > ans:
        ans = tmp
    if tmp < 0:
        tmp = 0
    idx +=1
        
print(ans)