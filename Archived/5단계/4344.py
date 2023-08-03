import sys
c = int(sys.stdin.readline().strip())
for i in range(c):
    li = list(map(int,sys.stdin.readline().strip().split()))
    avg = (sum(li)-li[0])/li[0]
    rtn = 0.0
    for j in li[1:]:
        if j > avg:
            rtn += 1
    print('%.3f%%'%(rtn/li[0]*100))
