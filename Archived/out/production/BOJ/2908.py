import sys

init = sys.stdin.readline().strip().split()
a = init[0][2] + init[0][1] + init[0][0]
b = init[1][2] + init[1][1] + init[1][0]

if int(a) > int(b):
    print(a)
else:
    print(b)
