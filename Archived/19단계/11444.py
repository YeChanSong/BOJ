import sys

'''
F(n)   = (1 1) ^ n-1 (F(1))
F(n-1) = (1 0)       (F(0))
'''

def pow(idx):
    global a
    if idx == 0:
        return [[1,0],[0,1]]
    
    if idx%2 == 1:
        return mul(a,pow(idx-1))
    tmp = pow(idx//2)
    return mul(tmp,tmp)
    
def mul(a,b):
    tmp = [[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            ttmp = 0
            for k in range(2):
                ttmp += a[i][k] * b[k][j]
            tmp[i][j] = ttmp%1000000007
    return tmp

n = int(sys.stdin.readline().strip())
a =[[1,1],[1,0]]
npow = pow(n-1)
ans = npow[0][0]%1000000007
print(ans)