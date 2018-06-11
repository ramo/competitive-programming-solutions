lookup = {'G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'}
input_str = input()
result = []
flag = False
for c in input_str:
    l = lookup.get(c)
    if not l:
        flag = True
        break
    else:
        result.append(l)

if not flag:
    print("".join(result))
else:
    print('Invalid input')



