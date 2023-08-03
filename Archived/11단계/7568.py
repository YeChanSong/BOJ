import sys

N = int(sys.stdin.readline().strip())
order = []
for i in range(N):
    data = list(map(int,sys.stdin.readline().strip().split()))
    data.append(i)
    order.append(data)

for i in range(len(order)):
    tmp = order[i]
    xcpt = order[:i] + order[i+1:]
    cnt = 1
    for j in xcpt:
        if tmp[0] < j[0] and tmp[1] < j[1]:
            cnt +=1
    order[i].append(cnt)

for i in order:
    print(i[3],end=' ')