import sys
a = int(sys.stdin.readline().strip())
li = sorted(list(map(int,sys.stdin.readline().strip().split())))
print(li[0],li[-1])
