import sys

L,C = map(int,sys.stdin.readline().split())
li = sorted(sys.stdin.readline().split())
vowel = ['a','e','i','o','u']
consonant = ['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z']
charset = dict(zip(consonant,[False for i in range(21)]))
for i in vowel:
    charset.setdefault(i,True)

def recur(cnt,vocnt,cocnt,idx,bef):
    if cnt == L:
        if vocnt <= 0 and cocnt <= 0:
            print(bef)
        return
    vtmp = vocnt;ctmp = cocnt
        
    for i in range(idx+1,C):
        tmp = bef+li[i]
        if charset[li[i]]:
            recur(cnt+1,vtmp-1,ctmp,i,tmp)
        else:
            recur(cnt+1,vtmp,ctmp-1,i,tmp)
recur(0,1,2,-1,'')
