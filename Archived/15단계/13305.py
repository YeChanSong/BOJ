import sys
'''
현재 위치한 도시의 기름값보다 적은 도시를 만나기 전까지는 멈출 필요가 없다.
따라서, 현재 위치한 도시의 기름값보다 싼 도시를 만나기 전까지의 거리 * 현재 도시의 기름값을
멈추는 도시마다 계산해서 더하면 된다.
'''
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