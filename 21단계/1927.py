import heapq, sys

N = int(sys.stdin.readline().strip())
hq = list()
for i in range(N):
    inst = int(sys.stdin.readline().strip())
    if inst == 0:
        if len(hq) == 0:
            print(0)
        else:
            print(heapq.heappop(hq))
    else:
        heapq.heappush(hq,inst)
