import sys

N = int(sys.stdin.readline().strip())
li = list()
for i in range(N):
    li.append(list(map(int,sys.stdin.readline().split())))
for i in range(N-2,-1,-1):
    for j in range(i,-1,-1):
        li[i][j] += max(li[i+1][j],li[i+1][j+1])
print(li[0][0])