from sys import stdin, stdout


def main():
    n, q = [int(i) for i in stdin.readline().split()]
    array = [int(x) for x in stdin.readline().split()]
    sum_array = [array[0]]
    for i in range(1, n):
        sum_array.append(array[i] + sum_array[i-1])

    # Execute queries
    means = []
    for query in stdin.readlines():
        l, h = [int(i) for i in query.split()]
        m = (sum_array[h-1] - (sum_array[l-2] if l-2 >= 0 else 0)) // (h-l+1)
        means.append(str(m))
    stdout.write("\n".join(means))


if __name__ == '__main__':
    main()
