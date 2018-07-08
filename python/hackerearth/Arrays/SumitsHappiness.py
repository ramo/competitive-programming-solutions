from sys import stdin


def main():
    buff = stdin.read().splitlines()
    idx = 0
    t = int(buff[idx])
    idx += 1
    for _ in range(t):
        n = int(buff[idx])
        idx += 1
        a = [int(x) for x in buff[idx].split()]
        idx += 1
        p_sum = 0
        n_sum = 0
        pc = 0
        neg = []
        for i in range(n):
            if a[i] >= 0:
                p_sum += a[i]
                pc += 1
            else:
                n_sum += a[i]
                neg.append(a[i])

        if p_sum == 0:
            print(n_sum)
        else:
            max_sum = (p_sum * pc) + n_sum
            neg.sort(reverse=True)
            for nn in neg:
                p_sum += nn
                n_sum -= nn
                pc += 1
                temp_sum = p_sum * pc + n_sum
                max_sum = max(max_sum, temp_sum)
            print(max_sum)


if __name__ == '__main__':
    main()
