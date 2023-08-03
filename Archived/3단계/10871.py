import sys
N,X = map(int,sys.stdin.readline().strip().split())
li = list(map(int,sys.stdin.readline().strip().split()))
for i in li:
    if i < X:
        print(i,end=' ')
