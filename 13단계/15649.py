import sys, itertools

N,M = map(int,sys.stdin.readline().strip().split())
li = list(map(list,itertools.permutations([i for i in range(1,N+1)],M)))
for i in li:
    for j in i:
        print(j,end=' ')
    print()
