import sys

n = int(sys.stdin.readline().strip())
tmp = []
for i in range(n):
    tmp.append(int(sys.stdin.readline().strip()))
for i in sorted(tmp):
    print(i)