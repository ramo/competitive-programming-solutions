"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/testing-strings-d1f28949/
"""
mod = 1000003
n, m, k = map(int, input().split())

# List of preprocessed (l,r) information of zth letter
wp = [[] for _ in range(m+1)]
for _ in range(n):
    l, r, z = map(int, input().split())
    # Adding a pair (1,z) to indicate that from lth index we 
    # need to take in consideration that the zth element not exist
    wp[l].append((1, z))
    # Adding a pair (-1, z) to indicate that the zth element can exist 
    # from r+1 index
    if r+1 <= m:
        wp[r+1].append((-1, z))

#count of possible letters. Intial value is 'k'
cnt = k
#control flags for increasing/decreasing the letter count
ctrl_val = [0] * (m+1)
# This is a special switch to handle overlapping ranges for 'z'th letter
ctrl_switch = [True] * (m+1)

ans = 1
# for each ith position of the 'm' length word
for i in range(1, m+1):
    # for each zth letter precomputed information of ith position
    for t in wp[i]:
        # Adding flag for zth letter available or not in the ith position
        ctrl_val[t[1]] += t[0]
        # If starting from this index, the zth letter is not available
        # reduce or increase the possible letters count.
        if ctrl_switch[t[1]] and ctrl_val[t[1]] == 1:
            cnt -= 1
            ctrl_switch[t[1]] = False
        elif (not ctrl_switch[t[1]]) and ctrl_val[t[1]] == 0:
            cnt += 1
            ctrl_switch[t[1]] = True
    ans = (ans * cnt) % mod

print(ans)
