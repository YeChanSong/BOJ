import sys

N, M = map(int,sys.stdin.readline().strip().split())
cards = list(map(int,sys.stdin.readline().strip().split()))

closest = -1
for i in range(N-2):
    a = cards[i]
    for j in range(i+1,N-1):
        b = cards[j]
        for k in range(j+1,N):
            c = cards[k]
            tmp = a + b + c
            if tmp <= M and tmp > closest:
                closest = tmp
print(closest)
