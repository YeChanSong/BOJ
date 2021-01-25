import sys
sys.setrecursionlimit(100000)
'''
a^p-1 = 1 (mod p)
a^p-2 = 1/a (mod p)
nCk = n!/k!(n-k)! = n!(k!(n-k)!)^1_000_000_005 (mod 1_000_000_007)
'''

def recur(n,idx):
    if idx == 0:
        return 1
    
    if idx %2 == 1:
        return (n * recur(n,idx-1)%1000000007) % 1000000007
    res = recur(n,idx//2) % 1000000007
    return (res * res) % 1000000007

N, K = map(int,sys.stdin.readline().strip().split())
nfac = 1
for i in range(1,N+1):
    nfac *= i
    nfac %= 1000000007
kfac = 1
for i in range(1,K+1):
    kfac *= i
    kfac %= 1000000007
n_kfac = 1
for i in range(1,N-K+1):
    n_kfac *= i
    n_kfac %= 1000000007
deno = (kfac * n_kfac)%1000000007
deno = recur(deno,1000000005)
ans = (nfac * deno)%1000000007
print(ans)