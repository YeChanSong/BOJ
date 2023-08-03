import sys

c = int(input())
for i in range(c):
    a,b = map(int,sys.stdin.readline().strip().split())
    print(a+b)
