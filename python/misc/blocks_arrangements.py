import sys


def rec_blocks(i, b, n, mat):
    if b == n:
        process_mat(mat, n)
        return

    if i < n*n:
        mat[i] = 1
        rec_blocks(i+1, b+1, n, mat)
        mat[i] = 0
        rec_blocks(i+1, b, n, mat)


def convert_1d_to_2d(mat, n):
    mat2 = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            mat2[i][j] = mat[(i * n) + j]
    return mat2


def dfs(mat2, n, i, j, v):
    if 0 <= i < n and 0 <= j < n:
        if v[i][j] == 0 and mat2[i][j] == 1:
            v[i][j] = 1
            return max(1 + dfs(mat2, n, i+1, j, v), 1 + dfs(mat2, n, i, j+1, v), 1 + dfs(mat2, n, i+1, j+1, v),
                       1 + dfs(mat2, n, i+1, j-1, v))
    return 0


def is_connected(mat2, n):
    i, j = find_one(mat2, n)
    v = [[0] * n for _ in range(n)]
    c = dfs(mat2, n, i, j, v)
    return c == n


def find_one(mat2, n):
    for i in range(n):
        for j in range(n):
            if mat2[i][j] == 1:
                return i, j
    return -1, -1


def print_mat2(mat2, n):
    for i in range(n):
        print(mat2[i])
    print('===============================')


def process_mat(mat, n):
    mat2 = convert_1d_to_2d(mat, n)
    if is_connected(mat2, n):
        global connected_candidates
        connected_candidates.append(mat2)
        # print_mat2(mat2, n)


def rotate(mat2, n):
    matr = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            matr[i][j] = mat2[n-j-1][i]
    return matr


def mirror_vertical(mat2, n):
    matm = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            matm[i][j] = mat2[i][n-j-1]
    return matm


def mirror_horizontal(mat2, n):
    matm = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            matm[i][j] = mat2[n-i-1][j]
    return matm


def translate(mat2, n):
    r = []
    c = []
    matt = copy_mat(mat2, n)

    for i in range(n):
        for j in range(n):
            if matt[i][j] == 1:
                r.append(i)
                c.append(j)
    min_r, min_c = min(r), min(c)
    for i in range(n):
        for j in range(n):
            if matt[i][j] == 1:
                matt[i][j] = 0
                matt[i-min_r][j-min_c] = 1

    return matt


def get_pattern(mat2, n):
    p = []
    mat2 = translate(mat2, n)
    for i in range(n):
        for j in range(n):
            p.append(mat2[i][j])
    return '#'.join(map(str, p))


def copy_mat(mat2, n):
    matc = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            matc[i][j] = mat2[i][j]
    return matc


def filter_candidates(mat2, n, pattern_set, dist_candidates):
    # translate
    mat2 = translate(mat2, n)
    mat2_bkup = copy_mat(mat2, n)

    patterns = set()
    patterns.add(get_pattern(mat2, n))
    patterns.add(get_pattern(mirror_vertical(mat2, n), n))
    patterns.add(get_pattern(mirror_horizontal(mat2, n), n))

    # rotate 90
    mat2 = rotate(mat2, n)
    patterns.add(get_pattern(mat2, n))
    patterns.add(get_pattern(mirror_vertical(mat2, n), n))
    patterns.add(get_pattern(mirror_horizontal(mat2, n), n))

    # rotate 180
    mat2 = rotate(mat2, n)
    patterns.add(get_pattern(mat2, n))
    patterns.add(get_pattern(mirror_vertical(mat2, n), n))
    patterns.add(get_pattern(mirror_horizontal(mat2, n), n))

    # rotate 270
    mat2 = rotate(mat2, n)
    patterns.add(get_pattern(mat2, n))
    patterns.add(get_pattern(mirror_vertical(mat2, n), n))
    patterns.add(get_pattern(mirror_horizontal(mat2, n), n))

    already_there = False
    for p in patterns:
        if p not in pattern_set:
            pattern_set.add(p)
        else:
            already_there = True
            break

    if not already_there:
        dist_candidates.append(mat2_bkup)


connected_candidates = []


def print_blocks(mat2, n):
    for i in range(n):
        for j in range(n):
            sys.stdout.write('#' if mat2[i][j] == 1 else ' ')
        sys.stdout.write('\n')
    sys.stdout.write('\n')


def main():
    n = int(input('Please enter number of blocks: '))
    mat = [0] * (n * n)
    rec_blocks(0, 0, n, mat)

    # filter out the duplicates from connected components
    pattern_map = set()
    dist_candidates = []
    for cc in connected_candidates:
        filter_candidates(cc, n, pattern_map, dist_candidates)
    print('Total number of allowable arrangements are ', len(dist_candidates))
    print('The allowable arrangements are:\n')
    for dc in dist_candidates:
        print_blocks(dc, n)


if __name__ == '__main__':
    main()
