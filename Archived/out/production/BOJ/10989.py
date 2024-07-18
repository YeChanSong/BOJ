import sys

# 비둘기집의 원리를 이용, 리스트의 길이를 10000으로 제한해서 메모리를 줄임!

n = int(sys.stdin.readline().strip())
tmp = [0 for i in range(10000)]
for i in range(n):
    tmp[int(sys.stdin.readline().strip())-1] += 1
for i in range(len(tmp)):
    for j in range(tmp[i]):
        print(i+1)
