import sys

n = int(sys.stdin.readline().strip())
coord = []
for i in range(n):
    coord.append(list(map(int,sys.stdin.readline().strip().split())))
coord = sorted(coord,key=lambda x: (x[0],x[1]))
for i in coord:
    print(i[0],i[1])