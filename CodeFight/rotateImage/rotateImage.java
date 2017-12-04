int[][] rotateImage(int[][] a) {
    int[][] b = a;
    int size = b[0].length;
    int limit;
    if (size%2 == 0)
        limit = size + 1;
    else 
        limit = size;
    for (int j = 0; j < limit/2; j++) {
        System.out.println(j);
        for (int i = j; i < size-1-j; i++) {
            swap(b, j, i, i, size-1-j); //b[0][i], b[i][size-1]);
            swap(b, j, i, size-1-j, size-1-i); //b[0][i], b[size-1][size-1-i]);
            swap(b, j, i, size-1-i, j); //b[0][i], b[size-1][i]);
        }
    }
    return b;
}

static void swap(int[][] a, int i, int j, 
                 int k, int l) {
    int temp = a[k][l];
    a[k][l] = a[i][j];
    a[i][j] = temp;
}