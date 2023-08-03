import sys

N = int(sys.stdin.readline().strip())
li = []
for i in range(N):
    li.append(tuple(map(int,sys.stdin.readline().strip().split())))
li = sorted(li,key= lambda x: (x[1],x[0]))
end = 0
cnt = 0
for i in li:
    if i[0] >= end:
        end = i[1]
        cnt += 1
print(cnt)