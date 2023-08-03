import sys, itertools

N,M = map(int,sys.stdin.readline().strip().split())
li = list(map(list,itertools.product([i for i in range(1,N+1)],repeat=M)))
for i in sorted(li):
    for j in i:
        print(j,end=' ')
    print()
