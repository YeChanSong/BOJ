import sys

def greedy():
    global N, payment, oil
    total = 0
    idx = 0
    while True:
        if idx == N-1:
            break
        cnt = 0
        for i in range(idx+1,N):
            cnt+=1
            if oil[idx] > oil[i]:
                break
        dist = 0
        for i in range(idx,idx+cnt):
            dist += payment[i]
        cost = oil[idx] * dist
        total += cost
        idx += cnt
    return total

global N, payment, oil
N = int(sys.stdin.readline().strip())
payment = list(map(int,sys.stdin.readline().strip().split()))
oil = list(map(int,sys.stdin.readline().strip().split()))
ans = greedy()
print(ans)