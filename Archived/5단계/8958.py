import sys
n = int(sys.stdin.readline().strip())
for i in range(n):
    li = list(sys.stdin.readline().strip())
    cnt, tmp = 0, 0
    for j in li:
        if j == 'X':
            tmp = 0
        else:
            tmp += 1
        cnt += tmp
    print(cnt)
    
