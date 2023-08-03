import sys

virt = 1
hori = 1
cnt = 0
vm = 2
hm = 4
x = int(sys.stdin.readline().strip())
while 1:
    if virt <= x <= hori or hori <= x <= virt:
        break
    if cnt %2 == 0:
        virt += vm
        vm += 4
        hori += 1
    else:
        virt += 1
        hori += hm
        hm += 4
    cnt += 1
up, dn = cnt+1, 1
if virt >= hori:
    tmp = virt - x
    up -= tmp
    dn += tmp
else:
    tmp = x - virt
    up -= tmp
    dn += tmp
print(str(up)+'/'+str(dn))
    
